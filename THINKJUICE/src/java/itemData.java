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
public class itemData extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<html><head>"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n" +
"        </head><body>");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
            Statement st = con.createStatement();
            String getData = request.getParameter("catData");
            String QUERY = "select * from Item_Details where cat_id = '"+getData+"'";
            ResultSet rs = st.executeQuery(QUERY);
            out.print("<option value=0>----Select Item----</option>");
            while(rs.next()){
               out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
            }
            out.print("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(itemData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(itemData.class.getName()).log(Level.SEVERE, null, ex);
        }
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
