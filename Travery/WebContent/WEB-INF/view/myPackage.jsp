<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/sidebar.jsp" flush="false" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="/Travery/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">

var contentArray = [];
var iConArray = [];
var markers = [];
var iterator = 0;
var markerArray = [];
var map;

// infowindow contents 배열
 contentArray[0] = "Kay";
 contentArray[1] = "uhoons blog";
 contentArray[2] = "www.uhoon.co.kr";
 contentArray[3] = "www.uhoon.co.kr ";
 contentArray[4] = "www.uhoon.co.kr";
 contentArray[5] = "www.goodkiss.co.kr";
 contentArray[6] = "GG";
 contentArray[7] = "www.goodkiss.co.kr";
 contentArray[8] = "II";
 contentArray[9] = "www.goodkiss.co.kr";

// marker icon 배열
 iConArray[0] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[1] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[2] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[3] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[4] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[5] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[6] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[7] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[8] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";
 iConArray[9] = "http://google-maps-icons.googlecode.com/files/walking-tour.png";

// 위경도 배열 + (갱신날짜 + 위치정보)
/*
var markerArray = [ new google.maps.LatLng(40.3938,-3.7077)
, new google.maps.LatLng(40.45038,-3.69803)
, new google.maps.LatLng(40.45848,-3.69477)
, new google.maps.LatLng(40.40672,-3.68327)
, new google.maps.LatLng(40.43672,-3.62093)
, new google.maps.LatLng(40.46725,-3.67443)
, new google.maps.LatLng(40.43794,-3.67228)
, new google.maps.LatLng(40.46212,-3.69166)
, new google.maps.LatLng(40.41926,-3.70445)
, new google.maps.LatLng(40.42533,-3.6844)
];
*/

markerArray[0] = new google.maps.LatLng(40.3938,-3.7077);
markerArray[1] = new google.maps.LatLng(40.45038,-3.69803);
markerArray[2] = new google.maps.LatLng(40.45848,-3.69477);
markerArray[3] = new google.maps.LatLng(40.40672,-3.68327);
markerArray[4] = new google.maps.LatLng(40.43672,-3.62093);
markerArray[5] = new google.maps.LatLng(40.46725,-3.67443);
markerArray[6] = new google.maps.LatLng(40.43794,-3.67228);
markerArray[7] = new google.maps.LatLng(40.46212,-3.69166);
markerArray[8] = new google.maps.LatLng(40.41926,-3.70445);
markerArray[9] = new google.maps.LatLng(40.42533,-3.6844);

function initialize() {
	var mapOptions = {
		zoom: 11,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		center: new google.maps.LatLng(40.4167754,-3.7037901999999576)
	};

	map = new google.maps.Map(document.getElementById('map'),mapOptions);

	for (var i = 0; i < markerArray.length; i++) {
		addMarker();
	}
}


// 마커 추가
function addMarker() {

	var marker = new google.maps.Marker({
		position: markerArray[iterator],
		map: map,
		draggable: false,
		icon: iConArray[iterator]
	});
	markers.push(marker);

	var infowindow = new google.maps.InfoWindow({
      content: contentArray[iterator]
	});

	google.maps.event.addListener(marker, 'click', function() {
		infowindow.open(map,marker);
	});
	iterator++;
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
${ myPackage.address }
<c:forEach items="${ articles.articleList }" var="pack">
			<tr>
				<td>${ art.articleId }</td>
				<td  colspan="2"><a href="/detail?articleId=${art.articleId}"> ${ art.title }
				</a> <c:if test="${art.fileCount gt 0 }">
				[${art.fileCount} each files included]
			</c:if></td>
				<td>${ art.nickName }</td>
				<td>${ art.hits }</td>
				<td>${ art.recommends }</td>
			</tr>
		</c:forEach>


var markerArray = [ new google.maps.LatLng(40.3938,-3.7077) ];


        <c:forEach items="${myPackage}" var="pack">
                (${pack.latitude},${pack.longitude})
        </c:forEach>


var markerArray[] = new google.maps.LatLng(40.3938,-3.7077) ;
(${ myPackage.latitude }, ${ myPackage.longitude })


<div id="map" style="width:760px;height:400px;margin-top:20px;"></div>
</body>
</html>