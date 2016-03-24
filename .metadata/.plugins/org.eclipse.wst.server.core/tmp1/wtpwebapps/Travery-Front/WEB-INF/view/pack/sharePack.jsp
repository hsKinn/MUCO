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
		<input type="text" id="search" name="search" placeholder="  #Hash Tag"  />
		<button type="button" class="btn btn-info">
      		<span class="glyphicon glyphicon-search"></span>검색
    	</button>
	</div>
	
	<div id="sortBox"> 
		<div class="dropdown">
 			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
  				<span class="caret"></span>
  			</button>
 			<ul class="dropdown-menu">
			    <li><a href="#">HTML</a></li>
			    <li><a href="#">CSS</a></li>
			    <li><a href="#">JavaScript</a></li>
  			</ul>
		</div>
	</div>
</div>	
	
<div id="share-body">
	<c:forEach var="i" begin="1" end="6" step="1">
		<div class="sharePack"> ${i}번째 내용</div>
	</c:forEach>
	
	<div id="sharePage">1, 2, 3, 4, 5</div>
</div>	

	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

