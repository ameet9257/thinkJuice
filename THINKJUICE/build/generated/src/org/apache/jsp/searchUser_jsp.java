package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Search Customer</title>\n");
      out.write("  \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function searchUser(){\n");
      out.write("                    var contact = document.getElementById('TextContact').value;\n");
      out.write("                    if(contact === null || contact === \"\"){\n");
      out.write("                        alert('Please Enter Customer Contact');\n");
      out.write("                    }else{ var xhttp = new XMLHttpRequest();\n");
      out.write("                        xhttp.onreadystatechange = function() {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            document.getElementById(\"userData\").innerHTML = this.responseText;\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                    xhttp.open(\"POST\",\"userSearch?getContact=\"+contact,true);\n");
      out.write("                    xhttp.send();\n");
      out.write("                    }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function goEdit(getId){\n");
      out.write("                            alert(\"Get ID \"+getId);\n");
      out.write("                            var link = \"index.jsp?getUID=\"+getId;\n");
      out.write("                            window.open(link,\"_self\");\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("            function goOrder(getId){\n");
      out.write("                            alert(\"Get ID \"+getId);\n");
      out.write("                            var link = \"index.jsp?getUID=\"+getId;\n");
      out.write("                            window.open(link,\"_self\");\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \n");
      out.write("        <div class=\"container-fluid\" style=\"margin-left: 30px;\">\n");
      out.write("                    <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark fixed-top\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"index.jsp\">Think Juice</a>\n");
      out.write("                        <ul class=\"navbar-nav\">\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"CustomerDetail.jsp\">Customer Detail</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"OrderDetail.jsp\">Order Detail</a>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"OrderItemDetail.jsp\">Order Item Detail</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"SendOffer.jsp\">Send Offer</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"searchUser.jsp\">Search Customer</a>\n");
      out.write("                                </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("        </div><BR><br><br>\n");
      out.write("        \n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>Think Juice</h1>\n");
      out.write("                <label for=\"sel1\" style=\"margin-top: 20px;display: inline;\">Enter Customer Contact</label>\n");
      out.write("                \n");
      out.write("                <input type=\"text\" class=\"form-control col-2\" id=\"TextContact\" style=\"display: inline;margin-left: 20px\"  placeholder=\"Enter Conact Number\" name=\"textContact\">\n");
      out.write("                \n");
      out.write("                <button type=\"button\" class=\"btn btn-primary col-2\" onclick=\"searchUser()\"  style=\"margin-left: 20px\">Search</button>\n");
      out.write("        \n");
      out.write("\n");
      out.write("                <p id=\"demo\"></p>\n");
      out.write("                <div id=\"userData\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
