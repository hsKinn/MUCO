package com.ktds.muco.biz;

import java.io.File;

import com.ktds.muco.dao.ImageDAO;
import com.ktds.muco.vo.ImageVO;
import com.ktds.muco.web.MultipartHttpServletRequest;
import com.ktds.muco.web.MultipartHttpServletRequest.MultipartFile;

public class ImageBiz {

	private ImageDAO idao;
	
	public ImageBiz(){
		idao = new ImageDAO();
	}
	
	public void insertFileToss(MultipartHttpServletRequest request, int articleId) {
		
		MultipartFile file = request.getFile("file");
		File upFile = file.write("D:\\" + file.getFileName());
			
/*		if ( file.getFileName() != null && file.getFileName().length() > 0) {
		}*/
		
		ImageVO imageVO = new ImageVO();
		
		imageVO.setImageId(articleId);
		imageVO.setImageName(file.getFileName());
		imageVO.setImageLocation(upFile.getPath());
		
		idao.insertFile(imageVO);
	}
}
