package com.ktds.muco.table.place.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 김현섭
 *
 */
public class RecommendPlaceListVO {

	private List<PlaceVO> dailyList = new ArrayList<PlaceVO>();
	
	private List<PlaceVO> weeklyList = new ArrayList<PlaceVO>();
	
	private List<PlaceVO> monthlyList = new ArrayList<PlaceVO>();

	
	public List<PlaceVO> getDailyList() {
		return dailyList;
	}

	public void setDailyList(List<PlaceVO> dailyList) {
		this.dailyList = dailyList;
	}

	public List<PlaceVO> getWeeklyList() {
		return weeklyList;
	}

	public void setWeeklyList(List<PlaceVO> weeklyList) {
		this.weeklyList = weeklyList;
	}

	public List<PlaceVO> getMonthlyList() {
		return monthlyList;
	}

	public void setMonthlyList(List<PlaceVO> monthlyList) {
		this.monthlyList = monthlyList;
	}
	
}
