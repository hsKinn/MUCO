package com.ktds.muco.table.place.vo;

import java.util.List;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.image.vo.ImageVO;
import com.ktds.muco.table.member.vo.MemberVO;

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
	
	// 기준에 대한 평균값
	private double avgBrightDarkScore;
	private double avgHighPriceLowPriceScore;
	private double avgActiveCalmScore;

	// 작성자
	private MemberVO writer;
	
	private List<ImageVO> images;

	public List<ImageVO> getImages() {
		return images;
	}

	public void setImages(List<ImageVO> images) {
		this.images = images;
	}

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
	
	public double getAvgBrightDarkScore() {
		return avgBrightDarkScore;
	}

	public void setAvgBrightDarkScore(double avgBrightDarkScore) {
		this.avgBrightDarkScore = avgBrightDarkScore;
	}

	public double getAvgHighPriceLowPriceScore() {
		return avgHighPriceLowPriceScore;
	}

	public void setAvgHighPriceLowPriceScore(double avgHighPriceLowPriceScore) {
		this.avgHighPriceLowPriceScore = avgHighPriceLowPriceScore;
	}

	public double getAvgActiveCalmScore() {
		return avgActiveCalmScore;
	}

	public void setAvgActiveCalmScore(double avgActiveCalmScore) {
		this.avgActiveCalmScore = avgActiveCalmScore;
	}
}
