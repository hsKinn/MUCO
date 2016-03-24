<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".hide").hide();

			});
</script>
<div class="Reply">
	<table border="1" align="center">
		<tr align="center">
			<th>MEMBER_ID</th>
			<th>NICK_NAME</th>
			<th>PASSWORD</th>
			<th>EMAIL</th>
			<th>IS_ADMIN</th>
		</tr>
		<tr>
			<td>${ member.memberId }</td>
			<td>${ member.nickName }</td>
			<td>${ member.password }</td>
			<td>${ member.email }</td>
			<td>${ member.isAdmin }</td>
		</tr>
	</table>
</div>
<%-- ${ sessionScope._MEMBER_.memberId } ${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password } ${ sessionScope._MEMBER_.email } --%>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
<c:set var="isAdmin" value="${ sessionScope._MEMBER_.isAdmin() }" />
${ loginId }

<c:if test="${ loginId eq article.memberId || isAdmin }">
	<a href="<c:url value="/infoDelete?memberId=${ member.memberId }" />">delete</a>
	<a href="<c:url value="/modify?memberId=${ member.memberId }" />">modify</a>
</c:if>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
