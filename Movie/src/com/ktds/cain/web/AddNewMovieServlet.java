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
import com.ktds.cain.dao.GradeDAO;
import com.ktds.cain.vo.ActorVO;
import com.ktds.cain.vo.DirectorVO;
import com.ktds.cain.vo.GenreVO;
import com.ktds.cain.vo.GradeVO;

/**
 * Servlet implementation class AddNewMovieServlet
 */
public class AddNewMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GenreDAO gdao;
    private GradeDAO grdao;
    private DirectorDAO ddao;
    private ActorDAO adao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMovieServlet() {
        super();
        gdao = new GenreDAO();
        grdao = new GradeDAO();
        ddao = new DirectorDAO();
        adao = new ActorDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorCode = request.getParameter("errorCode");
		errorCode = (errorCode == null ? "" : errorCode );
		
		if ( errorCode.equals(MovieValidateConst.MISSING_MOVIE_TITLE) ) {
			request.setAttribute("errorMessage", "choose the movie title");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_RATE) ) {
			request.setAttribute("errorMessage", "choose the rate");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_RUNNING_TIME) ) {
			request.setAttribute("errorMessage", "choose the run time");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_OPEN_DATE) ) {
			request.setAttribute("errorMessage", "choose the open date");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_GRADE) ) {
			request.setAttribute("errorMessage", "choose the grade");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_DIRECTORS) ) {
			request.setAttribute("errorMessage", "choose the directors");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_ACTORS) ) {
			request.setAttribute("errorMessage", "choose the actors");
		}
		if ( errorCode.equals(MovieValidateConst.MISSING_GENRES) ) {
			request.setAttribute("errorMessage", "choose the genres");
		}
		
		// 1. Genre List
		List<GenreVO> genreList = gdao.getAllGenres();
		// 2. Grade List
		List<GradeVO> gradeList = grdao.getAllGrades();
		// 3. Director List
		List<DirectorVO> directorList = ddao.getAllDirectors();
		// 4. Actor List
		List<ActorVO> actorList = adao.getAllActors();
		
		request.setAttribute("genreList", genreList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("directorList", directorList);
		request.setAttribute("actorList", actorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addNewMovie.jsp");
		rd.forward(request, response);
	}
}
