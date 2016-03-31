<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<c:if test="${menuNo eq 1 }">
<div id="menu3" class="tab-pane fade">
</c:if>
<c:if test="${menuNo eq 2 }">
<div id="menu3" class="tab-pane fade">
</c:if>
<c:if test="${menuNo eq 3 }">
<div id="menu3" class="tab-pane fade in active">
</c:if>


	<div id="faqWrapper">
		
		<div id="tabMenu" >
			<div class="container" style="width:100%;">
				  <h3>FAQ</h3>
				  <hr style="border:solid 1px #7f7f7f;">
				  <p>FAQ를 통해 궁금증을 해결하세요.</p>
				  <br />
				  <div class="panel-group" id="accordion">
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">회원정보</a>
				        </h4>
				      </div>
				      <div id="collapse1" class="panel-collapse collapse in">
				      <c:forEach items="${faqs }" var="faqs">
				      	<c:if test="${faqs.isFaq eq 1 }">
				      		<div class="panel-body"><a href="#${faqs.qnaId }">${faqs.title }</a></div>
				      	</c:if>
				      </c:forEach>
				      </div>
				    </div>
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">여행지정보</a>
				        </h4>
				      </div>
				      <div id="collapse2" class="panel-collapse collapse">
				        <c:forEach items="${faqs }" var="faqs">
				      	<c:if test="${faqs.isFaq eq 2 }">
				      		<div class="panel-body"><a href="#${faqs.qnaId }">${faqs.title }</a></div>
				      	</c:if>
				      </c:forEach>
				      </div>
				    </div>
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">해시태그검색</a>
				        </h4>
				      </div>
				      <div id="collapse3" class="panel-collapse collapse">
				        <c:forEach items="${faqs }" var="faqs">
				      	<c:if test="${faqs.isFaq eq 3 }">
				      		<div class="panel-body"><a href="#${faqs.qnaId }">${faqs.title }</a></div>
				      	</c:if>
				      </c:forEach>
				      </div>
				    </div>
				  </div> 
			</div>
		</div>
		
		<hr id="hrLine" width="2px" />
		
		<div id="faqContent">	
   	   		<c:forEach items="${faqs}" var="faqs">
   	   		
    	   		<div id="${faqs.qnaId}" class="faqLists">
    	 
   	   				
   	   				<div style="float:left; padding:20px 20px 0 20px; font-size: 18px;">
   	   					${faqs.title}
   	   				</div>
   	   				<div style="float:left; padding:0 20px 10px 20px;">
   	   					<hr>
   	   					${faqs.description}
   	   				</div>
    	   			
				</div>
			
			</c:forEach>
			<div id="gotop" class="gotop">
				<a href="javascript:scrollTo(0, 0);"><img src="<c:url value="/resource/img/common/topIcon.png" />" style="width:20px; height:20px;" ></a>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
	</div>



</div>