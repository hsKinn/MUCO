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
	
	$("#sharePackMenu").mouseout(function(){
		$("#sharePackMenu").css("color", "#ffffff");
	});
	$("#sharePackMenu").css("color", "#ffffff");
	
});
</script>

<!-- Share Pack Content by hskim -->

<div id="share-top">
	<div id="searchBox">
		<input type="text" id="search" name="search" placeholder="   #Hash Tag"  />
		<button type="button" class="btn btn-info">
      		<span class="glyphicon glyphicon-search"></span>검색
    	</button>
	</div>
	
	<div id="sortBox"> 
		<div class="dropdown">
 			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Sort By
  				<span class="caret"></span>
  			</button>
 			<ul class="dropdown-menu">
			    <li><a href="#">등록일 순</a></li>
			    <li><a href="#">추천 순</a></li>
  			</ul>
		</div>
	</div>
</div>	
	
<div id="share-body">
	<c:forEach items="${ packages.packList }" var="pakage">
		<div class="sharePack"> ${ pakage.packTitle }</div>
	</c:forEach>
	
    <form id="searchForm">
	    <div id="sharePage">
	      ${ packages.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
	    </div>
    </form>
</div>	

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

