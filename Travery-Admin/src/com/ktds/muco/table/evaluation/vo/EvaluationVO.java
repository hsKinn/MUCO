package com.ktds.muco.table.evaluation.vo;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.standard.vo.StandardVO;

/**
 * 
 * extends 하지 않고 VO를 생성함
 * 
 * @author 김광민
 *
 */
public class EvaluationVO extends StandardVO{

	private int ecaluationId;
	private int score;
	private PlaceVO place;
	private MemberVO member;

	public int getEcaluationId() {
		return ecaluationId;
	}

	public void setEcaluationId(int ecaluationId) {
		this.ecaluationId = ecaluationId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PlaceVO getPlace() {
		return place;
	}

	public void setPlace(PlaceVO place) {
		this.place = place;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}
}
