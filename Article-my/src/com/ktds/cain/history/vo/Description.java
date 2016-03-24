package com.ktds.cain.history.vo;

public interface Description {
	
	public static final String VISIT_LOGIN_PAGE = "[%s] is accesses login pages.";
	public static final String LOGIN = "[%s] is login now.";
	public static final String LOGIN_FAIL = "[%s] is[%s] login failed.";
	public static final String ALREADY_LOGIN = "[%s] is  already logined, then move list page.";
	
	public static final String LIST = "[%s] is List pages accesses";
	public static final String LIST_PAGING = "[%s]is [%s]번째 페이지로 이동";
	public static final String DETAIL = "[%s]is [%s]번째 글을 읽음";
	public static final String LIST_SEARCH = "[%s]님이 목록보기 페이지에서 [%s]로 [%s]를 검색";
	
	public static final String DETAIL_DESCRIPTION = "TITLE : [%s]<br/>Writer : [%s]<br/>Contents : [%s]<br/>";
	
}
