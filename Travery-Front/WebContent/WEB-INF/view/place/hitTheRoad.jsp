<!-- 김광민 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- CSS  -->
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/hitTheRoad.css"/>" />

<!-- Boot Script -->
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- jVector Map CSS -->
<link rel="stylesheet" media="all" href="<c:url value="/resource/css/place/jquery-jvectormap-2.0.3.css"/>" />

<!-- jVector Map SCRIPT -->
<script src="<c:url value="/resource/js/jvectormap/jquery-jvectormap-2.0.3.min.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/jquery-mousewheel.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/abstract-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/abstract-canvas-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/abstract-shape-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-group-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-canvas-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-shape-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-path-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-circle-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-image-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/svg-text-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-group-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-canvas-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-shape-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-path-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-circle-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vml-image-element.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/map-object.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/region.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/marker.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/vector-canvas.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/simple-scale.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/ordinal-scale.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/numeric-scale.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/color-scale.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/legend.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/data-series.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/proj.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/map.js" />"></script>
<script src="<c:url value="/resource/js/jvectormap/jquery-jvectormap-world-mill-en.js" />"></script>

<c:set var="axisX1" value="${ sessionScope._MEMBER_.selectedStandardList.get(0) }" />
<c:set var="axisX2" value="${ sessionScope._MEMBER_.selectedStandardList.get(1) }" />
<c:set var="axisY1" value="${ sessionScope._MEMBER_.selectedStandardList.get(2) }" />
<c:set var="axisY2" value="${ sessionScope._MEMBER_.selectedStandardList.get(3) }" />

<!-- 지도 출력 -->
<script>
	jQuery.noConflict();
	jQuery(function() {
		
		var $ = jQuery;

		$('#focus-multiple').click(function() {
			$('#map1').vectorMap('set', 'focus', {
				regions : [ 'KR', 'JP' ],
				animate : true
			});
		});

		$('#focus-init').click(function() {
			$('#map1').vectorMap('set', 'focus', {
				scale : 1,
				x : 0.5,
				y : 0.5,
				animate : true
			});
		});

		$('#map1').vectorMap({
			map : 'world_mill_en',
			panOnDrag : true,
			focusOn : {
				x : 0.5,
				y : 0.5,
				scale : 1,
				animate : true
			},
			onRegionClick : function(event, code) {
				var map = $('#map1').vectorMap('get', 'mapObject');
				location.href = "/selectedCountry?selectedCountryName=" + map.getRegionName(code);
			},
			series : {
				regions : [ {
					scale : [],
					normalizeFunction : 'polynomial'
				}]
			}
		});
	});
</script>

<!-- 기준 출력 -->
<script type="text/javascript">

	$(document).ready(function() {

		/* 0. 기본 값 */
		
		// 왼쪽 사이드바 메뉴 선택시
		$("#hitTheRoadMenu").mouseout(function() {
			$("#hitTheRoadMenu").css("color", "#ffffff");
		});
		$("#hitTheRoadMenu").css("color", "#ffffff");
		
		// 탭 유지
		$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
           localStorage.setItem('activeTab', $(e.target).attr('href'));
       });
       var activeTab = localStorage.getItem('activeTab');
       if(activeTab){
           $('[href="' + activeTab + '"]').tab('show');
       }
		
		// 새로고침 해도 현재 탭 유지
		
		/* 1. 나라 선택 탭 */
		
		// 오른쪽 나라 리스트에서 나라 지울때
		<c:if test=" not empty ${ removeCountryName }">
		<c:set value="${ removeCountryName }" var="removeCountryName" />
			$('#'+ removeCountryName).remove();
		</c:if>
  	
	   	// 나라 선택 초기화
	   	$("#removeAllCountries").click(function(){
			location.href = "/removeAllSelectedCountries";
	   	});
	   	
	   	/* 2. 나라 검색 탭 */
	   	
		// X축 변경
		$(".axisX").click(function(){
			location.href = "/selectedStandard?selectedStandard=X&selectedStandardName=" + $(this).text();
		});
	
		// Y축 변경
		$(".axisY").click(function(){
			location.href = "/selectedStandard?selectedStandard=Y&selectedStandardName=" + $(this).text();
		});
		
		// 점들의 위치 설정
							
		<c:if test="${ not empty selectedAllPlaceList }">
			<c:forEach items="${ selectedAllPlaceList }" var="selectedPlace">
			
				<c:if test="${ axisX1 eq 'Bright'}">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-left" : "${ selectedPlace.avgBrightDarkScore * 6.5}px"});
				</c:if>
				<c:if test="${ axisX1 eq 'Active' }">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-left" : "${ selectedPlace.avgActiveCalmScore * 6.5 }px"});
				</c:if>
				<c:if test="${ axisX1 eq 'HighPrice' }">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-left" : "${ selectedPlace.avgHighPriceLowPriceScore * 6.5 }px"});
				</c:if>
				
				<c:if test="${ axisY1 eq 'Bright'}">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-top" : "${ 325 - (selectedPlace.avgBrightDarkScore * 3.25) }px"});
				</c:if>
				<c:if test="${ axisY1 eq 'Active' }">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-top" : "${ 325 - (selectedPlace.avgActiveCalmScore * 3.25) }px"});
				</c:if>
				<c:if test="${ axisY1 eq 'HighPrice' }">
					$('#placeIdIs${ selectedPlace.placeId }').css({"margin-top" : "${ 325 - (selectedPlace.avgHighPriceLowPriceScore * 3.25) }px"});
				</c:if>
				
			</c:forEach>
		</c:if>
		
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<!-- Hit the road -->

