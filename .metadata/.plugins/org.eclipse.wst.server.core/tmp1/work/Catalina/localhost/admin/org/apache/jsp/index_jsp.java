/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-07 08:54:52 UTC
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
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1460007159000L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/workspace/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Travery-Admin/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
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

      out.write('\n');
      out.write('\n');

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

      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./WEB-INF/view/common/indexHeader.jsp", out, false);
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- id=\"header\" -->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\n");
      out.write("\t\t$(\"#login\").hide();\n");
      out.write("\t\t$(\"#goBack\").hide();\n");
      out.write("\t\t\n");
      out.write("\t    \n");
      out.write("\t    $(\"#letsLogIn\").click(function(){\n");
      out.write("\t    \t $(\"#letsLogIn\").animate({\n");
      out.write("\t             height: 'toggle'\n");
      out.write("\t         });\n");
      out.write("\t    \t $(\"#login\").animate({\n");
      out.write("\t             height: 'toggle'\n");
      out.write("\t         });\n");
      out.write("\t    \t \n");
      out.write("\t \t\t$(\"#letsJoin\").hide();\n");
      out.write("\t \t\t$(\"#join\").hide();\n");
      out.write("\t\t\t$(\"#goBack\").show();\n");
      out.write("\t    });\n");
      out.write("\t    \n");
      out.write("\t    $(\"#goBack\").click(function(){\n");
      out.write("\t    \t$(\"#join\").hide();\n");
      out.write("\t    \t$(\"#login\").hide();\n");
      out.write("\t\t\t$(\"#letsJoin\").show();\n");
      out.write("\t\t\t$(\"#letsLogIn\").show();\n");
      out.write("\t\t\t$(\"#goBack\").hide();\n");
      out.write("\t    });\n");
      out.write("\n");
      out.write("\t    // admin인지 확인 \n");
      out.write("\t\t$(\"#userEmail\").blur(function() {\n");
      out.write("\n");
      out.write("\t\t\t$.post(\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\", {\n");
      out.write("\t\t\t\t\"email\" : $(\"#userEmail\").val()\n");
      out.write("\t\t\t}, function(data) {\n");
      out.write("\n");
      out.write("\t\t\t\tvar jsonData = {};\n");
      out.write("\n");
      out.write("\t\t\t\ttry {\n");
      out.write("\t\t\t\t\tjsonData = JSON.parse(data);\n");
      out.write("\t\t\t\t} catch (e) {\n");
      out.write("\t\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t\tif (jsonData.result) {\n");
      out.write("\t\t\t\t\t//isAdmin : true\n");
      out.write("\t\t\t\t\tif (jsonData.isAdmin) {\n");
      out.write("\t\t\t\t\t\t$(\"#submit\").attr(\"disabled\", true);\n");
      out.write("\t\t\t\t\t//isAdmin : false\n");
      out.write("\t\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t\talert(\"접근할 수 없습니다\")\n");
      out.write("\t\t\t\t\t\t$(\"#userEmail\").val(\"\");\n");
      out.write("\t\t\t\t\t\t$(\"#userEmail\").focus();\n");
      out.write("\t\t\t\t\t\t$(\"#submit\").removeAttr(\"disabled\");\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\talert(\"세션을 종료합니다.\");\n");
      out.write("\t\t\t\t\tlocation.href = \"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t});\t    \n");
      out.write("\t    // 로그인 \n");
      out.write("\t\t$(\"#btnLogin\").click(function() {\n");
      out.write("\t\t\tvar form = $(\"#loginForm\");\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\n");
      out.write("\t\t\tform.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\")\n");
      out.write("\t\t\tform.submit();\n");
      out.write("\t\t});\t    \n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Index -->\n");
      out.write("<div id=\"index\">\n");
      out.write("\n");
      out.write("\t<div id=\"login\">\n");
      out.write("\t\t<form id=\"loginForm\">\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\"\ttabindex=\"1\" id=\"userEmail\" name=\"userEmail\" placeholder=\" Email\" >\n");
      out.write("\t\t\t<input type=\"password\" class=\"form-control\"\ttabindex=\"2\" id=\"userPw\" name=\"userPw\" placeholder=\" Password\" > \n");
      out.write("\t\t\t<input type=\"button\" id=\"btnLogin\" value=\"로그인\" />\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\t\n");
      out.write("\n");
      out.write("\t<div class=\"clear\"></div>\n");
      out.write("\t<div id=\"letsLogIn\">\n");
      out.write("\t\t<a>Login</a>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"goBack\">\n");
      out.write("\t\t<span class=\"glyphicon glyphicon-menu-left\"></span>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
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
    // /index.jsp(65,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/adminCheck");
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
    // /index.jsp(89,22) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/");
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
    // /index.jsp(99,24) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/doLogin");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }
}
