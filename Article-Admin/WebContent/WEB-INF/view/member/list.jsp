<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
  
$(document).ready( function() {
      
      $("#massiveSelectCheckBox").click(function() {
    	
    	  var isChecked = $(this).prop("checked");

    	  $(".dropOutMemberId").prop("checked", isChecked);
      });
      
      $("#massiveDropOutBtn").click(function() {
    	 var isChecked = false;
    	 
    	 $(".dropOutMemberId").each(function(index, data) {
    		 if( data.checked ) {
				isChecked = data.checked;
    		 }
    		 
    	 });
    	 
    	 if ( !isChecked ) {
    		alert("탈퇴시킬 대상 선택");
    		return;
    	 }
    	 
    	 if ( confirm("탈퇴 시키겠습니까?") ) {
			var form = $("#massiveDeleteForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/selectDropOut" />");
			form.submit();
    	 }
    	 
      });
      
      
      $("#massiveBlockBtn").click(function() {
    	 var isChecked = false;
    	 
    	 $(".dropOutMemberId").each(function(index, data) {
    		 if( data.checked ) {
				isChecked = data.checked;
    		 }
    		 
    	 });
    	 
    	 if ( !isChecked ) {
    		alert("차단/해제 시킬 대상 선택");
    		return;
    	 }
    	 
    	 if ( confirm("차단/해제 시키겠습니까?") ) {
			var form = $("#massiveDeleteForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/selectMemberBlock" />");
			form.submit();
    	 }
    	 
      });

   });
</script>

<div id="memberContent">  
	<table border="1" width="500px" align="center">
	   <tr>
	   		<th colspan="5">총 ${ members.paging.totalArticleCount } 명의 회원 존재</th>
	   </tr>
	   <tr>
	   	  <th>
	   	  	<input type="checkbox" id="massiveSelectCheckBox">
	   	  </th>
	      <th>ID</th>
	      <th>닉네임</th>
	      <th>E-Mail</th>
	      <th>차단</th>
	   </tr>
	   
	   <form id="massiveDeleteForm">
	   <c:forEach items="${ members.memberList }" var="members">
	   <tr>
	   	  <td class="c">
	   	  	<input type="checkbox" class="dropOutMemberId" name="dropOutMemberId" value="${members.memberId}" />
		  </td>
	      <td class="c">
	         <a href="<c:url value="/memberDetail?memberId=${members.memberId}" />">
	         	${ members.memberId }
	         </a>
	      </td>
	      <td class="c">${ members.nickName }</td>
	      <td class="c">${ members.email }</td>
	      <td class="c">${ members.isBlock }</td>
	   </tr>
	   </c:forEach>
	   </form>
	   
	   <tr>
	      <td colspan="5">
	         <form id="searchForm">
	         ${ members.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
	         </form>
	      </td>
	   </tr>
	</table>
	
	<%-- 세션 접근
	${ sessionScope._MEMBER_.memberId }
	${ sessionScope._MEMBER_.nickName }
	${ sessionScope._MEMBER_.password }
	${ sessionScope._MEMBER_.email } --%>
	
	<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
	
	<table border="1" align="center">
	   <tr>
	   		<th colspan="2">회원 관리 메뉴</th>
	   </tr>
	   
	   <tr align="center">
	      <td>
	      	<input type="button" id="massiveDropOutBtn" value="선택 탈퇴" />
	      </td>
	      <td>
	      	<input type="button" id="massiveBlockBtn" value="차단/해제" />
	      </td>
	   </tr>
	</table>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>