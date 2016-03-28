<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/sidebar.jsp" flush="false" />
<!DOCTYPE html>
<html>

<head>
	<title>위치기반 지역정보 검색</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resource/js/json2.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnIdCheck").click(function() {
			if ( document.registForm.nickName.value == "" ) {
				alert("ID란에 공백이있습니다.");
				return false;
			}
			$.post(
					"/admin/idDuplicationCheck"
					, {
						"nickName" : $("#nickName").val()
						}
					//callback구간을 달아줘야함. 응답데이터도 우리가 직접 적어줘야함. 성공여부는 확인불가.
					, function(data) {
											
						var jsonData = {};
						
						try {
							jsonData = JSON.parse(data);
						}
						catch(e) {
							jsonData.result = false;
						}
						
						/* console.log(jsonData); */
																
						if ( jsonData.result ) {
							if ( jsonData.checkData ) {
								alert("중복된아이디입니다.");
								$("#nickName").val();
							} else {
								alert("사용가능한 아이디입니다.");
								var answer = confirm('사용하시겠습니까?')
								if(answer == true){
									document.registForm.nickName.value=$("#nickName").val();
								}
								else {
									$("#nickName").empty();
								}							
							}
						}/* 
						else {
							alert("세션만료. 재로그인필요.");
							location.href = "/admin";
						} */
					});
				});
		
		$("#btnRegist").click(function() {
			
			if ( !document.registForm.nickName.value) {
				alert("ID를 입력하세요");
				return false;
			}
			if ( !document.registForm.password.value) {
				alert("PWD를 입력하세요");
				return false;
			}
			if ( document.registForm.password.value != document.registForm.checkPwd.value) {
				alert("PWD를 동일하게 입력하세요");
				return false;
			}
			if ( !document.registForm.email.value ) {
				alert("이메일을 입력하세요");
				return false;
			}
			var form = $("#registForm")
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/addNewMember" />");
			
			alert("회원가입이 완료 되었습니다.");
			form.submit();
		});
		$("#cancel").click( function() {
			var answer = confirm('정말 이동하시겠습니까?')
			if(answer == true){
				window.location = "<c:url value="/memberInformation" />";
			}
			else
				return false;
		});
	});
</script>






</head>

