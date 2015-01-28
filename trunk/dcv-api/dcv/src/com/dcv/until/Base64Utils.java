package com.dcv.until;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	/**
	 * Decode a string using Base64
	 * @param java.util.String
	 * @return java.util.String
	 */
	public static final String decode(String string) {
		if (string != null) {
			return new String(Base64.decodeBase64(string));
		} else {
			return null;
		}

	}
	
	/**
	 * Encode a string using Base64
	 * @param java.util.String
	 * @return java.util.String
	 */
	public static final String encode(String string) {
		if (string != null) {
			return new String(Base64.encodeBase64(string.getBytes()));
		} else {
			return null;
		}

	}
}
