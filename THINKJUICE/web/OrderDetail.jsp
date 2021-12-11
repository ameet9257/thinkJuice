<%-- 
    Document   : OrderDetail
    Created on : 23 Feb, 2019, 11:11:16 AM
    Author     : AmEEt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    
        <title>Order Detail</title>
        
        <script type="text/javascript">
                        function goAgain(uid){
                            var link = "index.jsp?getUID="+uid;
                            window.open(link,"_self");
                           // alert("Hello Dear"+uid);
                   }
                    
                    
        </script>
        
    </head>
    <body>

        
          <sql:setDataSource var="sqlDataSource" 
                          url="jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb"></sql:setDataSource>
        
          <sql:query dataSource="${sqlDataSource}" var="getOrderData">
                select u.user_name ,u.user_contact ,o.order_id,o.order_time,o.pay_mode,o.order_price,o.user_id
                from Order_Details o , User_Details u where o.user_id = u.user_id order by o.ID desc;
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
             <table class="table">
                <thead class="thead-dark">
                    <tr><th>Customer Name</th><th>Contact Number</th><th>Order Number</th>
                        <th>Order Date</th><th>Payment Mode</th><th>Order Price</th><th>Book</th></tr>
                </thead>    
                <tbody>
                    <c:forEach var="row" items="${getOrderData.rows}">
                        <tr>
                            <td><c:out value="${row.user_name}"></c:out></td>
                            <td><c:out value="${row.user_contact}"></c:out></td>
                            <td><c:out value="${row.order_id}"></c:out></td>
                            <td><c:out value="${row.order_time}"></c:out></td>
                            <td><c:out value="${row.pay_mode}"></c:out></td>
                            <td><c:out value="${row.order_price}"></c:out></td>
                            <td><input type="button" class="btn btn-info" value="Take Order" 
                                        id="<c:out value="${row.user_id}"></c:out>" onclick="goAgain(this.id)"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
        </div>
                
                <div id="test">
                    
                </div>
    </body>
</html>
