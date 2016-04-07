package com.ktds.muco.table.qna.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * QNA
 * 
 * title : 질문 제목 description : 질문 내용 isAnswer : 답변이 달렸으면 1, 안달렸으면 0
 * answerDescription : 답변 내용 isFaq : 자주묻는 질문이면 1, 아니면 0
 * 
 * @author 김광민
 *
 */
public class QNAVO extends MemberVO {

	private int qnaId;
	private String qndDate = "";
	private String title = "";
	private String description = "";
	private int isAnswer;
	private String answerDescription = "";
	private int isFaq;

	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}

	public String getQndDate() {
		return qndDate;
	}

	public void setQndDate(String qndDate) {
		this.qndDate = qndDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(int isAnswer) {
		this.isAnswer = isAnswer;
	}

	public String getAnswerDescription() {
		return answerDescription;
	}

	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}

	public int getIsFaq() {
		return isFaq;
	}

	public void setIsFaq(int isFaq) {
		this.isFaq = isFaq;
	}

}
