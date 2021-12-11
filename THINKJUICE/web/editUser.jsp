<%-- 
    Document   : editUser
    Created on : 7 Mar, 2019, 3:34:52 PM
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
        <title>Edit User Profile</title>
      
                <%
                 String getUserId = "";
                       getUserId  = request.getParameter("getUID");
                    if(getUserId.equals("") || getUserId == null){
                        getUserId = "";
                    }
                %>
            
        <script>
                    function giveData(){
                     var a = "<%=getUserId%>";
                     var name = document.getElementById("TextName").value;
                     var contact = document.getElementById("TextContact").value;
                     var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) {
                            document.getElementById("msg").innerHTML = this.responseText;
                            }
                        };
                        xhttp.open("POST","updateProfile?getId="+a+"&getName="+name+"&getContact="+contact,true);
                        xhttp.send();
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
                </ul>
            </nav>
         </div>
           <div class="container">
             <br><br><br>
             <h1>Think Juice</h1>
            <sql:setDataSource var="sqlDataSource" 
                          url="jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb"></sql:setDataSource>
        
            <sql:query dataSource="${sqlDataSource}" var="getUserData">
                select * from User_Details where user_id = "<%=getUserId%>";
            </sql:query>
            
            <c:forEach var="row" items="${getUserData.rows}">
                <c:set var="name" value="${row.user_name}"></c:set>
                <c:set var="contact" value="${row.user_contact}"></c:set>
            </c:forEach>    

                <h3>Customer Detail</h3>
                <br>
                <label for="labelName" style="margin-top: 20px; display: inline;">Customer Name :</label>
                <input type="text" style="display: inline;margin-left: 20px" 
                       class="form-control col-2" id="TextName" placeholder="Customer Name" name="textName"
                       value="<c:out value="${name}"></c:out>">
                
                <br><br>
                <label for="labelContact" style="margin-top: 20px;display: inline;">Customer Contact :</label>
                <input type="text" class="form-control col-2" id="TextContact" style="display: inline;margin-left: 20px"  
                       placeholder="Customer Contact" name="textContact"
                       value="<c:out value="${contact}"></c:out>">

                <br><br>
                <button type="button" class="btn btn-info" onclick="giveData()" id="getData">Update Profile</button> 
           
                <div id="msg">
                    
                </div>
           
           </div>
        </body>
</html>
