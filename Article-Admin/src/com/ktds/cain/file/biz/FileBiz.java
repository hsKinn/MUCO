package com.ktds.cain.file.biz;

import java.io.File;
import com.ktds.cain.article.web.MultipartHttpServletRequest;
import com.ktds.cain.article.web.MultipartHttpServletRequest.MultipartFile;
import com.ktds.cain.file.DAO.FileDAO;
import com.ktds.cain.file.vo.FileVO;

public class FileBiz {

	private FileDAO fdao;
	
	public FileBiz(){
		fdao = new FileDAO();
	}
	
	public void insertFileToss(MultipartHttpServletRequest request, int articleId) {
		
		MultipartFile file = request.getFile("file");
		File upFile = file.write("D:\\" + file.getFileName());
			
/*		if ( file.getFileName() != null && file.getFileName().length() > 0) {
		}*/
		
		FileVO vo = new FileVO();
		
		vo.setArticleId(articleId);
		vo.setFileName(file.getFileName());
		vo.setFileLocation(upFile.getPath());
		
		fdao.insertFile(vo);
	}
}
