package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.root.Root;

/**
 * 
 * Servlet implementation class DoLoginServlet
 * 
 * @author 김광민
 * 
 */
public class DoLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private MemberBiz memberBiz;
   private HistoryBiz historyBiz;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public DoLoginServlet() {
      super();
      memberBiz = new MemberBiz();
      historyBiz = new HistoryBiz();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      boolean isLoginSuccess = memberBiz.login(request);

      HttpSession session = request.getSession();
      MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
      
      if (isLoginSuccess) {
         
         Cookie autoLogin = new Cookie("autoLogin", "true");
         autoLogin.setMaxAge(0);
         response.addCookie(autoLogin);
         
         Cookie userId = new Cookie("userId", request.getParameter("userEmail"));
         userId.setMaxAge(999);
         response.addCookie(userId);
         
         Cookie userPassword = new Cookie("userPassword", request.getParameter("userPw") );
         userPassword.setMaxAge(999);
         response.addCookie(userPassword);
         
         HistoryVO history = new HistoryVO();
         history.setIp(request.getRemoteHost());
         history.setEmail(member.getEmail());
         history.setUrl(request.getRequestURI());
         history.setActionCode(ActionCode.LOGIN);
         history.setHistoryDescription(BuildDescription.get(Description.LOGIN, member.getEmail()));
         historyBiz.addHistory(history);
         
         response.sendRedirect(Root.get(this) + "/hitTheRoad");
         return;
      } else {
         
         HistoryVO history = new HistoryVO();
         history.setIp(request.getRemoteHost());
         history.setEmail("");
         history.setUrl(request.getRequestURI());
         history.setActionCode(ActionCode.LOGIN);
         history.setHistoryDescription(BuildDescription.get(Description.LOGIN_FAIL, request.getRemoteHost(), request.getParameter("userEmail")));
         historyBiz.addHistory(history);
         
         response.sendRedirect(Root.get(this) + "/?errorCode=1");
         return;
      }
   }
}