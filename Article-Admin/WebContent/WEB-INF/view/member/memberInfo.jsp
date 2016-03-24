<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<div id="user">${ sessionScope._MEMBER_.nickName } is attended.</div>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
	
	$(document).ready( function() {
		$("#initSearchBtn").click(function() {
			location.href = "<c:url value="/list/init" />";
		});
		
		$("#searchBtn").click(function() {
			if ( $("#searchKeyword").val() == "" ) {
				alert("검색어를 입력하셈");
				return
			}
			movePage('0');
		});
		
	$("#massiveSelectCheckBox").click( function() {
		var isChecked = $(this).prop("checked");
		$(".deleteArticleId").prop("checked", isChecked);
	});
	// 일괄 선택버튼
		
		$("#massiveDeleteBtn").click( function() {
			var isChecked = false;
			
			$(".deleteArticleId").each( function (index, data) {
				if (data.checked) {
					isChecked = data.checked;
				}
				
			});

			if ( !isChecked ) {
				alert("Choose The checkBoxes");
				return;
			}
			if ( confirm("Are you sure delete the articles?") ) {
				var form = $("#massiveDeleteForm");
				form.attr("method", "post");
				form.attr("action", "<c:url value="/massiveInfoDelete" />");
				form.submit();
			}
		});
	});

</script>
<div id="content">
	We have  ${ members.paging.totalArticleCount } Members attended.
	<table border="1" align="center">
		<tr align="center">
			<td><input type="checkbox" id="massiveSelectCheckBox" /></td>
			<th>MEMBER_ID</th>
			<th>NICK_NAME</th>
			<th>PASSWORD</th>
			<th>EMAIL</th>
			<th>ADMIN</th>			
		</tr>
		<form id="massiveDeleteForm">
			<c:forEach items="${ members.memberList }" var="member">
				<tr>
					<td><input type="checkbox" class="deleteMemberId" name="deleteMemberId" value="${ member.memberId }" /></td>
					<td>${ member.memberId }</td>
 					<td>${ member.nickName }</td>
					<td><a href="<c:url value="/memberInfoDetail?memberId=${member.memberId}" />"> ${ member.password }</a></td>
					<td>${ member.email }</td>
					<td>${ member.isAdmin }</td>
				</tr>
			</c:forEach>
		</form>
		<tr>
			<td colspan="6">
				<form id="searchForm">
					<div style="text-align: center;">${ members.paging.getPagingList("pageNo", "[@]", "[before]", "[next]", "searchForm") }
					</div>
					<div>
						<select name="searchType">
								<c:if test="${ searchVO.searchType eq '1' }">
	 							<option value="1" selected="selected">ID + NICK_NAME</option>
	  							<option value="2">NICK_NAME</option>
	  							<option value="3">EMAIL</option>
	  							<option value="4">ADMIN</option>
  							</c:if>
							<c:if test="${ searchVO.searchType eq '2' }">
	 							<option value="1">ID + NICK_NAME</option>
	  							<option value="2" selected="selected">NICK_NAME</option>
	  							<option value="3">EMAIL</option>
	  							<option value="4">ADMIN</option>
  							</c:if>
							<c:if test="${ searchVO.searchType eq '3' }">
	 							<option value="1">ID + NICK_NAME</option>
	  							<option value="2">NICK_NAME</option>
	  							<option value="3" selected="selected">EMAIL</option>
	  							<option value="4">ADMIN</option>
  							</c:if>
							<c:if test="${ searchVO.searchType eq '4' }">
	 							<option value="1">ID + NICK_NAME</option>
	  							<option value="2">NICK_NAME</option>
	  							<option value="3">EMAIL</option>
	  							<option value="4" selected="selected">ADMIN</option>
  							</c:if>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword }" /><br/>
						<input type="button" id="searchBtn" value="search" />
						<input type="button" id="initSearchBtn" value="init" />
					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3"><a href="<c:url value="/registerMember" />">regist</a></td>
			<td colspan="3"><span id="massiveDeleteBtn" style="cursor: pointer;">일괄삭제</span></td>
		</tr>
	</table>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>