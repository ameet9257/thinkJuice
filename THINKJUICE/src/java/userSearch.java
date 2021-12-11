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
public class userSearch extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                    
                    out.print("<html><head>"
                            + "\n" +
"        <style>\n" +
"                .button {\n" +
"                  background-color: #4CAF50; /* Green */\n" +
"                  border: none;\n" +
"                  color: white;\n" +
"                  padding: 10px 22px;\n" +
"                  text-align: center;\n" +
"                  text-decoration: none;\n" +
"                  display: inline-block;\n" +
"                  font-size: 16px;\n" +
"                  margin: 4px 2px;\n" +
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
                
                    String getContact = request.getParameter("getContact");
                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
                    String getUserId = "select * from User_Details where user_contact = '"+getContact+"'";
                    Statement userSt = con.createStatement();
                    ResultSet userRs = userSt.executeQuery(getUserId);
                    
                    out.print("<table class=table><thead class=thead-dark>" +
                              "<tr><th>Customer Name</th><th>Customer Contact</th><th>Grade Point</th>"
                            + "<th>Edit Detail</th><th>Take Order</th></tr></thead><tbody>");
                    while(userRs.next()){
                        out.print("<tr>");
                        out.print("<td>"+userRs.getString(2)+"</td>");
                        out.print("<td>"+userRs.getString(3)+"</td>");
                        out.print("<td>"+userRs.getInt(4)+"</td>");
                        out.print("<td><button type=button " +
                        "id="+userRs.getInt(1)+" class=button onclick=goEdit(this.id)>Edit Profile</button></td>");
                        out.print("<td><button type=button " +
                        "id="+userRs.getInt(1)+" class=button onclick=goOrder(this.id)>Take Order</button></td>");
                        out.print("</tr>");
                    }
                    out.print("</tbody></table></body></html>");
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
