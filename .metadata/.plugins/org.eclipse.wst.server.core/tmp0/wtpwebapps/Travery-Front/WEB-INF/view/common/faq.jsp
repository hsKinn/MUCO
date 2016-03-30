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
      <h2>I Love Food</h2>
      <h5><span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Sep 27, 2015.</h5>
      <h5><span class="label label-danger">Food</span> <span class="label label-primary">Ipsum</span></h5><br>
      <p>Food is my passion. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <br><br>
		
		<%-- <table border="1" style="text-align: center;">
			<tr style="height:40px;background-color: #eeeeee;">
				<th style="width:5%;">
					<input type="checkbox" id="massiveSelectCheckBox" />
				</th>
				<th style="width:8%;">글번호</th>
				<th style="width:55%;">글제목</th>
				<th style="width:16%;">글쓴이</th>
				<th style="width:8%;">조회수</th>
				<th style="width:8%;">추천수</th>
			</tr>
			<form id="massiveDeleteForm">
				<c:forEach items="${ articles.articleList}" var="article">
					<tr style="height:36px;">
						<td>
							<input type="checkbox" class="deleteArticleId"
								   name="deleteArticleId" value="${article.articleId }" />
						</td>
						<td>${article.articleId }</td>
						<td>
							<a href="<c:url value="/hits?articleId=${article.articleId }" />">
								${article.title }
							</a>
							<c:if test="${article.articleCount gt 0 }">
								[${article.articleCount }]
							</c:if>
							<c:if test="${article.fileCount gt 0 }">
								[${article.fileCount }개의 첨부파일 있음]
							</c:if>
						</td>
						<td>${article.nickName }</td>
						<td>${article.hits }</td>
						<td>${article.recommends }</td>
					</tr>
				</c:forEach>
			</form>
			<tr style="height:30px;">
				<td colspan="6">
					<form id="searchForm">
					<div style="margin-top:10px;">
						${articles.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
					</div>
					<div style="text-align: right;">
						<select name="searchType">
							<c:if test="${searchVO.searchType eq '1' }">
								<option value="1" selected="selected">제목+내용</option>
								<option value="2">아이디</option>
								<option value="3">글쓴이</option>
							</c:if>
							<c:if test="${searchVO.searchType eq '2' }">
								<option value="1">제목+내용</option>
								<option value="2"  selected="selected">아이디</option>
								<option value="3">글쓴이</option>
							</c:if>
							<c:if test="${searchVO.searchType eq '3' }">
								<option value="1">제목+내용</option>
								<option value="2">아이디</option>
								<option value="3" selected="selected">글쓴이</option>
							</c:if>
							<c:forEach begin="1" end="3" step="1" var="i">
								<c:set var="selected" value="" />
								<c:if test="${ i eq searchVO.searchType }">
									<c:set var="selected" value="selected='selected'" />
								</c:if>
								<c:if test="${ i eq 1 }">
									<c:set var="name" value="제목+내용" />
								</c:if>
								<c:if test="${ i eq 2 }">
									<c:set var="name" value="아이디" />
								</c:if>
								<c:if test="${ i eq 3 }">
									<c:set var="name" value="글쓴이" />
								</c:if>
								<option value="${i }">${name }</option>
							</c:forEach>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword }"/>
						<input type="button" id="searchBtn" value="검색" />
					</div>
					</form>
					
				</td>
			</tr>
		</table> --%>

      <h4>Leave a Comment:</h4>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>

    </div>
  </div>
</div>


</div>