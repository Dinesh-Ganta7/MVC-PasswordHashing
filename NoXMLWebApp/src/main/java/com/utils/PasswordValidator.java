package com.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

	

	public boolean validatePassword(String storedSalt, String storedHash, String password) throws Exception {

		// Convert the stored salt and password to byte arrays
		byte[] salt = fromHexString(storedSalt);
		char[] passwordChars = password.toCharArray();

		// Use PBKDF2 with SHA-256 to derive a key from the password and salt
		PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, 10000, 256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] derivedKey = skf.generateSecret(spec).getEncoded();

		// Convert the derived key to a hexadecimal string
		String derivedKeyString = toHexString(derivedKey);

		// Compare the calculated hash to the stored hash
		if (derivedKeyString.equals(storedHash)) {
			return true;
		} else {
			return false;
		}
	}

	public static byte[] fromHexString(String hexString) {
		int len = hexString.length();
		byte[] bytes = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
					+ Character.digit(hexString.charAt(i + 1), 16));
		}
		return bytes;
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
