package cn.com.liandisys.ahis.payment.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResourceLoader;

public class SigUtils {

    private static Logger logger = LoggerFactory.getLogger(SigUtils.class);

    private SigUtils() {
    }

    public static String signMessageWithCert(String reqdata, String certfilePath, String certpwd) {
        String tSignedBase64 = "";
        Signature tSignature = null;
        try {
            tSignature = Signature.getInstance("SHA1withRSA");
            tSignature.initSign(getMerchantKey(certfilePath, certpwd));
            tSignature.update(reqdata.toString().getBytes("UTF-8"));
            byte[] tSigned = tSignature.sign();
            tSignedBase64 = new String(Base64.encodeBase64((tSigned)));
        } catch (NoSuchAlgorithmException e) {
            logger.error("签名失败。", e);
        } catch (InvalidKeyException e) {
            logger.error("签名失败。", e);
        } catch (Exception e) {
            logger.error("签名失败。", e);
        }
        return new String(tSignedBase64);
    }

    public static boolean verifySignWithCert(String reqdata, String signmsg, String certfile) {
        byte[] tSign = Base64.decodeBase64(signmsg);
        try {
            Signature tSignature = Signature.getInstance("SHA1withRSA");
            tSignature.initVerify(getTrustCertificate(certfile));
            tSignature.update(reqdata.toString().getBytes("UTF-8"));
            if (tSignature.verify(tSign)) {
                return true;
            } else {
                logger.info("响应报文签名验证失败");
            }
        } catch (Exception e) {
            logger.error("响应报文签名验证失败 - " + e.getMessage(), e);
        }
        return false;
    }

    public static String cryptMD5(String str) {
        if (str == null || str.length() == 0) {
        }
        StringBuffer hexString = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            byte[] hash = md.digest();

            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5加密失败。", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5加密失败。", e);
        }
        return hexString.toString();
    }

    private static PrivateKey getMerchantKey(String certfile, String certpwd) throws Exception {
        KeyStore tKeyStore = null;
        InputStream tIn = null;
        String tMerchantCertFile = certfile;
        String tMerchantCertPassword = certpwd;
        try {
            tIn = new FileSystemResourceLoader().getResource(tMerchantCertFile).getInputStream();
            tKeyStore = KeyStore.getInstance("PKCS12", new com.sun.net.ssl.internal.ssl.Provider().getName());
            tKeyStore.load(tIn, tMerchantCertPassword.toCharArray());
        } catch (Exception e) {
            logger.error("无法读取证书文档[" + tMerchantCertFile + "]！", e);
        } finally {
            if (tIn != null) {
                try {
                    tIn.close();
                } catch (Exception localException1) {
                }
            }
        }
        String tAliases = "";
        try {
            Enumeration e = tKeyStore.aliases();
            if (e.hasMoreElements()) {
                tAliases = (String) e.nextElement();
            }
        } catch (Exception e) {
            logger.error("证书格式错误，无法对证书进行编码！", e);
        }

        PrivateKey iMerchantKey = null;
        try {
            iMerchantKey = (PrivateKey) tKeyStore.getKey(tAliases, tMerchantCertPassword.toCharArray());
        } catch (Exception e) {
            logger.error("无法读取商户私钥，无法生成私钥证书对象！", e);
        }
        return iMerchantKey;
    }

    private static Certificate getTrustCertificate(String tCertFile) throws Exception {
        Certificate tCertificate = null;
        byte[] tCertBytes = new byte[4096];
        int tCertBytesLen = 0;
        InputStream tIn = null;
        try {
            tIn = new FileSystemResourceLoader().getResource(tCertFile).getInputStream();
            tCertBytesLen = tIn.read(tCertBytes);
        } catch (Exception e) {
            logger.error("无法读取证书文档[" + tCertFile + "]！", e);
        } finally {
            try {
                tIn.close();
            } catch (Exception localException1) {
            }
        }
        byte[] tFinalCertBytes = new byte[tCertBytesLen];
        for (int i = 0; i < tCertBytesLen; ++i) {
            tFinalCertBytes[i] = tCertBytes[i];
        }

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        try {
            CertificateFactory tCertificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream bais = new ByteArrayInputStream(tFinalCertBytes);

            if (bais.available() > 0) {
                tCertificate = tCertificateFactory.generateCertificate(bais);
            }
        } catch (Exception e) {
            logger.error("证书格式错误 - 无法由[" + tCertFile + "]生成X.509证书对象！", e);
        }
        return tCertificate;
    }
}
