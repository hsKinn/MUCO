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
	
<<<<<<< HEAD
	$("#myPackMenu").mouseout(function(){
		$("#myPackMenu").css("color", "#ffffff");
	});
	$("#myPackMenu").css("color", "#ffffff");
	
	$(".pack").click(function(){
	    $("#placesOfPackListdiv").fadeToggle("slow");
	
	    $.post(
				"/packInfo"
				, {"packId" : "${packs.packId}"}	
				, function(data){
											
					var jsonData = {};
					try {
						jsonData = JSON.parse(data);
					}catch(e) {
						jsonData.result = false;
					}
					console.log(jsonData);
					
					/*처리부분*/
					if ( jsonData.result ){
						var text = $("#favorite").text();
						if (jsonData.isFavorite){
							$("#favorite").text("♥");
						}
						else if (text == "♥"){
								$("#favorite").text("♡");
						} 
					}
					else {
						/* alert("세션이 만료되었습니다. 다시 로그인해주세요.");
						location.href = "/"; */
					}
				}
		);
	
	
	});

=======
>>>>>>> origin/KGM
});
</script>

<body>
	<div id="packListdiv">
	<table id="packListTable" border="2">
			<c:forEach items="${ packs}" var="packs">
			<tr>
			  <td class="pack">
			  	<img src="<c:url value="/resource/img/pack/folder.png"/>" id="folderImg" />  ${packs.packTitle}  <span class="badge">10</span>
			  </td>
			</tr>
			</c:forEach>
	</table>
	</div>
	<div id="packListdiv2">
		<div id="placesOfPackListdiv">
			하이루 
		</div>
	</div>
</body>

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>