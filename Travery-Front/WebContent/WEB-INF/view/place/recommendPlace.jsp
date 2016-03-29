<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- Recommend Place -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#recommendPlaceMenu").mouseout(function() {
			$("#recommendPlaceMenu").css("color", "#ffffff");
		});
		$("#recommendPlaceMenu").css("color", "#ffffff");
	});
</script>

<div id="recommendPlace_Wrapper">
	<div id="inner_wrapper">
		<div id="daily_wrapper">
			<div id="daily_top">
				Daily
			</div>
			
			<div id="daily_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg" class="img-thumbnail" />
						</div>					
						<div class="content_middle">
							일일 여행지 Title
						</div>
						<div class="content_bottom">
							<div class="bottom_top">
								Writer	
							</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>
		</div>
		
		<div id="weekly_wrapper">
			<div id="weekly_top">
				Weekly
			</div>

			<div id="weekly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg" class="img-thumbnail" />
						</div>					
						<div class="content_middle">
							주간 여행지 Title
						</div>
						<div class="content_bottom">
							<div class="bottom_top">
								Writer	
							</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>
		</div>
		
		<div id="monthly_wrapper">
			<div id="monthly_top">
				Monthly
			</div>

			<div id="monthly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg" class="img-thumbnail" />
						</div>					
						<div class="content_middle">
							월간 여행지 Title
						</div>
						<div class="content_bottom">
							<div class="bottom_top">
								Writer	
							</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>			
		</div>
	</div>
	
	<div id="middle">
		<div id="search_part">
			<input type="text" id="searchKeyword" placeholder="  # Search" />
			<button type="button" class="btn btn-info" id="searchBtn">
	     		<span class="glyphicon glyphicon-search"></span>검색
	   		</button>
			<button type="button" class="btn btn-info" id="initSearchBtn">
	     		<span class="glyphicon glyphicon-repeat"></span>초기화
	   		</button>
   		 </div>
   		 <div id="write_part">
			<button type="button" class="btn btn-info" id="writeBtn">
	     		<span class="glyphicon glyphicon-pencil"></span>등록하기
	   		</button>   		 
   		 </div>
	</div>
	
	<div id="inner_wrapper2">
		<div id="paging">
			Paging
		</div>
		<div id="new_wrapper">
			<div id="new_top">
				<div id="top_name">New</div>
				<div id="top_sort">
					<div class="dropdown">
			 			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Sort By
			  				<span class="caret"></span>
			  			</button>
			 			<ul class="dropdown-menu">
						    <li><a href="#">추천 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
						    <li><a href="#">조회 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
						    <li><a href="#">등록 순<span class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
			  			</ul>
			  		</div>
		  		</div>
			</div>

			<div id="new_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="new_contents">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content_middle">
							새로운 여행지 Title
						</div>
						<div class="content_bottom">
							<div class="bottom_top">
								Writer	
							</div>
							<div class="bottom_first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			

			</div>
		</div>
	</div>
</div>





<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>