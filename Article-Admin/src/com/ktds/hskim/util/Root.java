package com.ktds.hskim.util;

import javax.servlet.http.HttpServlet;

public class Root {

	public static String get(HttpServlet servlet) {
		
		return servlet.getServletContext().getContextPath();
		
	}
}
