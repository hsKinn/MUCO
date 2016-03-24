package com.ktds.cain.filter;

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

import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
public class SessionCheckFilter implements Filter {
	
	private List<String> whiteList;
	private List<String> staticResourceList;

    /**
     * Default constructor. 
     */
    public SessionCheckFilter() {
    
		whiteList = new ArrayList<String>();
		whiteList.add("/admin/");
		whiteList.add("/admin/doLogin");
		whiteList.add("/admin/registerMember");
		whiteList.add("/admin/addNewMember");
		whiteList.add("/admin/memberInformation");
		whiteList.add("/admin/idDuplicationCheck");
		whiteList.add("/fabicon.ico");
   	
    	staticResourceList = new ArrayList<String>();
    	staticResourceList.add("/admin/resource/"); // if use /resource 
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		System.out.println(uri);
			
		if( !whiteList.contains(uri) ) {
			boolean isURIResourceFile = false;
			
			for ( String staticResource : staticResourceList ) {
				if ( uri.startsWith(staticResource) ) {
					isURIResourceFile = true;
					break;
				}
			}
			
			
		if ( !isURIResourceFile) {
			HttpSession session = req.getSession();
			
			MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
			if( member == null ) {
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect("/admin");
				return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}	

}
