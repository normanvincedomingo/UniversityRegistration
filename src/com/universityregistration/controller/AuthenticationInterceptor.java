package com.universityregistration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		User userData = (User) request.getSession().getAttribute(
				"LOGGEDIN_USER");
		
		if (!request.getRequestURI().equals(
				"/UniversityRegistration/")
				&& !request.getRequestURI().equals(
						"/UniversityRegistration/login.do")
				&& !request.getRequestURI().equals(
						"/UniversityRegistration/login.failed")) {
			
			if (userData == null) {
				response.sendRedirect("/UniversityRegistration/login.html");
				return false;
			}
		} else {
			
			if (userData != null) {
				response.sendRedirect("/UniversityRegistration/admissionForm.html");
				return false;
			}
			
		}
		return true;
	}
}
