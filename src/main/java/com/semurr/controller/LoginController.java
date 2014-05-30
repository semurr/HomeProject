package com.semurr.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.jboss.logging.Logger;
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
@Scope("request")
public class LoginController {
	
	@Autowired
	private SessionData sessionData;
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value = "/account/login",method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value = "/account/login",method = RequestMethod.POST)
	public ModelAndView submitLoginPage(@ModelAttribute("UserAccount") @Valid UserAccount userAccount, BindingResult result, ModelMap model){		
		
		Logger log = Logger.getLogger("InfoLoggin");
		
		try {
			log.info("start login");
			sessionData.setValidated(loginDAO.validateLogin(userAccount));
			sessionData.setUserAccountId(accountDAO.getAccountByName(userAccount.getEmail()).getUser_id());
		} catch (NoSuchAlgorithmException e) {
			log.info("login exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return new ModelAndView("login");
		
	}

}
