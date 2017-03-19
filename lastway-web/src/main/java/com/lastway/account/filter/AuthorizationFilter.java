package com.lastway.account.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.faces" })
public class AuthorizationFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest servletRequest = (HttpServletRequest)request;
			HttpServletResponse servletResponse = (HttpServletResponse)response;
			HttpSession session = servletRequest.getSession();

			String reqURI = servletRequest.getRequestURI();
			System.out.println("reqURI: " + reqURI);
			
			if ( reqURI.indexOf("/login.faces") >= 0 
					|| (session != null && session.getAttribute("username") != null )
					|| reqURI.indexOf("/account/") >= 0
					|| reqURI.contains("javax.faces.resources")) {
				
				
				System.out.println("1+1 = " + servletRequest.getContextPath());
				chain.doFilter(request, response);
			}else {
				System.out.println("2+2 == " + servletRequest.getContextPath()+"/login.faces");
				servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.faces");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
