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
public class serachItem extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try{
                
            String getDate = request.getParameter("idate");
            if("".equals(getDate) || getDate == null){
                
            }else{
                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                    String getDataCart = "select u.user_name, u.user_contact,o.order_id,o.order_time, cat.cat_name,i.item_name,oi.qty,oi.price " +
                    "from item_Details i,Category cat,Order_Item oi ,Order_Details o,User_Details u " +
                    "where i.cat_id = cat.cat_id and i.item_id = oi.item_id and " +
                    "u.user_id = oi.user_id and o.order_id = oi.order_id and o.order_time = '"+getDate+"'";
                    Statement cartSt = con.createStatement();
                    ResultSet row = cartSt.executeQuery(getDataCart);
                    
                        
                        out.print("<table class=\"table\">\n" +
                        "<thead class=\"thead-dark\" style=\"width: 80px;\">\n" +
                        "<tr><th>Customer Name</th><th>Customer Contact</th><th>Order Number</th><th>Order Time</th><th>Category Name</th><th>Item Name</th><th>Quantity</th><th>Price</th></tr>\n" +
                        "</thead>" +
                        "<tbody>");
                    
                    while(row.next()){
                        out.print("<tr>\n" +
                        "<td>"+row.getString(1)+"</td>" +
                        "<td>"+row.getString(2)+"</td>" +
                        "<td>"+row.getString(3)+"</td>" +
                        "<td>"+row.getString(4)+"</td>" +
                        "<td>"+row.getString(5)+"</td>" +
                        "<td>"+row.getString(6)+"</td>" +
                        "<td>"+row.getInt(7)+"</td>" +
                        "<td>"+row.getInt(8)+"</td>" +
                        "</tr>");
                    }
                    
               row.close();cartSt.close();
            
            String getTotal = " select sum(order_price) from Order_Details where order_time = '"+getDate+"'";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(getTotal);
            if(rs1.next()){
             
            out.print("<div class=\"fixed-bottom\" style=\"background-color: #f4511e;color: black;font-size: 25px;font-style: bold;height: 52px;\">\n" +
            "Total Collection : "+rs1.getInt(1)+" Rs</div>");
            }
        }
            
        }catch(Exception ex){
                out.print("Message :"+ex.getMessage());
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
