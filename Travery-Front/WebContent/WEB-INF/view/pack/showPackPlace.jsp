<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- My Package -->
<script type="text/javascript">

	$(document).ready(function() {

		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");

		$("#myPackMenu").css("color", "#ffffff");

		$(".pack").click(function() {
			$("#placesOfPackListdiv").hide();
			$("#placesOfPackListdiv").fadeIn("slow");
			var packId = $(this).children(":eq(2)").val();
			location.href = "/showPackPlace?packId=" + packId;
			$("/packId").val(packId);
		});

		$(".submitLabel").click(function() {

			var form = $(".deletePlaceOfPackForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/deletePlaceOfPack"/>");
			form.submit();

		});

		$(".pack").click(function() {
			$("#placesOfPackListdiv").fadeOut();
			$("#placesOfPackListdiv").fadeIn("slow");

			var packId = $(this).children(":eq(2)").val();
			location.href = "/showPackPlace?packId=" + packId;

		});

		$(".switch").click(function() {
			alert();
		});

	});
</script>

<body>
	<div id="wrapperdiv">
		<div id="packListdiv">
			<table id="packListTable" border="2">
					<c:forEach items="${packs}" var="packs">
					<tr>
					  <td class="pack" >
					  	<img src="<c:url value="/resource/img/pack/folder.png"/>" id="folderImg" /> 
						<label id="title" for="packData_Title" style="font-size:20px; display: inline;">${packs.packTitle}</label>
					  	<input type="hidden" id="packId" value="${packs.packId}"/>
					  </td>
					</tr>
					</c:forEach>
			</table>
		</div>
		<div id="buttondiv">
			<a href="/detailPack"><span class="glyphicon glyphicon-cog"></span></a>
		</div>
	</div>
	
	<div id="packListdiv2">
		<div id="placesOfPackListdiv">			
			<table id="placeListTable" border="2">
			<c:forEach items="${places}" var="places">
			<tr width="200px">
			  <td class="place" >
			  	<p id="title"  style="display: inline;"> ${places.placeName}</p> 
			  	<form class="deletePlaceOfPackForm" style="display: inline;">
					<label class="submitLabel" >
					  	<span class="glyphicon glyphicon-remove" style="font-size:20px; cursor: pointer;"></span>
					 	<input type="hidden" class="placeId" name="placeId" value="${places.placeId}"/>
					 	<input type="hidden" class="packId" name="packId" value="${packId}"/>
						<input type="submit" style="display: none"/>
					</label>
			 	</form>
			  </td>
			</tr>
			</c:forEach>
			</table>
			
		</div>	
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>