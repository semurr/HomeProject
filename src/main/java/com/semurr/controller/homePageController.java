package com.semurr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.model.SessionData;

@Controller
@Scope("session")
public class homePageController {
	
	@Autowired
	private SessionData sessionData;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView getHomePage(ModelMap model){
		
		
		return new ModelAndView("index", model);		
	}

}
