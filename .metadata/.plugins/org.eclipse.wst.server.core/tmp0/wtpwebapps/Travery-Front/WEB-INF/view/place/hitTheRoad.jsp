<!-- 김광민 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- jVector Map -->
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
				$.post(
						"<c:url value="/selectedCountry"/>"
						, { "selectedCountryName" : map.getRegionName(code) }
						, function(data) {
							var jsonData = {};
							try {
								jsonData = JSON.parse(data);
							}
							catch (e) {
									console.log(e);
									jsonData.result = false;
							}
							
							if (jsonData.result) {
								if (jsonData.isExistCountry) {
									$('#countries').append('<div class="selectedCountry" id= "' + map.getRegionName(code) + '">' + map.getRegionName(code) + '</div>');
								} else {
									$('#'+ map.getRegionName(code)).remove();

								}
							} else {
								alert("세션이 만료되었습니다. 다시 로그인해주세요.");
								location.href = "<c:url value="/"/>"
							}
						}
				);
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

		$("#hitTheRoadMenu").mouseout(function() {
			$("#hitTheRoadMenu").css("color", "#ffffff");
		});
		$("#hitTheRoadMenu").css("color", "#ffffff");
			
		$(".tapMenu").click(function(){
	   		$(".placeDetail").css({ "display" : "block" });
	   		$(".dropdown").css({ "display" : "block" });
	  	});
	   	$(".active").click(function(){
	   	  	$(".placeDetail").css({ "display" : "none" });
	   	  	$(".dropdown").css({ "display" : "none" });
	   	});
	   	
		// X 축
		$(".axisX").click(function(){
			
			$.post(
					"<c:url value="/selectedStandard"/>"
					, { "selectedStandard" : "X", "selectedStandardName" : $(this).text() }
					, function(data) {
						var jsonData = {};
						try {
							jsonData = JSON.parse(data);
						}
						catch (e) {
								console.log(e);
								jsonData.result = false;
						}
						
						if (jsonData.result) {
							if (jsonData.isChangedStandard) {
								$("#printAxisX1").text( jsonData.firstStandard );
								$("#printAxisX2").text( jsonData.secondStandard );
							}
						} else {
							alert("세션이 만료되었습니다. 다시 로그인해주세요.");
							location.href = "<c:url value="/"/>"
						}
					}
			);
		});
	
		// Y 축
		$(".axisY").click(function(){
			
			$.post(
					"<c:url value="/selectedStandard"/>"
					, { "selectedStandard" : "Y", "selectedStandardName" : $(this).text() }
					, function(data) {
						var jsonData = {};
						try {
							jsonData = JSON.parse(data);
						}
						catch (e) {
								console.log(e);
								jsonData.result = false;
						}
						
						if (jsonData.result) {
							if (jsonData.isChangedStandard) {
								$("#printAxisY1").text( jsonData.firstStandard );
								$("#printAxisY2").text( jsonData.secondStandard );
							}
						} else {
							alert("세션이 만료되었습니다. 다시 로그인해주세요.");
							location.href = "<c:url value="/"/>"
						}
					}
			);
		});
	});
</script>

<!-- Hit the road -->
<div id="hitTheRoad">

	<!-- 첫번째 열 -->
	<div id="firstRow" class="row">

		<!-- 나라 선택, 여행지 검색, 나의 패키지, 경로설정 -->
		<div class="col-sm-8" style="height: 100%;">
			<div id="firstContainer" class="container">

				<!-- 탭 -->
				<ul class="nav nav-pills">
					<li class="active"><a data-toggle="pill" href="#home">나라 선택</a></li>
					<li id="searchPlaces" class="tapMenu"><a data-toggle="pill" href="#menu1">여행지 검색</a></li>
					<li class="tapMenu"><a data-toggle="pill" href="#menu2">나의 패키지</a></li>
					<li class="tapMenu"><a data-toggle="pill" href="#menu3">경로 설정</a></li>
				</ul>

				<!-- 탭 내용 -->
				<div class="tab-content">

					<!-- 나라 선택 탭 -->
					<div id="home" class="tab-pane fade in active">

						<!-- 지도 -->
						<div id="map1" style="width: 100%; height: 95%;"></div>

						<button id="focus-multiple" >한국과 일본</button>
						<button id="focus-init" >세계지도 보기</button>
					</div>

					<!-- 여행지 검색 탭 -->
					<c:set var="axisX1" value="${ sessionScope._MEMBER_.selectedStandardList.get(0) }" />
					<c:set var="axisX2" value="${ sessionScope._MEMBER_.selectedStandardList.get(1) }" />
					<c:set var="axisY1" value="${ sessionScope._MEMBER_.selectedStandardList.get(2) }" />
					<c:set var="axisY2" value="${ sessionScope._MEMBER_.selectedStandardList.get(3) }" />
					
					<div id="menu1" class="tab-pane fade">
						<div class="row">
							<div id="printAxisY1">${ axisY1 }</div>
						</div>
						<div class="row" style="height: 350px;">
							<div id="printAxisX2" class="col-sm-1">${ axisX2 }</div>
							
							<!-- 점 찍는 곳 -->
							<div id="dottedDiv" class="col-sm-10">
								<div id="map2" style="width: 100%; height: 100%;"></div>
							</div>
							
							<div id="printAxisX1" class="col-sm-1">${ axisX1 }</div>
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
			<div id="countries" style="width: 100%; height: 100%;"></div>
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
			<div class="dropdown" style="float: left;">
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">X 축
				<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a class="axisX">Bright-Dark</a></li>
					<li><a class="axisX">HighPrice-LowPrice</a></li>
					<li><a class="axisX">Active-Calm</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<br />
			<!-- Drop Down : Y 축 -->
			<div class="dropdown" style="float: left;">
				<button class="btn btn-default dropdown-toggle" type="button"
					data-toggle="dropdown">Y 축 <span class="caret"></span>
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

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>



