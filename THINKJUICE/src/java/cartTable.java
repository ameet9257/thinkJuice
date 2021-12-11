import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class cartTable extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
             
            out.println("<html><head>"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n" +
"        "
                    + "<style>\n" +
"                .button {\n" +
"                  background-color: #4CAF50; /* Green */\n" +
"                  border: none;\n" +
"                  color: white;\n" +
"                  padding: 08px 20px;\n" +
"                  text-align: center;\n" +
"                  text-decoration: none;\n" +
"                  display: inline-block;\n" +
"                  font-size: 16px;\n" +
"                  margin: 2px 2px;\n" +
"                  -webkit-transition-duration: 0.4s; /* Safari */\n" +
"                  transition-duration: 0.4s;\n" +
"                  cursor: pointer;" +
"                  background-color: white; \n" +
"                   color: black; \n" +
"                   border: 2px solid #008CBA;"
                            + "}\n" +
"                   " +
"                    .button:hover {\n" +
"                      background-color: #008CBA;\n" +
"                      color: white;\n" +
"                    }\n" +
"</style>"
                    + "</head>"   + ""
                    + "<body>");
            
            try{
                
              String getName = request.getParameter("getName");
              String getContact = request.getParameter("getContact");
              String cat_id = request.getParameter("cat_id");
              String item_id = request.getParameter("item_id");
              String qty = request.getParameter("qty");
              
            //out.print("<h1>"+getName+getContact+cat_id+item_id+qty+"</h1>");
            int getUserid = 0;          
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
            Statement st = con.createStatement();
            String user_verify = "select * from User_Details where user_name='"+getName+"' and user_contact = '"+getContact+"' ";
            
            ResultSet rs = st.executeQuery(user_verify); 
            if(rs.next()){
                getUserid = rs.getInt(1);
                rs.close();st.close();
            } 
            else{
                String insQuery = "insert into User_Details (user_name,user_contact) values (?,?)";
                PreparedStatement ps = con.prepareStatement(insQuery);
                ps.setString(1, getName);
                ps.setString(2, getContact);
                int insCheck = ps.executeUpdate();
                    if(insCheck > 0){
                  //  out.println("<h1>Getting DATA</h1>");
                    Statement st1 = con.createStatement();
                    String getIdQuery = "select max(user_id) as user_id from User_Details";
                    ResultSet rs1 = st1.executeQuery(getIdQuery);
                        if(rs1.next()){
                             getUserid = rs1.getInt("user_id");
                        }
                        st1.close();rs1.close();
                }
            }
            
            if(getUserid > 0){
                  int iPrice = 0;  
 
                            Statement chks = con.createStatement();
                            String user_id_cat = "select * from Cart where user_id != '"+getUserid+"'";
                            ResultSet chkrs = chks.executeQuery(user_id_cat);
                            if(!chkrs.next()){

                                    Statement stIp = con.createStatement();
                                    String getPrice = "Select item_price from item_Details where item_id = '"+item_id+"'";
                                    ResultSet rsPrice = stIp.executeQuery(getPrice);
                                    if(rsPrice.next()){
                                        iPrice = rsPrice.getInt(1)*Integer.parseInt(qty);
                                    }
                                    stIp.close();rsPrice.close();

                    String insrtCart = "insert into cart (cat_id,item_id,qty,user_id,price) values (?,?,?,?,?)";
                    PreparedStatement ps1 = con.prepareStatement(insrtCart);
                    ps1.setInt(1,Integer.parseInt(cat_id));
                    ps1.setInt(2,Integer.parseInt(item_id));
                    ps1.setInt(3,Integer.parseInt(qty));
                    ps1.setInt(4, getUserid);
                    ps1.setInt(5, iPrice);
                    int i = ps1.executeUpdate();
                  
                            if(i>0){
                                    ps1.close();
                                   String TableQuery = " select cat.cat_name,i.item_name,cr.qty,cr.price,cr.cart_id "
                                           + " from item_Details i,Category cat,Cart cr "
                                           + " where i.cat_id = cat.cat_id and i.item_id = cr.item_id ";

                                     Statement st2 = con.createStatement();
                                     ResultSet rs2 = st2.executeQuery(TableQuery);
                                     out.print("<table class=table id=cartTable><thead class=thead-dark><tr><th>Category</th><th>Item Name</th>"
                                             + "<th>Quantity</th><th>Price</th><th>Edit</th></tr></thead><tbody>");
                    
                      while(rs2.next()){
                                out.print("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td>"
                                        + "<td>"+rs2.getInt(3)+"</td><td>"+rs2.getInt(4)+"</td><td>"
                                        + ""
                                        + "<button type=button class=button id = "+rs2.getInt(5)+" onclick=getCartId(this.id)>Remove Item</button></td></tr>");
                                    }
                                    out.print("</tbody></table>");                      
                                    ps1.close();st2.close();rs2.close();
                            }
                }else{
                      out.print("<h3>Message : To different Customer Order can't be added to Cart."
                              + "<br>Please Process Pending Item or Delete Item From Cart.<br>"
                              + "Please Check your pending Order.</h3>");
                  }
              }else{
                      out.print("<h3>Something Went Wrong</h3>");
                   }
            }catch(Exception e){
                    out.print("<h1>"+e.getMessage()+"</h1>");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cartTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cartTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
