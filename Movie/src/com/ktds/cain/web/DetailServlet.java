package com.ktds.cain.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.dao.ActorDAO;
import com.ktds.cain.dao.DirectorDAO;
import com.ktds.cain.dao.GenreDAO;
import com.ktds.cain.dao.MovieDAO;
import com.ktds.cain.vo.ActorVO;
import com.ktds.cain.vo.DirectorVO;
import com.ktds.cain.vo.GenreVO;
import com.ktds.cain.vo.MovieVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO mDAO;
	private DirectorDAO dDAO;
	private ActorDAO aDAO;
	private GenreDAO gDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        mDAO = new MovieDAO();
        dDAO = new DirectorDAO();
        aDAO = new ActorDAO();
        gDAO = new GenreDAO();
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
		
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		// briefing movie info
		MovieVO movie = mDAO.getOneMovieInfoByMovieId(movieId);
		
		// briefing director info
		List<DirectorVO> directors = dDAO.getDirectorsByMovieId(movieId);
		
		// briefing actor info
		List<ActorVO> actors = aDAO.getActorsByMovieId(movieId);
		
		// briefing genre info
		List<GenreVO> genres = gDAO.getGenreByMovieId(movieId);

		request.setAttribute("movie", movie);
		request.setAttribute("directors", directors);
		request.setAttribute("actors", actors);
		request.setAttribute("genres", genres);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/detail.jsp");
		rd.forward(request, response);
		
	}

}
