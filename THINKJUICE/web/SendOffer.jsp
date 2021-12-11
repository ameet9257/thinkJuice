<%-- 
    Document   : SendOffer
    Created on : 4 Mar, 2019, 11:36:09 AM
    Author     : AmEEt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <title>Think Juice Take Order</title>
    </head>
    <body>
                <div class="container-fluid" style="margin-left: 30px;">
                    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
                        <a class="navbar-brand" href="index.jsp">Think Juice </a>
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
        <div class="container"><br><br><br>
            <h1>Think Juice</h1>
                        
                        <form action="sendMsg" method="post">
                                <div class="form-group">
                                        <label for="comment">Enter Message</label>
                                        <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
                                </div>
                            <input type="submit" class="btn btn-primary" value="Send Message to Customer" name="b1">
                        </form>
            </div>
    </body>
</html>