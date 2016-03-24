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
	
});
</script>

<!-- Personal Info -->


<div id="personalInfoWrapper">
Personal Info

	<table id="personalInfoTable">
		<tr id="photo">
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		
		<tr id="name">
			<td>Username</td>
			<td></td>
			<td></td>
		</tr>
		
		<tr id="Email">
			<td>Email</td>
			<td></td>
			<td></td>
		</tr>
		
		<tr id="Password">
			<td>Password</td>
			<td></td>
			<td></td>		
		</tr>
		
		<tr id="phoneNumber">
			<td>Phonenumber</td>
			<td></td>
			<td></td>
		</tr>
	</table>
</div>





	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>