/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-07 07:44:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.place;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class placeInfoControl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("<!-- 김동규 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<!-- Log out -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/member/logout.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Recommend placeInfo -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#recommendplaceInfoMenu\").mouseout(function() {\r\n");
      out.write("\t\t\t$(\"#recommendplaceInfoMenu\").css(\"color\", \"#ffffff\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#recommendplaceInfoMenu\").css(\"color\", \"#ffffff\");\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document)\r\n");
      out.write("\t\t\t.ready(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$(\"#massiveSelectCheckBox\").click(function() {\r\n");
      out.write("\t\t\t\t\t\t\tvar isChecked = $(this).prop(\"checked\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\".deleteplaceInfoId\").prop(\"checked\", isChecked);\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$(\"#massiveDeleteBtn\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.click(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar isChecked = false;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\".deleteplaceInfoId\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.each(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction(index,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif (data.checked) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tisChecked = data.checked;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (!isChecked) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\talert(\"Select place.\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (confirm(\"정말로 삭제 하시겠습니까?\")) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar form = $(\"#massiveDeleteForm\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tform.attr(\"method\", \"post\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tform\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t.attr(\"action\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tform.submit();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready( function() { \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#mapBtn\").click( function openMap() {\r\n");
      out.write("\t\t\turl = \"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("\t\t\twindow.open(\turl,\r\n");
      out.write("\t\t\t\t\t\t\t\"GoogleMapAPI\",\r\n");
      out.write("\t\t\t\t\t\t\t\"toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizeable=no, width=835, height=660\"\r\n");
      out.write("\t\t\t\t\t\t);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction Mapdata() {\r\n");
      out.write("\t\t\tGoogleMapAPI.document.dataform.lat;\r\n");
      out.write("\t\t\tGoogleMapAPI.document.dataform.lng;\r\n");
      out.write("\t\t\tGoogleMapAPI.document.dataform.address;\r\n");
      out.write("\t\t\tGoogleMapAPI.document.dataform.countryId;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction readURL(input) {\r\n");
      out.write("\t\tif (input.files && input.files[0]) {\r\n");
      out.write("\t\t\tvar reader = new FileReader();\r\n");
      out.write("\t\t\treader.onload = function(e) {\r\n");
      out.write("\t\t\t\t$('#blah').attr('src', e.target.result);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treader.readAsDataURL(input.files[0]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<section class=\"bg-primary\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<!-- 제목 -->\r\n");
      out.write("\t\t<div class=\"col-lg-8 col-lg-offset-2 text-center\">\r\n");
      out.write("\t\t\t<h2 class=\"margin-top-0 wow fadeIn\">Add New placeInfo</h2>\r\n");
      out.write("\t\t\t<hr class=\"primary\">\r\n");
      out.write("\t\t\t<p>Add new place.</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"placeInfoControl_Wrapper\">\r\n");
      out.write("\t\t\t<div id=\"myPlace_Wrapper\">\r\n");
      out.write("\t\t\t\t<div id=\"myPlace_Top\">\r\n");
      out.write("\t\t\t\t\t<div id=\"myPlace_Title\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-folder-open\"></span>\r\n");
      out.write("\t\t\t\t\t\tMy places\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"myPlace_btn\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"myPlace_Content\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"addNewPlace_Wrapper\">\r\n");
      out.write("\t\t\t\t<div id=\"newPlace_Title\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-cloud-upload\"></span>\r\n");
      out.write("\t\t\t\t\t<span id=\"newPlace_Title\">Add place</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<form id=\"dataForm\" name=\"dataform\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t<div id=\"newPlace_Content\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"newPlace_Top\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"placeTitle\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"placeTitle\">Place Title :</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" id=\"placeName\" name=\"placeName\" placeholder=\"Place Title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.placeName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"placeAddress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"placeAddress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAddress : \r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Place Address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"lat\" name=\"lat\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.latitude}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"lng\" name=\"lng\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.longitude}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"countryId\" name=\"countryId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.countryId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-map-marker\" id=\"mapBtn\" onclick=\"openMap(this.form)\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div id=\"newPlace_Middle\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"photo_Top\">\r\n");
      out.write("\t\t\t\t\t\t\t\tPhoto <span class=\"glyphicon glyphicon-camera\"></span> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"photo_Bottom\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"file\" id=\"image\" name=\"image\" accept=\"image/*\" onchange=\"readURL(this);\" required/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img id=\"blah\" class=\"img-rounded\" src=\"#\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div id=\"newPlace_Bottom\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"description_Top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"description_Top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tDescription\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea id=\"description\" name=\"description\" style=\"height: 100%; width: 100%;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ placeInfo.description }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"description_Bottom\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\tSUBMIT\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\t\t\t\r\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/view/place/placeInfoControl.jsp(8,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resource/css/place/placeInfoControl.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/view/place/placeInfoControl.jsp(27,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty placeInfo }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t$(\"#submitBtn\")\r\n");
        out.write("\t\t\t\t\t\t\t\t.click(\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\tfunction() {\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tvar form = $(\"#dataForm\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform.attr(\"method\", \"post\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.attr(\"action\",\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"");
        if (_jspx_meth_c_005furl_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform.submit();\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/view/place/placeInfoControl.jsp(35,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/placeInfoCreate");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/view/place/placeInfoControl.jsp(39,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ not empty placeInfo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t$(\"#modifyBtn\")\r\n");
        out.write("\t\t\t\t\t\t\t\t.click(\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\tfunction() {\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tvar form = $(\"#dataForm\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform.attr(\"method\", \"post\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.attr(\"action\",\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"");
        if (_jspx_meth_c_005furl_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\");\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tform.submit();\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/view/place/placeInfoControl.jsp(47,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/placeInfoModify");
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
    // /WEB-INF/view/place/placeInfoControl.jsp(78,17) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/placeInfoMassiveDelete");
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
    // /WEB-INF/view/place/placeInfoControl.jsp(89,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/placeInfoAddAddress");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/place/placeInfoControl.jsp(138,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ placeList }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/view/place/placeInfoControl.jsp(138,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("placeInfo");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<div class=\"myPlace_Contents\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"myPlace_Contents_top\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"/image?imageName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ placeInfo.imageName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" />\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"myPlace_Contents_bottom\">\r\n");
          out.write("\t\t\t\t\t\t\t\t <a href=\"#\" onclick=\"window.open('/detailPlace?placeId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${placeInfo.placeId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("','Place Detail','toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizeable=no, width=930, height=820');\">\r\n");
          out.write("\t\t\t\t\t\t\t\t \t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ placeInfo.placeName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t \t</a>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/view/place/placeInfoControl.jsp(197,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty placeInfo }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-send\" id=\"submitBtn\"></span>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
