<!-- 김현섭 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- Share Package -->
<script type="text/javascript">
	$(document).ready(function() {
		
	   $("#initSearchBtn").click( function() {
			  location.href = "<c:url value="/init" />"; 
		   });
		   
	   $("#searchBtn").click( function() {
		  
		   if ( $("#searchKeyword").val() == "" ) {
			   alert("검색어 입력");
			   return;
		   }
		   
		   movePage('0');
		   
	   });		
	   
		$("#searchKeyword").keyup( function(e) {
			if ( e.keyCode == 13 ) {
				
				$("#searchBtn").click();
			}
		}) ;
		
		$(".packLike").click( function() {
			
			
			alert("${pack.packId}");
			
			var a = $(".packLike").data('packId');
			
			
			$.post(
					"/packLike"
					, { "packId" : a } 
					, function(data) {
						
						var jsonData3 = {};
						
						try {
							jsonData3 = JSON.parse(data);
						}
						catch(e) {
							jsonData3.result = false;							
						}
						
						console.log(jsonData3);
						
						if ( jsonData3.result) {
							// 하트를 넣음
							var text = $(".packLike").text();
							if ( jsonData3.isPackLike ) {
								$(".packLike").text("♥");							
							}
							else {
								$(".packLike").text("♡");	
							}
						}
						else {
							alert("세션 만료");
							location.href = "/";
						}
						
					}
					
			  );
		});		
	

	});
	
</script>

<!-- Share Pack Content by hskim -->

<form id="searchForm">
<div id="share-top">
	<div id="searchBox">
			<input type="text" id="searchKeyword" name="searchKeyword" value="${packSearchVO.searchKeyword}" placeholder="   #Hash Tag"  />
			<button type="button" class="btn btn-info" id="searchBtn">
	      		<span class="glyphicon glyphicon-search"></span>검색
	    	</button>
			<button type="button" class="btn btn-info" id="initSearchBtn">
	      		<span class="glyphicon glyphicon-repeat"></span>초기화
	    	</button>
	</div>
	
	<div id="sortBox"> 
		<div class="dropdown">
 			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Sort By
  				<span class="caret"></span>
  			</button>
 			<ul class="dropdown-menu">
			    <li><a href="/recentSharePack">등록일 순<span class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
			    <li><a href="/sharePack">추천 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
  			</ul>
		</div>
	</div>
    <div id="sharePage">
    	${ packages.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
   </div>
</div>	
</form>

<div id="share-body">
	<c:forEach items="${ packages.packList }" var="pack">
		<div class="sharePack"> 
			<div class="packTop">
				<span id="header" data-toggle="modal" data-target="#${ pack.packId }">${ pack.packTitle }</span>
			</div>
			
			<div class="packHashTag">
				<c:forEach items="${ pack.hashtagList }" var="hashtags">
					<span id="hashtag">#${ hashtags.hashtagName }</span>
				</c:forEach>
			</div>
			
			<div class="packPhoto">
				<img src="${ pack.imageLocation }" />
			</div>
			
			<div class="packFooter">
				<div class="packWriterName">Writer: ${ pack.name }</div>
				<div class="packLikeCount">
					<span class="glyphicon glyphicon-heart"></span>
					<span id="likeCount">${ pack.likeCount }</span>
				</div>
			</div>
		</div>
		
		
		<!-- Modal -->
		<div class="modal fade" id="${ pack.packId }" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		    	<div class="modal-content">
		        	<div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">
			          		${ pack.packTitle } 
			          		<span class="badge">view: ${ pack.viewCount }</span>
			          </h4>
			        </div>
			        <div class="modal-body">
						  <table class="table table-hover table-bordered table-condensed">
						    <thead>
						      <tr>
						        <td width="130px">여행지 명</td>
						        <td>주소</td>
						        <td width="80px">추천수</td>
						      </tr>
						    </thead>
						    <tbody>
						    <c:forEach items="${ pack.placeList }" var="places">
						      <tr>
						        <td>${ places.placeName }</td>
						        <th>${ places.address }</th>
						        <td>${ places.likeCount }</td>
						      </tr>
						    </c:forEach>
						  </table>
			        </div>
			        <div class="modal-footer">
			                  추천
			          <c:choose>
			          <c:when test="${ pack.isExistPackLike() }">
			          	<span class="packLike" data-packId='${ pack.packId }' >♥</span>			          
			          </c:when>
			          <c:otherwise>
			          	<span class="packLike">♡</span>		
			          </c:otherwise>
			          </c:choose>
			          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        </div>
		     	 </div>
		    </div>
		 </div>
  
	</c:forEach>
	
	<c:if test="${ packages.paging.totalArticleCount == 0 }">
		<div id="notFoundPack">
			<h3><span id="blue">#${packSearchVO.searchKeyword}</span>로 태그된 패키지가 존재하지 않습니다<br/><span id="red">초기화</span> 후 재 검색해주세요</h3>
			
		</div>
	</c:if>
</div>	

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

