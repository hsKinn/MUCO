package com.ktds.cain.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class modifyServlet
 */
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        biz = new ArticlesBiz();
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
		// TODO 1.어떤 글을 수정할 것인지 / 2.해당 글의 ID를 파라미터로 받아와야함 
		// 3.글의 정보 가져옴 / 4.글의 작성자 확인 / 5.맞다면 글 정보 JSP로 보내줌
		
		
		// 1.
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		// 2.
		ArticleVO article = biz.getDetail(articleId);
		
		// 3.
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		
		if ( article.getMemberId().equals(member.getMemberId())) {
			
			String descript = article.getDescript();
			descript = descript.replaceAll("<br/>", "\n");
			article.setDescript(descript);

			//4.
			request.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/write.jsp");
			rd.forward(request, response);
		} else {
			//5.
			response.sendRedirect("/list");
		}
		
	}

}
