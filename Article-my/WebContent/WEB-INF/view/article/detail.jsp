<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready( function() {
		$(".hide").hide();

		$("#favorite").click(function() {
			// ajex요청 시작단계
			$.post(
					"/favorite"
					, {
						"articleId" : "${article.articleId}"
						}
					//callback구간을 달아줘야함. 응답데이터도 우리가 직접 적어줘야함. 성공여부는 확인불가.
					, function(data) {
						
						/* var jsonData = {};
						jsonData.nameOne = "cain";
						jsonData.nameTwo = "kim";
						
						alert(jsonData.nameOne);
						var jsonData2 = {
								nameOne : "haha"
								, nameTwo : "juna"
						}
						alert(jsonData2.nameOne); */
						
						var jsonData = {};
						
						try {
							jsonData = JSON.parse(data);
						}//jsp는 타입이 없기 때문에 작성x
						catch(e) {
							jsonData.result = false;
						}
						
						console.log(jsonData);
				
						if ( jsonData.result ) {
							var text = $("#favorite").text();
							if ( jsonData3.isFavorite ) {
								$("#favorite").text("♥");
							} else {
								$("#favorite").text("♡");
							}
						}
						else {
							alert("세션만료. 재로그인필요.");
							location.href = "/";
						}
					});
				});

				$("#btnWriteReply").click(function() {
					var form = $("#writeReplyForm");
					form.attr("method", "post");
					form.attr("action", "/doWriteReply");
					form.submit();
				});

				$("body").on("click", "#btnWriteReply", function() {
					var form = $("#writeReplyForm");

					form.attr("method", "post");
					form.attr("action", "/doWriteReply");
					form.submit();
				});

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
			<th>글번호</th>
			<th>글 제목 <c:if test="${ isExistFavoriteData }">
					<span id="favorite" style="color: red;">♥</span>
				</c:if> <c:if test="${ !isExistFavoriteData }">
					<span id="favorite" style="color: red;">♡</span>
				</c:if>
			</th>
			<th>글쓴이의 ID(Member ID)</th>
			<th>글 내용</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
		<tr>
			<td>${ article.articleId }</td>
			<td>${ article.title }</td>
			<td>${ article.memberId }</td>
			<td>${ article.descript }</td>
			<td>${ article.hits }</td>
			<td>${ article.recommends }</td>
		</tr>

		<tr>
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

<div id="reply">
	<c:forEach items="${ article.replyList }" var="reply">
		<div style="padding-left: ${reply.depth * 20}px">
			<table border="1" width="100%">
				<tr>
					<td width="5%">${reply.nickName}</td>
					<td>${reply.description}<br /> <span class="writeReReply"
						style="cursor: pointer"><b>댓글달기</b></span>
					</td>
				</tr>
				<tr class="hide">
					<td class="groupId">${ reply.groupId }</td>
					<td class="parentReplyId">${ reply.parentReplyId }</td>
				</tr>
				<tr class="hide">
					<td class="depth">${ reply.depth }</td>
					<td class="orderNo">${ reply.orderNo }</td>
				</tr>
				<tr class="hide">
					<td colspan="2" class="replyId">${ reply.replyId }</td>
				</tr>
			</table>
			<div class="hide formAppender"></div>
		</div>
	</c:forEach>
</div>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
${ loginId }

<c:if test="${ loginId eq article.memberId }">
	<a href="/delete?articleId=${ article.articleId }">delete</a>
	<a href="/modify?articleId=${ article.articleId }">modify</a>
</c:if>

<a href="/recommend?articleId=${article.articleId}"> <input
	type="button" id="recommend" value="recommend" /></a>
<a href="/list"><input type="button" id="recommend" value="back" /></a>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>