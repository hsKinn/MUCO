<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready( function() {
		
		$(".hide").hide();
		
		$("#recommends").click( function() {
			
	        $.get('<c:url value="/recommends?articleId=${selectedArticle.articleId}"/>', function(){
        	    alert("추천 완료");
	        }); 

		});

 		$("#delete").click( function() {
 			
 			location.href='<c:url value="/delete?articleId=${ selectedArticle.articleId }" />';
 			
		}); 
 		
 		$("#goBack").click( function() {
 			location.href='<c:url value="/list" />';
 		});
 		
 		$("#modify").click( function() {
 			
 			location.href='<c:url value="/modify?articleId=${ selectedArticle.articleId }" />';
 			
		}); 
 		
 		$("#writeReplyBtn").click( function() {
 			
 			var form = $("#writeReplyForm");
 			
 			form.attr("method", "POST");
 			form.attr("action", "<c:url value="/doWriteReply"/>");
 			
 			form.submit();
 			
 		});
 		
 		$("body").on("click", "#writeReplyBtn", function() {

 			var form = $("#writeReplyForm");
 			
 			form.attr("method", "POST");
 			form.attr("action", "<c:url value="/doWriteReply"/>");
 			
 			form.submit();
 			
 		});
 			
 		
 		$(".writeReReply").click( function() {
 			var table = $(this).parent().parent().parent();
 			
 			var groupId = table.children(":eq(1)").children(":eq(0)").html();
 			var parentReplyId = table.children(":eq(1)").children(":eq(1)").html();
 			var depth = table.children(":eq(2)").children(":eq(0)").html();
 			var orderNo = table.children(":eq(2)").children(":eq(1)").html();
 			var replyId = table.children(":eq(3)").children(":eq(0)").html();
 			
			$("#depth").val( parseInt(depth)+1 );
 			$("#parentReplyId").val( replyId );
 			$("#groupId").val( groupId );
 			$("#orderNo").val( orderNo );
 			$("#replyId").val( replyId );
 			
 			
 			var form = $("#formWrapper").html();
 			$("#formWrapper").detach();
 			
 			if ( form == undefined ) {
 				$(".formAppender").each(function(index, data) {
 					if ( data.innerHTML != "" ) {
 						form = data.innerHTML;
 					}
 				});
 				$(".formAppender").html("");
 			}
 			
 			var formAppender = table.parent().parent().children(":eq(1)");
 			formAppender.html(form);
 			formAppender.show();
 		
 		});
		
	});
</script>

<table border="1" width="700px" align="center">
	<tr>
		<th>글 번호</th>
		<th>글 제목</th>
		<th>글쓴이 Nick</th>
		<th>글쓴이 ID</th>
		<th>글 내용</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<tr>
		<td class="c">${ selectedArticle.articleId }</td>
		<td class="c">${ selectedArticle.title }</td>
		<td class="c">${ selectedArticle.nickName }</td>
		<td class="c">${ selectedArticle.memberId }</td>
		<td class="c">${ selectedArticle.descript }</td>
		<td class="c">${ selectedArticle.hits }</td>
		<td class="c">${ selectedArticle.recommends }</td>
	</tr>
	
   <tr>
  		<c:forEach items="${ selectedArticle.fileList }" var="file">
  			<td colspan="7">
  				<a href="<c:url value="/download?fileId=${file.fileId}&articleId=${selectedArticle.articleId}" />" >
  					${ file.fileName }
  				</a>	
  			</td>
  		</c:forEach>
   </tr>
</table>

<%-- 세션 접근
${ sessionScope._MEMBER_.memberId }
${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password }
${ sessionScope._MEMBER_.email } --%>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
<c:set var="isAdmin" value="${ sessionScope._MEMBER_.isAdmin() }" />

<table border="1" align="center">
	<tr align="center">
		<td colspan="4">메뉴</td>
	</tr>
	<tr>
		<td align="center">
			<input type="button" id="goBack" value="돌아가기" />
		</td>
		<td align="center">
			<input type="button" id="recommends" value="추천" />
		</td>
		<c:if test="${ loginId eq selectedArticle.memberId || isAdmin }">
			<td align="center">
				<input type="button" id="delete" value="삭제" />
			</td>
			<td align="center">
				<input type="button" id="modify" value="수정" />
			</td>
		</c:if>
	</tr>
</table>

<%-- <table align="center">
	<tr>
		<td>
			<form id="writeReplyForm">
				<input type="hidden" id="articleId" name="articleId" value="${ selectedArticle.articleId }" />
				<input type="hidden" id="depth" name="depth" value="0" />
				<input type="hidden" id="parentReplyId" name="parentReplyId" value="0" />
				<input type="hidden" id="groupId" name="groupId" value="0" />
				<input type="hidden" id="orderNo" name="orderNo" value="0" />
				<textarea id="description" name="description"></textarea>
				<input type="button" id="writeReplyBtn" value="댓글 등록" />
			</form>
		</td>
	</tr>
</table> --%>


<div id="formWrapper">
<form id="writeReplyForm">
	<input type="hidden" id="articleId" name="articleId" value="${ selectedArticle.articleId }" />
	<input type="hidden" id="depth" name="depth" value="0" />
	<input type="hidden" id="parentReplyId" name="parentReplyId" value="0" />
	<input type="hidden" id="groupId" name="groupId" value="0" />
	<input type="hidden" id="orderNo" name="orderNo" value="0" />
	<input type="hidden" id="replyId" name="replyId" value="0" />
	<textarea id="description" name="description"></textarea>
	<input type="button" id="writeReplyBtn" value="댓글 등록" />
</form>
</div>

<div>
<c:forEach items="${ selectedArticle.replyList }" var="reply">
<div>
<table align="center" width="60%" style="margin-left: ${ reply.depth * 20 }px;">
	<tr>
		<td align="left" width="55px">${ reply.nickName }</td>
		<td>
			${ reply.description }
			<span class="writeReReply" style="cursor: pointer;">(댓글 달기)</span>
			<%-- <c:if test="${ reply.depth eq 0 }">
			</c:if> --%>
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

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
