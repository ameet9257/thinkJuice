import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author AmEEt
 */public class GenerateGraph extends HttpServlet {

    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    String dataPoints = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                try{

                    Date date;
                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                    Statement st = con.createStatement();
                    String user_verify = "select * from dateTable";
                    String sdate = "";
                    ResultSet rs = st.executeQuery(user_verify);
                    while(rs.next()){
                        //date = rs.getDate(2);
                        sdate = rs.getDate(2).toString();
                        out.print(sdate);
                    }
                }catch(Exception E){
                    out.print("<h3>Message :"+E.getMessage()+"</h3>");
                }
        }
    }
    
    public String getData(){
        
        return "";
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
