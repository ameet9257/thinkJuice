package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class Analyse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    String dataPoints = null;
    
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"  >\n");
      out.write("        <title>Get Detail</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                window.onload = function() { \n");
      out.write("                    filter();\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                function filter(){\n");
      out.write("                        var get_sel = document.getElementById('filter_graph').value;\n");
      out.write("                        if (get_sel === \"0\"){\n");
      out.write("                        ");
    try{
                                        gsonObj = new Gson();
                                        map = null;
                                        list = new ArrayList<Map<Object,Object>>();
                                        dataPoints = null;
                                        Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                                        Statement st = con.createStatement();
                                        ResultSet rs = st.executeQuery("select cat.cat_name,sum(oi.price) as Total from Order_Item oi , Category cat where cat.cat_id = oi.cat_id group by cat.cat_name");
                                        while(rs.next()){
                                            map = new HashMap<Object,Object>(); 
                                            map.put("label", rs.getString(1)); 
                                            map.put("y", rs.getInt(2)); 
                                            list.add(map);
                                        }
                                        dataPoints = gsonObj.toJson(list);
                                        rs.close();
                                        st.close();
                                        con.close();
                                }catch(Exception E){
                                    out.print("<h1> MESSAGE "+E.getMessage()+"</h1>");
                                    dataPoints=null;
                                }
      out.write("\n");
      out.write("                                            \n");
      out.write("                                var chart = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                                    animationEnabled: true,\n");
      out.write("                                    theme: \"light2\", // \"light1\", \"dark1\", \"dark2\"\n");
      out.write("                                    title: {\n");
      out.write("                                            text: \"Think Juice Category Wise Over All Sales\"\n");
      out.write("                                    },\n");
      out.write("                                    subtitles: [{\n");
      out.write("                                            text: \"In Rupees\",\n");
      out.write("                                            fontSize: 16\n");
      out.write("                                    }],\n");
      out.write("                                    axisY: {\n");
      out.write("                                            scaleBreaks: {\n");
      out.write("                                                    type: \"wavy\",\n");
      out.write("                                                    autoCalculate: true\n");
      out.write("                                            }\n");
      out.write("                                    },\n");
      out.write("                                    data: [{\n");
      out.write("                                            type: \"column\",\n");
      out.write("                                            indexLabel: \"{y}\",\n");
      out.write("                                            dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                                    }]\n");
      out.write("                            });\n");
      out.write("                            chart.render();\n");
      out.write("                            }\n");
      out.write("                        else if(get_sel === \"1\"){\n");
      out.write("                            ");

                                try{
                                    gsonObj = new Gson();
                                    map = null;
                                    list = new ArrayList<Map<Object,Object>>();
                                    dataPoints = null;
                                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                                    Statement st = con.createStatement();
                                    String user_verify = "select item.item_name,sum(oi.price) as Total \n" +
                                                            "from Order_Item oi, Item_Details item \n" +
                                                                "where item.item_id = oi.item_id \n" +
                                                                    "group by item_name";

                                ResultSet rs = st.executeQuery(user_verify);
                                while(rs.next()){
                                        map = new HashMap<Object,Object>(); 
                                        map.put("label", rs.getString(1)); 
                                        map.put("y", rs.getInt(2)); 
                                        list.add(map);
                                }   
                                dataPoints = gsonObj.toJson(list);
                                    rs.close();
                                    st.close();
                                    con.close();
                            }catch(Exception E){
                                out.print("<h1> MESSAGE "+E.getMessage()+"</h1>");
                                dataPoints=null;
                            }

                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            var chart2 = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                                animationEnabled: true,\n");
      out.write("\t\n");
      out.write("                                title:{\n");
      out.write("                                        text:\"Total Sales By Item\"\n");
      out.write("                                },\n");
      out.write("                                axisX:{\n");
      out.write("                                        interval: 1\n");
      out.write("                                },\n");
      out.write("                                axisY2:{\n");
      out.write("                                        interlacedColor: \"rgba(1,77,101,.2)\",\n");
      out.write("                                        gridColor: \"rgba(1,77,101,.1)\",\n");
      out.write("                                        title: \"Rupee ₹\"\n");
      out.write("                                },\n");
      out.write("                                data: [{\n");
      out.write("                                        \ttype: \"bar\",\n");
      out.write("                                                name: \"companies\",\n");
      out.write("                                                axisYType: \"secondary\",\n");
      out.write("                                                color: \"#014D65\",\n");
      out.write("                                                dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                                }]\n");
      out.write("                        });\n");
      out.write("                        chart2.render();\n");
      out.write("                        \n");
      out.write("                                function addSymbols(e) {\n");
      out.write("                                    var suffixes = [\"\", \"K\", \"M\", \"B\"];\n");
      out.write("\n");
      out.write("                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);\n");
      out.write("                                    if(order > suffixes.length - 1)\n");
      out.write("                                    order = suffixes.length - 1;\n");
      out.write("\n");
      out.write("                                    var suffix = suffixes[order];\n");
      out.write("                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                       /* else if(get_sel === \"2\"){\n");
      out.write("                            ");

                                        gsonObj = new Gson();
                                        map = null;
                                        list = new ArrayList<Map<Object,Object>>();
                                        dataPoints = null;
                                try{
                                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                                    Statement st = con.createStatement();
                                    String user_verify = "select item.item_name,sum(oi.price) as Total \n" +
                                                            "from Order_Item oi, Item_Details item \n" +
                                                                "where item.item_id = oi.item_id \n" +
                                                                    "group by item_name";

                                ResultSet rs = st.executeQuery(user_verify);
                                while(rs.next()){
                                        map = new HashMap<Object,Object>(); 
                                        map.put("label", rs.getString(1)); 
                                        map.put("y", rs.getInt(2)); 
                                        list.add(map);
                                }   
                                dataPoints = gsonObj.toJson(list);
                                    rs.close();
                                    st.close();
                                    con.close();
                            }catch(Exception E){
                                out.print("<h1> MESSAGE "+E.getMessage()+"</h1>");
                                dataPoints=null;
                            }

                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            var chart3 = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                                animationEnabled: true,\n");
      out.write("\t\n");
      out.write("                                title:{\n");
      out.write("                                        text:\"Total Sales By Item\"\n");
      out.write("                                },\n");
      out.write("                                axisX:{\n");
      out.write("                                        interval: 1\n");
      out.write("                                },\n");
      out.write("                                axisY2:{\n");
      out.write("                                        interlacedColor: \"rgba(1,77,101,.2)\",\n");
      out.write("                                        gridColor: \"rgba(1,77,101,.1)\",\n");
      out.write("                                        title: \"Rupee ₹\"\n");
      out.write("                                },\n");
      out.write("                                data: [{\n");
      out.write("                                        \ttype: \"bar\",\n");
      out.write("                                                name: \"companies\",\n");
      out.write("                                                axisYType: \"secondary\",\n");
      out.write("                                                color: \"#014D65\",\n");
      out.write("                                                dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                                }]\n");
      out.write("                        });\n");
      out.write("                        chart3.render();\n");
      out.write("                        \n");
      out.write("                                function addSymbols(e) {\n");
      out.write("                                    var suffixes = [\"\", \"K\", \"M\", \"B\"];\n");
      out.write("\n");
      out.write("                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);\n");
      out.write("                                    if(order > suffixes.length - 1)\n");
      out.write("                                    order = suffixes.length - 1;\n");
      out.write("\n");
      out.write("                                    var suffix = suffixes[order];\n");
      out.write("                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                        }*/\n");
      out.write("                    else if(get_sel === \"2\"){\n");
      out.write("                            ");

                                try{
                                    gsonObj = new Gson();
                                    map = null;
                                    list = new ArrayList<Map<Object,Object>>();
                                    dataPoints = null;
                                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                                    Statement st = con.createStatement();
                                    String user_verify = "select order_time,sum(order_price) as Total from Order_Details group by order_time";

                                ResultSet rs = st.executeQuery(user_verify);
                                while(rs.next()){
                                        map = new HashMap<Object,Object>(); 
                                        map.put("label", rs.getString(1)); 
                                        map.put("y", rs.getInt(2)); 
                                        list.add(map);
                                }   
                                dataPoints = gsonObj.toJson(list);
                                    rs.close();
                                    st.close();
                                    con.close();
                            }catch(Exception E){
                                out.print("<h1> MESSAGE "+E.getMessage()+"</h1>");
                                dataPoints=null;
                            }

                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            var chart3 = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                                theme: \"light2\",\n");
      out.write("                                title: {\n");
      out.write("                                        text: \"Day By Day Sale Track\"\n");
      out.write("                                },\n");
      out.write("                                subtitles: [{\n");
      out.write("                                        text: \"2019\"\n");
      out.write("                                }],\n");
      out.write("                                axisY:{\n");
      out.write("                                        title: \"Money Collection\",\n");
      out.write("                                        suffix: \"₹\",\n");
      out.write("                                        includeZero: false\n");
      out.write("                                },\n");
      out.write("                                data: [{\n");
      out.write("                                        type: \"spline\",\n");
      out.write("                                        toolTipContent: \"<b>{label}</b>: {y}₹\",\n");
      out.write("                                        dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                                }]\n");
      out.write("                        });\n");
      out.write("                        chart3.render();\n");
      out.write("                        \n");
      out.write("                         var chart4 = new CanvasJS.Chart(\"chartContainer2\", {\n");
      out.write("                                animationEnabled: true,\n");
      out.write("\t\n");
      out.write("                                title:{\n");
      out.write("                                        text:\"Total Sales By Item\"\n");
      out.write("                                },\n");
      out.write("                                axisX:{\n");
      out.write("                                        interval: 1\n");
      out.write("                                },\n");
      out.write("                                axisY2:{\n");
      out.write("                                        interlacedColor: \"rgba(1,77,101,.2)\",\n");
      out.write("                                        gridColor: \"rgba(1,77,101,.1)\",\n");
      out.write("                                        title: \"Rupee ₹\"\n");
      out.write("                                },\n");
      out.write("                                data: [{\n");
      out.write("                                        \ttype: \"bar\",\n");
      out.write("                                                name: \"companies\",\n");
      out.write("                                                axisYType: \"secondary\",\n");
      out.write("                                                color: \"#014D65\",\n");
      out.write("                                                dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                                }]\n");
      out.write("                        });\n");
      out.write("                        chart4.render();\n");
      out.write("                        \n");
      out.write("                                function addSymbols(e) {\n");
      out.write("                                    var suffixes = [\"\", \"K\", \"M\", \"B\"];\n");
      out.write("\n");
      out.write("                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);\n");
      out.write("                                    if(order > suffixes.length - 1)\n");
      out.write("                                    order = suffixes.length - 1;\n");
      out.write("\n");
      out.write("                                    var suffix = suffixes[order];\n");
      out.write("                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;\n");
      out.write("                            }\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("            }\n");
      out.write("                \n");
      out.write("    </script>\n");
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
      out.write("                                \n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"searchUser.jsp\">Search Customer</a>\n");
      out.write("                                </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"container\" style=\"margin-top: 100px\">\n");
      out.write("            \n");
      out.write("            <label for=\"sel1\">Generate Report</label>\n");
      out.write("                 \n");
      out.write("                <select class=\"form-control col-3\" style=\"display: inline;margin-left: 20px;\" id=\"filter_graph\" onchange=\"filter()\">\n");
      out.write("                     <option selected value=\"0\">Get Report By Category</option>\n");
      out.write("                     <option value=\"1\">Get Report By Items</option>\n");
      out.write("                     <option value=\"2\">Get Day by Day Report</option>\n");
      out.write("                </select>\n");
      out.write("            \n");
      out.write("            <div id=\"chartContainer\" style=\"height: 370px; width: 100%; margin-top: 40px\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("                <script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n");
      out.write("            </div>    \n");
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
}
