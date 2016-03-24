package com.ktds.muco.table.image.biz;

import java.io.File;

import com.ktds.muco.table.image.dao.ImageDAO;
import com.ktds.muco.table.image.vo.ImageVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;

/**
 * 
 * @author 김광민
 *
 */
public class ImageBiz {

	private ImageDAO imageDAO;
	
	public ImageBiz(){
		imageDAO = new ImageDAO();
	}
	
	public void insertFileToss(MultipartHttpServletRequest request, int placeId) {
		
		MultipartFile image = request.getFile("image");
		File upLoadImage = image.write("D:\\" + image.getFileName());
			
/*		if ( file.getFileName() != null && file.getFileName().length() > 0) {
		}*/
		
		ImageVO imageVO = new ImageVO();
		
		imageVO.setImageId(placeId);
		imageVO.setImageName(image.getFileName());
		imageVO.setImageLocation(upLoadImage.getPath());
		
		imageDAO.insertImage(imageVO);
	}
}
