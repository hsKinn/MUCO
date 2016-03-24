package com.ktds.cain.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class DoLoginServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        biz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인할 수 없다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("userId");
		String memberPassword = request.getParameter("userPwd");
		
		MemberVO loginMember = new MemberVO();
		loginMember.setMemberId(memberId);
		loginMember.setPassword(memberPassword);
		
		boolean isLoginSuccess = biz.login(loginMember, request);
		if ( isLoginSuccess ) {

/*			Cookie autoLogin = new Cookie("autoLogin", "true");
			autoLogin.setMaxAge(999);
			response.addCookie(autoLogin);*/
			
/*			Cookie autoLogin = new Cookie("autoLogin", "true");
			autoLogin.setMaxAge(0);
			response.addCookie(autoLogin);
			를 오토로그인 값을 0으로 셋팅 하기 때문에 초기화 시켜준다 사용시 쿠키 삭제로 적용가능하다.
*/			
			// 브라우저에 보내주고 싶은 정보를 적어줌
			Cookie userId = new Cookie("userId", memberId);
			userId.setMaxAge(999);
			response.addCookie(userId);
			
			Cookie userPassword = new Cookie("userPassword", memberPassword);
			userPassword.setMaxAge(999);
			response.addCookie(userPassword);
			
			response.sendRedirect(Root.get(this) + "/list");
			return;
		}
		else {
			response.sendRedirect(Root.get(this) + "/?errorCode=1");
			return;
		}	
	}
}
