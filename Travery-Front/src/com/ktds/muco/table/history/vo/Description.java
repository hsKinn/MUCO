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
	public static final String LOGIN = "[%s]님이 로그인했습니다.";
	public static final String LOGIN_FAIL = "[%s]가 [%s]로 로그인을 시도했지만, 실패했습니다.";
	
	// Hit the road
	public static final String HIT_THE_ROAD = "[%s]님이 HIT_THE_ROAD 메뉴로 접근했습니다.";
	public static final String SELECT_COUNTRY = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 나라를 선택했습니다.";
	public static final String SELECT_COUNTRY_FAIL = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 나라를 지웠습니다.";
	public static final String REMOVE_ALL_COUNTRY = "[%s]님이 HIT_THE_ROAD 메뉴에서 선택된 모든 나라를 지웠습니다.";
	public static final String REMOVE_ALL_COUNTRY_FAIL = "[%s]님이 HIT_THE_ROAD 메뉴에서 선택된 모든 나라를 지우지 못했습니다.";
	public static final String SELECTED_STANDARD = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s]축을 [%s]으로 변경했습니다.";
	public static final String SELECTED_STANDARD_FAIL = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s]축을 [%s]으로 변경하지 못했습니다.";
	public static final String SELECTED_PLACE = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 여행지를 선택했습니다.";
	public static final String SELECTED_PLACE_FAIL = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 여행지를 선택하지 못했습니다.";
	public static final String ADD_PLACE_TO_MYPACK = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 패키지에 여행지를 추가했습니다.";
	public static final String ADD_PLACE_TO_MYPACK_FAIL = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 패키지에 여행지를 추가하지 못했습니다.";
	public static final String SELECT_PACKAGE = "[%s]님이 HIT_THE_ROAD 메뉴에서 [%s] 패키지를 선택 했습니다.";
	
	// My pack
	public static final String MY_PACKAGE = "[%s]님이 MY_PACKAGE 메뉴로 접근했습니다.";
	public static final String PACK_INFO = "[%s]님이 MY_PACKAGE 메뉴에서 [%s]패키지를 선택했습니다.";
	public static final String PACK_INFO_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 [%s]패키지를 선택하지 못습니다.";
	public static final String MODIFY_PACK = "[%s]님이 MY_PACKAGE 메뉴에서 [%s]패키지를 수정했습니다.";
	public static final String MODIFY_PACK_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 [%s]패키지를 수정하지 못했습니다.";
	public static final String ADD_PACK = "[%s]님이 MY_PACKAGE 메뉴에서 패키지 추가 페이지로 접근했습니다.";
	public static final String ADD_PACK_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 패키지 추가 페이지로 접근했습니다.";
	public static final String DO_ADD_PACK = "[%s]님이 MY_PACKAGE 메뉴에서 [%s] 패키지를 추가했습니다.";
	public static final String DO_ADD_PACK_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 패키지를 추가하지 못했습니다.";
	public static final String DEL_PACK = "[%s]님이 MY_PACKAGE 메뉴에서 패키지 제거 페이지로 접근했습니다.";
	public static final String DEL_PACK_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 패키지 제거 페이지로 접근하지 못했습니다.";
	public static final String DO_DEL_PACK = "[%s]님이 MY_PACKAGE 메뉴에서 패키지를 제거 했습니다.";
	public static final String DO_DEL_PACK_FAIL = "[%s]님이 MY_PACKAGE 메뉴에서 패키지를 제거하지 못 했습니다.";
	
	// Share pack
	public static final String SHARE_PACKAGE = "[%s]님이 SHARE_PACKAGE 메뉴로 접근했습니다.";
	public static final String PACKAGE_SEARCH_INIT = "[%s]님이 SHARE_PACKAGE 메뉴에서 검색을 초기화 했습니다.";
	
	// Recommend place
	public static final String RECOMMEND_PLACE = "[%s]님이 RECOMMEND_PLACE 메뉴로 접근했습니다.";
	
	// Trip reservation
	public static final String TRIP_RESERVATION = "[%s]님이 TRIP_RESERVATION 메뉴로 접근했습니다.";
	
}
