<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/test.css"/>" />

<!-- Boot strap -->
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://www.w3schools.com/lib/w3-theme-teal.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jVector Map -->
<link rel="stylesheet" media="all"
	href="<c:url value="/resource/css/place/jquery-jvectormap-2.0.3.css"/>" />

<title>Travery</title>
<script type="text/javascript"
	src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resource/js/json2.js" />"></script>

<!-- Boot strap -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Share Package -->
<script type="text/javascript">
$(document).ready(function() {
	
    $('a[title]').tooltip();

    $('.btn-submit').on('click', function(e) {

        var formname = $(this).attr('name'); 
        var tabname = $(this).attr('href');
        
        if ($('#' + formname)[0].checkValidity()) { /* Only works in Firefox/Chrome need polyfill for IE9, Safari. http://afarkas.github.io/webshim/demos/ */
            e.preventDefault();
            $('ul.nav li a[href="' + tabname + '"]').parent().removeClass('disabled');
            $('ul.nav li a[href="' + tabname + '"]').trigger('click');
        }

    });

    $('ul.nav li').on('click', function(e) {
        if ($(this).hasClass('disabled')) {
            e.preventDefault();
            return false;
        }
    }

});

</script>


<body>


<section style="background:#efefe9;">
	<div id="clear" >
        <div class="container">
            <div class="row">
                <div class="board">
                    <!-- <h2>Welcome to IGHALO!<sup>™</sup></h2>-->
                    <div class="board-inner">
                    <ul class="nav nav-tabs" id="myTab">
                    <div class="liner"></div>
                     <li class="active">
                     <a href="#home" data-toggle="tab" title="welcome">
                      <span class="round-tabs one">
                              <i class="glyphicon glyphicon-home"></i>
                      </span> 
                  </a></li>

                  <li class="disabled"><a href="#profile" data-toggle="tab" title="profile">
                     <span class="round-tabs two">
                         <i class="glyphicon glyphicon-user"></i>
                     </span> 
                    </a>
                 </li>
                 <li class="disabled"><a href="#messages" data-toggle="tab" title="bootsnipp goodies">
                     <span class="round-tabs three">
                          <i class="glyphicon glyphicon-gift"></i>
                     </span> </a>
                     </li>

                   

                     
                     
                     </ul></div>

                     <div class="tab-content">
                      <div class="tab-pane fade in active" id="home">

                          
                        <form class="form-horizontal text-center" id="home_form" name="home_form" role="form">
                            <fieldset>
                                    <button type="submit" href="#profile" name="home_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                            </fieldset>
                        </form>  

                      </div>
                      <div class="tab-pane fade" id="profile">
                          <h3 class="head text-center">Create a Bootsnipp<sup>™</sup> Profile</h3>
                          <p class="narrow text-center">
                              Lorem ipsum dolor sit amet, his ea mollis fabellas principes. Quo mazim facilis tincidunt ut, utinam saperet facilisi an vim.
                          </p>
                          
                        <form class="form-horizontal text-center" id="profile_form" name="profile_form" role="form">
                            <fieldset>
                                    <button type="submit" href="#messages" name="profile_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                            </fieldset>
                        </form>  
                          
                      </div>
                      <div class="tab-pane fade" id="messages">
                          <h3 class="head text-center">Bootsnipp goodies</h3>
                          <p class="narrow text-center">
                              Lorem ipsum dolor sit amet, his ea mollis fabellas principes. Quo mazim facilis tincidunt ut, utinam saperet facilisi an vim.
                          </p>
                          
                        <form class="form-horizontal text-center" id="messages_form" name="messages_form" role="form">
                            <fieldset>
                                    <button type="submit" href="#settings" name="messages_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                            </fieldset>
                        </form>  
                      </div>
                      <div class="tab-pane fade" id="settings">
                          <h3 class="head text-center">Drop comments!</h3>
                          <p class="narrow text-center">
                              Lorem ipsum dolor sit amet, his ea mollis fabellas principes. Quo mazim facilis tincidunt ut, utinam saperet facilisi an vim.
                          </p>
                          
                        <form class="form-horizontal text-center" id="settings_form" name="settings_form" role="form">
                            <fieldset>
                                    <button type="submit" href="#doner" name="settings_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                            </fieldset>
                        </form>  
                      </div>
                      <div class="tab-pane fade" id="doner">
                          <div class="text-center">
                            <i class="img-intro icon-checkmark-circle"></i>
                        </div>
                        <h3 class="head text-center">thanks for staying tuned! <span style="color:#f48260;">♥</span> Bootstrap</h3>
                        <p class="narrow text-center">
                          Lorem ipsum dolor sit amet, his ea mollis fabellas principes. Quo mazim facilis tincidunt ut, utinam saperet facilisi an vim.
                        </p>
                        </div>
                        <div class="clearfix"></div>
                        </div>

</div>
</div>
</div>
</section>
              
              </div>     

</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
