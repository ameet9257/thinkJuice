<%-- 
    Document   : index
    Created on : 16 Feb, 2019, 12:45:35 AM
    Author     : AmEEt
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
    
        <script type="text/javascript">
            
                window.onload = function() { 
                    setName();
                };
            
                    function chg(){
                        var cat_id = document.getElementById('cat_value').value;
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                                document.getElementById('item_option').innerHTML=xhttp.responseText;
                                document.getElementById('TextPrice').value = "";
                                document.getElementById('TextQty').value = "";
                                }
                        };
                        xhttp.open("POST","itemData?catData="+cat_id,true);
                        xhttp.send();
                    }
                    function setPrice(){
                            var item_id = document.getElementById('item_option').value;
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;
                                document.getElementById('TextPrice').value=xhttp.responseText;
                                }
                        };
                        xhttp.open("POST","getPrice?item_id="+item_id,true);
                        xhttp.send();
                    }
                    
                    function setOrder(){
                            var cat_id = document.getElementById('cat_value').value;
                            var item_id = document.getElementById('item_option').value;
                            var price = "";
                            var qty = document.getElementById('TextQty').value;
                            var getName = document.getElementById('TextName').value;
                            var getContact = document.getElementById('TextContact').value;
                            
                            var phoneno = /^(?:(?:\+|0{0,2})91(\s*[\ -]\s*)?|[0]?)?[789]\d{9}|(\d[ -]?){10}\d$/;
                            
                            var status = "True";
                            
                           if(getName === null || getContact === null || getName === "" || getContact===""){
                                    status = "False";
                                    alert("Please Enter Customer Detail");
                                   
                            }
                           else if(item_id === "0" || cat_id === "0" || price === null){
                                    status = "False";
                                    alert("Please Select Product Category and Product Item");
                            }
                           else if(qty === null || qty === ""){
                                status = "False";
                                alert("Enter Quantity");
                            }else if(!phoneno.test(getContact)){
                                status = "False";
                                alert("Invalid Contact Number");
                            }
                            
                            
                           
                            if(status === "True"){
                                    var xhttp = new XMLHttpRequest();
                                    xhttp.onreadystatechange = function(){
                                    if(xhttp.readyState===4 && xhttp.status===200){
                                        document.getElementById('orderDiv').innerHTML=xhttp.responseText;
                                        
                                }
                                };
            
            xhttp.open("POST","cartTable?getName="+getName+"&getContact="+getContact+"&cat_id="+cat_id+"&item_id="+item_id+"&qty="+qty,true);
                                xhttp.send();
                        }
                    }
                    
                    function emptyCart(){
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;
                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;
                                }
                        };
                        xhttp.open("POST","deleteCart",true);
                        xhttp.send();
                    
                    }
                    
                    
                    function showCart(){
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                              //  document.getElementById('PriceDiv').innerHTML=xhttp.responseText;
                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;
                                }
                        };
                        xhttp.open("POST","showCart",true);
                        xhttp.send();
                        
                    }
                    
                    function getCartId(cartId){
                           var id = cartId;
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                                document.getElementById('orderDiv').innerHTML=xhttp.responseText;
                            }
                        };
                        xhttp.open("POST","removeItem?getID="+id,true);
                        xhttp.send();
                    }
                    
                    <% 
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
                            
                            
                    %>
                    
                    function setName(){
                            var ids = "<%=id %>";
                            var a = "<%=getUserName%>";
                            var b = "<%=getUserContact%>";
                            if(ids > 0){
                                //alert(ids+a+b);
                                document.getElementById('TextName').value=a;
                                document.getElementById('TextContact').value=b;
                                }
                        }
                    
                    function getName(){
                        var cont = ""; 
                        cont = document.getElementById('TextContact').value;
                            var xhttp = new XMLHttpRequest();
                            xhttp.onreadystatechange = function(){
                            if(xhttp.readyState===4 && xhttp.status===200){
                                if(xhttp.responseText !== "not"){
                                    document.getElementById("TextName").disabled = true;   
                                    document.getElementById('TextName').value=xhttp.responseText;
                                }else{
                                    document.getElementById("TextName").disabled = false;   
                                    document.getElementById('TextName').value="";        
                                }
                            }
                        };
                        xhttp.open("POST","getName?contact="+cont,true);
                        xhttp.send();
                    }
                    
                    function contact(){
                        document.getElementById("TextName").disabled = false;   
                        document.getElementById('TextName').value="";        
                    }
                </script>
        </head>
    
        
        
        
        <body>
        
        
       <sql:setDataSource var="sqlDataSource" 
                          url="jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb"></sql:setDataSource>
        
        <sql:query dataSource="${sqlDataSource}" var="getCategory">
            select * from Category
        </sql:query>
        
            
            <sql:query dataSource="${sqlDataSource}" var="getUserDeatail">
                select user_name,user_contact from User_Details where user_id = "<%=id%>"
            </sql:query>    

            
            <c:forEach var="row" items="${getUserDeatail.rows}">
                <c:set var="Uname" value="${row.user_name}" scope="request"></c:set>
                <c:set var="Ucontact" value="${row.user_contact}" scope="request"></c:set>
             </c:forEach>
         
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
            <h1>Think Juice</h1>
                
            <form method="post" action="cartDetail.jsp">
                <h4 style="margin-top: 20px">Customer Detail</h4>
               
                <label for="labelContact" style="margin-top: 20px;display: inline;">Enter Customer Contact :</label>
                <input type="text" class="form-control col-2" id="TextContact" onclick="contact()" style="display: inline;margin-left: 20px"  placeholder="Customer Contact" name="textContact">
            
                
                <label for="labelName" style="margin-top: 20px; display: inline;margin-left: 30px">Enter Customer Name :</label>
                <input type="text" style="display: inline;margin-left: 20px" disabled="disabled" onfocus="getName()" class="form-control col-2" id="TextName" placeholder="Customer Name" name="textName">
                
                <h4 style="margin-top: 20px">Product Detail</h4>
                <label for="sel1">Select Category</label>
                 
                <select class="form-control col-3" style="display: inline;margin-left: 20px;" id="cat_value" onchange="chg()">
                     <option selected value="0">----Select Category----</option>
                   <c:forEach var="row" items="${getCategory.rows}">
                    <option value="<c:out value="${row.cat_id}"></c:out>"><c:out value="${row.cat_name}"></c:out></option>
                    </c:forEach>    
                 </select>
                
                <label for="sel1" style="margin-top: 20px;display: inline;margin-left: 30px;" >Select Item</label>
                <select class="form-control col-3" onchange="setPrice()" id="item_option" style="display: inline;margin-left: 20px;">
                    <option selected value="0">----Select Item----</option>
                </select> 
                 
                <br><br>
                <label for="sel1" style="margin-top: 20px;display: inline;" >Price</label>
                <input type="text" class="form-control col-2" disabled="disabled" id="TextPrice" style="display: inline;margin-left: 20px"  placeholder="Price" name="textPrice">
               
                <label for="sel1" style="margin-top: 20px;display: inline;margin-left: 30px;">Quantity</label>
                
                <input type="text" class="form-control col-2" id="TextQty" style="display: inline;margin-left: 20px"  placeholder="Enter Quantity" name="textQty">
                
                <br><br>
                
                
                <input type="button" value="Add Item Into Cart" class="btn btn-primary col-2" onclick="setOrder()"  style="margin-top: 20px">
                
                <input type="submit" value="Proceed for Order" class="btn btn-primary col-3" style="margin-top: 20px">
              
                <input type="button" value="Pending Cart Items" class="btn btn-primary col-3" onclick="showCart();" style="margin-top: 20px">

                <input type="button" value="Delete Item From Cart" class="btn btn-primary col-2" onclick="emptyCart()"  style="margin-top: 20px">

                <div id="orderDiv" style="margin-top: 50px">
                </div>
                <br><br>
            </form>
        </div>
    </body>
</html>