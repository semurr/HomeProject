package com.semurr.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.BlogDAO;
import com.semurr.dao.impl.BlogDAOImpl;
import com.semurr.enums.Permission;
import com.semurr.helper.PermissionHelper;
import com.semurr.model.Blog;
import com.semurr.model.SessionData;
import com.semurr.model.UserAccount;

@Controller
@Scope("request")
public class BlogController {
	
	private String ERROR = "error";
	private String ERROR_MESSAGE_EMPTY_TITLE = "Unable to submit with an empty title";
	private String ERROR_MESSAGE_EMPTY_CONTENT = "Unable to submit with an empty Content";
	private String ERROR_MESSAGE_DATABASE = "Unable to submit blog to database";
	private String SUCCESS = "success";
	private String SUCCESS_MESSAGE = "New Blog Created";

	@Autowired
	private BlogDAO		blogDAO;

	@Autowired
	private SessionData	sessionData;

	@Autowired
	private AccountDAO	accountDAO;

	@RequestMapping(value = "/blog/{blogId}", method = RequestMethod.GET)
	public ModelAndView displayBlogInfoPage(@PathVariable("blogId") int blog,
			ModelMap model) {

		Blog blogDetails = blogDAO.getBlogById(blog);

		model.addAttribute("blog", blogDetails);

		return new ModelAndView("blog", model);

	}

	/**
	 * @param model
	 *            page model
	 * @return a new model and view for the create blog page if user has
	 *         permission to be here, else return bad page
	 */
	@RequestMapping(value = "/blog/create", method = RequestMethod.GET)
	public ModelAndView displayBlogCreatePage(ModelMap model) {

		if (!PermissionHelper.validateUserPermission(
				sessionData.getUserAccountId(), Permission.BLOG_WRITE)) {
			return new ModelAndView("404", model);
		}
		return new ModelAndView("createBlog", model);

	}

	@RequestMapping(value = "/blog/create", method = RequestMethod.POST)
	public ModelAndView createBlog(@ModelAttribute("Blog") @Valid Blog newBlog,
			BindingResult result, ModelMap model) {

		// verify the user has correct permission
		if (!PermissionHelper.validateUserPermission(
				sessionData.getUserAccountId(), Permission.BLOG_WRITE)) {
			return new ModelAndView("404", model);
		}

		//grab logged in user and add them to blog
		newBlog.setAuthor(accountDAO.getAccountById(sessionData
				.getUserAccountId()));

		//get current server time
		newBlog.setTime(Calendar.getInstance().getTime());	
		

		//check if title/context is empty if they are do not submit blog
		if (newBlog.getTitle().isEmpty()) {
			model.addAttribute(ERROR, ERROR_MESSAGE_EMPTY_TITLE);
			return new ModelAndView("createBlog", model);
		}

		if (newBlog.getSubject().isEmpty()) {
			model.addAttribute(ERROR, ERROR_MESSAGE_EMPTY_CONTENT);
			return new ModelAndView("createBlog", model);
		}
		
		try{
			//call the dao and create the blog
			blogDAO.addBlog(newBlog);
			model.addAttribute(SUCCESS, SUCCESS_MESSAGE);			
					
			return new ModelAndView("createBlog", model);
			
		} catch(Exception e){
			
			model.addAttribute(ERROR, ERROR_MESSAGE_DATABASE);			
			
			return new ModelAndView("createBlog", model);			
		}	
	}

}
