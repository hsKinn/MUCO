<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<script type="text/javascript">

	$(document).ready( function() {
		<c:if test="${ empty article }">
		$("#doWrite").click( function() {
			var form = $("#writeForm");
			form.attr("method", "post");
			form.attr("action", "/writeAction");
			form.submit();
		});
		</c:if>
		<c:if test="${ not empty article}">
		$("#doModify").click( function() {
			var form = $("#writeForm");
			form.attr("method", "post");
			form.attr("action", "/doModify");
			form.submit();
		});
		$("#reset").click(function() {
/* 			$("#title").val("${ article.title }");
			$("#description").val("${ article.descript }"); */
			location.reload();
		});
		</c:if>
		
		$("#cancel").click( function() {
			var answer = confirm('정말 이동하시겠습니까?')
			if(answer == true){
				window.location="/list";
			}
			else
				return false;
		});		
	});
</script>
<form id="writeForm" enctype="multipart/form-data">
	<table>
		<tr align="right">
			<td>Title</td>
			<td><input type="text" id="title" name="title" style="width: 250px;" value="${ article.title }" /></td>
		</tr>
		<tr align="right">
			<td>Description</td>
			<td><textarea id="descript" name="descript" style="width:250px; height:150px;">${ article.descript }</textarea></td>
		</tr>
		<tr align="right">
			<td align="right">
				<input type="file" id="file" name="file" />
			</td>
		</tr>
		<tr align="right">
			<td>	
			<c:if test="${ empty article }">
				<input type="button" id="doWrite" value="submit" />
				<input type="reset" value="reset"/>
			</c:if>
			</td>
			<td>
				<c:if test="${ not empty article }">
					<input type="hidden" name="articleId" value="${ article.articleId }" />
					<input type="button" id="doModify" value="modify" />
					<input type="button" value="reset"/>
				</c:if>
			</td>
			<td>		
				<input type="button" id="cancel" value="calcel" />
			</td>
		</tr>
	</table>
	
</form>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>