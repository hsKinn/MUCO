/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-30 06:45:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.reserve;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tripReservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1459320186681L));
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
  }

  public void _jspDestroy() {
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

      out.write("<!-- 유병훈 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Log out -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/member/logout.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Left Menu -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/leftMenu.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Trip Reservation -->\r\n");
      out.write("<div id=\"tripReservationWrapper\">\r\n");
      out.write("\t<form id=\"reservationForm\">\r\n");
      out.write("\t\r\n");
      out.write("\t<b style=\"color:#ffffff; font-size: 37px; padding-left:33%;\">TRIP RESERVATION</b>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 출발,여행지 입력 -->\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t \t<label for=\"departure\">출발지:\r\n");
      out.write("\t  \t<input type=\"text\" class=\"form-control\" id=\"departure\" />\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t<img src=\"/resource/img/reserve/arrow.png\" style=\"height:20px;\"/>\r\n");
      out.write("\t  \t<label for=\"destination\">여행지:\r\n");
      out.write("\t  \t<select class=\"form-control\" id=\"destination\" style=\"width:200px;\" >\r\n");
      out.write("\t    \t<option>my list</option>\r\n");
      out.write("\t    \t<option>my list</option>\r\n");
      out.write("\t    \t<option>my list</option>\r\n");
      out.write("\t    \t<option>my list</option>\r\n");
      out.write("\t  \t</select>\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 교통 입력 -->\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t  \t<label for=\"traffic\">교통:\r\n");
      out.write("\t  \t<input type=\"text\" disabled=\"disabled\" value=\"비행기\"class=\"form-control\" id=\"traffic\" />\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t<label for=\"grade\">등급:\r\n");
      out.write("\t  \t<select class=\"form-control\" id=\"grade\" style=\"width:200px;\" >\r\n");
      out.write("\t    \t<option>이코노미</option>\r\n");
      out.write("\t    \t<option>비지니스</option>\r\n");
      out.write("\t  \t</select>\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t<label for=\"departureDate\">출국일:\r\n");
      out.write("\t  \t<input type=\"date\" class=\"form-control\" id=\"departureDate\" />\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t<label for=\"destinationDate\">귀국일:\r\n");
      out.write("\t  \t<input type=\"date\" class=\"form-control\" id=\"destinationDate\" />\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t<label for=\"traPerson\">인원:\r\n");
      out.write("\t  \t<input type=\"number\" class=\"form-control\" id=\"traPerson\" value=\"1\"/>\r\n");
      out.write("\t  \t</label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 숙소 입력 -->\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t\r\n");
      out.write("\t  <label for=\"accommodations\">숙소:\r\n");
      out.write("\t  <select class=\"form-control\" id=\"accommodations\" style=\"width:200px;\" >\r\n");
      out.write("\t    <option>호텔</option>\r\n");
      out.write("\t    <option>호스텔</option>\r\n");
      out.write("\t    <option>게스트하우스</option>\r\n");
      out.write("\t  </select>\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <label for=\"accGrade\">등급:\r\n");
      out.write("\t  <select class=\"form-control\" id=\"accGrade\" style=\"width:200px;\" >\r\n");
      out.write("\t  \t<option>1인실</option>\r\n");
      out.write("\t  \t<option>2인실</option>\r\n");
      out.write("\t  \t<option>3인실</option>\r\n");
      out.write("\t  \t<option>4인실</option>\r\n");
      out.write("\t  \t<option>남녀혼용</option>\r\n");
      out.write("\t  \t<option>남자전용</option>\r\n");
      out.write("\t  \t<option>여자전용</option>\r\n");
      out.write("\t  </select>\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <label for=\"checkIn\">체크인:\r\n");
      out.write("\t  <input type=\"date\" class=\"form-control\" id=\"checkIn\"  />\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  <label for=\"checkOut\">체크아웃:\r\n");
      out.write("\t  <input type=\"date\" class=\"form-control\" id=\"checkOut\"  />\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <label for=\"accPerson\">인원:\r\n");
      out.write("\t  <input type=\"number\" class=\"form-control\" id=\"accPerson\" value=\"1\" />\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 렌트 입력 -->\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t\r\n");
      out.write("\t  <label for=\"rentCar\">렌트카:\r\n");
      out.write("\t  <select class=\"form-control\" id=\"rentCar\" style=\"width:200px;\">\r\n");
      out.write("\t    <option>대형</option>\r\n");
      out.write("\t    <option>중형</option>\r\n");
      out.write("\t    <option>소형</option>\r\n");
      out.write("\t    <option>경차</option>\r\n");
      out.write("\t    <option>suv</option>\r\n");
      out.write("\t  </select>\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <label for=\"rentDate\">대여일:\r\n");
      out.write("\t  <input type=\"date\" class=\"form-control\" id=\"rentDate\" />\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  <label for=\"returnDate\">반납일:\r\n");
      out.write("\t  <input type=\"date\" class=\"form-control\" id=\"returnDate\" />\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <label for=\"rentPerson\">인원:\r\n");
      out.write("\t  <input type=\"number\" class=\"form-control\" id=\"rentPerson\" value=\"1\"/>\r\n");
      out.write("\t  </label>\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 제출 -->\r\n");
      out.write("\t<div id=\"reserveSubmit\" >\r\n");
      out.write("\t<button type=\"submit\" class=\"btn btn-default\" id=\"subminBtn\" name=\"subminBtn\">제출</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
}
