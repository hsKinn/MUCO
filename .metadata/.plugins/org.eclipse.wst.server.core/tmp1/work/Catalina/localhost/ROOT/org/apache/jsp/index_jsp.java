/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-06 07:06:20 UTC
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
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1459859402053L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/workspace/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Travery-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
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

      out.write("<!--  이기연  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/indexHeader.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--scripts loaded here from cdn for performance -->\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\r\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   $(document).ready(function() {\r\n");
      out.write("      $(\"#join\").hide();\r\n");
      out.write("      $(\"#login\").hide();\r\n");
      out.write("      $(\"#letsJoin\").click(function() {\r\n");
      out.write("         $(\"#login\").hide();\r\n");
      out.write("         $(\"#join\").animate({\r\n");
      out.write("            height : 'toggle'\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("      $(\"#letsLogIn\").click(function() {\r\n");
      out.write("         $(\"#join\").hide();\r\n");
      out.write("         $(\"#login\").animate({\r\n");
      out.write("            height : 'toggle'\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("      // 회원 가입 \r\n");
      out.write("      $(\"#btnJoin\").click(function() {\r\n");
      out.write("         var userEmail = $(\"#userEmail\").val();\r\n");
      out.write("         userEmail = $.trim(userEmail);\r\n");
      out.write("         if (userEmail == \"\") {\r\n");
      out.write("            alert(\"이메일을 입력하세요!\");\r\n");
      out.write("            $(\"#userEmail\").focus();\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         var userPassword = $(\"#userPassword\").val();\r\n");
      out.write("         userPassword = $.trim(userPassword);\r\n");
      out.write("         if (userPassword == \"\") {\r\n");
      out.write("            alert(\"비밀번호를 입력하세요!\");\r\n");
      out.write("            $(\"#userPassword\").focus();\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         var userName = $(\"#userName\").val();\r\n");
      out.write("         userName = $.trim(userName);\r\n");
      out.write("         if (userName == \"\") {\r\n");
      out.write("            alert(\"닉네임을 입력하세요!\");\r\n");
      out.write("            $(\"#userName\").focus();\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         var form = $(\"#joinForm\");\r\n");
      out.write("         form.attr(\"method\", \"post\");\r\n");
      out.write("         form.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("         form.submit();\r\n");
      out.write("      });\r\n");
      out.write("      // 로그인 \r\n");
      out.write("      $(\"#btnLogin\").click(function() {\r\n");
      out.write("         var form = $(\"#loginForm\");\r\n");
      out.write("         form.attr(\"method\", \"post\");\r\n");
      out.write("         form.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\")\r\n");
      out.write("         form.submit();\r\n");
      out.write("      });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("    <header id=\"first\">\r\n");
      out.write("        <div class=\"header-content\">\r\n");
      out.write("            <div class=\"inner\">\r\n");
      out.write("                <h1 class=\"cursive\">Travel with Travery!</h1>\r\n");
      out.write("                <h4>Searching fit travel place with awesome Travery searching service</h4>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <a href=\"#one\" class=\"btn btn-primary btn-xl page-scroll\">Get Started</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <video autoplay=\"\" loop=\"\" class=\"fillWidth fadeIn wow collapse in\" data-wow-delay=\"0.5s\" poster=\"https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg\" id=\"video-background\">\r\n");
      out.write("            <source src=\"https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4\" type=\"video/mp4\">Your browser does not support the video tag. I suggest you upgrade your browser.\r\n");
      out.write("        </video>\r\n");
      out.write("    </header>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <section class=\"bg-primary\" id=\"one\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center\">\r\n");
      out.write("                    <h2 class=\"margin-top-0 text-primary\">Get Started Travery</h2>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <p class=\"text-faded\">\r\n");
      out.write("                       Does not have Travery account? Join us!<br/>\r\n");
      out.write("                       If have, Enjoy Travery!\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <a id=\"letsJoin\" class=\"btn btn-default btn-xl page-scroll\">Sign Up</a> &nbsp;\r\n");
      out.write("                    <a id=\"letsLogIn\" class=\"btn btn-default btn-xl page-scroll\">Login</a>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"clear\"></div>\r\n");
      out.write("               <div id=\"index\">\r\n");
      out.write("               \r\n");
      out.write("                  <div id=\"join\" style=\"margin:auto;\">\r\n");
      out.write("                     <form id=\"joinForm\">\r\n");
      out.write("                     \r\n");
      out.write("                        <input type=\"text\" class=\"form-control\"   tabindex=\"1\" id=\"userEmail\" name=\"userEmail\"\r\n");
      out.write("                           placeholder=\"Email\" >\r\n");
      out.write("                        <input type=\"password\" class=\"form-control\"   tabindex=\"2\" id=\"userPassword\"\r\n");
      out.write("                           name=\"userPassword\" placeholder=\"Password\" >          \r\n");
      out.write("                        <input type=\"text\" class=\"form-control\"   tabindex=\"1\" id=\"userName\" name=\"userName\" placeholder=\"Nick name\" >\r\n");
      out.write("                        <br/>   \r\n");
      out.write("                        <label>\r\n");
      out.write("                           <a class=\"btn btn-primary btn-xl page-scroll\">Let's Join!</a>\r\n");
      out.write("                           <input type=\"button\" id=\"btnJoin\" value=\"Signup\" style=\"display:none;\"/>\r\n");
      out.write("                        </label>\r\n");
      out.write("                        \r\n");
      out.write("                     </form>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  \r\n");
      out.write("                  \r\n");
      out.write("                  <div id=\"login\" style=\"margin:auto;\">\r\n");
      out.write("                     <form id=\"loginForm\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\"   tabindex=\"1\" id=\"userEmail\" name=\"userEmail\" placeholder=\" Email\" >\r\n");
      out.write("                        <input type=\"password\" class=\"form-control\"   tabindex=\"2\" id=\"userPw\" name=\"userPw\" placeholder=\" Password\" > \r\n");
      out.write("                        <br/>\r\n");
      out.write("                        <label>\r\n");
      out.write("                           <a class=\"btn btn-primary btn-xl page-scroll\">Let's fun!</a>\r\n");
      out.write("                           <input type=\"button\" id=\"btnLogin\" value=\"Login\" style=\"display:none;\" />\r\n");
      out.write("                        </label>                        \r\n");
      out.write("                        \r\n");
      out.write("                     </form>\r\n");
      out.write("                  </div>   \r\n");
      out.write("               \r\n");
      out.write("               </div>\r\n");
      out.write("       \r\n");
      out.write("   \r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section id=\"two\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12 text-center\">\r\n");
      out.write("                    <h2 class=\"margin-top-0 text-primary\">Travery Service</h2>\r\n");
      out.write("                    <hr class=\"primary\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-4 col-md-4 text-center\">\r\n");
      out.write("                    <div class=\"feature\">\r\n");
      out.write("                        <i class=\"icon-lg glyphicon glyphicon-phone wow fadeIn\" data-wow-delay=\".3s\"></i>\r\n");
      out.write("                        <h3>Travery SNS</h3>\r\n");
      out.write("                        <p class=\"text-muted\">Share your travel place with everybody</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-md-4 text-center\">\r\n");
      out.write("                    <div class=\"feature\">\r\n");
      out.write("                        <i class=\"icon-lg glyphicon glyphicon-globe wow fadeInUp\" data-wow-delay=\".2s\"></i>\r\n");
      out.write("                        <h3>Search</h3>\r\n");
      out.write("                        <p class=\"text-muted\">Easy to search travel place with visualization searching tool</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-md-4 text-center\">\r\n");
      out.write("                    <div class=\"feature\">\r\n");
      out.write("                        <i class=\"icon-lg glyphicon glyphicon-calendar wow fadeIn\" data-wow-delay=\".3s\"></i>\r\n");
      out.write("                        <h3>Reservation</h3>\r\n");
      out.write("                        <p class=\"text-muted\">Reserve the hotel, air plane, etc...</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section id=\"three\" class=\"no-padding\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row no-gutter\">\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d\" class=\"img-responsive\" alt=\"Image 1\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg\" class=\"img-responsive\" alt=\"Image 2\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4\" class=\"img-responsive\" alt=\"Image 3\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg\" class=\"img-responsive\" alt=\"Image 4\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg\" class=\"img-responsive\" alt=\"Image 5\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-sm-6\">\r\n");
      out.write("                    <a class=\"gallery-box\" data-toggle=\"modal\" data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg\">\r\n");
      out.write("                        <img src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg\" class=\"img-responsive\" alt=\"Image 6\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<!-- Footer -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/footer.jsp", out, false);
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
    // /index.jsp(13,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resource/js/scripts.js");
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
    // /index.jsp(55,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/doJoin");
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
    // /index.jsp(62,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
