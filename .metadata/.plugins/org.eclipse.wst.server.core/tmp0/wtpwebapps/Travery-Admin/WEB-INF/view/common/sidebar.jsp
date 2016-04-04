<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand">
					<a href="#"> TRAVERY </a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">여행지<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">여행지 관리자 메뉴</li>
						<li><a href="<c:url value="/originPlaceList" />">Origin Place</a></li>
						<li><a href="<c:url value="/newPlaceList" />">New Place</a>
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
				<li><a href="#">예약</a></li>
				<li><a href="#">QnA</a></li>
				<li><a href="#">History</a></li>
			</ul>
		</nav>
		<!-- /#sidebar-wrapper -->