<%-- 
    Document   : OrderItemDetail
    Created on : 23 Feb, 2019, 11:11:32 AM
    Author     : AmEEt
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Item Detail</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <title>Think Juice Take Order</title>
    
             <script type="text/javascript">
                 function getDate(){
                            var idate = document.getElementById('DateText').value;
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                                document.getElementById('detailItem').innerHTML=xhttp.responseText;
                                }
                        };
                        xhttp.open("POST","serachItem?idate="+idate,true);
                        xhttp.send();
                    }
    
             </script>
        
    </head>
    <body>
        
        
        <%
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);
        %>
        
        <sql:setDataSource var="sqlDataSource" 
                          url="jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb"></sql:setDataSource>
        
        
        <sql:query dataSource="${sqlDataSource}" var="getOrderItem">
            select u.user_name, u.user_contact,o.order_id,o.order_time, cat.cat_name,i.item_name,oi.qty,oi.price 
            from item_Details i,Category cat,Order_Item oi ,Order_Details o,User_Details u
            where i.cat_id = cat.cat_id and i.item_id = oi.item_id and 
            u.user_id = oi.user_id and o.order_id = oi.order_id and o.order_time = "<%= strDate %>" 
            order by oi.order_Item desc;
        </sql:query>
      
            
            
          <sql:query dataSource="${sqlDataSource}" var="getTotalPrice">
                select sum(order_price) as price from Order_Details where order_time = "<%= strDate %>"
          </sql:query>
            
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
                <div class="container">
                        
                
                <br><br><br>
        <h1>Think Juice</h1>
        <h3>Order Details</h3>
        <form action="serach" method="post">
            <label for="labelName" style="margin-top: 20px; display: inline;">Choose Date :</label>
            <input type="date" style="display: inline;margin-left: 20px" id="DateText" name="dateText">
            <input type="button" class="btn btn-primary" value="Search" name="b1" id="search" onclick="getDate()"> 
        </form>
        <BR>
        <div id="detailItem">
            <table class="table">
       <thead class="thead-dark" style="width: 80px;">
       <tr><th>Customer Name</th><th>Customer Contact</th><th>Order Number</th><th>Order Time</th><th>Category Name</th><th>Item Name</th><th>Quantity</th><th>Price</th></tr>
    </thead>    
    <tbody>
        <c:set var="count" value="0"></c:set>
        <c:forEach var="row" items="${getOrderItem.rows}">
            <tr>
                <td><c:out value="${row.user_name}"></c:out></td>
                <td><c:out value="${row.user_contact}"></c:out></td>
                <td><c:out value="${row.order_id}"></c:out></td>
                <td><c:out value="${row.order_time}"></c:out></td>
                <td><c:out value="${row.cat_name}"></c:out></td>
                <td><c:out value="${row.item_name}"></c:out></td>
                <td><c:out value="${row.qty}"></c:out></td>
                <td><c:out value="${row.price}"></c:out></td>
                
            </tr>
        </c:forEach>
        
        <c:forEach var="row" items="${getTotalPrice.rows}">
                 <div class="fixed-bottom" style="background-color: #f4511e;color: black;font-size: 25px;font-style: bold;height: 52px;">
                     Total Collection : <c:out value="${row.price}"></c:out> Rs</div>
        </c:forEach>
    <tbody>
         </table>
        </div>
    </div>
                
                
    </body>
</html>
