<!--  이기연  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!--scripts loaded here from cdn for performance -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
<script src="<c:url value="/resource/js/scripts.js" />"></script>
<script type="text/javascript">
	// 사진 미리보기
	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$(document).ready(function() {

		// 수정 row 들은 우선 hide 
		$("#nameForEdit").hide();
		$("#passwordForEdit").hide();
		$("#phoneNumberForEdit").hide();
		$("#nameAlertMsg").hide();
		$("#currentPasswordAlertMsg").hide();
		$("#newPasswordAlertMsg").hide();

		// name 수정 hide / show 
		$(".editNameBtn").click(function() {
			$("#name").hide();
			$("#nameForEdit").show();
		});

		// email 수정불가
		$("#email").click(function() {
			alert("수정할 수 없습니다.")
		});

		// password 수정 hide / show 
		$(".editPasswordBtn").click(function() {
			$("#password").hide();
			$("#passwordForEdit").show();
		});

		// phonNumber 수정 hide / show 
		$(".editphoneNumberBtn").click(function() {
			$("#phoneNumber").hide();
			$("#phoneNumberForEdit").show();
		});

		// name modify (cancel)
		// - cancel
		$("#cancelName").click(function() {
			$("#nameForEdit").hide();
			$("#nameInput").val("${name}");
			$("#nameAlertMsg").hide();
			$("#name").show();
		});

		$("#nameInput").blur(function() {

			$.post("<c:url value="/nameCheck" />", {
				"name" : $("#nameInput").val()
			}, function(data) {

				var jsonData = {};

				try {
					jsonData = JSON.parse(data);
				} catch (e) {
				}

				if (jsonData.result) {
					if (jsonData.isExistName || $("#nameInput").val() == "") {
						$("#alertMsg").show();
						$("#nameInput").val("");
						$("#nameInput").focus();

						$("#nameIcon").css("color", "red");
						$("#submit").attr("disabled", true);
					} else {
						$("#nameAlertMsg").hide();
						$("#nameIcon").css("color", "darkblue");

						$("#submit").removeAttr("disabled");
					}
				} else {
					alert("세션을 종료합니다.");
					location.href = "<c:url value="/" />";
				}

			});

		});

		// password 
		// - cancel	
		$("#cancelPassword").click(function() {
			$("#passwordForEdit").hide();
			$("#currentPassword").val("");
			$("#newPassword").val("");
			$("#newPasswordCheck").val("");
			$("#currentPasswordAlertMsg").hide();
			$("#newPasswordAlertMsg").hide();

			$("#password").show();
		});

		// 기존 비밀번호가 일치하는지 체크하기 
		$("#currentPassword").blur(function() {
			var password = "${password}";
			if ($("#currentPassword").val() == password) {
				$("#currentPasswordAlertMsg").hide();
				$("#passwordIcon").css("color", "darkblue");
			} else {
				$("#currentPasswordAlertMsg").show();
				$("#currentPassword").val("");
				$("#currentPassword").focus();
				$("#passwordIcon").css("color", "red");

			}
		});

		// new password 2개 맞는지 체크하기 
		$("#newPasswordCheck").blur(function() {

			if ($("#newPasswordCheck").val() == $("#newPassword").val()) {
				$("#newPasswordAlertMsg").hide();
				$("#submit").removeAttr("disabled");
				$("#passwordIcon").css("color", "darkblue");

			} else {
				$("#newPasswordAlertMsg").show();
				$("#submit").attr("disabled", true);
				$("#passwordIcon").css("color", "red");
			}

		});
		$("#newPassword").blur(function() {

			if ($("#newPasswordCheck").val() == $("#newPassword").val()) {
				$("#newPasswordAlertMsg").hide();
				$("#submit").removeAttr("disabled");
				$("#passwordIcon").css("color", "darkblue");

			} else {
				$("#newPasswordAlertMsg").show();
				$("#submit").attr("disabled", true);
				$("#passwordIcon").css("color", "red");
			}

		});

		// phonenumber
		// - cancel	
		$("#cancelPhoneNumber").click(function() {
			$("#phoneNumberForEdit").hide();
			$("#inputPhoneNumber").val("${phoneNumber}");
			$("#phoneNumber").show();
		});

		// tool tips 
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});

		//validation check

	});
</script>


