package com.ktds.muco.table.pack.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.file.vo.FileVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.util.file.DownloadUtil;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
    public DownloadServlet() {
        super();
        packBiz = new PackBiz();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imageName = request.getParameter("imageName");
		
		DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\");
		downloadUtil.download(request, response, imageName, imageName);
				
		
		
	}

}
