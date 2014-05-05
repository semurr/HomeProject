package com.semurr.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.BlogDAO;
import com.semurr.dao.impl.BlogDAOImpl;
import com.semurr.model.Blog;

@Controller
@Scope("request")
public class BlogController {
	
	private BlogDAO blogDAO;
	
	@RequestMapping(value = "/blog/{blogId}",method = RequestMethod.GET)
	public ModelAndView displayBlogInfoPage(@PathVariable("blogId") int blog, ModelMap model){
		
		//TODO: autowire
		blogDAO = new BlogDAOImpl();
		
		//TODO: temp remove just to make right blog is diaplying
		System.out.println(blog);
		
		Blog blogDetails = blogDAO.getBlogById(blog);
		
		model.addAttribute("blog", blogDetails);
		
		return new ModelAndView("blog", model);
		
	}

}
