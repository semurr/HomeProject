package com.semurr.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.account.UserAccount;
import com.smurr.hash.Hash;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/account/create",method = RequestMethod.GET)
	public ModelAndView getCreateAccountPage(ModelMap model){
		
		System.out.println("1");
		return new ModelAndView("createAccount", model);
		
	}
	
	@RequestMapping(value = "/account/create",method = RequestMethod.POST)
	public ModelAndView createAccount(UserAccount userAccount, ModelMap model){
				
		return new ModelAndView("createAccount", model);
		
	}

}
