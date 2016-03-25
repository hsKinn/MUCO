<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeInfoCreate.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resource/js/snap.js" />"></script>
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
<script type="text/javascript">



	$(document).ready(function() {
		
		$("#mapBtn").click(function openMap() {
			url = "<c:url value="/placeInfoAddAddress"/>";
			window.open(url, "GoogleMapAPI", "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizeable=no, width=1000, height=800");
		});
		
		function Mapdata() {
			GoogleMapAPI.document.dataform.lat;
			GoogleMapAPI.document.dataform.lng;
			GoogleMapAPI.document.dataform.address;
		}
		

	  

		
		
		<c:if test="${ empty placeInfo }">
		$("#submitBtn").click( function() {
			var form = $("#createForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoCreateAction"/>");
			form.submit();
		});
		</c:if>
	});
</script>


<div id="placeInfoCreate_Wrapper">

	<div id="placeInfoCreate_title">여행지 등록하기</div>
	
	<form id="dataForm" name="dataform" enctype="multipart/form-data">
	
		<div id="placeInfoCreate_searchMap">
			<img src="<c:url value="/resource/img/place/btn-map.png" />" id="mapBtn" onclick="openMap(this.form)" />
			<input type="text" id="address" name="address" placeholder="#address" />
			<input type="text" id="lat" name="lat" placeholder="#latitude" />
			<input type="text" id="lng" name="lng" placeholder="#longitude" />
		</div>
		
		<div id="placeInfoCreate_imageUpload">
			<img src="<c:url value="/resource/img/place/btn-image.png" />" />
			
			
			
		function fileCheck(obj) {
			document.getElementById('update_image_view').innerHTML = "<img src='" + obj + "'>";
			}
		function Preview(Obj,previewer){
			if(/(\.gif|\.jpg|\.jpeg)$/i.test(Obj.value)==false){
			alert("이미지 파일이 아닙니다. 이미지 파일을 선택하십시오");
			return;
			}	
			
			
			
			
			<input type="file" name="file" onchange="fileCheck(this.value);" />
			<table>
 <tr>
  <td align="center" id='update_image_view'>
   미리보기
  </td>
 </tr>
</table> 
				
				
				
				
				
				
				
				
				하단 이미지보여주기
		</div>
		<div id="placeInfoCreate_description">		
		<textarea id="description" name="description">${ placeInfo.description }</textarea>	
		</div>
		<div id="placeInfoCreate_submitBtn">
			<c:if test="${ empty placeInfo }">
					<img src="<c:url value="/resource/img/place/btn-submit.png" />" id="submitBtn"/>
			</c:if>
				SUBMIT [IMG5]
		</div>
	</form>
</div>







<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>