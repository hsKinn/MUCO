<!--  이기연  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/indexHeader.jsp"></jsp:include>

<!--scripts loaded here from cdn for performance -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
<script src="<c:url value="/resource/js/scripts.js" />"></script>
<script type="text/javascript">
$(document).ready(function() {
   $("#join").hide();
   $("#login").hide();
   $("#letsJoin").click(function() {
      $("#login").hide();
      $("#join").animate({
         height : 'toggle'
      });
   });
   $("#letsLogIn").click(function() {
      $("#join").hide();
      $("#login").animate({
         height : 'toggle'
      });
   });
   
   // 회원 가입 
   $("#btnJoin").click(function() {
      var userEmail = $("#SignUpUserEmail").val();
      userEmail = $.trim(userEmail);
      if (userEmail == "") {
         alert("이메일을 입력하세요!");
         $("#SignUpUserEmail").focus();
         return;
      }
      var userPassword = $("#userPassword").val();
      userPassword = $.trim(userPassword);
      if (userPassword == "") {
         alert("비밀번호를 입력하세요!");
         $("#userPassword").focus();
         return;
      }
      var userName = $("#userName").val();
      userName = $.trim(userName);
      if (userName == "") {
         alert("닉네임을 입력하세요!");
         $("#userName").focus();
         return;
      }
      var form = $("#joinForm");
      form.attr("method", "post");
      form.attr("action", "<c:url value="/doJoin"/>");
      form.submit();
   });
   
   // 로그인 
   $("#btnLogin").click(function() {
      var form = $("#loginForm");
      form.attr("method", "post");
      form.attr("action", "<c:url value="/doLogin"/>")
      form.submit();
   });
   
   //가입 체크 alert 
   $("#SignUpReEnterPasswordCheck").hide();
   $("#SignUpPasswordCheck").hide();
   $("#SignUpNickNameCheck").hide();
   $("#SignUpEmailCheck").hide();
   $("#SignUpInputCheck").hide();
   
   //로그인 체크 alert
   $("#LoginEmailCheck").hide();
   
   //가입 체크
     $("#SignUpUserEmail").blur(function() {
		$.post("<c:url value="/signUpEmailCheck" />", {
			"email" : $("#SignUpUserEmail").val()
		}, function(data) {
			var jsonData = {};
			try {
				jsonData = JSON.parse(data);
			} catch (e) {
			}
			if (jsonData.result) {
				//isExistName : true 존재 O 불가능
				if (jsonData.isExistName) {
					$("#SignUpUserEmail").val("");
					$("#SignUpUserEmail").focus();
					$("#SignUpEmailCheck").show();
					$("#submit").removeAttr("disabled");
				//isExistName : false 존재 X 가능 
				} else {
					$("#SignUpEmailCheck").hide();
					$("#submit").attr("disabled", true);
				}
			} else {
				alert("세션을 종료합니다.");
				location.href = "<c:url value="/" />";
			}
		});
	});	
   
   
});
</script>

    <header id="first">
        <div class="header-content">
            <div class="inner">
                <h1 class="cursive">Travel with Travery!</h1>
                <h4>Searching fit travel place with awesome Travery searching service</h4>
                <hr>
                <a href="#one" class="btn btn-primary btn-xl page-scroll">Get Started</a>
            </div>
        </div>
        <video autoplay="" loop="" class="fillWidth fadeIn wow collapse in" data-wow-delay="0.5s" poster="https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg" id="video-background">
            <source src="https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4" type="video/mp4">Your browser does not support the video tag. I suggest you upgrade your browser.
        </video>
    </header>
    
    
    <section class="bg-primary" id="one">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center">
                    <h2 class="margin-top-0 text-primary">Get Started Travery</h2>
                    <br>
                    <p class="text-faded">
                       Does not have Travery account? Join us!<br/>
                       If have, Enjoy Travery!
                    </p>
                    <a id="letsJoin" class="btn btn-default btn-xl page-scroll">Sign Up</a> &nbsp;
                    <a id="letsLogIn" class="btn btn-default btn-xl page-scroll">Login</a>
                    <div class="clear"></div>
               <div id="index">
               
                  <div id="join" style="margin:auto;">
                     <form id="joinForm">
                        <input type="email" class="form-control"   tabindex="1" id="SignUpUserEmail" name="SignUpUserEmail" placeholder="Email" >
                        <input type="password" class="form-control"   tabindex="2" id="SignUpuserPassword" name="SignUpuserPassword" placeholder="Password" >          
                        <input type="password" class="form-control"   tabindex="3" id="SignUpuserPasswordCheck" name="SignUpuserPasswordCheck" placeholder="Re-Enter Password" >          
                        <input type="text" class="form-control"   tabindex="4" id="SignUpuserName" name="SignUpuserName" placeholder="Nick name" >
                        <br/>   
						<div class="alert alert-info" id="SignUpEmailCheck">
							<strong>Email !</strong> You have already Travery account. 
							<br/>
							<a href="#" style="color:#333333;"><strong>Forgot your password? come here!</strong></a>
						</div>    
						<div class="alert alert-info" id="SignUpNickNameCheck">
							<strong>User name !</strong> This nick name is already taken. Please choose another nick name.
						</div>    
						<div class="alert alert-info" id="SignUpPasswordCheck">
							<strong>Password !</strong> Enter at least 6 character.
						</div>    
						<div class="alert alert-info" id="SignUpReEnterPasswordCheck">
							<strong>Password !</strong> Please enter your password correctly.
						</div>    
						<div class="alert alert-info" id="SignUpInputCheck">
							<strong>Upps!</strong> Do not forget to input information.
						</div>    
						                 
                        <label>
                           <a class="btn btn-primary btn-xl page-scroll">Let's Join!</a>
                           <input type="button" id="btnJoin" tabindex="5" value="Signup" style="display:none;"/>
                        </label>
                     </form>
                  </div>
                  
                  
                  <div id="login" style="margin:auto;">
                     <form id="loginForm">
                        <input type="text" class="form-control"   tabindex="1" id="LoginUserEmail" name="userEmail" placeholder=" Email" >
                        <input type="password" class="form-control"   tabindex="2" id="userPw" name="userPw" placeholder=" Password" > 
                        <br/>
                        <div class="alert alert-info" id="LoginEmailCheck">
							<strong>Upps !</strong> Please enter your email correctly.
							<br/>
							<a href="#" style="color:#333333;"><strong>Don't you have Travey account? Join us!</strong></a>
						</div>   
                        <label>
                           <a class="btn btn-primary btn-xl page-scroll">Let's fun!</a>
                           <input type="button" id="btnLogin" tabindex="3" value="Login" style="display:none;" />
                        </label> 
                     </form>
                  </div>  

               </div>
       
   
                    
                </div>
            </div>
        </div>
    </section>
    <section id="two">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="margin-top-0 text-primary">Travery Service</h2>
                    <hr class="primary">
                    <br/>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="feature">
                        <i class="icon-lg glyphicon glyphicon-phone wow fadeIn" data-wow-delay=".3s"></i>
                        <h3>Travery SNS</h3>
                        <p class="text-muted">Share your travel place with everybody</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="feature">
                        <i class="icon-lg glyphicon glyphicon-globe wow fadeInUp" data-wow-delay=".2s"></i>
                        <h3>Search</h3>
                        <p class="text-muted">Easy to search travel place with visualization searching tool</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="feature">
                        <i class="icon-lg glyphicon glyphicon-calendar wow fadeIn" data-wow-delay=".3s"></i>
                        <h3>Reservation</h3>
                        <p class="text-muted">Reserve the hotel, air plane, etc...</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="three" class="no-padding">
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d">
                        <img src="//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d" class="img-responsive" alt="Image 1">
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg">
                        <img src="//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg" class="img-responsive" alt="Image 2">
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4">
                        <img src="//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4" class="img-responsive" alt="Image 3">
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg">
                        <img src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg" class="img-responsive" alt="Image 4">
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg">
                        <img src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg" class="img-responsive" alt="Image 5">
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="gallery-box" data-toggle="modal" data-src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg">
                        <img src="//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg" class="img-responsive" alt="Image 6">
                    </a>
                </div>
            </div>
        </div>
    </section>

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>