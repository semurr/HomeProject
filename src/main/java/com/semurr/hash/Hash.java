package com.semurr.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author stephen
 * 
 *         Utility class to create a hash based on sha 256
 * 
 */
public class Hash {

	/**
	 * Generate a random salt
	 * 
	 * @return random byte[] for salt
	 * @throws NoSuchAlgorithmException
	 *             If the hashing algorithm is not found
	 */
	public static byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom rand = new SecureRandom();
		byte[] byteValue = new byte[8];

		// generate random byte
		rand.nextBytes(byteValue);

		return byteValue;
	}

	/**
	 * Method to create a hash with a salt
	 * 
	 * @param variableToHash
	 *            The variable you want to hash
	 * @param salt
	 *            The salt you want to apply to the hash
	 * @return The byte[] of the variable and salt hashed
	 * @throws NoSuchAlgorithmException
	 *             if unable to find hashing algorithm
	 */
	public static String createHash(byte[] variableToHash, byte[] salt)
			throws NoSuchAlgorithmException {
		byte[] concatResult = new byte[variableToHash.length + salt.length];

		System.arraycopy(variableToHash, 0, concatResult, 0,
				variableToHash.length);
		System.arraycopy(salt, 0, concatResult, variableToHash.length,
				salt.length);

		return createHash(concatResult);
	}

	/**
	 * Create a hex hash based on sha-256 based on the passed in string
	 * 
	 * @param variableToHash
	 *            Variable you want to hash
	 * @return The byte[] of the hashed string
	 * @throws NoSuchAlgorithmException
	 *             If unable to find hashing algorithm
	 */
	public static String createHash(byte[] variableToHash)
			throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(variableToHash);

		return byteToHex(digest.digest());

	}

	public static String byteToHex(byte[] stringToModify) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < stringToModify.length; i++) {
			String hex = Integer.toHexString(0xff & stringToModify[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
