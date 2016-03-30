<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>     

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/originPlaceList.css"/>" />
	
<script
	src="<c:url value="/resource/js/jquery-jvectormap-world-mill-en.js" />"></script>
<script type="text/javascript">
$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;

	    trigger.click(function () {
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
	  
	  $('[data-toggle="offcanvas"]').click(function () {
	        $('#wrapper').toggleClass('toggled');
	  });  
	});
</script>
<body>

    <div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       TRAVERY
                    </a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">여행지<span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">여행지 관리자 메뉴</li>
                    <li><a href="#">Origin Place</a></li>
                    <li><a href="#">New Place</a></li>
                    <li><a href="#">New Place Front Page</a></li>
                    <li><a href="#">Reported Place</a></li>
                    <li><a href="#">Place Mood Manage</a></li>
                  </ul>
                </li>
                <li>
                    <a href="#">패키지</a>
                </li>
                <li>
                    <a href="#">멤버</a>
                </li>
                <li>
                    <a href="#">예약</a>
                </li>
                <li>
                    <a href="#">QnA</a>
                </li>
                <li>
                    <a href="#">History</a>
                </li>
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
            
            <!-- Origin Place Contents -->
            <div class="container">


<!-- 총 회원 수 보여주기  -->
	총 <b style="color:red">${places.paging.totalArticleCount}</b> 있습니다. 
	
<!-- 회원 버튼 -->	
	<div id="buttonCollection">
		<span id="massiveDeleteBtn" style="cursor: pointer">
			<button type="button" class="btn btn-default">Delete</button>
		</span>
		<span id="massiveBlockBtn" style="cursor: pointer">
			<button type="button" class="btn btn-default">Report</button>
		</span>
		
		<a href="<c:url value="/registerMember"/>" >
			<button type="button" class="btn btn-default">Add New</button>
		</a>
	</div>
	
	<div id="memberListWrapper">
	<!-- 게시글 보여주는 list table -->
		<table id="tableList" >
			<tr>
				<th>
					<input type="checkbox" id="massiveSelectCheckBox" />
				</th>
				<th>여행지ID</th>
				<th>여행지명</th>
				<th>주소</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>설명</th>
				<th>최조등록자 이름</th>
				<th>도시ID</th>
			</tr>
			
			<form id="massiveDeleteForm">	
			<c:forEach items = "${places.placeList}" var = "place">
			<tr>
				<td>
					<input type="checkbox" class="deleteMemberId" name="deleteMemberId" value="${place.email}" />
				</td>
				<td>${place.placeId}</td>
				<td><a href= "<c:url value="/originPlaceDetail?placeId=${place.placeId}" />" >${place.placeName}</a></td>
				<td><a href= "<c:url value="/originPlaceDetail?placeId=${place.placeId}" />" >${place.address}</a></td>
				<td>${place.viewCount}</td>
				<td>${place.likeCount}</td>
				<td>${place.description}</td>
				<td>${place.email}</td>
				<td>도시ID</td>
			</tr>
			</c:forEach>
			</form>
			<tr>
				<td colspan="9">
				<form id="searchForm">
					${ places.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
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
