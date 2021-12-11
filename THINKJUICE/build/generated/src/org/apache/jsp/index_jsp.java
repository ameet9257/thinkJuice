package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var_dataSource;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_setDataSource_var_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_sql_setDataSource_var_url_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_sql_query_var_dataSource.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("        <title>Think Juice Take Order</title>\n");
      out.write("    \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("                window.onload = function() { \n");
      out.write("                    setName();\n");
      out.write("                };\n");
      out.write("            \n");
      out.write("                    function chg(){\n");
      out.write("                        var cat_id = document.getElementById('cat_value').value;\n");
      out.write("                        var xhttp = new XMLHttpRequest();\n");
      out.write("                        xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                                document.getElementById('item_option').innerHTML=xhttp.responseText;\n");
      out.write("                                document.getElementById('TextPrice').value = \"\";\n");
      out.write("                                document.getElementById('TextQty').value = \"\";\n");
      out.write("                                }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"itemData?catData=\"+cat_id,true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("                    function setPrice(){\n");
      out.write("                            var item_id = document.getElementById('item_option').value;\n");
      out.write("                            var xhttp = new XMLHttpRequest();\n");
      out.write("                            xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                document.getElementById('TextPrice').value=xhttp.responseText;\n");
      out.write("                                }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"getPrice?item_id=\"+item_id,true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    function setOrder(){\n");
      out.write("                            var cat_id = document.getElementById('cat_value').value;\n");
      out.write("                            var item_id = document.getElementById('item_option').value;\n");
      out.write("                            var price = \"\";\n");
      out.write("                            var qty = document.getElementById('TextQty').value;\n");
      out.write("                            var getName = document.getElementById('TextName').value;\n");
      out.write("                            var getContact = document.getElementById('TextContact').value;\n");
      out.write("                            \n");
      out.write("                            var phoneno = /^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$/;\n");
      out.write("                            \n");
      out.write("                            var status = \"True\";\n");
      out.write("                            \n");
      out.write("                           if(getName === null || getContact === null || getName === \"\" || getContact===\"\"){\n");
      out.write("                                    status = \"False\";\n");
      out.write("                                    alert(\"Please Enter Customer Detail\");\n");
      out.write("                                   \n");
      out.write("                            }\n");
      out.write("                           else if(item_id === \"0\" || cat_id === \"0\" || price === null){\n");
      out.write("                                    status = \"False\";\n");
      out.write("                                    alert(\"Please Select Product Category and Product Item\");\n");
      out.write("                            }\n");
      out.write("                           else if(qty === null || qty === \"\"){\n");
      out.write("                                status = \"False\";\n");
      out.write("                                alert(\"Enter Quantity\");\n");
      out.write("                            }else if(!phoneno.test(getContact)){\n");
      out.write("                                status = \"False\";\n");
      out.write("                                alert(\"Invalid Contact Number\");\n");
      out.write("                            }\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                           \n");
      out.write("                            if(status === \"True\"){\n");
      out.write("                                    var xhttp = new XMLHttpRequest();\n");
      out.write("                                    xhttp.onreadystatechange = function(){\n");
      out.write("                                    if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                                        document.getElementById('orderDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                        \n");
      out.write("                                }\n");
      out.write("                                };\n");
      out.write("            \n");
      out.write("            xhttp.open(\"POST\",\"cartTable?getName=\"+getName+\"&getContact=\"+getContact+\"&cat_id=\"+cat_id+\"&item_id=\"+item_id+\"&qty=\"+qty,true);\n");
      out.write("                                xhttp.send();\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    function emptyCart(){\n");
      out.write("                            var xhttp = new XMLHttpRequest();\n");
      out.write("                            xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"deleteCart\",true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    function showCart(){\n");
      out.write("                            var xhttp = new XMLHttpRequest();\n");
      out.write("                            xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;\n");
      out.write("                                }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"showCart\",true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    function getCartId(cartId){\n");
      out.write("                           var id = cartId;\n");
      out.write("                            var xhttp = new XMLHttpRequest();\n");
      out.write("                            xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"removeItem?getID=\"+id,true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    ");
 
                    int id = 0;
                    String getUserName = "";
                    String getUserContact = "";
                     try{   
                        String getUid = "";
                        getUid = request.getParameter("getUID");
                        if(getUid == null){
                        getUid = "";
                        id=0;
                        }else{
                            id = Integer.parseInt(getUid);
                            Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                            Statement st = con.createStatement();
                            String query = "select user_name,user_contact from User_Details where user_id = '"+id+"'";
                            ResultSet rs = st.executeQuery(query);
                            if(rs.next()){
                            getUserName = rs.getString(1);
                            getUserContact = rs.getString(2);
                            }
                    }
                }catch(Exception ex){
                         out.print(ex.getMessage());
                     }
                            
                            
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    function setName(){\n");
      out.write("                            var ids = \"");
      out.print(id );
      out.write("\";\n");
      out.write("                            var a = \"");
      out.print(getUserName);
      out.write("\";\n");
      out.write("                            var b = \"");
      out.print(getUserContact);
      out.write("\";\n");
      out.write("                            if(ids > 0){\n");
      out.write("                                //alert(ids+a+b);\n");
      out.write("                                document.getElementById('TextName').value=a;\n");
      out.write("                                document.getElementById('TextContact').value=b;\n");
      out.write("                                }\n");
      out.write("                        }\n");
      out.write("                    \n");
      out.write("                    function getName(){\n");
      out.write("                        var cont = \"\"; \n");
      out.write("                        cont = document.getElementById('TextContact').value;\n");
      out.write("                            var xhttp = new XMLHttpRequest();\n");
      out.write("                            xhttp.onreadystatechange = function(){\n");
      out.write("                            if(xhttp.readyState===4 && xhttp.status===200){\n");
      out.write("                                if(xhttp.responseText !== \"not\"){\n");
      out.write("                                    document.getElementById(\"TextName\").disabled = true;   \n");
      out.write("                                    document.getElementById('TextName').value=xhttp.responseText;\n");
      out.write("                                }else{\n");
      out.write("                                    document.getElementById(\"TextName\").disabled = false;   \n");
      out.write("                                    document.getElementById('TextName').value=\"\";        \n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        xhttp.open(\"POST\",\"getName?contact=\"+cont,true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    function contact(){\n");
      out.write("                        document.getElementById(\"TextName\").disabled = false;   \n");
      out.write("                        document.getElementById('TextName').value=\"\";        \n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("        </head>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("       ");
      if (_jspx_meth_sql_setDataSource_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      if (_jspx_meth_sql_query_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            ");
      //  sql:query
      org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_1 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
      _jspx_th_sql_query_1.setPageContext(_jspx_page_context);
      _jspx_th_sql_query_1.setParent(null);
      _jspx_th_sql_query_1.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sqlDataSource}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_sql_query_1.setVar("getUserDeatail");
      int[] _jspx_push_body_count_sql_query_1 = new int[] { 0 };
      try {
        int _jspx_eval_sql_query_1 = _jspx_th_sql_query_1.doStartTag();
        if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_push_body_count_sql_query_1[0]++;
            _jspx_th_sql_query_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_sql_query_1.doInitBody();
          }
          do {
            out.write("\n");
            out.write("                select user_name,user_contact from User_Details where user_id = \"");
            out.print(id);
            out.write("\"\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_sql_query_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
            _jspx_push_body_count_sql_query_1[0]--;
        }
        if (_jspx_th_sql_query_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sql_query_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sql_query_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sql_query_1.doFinally();
        _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_1);
      }
      out.write("    \n");
      out.write("\n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("         \n");
      out.write("                <div class=\"container-fluid\" style=\"margin-left: 30px;\">\n");
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
      out.write("                                \n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"searchUser.jsp\">Search Customer</a>\n");
      out.write("                                </li>\n");
      out.write("                                \n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"Analyse.jsp\">Report</a>\n");
      out.write("                                </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("            <h1>Think Juice</h1>\n");
      out.write("                \n");
      out.write("            <form method=\"post\" action=\"cartDetail.jsp\">\n");
      out.write("                <h4 style=\"margin-top: 20px\">Customer Detail</h4>\n");
      out.write("               \n");
      out.write("                <label for=\"labelContact\" style=\"margin-top: 20px;display: inline;\">Enter Customer Contact :</label>\n");
      out.write("                <input type=\"text\" class=\"form-control col-2\" id=\"TextContact\" onclick=\"contact()\" style=\"display: inline;margin-left: 20px\"  placeholder=\"Customer Contact\" name=\"textContact\">\n");
      out.write("            \n");
      out.write("                \n");
      out.write("                <label for=\"labelName\" style=\"margin-top: 20px; display: inline;margin-left: 30px\">Enter Customer Name :</label>\n");
      out.write("                <input type=\"text\" style=\"display: inline;margin-left: 20px\" disabled=\"disabled\" onfocus=\"getName()\" class=\"form-control col-2\" id=\"TextName\" placeholder=\"Customer Name\" name=\"textName\">\n");
      out.write("                \n");
      out.write("                <h4 style=\"margin-top: 20px\">Product Detail</h4>\n");
      out.write("                <label for=\"sel1\">Select Category</label>\n");
      out.write("                 \n");
      out.write("                <select class=\"form-control col-3\" style=\"display: inline;margin-left: 20px;\" id=\"cat_value\" onchange=\"chg()\">\n");
      out.write("                     <option selected value=\"0\">----Select Category----</option>\n");
      out.write("                   ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("                 </select>\n");
      out.write("                \n");
      out.write("                <label for=\"sel1\" style=\"margin-top: 20px;display: inline;margin-left: 30px;\" >Select Item</label>\n");
      out.write("                <select class=\"form-control col-3\" onchange=\"setPrice()\" id=\"item_option\" style=\"display: inline;margin-left: 20px;\">\n");
      out.write("                    <option selected value=\"0\">----Select Item----</option>\n");
      out.write("                </select> \n");
      out.write("                 \n");
      out.write("                <br><br>\n");
      out.write("                <label for=\"sel1\" style=\"margin-top: 20px;display: inline;\" >Price</label>\n");
      out.write("                <input type=\"text\" class=\"form-control col-2\" disabled=\"disabled\" id=\"TextPrice\" style=\"display: inline;margin-left: 20px\"  placeholder=\"Price\" name=\"textPrice\">\n");
      out.write("               \n");
      out.write("                <label for=\"sel1\" style=\"margin-top: 20px;display: inline;margin-left: 30px;\">Quantity</label>\n");
      out.write("                \n");
      out.write("                <input type=\"text\" class=\"form-control col-2\" id=\"TextQty\" style=\"display: inline;margin-left: 20px\"  placeholder=\"Enter Quantity\" name=\"textQty\">\n");
      out.write("                \n");
      out.write("                <br><br>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <input type=\"button\" value=\"Add Item Into Cart\" class=\"btn btn-primary col-2\" onclick=\"setOrder()\"  style=\"margin-top: 20px\">\n");
      out.write("                \n");
      out.write("                <input type=\"submit\" value=\"Proceed for Order\" class=\"btn btn-primary col-3\" style=\"margin-top: 20px\">\n");
      out.write("              \n");
      out.write("                <input type=\"button\" value=\"Pending Cart Items\" class=\"btn btn-primary col-3\" onclick=\"showCart();\" style=\"margin-top: 20px\">\n");
      out.write("\n");
      out.write("                <input type=\"button\" value=\"Delete Item From Cart\" class=\"btn btn-primary col-2\" onclick=\"emptyCart()\"  style=\"margin-top: 20px\">\n");
      out.write("\n");
      out.write("                <div id=\"orderDiv\" style=\"margin-top: 50px\">\n");
      out.write("                </div>\n");
      out.write("                <br><br>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_sql_setDataSource_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_url_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent(null);
    _jspx_th_sql_setDataSource_0.setVar("sqlDataSource");
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_setDataSource_var_url_nobody.reuse(_jspx_th_sql_setDataSource_0);
      return true;
    }
    _jspx_tagPool_sql_setDataSource_var_url_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }

  private boolean _jspx_meth_sql_query_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_0.setParent(null);
    _jspx_th_sql_query_0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sqlDataSource}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_sql_query_0.setVar("getCategory");
    int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
      if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_0[0]++;
          _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("            select * from Category\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_0[0]--;
      }
      if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_0.doFinally();
      _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("row");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${getUserDeatail.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                ");
          if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                ");
          if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("             ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_0.setVar("Uname");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.user_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_0.setScope("request");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_1.setVar("Ucontact");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.user_contact}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_1.setScope("request");
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("row");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${getCategory.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <option value=\"");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("</option>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.cat_id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.cat_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }
}
