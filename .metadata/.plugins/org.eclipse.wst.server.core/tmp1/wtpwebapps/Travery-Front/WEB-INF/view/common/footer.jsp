<!-- 이기연 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css"	rel="stylesheet" />
<link rel="stylesheet"	href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/styles.css"/>" />

<!-- Boot strap -->
<footer id="footer">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-6 col-sm-3 column">
				<h4>Information</h4>
				<ul class="list-unstyled">
					<li><a href="<c:url value="/termsAccess?menuNo=1"/>">이용약관</a></li>
					<li><a href="<c:url value="/termsAccess?menuNo=2"/>">개인정보취급방침</a></li>
				</ul>
			</div>
			<div class="col-xs-6 col-sm-3 column">
				<h4>Service Center</h4>
				<ul class="list-unstyled">
					<li><a href="<c:url value="/contactUs"/>">Contact Us</a></li>
					<li><a href="<c:url value="/termsAccess?menuNo=3"/>">Q&amp;A</a></li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-3 column">
				<h4>3 section</h4>
			</div>
			<div class="col-xs-12 col-sm-3 text-right">
				<h4>4 section</h4>
				<ul class="list-inline">
					<li>1 &nbsp;</li>
					<li>2 &nbsp;</li>
					<li>3</li>
				</ul>
			</div>
		</div>
		<br /> <span class="pull-right text-muted small"><a href="#">Travel
				with Travery</a> ©2016 Travery</span>
	</div>
</footer>

<div id="galleryModal" class="modal fade" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<img src="//placehold.it/1200x700/222?text=..." id="galleryImage"
					class="img-responsive" />
				<p>
					<br />
					<button class="btn btn-primary btn-lg center-block"
						data-dismiss="modal" aria-hidden="true">
						Close <i class="ion-android-close"></i>
					</button>
				</p>
			</div>
		</div>
	</div>
</div>
<div id="aboutModal" class="modal fade" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<h2 class="text-center">Landing Zero Theme</h2>
				<h5 class="text-center">A free, responsive landing page theme
					built by BootstrapZero.</h5>
				<p class="text-justify">This is a single-page Bootstrap template
					with a sleek dark/grey color scheme, accent color and smooth
					scrolling. There are vertical content sections with subtle
					animations that are activated when scrolled into view using the
					jQuery WOW plugin. There is also a gallery with modals that work
					nicely to showcase your work portfolio. Other features include a
					contact form, email subscribe form, multi-column footer. Uses
					Questrial Google Font and Ionicons.</p>
				<p class="text-center">
					<a href="http://www.bootstrapzero.com">Download at
						BootstrapZero</a>
				</p>
				<br />
				<button class="btn btn-primary btn-lg center-block"
					data-dismiss="modal" aria-hidden="true">OK</button>
			</div>
		</div>
	</div>
</div>

</body>
</html>