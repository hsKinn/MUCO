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
	
	$(".btn-default").click(function() {
		alert("click");
		var form = $("#addPack");
		form.attr("method", "post");		
		form.attr("action", "/doAddPack");
		form.submit();
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
	
	<a href="/myPack"><span class="glyphicon glyphicon-ok-sign"></span></a>
	
	</div>
	
	
	
	
	<div id="packListdiv2">
		<div id="addPackFormdiv">		
			
			<form id="addPack" enctype="multipart/form-data" role="form">			
			  <div class="form-group">
			    <label for="file"> My package Image : </label>
			   	<input type="file" id="file" name="file"/>
			  </div>
			  <div class="form-group">
			    <label for="title">My package name : </label>
			    <input type="text" class="form-control" id="title" name="title"/>
			  </div>
		
			
			  <button type="submit" class="btn btn-default">AddPackage</button>
			
			</form>
		</div>
	</div>
</body>

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>