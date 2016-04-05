package com.ktds.muco.table.history.vo;

/**
 * MB 멤버
 * MN 멤버
 * 
 * LI 로그인
 * LO 로그아웃
 * 
 * @author 김광민
 *
 */
public interface ActionCode {

	// 로그인, 로그아웃
	public static final String LOGIN = "MB_LI";
	public static final String LOGOUT = "MB_LO";
	
	// ORIGIN_PLACE
	public static final String ORIGIN_PLACE = "MN_OP";
	
	// NEW_PLACE
	public static final String NEW_PLACE = "MN_NP";
	
	// NEW_PLACE_FRONT_PAGE
	public static final String NEW_PLACE_FRONT_PAGE = "MN_NF";
	
	// REPORTED_PLACE
	public static final String REPORTED_PLACE = "MN_RP";
	
	// PACKAGE_PAGE
	public static final String PACKAGE_PAGE = "MN_PP";
	
	// MEMBER_PAGE
	public static final String MEMBER_PAGE = "MN_MP";
	
	// REPORTED_MEMBER
	public static final String REPORTED_MEMBER = "MN_RM";
	
	// BLOCKED_MEMBER
	public static final String BLOCKED_MEMBER = "MN_BM";
	
	// RESERVATION_PAGE
	public static final String RESERVATION_PAGE = "MN_RS";
	
	// QNA_PAGE
	public static final String QNA_PAGE = "MN_QP";
	
	// HISTORY_PAGE
	public static final String HISTORY_PAGE = "MN_HP";
}
