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
					<a href="#">
						<button type="button" class="btn btn-default">Edit</button>
					</a>
					
					<a href="<c:url value="/placeDelete?placeId=${placeDetail.placeId}" />">
						<button type="button" class="btn btn-default">Delete</button>
					</a>
									
					<span id="massiveBlockBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Report</button>
					</span> 
					
					<span id="massiveBlockBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Go Origin!</button>
					</span> 

					
				</div>
				            
				<div id="detailWrapper">
					<table id="detailTable">
						<tr>
							<th>여행지ID</th>
							<th>여행지명</th>
							<th>주소</th>
							<th>조회수</th>
							<th>추천수</th>
							<th>최초등록자 이름</th>
							<th>도시ID</th>
						</tr>
				
						<tr>
							<td>${placeDetail.placeId}</td>
							<td>${placeDetail.placeName}</td>
							<td>${placeDetail.address}</td>
							<td>${placeDetail.viewCount}</td>
							<td>${placeDetail.likeCount}</td>
							<td>${registerMember.name}</td>
							<td>${placeDetail.countryId}</td>
						</tr>
				
						<tr>
							<th colspan="7">여행지 설명</th>
						</tr>
				
						<tr>
							<td id="articleDescript" colspan="7">${placeDetail.description}</td>
						</tr>
				
						<tr>
							<th colspan="7">여행지 이미지</th>
						</tr>
				
						<tr>
							<td colspan="7">
								여행지 이미지 넣기! here! 
							</td>
						</tr>

						<tr>
							<th colspan="7">여행지 Mood</th>
						</tr>
						<tr>
							<td colspan="7">
								여행지 Mood
							</td>
						</tr>
					</table>
					<!-- /#detailTable -->
				</div>	
				<!-- /#detailWrapper -->

            </div>
            <!-- /#Origin Place Contents -->
            
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
