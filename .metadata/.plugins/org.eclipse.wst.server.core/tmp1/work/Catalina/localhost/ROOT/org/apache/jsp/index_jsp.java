/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-04 06:02:16 UTC
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
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1458633898000L));
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

      out.write("<!--  이기연  -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/indexHeader.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<!--scripts loaded here from cdn for performance -->\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("   src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("<script\n");
      out.write("   src=\"//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js\"></script>\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("   $(document).ready(function() {\n");
      out.write("\n");
      out.write("      $(\"#join\").hide();\n");
      out.write("      $(\"#login\").hide();\n");
      out.write("\n");
      out.write("      $(\"#letsJoin\").click(function() {\n");
      out.write("         $(\"#login\").hide();\n");
      out.write("\n");
      out.write("         $(\"#join\").animate({\n");
      out.write("            height : 'toggle'\n");
      out.write("         });\n");
      out.write("\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      $(\"#letsLogIn\").click(function() {\n");
      out.write("         $(\"#join\").hide();\n");
      out.write("\n");
      out.write("         $(\"#login\").animate({\n");
      out.write("            height : 'toggle'\n");
      out.write("         });\n");
      out.write("\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      // 회원 가입 \n");
      out.write("      $(\"#btnJoin\").click(function() {\n");
      out.write("\n");
      out.write("         var userEmail = $(\"#userEmail\").val();\n");
      out.write("         userEmail = $.trim(userEmail);\n");
      out.write("         if (userEmail == \"\") {\n");
      out.write("            alert(\"이메일을 입력하세요!\");\n");
      out.write("            $(\"#userEmail\").focus();\n");
      out.write("            return;\n");
      out.write("         }\n");
      out.write("\n");
      out.write("         var userPassword = $(\"#userPassword\").val();\n");
      out.write("         userPassword = $.trim(userPassword);\n");
      out.write("         if (userPassword == \"\") {\n");
      out.write("            alert(\"비밀번호를 입력하세요!\");\n");
      out.write("            $(\"#userPassword\").focus();\n");
      out.write("            return;\n");
      out.write("         }\n");
      out.write("\n");
      out.write("         var userName = $(\"#userName\").val();\n");
      out.write("         userName = $.trim(userName);\n");
      out.write("         if (userName == \"\") {\n");
      out.write("            alert(\"닉네임을 입력하세요!\");\n");
      out.write("            $(\"#userName\").focus();\n");
      out.write("            return;\n");
      out.write("         }\n");
      out.write("\n");
      out.write("         var form = $(\"#joinForm\");\n");
      out.write("         form.attr(\"method\", \"post\");\n");
      out.write("         form.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\");\n");
      out.write("         form.submit();\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      // 로그인 \n");
      out.write("      $(\"#btnLogin\").click(function() {\n");
      out.write("         var form = $(\"#loginForm\");\n");
      out.write("         form.attr(\"method\", \"post\");\n");
      out.write("         form.attr(\"action\", \"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\")\n");
      out.write("         form.submit();\n");
      out.write("      });\n");
      out.write("\n");
      out.write("   });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<header id=\"first\">\n");
      out.write("   <div class=\"header-content\">\n");
      out.write("      <div class=\"inner\">\n");
      out.write("         <h1 class=\"cursive\">Travel with Travery!</h1>\n");
      out.write("         <h4>Searching fit travel place with awesome Travery searching\n");
      out.write("            service</h4>\n");
      out.write("         <hr>\n");
      out.write("         <a href=\"#one\" class=\"btn btn-primary btn-xl page-scroll\">Get\n");
      out.write("            Started</a>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("   <video autoplay=\"\" loop=\"\" class=\"fillWidth fadeIn wow collapse in\"\n");
      out.write("      data-wow-delay=\"0.5s\"\n");
      out.write("      poster=\"https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg\"\n");
      out.write("      id=\"video-background\">\n");
      out.write("      <source\n");
      out.write("         src=\"https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4\"\n");
      out.write("         type=\"video/mp4\">\n");
      out.write("      Your browser does not support the video tag. I suggest you upgrade\n");
      out.write("      your browser.\n");
      out.write("   </video>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section class=\"bg-primary\" id=\"one\">\n");
      out.write("   <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("         <div\n");
      out.write("            class=\"col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center\">\n");
      out.write("            <h2 class=\"margin-top-0 text-primary\">Get Started Travery</h2>\n");
      out.write("            <br>\n");
      out.write("            <p class=\"text-faded\">\n");
      out.write("               Does not have Travery account? Join us!<br /> If have, Enjoy\n");
      out.write("               Travery!\n");
      out.write("            </p>\n");
      out.write("            <a id=\"letsJoin\" class=\"btn btn-default btn-xl page-scroll\">Sign\n");
      out.write("               Up</a> &nbsp; <a id=\"letsLogIn\"\n");
      out.write("               class=\"btn btn-default btn-xl page-scroll\">Login</a>\n");
      out.write("\n");
      out.write("            <div class=\"clear\"></div>\n");
      out.write("            <div id=\"index\">\n");
      out.write("\n");
      out.write("               <div id=\"join\" style=\"margin: auto;\">\n");
      out.write("                  <form id=\"joinForm\">\n");
      out.write("\n");
      out.write("                     <input type=\"text\" class=\"form-control\" tabindex=\"1\"\n");
      out.write("                        id=\"userEmail\" name=\"userEmail\" placeholder=\"Email\"> <input\n");
      out.write("                        type=\"password\" class=\"form-control\" tabindex=\"2\"\n");
      out.write("                        id=\"userPassword\" name=\"userPassword\" placeholder=\"Password\">\n");
      out.write("                     <input type=\"text\" class=\"form-control\" tabindex=\"1\"\n");
      out.write("                        id=\"userName\" name=\"userName\" placeholder=\"Nick name\"> <br />\n");
      out.write("                     <label> <a class=\"btn btn-primary btn-xl page-scroll\">Let's\n");
      out.write("                           Join!</a> <input type=\"button\" id=\"btnJoin\" value=\"Signup\"\n");
      out.write("                        style=\"display: none;\" />\n");
      out.write("                     </label>\n");
      out.write("\n");
      out.write("                  </form>\n");
      out.write("               </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("               <div id=\"login\" style=\"margin: auto;\">\n");
      out.write("                  <form id=\"loginForm\">\n");
      out.write("                     <input type=\"text\" class=\"form-control\" tabindex=\"1\"\n");
      out.write("                        id=\"userEmail\" name=\"userEmail\" placeholder=\" Email\"> <input\n");
      out.write("                        type=\"password\" class=\"form-control\" tabindex=\"2\" id=\"userPw\"\n");
      out.write("                        name=\"userPw\" placeholder=\" Password\"> <br /> <label>\n");
      out.write("                        <a class=\"btn btn-primary btn-xl page-scroll\">Let's fun!</a> <input\n");
      out.write("                        type=\"button\" id=\"btnLogin\" value=\"Login\" style=\"display: none;\" />\n");
      out.write("                     </label>\n");
      out.write("\n");
      out.write("                  </form>\n");
      out.write("               </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</section>\n");
      out.write("<section id=\"two\">\n");
      out.write("   <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("         <div class=\"col-lg-12 text-center\">\n");
      out.write("            <h2 class=\"margin-top-0 text-primary\">Travery Service</h2>\n");
      out.write("            <hr class=\"primary\">\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("   <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("         <div class=\"col-lg-4 col-md-4 text-center\">\n");
      out.write("            <div class=\"feature\">\n");
      out.write("               <i class=\"icon-lg glyphicon glyphicon-phone wow fadeInUp\"\n");
      out.write("                  data-wow-delay=\".3s\"></i>\n");
      out.write("               <h3>Travery SNS</h3>\n");
      out.write("               <p class=\"text-muted\">Share your travel place with everybody</p>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-md-4 text-center\">\n");
      out.write("            <div class=\"feature\">\n");
      out.write("               <i class=\"icon-lg glyphicon glyphicon-globe wow fadeInUp\"\n");
      out.write("                  data-wow-delay=\".2s\"></i>\n");
      out.write("               <h3>Search</h3>\n");
      out.write("               <p class=\"text-muted\">Easy to search travel place with\n");
      out.write("                  visualization searching tool</p>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-md-4 text-center\">\n");
      out.write("            <div class=\"feature\">\n");
      out.write("               <i class=\"icon-lg glyphicon glyphicon-calendar wow fadeInUp\"\n");
      out.write("                  data-wow-delay=\".3s\"></i>\n");
      out.write("               <h3>Reservation</h3>\n");
      out.write("               <p class=\"text-muted\">Easy to reserve hotels, air plane, etc... with Travery Reservation Servie!</p>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</section>\n");
      out.write("<section id=\"three\" class=\"no-padding\">\n");
      out.write("   <div class=\"container-fluid\">\n");
      out.write("      <div class=\"row no-gutter\">\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1430916273432-273c2db881a0%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3Df047e8284d2fdc1df0fd57a5d294614d\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 1\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/getrefe/regular/tumblr_nqune4OGHl1slhhf0o1_1280.jpg\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 2\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/unsplash/regular/photo-1433959352364-9314c5b6eb0b%3Fq%3D75%26fm%3Djpg%26w%3D1080%26fit%3Dmax%26s%3D3b9bc6caa190332e91472b6828a120a4\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 3\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-moto-drawing-illusion-nabeel-1440x960.jpg\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 4\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-new-york-crosswalk-nabeel-1440x960.jpg\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 5\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("            <a href=\"#galleryModal\" class=\"gallery-box\" data-toggle=\"modal\"\n");
      out.write("               data-src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg\">\n");
      out.write("               <img\n");
      out.write("               src=\"//splashbase.s3.amazonaws.com/lifeofpix/regular/Life-of-Pix-free-stock-photos-clothes-exotic-travel-nabeel-1440x960.jpg\"\n");
      out.write("               class=\"img-responsive\" alt=\"Image 6\">\n");
      out.write("               <div class=\"gallery-box-caption\">\n");
      out.write("                  <div class=\"gallery-box-content\">\n");
      out.write("                     <div>\n");
      out.write("                        <i class=\"icon-lg ion-ios-search\"></i>\n");
      out.write("                     </div>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </a>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</section>\n");
      out.write("<aside class=\"bg-dark\">\n");
      out.write("   <div class=\"container text-center\">\n");
      out.write("      <div class=\"call-to-action\">\n");
      out.write("         <h2 class=\"text-primary\">Developers</h2>\n");
      out.write("      </div>\n");
      out.write("      <hr />\n");
      out.write("      <br>\n");
      out.write("      <div class=\"row\">\n");
      out.write("         <div class=\"col-lg-10 col-lg-offset-1\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("               <h6 class=\"wide-space text-center\">TRAVERY IS DEVELOPED BY\n");
      out.write("                  THESE AWESOME GUYS!</h6>\n");
      out.write("               <img id=\"blah\" class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" /> &nbsp;&nbsp; <img id=\"blah\"\n");
      out.write("                  class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" /> &nbsp;&nbsp; <img id=\"blah\"\n");
      out.write("                  class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" /> &nbsp;&nbsp; <img id=\"blah\"\n");
      out.write("                  class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" /> &nbsp;&nbsp; <img id=\"blah\"\n");
      out.write("                  class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" /> &nbsp;&nbsp; <img id=\"blah\"\n");
      out.write("                  class=\"img-circle\"\n");
      out.write("                  src=\"");
      if (_jspx_meth_c_005furl_005f8(_jspx_page_context))
        return;
      out.write("\"\n");
      out.write("                  style=\"width: 100px;\" />\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("</aside>\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
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
    // /index.jsp(16,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /index.jsp(70,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /index.jsp(78,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/doLogin");
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
    // /index.jsp(315,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/resource/img/common/leina.jpg");
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
    // /index.jsp(318,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resource/img/common/leina.jpg");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /index.jsp(321,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/resource/img/common/leina.jpg");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /index.jsp(324,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/resource/img/common/leina.jpg");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent(null);
    // /index.jsp(327,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/resource/img/common/leina.jpg");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent(null);
    // /index.jsp(330,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/resource/img/common/leina.jpg");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }
}
