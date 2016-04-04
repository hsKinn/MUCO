<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<script src="<c:url value="/resource/js/jquery-jvectormap-world-mill-en.js" />"></script>
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

/* 내용 script */
$(document).ready( function() {
	
	// 검색 종류 list 받아오기 
	
	// 검색 초기화 클릭
	$("#initSearchBtn").click(function() {
		location.href = "<c:url value="/list/init" />";
	});
	
	// 검색 버튼 클릭 
	$("#searchBtn").click(function() {
		
		// 검색어를 입력하지 않았을 경우
		if ( $("#searchKeyword").val() =="") { 
			alert("검색어를 입력하세요");
			return;
		}
		
		// 검색을 마치고 movePage 0으로 간다 
		movePage('0');
		
	});
	
	$("#massiveSelectCheckBox").click( function() {
		var isChecked = $(this).prop("checked");
		//일괄체크 되도록 하는 것 
		$(".deletePlaceId").prop("checked", isChecked);
	});
	
	$("#massiveDeleteBtn").click( function() {
		var isChecked = false;
		
		$(".deletePlaceId").each( function (index, data) {
			if (data.checked) {
				isChecked = data.checked;
			}
			
		});
		
		// 삭제할 대상을 정하지 않았으면 alert뜨기 
		if( !isChecked ) {
			alert("삭제할 Place를 선택하세요");
		}
		
		// 사용자의 confirm 받기 
		if( confirm("정말 삭제하시겠습니까?") ) {
			// 지우는 로직 넣기 
			var form = $("#massiveDeleteForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeMassiveDelete" />");
			form.submit();
		}
		
	});
	
	$("#massiveGoOriginBtn").click( function() {
		var isChecked = false;
		
		$(".deletePlaceId").each( function (index, data) {
			if (data.checked) {
				isChecked = data.checked;
			}
			
		});
		
		// 삭제할 대상을 정하지 않았으면 alert뜨기 
		if( !isChecked ) {
			alert("Go Origin할 Place를 선택하세요");
		}
		
		// 사용자의 confirm 받기 
		if( confirm("정말 New Place로 넘기시겠습니까?") ) {
			// 지우는 로직 넣기 
			var form = $("#massiveDeleteForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeMassiveGoNewPlace" />");
			form.submit();
		}
		
	});
			
});
</script>
<body>

	<div id="wrapper">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/common/sidebar.jsp"></jsp:include>
		
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>

			<!-- Origin Place Contents -->
			<div class="container">


				<!-- 총 Place 수 보여주기  -->
				총 <b style="color: red">${places.paging.totalArticleCount}</b> 있습니다.

				<!-- Place 관리 버튼 -->
				<div id="buttonCollection">
					<span id="massiveDeleteBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Delete</button>
					</span> 
					
					<span id="massiveGoOriginBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Go NewPlace!</button>
					</span> 
					
					<!-- dropdown 정렬 메뉴 -->
					<div class="dropdown memberListdropDown" style="float: right;">
					    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
					    	정렬 <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">여행지명</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/placeList?sortOption=1" />">등록자 이름</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">나라ID</a></li>
					      <li role="presentation" class="divider"></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">추천수</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">조회수</a></li>
					    </ul>
					</div>	
					<!-- /#dropdown memberListdropDown -->						
				</div>

				<div id="listWrapper">
					<!-- Place List 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th><input type="checkbox" id="massiveSelectCheckBox" /></th>
							<th>여행지ID</th>
							<th>여행지명</th>
							<th>주소</th>
							<th>조회수</th>
							<th>추천수</th>
							<th>최초등록자Email</th>
							<th>나라ID</th>
						</tr>

						<form id="massiveDeleteForm">
							<c:forEach items="${places.placeList}" var="place">
								<tr>
									<td>
										<input type="checkbox" class="deletePlaceId" name="deletePlaceId" value="${place.placeId}" />
										<input type="hidden" class="placeType" name="placeType" value="${place.isNewPlace }" />
									</td>
									<td>${place.placeId}</td>
									<td><a
										href="<c:url value="/placeDetail?placeId=${place.placeId}" />">${place.placeName}</a></td>
									<td><a
										href="<c:url value="/placeDetail?placeId=${place.placeId}" />">${place.address}</a></td>
									<td>${place.viewCount}</td>
									<td>${place.likeCount}</td>
									<td>${place.writer.email}</td>
									<td>${place.countryId}</td>
								</tr>
							</c:forEach>
						</form>

						<tr>
							<td colspan="8" style="background-color:#a1a1a1;">
								<!-- 검색 form  -->
								<form id="searchForm">
									<br/>
									<div style="text-align: center;"> <!-- 페이징 -->
										${ places.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
									</div>
									<div style="text-align: center;"> <!-- 검색어 -->
										<c:set var="selectedList" value="${sessionScope._SEARCH_.searchList }" />
										<select name="searchList" id="searchList">
											<option value="placeName" ${selectedList eq "placeName" ? "selected" : "" }>여행지명</option>
										  	<option value="memberEmail" ${selectedList eq "memberId" ? "selected" : "" }>최초등록자Email</option>
										  	<option value="countryId" ${selectedList eq "memberNickName" ? "selected" : "" }>나라ID</option>
										</select>
										
										<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword}"/>
										<input type="button" id="searchBtn" name="searchBtn" value="검색"/>
										<input type="button" id="initSearchBtn" value="검색초기화" />
									</div>
								</form>									
								<br/>
							</td>
						</tr>
					</table>
					<!-- /#tableList -->
				</div>
				<!-- /#listWrapper -->


			</div>
			<!-- /#Origin Place Contents -->

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
