<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/login.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
<style>
div#registerFormDiv {
	align: center;
}
</style>

<script type="text/javascript">
	$(document).ready( function() {
		
		$("#doRegister").click( function() {
			
			// ID Check
			var id = $("#id").val();
			id = $.trim( id );
			if ( id == "" ) {
				alert("ID 입력");
				$("#id").focus();
				return;
			}
			
			// PASSWORD Check
			var password = $("#password").val();
			password = $.trim( password );
			if ( password == "" ) {
				alert("PASSWORD 입력");
				$("#password").focus();
				return;
			}
			
			// NICKNAME Check
			var nickname = $("#nickname").val();
			nickname = $.trim( nickname );
			if ( nickname == "" ) {
				alert("NICKNAME 입력");
				$("#nickname").focus();
				return;
			}
			
			// E-MAIL Check
			var email = $("#email").val();
			email = $.trim( email );
			if ( email == "" ) {
				alert("E-MAIL 입력");
				$("#email").focus();
				return;
			}
			
			// FOAM Submit
			var form = $("#registerForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/addNewMember"/>");
			form.submit();
			
		} );
		
		$("#cancle").click( function() {
			
			location.href="<c:url value="/"/>";
			
		} );
		
	} );
</script>   
<table align="center" width="400px">
	<tr>
		<td>
			<form id="registerForm">
				<table>
					<tr>
						<th align="right">ID :</th>
						<td>
							<input  type="text" id="id" name="id" style="width: 250px;" />
						</td>
					</tr>
					<tr>
						<th align="right">Password :</th>
						<td>
							<input type="password" id="password" name="password" style="width: 250px;" />
						</td>
					</tr>
					<tr>
						<th align="right">닉네임 :</th>
						<td>
							<input type="text" id="nickname" name="nickname" style="width: 250px;" />
						</td>
					</tr>
					<tr>
						<th align="right">E-mail :</th>
						<td>
							<input type="email" id="email" name="email" style="width: 250px;" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr align="center">
			<td>
				<input type="button" id="doRegister" value="등록!" />
				<input type="reset" value="다시 쓰기" />
				<input type="button" id="cancle" value="취소" />
			</form>
			</td>
		</tr>
</table>
