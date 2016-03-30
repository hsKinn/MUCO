<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/sidebar.jsp" flush="false" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"	src="/Travery/resource/js/jquery-1.12.1.js"></script>
</head>
<body>

<script type="text/javascript">
	
	$(document).ready( function() {
		
		$("#createBtn").click(function() {
			var form = $("#createForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoCreate"/>");
			form.submit();
		});
		
		$("#modifyBtn").click(function() {
			var form = $("#modifyForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoModify"/>");
			form.submit();
		});
		
		
		
		
		$("#massiveSelectCheckBox").click( function() {
			var isChecked = $(this).prop("checked");
			$(".deletePlaceId").prop("checked", isChecked);
		});
		
		$("#massiveDeleteBtn").click( function() {
			var isChecked = false;
			$(".deletePlaceId").each( function (index, data) {
				if (data.checked) {
					isChecked = data.checked;
				}
			});
			if ( !isChecked ) {
				alert("Choose The checkBoxes");
				return;
			}
			if ( confirm("정말로 삭제 하시겠습니까?") ) {
				var form = $("#massiveDeleteForm");
				form.attr("method", "post");
				form.attr("action", "<c:url value="/placeInfoMassiveDelete" />");
				form.submit();
			}
		});		
	});

</script>
<div id="content">

	<table border="1" align="center">
		<tr align="center">
			<td><input type="checkbox" id="massiveSelectCheckBox" /></td>
			<th>여행지 명칭</th>
			<th>이미지</th>
		</tr>
		
		<form id="massiveDeleteForm">
			<c:forEach items="${ recommends.recommendList }" var="rL">
				<tr>
					<td><input type="checkbox" class="deletePlaceId" name="deletePlaceId" value="${ rL.placeId }" /></td>
					<td>${ rL.placeName }</td>
					<td>
						<a href="<c:url value="/hit?placeId=${rL.placeId}" />"> ${ rL.title }</a> 
						<c:if test="${rL.fileCount gt 0 }"> [${rL.fileCount} each files included]
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</form>
	</table>
		
		<form id="createForm">
			<img src="<c:url value="/resource/img/btn-create.png" />" id="createBtn" style="cursor: pointer" />
		</form>	
		<form id="modifyForm">
			<img src="<c:url value="/resource/img/btn-modify.png" />" id="modifyBtn" style="cursor: pointer" />
		</form>	
		<form id="deleteForm">
			<img src="<c:url value="/resource/img/btn-delete.png" />" id="massiveDeleteBtn" style="cursor: pointer" />
		</form>	
		
			<a href="<c:url value="/write?articleId=${ art.articleId }" />">write</a>
</div>








</body>
</html>