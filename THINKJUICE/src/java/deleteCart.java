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
public class deleteCart extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try{
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                Statement st = con.createStatement();
                String QUERY = "Delete from Cart";
                int i = st.executeUpdate(QUERY);
                if(i>0){
                    //out.print("<script type=text/javascript>"
                      //      + " alert('Cart Is Empty'); window.location = 'index.jsp';</script>");
                    
                      String TableQuery = " select cat.cat_name,i.item_name,cr.qty,cr.price "
                            + " from item_Details i,Category cat,Cart cr "
                            + " where i.cat_id = cat.cat_id and i.item_id = cr.item_id ";
                      
                    Statement st2 = con.createStatement();
                    ResultSet rs2 = st2.executeQuery(TableQuery);
            out.print("<table class=table><thead class=thead-dark><tr><th>Category</th><th>Item Name</th><th>Quantity</th><th>Price</th></tr></thead><tbody>");
                    
                      while(rs2.next()){

 out.print("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getInt(3)+"</td><td>"+rs2.getInt(4)+"</td><td></td></tr>");

                      }
       out.print("</tbody></table>");                      
             st2.close();rs2.close();
               
                }else{
                    out.print("<h3>Cart is Empty<h3>");
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
