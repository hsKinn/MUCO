package com.ktds.muco.table.history.vo;

/**
 * 
 * @author 김광민
 *
 */
public interface Description {

	// 회원가입
	public static final String JOIN = "[%s]님이 회원가입 했습니다.";
	public static final String JOIN_FAIL = "[%s]님이 회원가입에 실패 했습니다.";
	
	// 로그인
	public static final String VISIT_LOGIN_PAGE = "[%s]님이 로그인 페이지에 접근했습니다.";
	public static final String LOGIN = "[%s]님이 로그인했습니다.";
	public static final String LOGIN_FAIL = "[%s]가 [%s]로 로그인을 시도했지만, 실패했습니다.";
	
	// 메뉴 접근
	public static final String HIT_THE_ROAD = "[%s]님이 HIT_THE_ROAD 메뉴로 접근했습니다.";
	public static final String MY_PACKAGE = "[%s]님이 MY_PACKAGE 메뉴로 접근했습니다.";
	public static final String SHARE_PACKAGE = "[%s]님이 SHARE_PACKAGE 메뉴로 접근했습니다.";
	public static final String RECOMMEND_PLACE = "[%s]님이 RECOMMEND_PLACE 메뉴로 접근했습니다.";
	public static final String TRIP_RESERVATION = "[%s]님이 TRIP_RESERVATION 메뉴로 접근했습니다.";
	
	

}
