package com.ktds.muco.table.history.vo;

/**
 * 
 * MB 멤버
 * MN 메뉴
 * CT 나라
 * ST 기준
 * PL 여행지
 * PM 여행지 맵 
 * PS 여행지 세션
 * PH 여행지 조회수
 * PI 여행지 추천수
 * PR 여행지 댓글
 * PK 패키지
 * KH 패키지 조회수
 * KL 패키지 추천수
 * KR 패키지 댓글
 * 
 * JI 회원가입
 * LI 로그인
 * LO 로그아웃
 * SE 선택
 * RE 제거
 * DL 제거
 * MD 수정
 * AD 추가
 * DT 상세정보
 * IN 검색 초기화
 * 
 * @author 김광민
 *
 */
public interface ActionCode {

	// 회원가입
	public static final String JOIN = "MB_JI";
	
	// 로그인, 로그아웃
	public static final String LOGIN = "MB_LI";
	public static final String LOGOUT = "MB_LO";
	
	// Hit the road
	public static final String HIT_THE_ROAD = "MN_HR";
	public static final String SELECT_COUNTRY = "CT_SE";
	public static final String REMOVE_ALL_COUNTRY = "CT_RE";
	public static final String SELECTED_STANDARD = "ST_SE";
	public static final String SELECTED_PLACE = "PL_SE";
	public static final String ADD_PLACE_TO_MYPACK = "PK_MD";
	public static final String SELECT_PACKAGE = "PK_SE";
	
	// My pack
	public static final String MY_PACKAGE = "MN_MP";
	public static final String PACK_INFO = "PK_DT";
	public static final String MODIFY_PACK = "PK_MD";
	public static final String ADD_PACK = "PK_AD";
	public static final String DO_ADD_PACK = "PK_AD";
	public static final String DEL_PACK = "PK_DL";
	public static final String DO_DEL_PACK = "PK_DL";
	
	// Share pack
	public static final String SHARE_PACKAGE = "MN_SP";
	public static final String PACKAGE_SEARCH_INIT = "PK_IN";
	public static final String SHOW_PACK = "PK_DT";
	public static final String ADD_HIT_PACK = "KH_AD";
	public static final String ADD_LIKE_PACK = "KL_AD";
	public static final String PACK_REPLY_ADD = "KR_AD";
	public static final String PACK_REPLY_DEL = "KR_DL";
	
	// Recommend place
	public static final String RECOMMEND_PLACE = "MN_RP";
	public static final String PLACE_DETAIL = "PL_DT";
	public static final String ADD_PLACE_MAP = "PM_AD";
	public static final String MODIFY_MY_PLACE = "PL_MD";
	public static final String ADD_NEW_PLACE = "PL_AD";
	public static final String REMOVE_PLACE_SESSION = "PS_DL";
	public static final String ADD_PLACE_HIT = "PH_AD";
	public static final String ADD_PLACE_LIKE = "PI_AD";
	public static final String ADD_PLACE_REPLY = "PR_AD";
	public static final String DEL_PLACE_REPLY = "PR_DL";
	
	// Trip reservation
	public static final String TRIP_RESERVATION = "MN_TR";
	
	// Personal info
	public static final String PERSONAL_INFO = "MN_PI";
	
	// ContactUs, Q&A
	public static final String CONTACT_US = "MN_CU";
	public static final String QNA = "MN_QA";
}
