package com.ktds.cain.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.dao.ActorDAO;


/**
 * Servlet implementation class AddNewActorActionServlet
 */
public class AddNewActorActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ActorDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewActorActionServlet() {
        super();
        dao = new ActorDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Wrong Forbidden Responses.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String actorName = request.getParameter("actorName");
		
		if ( actorName == null || actorName.length() == 0) {
			response.sendRedirect("/Movie/addNewActor?errorCode=1");		
			return;
		} // if not adding actor name print error code = 1

		boolean insertResult = dao.addNewActor(actorName);
		if ( insertResult ) {
			response.sendRedirect("/Movie/ms");
		}
		else { 
			response.sendRedirect("/Movie/addNewActor?errorCode=2");
		}
	}
}
