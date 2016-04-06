package com.ktds.muco.table.place.vo;

import java.util.List;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.image.vo.ImageVO;
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
	private int likeCount;
	private String placeDescription;
	private int isNewPlace;
	private int avgLikeCount;
	
	private boolean isExistPlaceLike;
	private boolean isExistVote;
	private List<PlaceReplyVO> placeReplyList;
	
	// 기준에 대한 평균값
	private double avgBrightDarkScore;
	private double avgHighPriceLowPriceScore;
	private double avgActiveCalmScore;
	private double avgArtificialNaturalScore;

	// 작성자
	private MemberVO writer;
	
	private String name;
	private String imageLocation;	
	
	private List<ImageVO> placeImageList;
	
	public boolean isExistVote() {
		return isExistVote;
	}

	public void setExistVote(boolean isExistVote) {
		this.isExistVote = isExistVote;
	}
	public List<ImageVO> getPlaceImageList() {
		return placeImageList;
	}

	public void setPlaceImageList(List<ImageVO> placeImageList) {
		this.placeImageList = placeImageList;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvgLikeCount() {
		return avgLikeCount;
	}

	public void setAvgLikeCount(int avgLikeCount) {
		this.avgLikeCount = avgLikeCount;
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

	public double getAvgArtificialNaturalScore() {
		return avgArtificialNaturalScore;
	}

	public void setAvgArtificialNaturalScore(double avgArtificialNaturalScore) {
		this.avgArtificialNaturalScore = avgArtificialNaturalScore;
	}
}
