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

		$("#myPackMenu").mouseout(function() {
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
>>>>>>> origin/bjg3
	</div>




	<div id="packListdiv2">
<<<<<<< HEAD
		<div id="addPackFormdiv">

			<form id="addPack" enctype="multipart/form-data" role="form">
				<div class="form-group">
					<label for="file"> My package Image : </label> <input type="file"
						id="file" name="file" />
				</div>
				<div class="form-group">
					<label for="title">My package name : </label> <input type="text"
						class="form-control" id="title" name="title" />
				</div>


				<button type="submit" class="btn btn-default">AddPackage</button>

=======
		<div id="addPackFormdiv" align="center";>		
			<form id="addPack" enctype="multipart/form-data" role="form">			
			  <div class="form-group">
			    <label for="file"> My package Image : </label>
			   	<input type="file" id="file" name="file"/>
			  </div>
			  <div class="form-group">
			    <label for="title">My package name : </label>
			    <input type="text" class="form-control" id="title" name="title"/>
			  </div>
				<div class="form-group">
				<label for="packData_Title">Share :</label>
				<label class="switch">
				 <input type="checkbox" id="packData_IsPublic" name="packData_IsPublic" value="1"/>
				 <div class="slider round"></div>
				</label>
				</div>
			
			  <button type="submit" class="btn btn-default">AddPackage</button>
			
>>>>>>> origin/bjg3
			</form>
		</div>
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>