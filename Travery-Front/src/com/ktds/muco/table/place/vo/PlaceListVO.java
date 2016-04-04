package com.ktds.muco.table.place.vo;

import java.util.List;

import com.ktds.muco.table.image.vo.ImageVO;
import com.ktds.muco.util.web.Paging;
/**
 * 여행지
 * 
 * Paging 미구현
 * 
 * @author 김동규
 *
 */
public class PlaceListVO {

	private List<PlaceVO> placeList;
	private Paging paging;
	
	public List<PlaceVO> getPlaceList() {
		return placeList;
	}
	public void setPlaceList(List<PlaceVO> placeList) {
		this.placeList = placeList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
}
