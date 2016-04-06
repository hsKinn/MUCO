package com.ktds.muco.util.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.pack.biz.PackBiz;

/**
 * Servlet implementation class DownloadServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
    public ImageServlet() {
        super();
        packBiz = new PackBiz();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		
		DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\travery\\");
		downloadUtil.download(request, response, imageName, imageName);
	}

}
