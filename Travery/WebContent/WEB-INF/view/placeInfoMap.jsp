<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/sidebar.jsp" flush="false" />
<!DOCTYPE>
<html>
<head>
<style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map_canvas {
        height: 100%;
        width: 800px; 
        height: 600px;
      }
      .controls {
        margin-top: 10px;
        border: 1px solid transparent;
        border-radius: 2px 0 0 2px;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        height: 32px;
        outline: none;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
      }

      #pac-input {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        /* margin-top:570px; */
        padding: 0 11px 0 13px;
        text-overflow: ellipsis;
        width: 300px;
      }

      #pac-input:focus {
        border-color: #4d90fe;
      }

      .pac-container {
        font-family: Roboto;
      }

      #type-selector {
        color: #fff;
        background-color: #4d90fe;
        padding: 5px 11px 0px 11px;
      }

      #type-selector label {
        font-family: Roboto;
        font-size: 13px;
        font-weight: 300;
      }
      #target {
        width: 345px;
      }
    </style>

<link rel="stylesheet" href="resource/css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travery</title>
<script type="text/javascript"	src="/Travery/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#addNewPlace").click(function() {
			var form = $("#addNewPlaceForm");
			form.attr("method", "post");
			form.attr("action", "/Travery/addNewPlace");
			form.submit();
		});
	});
