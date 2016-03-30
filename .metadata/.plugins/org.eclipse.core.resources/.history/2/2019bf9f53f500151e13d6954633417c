package com.ktds.jgbaek.article.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.article.biz.ArticleBiz;
import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.file.vo.FileVO;
import com.ktds.jgbaek.util.DownloadUtil;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
    public DownloadServlet() {
        super();
        articleBiz = new ArticleBiz();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		
		ArticleVO article = articleBiz.getOneArticleByArticleId(articleId);
		List<FileVO> fileList = article.getFileList();
		
		if ( fileList != null ) {
			for (FileVO fileVO : fileList ) {
				if (fileVO.getFileId() == fileId){
					DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\");
					downloadUtil.download(request, response, fileVO.getFileName(), fileVO.getFileName());
				}
			}
		}
		
		
	}

}
