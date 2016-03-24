<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnIdCheck").click(function() {
			if ( document.registForm.nickName.value == "" ) {
				alert("ID란에 공백이있습니다.");
				return false;
			}
			$.post(
					"/admin/idDuplicationCheck"
					, {
						"nickName" : $("#nickName").val()
						}
					//callback구간을 달아줘야함. 응답데이터도 우리가 직접 적어줘야함. 성공여부는 확인불가.
					, function(data) {
											
						var jsonData = {};
						
						try {
							jsonData = JSON.parse(data);
						}
						catch(e) {
							jsonData.result = false;
						}
						
						/* console.log(jsonData); */
																
						if ( jsonData.result ) {
							if ( jsonData.checkData ) {
								alert("중복된아이디입니다.");
								$("#nickName").val();
							} else {
								alert("사용가능한 아이디입니다.");
								var answer = confirm('사용하시겠습니까?')
								if(answer == true){
									document.registForm.nickName.value=$("#nickName").val();
								}
								else {
									$("#nickName").empty();
								}							
							}
						}/* 
						else {
							alert("세션만료. 재로그인필요.");
							location.href = "/admin";
						} */
					});
				});
		
		$("#btnRegist").click(function() {
			
			if ( !document.registForm.nickName.value) {
				alert("ID를 입력하세요");
				return false;
			}
			if ( !document.registForm.password.value) {
				alert("PWD를 입력하세요");
				return false;
			}
			if ( document.registForm.password.value != document.registForm.checkPwd.value) {
				alert("PWD를 동일하게 입력하세요");
				return false;
			}
			if ( !document.registForm.email.value ) {
				alert("이메일을 입력하세요");
				return false;
			}
			var form = $("#registForm")
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/addNewMember" />");
			
			alert("회원가입이 완료 되었습니다.");
			form.submit();
		});
		$("#cancel").click( function() {
			var answer = confirm('정말 이동하시겠습니까?')
			if(answer == true){
				window.location = "<c:url value="/memberInformation" />";
			}
			else
				return false;
		});
	});
</script>
<div id="regist">
	<form id="registForm" name="registForm">
		<table>
			<tr>
				<td>NICK_NAME</td>
				<td><input type="text" id="nickName" name="nickName" /></td>
				<td><input type="button" id="btnIdCheck" name="btnIdCheck" value="IDCheck"/></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td colspan="2"><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td>PASSWORD(check)</td>
				<td colspan="2"><input type="password" id="checkPwd" name="checkPwd" /></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td colspan="2"><input type="email" id="email" name="email" /></td>
			</tr>
		</table>
		<input type="button" id="btnRegist" name="btnRegist" value="regist" />
		<input type="button" id="cancel" value="cancel" />
	</form>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>