package com.ktds.muco.table.packReply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.packReply.biz.PackReplyBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DeletePackReplyServlet
 */
public class DeletePackReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PackReplyBiz packReplyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePackReplyServlet() {
        super();
        
        packReplyBiz = new PackReplyBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int packReplyId = Integer.parseInt(request.getParameter("packReplyId"));
		
		boolean check = packReplyBiz.deletePackReply(packReplyId);
		
		if (check) {
			response.sendRedirect(Root.get(this) + "/sharePack");
		}
		else {
			response.sendRedirect(Root.get(this) + "/sharePack?deleteFail");
		}
	}

}
