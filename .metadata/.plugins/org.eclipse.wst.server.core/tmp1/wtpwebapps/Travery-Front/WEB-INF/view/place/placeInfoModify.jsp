<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

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
<<<<<<< HEAD
<script type="text/javascript">
	$(document).ready(function() {

		$("#modifyBtn").click(function() {
			var form = $("#modifyForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoModify"/>");
			form.submit();
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		<c:if test="${ not empty article}">
		$("#doModify").click(function() {
			var form = $("#writeForm");
			form.attr("method", "post");
			form.attr("action", "/doModify");
			form.submit();
		});
		</c:if>
	});
</script>


<div id="placeInfoModify_Wrapper">



	<div id="placeInfoModify_title">
		여행지 등록하기 <input type="text" id="title" name="title"
			style="width: 250px;" value="${ article.title }" />

	</div>

	<form id="writeForm" enctype="multipart/form-data">

		<div id="placeInfoModify_searchMap">[IMG] 주소받아오기창 연동 Google MAP
			API</div>
		<div id="placeInfoModify_imageUpload">
			[IMG] 파일경로 /하단 이미지보여주기 / 파일 업로드 <input type="file" id="file"
				name="file" />
		</div>

		<div id="placeInfoModify_description">
			TEXTAREA SIZE HEIGHT 40%/
			<textarea id="descript" name="descript"
				style="width: 250px; height: 150px;">${ article.descript }</textarea>

		</div>
		<div id="placeInfoModify_modifyBtn">
			SUBMIT [IMG5]
			<c:if test="${ empty article }">
				<input type="button" id="doWrite" value="submit" />
			</c:if>

		</div>
	</form>
=======

<div id="recommendPlace_Wrapper">
	<div id="inner_wrapper">
		<div id="daily_wrapper">
			<div id="daily_top">
				Daily
			</div>
			
			<div id="daily_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							일일 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>
		</div>
		
		<div id="weekly_wrapper">
			<div id="weekly_top">
				Weekly
			</div>

			<div id="weekly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							주간 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>
		</div>
		
		<div id="monthly_wrapper">
			<div id="monthly_top">
				Monthly
			</div>

			<div id="monthly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							월간 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>			
		</div>
	</div>
	
	<div id="middle">
		<div id="search_part">
			<input type="text" id="searchKeyword" placeholder="  # Search" />
			<button type="button" class="btn btn-info" id="searchBtn">
	     		<span class="glyphicon glyphicon-search"></span>검색
	   		</button>
			<button type="button" class="btn btn-info" id="initSearchBtn">
	     		<span class="glyphicon glyphicon-repeat"></span>초기화
	   		</button>
   		 </div>
   		 <div id="write_part">
			<button type="button" class="btn btn-info" id="writeBtn">
	     		<span class="glyphicon glyphicon-pencil"></span>등록하기
	   		</button>   		 
   		 </div>
	</div>
	
	<div id="inner_wrapper2">
		<div id="new_wrapper">
			<div id="new_top">
				New
			</div>

			<div id="new_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="new-contents">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>					
						<div class="content-middle">
							새로운 여행지 Title
						</div>
						<div class="content-bottom">
							<div class="bottom-top">
								Writer	
							</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
								<span class="glyphicon glyphicon-heart"></span>
								<span id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>			
			</div>
		</div>
	</div>
>>>>>>> origin/롯드4
</div>





<<<<<<< HEAD






















$(document).ready( function() { $(".hide").hide();

$(".writeReReply").click( function() { var table =
$(this).parent().parent().parent(); console.log(table.text()); var
groupId = table.children(":eq(1)").children( ":eq(0)").html(); var
parentReplyId = table.children(":eq(1)") .children(":eq(1)").html(); var
depth = table.children(":eq(2)").children( ":eq(0)").html(); var orderNo
= table.children(":eq(2)").children( ":eq(1)").html(); var replyId =
table.children(":eq(3)").children( ":eq(0)").html();

$("#depth").val(parseInt(depth) + 1); $("#parentReplyId").val(replyId);
$("#groupId").val(groupId); $("#orderNo").val(orderNo);
$("#replyId").val(replyId); var form = $("#formWrapper").html();
$("formWrapper").detach(); if (form == undefined) {
$(".formAppender").each(function(index, data) { if (data.innerHTML !=
"") { form = data.innerHTML; } }); $("formAppender").html(""); } var
formAppender = table.parent() .children(":eq(1)");
formAppender.html(form); formAppender.show(); }); });
</script>


<div class="Reply">
	<table border="1">
		<tr align="center">
			<th>글 제목</th>
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
	<a href="/delete?articleId=${ article.articleId }"> <input
		type="button" id="delete" value="delete" />
	</a>
	<a href="/modify?articleId=${ article.articleId }"> <input
		type="button" id="modify" value="modify" />
	</a>
</c:if>



















=======
>>>>>>> origin/롯드4
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>