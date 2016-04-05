<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>     

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/originPlaceList.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/placeListDetail.css"/>" />
	
<body>

    <div id="wrapper">
        <div class="overlay"></div>
    
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/common/sidebar.jsp"></jsp:include>	

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
            
            <!-- Origin Place Contents -->
            <div class="container">
            
				<!-- 회원 버튼 -->
				<div id="buttonCollection">
					<a href="<c:url value="/memberDelete?email=${member.email}" />">
						<button type="button" class="btn btn-default">Delete</button>
					</a>
					<a href="<c:url value="/memberBlock?email=${member.email}" />">
						<button type="button" class="btn btn-default">Block</button>
					</a>
				</div>
				            
				<div id="detailWrapper">
					<table id="detailTable">
						<tr>
							<th>Email</th>
							<th>비밀번호</th>
							<th>운영자 여부</th>
							<th>전화번호</th>
							<th>이름</th>
							<th>가입일</th>
							<th>최근 접속일</th>
						</tr>
				
						<tr>
							<td>${member.email}</td>
							<td>${member.password}</td>
							<td>${member.isAdmin}</td>
							<td>${member.phoneNumber}</td>
							<td>${member.name}</td>
							<td>${member.joinDate}</td>
							<td>${member.recentAccessDate}</td>
						</tr>
				
						<tr>
							<th colspan="7">회원 프로필 이미지</th>
						</tr>
				
						<tr>
							<td colspan="7">
								회원 프로필 이미지 넣기! here! 
							</td>
						</tr>

						<tr>
							<th colspan="7">회원 활동</th>
						</tr>
						<tr>
							<td colspan="7">
								회원 활동
							</td>
						</tr>
					</table>
					<!-- /#detailTable -->
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
