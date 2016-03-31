<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

	$(document).ready(function(){
		
	});

</script>


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
				        <div class="panel-body"><a data-toggle="pill" href="#joinMethod">TRAVERY 회원가입 방법</a></div>
				        <div class="panel-body"><a data-toggle="pill" href="#joinUpdateMethod">TRAVERY 회원정보 수정방법</a></div>
				      </div>
				    </div>
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">여행지정보</a>
				        </h4>
				      </div>
				      <div id="collapse2" class="panel-collapse collapse">
				        <div class="panel-body">보고싶은 여행지 선택방법</div>
				        <div class="panel-body">여행지 등록방법</div>
				        <div class="panel-body">여행지 예약방법</div>
				      </div>
				    </div>
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">해시태그검색</a>
				        </h4>
				      </div>
				      <div id="collapse3" class="panel-collapse collapse">
				        <div class="panel-body">해시태그 검색방법</div>
				      </div>
				    </div>
				  </div> 
			</div>
		</div>
		
		<hr id="hrLine" width="2px" />
		
		<div id="faqContent" >
		
			<div class="lst_typ_section">
   	            <h3><span class="blind"></span></h3>
   	            <ul id="faqInit" class="tab-pane fade in active" >
					<li>TRAVERY 회원가입은 어떻게 하나요?<span class="ic"></span></a></li>
					<li>메일을 잘못 발송했는데 취소할 수 있나요?<span class="ic"></span></a></li>
					<li>메일 목록이 하얗게 보이거나 로딩이 잘 되지 않습니다.<span class="ic"></span></a></li>
					<li>다른 사람 이름/명의로 된 메일이 수신됩니다<span class="ic"></span></a></li>
					<li>수신 차단/해제하고 싶으면 어떻게 하나요?<span class="ic"></span></a></li>
					<li>네이버로 메일이 도착하지 않아요. (타 사이트 → 네이버)<span class="ic"></span></a></li>
					<li>별도의 메일 서버에서 발송한 메일을 네이버 수신자가 받지 못해요.<span class="ic"></span></a></li>
                   </ul>
                <div id="joinMethod" class="tab-pane fade">
			    	회원가입        
    	   		</div> 
    	   		<div id="joinUpdateMethod" class="tab-pane fade">
    	   			회원수정
    	   		</div>
			
		</div>
		
	</div>



</div>