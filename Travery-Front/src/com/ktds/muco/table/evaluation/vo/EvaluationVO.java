package com.ktds.muco.table.evaluation.vo;

import com.ktds.muco.table.member.vo.MemberVO;

public class EvaluationVO extends MemberVO {
	
	private int evaluationId;
	private int score;
	private int standardId;
	
	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStandardId() {
		return standardId;
	}
	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}
	
}
