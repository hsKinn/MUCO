<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>

<script type="text/javascript">

	$(document).ready( function() {
		
 		$("#dropOut").click( function() {
 			
 			location.href='<c:url value="/dropOutMember?memberId=${ seletedMember.memberId}" />';
 			
		}); 

 		$("#block").click( function() {
 			
 			location.href='<c:url value="/memberBlock?memberId=${ seletedMember.memberId}" />';
 			
		}); 
 		
 		$("#changePassword").click( function() {
 			
 			var form = $("#changePasswordForm");
 			
 			form.attr("method", "POST");
 			form.attr("action", "<c:url value="/doChangePassword"/>");
 			
 			form.submit();
 			
 		});
 		
		
	});
</script>

<table border="1" width="700px" align="center">
	<tr>
		<th>사용자 ID</th>
		<th>닉네임</th>
		<th>E-MAIL</th>
		<th>Password</th>
		<th>관리자 등급</th>
		<th>차단</th>
	</tr>
	
	<tr>
		<td class="c">${ seletedMember.memberId}</td>
		<td class="c">${ seletedMember.nickName }</td>
		<td class="c">${ seletedMember.email }</td>
		
		<td class="c">
			<form id="changePasswordForm">
				<input type="password" id="password" name="password" value="${ seletedMember.password }"/>
				<input type="hidden" id="memberId" name="memberId" value="${ seletedMember.memberId}" />
			</form>
		</td>
		<td class="c">${ seletedMember.isAdmin }</td>
		<td class="c">${ seletedMember.isBlock }</td>
	</tr>
</table>

<c:set var="isAdmin" value="${ sessionScope._MEMBER_.isAdmin() }" />

<table border="1" align="center">
	<tr align="center">
		<th colspan="3">메뉴</th>
	</tr>
	<tr>
		<c:if test="${ isAdmin }">
			<td>
				<input type="button" id="dropOut" value="삭제" />
			</td>
			<td>
				<input type="button" id="changePassword" value="비밀번호 변경" />
			</td>
			<td>
				<input type="button" id="block" value="차단" />
			</td>
		</c:if>
	</tr>
</table>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
