<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<script
	src="<c:url value="/resource/js/jquery-jvectormap-world-mill-en.js" />"></script>
<script type="text/javascript">
$(document).ready( function() {
	var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false; trigger.click(function() {
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
	
	$("#massiveSelectCheckBox").click( function() {
		var isChecked = $(this).prop("checked");
		//일괄체크 되도록 하는 것 
		$(".deleteArticleId").prop("checked", isChecked);
	});
	
	$("#massiveDeleteBtn").click( function() {
		var isChecked = false;
		
		$(".deleteArticleId").each( function (index, data) {
			if (data.checked) {
				isChecked = data.checked;
			}
			
		});
		
		// 삭제할 대상을 정하지 않았으면 alert뜨기 
		if( !isChecked ) {
			alert("삭제할 대상을 선택하세요");
		}
		
		// 사용자의 confirm 받기 
		if( confirm("정말 삭제하시겠습니까?") ) {
			// 지우는 로직 넣기 
			var form = $("#massiveDeleteForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/massiveDelete" />");
			form.submit();
		}
		
	});
	
});
</script>
<body>

	<div id="wrapper">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand"><a href="#"> TRAVERY </a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">여행지<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">여행지 관리자 메뉴</li>
						<li><a href="<c:url value="/originPlaceList" />">Origin
								Place</a></li>
						<li><a href="<c:url value="/newPlaceList" />">New Place</a></li>
						<li><a href="#">New Place Front Page</a></li>
						<li><a href="<c:url value="/reportedPlaceList" />">Reported
								Place</a></li>
					</ul></li>
				<li><a href="<c:url value="/packList" />">패키지</a></li>
				<li><a href="<c:url value="/memberList" />">멤버</a></li>
				<li><a href="#">예약</a></li>
				<li><a href="#">QnA</a></li>
				<li><a href="#">History</a></li>
			</ul>
		</nav>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>

			<!-- Origin Place Contents -->
			<div class="container">


				<!-- 총 회원 수 보여주기  -->
				총 <b style="color: red">${members.paging.totalArticleCount}</b>명
				있습니다.

				<!-- 회원 버튼 -->
				<div id="buttonCollection">
					<span id="massiveDeleteBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Delete</button>
					</span> <span id="massiveBlockBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Report</button>
					</span> <a href="<c:url value="/registerMember"/>">
						<button type="button" class="btn btn-default">sorting</button>
					</a>
				</div>

				<div id="memberListWrapper">
					<!-- 게시글 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th><input type="checkbox" id="massiveSelectCheckBox" /></th>
							<th>Email</th>
							<th>비밀번호</th>
							<th>운영자 여부</th>
							<th>전화번호</th>
							<th>이름</th>
							<th>가입일</th>
							<th>최근 접속일</th>
						</tr>

						<form id="massiveDeleteForm">
							<c:forEach items="${members.memberList}" var="member">
								<tr>
									<td><input type="checkbox" class="deleteMemberId"
										name="deleteMemberId" value="${member.email}" /></td>
									<td><a
										href="<c:url value="/memberDetail?email=${member.email}" />">${member.email}</a></td>
									<td>${member.password}</a></td>
									<td>${member.isAdmin}</td>
									<td>${member.phoneNumber}</td>
									<td>${member.name}</td>
									<td>${member.joinDate}</td>
									<td>${member.recentAccessDate}</td>
								</tr>
							</c:forEach>
						</form>

						<tr>
							<td colspan="8">
								<form id="searchForm">${ members.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
								</form>
							</td>
						</tr>
					</table>
					<!-- /#tableList -->
				</div>
				<!-- /#memberListWrapper -->


			</div>
			<!-- /#Origin Place Contents -->

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>