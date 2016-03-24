<!-- 이기연 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function() {

	$("#personalInfoMenu").mouseout(function(){
		$("#personalInfoMenu").css("color", "#ffffff");
	});
	$("#personalInfoMenu").css("color", "#ffffff");
	
	$("#name").mouseenter(function(){
		cursor
	});
	
	$("#editProfile").hover(function(){
		$("#editProfile").css("color", "#333333");
	});
	$("#editProfile").mouseout(function(){
		$("#editProfile").css("color", "#808080");
	});
	
	$("#editName").hover(function(){
		$("#editName").css("color", "#333333");
	});
	$("#editName").mouseout(function(){
		$("#editName").css("color", "#808080");
	});
	
	$("#editPassword").hover(function(){
		$("#editPassword").css("color", "#333333");
	});
	$("#editPassword").mouseout(function(){
		$("#editPassword").css("color", "#808080");
	});
	
	$("#editPhoneNumber").hover(function(){
		$("#editPhoneNumber").css("color", "#333333");
	});
	$("#editPhoneNumber").mouseout(function(){
		$("#editPhoneNumber").css("color", "#808080");
	});	
});
</script>

<!-- Personal Info -->

<div class="well" id="personalInfoWrapper">
<h1>Personal Info</h1>

	<form>
	<table class="table">
		<tr id="photo">
			<th>Photo</th>
			<td>
				<c:if test="${ empty mainImageLocation }" >
					<img id="profile" class="img-circle" src="<c:url value="/resource/img/member/default-profile.png"/>" />
				</c:if>
				
				<c:if test="${ not empty mainImageLocation }" >
					사용자가 등록한 img 출력	
				</c:if>
				
			</td>
			<td><span class="glyphicon glyphicon-pencil" id="editProfile"></span></td>
		</tr>
		
		<tr id="name">
			<th>Username</th>
			<td>${ name }</td>
			<td><span class="glyphicon glyphicon-pencil" id="editName"></span></td>
		</tr>
		
		<tr id="email">
			<th>Email</th>
			<td colspan="2">${ email }</td>
		</tr>
		
		<tr id="password">
			<th>Password</th>
			<td> ********</td>
			<td><span class="glyphicon glyphicon-pencil" id="editPassword"></span></td>
		</tr>
		<tr style="background-color:red">
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr style="background-color:blue">
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>		
		
		<tr id="phoneNumber">
			<th>Phonenumber</th>
			<td>${ phoneNumber }</td>
			<td><span class="glyphicon glyphicon-pencil" id="editPhoneNumber"></span></td>
		</tr>
	</table>
	</form>
	
</div> <!-- personalInfoWrapper : close -->





	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>