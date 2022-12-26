package com.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

@Component
public class HashAndSaltGenerator {

	public String[] getHexAndSaltStrings(String password) throws Exception {

		// Generate a salt using SecureRandomF
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);

		// Use PBKDF2 with SHA-256 to derive a key from the password
		char[] passwordChars = password.toCharArray();
		PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, 10000, 256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();

		// Convert the salt and hash to hexadecimal strings
		String saltString = toHexString(salt);
        String hashString = toHexString(hash);
        return new String[]{saltString,hashString};

	}

	public static String toHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

}
