package com.ktds.cain.article.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.file.vo.FileVO;
import com.ktds.cain.util.DownloadUtil;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        biz = new ArticlesBiz();
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

		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		
		ArticleVO article =  biz.getDetail(articleId);
		List<FileVO> fileList = article.getFileList();
		
		if ( fileList != null) {
			for ( FileVO fileVO : fileList ) {
				if ( fileVO.getFileId() == fileId) {
					DownloadUtil util = DownloadUtil.getInstance("D:\\");
					util.download(request, response, fileVO.getFileName(), fileVO.getFileName());
					// 난수로 바꿀때를 대비해서 현재 파일명과 db에 저장할 파일명의 변수를 기입.  
				}
			}
		}
	}
}
