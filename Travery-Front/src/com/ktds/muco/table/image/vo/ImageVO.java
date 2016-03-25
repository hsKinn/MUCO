package com.ktds.muco.table.image.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * 여행지의 이미지
 * 
 * @author 김광민
 *
 */
public class ImageVO extends MemberVO {

	private int imageId;
	private String imageName;
	private String imageLocation;
	private String createdDate;

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

}
