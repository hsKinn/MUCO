<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

/* 사이드 메뉴 script */
$(document).ready(function() {
	var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

	trigger.click(function() {
		hamburger_cross();
	});

	function hamburger_cross() {

		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		} else {
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		}
	}

	$('[data-toggle="offcanvas"]').click(function() {
		$('#wrapper').toggleClass('toggled');
	});
	
});
</script>

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand">
					<a href="#"> TRAVERY ADMIN</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">여행지<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">여행지 관리자 메뉴</li>
						<li><a href="<c:url value="/originPlaceList?sortOption=9" />">Origin Place</a></li>
						<li><a href="<c:url value="/newPlaceList?sortOption=9" />">New Place</a>
						</li>
						<li><a href="#">New Place Front Page</a></li>
						<li><a href="<c:url value="/reportedPlaceList" />">Reported Place</a></li>
					</ul>
				</li>
				<li><a href="<c:url value="/packList" />">패키지</a></li>
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">회원관리 메뉴</li>
						<li><a href="<c:url value="/memberList" />">멤버</a></li>
						<li><a href="<c:url value="/reportedMemberList" />">신고된 멤버</a></li>
						<li><a href="<c:url value="/blockedMemberList" />">차단된 멤버</a></li>
					</ul>
				</li>
				<li><a href="<c:url value="/reserveList" />">예약</a></li>
				<li><a href="<c:url value="/qnaList" />">Q&A</a></li>
				<li><a href="<c:url value="/historyList" />">History</a></li>
			</ul>
		</nav>
		<!-- /#sidebar-wrapper -->