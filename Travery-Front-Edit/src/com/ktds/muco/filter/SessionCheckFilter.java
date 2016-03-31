package com.ktds.muco.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * Servlet Filter implementation class SessionCheckFilter
 * 
 * @author 김광민
 */
public class SessionCheckFilter implements Filter {

	private List<String> whiteList;
	private List<String> staticResourceList;

	/**
	 * Default constructor.
	 */
	public SessionCheckFilter() {

		// 접근 가능한 페이지로 가는 Servlet uri 등록
		// uri 전체가 whiteList 의 데이터중에 정확히 일치해야함
		whiteList = new ArrayList<String>();
		whiteList.add("/");
		whiteList.add("/login");
		whiteList.add("/join");
		whiteList.add("/doLogin");
		whiteList.add("/fabicon.ico");

		// whiteList에는 포함되지 않지만
		// staticResourceList 의 데이터중에 정확히 일치 하지 않고
		// 해당 데이터로 시작하는 것들은 filter를 거치지 않는다.
		// "/resource" 라고 작성하면 나중에 resource로 시작하는 모든 uri를 받아오지만
		// "/resource/" 라고 정확히 닫아 놓으면 정확히 resource uri 인지 확인 할 수 있다.
		staticResourceList = new ArrayList<String>();
		staticResourceList.add("/resource/");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// HttpServletRequest Type 으로 캐스팅
		HttpServletRequest req = (HttpServletRequest) request;

		// URI를 얻어온다.
		String uri = req.getRequestURI();
		System.out.println(uri);

		// whiteList에 uri가 포함되어 있지 않다면
		if (!whiteList.contains(uri)) {

			boolean isURIResourceFile = false;

			// staticResourceList 에서 하나씩 꺼내와서
			for (String staticResource : staticResourceList) {

				// uri가 staticResource로 시작한다면
				if (uri.startsWith(staticResource)) {
					isURIResourceFile = true;
					break;
				}
			}

			// Resource uri 아니라면 세션을 체크해라.
			if (!isURIResourceFile) {

				// 세션을 얻어온다.
				HttpSession session = req.getSession();

				// 임시저장된 세션 loginMember(MemberVO)를 가져온다.
				MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");

				// 만약 존재하지 않는 회원이라면
				if (member == null) {

					// 첫 페이지로 이동한다.
					HttpServletResponse res = (HttpServletResponse) response;
					res.sendRedirect("/");
					return;
				} else {

				}
			}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
