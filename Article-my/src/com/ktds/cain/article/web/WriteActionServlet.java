package com.ktds.cain.article.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.article.web.MultipartHttpServletRequest.MultipartFile;
import com.ktds.cain.file.biz.FileBiz;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class WriteActionServlet
 */
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
	private FileBiz fbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteActionServlet() {
        super();
        biz = new ArticlesBiz();
        fbiz= new FileBiz();
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

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		ArticleVO vo = new ArticleVO();
		
		String title = multipartRequest.getParameter("title");
		String descript = multipartRequest.getParameter("descript");
		MultipartFile file = multipartRequest.getFile("file");
		
		vo.setTitle(title);
		vo.setDescript(descript);
		vo.setMemberId(member.getMemberId());
		int articleId = biz.insertArticle(vo);
		
		
		if ( file.getFileSize() > 0) {
			fbiz.insertFileToss(multipartRequest, articleId);
		}
		try {
			response.sendRedirect("/list");
			}
		catch ( RuntimeException re ) {
			System.out.println(re.getMessage());
			response.sendRedirect("/detail?articleId=" + articleId);
		}
	}
}
