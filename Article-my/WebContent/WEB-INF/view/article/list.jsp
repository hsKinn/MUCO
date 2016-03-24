<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>

<DIV class="TotalCount">There are totals of ${ articles.paging.totalArticleCount }
	posts on the board.</DIV>
<DIV class="list">
	<table border="1" align="center">
		<tr align="center">
			<th>번호</th>
			<th colspan="2">제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
		<c:forEach items="${ articles.articleList }" var="art">
			<tr>
				<td>${ art.articleId }</td>
				<td  colspan="2"><a href="/detail?articleId=${art.articleId}"> ${ art.title }
				</a> <c:if test="${art.fileCount gt 0 }">
				[${art.fileCount} each files included]
			</c:if></td>
				<td>${ art.nickName }</td>
				<td>${ art.hits }</td>
				<td>${ art.recommends }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<form id="searchForm">${ articles.paging.getPagingList("pageNo", "[@]", "[before]", "[next]", "searchForm") }
				</form>
			</td>
			<td><a href="/write?articleId=${ art.articleId }">write</a></td>
		</tr>
	</table>
</DIV>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>