<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

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
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							일일 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
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
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							주간 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
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
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							월간 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
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
		<div id="new_wrapper">
			<div id="new_top">
				New
			</div>

			<div id="new_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="new-contents">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							새로운 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
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