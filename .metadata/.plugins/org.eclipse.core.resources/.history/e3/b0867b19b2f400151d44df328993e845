<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeInfoModify.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resource/js/snap.js" />"></script>
<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- Recommend Place -->
<script type="text/javascript">
	$(document).ready(function() {

		$("#recommendPlaceMenu").mouseout(function() {
			$("#recommendPlaceMenu").css("color", "#ffffff");
		});
		$("#recommendPlaceMenu").css("color", "#ffffff");

	});
</script>
<script type="text/javascript">
	
	$(document).ready( function() {
		
		$("#modifyBtn").click(function() {
			var form = $("#modifyForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoModify"/>");
			form.submit();
		});
		
		
		
	
		
		
		
	});


</script>
<script type="text/javascript">

	$(document).ready( function() {
		<c:if test="${ not empty article}">
		$("#doModify").click( function() {
			var form = $("#writeForm");
			form.attr("method", "post");
			form.attr("action", "/doModify");
			form.submit();
		});
		</c:if>
	});
</script>


<div id="placeInfoModify_Wrapper">



	<div id="placeInfoModify_title">여행지 등록하기
	
		<input type="text" id="title" name="title" style="width: 250px;" value="${ article.title }" />
	
	</div>

	<form id="writeForm" enctype="multipart/form-data">

	<div id="placeInfoModify_searchMap">[IMG] 주소받아오기창 연동 Google MAP API</div>
	<div id="placeInfoModify_imageUpload">
	[IMG] 파일경로 /하단 이미지보여주기 / 파일	업로드
		<input type="file" id="file" name="file" />
	</div>
	
	<div id="placeInfoModify_description">TEXTAREA SIZE HEIGHT 40%/
		<textarea id="descript" name="descript" style="width:250px; height:150px;">${ article.descript }</textarea>	
	
	</div>
	<div id="placeInfoModify_modifyBtn">SUBMIT [IMG5]
			<c:if test="${ empty article }">
				<input type="button" id="doWrite" value="submit" />
			</c:if>
	
	</div>
	</form>
</div>



























	$(document).ready( function() {
		$(".hide").hide();
		
				$(".writeReReply").click(
						function() {
							var table = $(this).parent().parent().parent();
							console.log(table.text());
							var groupId = table.children(":eq(1)").children(
									":eq(0)").html();
							var parentReplyId = table.children(":eq(1)")
									.children(":eq(1)").html();
							var depth = table.children(":eq(2)").children(
									":eq(0)").html();
							var orderNo = table.children(":eq(2)").children(
									":eq(1)").html();
							var replyId = table.children(":eq(3)").children(
									":eq(0)").html();

							$("#depth").val(parseInt(depth) + 1);
							$("#parentReplyId").val(replyId);
							$("#groupId").val(groupId);
							$("#orderNo").val(orderNo);
							$("#replyId").val(replyId);

							var form = $("#formWrapper").html();
							$("formWrapper").detach();

							if (form == undefined) {
								$(".formAppender").each(function(index, data) {
									if (data.innerHTML != "") {
										form = data.innerHTML;
									}
								});
								$("formAppender").html("");
							}

							var formAppender = table.parent()
									.children(":eq(1)");
							formAppender.html(form);
							formAppender.show();
						});
			});
</script>


<div class="Reply">
	<table border="1">
		<tr align="center">
			<th>글 제목 </th>
			<th>글쓴이의 ID(Member ID)</th>
			<th>글 내용</th>
		</tr>
		<tr>
			<td>${ article.title }</td>
			<td>${ article.memberId }</td>
			<td>${ article.descript }</td>
			<c:forEach items="${ article.fileList }" var="fileList">
				<td colspan="6"><a
					href="/download?fileId=${fileList.fileId}&articleId=${article.articleId}">
						${fileList.fileName} </a></td>
			</c:forEach>
		</tr>
	</table>
</div>



<%-- ${ sessionScope._MEMBER_.memberId } ${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password } ${ sessionScope._MEMBER_.email } --%>

<div id="formWrapper">
	<form id="writeReplyForm">
		<input type="hidden" id="articleId" name="articleId"
			value="${ article.articleId }" /> <input type="hidden" id="depth"
			name="depth" value="0" /> <input type="hidden" id="replyId"
			name="replyId" value="0" /> <input type="hidden" id="parentReplyId"
			name="parentReplyId" value="0" /> <input type="hidden" id="groupId"
			name="groupId" value="0" /> <input type="hidden" id="orderNo"
			name="orderNo" value="0" />
		<textarea rows="5" cols="20" id="description" name="description"></textarea>
		<input type="button" id="btnWriteReply" value="Reply" />
	</form>
</div>


<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
${ loginId }

<c:if test="${ loginId eq article.memberId }">
	<a href="/delete?articleId=${ article.articleId }">
	<input type="button" id="delete" value="delete" />
	</a>
	<a href="/modify?articleId=${ article.articleId }">
	<input type="button" id="modify" value="modify" />
	</a>
</c:if>



















<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>