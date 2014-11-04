package com.semurr.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.hibernate.HibernateException;
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
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.model.SessionData;
import com.semurr.model.UserAccount;

@Controller
@Scope("request")
public class AccountController {
	
	@Autowired
	private SessionData sessionData;
	
	@Autowired
	AccountDAO accountDAO;
	
	@RequestMapping(value = "/account/create",method = RequestMethod.GET)
	public ModelAndView getCreateAccountPage(ModelMap model){
		
		return new ModelAndView("createAccount", model);
		
	}
	
	@RequestMapping(value = "/account/create",method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("UserAccount") @Valid UserAccount userAccount, BindingResult result, ModelMap model){
		
		Logger log = Logger.getLogger("InfoLoggin");	
				
		try {			
			userAccount = accountDAO.createAccount(userAccount, null);
		} catch (NoSuchAlgorithmException e) {		
			return new ModelAndView("createAccount", model);			
		}
		
		try{
			log.info("starting add account");			
			accountDAO.addAcccount(userAccount);
			
		} catch (HibernateException e){			
			log.info("caught hibernate error");
			model.addAttribute("error", e.getMessage());
			
			return new ModelAndView("createAccount", model);
		}	
		
		log.info("account created");		
		model.addAttribute("accountName", userAccount.getEmail());
				
		return new ModelAndView("createAccountSuccess", model);		
	}

}
