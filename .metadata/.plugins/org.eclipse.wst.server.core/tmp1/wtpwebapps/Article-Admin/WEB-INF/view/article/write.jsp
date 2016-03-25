<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready( function() {
		
		<c:if test="${ empty article }">
		$("#doWrite").click( function() {
			
			var form = $("#writeForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/writeAction"/>");
			form.submit();
			
		} );
		</c:if>
		
		<c:if test="${ not empty article }">
		$("#doModify").click( function() {
			
			var form = $("#writeForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/modifyAction"/>");
			form.submit();
			
		} );
		$("#reset").click( function() {
			
			/*$("#title").val("${ article.title }");
			$("#description").val("${ article.descript }"); */
			
			location.reload();
			
		} );
		</c:if>
		
		$("#cancle").click( function() {
			
			location.href="/list";
			
		} );
		
	} );
</script>   
    


<form id="writeForm" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>Title</th>
			<td>
				<input type="text" id="title" name="title" style="width: 250px;" 
				value="${ article.title }" />
			</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>
				<textarea id="description" name="description" style="width: 250px; height: 150px;">${ article.descript }</textarea>
			</td>
		</tr>
		<tr>
			<th>Upload</th>
			<td>
				<input type="file" id="file" name="file" />
			</td>
		</tr>
	</table>

	<c:if test="${ empty article }">
		<input type="button" id="doWrite" value="등록!" />
		<input type="reset" value="다시 쓰기" />
	</c:if>
	<c:if test="${ not empty article }">
		<input type="hidden" name="articleId" value="${ article.articleId }" />
		<input type="button" id="doModify" value="수정!" />
		<input type="button" id="reset" value="다시 쓰기" />
	</c:if>
	<input type="button" id="cancle" value="취소" />
</form>


