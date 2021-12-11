on : 18 Feb, 2019, 6:30:56 PM
    Author     : AmEEt
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
.button {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 10px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <title>Think Juice Cart</title>
        
        
        
        <script type="text/javascript">
            function getBack(){
              //  alert("YOYO");
              window.location = 'index.jsp';
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
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
            <br><br><br>
            
            <div class="container">
        
                <h1>Think Juice Cart Detail</h1>
                <%
                try{
                String getUserName = "";
                String getUserContact = "";
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                Statement st = con.createStatement();
                String query = "select u.user_id,u.user_name,u.user_contact from Cart cr,User_Details u where u.user_id = cr.user_id";
                ResultSet rs = st.executeQuery(query);
                int user_id = 0;
                if(rs.next()){
                    user_id = rs.getInt(1);
                    getUserName = rs.getString(2);
                    getUserContact = rs.getString(3);
                }else{
                    out.print("<script type=text/javascript>"
                            + " alert('Please Add Item to Cart'); window.location = 'index.jsp';</script>");
                   
                }
                st.close();rs.close();
                int count = 0;
                if(user_id > 0){
                    //out.print("<h1>"+user_id+"</h1>");
                    String query1 = "select distinct(user_id) from Cart";
                    Statement st1 = con.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);
                    while(rs1.next()){
                            count++;
                    }
                    //out.print("<h1>"+count+"</h1>");
                    st1.close();rs1.close();
                    
                    if(count==1){
                        
                        String query2 = "select cat.cat_name,i.item_name,cr.qty,cr.price "
                            + " from item_Details i,Category cat,Cart cr "
                            + " where i.cat_id = cat.cat_id and i.item_id = cr.item_id and cr.user_id = '"+user_id+"'";
                      
                        Statement st2 = con.createStatement();
                        ResultSet rs2 = st2.executeQuery(query2);
                        
                        String query3 = "select sum(price) from Cart where user_id='"+user_id+"'";
                        Statement st3 = con.createStatement();
                        ResultSet rs3 = st3.executeQuery(query3);
                        int totalCost = 0;
                        if(rs3.next()){
                            totalCost = rs3.getInt(1);
                        }
                        
                    out.print("<form action=Order action=post>");out.print("<label for=labelName style = margin-top:20px; display: inline;>Customer Name : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+getUserName+"</label>");
                            out.print("<label for=labelName style= margin-left:30px; display: inline>Customer Contact : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+getUserContact+"</label>");
                            
                    out.print("<table style=margin-top:20px class=table><thead class=thead-dark><tr><th>Category</th><th>Item Name</th><th>Quantity</th><th>Price</th></tr></thead><tbody>");
                        while(rs2.next()){
         out.print("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getInt(3)+"</td><td>"+rs2.getInt(4)+"</td></tr>");

                      }
       out.print("<tr><td colspan=3>Total Price </td><td>"+totalCost+"</td></tr>");
       out.print("</tbody></table>");   %>  
       
       <label for="sel1" style="margin-top: 20px;display: inline;">Select Payment Method</label>
               <select class="form-control col-3" name="Pay_Mode" style="display: inline;margin-left: 20px;">
               <option selected value="Cash">Cash Mode</option> "
               <option value="Credit/Debit">Credit/Debit Card</option>
               <option value="Paytm/Gpay/Ppay">Paytm/Gpay/Ppay</option> 
               </select>
        
    <label for="labelName" style="margin-left: 20px; display: inline;">Discount :</label>
    <select class="form-control col-3" style="display: inline;margin-left: 20px;" name="textDis">
        <option selected value="0">0 % </option>
        <option value="10">10 %</option>
        <option value="20">20 %</option>
        <option value="30">30 %</option>
        <option value="40">40 %</option>
        <option value="50">50 %</option>   
        <option value="100">100rs Grade Points</option>  
    </select>
                
    <%
        String pointQuery = "select user_points from User_Details where user_id = '"+user_id+"'";
                        int point=0;
                        Statement st4 = con.createStatement();
                        ResultSet rs4 = st4.executeQuery(pointQuery);
                        if(rs4.next()){
                            point = rs4.getInt(1);
                        }
                        
    %>
    <label for="labelName" style="margin-left: 30px;">Grade Point :</label>
    <input type="text" style="display: inline;margin-left: 10px" class="form-control col-1" id="TextPoint" disabled="disabled" name="textPoint" value="<%= point %>">
    
                <%
       
                        out.print("<br><br>");
                        
                        out.print("<input type=button value=Cancel Order class=button style=margin-top:40px onclick=getBack()>");
                        out.print("<input type=submit value=Confirm Order class=button style=margin-top:40px;margin-left:30px;>");
                       
                        out.print("</form>");
            
                    }else{
                         out.print("<script type=text/javascript>"
                            + " alert('Please Add data into the cart'); window.location = 'index.jsp';</script>");
                    }
                }
        
                    
                }catch(Exception e){
                    out.println("<h1>"+e.getMessage()+"</h1>");
                }
         
            %>
       </div>
    </body>
</html>
