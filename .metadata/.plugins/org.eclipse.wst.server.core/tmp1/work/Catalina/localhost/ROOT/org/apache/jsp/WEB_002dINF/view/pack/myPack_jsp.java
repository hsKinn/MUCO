/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-31 06:13:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.pack;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myPack_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1458724465294L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/Documents/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Travery-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
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

      out.write("<!-- 백지경 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Boot Script -->\r\n");
      out.write("<script\tsrc=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- My Package -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#myPackMenu\").mouseout(function() {\r\n");
      out.write("\t\t\t$(\"#myPackMenu\").css(\"color\", \"#ffffff\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#myPackMenu\").css(\"color\", \"#ffffff\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#placesOfPackListdiv\").hide();\r\n");
      out.write("\r\n");
      out.write("\t\t$(\".pack\").click(function() {\r\n");
      out.write("\t\t\t$(\"#placesOfPackListdiv\").hide();\r\n");
      out.write("\t\t\t$(\"#placesOfPackListdiv\").fadeIn(\"slow\");\r\n");
      out.write("\t\t\tvar packId = $(this).children(\":eq(2)\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.post(\"/packInfo\", {\r\n");
      out.write("\t\t\t\t\"packId\" : packId\r\n");
      out.write("\t\t\t}, function(data) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar jsonData = {};\r\n");
      out.write("\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\tjsonData = JSON.parse(data);\r\n");
      out.write("\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\tjsonData.result = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tconsole.log(jsonData);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (jsonData.result) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$(\"#packData_Title\").val(jsonData.title);\r\n");
      out.write("\t\t\t\t\t$(\"#packData_image\").attr(\"src\", \"/image?imageName=\"+jsonData.imageName);\r\n");
      out.write("\t\t\t\t\tif (jsonData.isPublic == 1) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#packData_IsPublic\").attr(\"checked\", true);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#packData_IsPublic\").attr(\"checked\", false);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$(\"#packData_likeCount\").text(jsonData.likeCount);\r\n");
      out.write("\t\t\t\t\t$(\"#packData_viewCount\").text(jsonData.viewCount);\r\n");
      out.write("\t\t\t\t\t$(\"#curpackId\").val(jsonData.packId);\r\n");
      out.write("\t\t\t\t\t$(\".hashtagBox\").text(jsonData.hashtags);\r\n");
      out.write("\t\t\t\t\t$(\"#texthashtag\").val(jsonData.hashtags);\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t/* alert(\"세션이 만료되었습니다. 다시 로그인해주세요.\");\r\n");
      out.write("\t\t\t\t\tlocation.href = \"/\"; */\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#hashtagAddBtn\").click(function() {\r\n");
      out.write("\t\t\tvar tag = $(\"#hashTag\").val();\r\n");
      out.write("\t\t\tvar tags = $(\"#texthashtag\").val();\r\n");
      out.write("\t\t\t$(\".hashtagBox\").append(\" #\"+tag);\r\n");
      out.write("\t\t\t$(\"#texthashtag\").val(tags+\" \"+tag);\r\n");
      out.write("\t\t\t$(\"#hashTag\").val(null);\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\".btn-success\").click(function() {\r\n");
      out.write("\t\t\tvar form = $(\"#modifyForm\");\r\n");
      out.write("\t\t\tvar isPublic = $(\"#packData_IsPublic\").is(\":checked\");\r\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\r\n");
      out.write("\t\t\tform.attr(\"action\", \"/doModifyPack\");\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<section class=\"bg-primary\" id=\"one\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div id=\"mypackWrapperdiv\">\r\n");
      out.write("\t\t\t<div id=\"mypackListdiv\">\r\n");
      out.write("\t\t\t\t<table id=\"packListTable\" border=\"2\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"buttondiv\">\r\n");
      out.write("\t\t\t\t<a href=\"/addPack\"><span class=\"glyphicon glyphicon-plus-sign\"></span></a>\r\n");
      out.write("\t\t\t\t<a href=\"/deletePack\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-minus-sign\"></span></a> <a href=\"/myPack\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-ok-sign\"></span></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"packListdiv2\">\r\n");
      out.write("\t\t\t<div id=\"placesOfPackListdiv\" align=\"center\">\r\n");
      out.write("\t\t\t\t<img id=\"packData_image\" src=\"#\" /><br /> <br />\r\n");
      out.write("\t\t\t\t<form id=\"modifyForm\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"file\" name=\"file\" value=\"file\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"packData_Title\">Pack Title :</label> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" class=\"form-control\" id=\"packData_Title\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"packData_Title\" style=\"width: 50%; display: inline;\"></span><br />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"curpackId\" name=\"curpackId\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"submit\" style=\"display: none\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"packData_Title\">Share :</label> <label class=\"switch\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"packData_IsPublic\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"packData_IsPublic\" value=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"slider round\"></div>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"viewCount\">View Count :</label> <span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"packData_viewCount\" name=\"packData_viewCount\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"likeCount\">Like Count :</label> <span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"packData_likeCount\" name=\"packData_likeCount\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"texthashtag\">Hash Tag :</label> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"texthashtag\" id=\"texthashtag\" /> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control\" id=\"hashTag\" name=\"hashTag\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 30%; display: inline;\" />\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"hashtagAddBtn\" class=\"btn btn-info\">Push</button>\r\n");
      out.write("\t\t\t\t\t\t</br> <span class=\"hashtagBox\" name=\"hashtagBox\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-success\">OK</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/pack/myPack.jsp(88,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packs}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/view/pack/myPack.jsp(88,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("packs");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td class=\"pack\"><img\r\n");
          out.write("\t\t\t\t\t\t\t\tsrc=\"");
          if (_jspx_meth_c_005furl_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\"\r\n");
          out.write("\t\t\t\t\t\t\t\tid=\"folderImg\" /> <label id=\"title\" for=\"packData_Title\"\r\n");
          out.write("\t\t\t\t\t\t\t\tstyle=\"font-size: 20px; display: inline;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packs.packTitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"packId\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packs.packId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" /></td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
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
    // /WEB-INF/view/pack/myPack.jsp(91,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
