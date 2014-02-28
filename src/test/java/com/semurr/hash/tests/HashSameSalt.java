package com.semurr.hash.tests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.junit.Test;

import com.smurr.hash.Hash;

public class HashSameSalt {

	@Test
	public void SameSaltCompare() throws NoSuchAlgorithmException {
		byte[] test = Hash.generateSalt();

		byte[] hashResult1 = Hash.createHash("password".getBytes(), test);
		byte[] hashResult2 = Hash.createHash("password".getBytes(), test);

		assertTrue("Same password with same salt has same hash",
				Arrays.equals(hashResult1, hashResult2));
	}

}
