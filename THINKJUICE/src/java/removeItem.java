import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class removeItem extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                
                out.print("<html><head>"
                            + "\n" +
"        <style>\n" +
"                .button {\n" +
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
"</style></head><body>");
                
                
                String id = request.getParameter("getID");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                Statement st = con.createStatement();
                String QUERY = "Delete from Cart where cart_id = '"+id+"'";
                int i = st.executeUpdate(QUERY);
                if(i>0){
                    //out.println("Item has removed from cart");
                    String TableQuery = " select cat.cat_name,i.item_name,cr.qty,cr.price,cr.cart_id "
                            + " from item_Details i,Category cat,Cart cr "
                            + " where i.cat_id = cat.cat_id and i.item_id = cr.item_id ";
                      
                      Statement st2 = con.createStatement();
                      ResultSet rs2 = st2.executeQuery(TableQuery);
                //      out.println("<h1>Status Ok</h1>");
                      
            out.print("<table class=table id=cartTable><thead class=thead-dark><tr><th>Category</th><th>Item Name</th><th>Quantity</th><th>Price</th><th>Edit</th></tr></thead><tbody>");
                    
                      while(rs2.next()){

 out.print("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getInt(3)+"</td><td>"+rs2.getInt(4)+"</td><td>"
         + ""
         + "<button type=button id = "+rs2.getInt(5)+" class=button onclick=getCartId(this.id)>Remove Item</button></td></tr>");

                      }
       out.print("</tbody></table></body></html>");     
                }
            }catch(Exception ex){
                out.print(ex.getMessage());
        }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(removeItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(removeItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
