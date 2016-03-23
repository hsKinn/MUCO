package com.ktds.muco.table.place.vo;

import com.ktds.muco.table.city.vo.CityVO;

/**
 * PlaceVO
 * 
 * latitude : 위도
 * longitude : 경도
 * isNewPlace : 0 기존 / 1 신규
 * nickName : 여행지 최초 등록자 닉네임
 * ( 이메일(FK)로 하면 회원이 탈퇴하면 문제가 생기기 때문에 닉네임으로 )
 * 
 * @author 김광민
 *
 */
public class PlaceVO extends CityVO {

	private int placeId;
	private String placeName;
	private double latitude;
	private double longitude;
	private String address;
	private int viewCount;
	private int likeCount;
	private String description;
	private int isNewPlace;
	

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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsNewPlace() {
		return isNewPlace;
	}

	public void setIsNewPlace(int isNewPlace) {
		this.isNewPlace = isNewPlace;
	}

	
}