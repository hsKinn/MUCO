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
	$(document).ready(function() {
		
		var hashtag = {};
		var count=0;
		
		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");

		$("#addPackImg").hide();
		$("#hashtagAddBtn").click(function() {
			var tag = $("#hashTag").val();
			hashtag[count]=tag;
			count++;
			$(".hashtagBox").append(" #"+tag);
			$("#hashTag").val(null);
		});

		$(".btn-default").click(function() {
			var form = $("#addPack");
			form.attr("method", "post");
			form.attr("action", "/doAddPack");
			form.submit();
			hashtag.submit();
		});

	});
</script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			$("#addPackImg").show();

			var reader = new FileReader();
			reader.onload = function(e) {
				$('#addPackImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>


<body>
	<div id="mypackWrapperdiv">
		<div id="mypackListdiv">
		<table id="packListTable" border="2">
				<c:forEach items="${ packs}" var="packs">
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
			<a href="/myPack"><span class="glyphicon glyphicon-ok-sign"></span></a>
		</div>
	</div>




	<div id="packListdiv2">
		<div id="addPackFormdiv" align="center";>		
			<form id="addPack" enctype="multipart/form-data" role="form">			
			 	<div class="form-group" align="center"; style="display: inline;"> 
					<label for="file"> My package Image : </label> <br/>
				</div>
					<div class="form-group" align="center"; style="display: inline;"> 
					<img id="addPackImg"
						class="img-rounded" src="#"
						style="width: 150px; height: 150px;" /><br/>
				<br/><br/>
				<input type="file"
					id="image" name="image" accept="image/*" onchange="readURL(this); " /> 
				</div><br/>
			  <div class="form-group">
			    <label for="title">My package name : </label>
			    <input type="text" class="form-control" id="title" name="title" style="width:50%;display: inline;"/>
			  </div>
				<div class="form-group">
				<label for="packData_Title">Share :</label>
				<label class="switch">
				 <input type="checkbox" id="packData_IsPublic" name="packData_IsPublic" value="1"/>
				 <div class="slider round"></div>
				</label>
				</div>
				<div class="form-group">
				<label for="packData_Title">Hash Tag :</label>
				  <input type="text" class="form-control" id="hashTag" name="hashTag"style="width:30%;display: inline;"/>
				  <button type="button" id="hashtagAddBtn" class="btn btn-info">Push</button>
				</div>
				<div class="form-group">
					<span class="hashtagBox"></span>
				</div>
				
			
			
			  <button type="submit" class="btn btn-primary" style="width:130px;">AddPackage</button>
			</form>
		</div>
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>