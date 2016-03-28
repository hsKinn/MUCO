package com.ktds.muco.table.pack.vo;

import java.util.List;

import com.ktds.muco.table.hashtag.vo.HashTagVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;

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
	
	private String shareImageLocation;
	private String imageLocation;
	
	private boolean isExistPackLike;
	
	private List<HashTagVO> hashtagList;
	
	private List<PlaceVO> placeList;
	
	
	public boolean isExistPackLike() {
		return isExistPackLike;
	}

	public void setExistPackLike(boolean isExistPackLike) {
		this.isExistPackLike = isExistPackLike;
	}

	public List<PlaceVO> getPlaceList() {
		return placeList;
	}
	
	public void setPlaceList(List<PlaceVO> placeList) {
		this.placeList = placeList;
	}

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
		
	private String shareImageName;

	public String getShareImageLocation() {
		return shareImageLocation;
	}

	public void setShareImageLocation(String shareImageLocation) {
		this.shareImageLocation = shareImageLocation;
	}

	public String getShareImageName() {
		return shareImageName;
	}

	public void setShareImageName(String shareImageName) {
		this.shareImageName = shareImageName;
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
