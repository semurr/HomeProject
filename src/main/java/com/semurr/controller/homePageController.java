package com.semurr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.BlogDAO;
import com.semurr.dao.impl.BlogDAOImpl;
import com.semurr.model.Blog;
import com.semurr.model.SessionData;

@Controller
@Scope("request")
public class homePageController {
	
	@Autowired
	private SessionData sessionData;
	
	private BlogDAO blogDAO;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView getHomePage(ModelMap model){
		
		//TODO: autowire
		blogDAO = new BlogDAOImpl();
		
		//get blog
		List<Blog> blogs = blogDAO.getAllBlogs();
		
		model.addAttribute("blogList", blogs);
		
		
		return new ModelAndView("index", model);		
	}

}
