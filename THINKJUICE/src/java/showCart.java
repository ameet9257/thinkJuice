import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class showCart extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                     
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
               String TableQuery = " select u.user_name,u.user_contact, cat.cat_name,i.item_name,cr.qty,cr.price,cr.cart_id "
                            + " from item_Details i,Category cat,Cart cr, User_Details u "
                            + " where i.cat_id = cat.cat_id and i.item_id = cr.item_id and u.user_id = cr.user_id";
                      
                    Statement st2 = con.createStatement();
                    ResultSet rs2 = st2.executeQuery(TableQuery);
                   
            if(rs2.isBeforeFirst()){
   out.print("<table class=table><thead class=thead-dark><tr><th>Customer Name</th><th>Customer Contact</th><th>Category</th><th>Item Name</th><th>Quantity</th><th>Price</th><th>Edit</th></tr></thead><tbody>");
 
                while(rs2.next()){
            
 out.print("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getInt(5)+"</td><td>"+rs2.getInt(6)+"</td>"
         + "<td><button type=button class=button id = "+rs2.getInt(7)+" onclick=getCartId(this.id)>Remove Item</button></td></tr>");

                      }
       out.print("</tbody></table></body></html>");                      
             st2.close();rs2.close();
                
            }else{
                out.println("<h3>Cart Is Empty : Not Found any Pending Item in Cart</h3>");
            }
            }catch(Exception E){
                out.print("<h1>Error : "+E.getMessage()+"</h1>");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
