package cn.com.liandisys.ahis.webapp.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* AES128 算法
*
* CBC 模式
* PKCS7Padding 填充模式
* CBC模式需要添加一个参数iv
*
* 介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding 没有什么区别
* 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
*/
public class AESUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);

	private static ResourceBundle bundle = ResourceBundle.getBundle("ahis_aes");
	// AES的长是128bit（16byte）
	public static String COMMON_AES_SALT = bundle.getString("common.aes.salt");
	// CBC用IV
	private static String COMMON_AES_IV = bundle.getString("common.aes.iv");

	// 算法名称
	private static final String KEY_ALGORITHM = "AES";
	// 加解密算法/模式/填充方式
	private static final String algorithmStr = "AES/CBC/PKCS7Padding";
	//
	private static Key key;
	private static Cipher cipher;
	boolean isInited = false;

	//private static byte[] iv = { 0x30, 0x31, 0x30, 0x32, 0x30, 0x33, 0x30, 0x34, 0x30, 0x35, 0x30, 0x36, 0x30, 0x37, 0x30, 0x38 };
	private static byte[] iv = COMMON_AES_IV.getBytes();

	public static void init(byte[] keyBytes) {

		// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
		int base = 16;
		if (keyBytes.length % base != 0) {
			int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
			keyBytes = temp;
		}
		// 初始化
		Security.addProvider(new BouncyCastleProvider());
		// 转化成JAVA的密钥格式
		key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
		try {
			// 初始化cipher
			cipher = Cipher.getInstance(algorithmStr, "BC");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密方法
	 *
	 * @param content 要加密的字符串
	 * @return
	 */
	public static String encrypt(String content) {
		// 加密
		byte[] keybytes = AESUtil.COMMON_AES_SALT.getBytes();
		byte[] resultbytes = AESUtil.encrypt(content.getBytes(), keybytes);
		return new String(Hex.encode(resultbytes));
	}

	/**
	 * 解密方法
	 *
	 * @param encryptedData 要解密的字符串
	 * @return
	 */
	public static String decrypt(String encryptedData) {
		// 解密
		byte[] keybytes = AESUtil.COMMON_AES_SALT.getBytes();
		byte[] resultbytes = AESUtil.decrypt(Hex.decode(encryptedData.getBytes()), keybytes);
		return new String(resultbytes);
	}

	/**
	 * 加密方法
	 *
	 * @param content
	 *            要加密的字符串
	 * @param keyBytes
	 *            加密密钥
	 * @return
	 */
	private static byte[] encrypt(byte[] content, byte[] keyBytes) {
		byte[] encryptedText = null;
		init(keyBytes);
		//System.out.println("IV：" + new String(iv));
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
			encryptedText = cipher.doFinal(content);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return encryptedText;
	}

	/**
	 * 解密方法
	 *
	 * @param encryptedData
	 *            要解密的字符串
	 * @param keyBytes
	 *            解密密钥
	 * @return
	 */
	private static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) {
		byte[] encryptedText = null;
		init(keyBytes);
		//System.out.println("IV：" + new String(iv));
		try {
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			encryptedText = cipher.doFinal(encryptedData);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return encryptedText;
	}
}