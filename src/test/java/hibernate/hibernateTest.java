package hibernate;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.model.UserAccount;

public class hibernateTest {

	@Test
	public void test() {
		
		AccountDAO test = new AccountDAOImpl();
		
		UserAccount account = test.getAccountByName("test");
		
		assertTrue("got the right account?", account.getUser_id().equals(1));		
	}

}
