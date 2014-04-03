package com.semurr.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.model.SessionData;
import com.semurr.model.UserAccount;
import com.smurr.hash.Hash;

@Controller
@Scope("session")
public class AccountController {
	
	@Autowired
	private SessionData sessionData;
	
	AccountDAO accountDAO;
	
	@RequestMapping(value = "/account/create",method = RequestMethod.GET)
	public ModelAndView getCreateAccountPage(ModelMap model){
		
		return new ModelAndView("createAccount", model);
		
	}
	
	@RequestMapping(value = "/account/create",method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("UserAccount") @Valid UserAccount userAccount, BindingResult result, ModelMap model){	
		
		if(result.hasErrors()){
			return new ModelAndView("createAccount");
		} 
		
		accountDAO = new AccountDAOImpl();
				
		try {			
			userAccount = accountDAO.createAccount(userAccount, null);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		accountDAO.addAcccount(userAccount);
		
		model.addAttribute("accountName", userAccount.getEmail());
				
		return new ModelAndView("createAccountSuccess", model);		
	}

}
