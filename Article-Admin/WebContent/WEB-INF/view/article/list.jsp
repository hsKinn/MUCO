<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<div id="user">${ sessionScope._MEMBER_.nickName } is attended.</div>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
	
	$(document).ready( function() {
		$("#initSearchBtn").click(function() {
			location.href = "<c:url value="/list/init" />";
		});
		
		$("#searchBtn").click(function() {
			if ( $("#searchKeyword").val() == "" ) {
				alert("검색어를 입력하셈");
				return
			}
			movePage('0');
		});
		
	$("#massiveSelectCheckBox").click( function() {
		var isChecked = $(this).prop("checked");
		$(".deleteArticleId").prop("checked", isChecked);
	});
	// 일괄 선택버튼
		
		$("#massiveDeleteBtn").click( function() {
			var isChecked = false;
			
			$(".deleteArticleId").each( function (index, data) {
				if (data.checked) {
					isChecked = data.checked;
				}
				
			});

			if ( !isChecked ) {
				alert("Choose The checkBoxes");
				return;
			}
			if ( confirm("Are you sure delete the articles?") ) {
				var form = $("#massiveDeleteForm");
				form.attr("method", "post");
				form.attr("action", "<c:url value="/massiveDelete" />");
				form.submit();
			}
		});
	});

</script>
<div id="content">
	There are totals of ${ articles.paging.totalArticleCount } posts on the
	board.
	<table border="1" align="center">
		<tr align="center">
			<td><input type="checkbox" id="massiveSelectCheckBox" /></td>
			<th>번호</th>
			<th colspan="2">제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
		<form id="massiveDeleteForm">

			<c:forEach items="${ articles.articleList }" var="art">
				<tr>
					<td><input type="checkbox" class="deleteArticleId"
						name="deleteArticleId" value="${ art.articleId }" /></td>
					<td>${ art.articleId }</td>
					<td colspan="2"><a
						href="<c:url value="/hit?articleId=${art.articleId}" />"> ${ art.title }
					</a> <c:if test="${art.fileCount gt 0 }">
				[${art.fileCount} each files included]
			</c:if></td>
					<td>${ art.nickName }</td>
					<td>${ art.hits }</td>
					<td>${ art.recommends }</td>
				</tr>
			</c:forEach>

		</form>

		<tr>
			<td colspan="7">
				<form id="searchForm">
					<div style="text-align: center;">${ articles.paging.getPagingList("pageNo", "[@]", "[before]", "[next]", "searchForm") }
					</div>
					<div>
						<select name="searchType">
								<c:if test="${ searchVO.searchType eq '1' }">
	 							<option value="1" selected="selected">Title+Descript</option>
	  							<option value="2">Writer_ID</option>
	  							<option value="3">Writer_Name</option>
  							</c:if>
							<c:if test="${ searchVO.searchType eq '2' }">
	 							<option value="1">Title+Descript</option>
	  							<option value="2" selected="selected">Writer_ID</option>
	  							<option value="3">Writer_Name</option>
  							</c:if>
							<c:if test="${ searchVO.searchType eq '3' }">
	 							<option value="1">Title+Descript</option>
	  							<option value="2">Writer_ID</option>
	  							<option value="3" selected="selected">Writer_Name</option>
  							</c:if>
							<%-- <c:set var="names" value="<%=new String[]{ "Title+Descript", "Writer_ID", "Writer_Name" } %>"></c:set> jstl로 배열생성은 어렵다. --%>
							<%-- <c:forEach begin="1" end="3" step="1" var="i">
								<c:set var="selected" value="" />
									<c:if test="${ i eq searchVO.searchType }"></c:if>
										<c:set var="selected" value="selected='selected'" />
											<c:if test="${ i eq 1 }">
												<c:set var="name" value="Title+Descript"></c:set>
											</c:if>
											<c:if test="${ i eq 2 }">
												<c:set var="name" value="Writer_ID"></c:set>
											</c:if>
											<c:if test="${ i eq 3 }">
												<c:set var="name" value="Writer_Name"></c:set>
											</c:if>
										<option value="${i}" ${selected}>${name}</option>
							</c:forEach> --%>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword }" /><br/>
						<input type="button" id="searchBtn" value="search" />
						<input type="button" id="initSearchBtn" value="init" />
					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="4"><a
				href="<c:url value="/write?articleId=${ art.articleId }" />">write</a></td>
			<td colspan="3"><span id="massiveDeleteBtn"
				style="cursor: pointer;">일괄삭제</span></td>
		</tr>
	</table>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>