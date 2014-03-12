package com.semurr.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.model.UserAccount;
import com.smurr.hash.Hash;

@Controller
public class AccountController {
	
	AccountDAO accountDAO;
	
	@RequestMapping(value = "/account/create",method = RequestMethod.GET)
	public ModelAndView getCreateAccountPage(ModelMap model){		
		
		return new ModelAndView("createAccount", model);
		
	}
	
	@RequestMapping(value = "/account/create",method = RequestMethod.POST)
	public ModelAndView createAccount(UserAccount userAccount, BindingResult result, ModelMap model){		
		
		accountDAO = new AccountDAOImpl();
				
		try {
			userAccount.setSalt(Hash.generateSalt());
			System.out.println("salt = " + userAccount.getEmail());
			System.out.println("salt = " + userAccount.getSalt());
			System.out.println("passwrd = " + userAccount.getPassword());
			userAccount.setPassword(Hash.createHash(userAccount.getPassword().getBytes(), userAccount.getSalt()).toString());
			System.out.println("passwrd2 = " + userAccount.getPassword().length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		accountDAO.addAcccount(userAccount);		
				
		return new ModelAndView("createAccount", model);		
	}

}
