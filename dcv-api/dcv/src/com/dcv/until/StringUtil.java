package com.dcv.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**	
	 * String pattern
	 */
	private static Pattern pattern;
	
	/**
	 * Regex matcher
	 */
	private static Matcher matcher;

	/**
	 * Email pattern
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * 
	 */
	private static String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabsdefghijklmnopqrstuvwxyz";
	
	/**
	 * 
	 */
	private static Random random = new Random();

	/**
	 * Get login
	 * @param accessToken
	 * @return
	 */
	public static Integer getLoginID(String accessToken) {
		return Integer.valueOf(Base64Utils.decode(accessToken.substring(0, accessToken.length()	- DcvContanst.LENGTHACCESSTOKEN)));
	}

	/**
	 * Get log in ID encode
	 * @param accessToken
	 * @return
	 */
	public static String getLoginIDEncode(String accessToken) {
		return accessToken.substring(0, accessToken.length() - DcvContanst.LENGTHACCESSTOKEN);
	}

	/**
	 * Get id of forgot password user
	 * @param accessToken
	 * @return {@link Integer}
	 */
//	public static Integer getLoginIDFG(String accessToken) {
//		return Integer.valueOf(Base64Utils.decode(accessToken.substring(0 + JioConstant.FORGOT_PREFIX.length(), accessToken.length() - DcvContanst.LENGTHACCESSTOKEN)));
//	}

	/**
	 * Format date
	 * @param date
	 * @param pattern
	 * @return {@link Integer}
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date).toString();
	}

	/**
	 * Convert MMDDYY to YYMMDD 
	 * @param date
	 * @param expression
	 * @return
	 */
	public static String convert_MDY_To_YMD(String date, String expression) {
		// Convert Month-Day-Year to Year-Month-Day
		String[] arr = date.split(expression);
		return arr[2] + expression + arr[0] + expression + arr[1];
	}

	/**
	 * Check if string is empty or null
	 * @param constant
	 * @return true if it is empty and vice versa
	 */
	public static boolean isEmpty(String constant) {
		if ((constant == null) || ("".equals(constant.trim()))) {
			return true;
		}
		return false;
	}

	/**
	 * Check if a string is not empty
	 * @param constant
	 * @return true if it is not empty and vice versa
	 */
	public static boolean isNotEmpty(String constant) {
		if (isEmpty(constant)) {
			return false;
		}
		return true;
	}


	/**
	 * generate string consists of random characters.
	 * 
	 * @param length
	 *            length of generated string
	 * @return string
	 */
	public static String randomString(int length) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < length; i++) {
			b.append(base.charAt(random.nextInt(base.length())));
		}
		return b.toString();
	}


}
