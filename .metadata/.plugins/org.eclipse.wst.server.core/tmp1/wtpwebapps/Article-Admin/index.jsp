<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ktds.hskim.history.biz.OperationHistoryBiz"%>
<%@page import="com.ktds.hskim.history.vo.OperationHistoryVO"%>
<%@page import="com.ktds.hskim.history.vo.ActionCode"%>
<%@page import="com.ktds.hskim.history.vo.BuildDescription"%>
<%@page import="com.ktds.hskim.history.vo.Description"%>
<%@page import="com.ktds.hskim.member.vo.MemberVO"%>
<%
	
	MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
	if ( member != null ) {
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		historyVO.setIp(request.getRemoteHost());
		historyVO.setMemberId(member.getMemberId());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.LOGIN);
		historyVO.setDescription(BuildDescription.get( Description.ALREADY_LOGIN, member.getMemberId()) );
		
		OperationHistoryBiz biz = new OperationHistoryBiz();
		biz.addHistory(historyVO);
		
		response.sendRedirect("/admin/list");
		return;
	}
	
	OperationHistoryVO historyVO = new OperationHistoryVO();
	historyVO.setIp(request.getRemoteHost());
	historyVO.setMemberId("");
	historyVO.setUrl(request.getRequestURI());
	historyVO.setActionCode(ActionCode.LOGIN);
	historyVO.setDescription(BuildDescription.get( Description.VISIT_LOGIN_PAGE, request.getRemoteHost() ));
	
	OperationHistoryBiz biz = new OperationHistoryBiz();
	biz.addHistory(historyVO);
	
%>


<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/login.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