</script>
<script type="text/javascript"
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDuLfX3hC4iBa4XL588g7cB2OCHhPpjuy8&libraries=geometry,places">
</script>
<!-- <script type="text/javascript"	src="http://maps.google.com/maps/api/js?sensor=false"></script> -->
<script type="text/javascript">
	$(document).ready( function() {
		var latlng = new google.maps.LatLng(37.566666, 126.966667); //위도 , 경도 (원하는 위치를 기본으로 지정가능);
		var myOptions = {
							zoom : 4,
							center : latlng,
							mapTypeControl:true,
							  mapTypeControlOptions: {
							      style:google.maps.MapTypeControlStyle.DROPDOWN_MENU
							    },
							mapTypeId : google.maps.MapTypeId.ROADMAP
						} // 변수 myoptions에 맵 생성시에 필요한 원하는 기능을 지정 / zoom 1 = 세계지도단위 / 15 = 지도 300m단위 / center = 위도경도를 기준으로 기준점잡기 / mapTypeId 4종류의 맵 타입중 하나 지정
		var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions); // 맵생성시 필요한 변수
		var marker = new google.maps.Marker({
							position : latlng,
							map : map
						}); // 마커기능 /  포지션에 위도 경도가 있어야 지정가능 / (포지션 : 위도경도) 에서 맵에서 맵으로 마커를 지정한다는 부분 default로 있어야함

		 // Create the search box and link it to the UI element.
		var input = document.getElementById('pac-input');
		var searchBox = new google.maps.places.SearchBox(input);
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

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
							url: place.icon,
							size: new google.maps.Size(71, 71),
							origin: new google.maps.Point(0, 0),
						 	anchor: new google.maps.Point(17, 34),
							scaledSize: new google.maps.Size(25, 25)
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
		
		google.maps.event.addListener(	map, 'click', function(event) {
			var location = event.latLng;
			geocoder.geocode({	'latLng' : location	},	function( results, status ) {
				if (status == google.maps.GeocoderStatus.OK) {
					$('#address').val(	results[0].formatted_address);
					$('#lat').val(	results[0].geometry.location.lat());
					$('#lng').val(	results[0].geometry.location.lng());
				} else if (status == google.maps.GeocoderStatus.ERROR) {
					alert("통신중 에러발생！");
				} else if (status == google.maps.GeocoderStatus.INVALID_REQUEST) {
					alert("요청에 문제발생！geocode()에 전달하는GeocoderRequest확인요！");
				} else if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
					alert("단시간에 쿼리 과다송신！");
				} else if (status == google.maps.GeocoderStatus.REQUEST_DENIED) {
					alert("이 페이지에는 지오코더 이용 불가! 왜??");
				} else if (status == google.maps.GeocoderStatus.UNKNOWN_ERROR) {
					alert("서버에 문제가 발생한거 같아요. 다시 한번 해보세요.");
				} else if (status == google.maps.GeocoderStatus.ZERO_RESULTS) {
					alert("존재하지 않습니다.");
				} else {
					alert("Geocoder Failed Due To : " + status );
				}
			}); // 맵에서 클릭을 실행했을 때 기능이 실행이되고, 위도경도를 기점으로 옳바른 위도경도를 받았을때 상태와 결과를 어드레스,위도,경도 로 각각 값으로 전달한다. 틀렸을 시에 값을 못받았다는 내용을 경고문 출력.
					// formatted_address : String 형태의 사람이 읽는 주소값 / geometry.location.lat() : -90,90 / geometry.location.lng() : -180, 180
			if (!marker) {
				marker = new google.maps.Marker({
					position : location,
					map : map
				});
			} else {
				marker.setMap(null);
				marker = new google.maps.Marker({
					position : location,
					map : map
				});
			}
			map.setCenter(location);
		});

		$("#lat").focusout(	function() {
			var lat = $(this).val();
			if (lat != '') {
				geocoder.geocode({	'lat' : lat	}, function( results, status ) {
					if (status == google.maps.GeocoderStatus.OK) {
						$('#lat').html(results[0].geometry.location.lat());
						map.setCenter(results[0].geometry.location);
						if (!marker) {
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
							});
						} else {
							marker.setMap(null);
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
							});
						}
					} else if (status == google.maps.GeocoderStatus.ERROR) {
						alert("통신중 에러발생！");
					} else if (status == google.maps.GeocoderStatus.INVALID_REQUEST) {
						alert("요청에 문제발생！geocode()에 전달하는GeocoderRequest확인요！");
					} else if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
						alert("단시간에 쿼리 과다송신！");
					} else if (status == google.maps.GeocoderStatus.REQUEST_DENIED) {
						alert("이 페이지에는 지오코더 이용 불가! 왜??");
					} else if (status == google.maps.GeocoderStatus.UNKNOWN_ERROR) {
						alert("서버에 문제가 발생한거 같아요. 다시 한번 해보세요.");
					} else if (status == google.maps.GeocoderStatus.ZERO_RESULTS) {
						alert("존재하지 않습니다.");
					} else {
						alert("Geocoder Failed Due To : " + status );
					}
				});
			}
		}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lat에 출력해주는 부분
		$("#lng").focusout(	function() {
			var lng = $(this).val();
			if (lng != '') {
				geocoder.geocode({'lng' : lng }, function( results, status ) {
					if (status == google.maps.GeocoderStatus.OK) {
						$('#lng').html(results[0].geometry.location.lng());
						map.setCenter(results[0].geometry.location);
						if (!marker) {
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
							});
						} else {
							marker.setMap(null);
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
								});
							}
					} else if (status == google.maps.GeocoderStatus.ERROR) {
						alert("통신중 에러발생！");
					} else if (status == google.maps.GeocoderStatus.INVALID_REQUEST) {
						alert("요청에 문제발생！geocode()에 전달하는GeocoderRequest확인요！");
					} else if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
						alert("단시간에 쿼리 과다송신！");
					} else if (status == google.maps.GeocoderStatus.REQUEST_DENIED) {
						alert("이 페이지에는 지오코더 이용 불가! 왜??");
					} else if (status == google.maps.GeocoderStatus.UNKNOWN_ERROR) {
						alert("서버에 문제가 발생한거 같아요. 다시 한번 해보세요.");
					} else if (status == google.maps.GeocoderStatus.ZERO_RESULTS) {
						alert("존재하지 않습니다.");
					} else {
						alert("Geocoder Failed Due To : " + status );
					}
				});
			}
		}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lng에 출력해주는 부분

		$("#address").focusout(	function() {
			var address = $(this).val();
			if (address != '') {
				geocoder.geocode({ 'address' : address }, function( results, status ) {
					if (status == google.maps.GeocoderStatus.OK) {
						$('#lat').html(results[0].geometry.location.lat());
						$('#lng').html(results[0].geometry.location.lng());
						map.setCenter(results[0].geometry.location);
						if (!marker) {
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
								});
						} else {
							marker.setMap(null);
							marker = new google.maps.Marker({
								position : results[0].geometry.location,
								map : map
							});
						}
					} else if (status == google.maps.GeocoderStatus.ERROR) {
						alert("통신중 에러발생！");
					} else if (status == google.maps.GeocoderStatus.INVALID_REQUEST) {
						alert("요청에 문제발생！geocode()에 전달하는GeocoderRequest확인요！");
					} else if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
						alert("단시간에 쿼리 과다송신！");
					} else if (status == google.maps.GeocoderStatus.REQUEST_DENIED) {
						alert("이 페이지에는 지오코더 이용 불가! 왜??");
					} else if (status == google.maps.GeocoderStatus.UNKNOWN_ERROR) {
						alert("서버에 문제가 발생한거 같아요. 다시 한번 해보세요.");
					} else if (status == google.maps.GeocoderStatus.ZERO_RESULTS) {
						alert("존재하지 않습니다.");
					} else {
						alert("Geocoder Failed Due To : " + status );
					}
				});
			}
		}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #address에 출력해주는 부분
	});
</script>
</head>
<body>
	New Place
	
	<input id="pac-input" class="controls" type="text" placeholder="Search Box" />
	<form id="addNewPlaceForm">
		<table border="1" align="right" id="SelectMap">
			<tr>
				<td colspan="2"><div id="map_canvas"></div></td>
			</tr>
			<tr>
				<th width="100">위도</th>
				<td><input type="text" id="lat" name="lat" value="" size="50" /></td>
			</tr>
			<tr>
				<th width="100">경도</th>
				<td><input type="text" id="lng" name="lng" value="" size="50" /></td>
			</tr>
			<tr>
				<th width="100">주소</th>
				<td><input type="text" id="address" name="address" size="50" /></td>
			</tr>
		</table>
		<div style="float: right;">
			<input type="button" id="addNewPlace" value="submit" /></div>
	</form>
</body>
</html>