package com.ktds.hskim.history.vo;

public interface Description {
	
	public static final String VISIT_LOGIN_PAGE = "[%s]가 로그인 접근";
	public static final String LOGIN = "[%s] 님이 로그인 성공";
	public static final String LOGIN_FAIL = "[%s]가 [%s]로 로그인 시도 실패";
	public static final String ALREADY_LOGIN = "[%s] 님이 이미 로그인 되어있습니다";
	
	public static final String LIST = "[%s]님이 목록 페이지 접근";
	public static final String LIST_PAGING = "[%s]님이 [%s] 페이지로 이동";
	public static final String LIST_SEARCH = "[%s]님이 [%s]로 [%s]를 검색";
	public static final String DETAIL = "[%s]님이 [%s]번째 글을 읽었습니다";
	
	public static final String DETAIL_DESCRIPTION = "제목 : [%s]<br/> 글쓴이 : [%s]<br/> 내용 : [%s]<br/>";
	
}
