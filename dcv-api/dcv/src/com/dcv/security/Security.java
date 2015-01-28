package com.dcv.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

	public static String encrypSHA256(String pw){
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
		        byte byteData[] = md.digest();
		        
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < byteData.length; i++) {
		        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
