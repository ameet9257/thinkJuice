<%-- 
    Document   : searchUser
    Created on : 7 Mar, 2019, 1:21:03 PM
    Author     : AmEEt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <title>Search Customer</title>
  
        <script type="text/javascript">
            
            function searchUser(){
                    var contact = document.getElementById('TextContact').value;
                    if(contact === null || contact === ""){
                        alert('Please Enter Customer Contact');
                    }else{ var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) {
                            document.getElementById("userData").innerHTML = this.responseText;
                            }
                        };
                    xhttp.open("POST","userSearch?getContact="+contact,true);
                    xhttp.send();
                    }
            }
            
            
            function goEdit(getId){
                            //alert("Get ID "+getId);
                            var link = "editUser.jsp?getUID="+getId;
                            window.open(link,"_self");
                    }
                    
            function goOrder(getId){
                            //alert("Get ID "+getId);
                            var link = "index.jsp?getUID="+getId;
                            window.open(link,"_self");
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
        </div><BR><br><br>
        
            <div class="container">
                <h1>Think Juice</h1>
                <label for="sel1" style="margin-top: 20px;display: inline;">Enter Customer Contact</label>
                
                <input type="text" class="form-control col-2" id="TextContact" style="display: inline;margin-left: 20px"  placeholder="Enter Conact Number" name="textContact">
                
                <button type="button" class="btn btn-primary col-2" onclick="searchUser()"  style="margin-left: 20px">Search</button>
        

                <p id="demo"></p>
                <div id="userData">
                    
                </div>
            </div>
    </body>
</html>
