package com.ktds.muco.table.image.biz;

import java.io.File;

import javax.servlet.http.HttpSession;

import com.ktds.muco.table.image.dao.ImageDAO;
import com.ktds.muco.table.image.vo.ImageVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;

/**
 * 
 * @author 김광민
 *
 */
public class ImageBiz {

	private ImageDAO imageDAO;

	public ImageBiz() {
		imageDAO = new ImageDAO();
	}

	/**
	 * 
	 * @author insertImageToss 김동규
	 *
	 */
	public void insertImageToss(MultipartHttpServletRequest request, PlaceVO placeVO) {

		ImageVO imageVO = new ImageVO();

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");

		MultipartFile image = request.getFile("image");
		File upLoadImage = image.write("D:\\" + image.getFileName());

		imageVO.setPlaceId(placeVO.getPlaceId());
		imageVO.setImageName(image.getFileName());
		imageVO.setImageLocation(upLoadImage.getPath());
		imageVO.setEmail(member.getEmail());

		imageDAO.insertImage(imageVO);

	}
}
