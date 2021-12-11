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

public class updateProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           try{
               String getId = request.getParameter("getId");
               String getName = request.getParameter("getName");
               String getContact = request.getParameter("getContact");
               if(!getId.equals("") || getId != null || !getName.equals("") || getName == null || !getContact.equals("") || getContact == null){
                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                    String getUserId = "update User_Details set user_name = '"+getName+"',user_contact = '"+getContact+"' where user_id = '"+getId+"'";
                    Statement userSt = con.createStatement();
                    int i =userSt.executeUpdate(getUserId);
                    if(i>0){
                        out.print("Message : <h3>Customer Detail is Updated Successfully</h3>");
                    }else{
                        out.print("Message : <h3>Customer Detail is not updated</h3>");
                    }
               }
               
           }catch(Exception ex){
               out.print("Message : "+ex.getMessage());
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
