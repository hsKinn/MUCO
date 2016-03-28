package com.ktds.hskim.article.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.file.biz.FileBiz;
import com.ktds.hskim.file.vo.FileVO;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.MultipartHttpServletRequest;
import com.ktds.hskim.util.MultipartHttpServletRequest.MultipartFile;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class WriteActionServlet
 */
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleBiz articleBiz;
	FileBiz fileBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteActionServlet() {
        super();
        
        articleBiz = new ArticleBiz();
        fileBiz = new FileBiz();
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
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		String title = multipartRequest.getParameter("title");
		String description =  multipartRequest.getParameter("description");
		MultipartFile file = multipartRequest.getFile("file");
		File upFile = file.write("D:\\" + file.getFileName());
		boolean checkaddFile = false;
		
		// 로그인 세션 가져오기
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( loginMember.isBlock() ){
			
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}
		else {
			
			// 작성할 게시글 내용 입력
			ArticleVO article = new ArticleVO();
			article.setMemberId(loginMember.getMemberId());
			article.setDescript(description);
			article.setTitle(title);
			
			// 게시글 추가
			int writtenArticleId = articleBiz.writeArticle( article );
			
			// 파일 존재 여부 확인
			if ( file.getFileName().length() > 0 ) {
				
				FileVO attachFile = new FileVO();
				attachFile.setFileName(file.getFileName());
				attachFile.setFileLocation("D:\\" + file.getFileName());
				attachFile.setArticleId(writtenArticleId);
				
				checkaddFile = fileBiz.addFileList(attachFile);
			}
			
			response.sendRedirect(Root.get(this) + "/list");
		}
	}

}
