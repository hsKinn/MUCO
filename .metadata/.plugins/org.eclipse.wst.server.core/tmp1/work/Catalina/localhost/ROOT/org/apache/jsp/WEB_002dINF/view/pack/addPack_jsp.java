/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-31 06:02:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.pack;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addPack_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("<!-- 백지경 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<!-- My Package -->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#myPackMenu\").mouseout(function() {\n");
      out.write("\t\t\t$(\"#myPackMenu\").css(\"color\", \"#ffffff\");\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#myPackMenu\").css(\"color\", \"#ffffff\");\n");
      out.write("\n");
      out.write("\t\t$(\"#addPackImg\").hide();\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#hashtagAddBtn\").click(function() {\n");
      out.write("\t\t\tvar tag = $(\"#hashTag\").val();\n");
      out.write("\t\t\tvar tags = $(\"#texthashtag\").val();\n");
      out.write("\t\t\t$(\".hashtagBox\").append(\" #\"+tag);\n");
      out.write("\t\t\t$(\"#texthashtag\").val(tags+\" \"+tag);\n");
      out.write("\t\t\t$(\"#hashTag\").val(null);\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t$(\".btn-primary\").click(function() {\n");
      out.write("\t\t\tvar form = $(\"#addPack\");\n");
      out.write("\t\t\talert(form.hashtagBox);\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\n");
      out.write("\t\t\tform.attr(\"action\", \"/doAddPack\");\n");
      out.write("\t\t\tform.submit();\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction readURL(input) {\n");
      out.write("\t\tif (input.files && input.files[0]) {\n");
      out.write("\t\t\t$(\"#addPackImg\").show();\n");
      out.write("\n");
      out.write("\t\t\tvar reader = new FileReader();\n");
      out.write("\t\t\treader.onload = function(e) {\n");
      out.write("\t\t\t\t$('#addPackImg').attr('src', e.target.result);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\treader.readAsDataURL(input.files[0]);\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<section class=\"bg-primary\" id=\"one\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div id=\"mypackWrapperdiv\">\n");
      out.write("\t\t\t<div id=\"mypackListdiv\">\n");
      out.write("\t\t\t\t<table id=\"packListTable\" border=\"2\">\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"buttondiv\">\n");
      out.write("\t\t\t\t<a href=\"/myPack\"><span class=\"glyphicon glyphicon-ok-sign\"></span></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"packListdiv2\">\n");
      out.write("\t\t\t<div id=\"addPackFormdiv\" align=\"center\";>\n");
      out.write("\t\t\t\t<form id=\"addPack\" enctype=\"multipart/form-data\" role=\"form\">\n");
      out.write("\t\t\t\t\t<div class=\"form-group\" align=\"center\" ; style=\"display: inline;\">\n");
      out.write("\t\t\t\t\t\t<label for=\"file\"> My package Image : </label> <br />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\" align=\"center\" ; style=\"display: inline;\">\n");
      out.write("\t\t\t\t\t\t<img id=\"addPackImg\" class=\"img-rounded\" src=\"#\"\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 150px; height: 150px;\" /><br /> <br /> <br /> <input\n");
      out.write("\t\t\t\t\t\t\ttype=\"file\" id=\"image\" name=\"image\" accept=\"image/*\"\n");
      out.write("\t\t\t\t\t\t\tonchange=\"readURL(this); \" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"title\">My package name : </label> <input type=\"text\"\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control\" id=\"title\" name=\"title\"\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 50%; display: inline;\" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"packData_Title\">Share :</label> <label class=\"switch\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"packData_IsPublic\"\n");
      out.write("\t\t\t\t\t\t\tname=\"packData_IsPublic\" value=\"1\" />\n");
      out.write("\t\t\t\t\t\t\t<div class=\"slider round\"></div>\n");
      out.write("\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"texthashtag\">Hash Tag :</label> <input type=\"hidden\"\n");
      out.write("\t\t\t\t\t\t\tname=\"texthashtag\" id=\"texthashtag\" /> <input type=\"text\"\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control\" id=\"hashTag\" name=\"hashTag\"\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 30%; display: inline;\" />\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"hashtagAddBtn\" class=\"btn btn-info\">Push</button>\n");
      out.write("\t\t\t\t\t\t</br> <span class=\"hashtagBox\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\" style=\"width: 130px;\">AddPackage</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</section>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/pack/addPack.jsp(58,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ packs}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/view/pack/addPack.jsp(58,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("packs");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t\t\t<td class=\"pack\"><img\n");
          out.write("\t\t\t\t\t\t\t\tsrc=\"");
          if (_jspx_meth_c_005furl_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\"\n");
          out.write("\t\t\t\t\t\t\t\tid=\"folderImg\" /> <label id=\"title\" for=\"packData_Title\"\n");
          out.write("\t\t\t\t\t\t\t\tstyle=\"font-size: 20px; display: inline;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packs.packTitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"packId\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packs.packId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" /></td>\n");
          out.write("\t\t\t\t\t\t</tr>\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/view/pack/addPack.jsp(61,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resource/img/pack/folder.png");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
