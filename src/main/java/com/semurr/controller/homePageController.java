package com.semurr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.BlogDAO;
import com.semurr.dao.impl.BlogDAOImpl;
import com.semurr.helper.blogHelper;
import com.semurr.model.Blog;
import com.semurr.model.BlogPaginationHelper;
import com.semurr.model.SessionData;

@Controller
@Scope("request")
public class homePageController {
	
	private int pagesPerBlog = 5;
	
	@Autowired
	private SessionData sessionData;
	
	private BlogDAO blogDAO;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView getHomePage(HttpServletRequest request, ModelMap model){
		
		
		
		//TODO: autowire
		blogDAO = new BlogDAOImpl();
		
		//get blog
		List<Blog> blogs = blogDAO.getAllBlogs();
		
		//only display the first 5 blogs depending on which page was given
		String blogNewsRequestPage = request.getParameter("page");
		int blogPageNumber = 1;
		
		//if a page number is null give them first blogs, else convert to int then try to parse
		if(blogNewsRequestPage != null){
			try{
				int tempPageNumberStub = Integer.parseInt(blogNewsRequestPage);
				
				//if the passed number is greater then one set it to current blog number, or keep it at 1
				//0 or below will throw error lower
				if(tempPageNumberStub > 1){
					blogPageNumber = tempPageNumberStub;
				}
				 				
			} catch (Exception e){
				//bad input give them first page
			}
		}
		
        BlogPaginationHelper blogPager = blogHelper.blogListLimitationHelper(blogPageNumber, blogs.size());        
        
        model.addAttribute("pagination", blogPager);
        
        if(blogPager != null){
        	model.addAttribute("blogList", blogs.subList(blogPager.getStartPageNumber(), blogPager.getEndPageNumber()));
        	model.addAttribute("pagerNumber", blogPager.getCurrentPageNumber());
        } else{        	
        	model.addAttribute("pagerNumber", blogPageNumber);        	
        }
		
		
		
		return new ModelAndView("index", model);		
	}

}
