package cn.com.liandisys.ahis.webapp.captcha;

import java.util.Random;

import nl.captcha.text.producer.TextProducer;

public class AhisCaptchaProducer implements TextProducer {

	private static final char[] CALCULATE_OPERATION_CHARS = new char[] { '+', '-', '×', '÷' };
	
	@Override
	public String getText() {
		StringBuilder sb = new StringBuilder();
		int fstNum = new Random().nextInt(10);
		sb.append(String.valueOf(fstNum));
		char fstOperator = CALCULATE_OPERATION_CHARS[new Random().nextInt(3)];
		sb.append(String.valueOf(fstOperator));
		int secNum = new Random().nextInt(10);
		sb.append(String.valueOf(secNum));
		char secOperator = CALCULATE_OPERATION_CHARS[new Random().nextInt(3)];
		sb.append(String.valueOf(secOperator));
		int thrNum = new Random().nextInt(10);
		sb.append(String.valueOf(thrNum));
		return sb.toString();
	}

}
