package com.smurr.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class hash {	

	/**
	 * Generate a random salt
	 * 
	 * @return String of hex salt value
	 * @throws NoSuchAlgorithmException
	 *             If the hashing algorithm is not found
	 */
	public String generateSalt() throws NoSuchAlgorithmException {
		SecureRandom rand = new SecureRandom();
		byte[] byteValue = new byte[20];

		// generate random byte
		rand.nextBytes(byteValue);

		return createHash(byteValue.toString());
	}

	/**
	 * Method to create a hash with a salt
	 * 
	 * @param variableToHash
	 *            The variable you want to hash
	 * @param salt
	 *            The salt you want to apply to the hash
	 * @return The hex value of salted hash
	 * @throws NoSuchAlgorithmException
	 *             if unable to find hashing algorithm
	 */
	public String createHash(String variableToHash, String salt)
			throws NoSuchAlgorithmException {
		return createHash(variableToHash + salt);
	}

	/**
	 * Create a hex hash based on sha-256 based on the passed in string
	 * 
	 * @param variableToHash
	 *            string value to hash
	 * @return The hex value of the hashed string
	 * @throws NoSuchAlgorithmException
	 *             If unable to find hashing algorithm
	 */
	public String createHash(String variableToHash)
			throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(variableToHash.getBytes());

		return byteToHex(digest.digest());

	}

	/**
	 * Converts a byte array input into hex
	 * 
	 * @param convertValue
	 *            byte value to convert into hex
	 * @return String hex value of the byte
	 */
	private String byteToHex(byte[] convertValue) {
		StringBuilder hexString = new StringBuilder();

		for (int i = 0; i < convertValue.length; i++) {
			String hex = Integer.toHexString(0xff & convertValue[i]);

			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();

	}

}
