package cn.com.liandisys.ahis.webapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 平台订单号生成工具类
 * （平台用于唯一标识一笔订单的流水号）
 *
 */
public class MakeOrdNumUtil {

    /** 锁对象，可以为任意对象 */
    private static Object lockObj = "lockerOrder";

    /** 时间格式，精确到毫秒 */
    private static final String YYMMDDHHMMSS_SSS = "yyMMddHHmmssSSS";

    /** 订单号生成计数器 */
    private static long orderNumCount = 0L;

    /** 每毫秒生成订单号数量最大值 */
    private static int maxPerMSECSize = 100;

    public static String create() {
        return create(1);
    }

    /** 
     * 生成非重复订单号，理论上限1毫秒100个，可扩展 
     * @param type 订单类型 （1：挂号，2：住院押金，3：门诊）
     * @return 生成的平台订单号
     */  
    public static String create(int type) {

        // 最终生成的订单号  
        String psOrdNum = "";
        synchronized (lockObj) {
            // 取系统当前时间作为订单号变量前半部分，精确到毫秒  
            long nowLong = Long.parseLong(new SimpleDateFormat(YYMMDDHHMMSS_SSS).format(new Date()));
            // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值100个，1秒10万
            if (orderNumCount > maxPerMSECSize) {
                orderNumCount = 0L;
            }
            // 组装订单号 
            String countStr = String.valueOf(maxPerMSECSize + orderNumCount).substring(1);
            psOrdNum = String.valueOf(type) + nowLong + countStr;
            orderNumCount++;
            //System.out.println(psOrdNum);
        }
        return psOrdNum;
    }

    
}
