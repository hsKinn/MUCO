<!-- 김현섭 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
 --%>
 
 <!-- Jquery, Json Script -->
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resource/js/json2.js" />"></script>
 
<!-- Boot Script -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/detailPlace.css"/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/hitTheRoad.css"/>" />

<!-- Share Package -->
<script type="text/javascript">
	$(document).ready(function() {
		
	    $('.thumb').hover(function(){
	          $('.main_image img').attr('src',$(this).children('img').attr('src'));
	    });
		
		$(".doNotVote").click( function() {
			
			alert("Already Vote.");
		});
		
		$("#voteSubmit").click( function() {
			
			var form = $("#voteForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/doVote"/>");
			form.submit();
		});
		
		$("#reportSubmit").click( function() {
			
			var form = $("#reportForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/doReport"/>");
			form.submit();
		});
		
		$("#addMyPackOnePlace").click( function() {
			
			var form = $("#addMyPackForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/addMyPackByOnePlace"/>");
			form.submit();
		});
		
		$("#addPhotoUpload").click( function() {
			
			var form = $("#addPhotoForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/addPlacePhoto"/>");
			form.submit();			
		});
	
		$("#writePlaceReplyBtn").click( function() {
			
			var description = $("#description").val();
			description = $.trim(description);
			if ( description == "" ) {
				alert("댓글을 입력해주세요");
				$("#description").focus();
				return;
			}
			
			var form = $("#writePlaceReplyForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/doWritePlaceReply"/>");
			form.submit();
		});
		
		$("#description").keyup(function(e) {
			if (e.keyCode == 13) {
				$("#writePlaceReplyBtn").click();
			}
		});
		
		$(".placeLike").click( function() {
			
			$.post(
					"/placeLike"
					, { "placeId" : "${place.placeId}" } 
					, function(data) {
						
						var jsonData4 = {};
						
						try {
							jsonData4 = JSON.parse(data);
						}
						catch(e) {
							jsonData4.result = false;							
						}
						
						if ( jsonData4.result) {
							// 하트를 넣음
							var text = $(".placeLike").text();
							if ( jsonData4.isplaceLike ) {
								$(".placeLike").text("Like ♥");							
							}
							else {
								$(".placeLike").text("Like ♡");	
							}
						}
						else {
							alert("세션 만료");
							location.href = "/";
						}
					}
			  );
		});
		
		var rangeSlider = function(){
			  var slider = $('.range-slider'),
			      range = $('.range-slider__range'),
			      value = $('.range-slider__value');
			    
			  slider.each(function(){
	
			    value.each(function(){
			      var value = $(this).prev().attr('value');
			      $(this).html(value);
			    });
	
			    range.on('input', function(){
			      $(this).next(value).html(this.value);
			    });
			  });
			};
	
			rangeSlider();		
	});

</script>
<c:set var="loginEmail" value="${ sessionScope._MEMBER_.email }" />

<!-- Detail Place Content by hskim -->

		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">Detail Place Page</h2>
			<hr class="primary">
			<p>Place의 상세 정보를 확인하세요</p>
		</div>
		
		<div id="addMyPack">
			<form id="addMyPackForm">
			<span id="myPackList">
				Add My Package : 
					<select name="packList" id="packList">
						<c:if test="${ not empty loginUserPackList }">
							<option value="0">Your Packages</option>
								<c:forEach items="${ loginUserPackList }" var="myPack">
									<option value="${ myPack.packId }">${ myPack.packTitle }</option>
								</c:forEach>
								<input type="hidden" id="placeId" name="placeId" value="${place.placeId}" />
						</c:if>
						<c:if test="${ empty loginUserPackList }">
							<option value="0">Not Exist Packages</option>
						</c:if>
					</select>
				<span id="addMyPackOnePlace">
	   				<span class="glyphicon glyphicon-plus" style="cursor:pointer;"></span>
	   			</span>
   			 </span>
		 	</form>
		</div>		
		
		<div id="detail-Wrapper">
			
			<div id="detail-LeftWrapper">
				
				<div class="gallery">
					<div id="photo-Top">
						<div class="main_image">
							<img src="/image?imageName=${ imageList[0].imageName }" />
						</div>
					</div>
					
					<div id="photo-Bottom">
						<c:forEach items="${ imageList }" var="images">
							<div class="selection_image">
								<div id="photos">
									<div class="thumb">
				    		     		<div class="overlay"></div>
						    		    <img src="/image?imageName=${images.imageName }" />
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					<div id="photoAdd">
						<span id="addPhoto">Add Place Image
						<span id="addPhotoUpload">
				          	<span class="glyphicon glyphicon-upload" style="cursor:pointer;"></span>
	                    </span>
				        </span>
						<form id="addPhotoForm"  enctype="multipart/form-data">
							<input type="file" id="image" name="image" />
							<input type="hidden" id="placeId" name="placeId" value="${ place.placeId }" />
						</form>
					</div>
					
				</div>
			</div>
			
			<div id="detail-RightWrapper">
				<div id="info-Top">
					<div id="place-Reportbtn">
				        <a href="#">
				          <span class="glyphicon glyphicon-ban-circle" data-toggle="modal" data-target="#reportModal"></span>
				        </a>
					</div>
					<div id="place-Title">
						${ place.placeName }, [${ place.countryName }]
					</div>
					<div id="place-LikeCount">
						<span class="badge">
							<span class="glyphicon glyphicon-heart"></span>
							<span id="placeLikeCount">${ place.likeCount }</span>
						</span>
					</div>
				</div>
				<div id="info-Middle">
					<div id="place-Description">
						<textarea readonly="readonly">${ place.placeDescription }</textarea>
					</div>
				</div>
				<div id="info-Vote">
					<div id="vote-Left">
						<c:choose>
							<c:when test="${ place.isExistPlaceLike() }">
								<span class="placeLike">
									Like ♥
								</span>
							</c:when>
							<c:otherwise>
								<span class="placeLike" >
									Like ♡
								</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="vote-Right">
						<c:if test="${ !writer.isExistVote() }">
							<span class="doVote" data-toggle="modal" data-target="#voteModal">
								Vote
							</span>
						</c:if>
						<c:if test="${ writer.isExistVote() }">
							<span class="doNotVote" style="cursor: pointer;">
								Vote
							</span>						
						</c:if>
					</div>
					
					<div class="placeVote">
						<div class="range-slider">
							<table border="1">
								<tr>
									<td colspan="2">Dark</td>
									<td>
										<input class="range-slider__range" type="range" readonly="readonly" min="1" max="100" value="${ place.avgBrightDarkScore }">
										<span class="badge range-slider__value">0</span>
									</td>
									<td colspan="2">Bright</td>
								</tr>
								<tr>
									<td colspan="2">LowPrice</td>
									<td>
										<input class="range-slider__range" type="range" readonly="readonly" min="1" max="100" value="${ place.avgHighPriceLowPriceScore }">
										<span class="badge range-slider__value">0</span>
									</td>
									<td colspan="2">HightPrice</td>
								</tr>
								<tr>
									<td colspan="2">Calm</td>
									<td>
										<input class="range-slider__range" type="range" readonly="readonly" min="1" max="100" value="${ place.avgActiveCalmScore }">
										<span class="badge range-slider__value">0</span>
									</td>
									<td colspan="2">Active</td>
								</tr>
								<tr>
									<td colspan="2">Natural</td>
									<td>
										<input class="range-slider__range" type="range" readonly="readonly" min="1" max="100" value="${ place.avgArtificialNaturalScore }">
										<span class="badge range-slider__value">0</span>
									</td>
									<td colspan="2">Artificial</td>
								</tr>
							</table>
						</div>						
					</div>
				</div>
				
				<div id="info-Bottom">
		          	<div id="place-Reply">
						<div id="placeReplyWrapper">
							<form id="writePlaceReplyForm">
								<table id="placeReply_table">
									<tr>
										<td id="placeReply_content">
											<input id="description" name="description" placeholder="Write Reply"></textarea>
										</td>
										<td id="placeReply_btn">
											<button type="button" class="btn btn-info" id="writePlaceReplyBtn">
									     		<span class="glyphicon glyphicon-pencil"></span><span id="placeReply-Submit">Submit</span>
									   		</button>  													
										</td>
									</tr>
								</table>
								<input type="hidden" class="placeId" name="placeId" value="${ place.placeId }" />
								<input type="hidden" class="depth" name="depth" value="0" />
								<input type="hidden" class="parentReplyId" name="parentReplyId" value="0" />
								<input type="hidden" class="groupId" name="groupId" value="0" />
								<input type="hidden" class="orderNo" name="orderNo" value="0" />
								<input type="hidden" class="placeReplyId" name="placeReplyId" value="0" />
							</form>
						</div>
						
						<div id="replybyPlace">
							<c:forEach items="${ place.placeReplyList }" var="reply">
								<div>
								<table>
									<tr id="placeReplyTR">
										<td id="placeReplyWriterName">${ reply.name }</td>
										<td id="placeReplyWrittenReply">
											${ reply.placeReplyDescription }
										</td>
										<c:if test="${ reply.email eq loginEmail }">
											<td id="deletePlaceReply">
										        <a href="/deletePlaceReply?placeReplyId=${ reply.placeReplyId }&placeId=${ place.placeId }">
										          <span class="glyphicon glyphicon-remove"></span>
										        </a>
											</td>
										</c:if>
									</tr>
								</table>
								<div id="hide formAppender"></div>
								</div>
							</c:forEach>
						</div>	
		          	</div>		
				</div>
				
			</div>
			
		
		</div>
		
		<!-- Vote Modal -->
		<div class="modal fade" id="voteModal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		    	<div class="modal-content">
		        	<div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">
			          	Mood Vote !
			          </h4>
			        </div>
			        <!-- Modal Body -->
			        <div class="modal-body">
						<div class="placeVoteModal">
							<form id="voteForm">
								<input type="hidden" name="placeId" value="${ place.placeId }" />
								<div class="range-slider">
									<table border="1">
										<tr>
											<td colspan="2">Bright</td>
											<td>
												<input class="range-slider__range" name="bright" type="range" min="1" max="100" value="50">
												<span class="badge range-slider__value">0</span>
											</td>
											<td colspan="2">Dark</td>
										</tr>
										<tr>
											<td colspan="2">HightPrice</td>
											<td>
												<input class="range-slider__range" name="highPrice" type="range" min="1" max="100" value="50">
												<span class="badge range-slider__value">0</span>
											</td>
											<td colspan="2">LowPrice</td>
										</tr>
										<tr>
											<td colspan="2">Active</td>
											<td>
												<input class="range-slider__range" name="active" type="range" min="1" max="100" value="50">
												<span class="badge range-slider__value">0</span>
											</td>
											<td colspan="2">Calm</td>
										</tr>
										<tr>
											<td colspan="2">Artificial</td>
											<td>
												<input class="range-slider__range" name="artificial" type="range" min="1" max="100" value="50">
												<span class="badge range-slider__value">0</span>
											</td>
											<td colspan="2">Natural</td>
										</tr>
									</table>
								</div>
							</form>
						</div>
			        </div>
			        <!-- Modal Footer -->
			        <div class="modal-footer">
			    		<button type="button" class="btn btn-default" id="voteSubmit">Do Vote</button>
			    		<button type="button" class="btn btn-default" id="placeModal-Close" data-dismiss="modal">Close</button>
			        </div>
		     	 </div>
		    </div>
		 </div> <!-- Modal END -->		
		
		<!-- Report Modal -->
		<div class="modal fade" id="reportModal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		    	<div class="modal-content">
		        	<div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          	<span id="report-Title">Report Place</span><br>
			          <h4 class="modal-title">
		          		
		          		<span class="glyphicon glyphicon-exclamation-sign"></span> 
			          	<span id="report-Content">
			          		[허위 신고시 신고하신 분의 활동이 제한될 수 있습니다]
			          	</span>
			          </h4>
			        </div>
			        <!-- Modal Body -->
			        <div class="modal-body">
						<form id="reportForm">
							<input type="hidden" name="placeId" value="${ place.placeId }" />
							<table>
								<tr>
									<th id="cate">Category :</th>
									<td>
										<select name="reportReason">
											<option value="정보수정요청">정보 수정요청</option>
											<option value="욕설/비방">욕설/비방</option>
											<option value="음란성">음란성</option>
											<option value="광고">광고</option>
											<option value="저작권 위반">저작권 위반</option>
										</select>										
									</td>
								</tr>
								<tr>
									<th>Description : </th>
									<td>
										<textarea id="reportDescription" name="reportDescription"></textarea>
									</td>
								</tr>
							</table>
						</form>
			        </div>
			        <!-- Modal Footer -->
			        <div class="modal-footer">
			    		<button type="button" class="btn btn-default" id="reportSubmit">Do Report</button>
			    		<button type="button" class="btn btn-default" id="placeModal-Close" data-dismiss="modal">Close</button>
			        </div>
		     	 </div>
		    </div>
		 </div> <!-- Modal END -->		

<%-- <!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
 --%>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css" rel="stylesheet" />
<link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/styles.css"/>" />

<!-- Boot strap -->

<link rel="stylesheet"   href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css"   rel="stylesheet" />
<link rel="stylesheet"   href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/styles.css"/>" />
 