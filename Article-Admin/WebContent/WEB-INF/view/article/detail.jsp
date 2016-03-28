<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".hide").hide();

				$("#btnWriteReply").click(function() {
					var form = $("#writeReplyForm");
					form.attr("method", "POST");
					form.attr("action", "<c:url value="/doWriteReply" />");
					form.submit();
				});

				$("body").on("click", "#btnWriteReply", function() {
					var form = $("#wrtieReplyForm");

					form.attr("method", "post");
					form.attr("action", "<c:url value="/doWriteReply"/>");
					form.submit();
				});

				$(".writeReply").click(
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

							$("#groupId").val(groupId);
							$("#parentReplyId").val(replyId);
							$("#depth").val(parseInt(depth) + 1);
							$("#orderNo").val(orderNo);
							$("#replyId").val(replyId);

							var form = $("#formWrapper").html();
							$("#formWrapper").detach();

							if (form == undefined) {
								$(".formAppender").each(function(index, data) {
									if (data.innerHTML != "") {
										form = data.innerHTML;
									}
								});
								$(".formAppender").html("");
							}

							var formAppender = table.parent().parent()
									.children(":eq(1)");
							formAppender.html(form);
							formAppender.show();
						});
			});
</script>
<div class="Reply">
	<table border="1" align="center">
		<tr align="center">
			<th>글번호</th>
			<th>글 제목</th>
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
					href="<c:url value="/download?fileId=${fileList.fileId}&articleId=${article.articleId}" />">
						${fileList.fileName} </a></td>
			</c:forEach>
		</tr>
	</table>
</div>
<%-- ${ sessionScope._MEMBER_.memberId } ${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password } ${ sessionScope._MEMBER_.email } --%>

<div id="formWrapper">
	<form id="wrtieReplyForm">
		<input type="hidden" name="articleId" id="articleId"
			value="${article.articleId}" /> <input type="hidden" name="depth"
			id="depth" value="0" /> <input type="hidden" name="parentReplyId"
			id="parentReplyId" value="0" /> <input type="hidden" name="replyId"
			id="replyId" value="0" /> <input type="hidden" name="groupId"
			id="groupId" value="0" /> <input type="hidden" name="orderNo"
			id="orderNo" value="0" />
		<textarea rows="1" cols="35" id="description" name="description"></textarea>
		<input type="button" id="btnWriteReply" value="Reply" />
	</form>
</div>
<div id="reply">
	<c:forEach items="${ article.replyList }" var="reply">
		<div style="padding-left: ${reply.depth * 20}px">
			<table border="1" width="75%">
				<tr>
					<td width="5%">${reply.nickName}</td>
					<td align="center">${reply.description}  <span class="writeReply"
						style="cursor: pointer"><b>Reply</b></span>
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
<c:set var="isAdmin" value="${ sessionScope._MEMBER_.isAdmin() }" />
${ loginId }

<c:if test="${ loginId eq article.memberId || isAdmin }">
	<a href="<c:url value="/delete?articleId=${ article.articleId }" />">delete</a>
	<a href="<c:url value="/modify?articleId=${ article.articleId }" />">modify</a>
</c:if>


<a href="<c:url value="/recommend?articleId=${article.articleId}" /> ">
	<input type="button" id="recommend" value="recommend" />
</a>
<a href="<c:url value="/list" /> "><input type="button"	id="recommend" value="back" /></a>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
