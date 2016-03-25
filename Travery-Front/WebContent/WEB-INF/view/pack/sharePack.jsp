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
			    <li><a href="#">등록일 순<span class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
			    <li><a href="#">추천 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span>(기본값)</a></li>
  			</ul>
		</div>
	</div>
    <div id="sharePage">
    	${ packages.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
   </div>
</div>	
</form>

<div id="share-body">
	<c:forEach items="${ packages.packList }" var="packages">
		<div class="sharePack"> 
			<div class="packTop">
				<span id="header">${ packages.packTitle }</span>
			</div>
			
			<div class="packHashTag">
				<c:forEach items="${ packages.hashtagList }" var="hashtags">
					<span id="hashtag">#${ hashtags.hashtagName }</span>
				</c:forEach>
			</div>
			
			<div class="packPhoto">
				<img src="${ packages.imageLocation }" />
			</div>
			
			<div class="packLikeCount">
				<span class="glyphicon glyphicon-heart"></span>
				<span id="likeCount">${ packages.likeCount } </span>
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

