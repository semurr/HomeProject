package com.semurr.hash.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HashSameSalt.class, HashDifferentSalt.class })
public class HashSuites {

}
