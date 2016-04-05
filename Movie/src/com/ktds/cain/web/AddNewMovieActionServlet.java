package com.ktds.cain.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.ktds.cain.dao.ActorDAO;
import com.ktds.cain.dao.DirectorDAO;
import com.ktds.cain.dao.GenreDAO;
import com.ktds.cain.dao.MovieDAO;
import com.ktds.cain.vo.ActorVO;
import com.ktds.cain.vo.DirectorVO;
import com.ktds.cain.vo.GenreVO;
import com.ktds.cain.vo.MovieVO;

/**
 * Servlet implementation class AddNewMovieActionServlet
 */
public class AddNewMovieActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO mdao;
	private GenreDAO gdao;
	private ActorDAO adao;
	private DirectorDAO ddao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewMovieActionServlet() {
		super();
		mdao = new MovieDAO();
		gdao = new GenreDAO();
		adao = new ActorDAO();
		ddao = new DirectorDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Wrong Responsable Actions.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String movieTitle = request.getParameter("movieTitle");
		String rate = request.getParameter("rate");
		String runTime = request.getParameter("runTime");
		String openDate = request.getParameter("openDate");
		String grade = request.getParameter("grade");

		List<String> directors = Arrays.asList(request.getParameterValues("directors"));
		List<String> actors = Arrays.asList(request.getParameterValues("actors"));
		List<String> genres = Arrays.asList(request.getParameterValues("genres"));

		if (movieTitle == null || movieTitle.length() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_MOVIE_TITLE);
			return;
		}
		if (rate == null | rate.length() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RATE);
			return;
		}
		try {
			double ratePoint = Double.parseDouble(rate);
		} catch (NumberFormatException nfe) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RATE);
			return;
		}
		if (runTime == null || runTime.length() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		if (runTime.length() > 5) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		Pattern p = Pattern.compile("^[0-2][0-9]:[0-5][0-9]$");
		Matcher m = p.matcher(runTime);
		if (!m.matches()) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		if (openDate == null || openDate.length() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_OPEN_DATE);
			return;
		}
		if (grade == null || grade.length() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_GRADE);
			return;
		}
		if (directors == null || directors.size() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_DIRECTORS);
			return;
		}
		if (actors == null || actors.size() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_ACTORS);
			return;
		}
		if (genres == null || genres.size() == 0) {
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_GENRES);
			return;
		}
		MovieVO movie = new MovieVO();
		movie.setTitle(movieTitle);
		movie.setRate(Double.parseDouble(rate));
		movie.setRunTime(runTime);
		movie.setStartDate(openDate);
		movie.setGradeId(Integer.parseInt(grade));

		int newMovieId = mdao.insertNewMovie(movie);

		if (newMovieId > 0) {
			GenreVO genre = new GenreVO();
			genre.setMovieId(newMovieId);
			for (String selectedGenre : genres) {
				genre.setGenreId(Integer.parseInt(selectedGenre));
				gdao.insertNewGenreOfNewMovie(genre);
			}
			ActorVO actor = new ActorVO();
			actor.setMovieId(newMovieId);
			for (String selectedActor : actors) {
				actor.setActorId(Integer.parseInt(selectedActor));
				adao.insertNewActorOfNewMovie(actor);
			}
			DirectorVO director = new DirectorVO();
			director.setMovieId(newMovieId);
			for (String selectedDirector : actors) {
				director.setDirectorId(Integer.parseInt(selectedDirector));
				ddao.insertNewDirectorOfNewMovie(director);
			}
			response.sendRedirect("/Movie/ms");
			return;
		}
	}
}