<section class="bg-primary" id="one">
	<div class="container">
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">HIT THE ROAD</h2>
			<hr class="primary">
			<p>손 쉽게 여행 예약을 할 수 있는 기능</p>
		</div>

		<!-- 내용 -->
		<div id="hitTheRoad">
		
			<!-- 첫번째 열 -->
			<div id="firstRow" class="row">
		
				<!-- 나라 선택, 여행지 검색, 나의 패키지, 경로설정 -->
				<div class="col-sm-8" style="height: 100%;">
					<div id="firstContainer" class="container">
		
						<!-- 탭 -->
						<ul id="hitTheRoadTabs" class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#home">Country</a></li>
							<li id="searchPlaces" class="tapMenu"><a data-toggle="tab" href="#menu1">Mood</a></li>
							<li class="tapMenu"><a data-toggle="tab" href="#menu2">My package</a></li>
							<li class="tapMenu"><a data-toggle="tab" href="#menu3">Route</a></li>
						</ul>
		
						<!-- 탭 내용 -->
						<div class="tab-content">
							<!-- 나라 선택 탭 -->
							<div id="home" class="tab-pane fade in active">
		
								<!-- 지도 -->
								<div id="map1" style="width: 100%; height: 95%;"></div>
		
								<button id="focus-multiple" >KR and JP</button>
								<button id="focus-init" >World Map</button>
								<button id="removeAllCountries" style="background-color: #333333; color:#ffffff;">Remove All Countries</button>
							</div>
		
							<!-- 여행지 검색 탭 -->
							<div id="menu1" class="tab-pane fade">
								<div class="row">
									<div id="printAxisY1">${ axisY1 }</div>
								</div>
								<div class="row" style="height: 350px; margin-top: 20px; margin-bottom: 20px;">
									<div id="printAxisX2" class="col-sm-2">${ axisX2 }</div>
									
									<!-- ★★★★★★★★★★★★★★★★ 점 찍는 곳 ★★★★★★★★★★★★★★★★★★★★ -->
									<div id="dottedDiv" class="col-sm-8" style="padding:0;">
										<c:forEach items="${ selectedAllPlaceList }" var="selectedPlace">
											<c:set value="${ selectedPlace.placeId }" var="placeId" />
											<c:set value="${ selectedPlace.placeName }" var="placeName" />
											<c:set value="${ selectedPlace.countryId }" var="countryId" />
											<a
											id="placeIdIs${ placeId }"
											class="countryIdIs${ countryId }" 
											href="#"
											data-toggle="tooltip"
											title="${ placeName }"
											style="
												font-weight: bolder;
												font-size:x-small;
												text-decoration: none;
												position: absolute;"
											>●
											</a>		
										</c:forEach>
									</div>
									
									<div id="printAxisX1" class="col-sm-2">${ axisX1 }</div>
								</div>
								<div class="row">
									<div id="printAxisY2">${ axisY2 }</div>
								</div>
							</div>
							<!-- 나의 패키지 탭 -->
							<div id="menu2" class="tab-pane fade"></div>
		
							<!-- 경로 설정 탭 -->
							<div id="menu3" class="tab-pane fade"></div>
						</div>
					</div>
				</div>
		
				<!-- 선택된 나라 리스트 -->
				<div class="col-sm-1" style="height: 100%;" >
					<div id="countries" style="width: 100%; height: 100%;">
						<c:forEach items="${ selectedCountryList }" var="selectedCountry">
							<div style="border-radius:6px;" class="selectedCountry" id="countryNameIs${ selectedCountry.countryName }">${ selectedCountry.countryName }</div>
						</c:forEach>
					</div>
				</div>
			</div>
		
			<!-- 두번째 열 -->
			<div id="secondRowDiv" class="row">
		
				<!-- 여행지 임시 리스트 -->
		
				<div id="tempPlaceList" class="col-sm-8">
		
					<!-- 여행지 상세보기 페이지 -->
		
					<div class="placeDetail" data-toggle="modal" data-target="#myModal">KOREA</div>
		
					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="divHeader">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
		
								<div class="divBody">
		
									<div class="travelImage">
										<h4 class="modal-title">travel image</h4>
									</div>
		
									<div class="travelExplain">
										<div class="modal-header">
											<h2 class="modal-title">travelTitle</h2>
										</div>
										<div class="modal-header" style="height: 50%;">
											<h4 class="modal-title">travelDescript</h4>
										</div>
										<div class="modal-header" style="height: 40%;">
											<h4 class="modal-title">travelReply</h4>
											<div id="writeReply">
												<div style="float: left; width: 70%;">
													<textarea id="description" name="description"
														style="width: 500px; height: 47px;"></textarea>
												</div>
												<div style="float: left;">
													<button type="button" class="btn btn-info btn-lg">댓글등록</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
		
				<!-- 기준 선택 -->
				<div id="selectStandardBtns" class="col-sm-2" style="height: 100%;">
		
					<!-- Drop Down : X 축 -->
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">X - Axis
						<span class="caret"></span></button>
						<ul class="dropdown-menu">
							<li><a class="axisX">Bright-Dark</a></li>
							<li><a class="axisX">HighPrice-LowPrice</a></li>
							<li><a class="axisX">Active-Calm</a></li>
						</ul>
					</div>
					<br />
					<!-- Drop Down : Y 축 -->
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Y - Axis
						<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a class="axisY">Bright-Dark</a></li>
							<li><a class="axisY">HighPrice-LowPrice</a></li>
							<li><a class="axisY">Active-Calm</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>