<!-- Personal Info -->
<section class="bg-primary" id="one">
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">Personal Info</h2>
			<hr class="primary">
			<p>회원 정보를 수정할 수 있습니다.</p>
		</div>

		<form id="personalInfoForm" method="post" action="/personalInfoAction"
			enctype="multipart/Form-data">
			<table class="table" id="personalInfoTable">

				<!-- 사진 -->
				<tr id="photo">
					<td><a href="#" data-toggle="tooltip" title="자신의 사진을 등록해주세요!">
							<span class="glyphicon glyphicon-question-sign"></span>
					</a></td>
					<th>Photo</th>
					<td style="text-align: center;"><c:if
							test="${ empty mainImageLocation }">
							<label> <img id="blah" class="img-circle"
								src="<c:url value="/resource/img/member/default-profile.png"/>" />
								<input type="file" id="file" name="file"
								onchange="readURL(this);" style="display: none;"
								accept="image/*" required />
							</label>
							<br />
							<b>사진을 등록해주세요</b>
						</c:if> <c:if test="${ not empty mainImageLocation }">
							<img id="blah" class="img-circle" src="/profileImageDownload"
								style="width: 85px; height: 85px;"
								onclick="doImgPop('/profileImageDownload')" />
							<br />
						</c:if></td>
					<td><br /> <label> <span
							class="glyphicon glyphicon-camera" id="editMainImage"
							style="cursor: pointer;"></span> <input type="file" id="file"
							name="file" onchange="readURL(this);" style="display: none;"
							accept="image/*" />
					</label> <br /></td>
				</tr>

				<!-- 이름 -->
				<tr id="name">
					<td></td>
					<th>User name</th>
					<td class="editNameBtn" style="cursor: auto;">${ name }</td>
					<td><span class="glyphicon glyphicon-pencil editNameBtn"
						id="editNameBtn"></span></td>
				</tr>
				<tr id="nameForEdit">
					<td><span id="nameIcon" class="glyphicon glyphicon-ok-circle"
						style="color: darkblue;"></span></td>
					<th>Username</th>
					<td colspan="2" style="text-align: center;"><input type="text"
						class="form-control" placeholder="Username" name="name"
						value="${name}" id="nameInput">
						<div id="nameAlertMsg" class="alert alert-danger" role="alert">
							<b>Oh snap!</b>사용할 수 없는 이름입니다.
						</div> <br />
						<button type="button" class="btn btn-default btn-sm"
							id="cancelName">Cancel</button></td>
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
					<td class="editPasswordBtn" style="cursor: auto;">********</td>
					<td><span class="glyphicon glyphicon-pencil editPasswordBtn"
						id="editPassword"></span></td>
				</tr>

				<tr id="passwordForEdit">
					<td><span id="passwordIcon"
						class="glyphicon glyphicon-ok-circle" style="color: darkblue;"></span></td>
					<th>Password</th>
					<td colspan="2" style="text-align: center;"><input
						type="password" class="form-control" id="currentPassword"
						name="currentPassword" placeholder="Current Password"> <input
						type="password" class="form-control" id="newPassword"
						name="newPassword" placeholder="New Password"> <input
						type="password" class="form-control" id="newPasswordCheck"
						name="newPasswordCheck" placeholder="New Password check">
						<br />
						<div id="currentPasswordAlertMsg" class="alert alert-danger"
							role="alert">
							<b style="color: red;">Oh snap! </b>기존 비밀번호를 다시 입력하세요
						</div>
						<div id="newPasswordAlertMsg" class="alert alert-danger"
							role="alert">
							<b style="color: red;">Oh snap!</b>새 비밀번호가 일치하지 않습니다
						</div> <br />
						<button type="button" class="btn btn-default btn-sm"
							id="cancelPassword">Cancel</button></td>
				</tr>

				<!-- 연락처 -->
				<tr id="phoneNumber">
					<td><a href="#" data-toggle="tooltip"
						title="여행 예약을 하고 싶다면 필수!"> <span
							class="glyphicon glyphicon-question-sign"></span>
					</a></td>
					<th>PhoneNumber</th>
					<td class="editphoneNumberBtn" style="cursor: auto;"><c:if
							test="${ empty phoneNumber }">
							입력된 전화번호가 없습니다.
					</c:if> <c:if test="${ not empty phoneNumber }">
							${ phoneNumber }
					</c:if></td>
					<td><span
						class="glyphicon glyphicon-pencil editphoneNumberBtn"
						id="editPhoneNumber"></span></td>
				</tr>

				<tr id="phoneNumberForEdit">
					<td><span class="glyphicon glyphicon-ok-circle"
						style="color: darkblue;"></span></td>
					<th>PhoneNumber</th>
					<td colspan="2" style="text-align: center;"><input type="text"
						id="inputPhoneNumber" class="form-control" name="phoneNumber"
						placeholder="phoneNumber" value="${ phoneNumber }"> <br />
						<button type="button" class="btn btn-default btn-sm"
							id="cancelPhoneNumber">Cancel</button></td>
				</tr>


				<tr>
					<td colspan="4" style="text-align: center;"><br /> 
					<label>
						<a class="btn btn-default btn-xl page-scroll">save</a>
						<input
							type="submit" id="submit" class="btn btn-default" value="save" style="display:none;"></input>
					</label>
					</td>
				</tr>
			</table>


		</form>
	</div>
</section>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>