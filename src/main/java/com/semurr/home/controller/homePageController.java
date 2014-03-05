package com.semurr.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homePageController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView getHomePage(ModelMap model){
		
		
		return new ModelAndView("index", model);		
	}

}
