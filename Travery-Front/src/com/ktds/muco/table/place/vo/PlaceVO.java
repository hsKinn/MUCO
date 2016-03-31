package com.ktds.muco.table.place.vo;

import java.util.List;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.placeReply.vo.PlaceReplyVO;

/**
 * 여행지
 * 
 * latitude : 위도 
 * longitude : 경도 
 * isNewPlace : 0 기존 / 1 신규 
 * writer : 작성자 VO
 * 
 * @author 김광민
 *
 */
public class PlaceVO extends CountryVO {

	private int placeId;
	private String placeName;
	private double latitude;
	private double longitude;
	private String address;
	private int viewCount;
	private String placeDescription;
	private int isNewPlace;
	/**
	 * 여행지
	 * 
	 * add : likeCount
	 * @author 김동규
	 *
	 */
	private MemberVO writer;
	private int likeCount;
	private String imageLocation;
	private boolean isExistPlaceLike;
	private List<PlaceReplyVO> placeReplyList;
	private String name;
	private List<PlaceVO> placeList;
	
	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getPlaceDescription() {
		return placeDescription;
	}

	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}

	public int getIsNewPlace() {
		return isNewPlace;
	}

	public void setIsNewPlace(int isNewPlace) {
		this.isNewPlace = isNewPlace;
	}

	public MemberVO getWriter() {
		return writer;
	}

	public void setWriter(MemberVO writer) {
		this.writer = writer;
	}
	public int getLikeCount() {
		return likeCount;
	}
	
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public boolean isExistPlaceLike() {
		return isExistPlaceLike;
	}

	public void setExistPlaceLike(boolean isExistPlaceLike) {
		this.isExistPlaceLike = isExistPlaceLike;
	}

	public List<PlaceReplyVO> getPlaceReplyList() {
		return placeReplyList;
	}

	public void setPlaceReplyList(List<PlaceReplyVO> placeReplyList) {
		this.placeReplyList = placeReplyList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PlaceVO> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<PlaceVO> placeList) {
		this.placeList = placeList;
	}
	
	
	
}
