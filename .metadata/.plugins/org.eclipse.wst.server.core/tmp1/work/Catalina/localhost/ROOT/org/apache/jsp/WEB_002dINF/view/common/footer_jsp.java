/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
<<<<<<< HEAD
 * Generated at: 2016-04-01 05:51:44 UTC
=======
 * Generated at: 2016-04-01 03:05:00 UTC
>>>>>>> origin/YBH7
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1458628058000L));
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

<<<<<<< HEAD
      out.write("<!-- 이기연 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\"   href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" />\n");
      out.write("<link href=\"//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css\"   rel=\"stylesheet\" />\n");
      out.write("<link rel=\"stylesheet\"   href=\"//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\" />\n");
      out.write("\n");
      out.write("<!-- CSS -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"   href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("\n");
      out.write("<!-- Boot strap -->\n");
      out.write("<footer id=\"footer\">\n");
      out.write("   <div class=\"container-fluid\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("         <div class=\"col-xs-6 col-sm-3 column\">\n");
      out.write("            <h4>Information</h4>\n");
      out.write("            <ul class=\"list-unstyled\">\n");
      out.write("               <li><a href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">이용약관</a></li>\n");
      out.write("               <li><a href=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\">개인정보취급방침</a></li>\n");
      out.write("            </ul>\n");
      out.write("         </div>\n");
      out.write("         <div class=\"col-xs-6 col-sm-3 column\">\n");
      out.write("            <h4>Service Center</h4>\n");
      out.write("            <ul class=\"list-unstyled\">\n");
      out.write("               <li><a href=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\">Contact Us</a></li>\n");
      out.write("               <li><a href=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\">Q&amp;A</a></li>\n");
      out.write("            </ul>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("      <br /> <span class=\"pull-right text-muted small\"><a href=\"#\">Travel\n");
      out.write("            with Travery</a> ©2016 Travery</span>\n");
      out.write("   </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<div id=\"galleryModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\"\n");
      out.write("   aria-hidden=\"true\">\n");
      out.write("   <div class=\"modal-dialog modal-lg\">\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("         <div class=\"modal-body\">\n");
      out.write("            <img src=\"//placehold.it/1200x700/222?text=...\" id=\"galleryImage\"\n");
      out.write("               class=\"img-responsive\" />\n");
      out.write("            <p>\n");
      out.write("               <br />\n");
      out.write("               <button class=\"btn btn-primary btn-lg center-block\"\n");
      out.write("                  data-dismiss=\"modal\" aria-hidden=\"true\">\n");
      out.write("                  Close <i class=\"ion-android-close\"></i>\n");
      out.write("               </button>\n");
      out.write("            </p>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</div>\n");
      out.write("<div id=\"aboutModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\"\n");
      out.write("   aria-hidden=\"true\">\n");
      out.write("   <div class=\"modal-dialog\">\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("         <div class=\"modal-body\">\n");
      out.write("            <h2 class=\"text-center\">Landing Zero Theme</h2>\n");
      out.write("            <h5 class=\"text-center\">A free, responsive landing page theme\n");
      out.write("               built by BootstrapZero.</h5>\n");
      out.write("            <p class=\"text-justify\">This is a single-page Bootstrap template\n");
      out.write("               with a sleek dark/grey color scheme, accent color and smooth\n");
      out.write("               scrolling. There are vertical content sections with subtle\n");
      out.write("               animations that are activated when scrolled into view using the\n");
      out.write("               jQuery WOW plugin. There is also a gallery with modals that work\n");
      out.write("               nicely to showcase your work portfolio. Other features include a\n");
      out.write("               contact form, email subscribe form, multi-column footer. Uses\n");
      out.write("               Questrial Google Font and Ionicons.</p>\n");
      out.write("            <p class=\"text-center\">\n");
      out.write("               <a href=\"http://www.bootstrapzero.com\">Download at\n");
      out.write("                  BootstrapZero</a>\n");
      out.write("            </p>\n");
      out.write("            <br />\n");
      out.write("            <button class=\"btn btn-primary btn-lg center-block\"\n");
      out.write("               data-dismiss=\"modal\" aria-hidden=\"true\">OK</button>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
=======
      out.write("<!-- 이기연 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" />\r\n");
      out.write("    <link href=\"//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\"\thref=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Boot strap -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- jVector Map -->\r\n");
      out.write("\t<link rel=\"stylesheet\" media=\"all\"\thref=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("\t\r\n");
      out.write("    <footer id=\"footer\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-6 col-sm-3 column\">\r\n");
      out.write("                    <h4>Information</h4>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\">이용약관</a></li>\r\n");
      out.write("                        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\">개인정보취급방침</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-6 col-sm-3 column\">\r\n");
      out.write("                    <h4>Service Center</h4>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\">Contact Us</a></li>\r\n");
      out.write("                        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\">Q&amp;A</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-12 col-sm-3 column\">\r\n");
      out.write("                    <h4>3 section</h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-12 col-sm-3 text-right\">\r\n");
      out.write("                    <h4>4 section</h4>\r\n");
      out.write("                    <ul class=\"list-inline\">\r\n");
      out.write("                      <li>1 &nbsp;</li>\r\n");
      out.write("                      <li>2 &nbsp;</li>\r\n");
      out.write("                      <li>3 </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <span class=\"pull-right text-muted small\"><a href=\"#\">Travel with Travery</a> ©2016 Travery</span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"galleryModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog modal-lg\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("        \t<div class=\"modal-body\">\r\n");
      out.write("        \t\t<img src=\"//placehold.it/1200x700/222?text=...\" id=\"galleryImage\" class=\"img-responsive\" />\r\n");
      out.write("        \t\t<p>\r\n");
      out.write("        \t\t    <br/>\r\n");
      out.write("        \t\t    <button class=\"btn btn-primary btn-lg center-block\" data-dismiss=\"modal\" aria-hidden=\"true\">Close <i class=\"ion-android-close\"></i></button>\r\n");
      out.write("        \t\t</p>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"aboutModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("        \t<div class=\"modal-body\">\r\n");
      out.write("        \t\t<h2 class=\"text-center\">Landing Zero Theme</h2>\r\n");
      out.write("        \t\t<h5 class=\"text-center\">\r\n");
      out.write("        \t\t    A free, responsive landing page theme built by BootstrapZero.\r\n");
      out.write("        \t\t</h5>\r\n");
      out.write("        \t\t<p class=\"text-justify\">\r\n");
      out.write("        \t\t    This is a single-page Bootstrap template with a sleek dark/grey color scheme, accent color and smooth scrolling.\r\n");
      out.write("        \t\t    There are vertical content sections with subtle animations that are activated when scrolled into view using the jQuery WOW plugin. There is also a gallery with modals\r\n");
      out.write("        \t\t    that work nicely to showcase your work portfolio. Other features include a contact form, email subscribe form, multi-column footer. Uses Questrial Google Font and Ionicons.\r\n");
      out.write("        \t\t</p>\r\n");
      out.write("        \t\t<p class=\"text-center\"><a href=\"http://www.bootstrapzero.com\">Download at BootstrapZero</a></p>\r\n");
      out.write("        \t\t<br/>\r\n");
      out.write("        \t\t<button class=\"btn btn-primary btn-lg center-block\" data-dismiss=\"modal\" aria-hidden=\"true\"> OK </button>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
>>>>>>> origin/YBH7
      out.write("</html>");
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
    // /WEB-INF/view/common/footer.jsp(12,47) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resource/styles.css");
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
    // /WEB-INF/view/common/footer.jsp(21,28) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/termsAccess?menuNo=1");
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
    // /WEB-INF/view/common/footer.jsp(22,28) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/termsAccess?menuNo=2");
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
    // /WEB-INF/view/common/footer.jsp(28,28) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/contactUs");
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
    // /WEB-INF/view/common/footer.jsp(29,28) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/termsAccess?menuNo=3");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }
}
