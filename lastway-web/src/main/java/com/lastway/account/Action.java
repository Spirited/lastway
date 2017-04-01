package com.lastway.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String execute(HttpServletRequest request, HttpServletResponse httpServletResponse);
}
