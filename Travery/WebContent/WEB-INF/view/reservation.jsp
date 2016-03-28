<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/sidebar.jsp" flush="false" />
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="resource/css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travery</title>
</head>
<script type="text/javascript"	src="/Travery/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<body>

<div id='map' style='width:930px; height:500px;'><br></div>
<script type='text/javascript'>
	var map = new google.maps.Map(document.getElementById("map"), {
		zoom: 12,
		center: new google.maps.LatLng(37.564615,126.98420299999998),
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	google.maps.event.addListener(map, 'click', function(mouseEvent) {
		getAddress(mouseEvent.latLng);
	});

	function getAddress(latlng) {
		var geocoder = new google.maps.Geocoder();
		geocoder.geocode({
			latLng: latlng
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0].geometry) {
					var address = results[0].formatted_address.replace(/^日本, /, '');
					new google.maps.InfoWindow({
						content: address + "<br>(Lat, Lng) = " + latlng
					}).open(map, new google.maps.Marker({
						position: latlng,
						map: map
					}));
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
</script>


</body>
</html>




