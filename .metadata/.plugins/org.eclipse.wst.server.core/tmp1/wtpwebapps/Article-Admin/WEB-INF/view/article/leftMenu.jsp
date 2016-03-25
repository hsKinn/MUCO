<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div id="leftMenu">
	<ul>
		<li>최근 등록 게시물 보기</li>
		<li>차단된 사용자 등록한 게시글 보기</li>
		<li>차단된 게시글 보기</li>
		<li>신고가 접수된 게시글 보기</li>
		<li>
			<a href="<c:url value="/list/init"/>" >
				전체 게시글 보기
			</a>
		</li>
	</ul>
</div>

