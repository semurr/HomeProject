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
import com.semurr.dao.LoginDAO;
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.dao.impl.LoginDAOImpl;
import com.semurr.model.SessionData;
import com.semurr.model.UserAccount;

@Controller
@Scope("session")
public class LoginController {
	
	@Autowired
	private SessionData sessionData;
	
	AccountDAO accountDAO;
	
	@RequestMapping(value = "/account/login",method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value = "/account/login",method = RequestMethod.POST)
	public ModelAndView submitLoginPage(@ModelAttribute("UserAccount") @Valid UserAccount userAccount, BindingResult result, ModelMap model){
		
		LoginDAO loginDAO = new LoginDAOImpl();
		
		try {
			sessionData.setValidated(loginDAO.validateLogin(userAccount));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Correct password: " + sessionData.isValidated());
		
		
		
		return new ModelAndView("login");
		
	}

}
