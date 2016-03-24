package com.ktds.muco.table.pack.vo;

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
