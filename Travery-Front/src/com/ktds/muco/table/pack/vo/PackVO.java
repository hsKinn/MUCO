package com.ktds.muco.table.pack.vo;

import java.util.List;

import com.ktds.muco.table.hashtag.vo.HashTagVO;
import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김광민
 *
 */
public class PackVO extends MemberVO {

	private int packId;
	private String packTitle;
	private int viewCount;
	private int likeCount;
	private int isPublic;
	private String imageLocation;
	
	private List<HashTagVO> hashtagList;

	public List<HashTagVO> getHashtagList() {
		return hashtagList;
	}

	public void setHashtagList(List<HashTagVO> hashtagList) {
		this.hashtagList = hashtagList;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getPackTitle() {
		return packTitle;
	}

	public void setPackTitle(String packTitle) {
		this.packTitle = packTitle;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
}
