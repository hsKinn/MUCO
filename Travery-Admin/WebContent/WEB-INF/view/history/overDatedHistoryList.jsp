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
		location.href = "<c:url value="/historyList/init" />";
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
				<h1 style="text-align: center;">Over 30days History</h1>
				<hr style="border-top: 3px solid #333333;"/>

				<!-- 총 Place 수 보여주기  -->
				총 <b style="color: red">${hisotryies.paging.totalArticleCount}</b> 있습니다.

				<!-- Place 관리 버튼 -->
				<div id="buttonCollection">
					<a href="<c:url value="/deleteAllHistoryList" />">
						<button type="button" class="btn btn-default">Delete All History</button>
					</a> 
					
				</div>

				<div id="listWrapper">
					<!-- Place List 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th><input type="checkbox" id="massiveSelectCheckBox" /></th>
							<th>히스토리ID</th>
							<th>IP</th>
							<th>EMAIL</th>
							<th>생성일</th>
							<th>접근 URL</th>
							<th>액션코드</th>
							<th>내용</th>
							<th>ETC</th>
						</tr>

						<form id="massiveDeleteForm">
							<c:forEach items="${hisotryies.historyList}" var="history">
								<tr>
									<td>
										<input type="checkbox" class="hisotryId" name="hisotryId" value="${history.historyId}" />
									</td>
									<td>${history.historyId}</td>
									<td>${history.ip}</td>
									<td>${history.email}</td>
									<td>${history.createdDate}</td>
									<td>${history.url}</td>
									<td><a href="<c:url value="#" />">${history.actionCode}</a></td>
									<td><a href="<c:url value="#" />">${place.description}</a></td>
									<td>${history.etc}</td>
								</tr>
							</c:forEach>
						</form>

						<tr>
							<td colspan="9" style="background-color:#a1a1a1;">
								<!-- 검색 form  -->
								<form id="searchForm">
									<br/>
									<div style="text-align: center;"> <!-- 페이징 -->
										${ hisotryies.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
									</div>
									<div style="text-align: center;"> <!-- 검색어 -->
										<c:set var="selectedList" value="${sessionScope._SEARCH_.searchList }" />
										<select name="searchList" id="searchList">
											<option value="placeName" ${selectedList eq "placeName" ? "selected" : "" }>IP</option>
										  	<option value="memberEmail" ${selectedList eq "email" ? "selected" : "" }>EMAIL</option>
										  	<option value="countryId" ${selectedList eq "countryId" ? "selected" : "" }>접근 URL</option>
										  	<option value="countryId" ${selectedList eq "countryId" ? "selected" : "" }>액션코드</option>
										  	<option value="countryId" ${selectedList eq "countryId" ? "selected" : "" }>내용</option>
										  	<option value="countryId" ${selectedList eq "countryId" ? "selected" : "" }>ETC</option>
										</select>
										
										<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword}"/>
										<input type="button" id="searchBtn" name="searchBtn" value="검색"/>
										<input type="button" id="initSearchBtn" value="검색초기화" />
										<input type="hidden" id="placeType" name="placeType" value="0" />
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