<body class="docs framebox_body">﻿
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>
	<script type="text/javascript">
		var map, places, iw;
		var markers = [];
		var autocomplete;

		function initialize() {
			var myLatlng = new google.maps.LatLng(37.566535, 126.97796919999996);
			var myOptions = {
				zoom: 14,
				center: myLatlng,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document.getElementById('map_canvas'), myOptions);
			places = new google.maps.places.PlacesService(map);
			google.maps.event.addListener(map, 'tilesloaded', tilesLoaded);
			autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'));
			google.maps.event.addListener(autocomplete, 'place_changed', function () {
				showSelectedPlace();
			});
		}

		function tilesLoaded() {
			google.maps.event.clearListeners(map, 'tilesloaded');
			google.maps.event.addListener(map, 'zoom_changed', search);
			google.maps.event.addListener(map, 'dragend', search);
			search();
		}

		function showSelectedPlace() {
			clearResults();
			clearMarkers();
			var place = autocomplete.getPlace();
			alert(place.geometry.location);
			map.panTo(place.geometry.location);
			markers[0] = new google.maps.Marker({
				position: place.geometry.location,
				map: map
			});
			iw = new google.maps.InfoWindow({
				content: getIWContent(place)
			});
			iw.open(map, markers[0]);
		}

		function search() {
			var type;
			for (var i = 0; i < document.controls.type.length; i++) {
				if (document.controls.type[i].checked) {
					type = document.controls.type[i].value;
				}
			}
			autocomplete.setBounds(map.getBounds());
			var search = {
				bounds: map.getBounds()
			};
			if (type != 'establishment') {
				search.types = [type];
			}
			places.search(search, function (results, status) {
				if (status == google.maps.places.PlacesServiceStatus.OK) {
					clearResults();
					clearMarkers();
					for (var i = 0; i < results.length; i++) {
						markers[i] = new google.maps.Marker({
							position: results[i].geometry.location,
							animation: google.maps.Animation.DROP
						});
						google.maps.event.addListener(markers[i], 'click', getDetails(results[i], i));
						setTimeout(dropMarker(i), i * 100);
						addResult(results[i], i);
					}
				}
			});
		}

		function clearMarkers() {
			for (var i = 0; i < markers.length; i++) {
				if (markers[i]) {
					markers[i].setMap(null);
					markers[i] == null;
				}
			}
		}

		function dropMarker(i) {
			return function () {
				markers[i].setMap(map);
			}
		}

		function addResult(result, i) {
			var results = document.getElementById('results');
			var tr = document.createElement('tr');
			tr.style.backgroundColor = (i % 2 == 0 ? '#F0F0F0' : '#FFFFFF');
			tr.onclick = function () {
				google.maps.event.trigger(markers[i], 'click');
			};
			var iconTd = document.createElement('td');
			var nameTd = document.createElement('td');
			var icon = document.createElement('img');
			icon.src = result.icon.replace('http:', '');
			icon.setAttribute('class', 'placeIcon');
			var name = document.createTextNode(result.name);
			iconTd.appendChild(icon);
			nameTd.appendChild(name);
			tr.appendChild(iconTd);
			tr.appendChild(nameTd);
			results.appendChild(tr);
		}

		function clearResults() {
			var results = document.getElementById('results');
			while (results.childNodes[0]) {
				results.removeChild(results.childNodes[0]);
			}
		}

		function getDetails(result, i) {
			return function () {
				places.getDetails({
					reference: result.reference
				}, showInfoWindow(i));
			}
		}

		function showInfoWindow(i) {
			return function (place, status) {
				if (iw) {
					iw.close();
					iw = null;
				}
				if (status == google.maps.places.PlacesServiceStatus.OK) {
					iw = new google.maps.InfoWindow({
						content: getIWContent(place)
					});
					iw.open(map, markers[i]);
				}
			}
		}

		function getIWContent(place) {
			var content = '<table style="border:0"><tr><td style="border:0;">';
			content += '<img class="placeIcon" src="' + place.icon + '"></td>';
			content += '<td style="border:0;"><b><a href="' + place.url + '">' + place.name + '</a></b>';
			content += '</td></tr></table>';
			return content;
		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
	<style type="text/css">
		html, body {
			margin: 0;
			padding: 0;
			height: 100%;
			font-family: arial;
			font-size: 13px;
			overflow: hidden;
		}
		#map_canvas {
			float: left;
			width: 820px;
			height: 406px;
		}
		#listing {
			float: left;
			margin-left: 1px;
			width: 205px;
			height: 326px;
			overflow: auto;
			cursor: pointer;
		}
		#controls {
			padding: 5px;
		}
		.placeIcon {
			width: 16px;
			height: 16px;
			margin: 2px;
		}
		#results {
			border-collapse: collapse;
			width: 184px;
		}
		#locationField {
			margin-left: 1px;
		}
		#autocomplete {
			width: 516px;
			border: 1px solid #ccc;
		}
	</style>
	<div id="locationField">
		<input id="autocomplete" type="text">
	</div>
	<div id="map_canvas"></div>
	<div id="controls">
		<form name="controls">
			<input type="radio" name="type" value="establishment" onclick="search()" checked="checked" />기관, 시설
			<br/>
			<input type="radio" name="type" value="hospital" onclick="search()" />병원
			<br/>
			<input type="radio" name="type" value="restaurant" onclick="search()" />레스토랑
			<br/>
			<input type="radio" name="type" value="subway_station" onclick="search()" />지하철
			<br/>
			<input type="radio" name="type" value="lodging" onclick="search()" />숙박업소</form>
	</div>
	<div id="listing">
		<table id="results"></table>
	</div>
</body>

</html>