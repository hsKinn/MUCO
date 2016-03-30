package com.ktds.muco.util.root;

import javax.servlet.http.HttpServlet;

public class Root {

	/**
	 * Get Root
	 * 
	 * @param servlet
	 * @return String "/"
	 */
	public static String get(HttpServlet servlet) {

		return servlet.getServletContext().getContextPath();
	}
}
