/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-23 07:02:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newPlace_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1456288816000L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/Documents/MUCO/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Travery/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
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

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("      html, body {\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("      }\r\n");
      out.write("      #map_canvas {\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        width: 800px; \r\n");
      out.write("        height: 600px;\r\n");
      out.write("      }\r\n");
      out.write("      .controls {\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("        border: 1px solid transparent;\r\n");
      out.write("        border-radius: 2px 0 0 2px;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("        -moz-box-sizing: border-box;\r\n");
      out.write("        height: 32px;\r\n");
      out.write("        outline: none;\r\n");
      out.write("        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #pac-input {\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        font-family: Roboto;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        font-weight: 300;\r\n");
      out.write("        margin-left: 12px;\r\n");
      out.write("        /* margin-top:570px; */\r\n");
      out.write("        padding: 0 11px 0 13px;\r\n");
      out.write("        text-overflow: ellipsis;\r\n");
      out.write("        width: 300px;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #pac-input:focus {\r\n");
      out.write("        border-color: #4d90fe;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .pac-container {\r\n");
      out.write("        font-family: Roboto;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #type-selector {\r\n");
      out.write("        color: #fff;\r\n");
      out.write("        background-color: #4d90fe;\r\n");
      out.write("        padding: 5px 11px 0px 11px;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #type-selector label {\r\n");
      out.write("        font-family: Roboto;\r\n");
      out.write("        font-size: 13px;\r\n");
      out.write("        font-weight: 300;\r\n");
      out.write("      }\r\n");
      out.write("      #target {\r\n");
      out.write("        width: 345px;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resource/css/main.css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Travery</title>\r\n");
      out.write("<script type=\"text/javascript\"\tsrc=\"/Travery/resource/js/jquery-1.12.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#addNewPlace\").click(function() {\r\n");
      out.write("\t\t\tvar form = $(\"#addNewPlaceForm\");\r\n");
      out.write("\t\t\tform.attr(\"method\", \"post\");\r\n");
      out.write("\t\t\tform.attr(\"action\", \"/Travery/addNewPlace\");\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("  src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDuLfX3hC4iBa4XL588g7cB2OCHhPpjuy8&libraries=geometry,places\">\r\n");
      out.write("</script>\r\n");
      out.write("<!-- <script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://maps.google.com/maps/api/js?sensor=false\"></script> -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready( function() {\r\n");
      out.write("\t\tvar latlng = new google.maps.LatLng(37.566666, 126.966667); //위도 , 경도 (원하는 위치를 기본으로 지정가능);\r\n");
      out.write("\t\tvar myOptions = {\r\n");
      out.write("\t\t\t\t\t\t\tzoom : 4,\r\n");
      out.write("\t\t\t\t\t\t\tcenter : latlng,\r\n");
      out.write("\t\t\t\t\t\t\tmapTypeControl:true,\r\n");
      out.write("\t\t\t\t\t\t\t  mapTypeControlOptions: {\r\n");
      out.write("\t\t\t\t\t\t\t      style:google.maps.MapTypeControlStyle.DROPDOWN_MENU\r\n");
      out.write("\t\t\t\t\t\t\t    },\r\n");
      out.write("\t\t\t\t\t\t\tmapTypeId : google.maps.MapTypeId.ROADMAP\r\n");
      out.write("\t\t\t\t\t\t} // 변수 myoptions에 맵 생성시에 필요한 원하는 기능을 지정 / zoom 1 = 세계지도단위 / 15 = 지도 300m단위 / center = 위도경도를 기준으로 기준점잡기 / mapTypeId 4종류의 맵 타입중 하나 지정\r\n");
      out.write("\t\tvar map = new google.maps.Map(document.getElementById(\"map_canvas\"), myOptions); // 맵생성시 필요한 변수\r\n");
      out.write("\t\tvar marker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\tposition : latlng,\r\n");
      out.write("\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t}); // 마커기능 /  포지션에 위도 경도가 있어야 지정가능 / (포지션 : 위도경도) 에서 맵에서 맵으로 마커를 지정한다는 부분 default로 있어야함\r\n");
      out.write("\r\n");
      out.write("\t\t // Create the search box and link it to the UI element.\r\n");
      out.write("\t\tvar input = document.getElementById('pac-input');\r\n");
      out.write("\t\tvar searchBox = new google.maps.places.SearchBox(input);\r\n");
      out.write("\t\tmap.controls[google.maps.ControlPosition.TOP_LEFT].push(input);\r\n");
      out.write("\r\n");
      out.write("\t\t// Bias the SearchBox results towards current map's viewport.\r\n");
      out.write("\t\tmap.addListener('bounds_changed', function() {\r\n");
      out.write("\t\t\tsearchBox.setBounds(map.getBounds());\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t// Listen for the event fired when the user selects a prediction and retrieve\r\n");
      out.write("\t\t// more details for that place.\r\n");
      out.write("\t\tsearchBox.addListener('places_changed', function() {\r\n");
      out.write("\t\t\tvar places = searchBox.getPlaces();\r\n");
      out.write("\t\t    if (places.length == 0) {\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t// For each place, get the icon, name and location.\r\n");
      out.write("\t\tvar bounds = new google.maps.LatLngBounds();\r\n");
      out.write("\t\tplaces.forEach(function(place) {\r\n");
      out.write("\t\t\tvar icon = {\r\n");
      out.write("\t\t\t\t\t\t\turl: place.icon,\r\n");
      out.write("\t\t\t\t\t\t\tsize: new google.maps.Size(71, 71),\r\n");
      out.write("\t\t\t\t\t\t\torigin: new google.maps.Point(0, 0),\r\n");
      out.write("\t\t\t\t\t\t \tanchor: new google.maps.Point(17, 34),\r\n");
      out.write("\t\t\t\t\t\t\tscaledSize: new google.maps.Size(25, 25)\r\n");
      out.write("\t\t\t\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (place.geometry.viewport) {\r\n");
      out.write("\t\t\t\t// Only geocodes have viewport.\r\n");
      out.write("\t\t\t\tbounds.union(place.geometry.viewport);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tbounds.extend(place.geometry.location);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\tmap.fitBounds(bounds);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\tvar geocoder = new google.maps.Geocoder(); // 위도, 경도를 이용한 전환으로 어드레스 를 불러올 떄 필요\r\n");
      out.write("\t\t// addListener 는 자바스크립트의 이벤트 핸들러를 정의한 것으로 특정 이벤트가 발생했을 때 등록,불러오기,전달 등을 실행 한다.\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tgoogle.maps.event.addListener(\tmap, 'click', function(event) {\r\n");
      out.write("\t\t\tvar location = event.latLng;\r\n");
      out.write("\t\t\tgeocoder.geocode({\t'latLng' : location\t},\tfunction( results, status ) {\r\n");
      out.write("\t\t\t\tif (status == google.maps.GeocoderStatus.OK) {\r\n");
      out.write("\t\t\t\t\t$('#address').val(\tresults[0].formatted_address);\r\n");
      out.write("\t\t\t\t\t$('#lat').val(\tresults[0].geometry.location.lat());\r\n");
      out.write("\t\t\t\t\t$('#lng').val(\tresults[0].geometry.location.lng());\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"Geocoder Failed Due to : \" + status );\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}); // 맵에서 클릭을 실행했을 때 기능이 실행이되고, 위도경도를 기점으로 옳바른 위도경도를 받았을때 상태와 결과를 어드레스,위도,경도 로 각각 값으로 전달한다. 틀렸을 시에 값을 못받았다는 내용을 경고문 출력.\r\n");
      out.write("\t\t\t\t\t// formatted_address : String 형태의 사람이 읽는 주소값 / geometry.location.lat() : -90,90 / geometry.location.lng() : -180, 180\r\n");
      out.write("\t\t\t\tif (!marker) {\r\n");
      out.write("\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\tposition : location,\r\n");
      out.write("\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tmarker.setMap(null);\r\n");
      out.write("\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\tposition : location,\r\n");
      out.write("\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tmap.setCenter(location);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#lat\").focusout(\tfunction() {\r\n");
      out.write("\t\t\tvar lat = $(this).val();\r\n");
      out.write("\t\t\tif (lat != '') {\r\n");
      out.write("\t\t\t\tgeocoder.geocode({\t'lat' : lat\t}, function( results, status ) {\r\n");
      out.write("\t\t\t\t\tif (status == google.maps.GeocoderStatus.OK) {\r\n");
      out.write("\t\t\t\t\t\t$('#lat').html(results[0].geometry.location.lat());\r\n");
      out.write("\t\t\t\t\t\tmap.setCenter(results[0].geometry.location);\r\n");
      out.write("\t\t\t\t\t\tif (!marker) {\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tmarker.setMap(null);\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\talert(\"Geocoder Failed Due To : \" + status );\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lat에 출력해주는 부분\r\n");
      out.write("\t\t$(\"#lng\").focusout(\tfunction() {\r\n");
      out.write("\t\t\tvar lng = $(this).val();\r\n");
      out.write("\t\t\tif (lng != '') {\r\n");
      out.write("\t\t\t\tgeocoder.geocode({'lng' : lng }, function( results, status ) {\r\n");
      out.write("\t\t\t\t\tif (status == google.maps.GeocoderStatus.OK) {\r\n");
      out.write("\t\t\t\t\t\t$('#lng').html(results[0].geometry.location.lng());\r\n");
      out.write("\t\t\t\t\t\tmap.setCenter(results[0].geometry.location);\r\n");
      out.write("\t\t\t\t\t\tif (!marker) {\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tmarker.setMap(null);\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\talert(\"Geocoder Failed Due To : \" + status );\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #lng에 출력해주는 부분\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#address\").focusout(\tfunction() {\r\n");
      out.write("\t\t\tvar address = $(this).val();\r\n");
      out.write("\t\t\tif (address != '') {\r\n");
      out.write("\t\t\t\tgeocoder.geocode({ 'address' : address }, function( results, status ) {\r\n");
      out.write("\t\t\t\t\tif (status == google.maps.GeocoderStatus.OK) {\r\n");
      out.write("\t\t\t\t\t\t$('#lat').html(results[0].geometry.location.lat());\r\n");
      out.write("\t\t\t\t\t\t$('#lng').html(results[0].geometry.location.lng());\r\n");
      out.write("\t\t\t\t\t\tmap.setCenter(results[0].geometry.location);\r\n");
      out.write("\t\t\t\t\t\tif (!marker) {\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tmarker.setMap(null);\r\n");
      out.write("\t\t\t\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t\t\t\tposition : results[0].geometry.location,\r\n");
      out.write("\t\t\t\t\t\t\t\tmap : map\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\talert(\"Geocoder Failed Due To : \" + status );\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); // addListener를 통한 결과 값을 위도 정보를 text형태로 #address에 출력해주는 부분\r\n");
      out.write("\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\tNew Place\r\n");
      out.write("\t\r\n");
      out.write("\t<input id=\"pac-input\" class=\"controls\" type=\"text\" placeholder=\"Search Box\" />\r\n");
      out.write("\t<form id=\"addNewPlaceForm\">\r\n");
      out.write("\t\t<table border=\"1\" align=\"right\" id=\"SelectMap\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><div id=\"map_canvas\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"100\">위도</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"lat\" name=\"lat\" value=\"\" size=\"50\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"100\">경도</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"lng\" name=\"lng\" value=\"\" size=\"50\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"100\">주소</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"address\" name=\"address\" size=\"50\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div style=\"float: right;\">\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"addNewPlace\" value=\"submit\" /></div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
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
}
