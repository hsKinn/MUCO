<!-- 김동규 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeInfoMap.css"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travery</title>
<script type="text/javascript"
	src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
 		var countryId = $("#countryId option:selected").val();
		if ( countryId == undefined ) {
			alert("choose the country.");
			$("#countryId").fadeOut().fadeIn().fadeOut().fadeIn();
			return;
		}
		
		$("#mapData").click(function mapData() {
			window.opener.dataform.lat.value = $("#lat").val();
			window.opener.dataform.lng.value = $("#lng").val();
			window.opener.dataform.address.value = $("#address").val();
			window.opener.dataform.countryId.value = $("#countryId").val();
			self.close();
		});		
	});
</script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDuLfX3hC4iBa4XL588g7cB2OCHhPpjuy8&libraries=geometry,places&language=en">
	
</script>
<!-- <script type="text/javascript"	src="http://maps.google.com/maps/api/js?sensor=false"></script> -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var latlng = new google.maps.LatLng(37.566666,
								126.966667); //위도 , 경도 (원하는 위치를 기본으로 지정가능);
						var myOptions = {
							zoom : 4,
							center : latlng,
							mapTypeControl : true,
							mapTypeControlOptions : {
								style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
							},
							mapTypeId : google.maps.MapTypeId.ROADMAP
						} // 변수 myoptions에 맵 생성시에 필요한 원하는 기능을 지정 / zoom 1 = 세계지도단위 / 15 = 지도 300m단위 / center = 위도경도를 기준으로 기준점잡기 / mapTypeId 4종류의 맵 타입중 하나 지정
						var map = new google.maps.Map(document
								.getElementById("map_canvas"), myOptions); // 맵생성시 필요한 변수
						var marker = new google.maps.Marker({
							position : latlng,
							map : map
						}); // 마커기능 /  포지션에 위도 경도가 있어야 지정가능 / (포지션 : 위도경도) 에서 맵에서 맵으로 마커를 지정한다는 부분 default로 있어야함

						// Create the search box and link it to the UI element.
						var input = document.getElementById('pac-input');
						var searchBox = new google.maps.places.SearchBox(input);
						map.controls[google.maps.ControlPosition.TOP_LEFT]
								.push(input);

						// Bias the SearchBox results towards current map's viewport.
						map.addListener('bounds_changed', function() {
							searchBox.setBounds(map.getBounds());
						});

						// Listen for the event fired when the user selects a prediction and retrieve
						// more details for that place.
						searchBox.addListener('places_changed', function() {
							var places = searchBox.getPlaces();
							if (places.length == 0) {
								return;
							}

							// For each place, get the icon, name and location.
							var bounds = new google.maps.LatLngBounds();
							places.forEach(function(place) {
								var icon = {
									url : place.icon,
									size : new google.maps.Size(71, 71),
									origin : new google.maps.Point(0, 0),
									anchor : new google.maps.Point(17, 34),
									scaledSize : new google.maps.Size(25, 25)
								};

								if (place.geometry.viewport) {
									// Only geocodes have viewport.
									bounds.union(place.geometry.viewport);
								} else {
									bounds.extend(place.geometry.location);
								}
							});
							map.fitBounds(bounds);
						});

						var geocoder = new google.maps.Geocoder(); // 위도, 경도를 이용한 전환으로 어드레스 를 불러올 떄 필요
						// addListener 는 자바스크립트의 이벤트 핸들러를 정의한 것으로 특정 이벤트가 발생했을 때 등록,불러오기,전달 등을 실행 한다.

						google.maps.event
								.addListener(
										map,
										'click',
										function(event) {
											var location = event.latLng;
											geocoder
													.geocode(
															{
																'latLng' : location
															},
															function(results,
																	status) {
																if (status == google.maps.GeocoderStatus.OK) {
																	$(
																			'#address')
																			.val(
																					results[0].formatted_address);
																	$('#lat')
																			.val(
																					results[0].geometry.location
																							.lat());
																	$('#lng')
																			.val(
																					results[0].geometry.location
																							.lng());
																} else {
																	alert("Geocoder Failed Due to : "
																			+ status);
																}
															}); // 맵에서 클릭을 실행했을 때 기능이 실행이되고, 위도경도를 기점으로 옳바른 위도경도를 받았을때 상태와 결과를 어드레스,위도,경도 로 각각 값으로 전달한다. 틀렸을 시에 값을 못받았다는 내용을 경고문 출력.
											// formatted_address : String 형태의 사람이 읽는 주소값 / geometry.location.lat() : -90,90 / geometry.location.lng() : -180, 180
											if (!marker) {
												marker = new google.maps.Marker(
														{
															position : location,
															map : map
														});
											} else {
												marker.setMap(null);
												marker = new google.maps.Marker(
														{
															position : location,
															map : map
														});
											}
											map.setCenter(location);
										});

						$("#lat")
								.focusout(
										function() {
											var lat = $(this).val();
											if (lat != '') {
												geocoder
														.geocode(
																{
																	'lat' : lat
																},
																function(
																		results,
																		status) {
																	if (status == google.maps.GeocoderStatus.OK) {
																		$(
																				'#lat')
																				.html(
																						results[0].geometry.location
																								.lat());
																		map
																				.setCenter(results[0].geometry.location);
																		if (!marker) {
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		} else {
																			marker
																					.setMap(null);
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		}
																	} else {
																		alert("Geocoder Failed Due To : "
																				+ status);
																	}
																});
											}
										}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lat에 출력해주는 부분
						$("#lng")
								.focusout(
										function() {
											var lng = $(this).val();
											if (lng != '') {
												geocoder
														.geocode(
																{
																	'lng' : lng
																},
																function(
																		results,
																		status) {
																	if (status == google.maps.GeocoderStatus.OK) {
																		$(
																				'#lng')
																				.html(
																						results[0].geometry.location
																								.lng());
																		map
																				.setCenter(results[0].geometry.location);
																		if (!marker) {
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		} else {
																			marker
																					.setMap(null);
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		}
																	} else {
																		alert("Geocoder Failed Due To : "
																				+ status);
																	}
																});
											}
										}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lng에 출력해주는 부분

						$("#address")
								.focusout(
										function() {
											var address = $(this).val();
											if (address != '') {
												geocoder
														.geocode(
																{
																	'address' : address
																},
																function(
																		results,
																		status) {
																	if (status == google.maps.GeocoderStatus.OK) {
																		$(
																				'#lat')
																				.html(
																						results[0].geometry.location
																								.lat());
																		$(
																				'#lng')
																				.html(
																						results[0].geometry.location
																								.lng());
																		map
																				.setCenter(results[0].geometry.location);
																		if (!marker) {
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		} else {
																			marker
																					.setMap(null);
																			marker = new google.maps.Marker(
																					{
																						position : results[0].geometry.location,
																						map : map
																					});
																		}
																	} else {
																		alert("Geocoder Failed Due To : "
																				+ status);
																	}
																});
											}
										}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #address에 출력해주는 부분
					});
</script>
</head>
<body>
	<input id="pac-input" class="controls" type="text"
		placeholder="Search Box" />
	<form id="dataform">
		<table border="1" align="right" id="SelectMap">
			<tr>
				<td colspan="4"><div id="map_canvas"></div> <input
					type="hidden" id="lat" name="lat" size="50" /> 
					<input type="hidden" id="lng" name="lng" size="50" />
				</td>
			</tr>
			<tr>
				<th width="100">주소</th>
				<td><input type="text" id="address" name="address" size="50" /></td>
				<th width="100">나라선택</th>
				<td><select id="countryId" name="countryId" style="color: #333333; size: 30;">
						<c:forEach items="${ countryList }" var="selectPlace">
							<option value="${ selectPlace.countryId }">${ selectPlace.countryName }</option>
						</c:forEach>
				</select>
				<input type="button" id="mapData" value="submit" onclick="mapData();" style="float: right;" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>