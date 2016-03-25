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

<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	// menu에서 jquery 색상 
	$("#personalInfoMenu").mouseout(function(){
		$("#personalInfoMenu").css("color", "#ffffff");
	});
	$("#personalInfoMenu").css("color", "#ffffff");
	
	$("#name").mouseenter(function(){
		cursor
	});
	
	// edit icon jquery 색상
	$("#editMainImage").hover(function(){
		$("#editMainImage").css("color", "#333333");
	});
	$("#editMainImage").mouseout(function(){
		$("#editMainImage").css("color", "#808080");
	});
	
	$("#editNameBtn").hover(function(){
		$("#editNameBtn").css("color", "#333333");
	});
	$("#editNameBtn").mouseout(function(){
		$("#editNameBtn").css("color", "#808080");
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
	
	// 수정 row 들은 우선 hide 
	$("#nameForEdit").hide();
	$("#passwordForEdit").hide();
	$("#phoneNumberForEdit").hide();
	
	// name 수정 hide / show 
	$(".editNameBtn").click(function(){
		$("#name").hide();
		$("#nameForEdit").show();
	});
	
	// email 수정불가
	$("#email").click(function(){
		alert("수정할 수 없습니다.")
	});
	
	// password 수정 hide / show 
	$(".editPasswordBtn").click(function(){
		$("#password").hide();
		$("#passwordForEdit").show();
	});
	
	// phonNumber 수정 hide / show 
	$(".editphoneNumberBtn").click(function(){
		$("#phoneNumber").hide();
		$("#phoneNumberForEdit").show();
	});
	
	
	// name modify (cancel)
	// - cancel
	$("#cancelName").click(function() {
		$("#nameForEdit").hide();
		$("#name").show();
	});
	// - save 
	$("#saveName").click(function() {
		$.post( //파라미터 3개 가지고 있음 
				"/personalInfoAction" //어디로 요청
				, { "name" : $("#name").val() } //뭘 준다.  
				, function(data) { // 콜백, 응답해주는것 (우리가 직접 처리해줘야 한다)
					// 방법 3. 
					var jsonData = {}
					try {
						jsonData = JSON.parse(data);
					} catch (e) {
						jsonData.result = false;
					}
					
					alert(jsonData);
					console.log(jsonData);
					
					if ( jsonData.result ) {
						var text = $("#name").text();
						if (jsonData.isFavorite) {
							$("#favorite").text("♥");
						} 
						else {
							$("#favorite").text("♡");
						}
					} else {
						alert("세션이 완료되었습니다.");
						location.href="/";
					}
				}  
				
			);
	});	
	
	// password 
	// - cancel	
	$("#cancelPassword").click(function() {
		$("#passwordForEdit").hide();
		$("#password").show();
	});
	
	// phonenumber
	// - cancel	
	$("#cancelPhoneNumber").click(function() {
		$("#phoneNumberForEdit").hide();
		$("#phoneNumber").show();
	});		
		
	// 최종 save 
	
	$('[data-toggle="popover"]').popover(); 
	
});
</script>


<!-- Personal Info -->

<div class="well" id="personalInfoWrapper">
<h1>Personal Info</h1>

	<form id="personalInfoForm" method="post" action="/personalInfoAction" enctype="multipart/Form-data">
	<table class="table" id="personalInfoTable">
		
		<!-- 사진 -->
		<tr id="photo">
			<td></td>
			<th>Photo</th>
			<td>
				<c:if test="${ empty mainImageLocation }" >
					<img id="profile" class="img-circle" src="<c:url value="/resource/img/member/default-profile.png"/>" />
					<br/>
					사진을 등록해주세요
				</c:if>
				
				<c:if test="${ not empty mainImageLocation }" >
					<img id="profile" class="img-circle" />
				</c:if>
			</td>
			<td>
				<span class="glyphicon glyphicon-camera" id="editMainImage"></span>
				<br/>
				<input type="file" id="file" name="file" />
			</td>
		</tr>
		
		<!-- 이름 -->
		<tr id="name">
			<td></td>
			<th>Username</th>
			<td class="editNameBtn">${ name }</td>
			<td><span class="glyphicon glyphicon-pencil editNameBtn" id="editNameBtn" ></span></td>
		</tr>
		<tr id="nameForEdit" >
			<td><span class="glyphicon glyphicon-ok-circle" style="color:darkblue;"></span></td>
			<th>Username</th>
			<td colspan="2">
				<input type="text" placeholder="Username" name="name" value="${name}"/> <br />
				<span id="validationCheck"></span>
				<span id="cancelName">Cancel</span>
			</td>
		</tr>	
		
		<!-- 이메일 -->
		<tr id="email">
			<td></td>
			<th>Email</th>
			<td colspan="2">${ email }</td>
		</tr>
		
		
		<!-- 비밀번호 -->
		<tr id="password">
			<td></td>
			<th>Password</th>
			<td class="editPasswordBtn"> ********</td>
			<td><span class="glyphicon glyphicon-pencil editPasswordBtn" id="editPassword"></span></td>
		</tr>
		
		<tr id="passwordForEdit">
			<td><span class="glyphicon glyphicon-ok-circle" style="color:darkblue;"></span></td>
			<th>Password</th>
			<td colspan="2">
				<input type="password" name="currentPassword" placeholder="Current Password" />
				<br/>
				<br/>
				<input type="password" name="newPassword" placeholder="New Password" />
				<br/>
				<br/>
				<input type="password" name="newPasswordCheck" placeholder="New Password check" />
				<br/>
				<br/>
				<span id="cancelPassword">Cancel</span>
			</td>
		</tr>
		
		<!-- 연락처 -->
		<tr id="phoneNumber">
			<td>
				<a href="#" data-toggle="popover" title="Phone Number?" data-content="여행 예약을 위해 필요한 항목">
					<span class="glyphicon glyphicon-question-sign"></span>
				</a>			
			</td>
			<th>phoneNumber</th>
			<td class="editphoneNumberBtn">
				<c:if test="${ empty phoneNumber }">
					입력된 전화번호가 없습니다.
				</c:if>
				<c:if test="${ not empty phoneNumber }">
					${ phoneNumber }
				</c:if>
			</td>
			<td><span class="glyphicon glyphicon-pencil editphoneNumberBtn" id="editPhoneNumber"></span></td>
		</tr>
		
		<tr id="phoneNumberForEdit">
			<td>
			</td>
			<th>phoneNumber</th>
			<td colspan="2">
				<input type="text" name="phoneNumber" placeholder="phoneNumber" value="${ phoneNumber }"/> <br/> <br/>
				<span id="cancelPhoneNumber">Cancel</span>
			</td>
		</tr>			
		
		
		<tr>
		<td colspan="3">
			<br/>
			<input type="submit" class="btn btn-default" value="save"></input>
		</td>
		</tr>
	</table>
	</form>
	
</div> <!-- personalInfoWrapper : close -->


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>