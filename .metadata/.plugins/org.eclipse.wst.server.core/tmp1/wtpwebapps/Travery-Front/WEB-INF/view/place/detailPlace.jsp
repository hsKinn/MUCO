<!-- 김현섭 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Boot Script -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/detailPlace.css"/>" />

<!-- Share Package -->
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>

<c:set var="loginEmail" value="${ sessionScope._MEMBER_.email }" />

<!-- Detail Place Content by hskim -->
<section class="bg-primary" id="one">
	<div class="container">

		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">Detail Place Page</h2>
			<hr class="primary">
			<p>Place의 상세 정보를 확인하세요</p>
		</div>
		
		<div id="detail-Wrapper">
			
			<div id="detail-LeftWrapper">
				
				<div id="photo-Top">
					대표 이미지
					<img src="#" />
				</div>
				
				<div id="photo-Bottom">
					<c:forEach var="i" begin="1" end="12">
						<div class="photos">
							<img src="#" />
						</div>
					</c:forEach>
				</div>
				
				
			</div>
			
			<div id="detail-RightWrapper">
				<div id="info-Top">
					<div id="place-Title">
						국가명 ${ place.countryName }, 여행지명 ${ place.placeName } 
					</div>
					<div id="place-LikeCount">
						♥ 42 ${ place.likeCount }
					</div>
				</div>
				
				<div id="info-Middle">
					<div id="place-Description">
						<textarea>여행지에 대한 설명입니다${ place.placeDescription }</textarea>
					</div>
				</div>
				
				<div id="info-Vote">
					<div id="vote-Top">
						투표하기
					</div>
					<div id="placeVote">
						<table>
							<tr>
								<td>Bright</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="88">
								</td>
								<td>Dark</td>
							</tr>
							<tr>
								<td>HightPrice</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="27">
								</td>
								<td>LowPrice</td>
							</tr>
							<tr>
								<td>Active</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="50">
								</td>
								<td>Calm</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div id="info-Bottom">
		          	<div class="pack-reply">
						<div class="formWrapper">
							<form class="writeReplyForm">
								<table class="reply_table">
									<tr>
										<td class="reply_content">
											<textarea class="description" name="description" placeholder="댓글을 달아보세요"></textarea>
										</td>
										<td class="reply_btn">
											<button type="button" class="btn btn-info" id="writeReplyBtn">
									     		<span class="glyphicon glyphicon-pencil"></span>댓글 등록
									   		</button>  													
										</td>
									</tr>
								</table>
								<input type="hidden" class="placeId" name="placeId" value="${ place.placeId }" />
								<input type="hidden" class="depth" name="depth" value="0" />
								<input type="hidden" class="parentReplyId" name="parentReplyId" value="0" />
								<input type="hidden" class="groupId" name="groupId" value="0" />
								<input type="hidden" class="orderNo" name="orderNo" value="0" />
								<input type="hidden" class="packReplyId" name="packReplyId" value="0" />
							</form>
						</div>
						
						<div class="replybypack">
							<c:forEach items="${ place.replyList }" var="reply">
								<div>
								<table>
									<tr class="replyTR">
										<td class="replyWriterName">${ reply.name }</td>
										<td class="replyWrittenReply">
											${ reply.placeReplyDescription }
										</td>
										<c:if test="${ reply.email eq loginEmail }">
											<td class="deleteReply">
										        <a href="/deletePackReply?packReplyId=${ reply.packReplyId }">
										          <span class="glyphicon glyphicon-remove"></span>
										        </a>
											</td>
										</c:if>
									</tr>
								</table>
								<div class="hide formAppender"></div>
								</div>
							</c:forEach>
						</div>	
		          	</div>		
				</div>
				
			</div>
			
		
		</div>

	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

