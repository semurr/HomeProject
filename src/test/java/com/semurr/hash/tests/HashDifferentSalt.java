package com.semurr.hash.tests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.junit.Test;

import com.smurr.hash.Hash;

public class HashDifferentSalt {

	@Test
	public void differentSaltEquals() throws NoSuchAlgorithmException {
		byte[] test = Hash.generateSalt();
		byte[] test2 = Hash.generateSalt();

		byte[] hashResult1 = Hash.createHash("password".getBytes(), test);
		byte[] hashResult2 = Hash.createHash("password".getBytes(), test2);

		assertFalse("Same password with different salt does not have same hash",
				Arrays.equals(hashResult1, hashResult2));

	}

}
