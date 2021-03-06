<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<script type="text/javascript">
/* 내용 script */
$(document).ready( function() {
	
	// 검색 종류 list 받아오기 
	
	// 검색 초기화 클릭
	$("#initSearchBtn").click(function() {
		location.href = "<c:url value="/reportedPlaceList/init" />";
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
		$(".deleteReportedPlaceId").prop("checked", isChecked);
	});
	
	$("#massiveDeleteBtn").click( function() {
		var isChecked = false;
		
		$(".deleteReportedPlaceId").each( function (index, data) {
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
			form.attr("action", "<c:url value="/reportedPlaceMassiveDelete" />");
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
				총 <b style="color: red">${reportedPlaces.paging.totalArticleCount}</b> 있습니다.

				<!-- Place 관리 버튼 -->
				<div id="buttonCollection">
					<span id="massiveDeleteBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Delete</button>
					</span> 
					
					<!-- dropdown 정렬 메뉴 -->
					<div class="dropdown memberListdropDown" style="float: right;">
					    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
					    	정렬 <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/reportedPlaceList?sortOption=1" />">신고자EMAIL</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/reportedPlaceList?sortOption=2" />" >신고된 여행지</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/reportedPlaceList?sortOption=3" />">신고일</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/reportedPlaceList?sortOption=4" />">신고이유</a></li>
					    </ul>
					</div>	
					<!-- /#dropdown memberListdropDown -->						
				</div>

				<div id="listWrapper">
					<!-- Place List 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th><input type="checkbox" id="massiveSelectCheckBox" /></th>
							<th>신고ID</th>
							<th>신고자EMAIL</th>
							<th>신고된 여행지ID</th>
							<th>신고일</th>
							<th>신고 이유</th>
							<th>신고 설명</th>
						</tr>

						<form id="massiveDeleteForm">
							<c:forEach items="${reportedPlaces.reportedPlaceList}" var="reportedPlace">
								<tr>
									<td>
										<input type="checkbox" class="deleteReportedPlaceId" name="deleteReportedPlaceId" value="${reportedPlace.placeId}" />
									</td>
									<td>${reportedPlace.reportedId}</td>
									<td>${reportedPlace.email}</td>
									<td><a
										href="<c:url value="/placeDetail?placeId=${reportedPlace.placeId}" />">${reportedPlace.placeId}</a></td>
									<td>${reportedPlace.reportedDate}</td>
									<td>${reportedPlace.category}</td>
									<td>${reportedPlace.description}</td>
								</tr>
							</c:forEach>
						</form>

						<tr>
							<td colspan="7" style="background-color:#a1a1a1;">
								<!-- 검색 form  -->
								<form id="searchForm">
									<br/>
									<div style="text-align: center;"> <!-- 페이징 -->
										${ reportedPlaces.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
									</div>
									<div style="text-align: center;"> <!-- 검색어 -->
										<c:set var="selectedList" value="${sessionScope._RESERVE_SEARCH_.searchList }" />
										<c:set var="reservedList" value="${sessionScope._RESERVE_SEARCH_ }" />
										<select name="searchList" id="searchList">
											<option value="basic">검색 타입</option>
											<option value="email" ${selectedList eq "email" ? "selected" : "" }>신고자 Email</option>
										  	<option value="placeId" ${selectedList eq "placeId" ? "selected" : "" }>신고된 여행지ID</option>
										  	<option value="category" ${selectedList eq "category" ? "selected" : "" }>신고이유</option>
										  	<option value="description" ${selectedList eq "description" ? "selected" : "" }>신고설명</option>
										</select>
										
										<input type="text" id="searchKeyword" name="searchKeyword" value="${reservedList.searchKeyword}"/>
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
