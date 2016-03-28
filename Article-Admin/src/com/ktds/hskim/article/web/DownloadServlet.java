package com.ktds.hskim.article.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.file.vo.FileVO;
import com.ktds.hskim.util.DownloadUtil;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        articleBiz = new ArticleBiz();
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

		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		
		ArticleVO article = articleBiz.getDetailArticle(articleId);
		List<FileVO> fileList = article.getFileList();
		
		if ( fileList != null ) {
			for ( FileVO fileVO : fileList ) {
				if ( fileVO.getFileId() == fileId ) {
					DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\");
					
					downloadUtil.download(request, response, fileVO.getFileName(), fileVO.getFileName());
				}
			}
		
		}
	}
		
}	
