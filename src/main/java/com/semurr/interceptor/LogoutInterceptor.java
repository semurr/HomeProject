package com.semurr.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author stephen
 * 
 * Interceptor to see if logout was passed as true
 *
 */
public class LogoutInterceptor extends HandlerInterceptorAdapter{
	
	private String logout = "logout";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){	
		
		String requestLogout = request.getParameter(logout);	
		
		if(requestLogout != null){
			if(Boolean.valueOf(requestLogout) == true){				
				request.getSession().invalidate();
			}
		}
		
		return true;		
	}

}
