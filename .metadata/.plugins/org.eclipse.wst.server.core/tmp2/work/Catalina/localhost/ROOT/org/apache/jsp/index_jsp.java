/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-30 06:21:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1458700068000L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/Documents/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/Travery-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	Cookie[] cookies = request.getCookies();

	String userId = "";
	String userPassword = "";
	String autoLogin = "";

	if (cookies != null) {
		// 존재하는 쿠키들을 하나씩 검사
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userId")) {
				// 아이디 쿠키 받아오기
				userId = cookie.getValue();
			} else if (cookie.getName().equals("userPassword")) {
				// 비밀번호 쿠키 받아오기
				userPassword = cookie.getValue();
			} else if (cookie.getName().equals("autoLogin")) {
				// 자동 로그인 쿠키 받아오기
				autoLogin = cookie.getValue();
			}
		}
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./WEB-INF/view/common/indexHeader.jsp", out, false);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- id=\"header\" -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#join\").hide();\r\n");
      out.write("\t\t$(\"#login\").hide();\r\n");
      out.write("\t\t$(\"#goBack\").hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t    $(\"#letsJoin\").click(function(){\r\n");
      out.write("\t    \t $(\"#letsJoin\").animate({\r\n");
      out.write("\t             height: 'toggle'\r\n");
      out.write("\t         });\r\n");
      out.write("\t    \t $(\"#join\").animate({\r\n");
      out.write("\t             height: 'toggle'\r\n");
      out.write("\t         });\r\n");
      out.write("\t    \t \r\n");
      out.write("\t\t\t$(\"#letsLogIn\").hide();\r\n");
      out.write("\t\t\t$(\"#login\").hide();\r\n");
      out.write("\t\t\t$(\"#goBack\").show();\r\n");
      out.write("\t    });\r\n");
      out.write("\t    \r\n");
      out.write("\t    $(\"#letsLogIn\").click(function(){\r\n");
      out.write("\t    \t $(\"#letsLogIn\").animate({\r\n");
      out.write("\t             height: 'toggle'\r\n");
      out.write("\t         });\r\n");
      out.write("\t    \t $(\"#login\").animate({\r\n");
      out.write("\t             height: 'toggle'\r\n");
      out.write("\t         });\r\n");
      out.write("\t    \t \r\n");
      out.write("\t \t\t$(\"#letsJoin\").hide();\r\n");
      out.write("\t \t\t$(\"#join\").hide();\r\n");
      out.write("\t\t\t$(\"#goBack\").show();\r\n");
      out.write("\t    });\r\n");
      out.write("\t    \r\n");
      out.write("\t    $(\"#goBack\").click(function(){\r\n");
      out.write("\t    \t$(\"#join\").hide();\r\n");
      out.write("\t    \t$(\"#login\").hide();\r\n");
      out.write("\t\t\t$(\"#letsJoin\").show();\r\n");
      out.write("\t\t\t$(\"#letsLogIn\").show();\r\n");
      out.write("\t\t\t$(\"#goBack\").hide();\r\n");
      out.write("\t    });\r\n");
      out.write("\r\n");
      out.write("\t    \r\n");
      out.write("\t    // 회원 가입 \r\n");
      out.write("\t\t$(\"#btnJoin\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar userEmail = $(\"#userEmail\").val();\r\n");
      out.write("\t\t\tuserEmail = $.trim(userEmail);\r\n");
      out.write("\t\t\tif (userEmail == \"\") {\r\n");
      out.write("\t\t\t\talert(\"이메일을 입력하세요!\");\r\n");
      out.write("\t\t\t\t$(\"#userEmail\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar userPassword = $(\"#userPassword\").val();\r\n");
      out.write("\t\t\tuserPassword = $.trim(userPassword);\r\n");
      out.write("\t\t\tif (userPassword == \"\") {\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 입력하세요!\");\r\n");
      out.write("\t\t\t\t$(\"#userPassword\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar userName = $(\"#userName\").val();\r\n");
      out.write("\t\t\tuserName = $.trim(userName);\r\n");
      out.write("\t\t\tif (userName == \"\") {\r\n");
      out.write("\t\t\t\talert(\"닉네임을 입력하세요!\");\r\n");
      out.write("\t\t\t\t$(\"#userName\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar form = $(\"#joinForm\");\r\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\r\n");
      out.write("\t\t\tform.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t    \r\n");
      out.write("\t    // 로그인 \r\n");
      out.write("\t\t$(\"#btnLogin\").click(function() {\r\n");
      out.write("\t\t\tvar form = $(\"#loginForm\");\r\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\r\n");
      out.write("\t\t\tform.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\")\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t});\t    \r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Index -->\r\n");
      out.write("<div id=\"imageSlider\">\r\n");
      out.write("\t<ul id=\"imageList\">\r\n");
      out.write("\t\t<li id=\"1\"> <img style=\"width:100%;\" src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" /> </li>\r\n");
      out.write("\t\t<li id=\"2\"> <img style=\"width:100%;\" src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"/> </li>\r\n");
      out.write("\t\t<li id=\"3\"> <img style=\"width:100%;\" src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"/> </li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"index\">\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"join\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<form id=\"joinForm\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\"\ttabindex=\"1\" id=\"userEmail\" name=\"userEmail\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Email\" >\r\n");
      out.write("\t\t\t\t<input type=\"password\" class=\"form-control\"\ttabindex=\"2\" id=\"userPassword\"\r\n");
      out.write("\t\t\t\t\tname=\"userPassword\" placeholder=\"Password\" > \t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\"\ttabindex=\"1\" id=\"userName\" name=\"userName\" placeholder=\"Nick name\" >\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"btnJoin\" value=\"가입하기\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"login\">\r\n");
      out.write("\t\t<form id=\"loginForm\">\r\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\"\ttabindex=\"1\" id=\"userEmail\" name=\"userEmail\" placeholder=\" Email\" >\r\n");
      out.write("\t\t\t<input type=\"password\" class=\"form-control\"\ttabindex=\"2\" id=\"userPw\" name=\"userPw\" placeholder=\" Password\" > \r\n");
      out.write("\t\t\t<input type=\"button\" id=\"btnLogin\" value=\"로그인\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"letsJoin\">\r\n");
      out.write("\t\t<a>Join</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"clear\"></div>\r\n");
      out.write("\t<div id=\"letsLogIn\">\r\n");
      out.write("\t\t<a>Login</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"goBack\">\r\n");
      out.write("\t\t<span class=\"glyphicon glyphicon-menu-left\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Footer -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./WEB-INF/view/common/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /index.jsp(105,24) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/doJoin");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /index.jsp(113,24) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/doLogin");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /index.jsp(124,44) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/resource/img/common/IndexImg.jpg");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /index.jsp(125,44) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/resource/img/common/IndexImg2.jpg");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /index.jsp(126,44) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resource/img/common/IndexImg3.jpg");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }
}
