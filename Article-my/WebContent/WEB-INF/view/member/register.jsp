<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnRegist").click(function() {
			var form = $("#registForm")
			form.attr("method", "POST");
			form.attr("action", "/addNewMember");
			form.submit();
		});
		
		$("#cancel").click( function() {
			var answer = confirm('정말 이동하시겠습니까?')
			if(answer == true){
				window.location = "<c:url value="/list" />";
			}
			else
				return false;
		});
		
	});
</script>
<div id="regist">
	<form id="registForm">
		<table>
			<tr>
				<td>NICK_NAME</td>
				<td><input type="text" id="newNickName" name="newNickName" /></td>
			</tr>
			<tr>
			<tr>
				<td>PASSWORD</td>
				<td colspan="2"><input type="password" id="newPassword" name="newPassword" /></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td colspan="2"><input type="email" id="newEmail" name="newEmail" /></td>
			</tr>
		</table>
		<input type="button" id="btnRegist" name="btnRegist" value="regist" />
		<input type="button" id="cancel" value="calcel" />
	</form>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>