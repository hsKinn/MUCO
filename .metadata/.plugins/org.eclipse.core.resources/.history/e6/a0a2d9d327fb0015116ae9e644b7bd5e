<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<script	src="<c:url value="/resource/js/jquery-jvectormap-world-mill-en.js" />"></script>
<script type="text/javascript"></script>
<body>

	<div id="wrapper">
		<div class="overlay"></div>

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


				<!-- 총 회원 수 보여주기  -->
				총 <b style="color: red">${members.paging.totalArticleCount}</b>명
				있습니다.

				<!-- 회원 버튼 -->
				<div id="buttonCollection">
					<a href="<c:url value="/memberDelete?email=${member.email}" />">
						<button type="button" class="btn btn-default">Delete</button>
					</a>
					<a href="<c:url value="/memberRelease?email=${member.email}" />">
						<button type="button" class="btn btn-default">Release</button>
					</a>
				
					<div class="dropdown memberListdropDown" style="float: right;">
					    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
					    	정렬 <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">가입일</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">최근 접속일</a></li>
					      <li role="presentation" class="divider"></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">이름</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Email</a></li>
					      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">운영자</a></li>
					    </ul>
					</div>	
					<!-- /#dropdown memberListdropDown -->			
				</div>

				<div id="listWrapper">
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
									<td>
										<input type="checkbox" class="deleteMemberId" name="deleteMemberId" value="${member.email}" /></td>
									<td>
										<a href="<c:url value="/blockedMemberDetail?email=${member.email}" />">${member.email}</a></td>
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
							<td colspan="8" style="background-color:#a1a1a1;">
								<!-- 검색 form  -->
								<form id="searchForm">
									<br/>
									<div style="text-align: center;"> <!-- 페이징 -->
										${ members.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
									</div>
									<div style="text-align: center;"> <!-- 검색어 -->
										<c:set var="selectedList" value="${sessionScope._SEARCH_.searchList }" />
										<select name="searchList" id="searchList">
											<option value="placeName" ${selectedList eq "placeName" ? "selected" : "" }>Email</option>
											<option value="placeName" ${selectedList eq "placeName" ? "selected" : "" }>전화번호</option>
											<option value="placeName" ${selectedList eq "placeName" ? "selected" : "" }>이름</option>
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
