<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- My Package -->
<script type="text/javascript">
<<<<<<< HEAD
	$(document).ready(function() {
=======
$(document).ready(function() {	
	
>>>>>>> origin/bjg3

		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");
<<<<<<< HEAD
=======
	});
	$("#myPackMenu").css("color", "#ffffff");
	
	$("#placesOfPackListdiv").hide();
	
	$(".pack").click(function(){
		open = false;
		 $("#placesOfPackListdiv").hide();
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
						
						$("#packData_Title").val(jsonData.title);
						$("#packData_image").attr("src",jsonData.imageLocation);
						if ( jsonData.isPublic==1){
							$("#packData_IsPublic").attr("checked",true);
						}
						else {$("#packData_IsPublic").attr("checked",false);}
						$("#packData_likeCount").text(jsonData.likeCount);	
						$("#packData_viewCount").text(jsonData.viewCount);							
						$("#curpackId").val(jsonData.packId);						
					}
					else {
						/* alert("세션이 만료되었습니다. 다시 로그인해주세요.");
						location.href = "/"; */
					}
			}
		);
	
	});
	
	$(".btn-success").click(function(){		
		var form = $("#modifyForm");
		var isPublic = $("#packData_IsPublic").is(":checked");
		form.attr("method", "post");		
		form.attr("action", "/doModifyPack");
		form.submit();
	});
	
>>>>>>> origin/bjg3

		$(".pack").click(function() {
			$("#placesOfPackListdiv").fadeOut();
			$("#placesOfPackListdiv").fadeIn("slow");

			var packId = $(this).children(":eq(2)").val();

			$.post("/packInfo", {
				"packId" : packId
			}, function(data) {

				var jsonData = {};
				try {
					jsonData = JSON.parse(data);
				} catch (e) {
					jsonData.result = false;
				}
				console.log(jsonData);

				if (jsonData.result) {

					$("#packData_Title").text(jsonData.title);
					$("#packData_IsPublic").text(jsonData.isPublic);
					$("#packData_image").attr("src", jsonData.imageLocation);

				} else {
					/* alert("세션이 만료되었습니다. 다시 로그인해주세요.");
					location.href = "/"; */
				}

			});

		});

		$(".switch").click(function() {
			alert();
		});

	});
</script>

<body>
<<<<<<< HEAD
	<div id="packListdiv">
		<table id="packListTable" border="2">
			<c:forEach items="${ packs}" var="packs">
				<tr>
					<td class="pack"><img
						src="<c:url value="/resource/img/pack/folder.png"/>"
						id="folderImg" />
						<p id="title" style="display: inline;">${packs.packTitle}</p> <input
						type="hidden" id="packId" value="${packs.packId}" /> <span
						class="badge">10</span></td>
				</tr>
			</c:forEach>
		</table>

		<a href="/addPack"><img src="/resource/img/pack/circledPlus.png"
			id="btnAdd" /></a> <a href="/deletePack"><img
			src="/resource/img/pack/circledMinus.png" id="btnDelete" /></a>

=======
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
		<a href="/addPack"><span class="glyphicon glyphicon-plus-sign"></span></a>
		<a href="/deletePack"><span class="glyphicon glyphicon-minus-sign"></span></a>	
		<a href="/myPack"><span class="glyphicon glyphicon-ok-sign"></span></a>
		</div>
>>>>>>> origin/bjg3
	</div>
	
	<div id="packListdiv2">
<<<<<<< HEAD
		<div id="placesOfPackListdiv">
			<span id="packData_Title"></span><br /> <span id="packData_IsPublic"></span><br />
			공개 <label class="switch"> <input type="checkbox">
				<div class="slider round"></div>
			</label> <img id="packData_image" src="#" /> 수정버튼
		</div>
=======
		<div id="placesOfPackListdiv" align="center">		
			<img id="packData_image" src="#" /><br/><br/>
			<form id="modifyForm" enctype="multipart/form-data" >	
				<div class="form-group" align="center">
				<input type="file" name="file" value="file" />
				</div>
				<div class="form-group">
				<label for="packData_Title">Pack Title :</label>
				<input type="text" class="form-control" id="packData_Title" name="packData_Title" style="width:50%;display: inline;"></span><br/>
				<input type="hidden" id="curpackId" name="curpackId" />
				<input type="submit" style="display: none"/>
				</div>
				<div class="form-group">
				<label for="packData_Title">Share :</label>
				<label class="switch">
				 <input type="checkbox" id="packData_IsPublic" name="packData_IsPublic" value="1"/>
				 <div class="slider round"></div>
				</label>
				</div>
				<div class="form-group">
				<label for="viewCount">View Count :</label>
				<span id="packData_viewCount" name="packData_viewCount"></span>
				</div>
				<div class="form-group">
				<label for="likeCount">Like Count :</label>
				<span id="packData_likeCount" name="packData_likeCount"></span>
				</div>
	 		</form>
					 
	 			<button type="button" class="btn btn-success">OK</button>
		</div>	
>>>>>>> origin/bjg3
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>