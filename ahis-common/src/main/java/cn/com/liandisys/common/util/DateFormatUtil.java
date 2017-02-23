package cn.com.liandisys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	/** yyyy年MM月dd日 */
	private static final String CHIYMD = "yyyy年MM月dd日";

	/** yyyy年M月d日 */
	private static final String CHIYMDSIMPLE = "yyyy年M月d日";

	/** yyyy-MM-dd */
	private static final String BARYMD = "yyyy-MM-dd";

	/** yyyy-M-d */
	private static final String BARYMDSIMPLE = "yyyy-M-d";

	/** yyyyMMddHHmmss */
	private static final String YMDHMS = "yyyyMMddHHmmss";

	/** yyyyMMddHHmmssSSS */
	private static final String YMDHMSF = "yyyyMMddHHmmssSSS";

	/** yyyy年M月d日 星期× */
	private static final String CHIYMDWEEKDAY = "yyyy年M月d日 EEEE";

	/** yyyy年M月d日 × （×为星期简写，如：日、 一、二、三） */
	private static final String CHIYMDWEEKDAYSIMPLE = "yyyy年M月d日 E";

	/**
	 * Date型 转换为 'yyyy年MM月dd日' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy年MM月dd日
	 */
	public static String formatDateToChiYmd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMD);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyy年M月d日' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy年M月d日
	 */
	public static String formatDateToChiYmdS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMDSIMPLE);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyy年M月d日 星期×' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy年M月d日 星期×
	 */
	public static String formatDateToChiYmdWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMDWEEKDAY);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyy年M月d日 ×' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy年M月d日 × （×为星期简写）
	 */
	public static String formatDateToChiYmdWeekS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMDWEEKDAYSIMPLE);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyy-MM-dd' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy-MM-dd
	 */
	public static String formatDateToBarYmd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(BARYMD);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyy-M-d' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyy-M-d
	 */
	public static String formatDateToBarYmdS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(BARYMDSIMPLE);
		return sdf.format(date);
	}

	/**
	 * Date型 转换为 'yyyyMMddHHmmss' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyyMMddHHmmss
	 */
	public static String formatDateToYmdhms(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS);
		return formatter.format(date);
	}

	/**
	 * Date型 转换为 'yyyyMMddHHmmssSSS' 字符串。
	 * 
	 * @param date
	 *            日期
	 * @return yyyyMMddHHmmssSSS
	 */
	public static String formatDateToYmdhmsf(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMSF);
		return formatter.format(date);
	}

	/**
	 * yyyy年MM月dd日 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyy年MM月dd日 日期格式Str
	 * @return Date
	 */
	public static Date convertChiYmdToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMD);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyy年M月d日 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyy年M月d日 日期格式Str
	 * @return Date
	 */
	public static Date convertChiYmdSToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(CHIYMDSIMPLE);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyy-MM-dd 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd 日期格式Str
	 * @return Date
	 */
	public static Date convertBarYmdToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(BARYMD);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyy-M-d 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyy-M-d 日期格式Str
	 * @return Date
	 */
	public static Date convertBarYmdSToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(BARYMDSIMPLE);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyyMMddHHmmss 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyyMMddHHmmss 日期格式Str
	 * @return Date
	 */
	public static Date convertYmdhmsToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(YMDHMS);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyyMMddHHmmssSSS 格式字符串 转换为 Date类型。
	 * 
	 * @param dateStr
	 *            yyyyMMddHHmmssSSS 日期格式Str
	 * @return Date
	 */
	public static Date convertYmdhmsfToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(YMDHMSF);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
