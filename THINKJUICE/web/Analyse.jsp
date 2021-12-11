<%-- 
    Document   : Analyse
    Created on : 10 Sep, 2019, 8:44:03 PM
    Author     : AmEEt
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    String dataPoints = null;
    %>

    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  >
        <title>Get Detail</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
                window.onload = function() { 
                    filter();
                };
                
                
                function filter(){
                        var get_sel = document.getElementById('filter_graph').value;
                        if (get_sel === "0"){
                        <%    try{
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
                                }%>
                                            
                                var chart = new CanvasJS.Chart("chartContainer", {
                                    animationEnabled: true,
                                    theme: "light2", // "light1", "dark1", "dark2"
                                    title: {
                                            text: "Think Juice Category Wise Over All Sales"
                                    },
                                    subtitles: [{
                                            text: "In Rupees",
                                            fontSize: 16
                                    }],
                                    axisY: {
                                            scaleBreaks: {
                                                    type: "wavy",
                                                    autoCalculate: true
                                            }
                                    },
                                    data: [{
                                            type: "column",
                                            indexLabel: "{y}",
                                            dataPoints: <%out.print(dataPoints);%>
                                    }]
                            });
                            chart.render();
                            }
                        else if(get_sel === "1"){
                            <%
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

                            %>
                            
                            var chart2 = new CanvasJS.Chart("chartContainer", {
                                animationEnabled: true,
	
                                title:{
                                        text:"Total Sales By Item"
                                },
                                axisX:{
                                        interval: 1
                                },
                                axisY2:{
                                        interlacedColor: "rgba(1,77,101,.2)",
                                        gridColor: "rgba(1,77,101,.1)",
                                        title: "Rupee ₹"
                                },
                                data: [{
                                        	type: "bar",
                                                name: "companies",
                                                axisYType: "secondary",
                                                color: "#014D65",
                                                dataPoints: <%out.print(dataPoints);%>
                                }]
                        });
                        chart2.render();
                        
                                function addSymbols(e) {
                                    var suffixes = ["", "K", "M", "B"];

                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
                                    if(order > suffixes.length - 1)
                                    order = suffixes.length - 1;

                                    var suffix = suffixes[order];
                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
                            }

                        }
                    else if(get_sel === "2"){
                            <%
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

                            %>
                            
                            var chart3 = new CanvasJS.Chart("chartContainer", {
                                theme: "light2",
                                title: {
                                        text: "Day By Day Sale Track"
                                },
                                subtitles: [{
                                        text: "2019-2020"
                                }],
                                axisY:{
                                        title: "Money Collection",
                                        suffix: "₹",
                                        includeZero: false
                                },
                                data: [{
                                        type: "spline",
                                        toolTipContent: "<b>{label}</b>: {y}₹",
                                        dataPoints: <%out.print(dataPoints);%>
                                }]
                        });
                        chart3.render();
                        
                         var chart4 = new CanvasJS.Chart("chartContainer2", {
                                animationEnabled: true,
	
                                title:{
                                        text:"Total Sales By Item"
                                },
                                axisX:{
                                        interval: 1
                                },
                                axisY2:{
                                        interlacedColor: "rgba(1,77,101,.2)",
                                        gridColor: "rgba(1,77,101,.1)",
                                        title: "Rupee ₹"
                                },
                                data: [{
                                        	type: "bar",
                                                name: "companies",
                                                axisYType: "secondary",
                                                color: "#014D65",
                                                dataPoints: <%out.print(dataPoints);%>
                                }]
                        });
                        chart4.render();
                        
                                function addSymbols(e) {
                                    var suffixes = ["", "K", "M", "B"];

                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
                                    if(order > suffixes.length - 1)
                                    order = suffixes.length - 1;

                                    var suffix = suffixes[order];
                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
                            }
                        
                        
                    }
                    
                    else if(get_sel === "3"){
                            <%
                                try{
                                    gsonObj = new Gson();
                                    map = null;
                                    list = new ArrayList<Map<Object,Object>>();
                                    dataPoints = null;
                                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                                    Statement st = con.createStatement();
                                    String user_verify = "select order_time,count(*) as Total from Order_Details group by order_time";

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

                            %>
                        var chart4 = new CanvasJS.Chart("chartContainer", {
                                animationEnabled: true,
	
                                title:{
                                        text:"Cstomer Visiting Report"
                                },
                                axisX:{
                                        interval: 1
                                },
                                axisY2:{
                                        interlacedColor: "rgba(1,77,101,.2)",
                                        gridColor: "rgba(1,77,101,.1)",
                                        title: "Number of Customers"
                                },
                                data: [{
                                        	type: "bar",
                                                name: "companies",
                                                axisYType: "secondary",
                                                color: "#014D65",
                                                dataPoints: <%out.print(dataPoints);%>
                                }]
                        });
                        chart4.render();
                        
                                function addSymbols(e) {
                                    var suffixes = ["", "K", "M", "B"];

                                    var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
                                    if(order > suffixes.length - 1)
                                    order = suffixes.length - 1;

                                    var suffix = suffixes[order];
                                    return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
                            }
                    }
                        
                    
            }
                
    </script>
    </head>
    <body>
    
        <div class="container-fluid" style="margin-left: 30px;">
                    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
                        <a class="navbar-brand" href="index.jsp">Think Juice</a>
                        <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="CustomerDetail.jsp">Customer Detail</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="OrderDetail.jsp">Order Detail</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="OrderItemDetail.jsp">Order Item Detail</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="SendOffer.jsp">Send Offer</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="searchUser.jsp">Search Customer</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="Analyse.jsp">Report</a>
                                </li>
                        </ul>
                    </nav>
            </div>
        <div class="container" style="margin-top: 100px">
            
            <label for="sel1">Generate Report</label>
                 
                <select class="form-control col-3" style="display: inline;margin-left: 20px;" id="filter_graph" onchange="filter()">
                     <option selected value="0">Get Report By Category</option>
                     <option value="1">Get Report By Items</option>
                     <option value="2">Get Day by Day Report</option>
                     <option value="3">Get Customer Visiting Report</option>
                </select>
            
            <div id="chartContainer" style="height: 370px; width: 100%; margin-top: 40px">
            </div>
            
                <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
            </div>    
    </body>
</html>