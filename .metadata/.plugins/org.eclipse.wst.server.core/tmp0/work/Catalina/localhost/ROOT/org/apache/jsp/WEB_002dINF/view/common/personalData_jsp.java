/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-29 05:43:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class personalData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1458628058000L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/Documents/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Travery-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- 개인정보취급방침 페이지 -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"menu2\" class=\"tab-pane fade\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"content\" class=\"privacy\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"section\">\r\n");
      out.write("            <h3>TRAVERY 개인정보취급방침</h3>\r\n");
      out.write("            <p>TRAVERY는 서비스 기획부터 종료까지 정보통신망 이용촉진 및 정보보호 등에 관한 법률(이하 ‘정보통신망법’), 개인정보보호법 등 국내의 개인정보 보호 법령을 철저히 준수합니다. 또한 OECD의 개인정보 보호 가이드라인 등 국제 기준을 준수하여 서비스를 제공합니다.</p>\r\n");
      out.write("            <div class=\"btn_area\">\r\n");
      out.write("                <a href=\"http://www.law.go.kr/lsInfoP.do?lsiSeq=167388&amp;efYd=20150421#0000\" class=\"sp btn0_1\">‘정보통신망법’ 바로가기</a>\r\n");
      out.write("                <a href=\"http://www.law.go.kr/lsInfoP.do?lsiSeq=173223&amp;efYd=20150724#0000\" class=\"sp btn0_2\">‘개인정보보호법’ 바로가기</a>\r\n");
      out.write("                <a href=\"http://www.oecd.org/sti/ieconomy/oecdguidelinesontheprotectionofprivacyandtransborderflowsofpersonaldata.htm\" class=\"sp btn0_3\">‘OECD Guidelines(영문)’ 바로가기</a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"shortcut\">\r\n");
      out.write("                <p>본 개인정보취급방침의 목차는 아래와 같습니다. <br>\r\n");
      out.write("                일부는 관계법령이 개인정보취급방침의 작성에 있어 요구하는 필수 사항을 포함하였고, 나머지는 TRAVERY가 자체적으로 이용자의 개인정보 보호에 있어 중요하다 판단하는 내용을 추가하였습니다.</p>\r\n");
      out.write("                <ol class=\"sc1\">\r\n");
      out.write("                    <li><i>1.</i><a href=\"#pd1\">개인정보취급방침의 의의</a></li>\r\n");
      out.write("                    <li><i>2.</i><a href=\"#pd2\">수집하는 개인정보 (필수 안내사항)</a></li>\r\n");
      out.write("                    <li><i>3.</i><a href=\"#pd3\">수집한 개인정보의 이용 (필수 안내사항)</a></li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li><i>4.</i><a href=\"#pd5\">개인정보의 파기 (필수 안내사항)</a></li>\r\n");
      out.write("                </ol>\r\n");
      out.write("                <ol class=\"sc2\">\r\n");
      out.write("                    <li><i>5.</i><a href=\"#pd6\">이용자 및 법정대리인의 권리와 행사 방법 (필수 안내사항)</a></li>\r\n");
      out.write("                    <li><i>6.</i><a href=\"#pd7\">개인정보보호를 위한 TRAVERY의 노력</a></li>\r\n");
      out.write("                    <li><i>7.</i><a href=\"#pd8\">개인정보 관리책임자 및 담당자 안내 (필수 안내사항)</a></li>\r\n");
      out.write("                    <li><i>8.</i><a href=\"#pd9\">본 개인정보취급방침의 적용 범위</a></li>\r\n");
      out.write("                    <li><i>9.</i><a href=\"#pd10\">개정 전 고지 의무</a></li>\r\n");
      out.write("                </ol>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd1\" class=\"section\">\r\n");
      out.write("            <h4>1. 개인정보취급방침의 의의</h4>\r\n");
      out.write("            <p><strong class=\"b\">TRAVERY는 본 개인정보취급방침을 정보통신망법을 기준으로 작성하되, TRAVERY 내에서의 이용자 개인정보 취급 현황을 최대한 알기 쉽고 상세하게 설명하기 위해 노력하였습니다.</strong><br>\r\n");
      out.write("            이는 쉬운 용어를 사용한 개인정보취급방침 작성 원칙인 ‘Plain Language Privacy Policy(쉬운 용어를 사용한 개인정보취급방침)’를 도입한 것입니다.</p>\r\n");
      out.write("            <div class=\"btn_area\">\r\n");
      out.write("                <a href=\"http://centerforplainlanguage.org/5-steps-to-plain-language/\" class=\"sp btn1_1\">‘쉬운 용어를 사용한 개인정보취급방침 작성 체크리스트(영문)’ 바로가기</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p>개인정보취급방침은 다음과 같은 중요한 의미를 가지고 있습니다.</p>\r\n");
      out.write("            <ul class=\"bu\">\r\n");
      out.write("                <li><i></i>TRAVERY가 어떤 정보를 수집하고, 수집한 정보를 어떻게 사용하며, 필요에 따라 누구와 이를 공유(‘위탁 또는 제공’)하며, 이용목적을 달성한 정보를 언제·어떻게 파기하는지 등 ‘개인정보의 한살이’와 관련한 정보를 투명하게 제공합니다.</li>\r\n");
      out.write("                <li><i></i>정보주체로서 이용자는 자신의 개인정보에 대해 어떤 권리를 가지고 있으며, 이를 어떤 방법과 절차로 행사할 수 있는지를 알려드립니다. 또한, 법정대리인(부모 등)이 만14세 미만 아동의 개인정보 보호를 위해 어떤 권리를 행사할 수 있는지도 함께 안내합니다.</li>\r\n");
      out.write("                <li><i></i>개인정보 침해사고가 발생하는 경우, 추가적인 피해를 예방하고 이미 발생한 피해를 복구하기 위해 누구에게 연락하여 어떤 도움을 받을 수 있는지 알려드립니다.</li>\r\n");
      out.write("                <li><i></i>그 무엇보다도, 개인정보와 관련하여 TRAVERY와 이용자간의 권리 및 의무 관계를 규정하여 이용자의 ‘개인정보자기결정권’을 보장하는 수단이 됩니다.</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t\t<hr> \r\n");
      out.write("\t\t\r\n");
      out.write("        <div id=\"pd2\" class=\"section\">\r\n");
      out.write("            <h4>2. 수집하는 개인정보</h4>\r\n");
      out.write("            <p><strong class=\"b\">이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 TRAVERY 서비스를 회원과 동일하게 이용할 수 있습니다. <br>\r\n");
      out.write("            이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, TRAVERY는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.</strong></p>\r\n");
      out.write("            <ul class=\"sec\">\r\n");
      out.write("                <li class=\"first\">\r\n");
      out.write("                    <p><strong>회원가입 시점에 TRAVERY가 이용자로부터 수집하는 개인정보는 아래와 같습니다.</strong></p>\r\n");
      out.write("                    <ul class=\"bu\">\r\n");
      out.write("                        <li><i></i>회원 가입 시에 ‘아이디, 비밀번호, 이름, 생년월일, 성별, 가입인증 휴대폰번호’를 필수항목으로 수집합니다. 만약 이용자가 입력하는 생년월일이 만14세 미만 아동일 경우에는 법정대리인 정보를 추가로 수집합니다. 그리고 선택항목으로 이메일 주소를 수집합니다.</li>\r\n");
      out.write("                        <li><i></i>단체아이디로 회원 가입 시에 단체아이디, 단체이름, 법인명(단체명), 대표자명, 대표 전화번호, 사업장 소재지, 관리자 아이디, 관리자 휴대폰번호를 필수항목으로 수집합니다.</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong><a href=\"#tgl2-1\" class=\"tgl_more\">회원 가입 시 수집하는 개인정보에 대한 추가 설명 <i class=\"sp ico_tgl\">내용 더보기/닫기</i></a></strong></p>\r\n");
      out.write("                    <dl class=\"tgl_cont\" id=\"tgl2-1\" style=\"display:block;\">\r\n");
      out.write("                        <dt>(1) 필수항목과 선택항목의 차이</dt>\r\n");
      out.write("                        <dd>필수항목이란 서비스의 본질적 기능을 수행하기 위해 필요한 정보이며, 선택항목이란 서비스 이용 자체에 영향을 미치지는 않으나 이용자에게 부가적인 가치를 제공하기 위해 추가로 수집하는 정보입니다.\r\n");
      out.write("                        회원가입 시에 수집하는 아이디, 비밀번호는 로그인을 위하여 필요한 정보이며 이름, 생년월일, 성별은 회원제 서비스 운영에 따르는 이용자 구분을 위하여 사용됩니다. 가입인증 휴대폰번호는 불법 광고 게시 등 부정한 목적으로 회원가입을 시도하는 경우, 이용제한 조치 등을 적용하기 위하여 수집합니다.\r\n");
      out.write("                        선택항목은 입력을 하지 않아도 회원 가입이나 서비스 이용에 제한이 없으며, 필요할 경우 ‘TRAVERY 내정보 &gt; 회원정보 &gt; 연락처’에서 사후에 언제든지 직접 입력하실 수 있습니다.</dd>\r\n");
      out.write("                        <dt>(2) 법정대리인 정보를 수집하는 이유</dt>\r\n");
      out.write("                        <dd>만 14세 미만 아동의 개인정보를 수집할 경우, 회사는 정보통신망법 제31조(법정대리인의 권리)에 따라 법정대리인(부모 등 아동의 보호자)의 동의를 받아야 합니다. 이에 따라 TRAVERY는 만 14세 미만 아동의 개인정보 수집 시점에서 법정대리인의 동의를 받고 있으며, 이 과정에서 법정대리인의 이름, DI, 휴대폰번호(모바일 인증 시에만)를 수집합니다. 수집된 법정대리인의 정보는 아동이 성년이 되는 시점에서 파기하고 있습니다.</dd>\r\n");
      out.write("                        <dt>(3) 단체정보의 개인정보 인정 여부</dt>\r\n");
      out.write("                        <dd>정보통신망법, 개인정보보호법 등에서 정의하는 개인정보는 ‘살아있는 자연인에 대한 정보’를 말합니다. 따라서 단체명, 영업소 주소 및 전화번호, 대표자 성명 등과 같은 법인이나 단체에 관한 정보는 원칙적으로 개인정보에 해당하지 않습니다.\r\n");
      out.write("                        TRAVERY 단체아이디로 회원 가입 시에 수집하는 대부분의 정보는 개인정보에 해당하지 않습니다. 하지만 개인 사업자 등의 경우 이를 단체정보로만 처리하기 모호한 측면이 있고, 관리자/담당자의 연락처 정보 등을 수집하기 때문에 본 개인정보취급방침에서는 단체정보의 수집 관련 내용을 기재하여 이용자의 이해를 돕고 있습니다.</dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다.</strong></p>\r\n");
      out.write("                    <p>TRAVERY 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게 ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를 받습니다.</p>\r\n");
      out.write("                    <div class=\"btn_area\">\r\n");
      out.write("                        <a href=\"privacy_agreement.html\" target=\"_blank\" class=\"sp btn2_1\" onclick=\"window.open('privacy_agreement.html','','width=880, height=780, scrollbars=yes, resizable=yes');return false;\">이용자 동의 후 개인정보를 추가 수집하는 경우</a>\r\n");
      out.write("                        <a href=\"https://nid.TRAVERY.com/user2/privacycenter/info.nhn?m=viewServiceMyInfoUseMain\" class=\"sp btn2_2\">‘개인정보 이용현황(TRAVERY 프라이버시 센터)’ 확인하기</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>서비스 이용 과정에서 IP 주소, 쿠키, 방문 일시·불량 이용 기록 등의 서비스 이용 기록, 기기정보가 생성되어 수집될 수 있습니다.</strong></p>\r\n");
      out.write("                    <p>구체적으로 1) 서비스 이용 과정에서 이용자에 관한 정보를 정보통신서비스 제공자가 자동화된 방법으로 생성하여 이를 저장(수집)하거나, 2) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환한 후에 수집하는 경우를 의미합니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong><a href=\"#tgl2-2\" class=\"tgl_more\">생성정보 수집에 대한 추가 설명 <i class=\"sp ico_tgl\">내용 더보기/닫기</i></a></strong></p>\r\n");
      out.write("                    <dl class=\"tgl_cont\" id=\"tgl2-2\" style=\"display:block;\">\r\n");
      out.write("                        <dt>IP(Internet Protocol) 주소란?</dt>\r\n");
      out.write("                        <dd>IP 주소는 인터넷 망 사업자가 인터넷에 접속하는 이용자의 PC 등 기기에 부여하는 온라인 주소정보 입니다. IP 주소가 개인정보에 해당하는지 여부에 대해서는 각국마다 매우 다양한 견해가 있습니다.</dd>\r\n");
      out.write("                        <dt>기기정보란?</dt>\r\n");
      out.write("                        <dd>본 개인정보취급방침에 기재된 기기정보는 생산 및 판매 과정에서 기기에 부여된 정보뿐 아니라, 기기의 구동을 위해 사용되는 S/W를 통해 확인 가능한 정보를 모두 일컫습니다. OS(Windows, MAC OS 등) 설치 과정에서 이용자가 PC에 부여하는 컴퓨터의 이름, PC에 장착된 주변기기의 일련번호, 스마트폰의 통신에 필요한 고유한 식별값(IMEI, IMSI) 등을 의미합니다. 단, TRAVERY는 기기의 고유한 식별값을 수집할 필요가 있는 경우, 이를 수집하기 전에 TRAVERY도 원래의 값을 알아볼 수 없는 방식으로 암호화 하여 식별성(Identifiability)을 제거한 후에 수집합니다.</dd>\r\n");
      out.write("                        <dt>쿠키(cookie)란?</dt>\r\n");
      out.write("                        <dd>쿠키는 이용자가 웹사이트를 접속할 때에 해당 웹사이트에서 이용자의 웹브라우저를 통해 이용자의 PC에 저장하는 매우 작은 크기의 텍스트 파일입니다. 이후 이용자가 다시 웹사이트를 방문할 경우 웹사이트 서버는 이용자 PC에 저장된 쿠키의 내용을 읽어 이용자가 설정한 서비스 이용 환경을 유지하여 편리한 인터넷 서비스 이용을 가능케 합니다. 또한 방문한 서비스 정보, 서비스 접속 시간 및 빈도, 서비스 이용 과정에서 생성된 또는 제공(입력)한 정보 등을 분석하여 이용자의 취향과 관심에 특화된 서비스(광고 포함)를 제공할 수 있습니다.\r\n");
      out.write("                        이용자는 쿠키에 대한 선택권을 가지고 있으며, 웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나, 쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의 저장을 거부할 수도 있습니다. 다만, 쿠키의 저장을 거부할 경우에는 로그인이 필요한 TRAVERY 일부 서비스의 이용에 불편이 있을 수 있습니다.<br>\r\n");
      out.write("                        </dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"last\">\r\n");
      out.write("                    <p><strong>TRAVERY는 아래의 방법을 통해 개인정보를 수집합니다.</strong></p>\r\n");
      out.write("                    <ul class=\"bu\">\r\n");
      out.write("                        <li><i></i>회원가입 및 서비스 이용 과정에서 이용자가 개인정보 수집에 대해 동의를 하고 직접 정보를 입력하는 경우, 해당 개인정보를 수집합니다.</li>\r\n");
      out.write("                        <li><i></i>고객센터를 통한 상담 과정에서 웹페이지, 메일, 팩스, 전화 등을 통해 이용자의 개인정보가 수집될 수 있습니다.</li>\r\n");
      out.write("                        <li><i></i>오프라인에서 진행되는 이벤트, 세미나 등에서 서면을 통해 개인정보가 수집될 수 있습니다.</li>\r\n");
      out.write("                        <li><i></i>TRAVERY와 제휴한 외부 기업이나 단체로부터 개인정보를 제공받을 수 있으며, 이러한 경우에는 정보통신망법에 따라 제휴사에서 이용자에게 개인정보 제공 동의 등을 받은 후에 TRAVERY에 제공합니다.</li>\r\n");
      out.write("                        <li><i></i>기기정보와 같은 생성정보는 PC웹, 모바일 웹/앱 이용 과정에서 자동으로 생성되어 수집될 수 있습니다.</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd3\" class=\"section\">\r\n");
      out.write("            <h4>3. 수집한 개인정보의 이용</h4>\r\n");
      out.write("            <ul class=\"sec\">\r\n");
      out.write("                <li class=\"first last\"><p><strong>TRAVERY는 회원관리, 서비스 개발·제공 및 향상, 안전한 인터넷 이용환경 구축 등 아래의 목적으로만 개인정보를 이용합니다.</strong></p>\r\n");
      out.write("                    <ul class=\"bu\">\r\n");
      out.write("                        <li><i></i>회원 가입 의사의 확인, 연령 확인 및 법정대리인 동의 진행, 이용자 및 법정대리인의 본인 확인, 이용자 식별, 회원탈퇴 의사의 확인 등 회원관리를 위하여 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>콘텐츠 등 기존 서비스 제공(광고 포함)에 더하여, 인구통계학적 분석, 서비스 방문 및 이용기록의 분석, 개인정보 및 관심에 기반한 이용자간 관계의 형성, 지인 및 관심사 등에 기반한 맞춤형 서비스 제공 등 신규 서비스 요소의 발굴 및 기존 서비스 개선 등을 위하여 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>법령 및 TRAVERY 이용약관을 위반하는 회원에 대한 이용 제한 조치, 부정 이용 행위를 포함하여 서비스의 원활한 운영에 지장을 주는 행위에 대한 방지 및 제재, 계정도용 및 부정거래 방지, 약관 개정 등의 고지사항 전달, 분쟁조정을 위한 기록 보존, 민원처리 등 이용자 보호 및 서비스 운영을 위하여 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>유료 서비스 제공에 따르는 본인인증, 구매 및 요금 결제, 상품 및 서비스의 배송을 위하여 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>이벤트 정보 및 참여기회 제공, 광고성 정보 제공 등 마케팅 및 프로모션 목적으로 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>서비스 이용기록과 접속 빈도 분석, 서비스 이용에 대한 통계, 서비스 분석 및 통계에 따른 맞춤 서비스 제공 및 광고 게재 등에 개인정보를 이용합니다.</li>\r\n");
      out.write("                        <li><i></i>보안, 프라이버시, 안전 측면에서 이용자가 안심하고 이용할 수 있는 서비스 이용환경 구축을 위해 개인정보를 이용합니다.</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t\t<hr>       \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd5\" class=\"section\">\r\n");
      out.write("            <h4>4. 개인정보의 파기</h4>\r\n");
      out.write("            <ul class=\"sec\">\r\n");
      out.write("                <li class=\"first\">\r\n");
      out.write("                    <p><strong>회사는 원칙적으로 이용자의 개인정보를 회원 탈퇴 시 지체없이 파기하고 있습니다.</strong></p>\r\n");
      out.write("                    <p>단, 이용자에게 개인정보 보관기간에 대해 별도의 동의를 얻은 경우, 또는 법령에서 일정 기간 정보보관 의무를 부과하는 경우에는 해당 기간 동안 개인정보를 안전하게 보관합니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>이용자에게 개인정보 보관기간에 대해 별도의 동의를 얻은 경우는 아래와 같습니다.</strong></p>\r\n");
      out.write("                    <p>부정가입 및 징계기록 등의 부정이용기록은 부정 가입 및 이용 방지를 위하여 수집 시점으로부터 6개월간 보관하고 파기하고 있습니다. 부정이용기록 내 개인정보는 가입인증 휴대폰 번호(만 14세 미만 회원의 경우 법정대리인 DI)가 있습니다. <br>\r\n");
      out.write("                    결제도용, 카드깡 등 관련 법령 및 이용약관을 위반하는 TRAVERY페이의 부정거래기록(아이디, 이름, 휴대폰번호, 배송지 주소, IP주소, 쿠키, 기기정보)은 부정거래 방지 및 다른 선량한 이용자의 보호, 안전한 거래 환경 보장을 위하여 수집 시점으로부터 3년간 보관하고 파기합니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>전자상거래 등에서의 소비자 보호에 관한 법률, 전자금융거래법, 통신비밀보호법 등 법령에서 일정기간 정보의 보관을 규정하는 경우는 아래와 같습니다. TRAVERY는 이 기간 동안 법령의 규정에 따라 개인정보를 보관하며, 본 정보를 다른 목적으로는 절대 이용하지 않습니다.</strong></p>\r\n");
      out.write("                    <dl class=\"bu\">\r\n");
      out.write("                        <dt><i></i>전자상거래 등에서 소비자 보호에 관한 법률</dt>\r\n");
      out.write("                        <dd>계약 또는 청약철회 등에 관한 기록: 5년 보관</dd>\r\n");
      out.write("                        <dd>대금결제 및 재화 등의 공급에 관한 기록: 5년 보관</dd>\r\n");
      out.write("                        <dd>소비자의 불만 또는 분쟁처리에 관한 기록: 3년 보관</dd>\r\n");
      out.write("                        <dt><i></i>전자금융거래법</dt>\r\n");
      out.write("                        <dd>전자금융에 관한 기록: 5년 보관</dd>\r\n");
      out.write("                        <dt><i></i>통신비밀보호법</dt>\r\n");
      out.write("                        <dd>로그인 기록: 3개월</dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"last\">\r\n");
      out.write("                    <p><strong>회원탈퇴, 서비스 종료, 이용자에게 동의받은 개인정보 보유기간의 도래와 같이 개인정보의 수집 및 이용목적이 달성된 개인정보는 재생이 불가능한 방법으로 파기하고 있습니다. <br>\r\n");
      out.write("                    법령에서 보존의무를 부과한 정보에 대해서도 해당 기간 경과 후 지체없이 재생이 불가능한 방법으로 파기합니다.</strong></p>\r\n");
      out.write("                    <p>전자적 파일 형태의 경우 복구 및 재생이 되지 않도록 기술적인 방법을 이용하여 안전하게 삭제하며, 출력물 등은 분쇄하거나 소각하는 방식 등으로 파기합니다.</p>\r\n");
      out.write("                    <p><strong>참고로 TRAVERY는 ‘개인정보 유효기간제’에 따라 1년간 서비스를 이용하지 않은 회원의 개인정보를 별도로 분리 보관하여 관리하고 있습니다.</strong></p>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd6\" class=\"section\">\r\n");
      out.write("            <h4>5. 이용자 및 법정대리인의 권리와 행사 방법</h4>\r\n");
      out.write("            <ul class=\"bu\">\r\n");
      out.write("                <li><i></i>이용자는 언제든지 ‘<a href=\"https://nid.TRAVERY.com/user2/help/changeUserInfo.nhn?lang=&amp;menu=nid\">TRAVERY 내정보 &gt; 회원정보</a>’에서 자신의 개인정보를 조회하거나 수정할 수 있습니다.</li>\r\n");
      out.write("                <li><i></i>이용자는 언제든지 ‘<a href=\"https://nid.TRAVERY.com/user2/help/leaveId.nhn?menu=nid&amp;lang=ko_KR\">회원탈퇴</a>’ 등을 통해 개인정보의 수집 및 이용 동의를 철회할 수 있습니다.</li>\r\n");
      out.write("                <li><i></i>만 14세 미만 아동의 경우, 법정대리인이 아동의 개인정보를 조회하거나 수정할 권리, 수집 및 이용 동의를 철회할 권리를 가집니다.</li>\r\n");
      out.write("                <li><i></i>이용자가 개인정보의 오류에 대한 정정을 요청한 경우, 정정을 완료하기 전까지 해당 개인정보를 이용 또는 제공하지 않습니다. 또한 잘못된 개인정보를 제3자에게 이미 제공한 경우에는 정정 처리결과를 제3자에게 지체 없이 통지하여 정정이 이루어지도록 하겠습니다.</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd7\" class=\"section\">\r\n");
      out.write("            <h4>6. 개인정보보호를 위한 TRAVERY의 노력</h4>\r\n");
      out.write("            <ul class=\"sec\">\r\n");
      out.write("                <li class=\"first\">\r\n");
      out.write("                    <p><strong>TRAVERY는 이용자의 개인정보를 안전하게 관리하기 위하여 최선을 다하며, 정보통신망법 및 개인정보보호법에서 요구하는 수준 이상으로 개인정보를 보호하고 있습니다.</strong></p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>개인정보를 암호화하고 있습니다.</strong></p>\r\n");
      out.write("                    <p>법령에서 암호화를 요구하고 있는 비밀번호, 고유식별정보, 계좌번호 및 카드번호 외에 이메일 주소와 휴대폰 번호 등을 추가로 암호화 하여 보관하고 있습니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>대내외의 보안 위협으로부터 개인정보를 안전하게 관리합니다.</strong></p>\r\n");
      out.write("                    <p>해킹이나 컴퓨터 바이러스 등에 의해 회원의 개인정보가 유출되거나 훼손되는 것을 막기 위해 외부로부터 접근이 통제된 구역에 시스템을 설치하고 있습니다. 개인정보의 훼손에 대비해서 자료를 수시로 백업하고 있고, 최신 백신프로그램을 이용하여 이용자들의 개인정보나 자료가 누출되거나 손상되지 않도록 방지하고 있습니다. 암호화 통신 등을 통하여 네트워크상에서 개인정보를 안전하게 송수신하고 있습니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>개인정보취급자를 최소한으로 유지하고 있습니다.</strong></p>\r\n");
      out.write("                    <p>개인정보를 취급하는 직원을 최소한으로 관리하며, 개인정보처리시스템에서 개인정보의 다운로드가 가능한 직원들의 업무용 PC에 대해 외부 인터넷망과 내부망을 분리하여 개인정보 유출 가능성을 줄이고 있습니다. 또한 개인정보취급자에 대한 정기 교육, 전사 임직원에 대한 수시 교육 및 캠페인을 통하여 회원 개인정보 보호가 TRAVERY의 가장 중요한 가치임을 끊임없이 강조하고 있습니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <p><strong>개인정보보호 전담 조직을 운영하고 있습니다.</strong></p>\r\n");
      out.write("                    <p>TRAVERY는 국내 기업 중 최초로 2007년에 고객정보보호팀을 만든 바 있습니다. 현재도 개인정보보호팀 및 상위 부서인 정보보호실에서 전사 임직원이 이용자 개인정보 보호 의무를 올바르게 준수할 수 있도록 기술적/관리적 보호조치를 상시 수행하고 있습니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("                \r\n");
      out.write("                <li class=\"last\">\r\n");
      out.write("                    <p><strong>TRAVERY는 이용자 정보보호 활동에 대해 국내외 인증기관으로부터 검증을 받습니다.</strong></p>\r\n");
      out.write("                    <p>국제 정보보호 인증인 ISO/IEC 27001:2013, 국내 정보보호 인증인 PIMS·ISMS를 통해 외부 기관으로부터 정기적으로 TRAVERY 정보보호 활동에 대해 검증을 받고 있습니다. 또한 미국 공인회계사협회의 감사 기준에 따라 내부 서비스 통제 수준을 검증받고, 그 결과를 SOC 리포트로 발간하고 있습니다.</p>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd8\" class=\"section\">\r\n");
      out.write("            <h4>7. 개인정보 관리책임자 및 담당자 안내</h4>\r\n");
      out.write("            <p>TRAVERY는 이용자의 개인정보 관련 문의사항 및 불만 처리 등을 위하여 아래와 같이 개인정보 관리 책임자 및 담당자를 지정하고 있습니다.</p>\r\n");
      out.write("            <div class=\"contact\">\r\n");
      out.write("                <dl>\r\n");
      out.write("                    <dt>개인정보 관리책임자</dt>\r\n");
      out.write("                    <dd>이 름 : 유병훈</dd>\r\n");
      out.write("                    <dd>소 속 : kt ds</dd>\r\n");
      out.write("                    <dd>직 위 : 교육생</dd>\r\n");
      out.write("                    <dd class=\"em\">메 일 : <a href=\"mailto:yoogo37@gmail.com\">yoogo37@gmail.com</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("                <dl>\r\n");
      out.write("                    <!-- <dt>개인정보 관리담당자</dt>\r\n");
      out.write("                    <dd>이 름 : 이진규</dd>\r\n");
      out.write("                    <dd>소 속 : 개인정보보호팀</dd>\r\n");
      out.write("                    <dd>직 위 : 팀장</dd>\r\n");
      out.write("                    <dd class=\"tel\">전 화 : 1588-3820</dd>\r\n");
      out.write("                    <dd class=\"em\">메 일 : <a href=\"mailto:privacy@TRAVERY.com\">privacy@TRAVERY.com</a></dd> -->\r\n");
      out.write("                </dl>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p>기타 개인정보 침해에 대한 신고나 상담이 필요한 경우에 아래 기관에 문의 가능합니다.</p>\r\n");
      out.write("            <ul class=\"bu\">\r\n");
      out.write("                <li><i></i>개인정보침해신고센터 (<a href=\"http://privacy.kisa.or.kr\">privacy.kisa.or.kr</a> / 국번없이 118)</li>\r\n");
      out.write("                <li><i></i>대검찰청 사이버수사과 (<a href=\"http://www.spo.go.kr\">www.spo.go.kr</a> / 국번없이 1301)</li>\r\n");
      out.write("                <li><i></i>경찰청 사이버안전국 (<a href=\"http://www.ctrc.go.kr\">www.ctrc.go.kr</a> / 국번없이 182)</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd9\" class=\"section\">\r\n");
      out.write("            <h4>8. 본 개인정보취급방침의 적용 범위</h4>\r\n");
      out.write("            <ul class=\"bu\">\r\n");
      out.write("                <li><i></i>본 개인정보취급방침은 회사의 브랜드 중 하나인 ‘TRAVERY 서비스(<a href=\"/\">http://localhost:8080/</a>)’에 적용되며, 다른 브랜드로 제공되는 서비스에 대해서는 별개의 개인정보취급방침이 적용될 수 있습니다.</li>\r\n");
      out.write("                <li><i></i>TRAVERY에 링크되어 있는 다른 회사의 웹사이트에서 개인정보를 수집하는 경우, 이용자 동의 하에 개인정보가 제공된 이후에는 본 개인정보취급방침이 적용되지 않습니다.</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <hr> \r\n");
      out.write("\r\n");
      out.write("        <div id=\"pd10\" class=\"section\">\r\n");
      out.write("            <h4>9. 개정 전 고지 의무</h4>\r\n");
      out.write("            <p>본 개인정보취급방침의 내용 추가, 삭제 및 수정이 있을 경우 개정 최소 7일 전에 ‘공지사항’을 통해 사전 공지를 할 것입니다. <br>\r\n");
      out.write("            다만, 수집하는 개인정보의 항목, 이용목적의 변경 등과 같이 이용자 권리의 중대한 변경이 발생할 때에는 최소 30일 전에 공지하며, 필요 시 이용자 동의를 다시 받을 수도 있습니다.</p>\r\n");
      out.write("            <ul class=\"bu\">\r\n");
      out.write("                <li><i></i>공고일자: 2016년 3월 29일</li>\r\n");
      out.write("                <li><i></i>시행일자: 2016년 4월 8일</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t<div id=\"gotop\" class=\"gotop\">\r\n");
      out.write("\t<a href=\"javascript:scrollTo(0, 0);\">top</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
