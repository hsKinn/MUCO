<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- My Package -->
<script type="text/javascript">
$(document).ready(function() {	

	$("#myPackMenu").mouseout(function(){
		$("#myPackMenu").css("color", "#ffffff");
	});
	$("#myPackMenu").css("color", "#ffffff");
	
	$(".pack").click(function(){
		 $("#placesOfPackListdiv").fadeOut();
		 $("#placesOfPackListdiv").fadeIn("slow");
	  
		var packId = $(this).children(":eq(2)").val();
		
	     $.post(
			"/packInfo"
			, {"packId" : packId }	
			, function(data){
				
					var jsonData = {};
					try {
						jsonData = JSON.parse(data);
					}catch(e) {
						jsonData.result = false;
					}
					console.log(jsonData);					
	
					if ( jsonData.result ){
						
						$("#packData_Title").text(jsonData.title);
						$("#packData_IsPublic").text(jsonData.isPublic);						
						$("#packData_image").attr("src",jsonData.imageLocation);
											
					}
					else {
						/* alert("세션이 만료되었습니다. 다시 로그인해주세요.");
						location.href = "/"; */
					}
					
					
			}
		);
	
	});
	
	$(".switch").click(function(){
		alert();
	});

});
</script>

<body>
	<div id="packListdiv">
	<table id="packListTable" border="2">
			<c:forEach items="${ packs}" var="packs">
			<tr>
			  <td class="pack" >
	
			  	<img src="<c:url value="/resource/img/pack/folder.png"/>" id="folderImg" /> 
			  	<p id="title"  style="display: inline;"> ${packs.packTitle} </p> 
			  	<input type="hidden" id="packId" value="${packs.packId}"/>
			  	 <span class="badge">10</span>
			  </td>
			</tr>
			</c:forEach>
	</table>
	
	<a href="/addPack"><img src="/resource/img/pack/circledPlus.png" id="btnAdd" /></a>
	<a href="/deletePack"><img src="/resource/img/pack/circledMinus.png" id="btnDelete" /></a>
	
	</div>
	<div id="packListdiv2">
		<div id="placesOfPackListdiv">			
			<span id="packData_Title"></span><br/>
			<span id="packData_IsPublic"></span><br/>
 공개
			  <label class="switch">
				  <input type="checkbox">
				  <div class="slider round"></div>
				</label>
				<img id="packData_image" src="#" />


			수정버튼
		</div>	
	</div>
</body>

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>