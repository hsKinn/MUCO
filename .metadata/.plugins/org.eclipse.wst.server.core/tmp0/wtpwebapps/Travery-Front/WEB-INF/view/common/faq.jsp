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



<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>FAQ</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">회원정보</a></li>
        <li><a href="#section2">Friends</a></li>
        <li><a href="#section3">Family</a></li>
        <li><a href="#section3">Photos</a></li>
      </ul><br>
    </div>

    <div class="col-sm-9">
      <h4><small>FAQ를 통해 궁금증을 해결하세요.</small></h4>
      <hr>
      <h3>회원정보 FAQ</h3>
      
		
		 <table border="1" style="text-align: center; width:30%;">
			<tr style="height:40px;background-color: #eeeeee;">
				<th style="width:8%;text-align: center;">글번호</th>
				<th style="width:55%;text-align: center;">글제목</th>
			</tr>
			
				<c:forEach items="${ faqs.qnaList}" var="faq">
					<tr style="height:36px;">
						<td>${faq.qnaId }</td>
						<td>${faq.title }</td>
					</tr>
				</c:forEach>
			
			<tr style="height:30px;">
				<td colspan="6">
					<form id="searchForm">
					<div style="margin-top:10px;">
						${faqs.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
					</div>
					</form>
					
				</td>
			</tr>
		</table> 

      
      <br><br>

    </div>
  </div>
</div>


</div>