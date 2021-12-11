import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Order extends HttpServlet {
    public String OrderNumberGenrator(){
        int n = 8;
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
        String randomString = new String(array, Charset.forName("UTF-8")); 
        StringBuilder r = new StringBuilder(); 
        for (int k = 0; k < randomString.length(); k++) { 
            char ch = randomString.charAt(k); 
            if (((ch >= 'a' && ch <= 'z') 
                 || (ch >= 'A' && ch <= 'Z') 
                 || (ch >= '0' && ch <= '9')) 
                && (n > 0)) { 
            r.append(ch); 
                n--; 
            } 
        }
        return r.toString();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try{
            out.println("<html><head>    <style>\n" +
".button {\n" +
"  border-radius: 4px;\n" +
"  background-color: #f4511e;\n" +
"  border: none;\n" +
"  color: #FFFFFF;\n" +
"  text-align: center;\n" +
"  font-size: 28px;\n" +
"  padding: 10px;\n" +
"  width: 200px;\n" +
"  transition: all 0.5s;\n" +
"  cursor: pointer;\n" +
"  margin: 5px;\n" +
"}\n" +
"\n" +
".button span {\n" +
"  cursor: pointer;\n" +
"  display: inline-block;\n" +
"  position: relative;\n" +
"  transition: 0.5s;\n" +
"}\n" +
"\n" +
".button span:after {\n" +
"  content: '\\00bb';\n" +
"  position: absolute;\n" +
"  opacity: 0;\n" +
"  top: 0;\n" +
"  right: -20px;\n" +
"  transition: 0.5s;\n" +
"}\n" +
"\n" +
".button:hover span {\n" +
"  padding-right: 25px;\n" +
"}\n" +
"\n" +
".button:hover span:after {\n" +
"  opacity: 1;\n" +
"  right: 0;\n" +
"}\n" +
"</style>"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n" +
"        <title>Think Juice Take Order</title>\n" +
"    "
                    + "</head>"
                    + "<body>"
                    + "<div class=\"container-fluid\">\n" +
"           <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark fixed-top\">\n" +
"                <a class=\"navbar-brand\" href=\"index.jsp\">Think Juice</a>\n" +
"                <ul class=\"navbar-nav\">\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"CustomerDetail.jsp\">Customer Detail</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"OrderDetail.jsp\">Order Detail</a>\n" +
"                        </li>\n" +
"                        \n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"OrderItemDetail.jsp\">Order Item Detail</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"SendOffer.jsp\">Send Offer</a>\n" +
"                        </li>"
                    + "\n"
                    + "<li class=\"nav-item\">\n" +
"                                    <a class=\"nav-link\" href=\"searchUser.jsp\">Search Customer</a>\n" +
"                                </li> "
                    + "<li class=\"nav-item\">\n" +
"                                    <a class=\"nav-link\" href=\"Analyse.jsp\">Report</a>\n" +
"                                </li>" +
                    
"                </ul>\n" +
"            </nav>\n" +
"        </div>    \n" +
"            <br><br><br>\n" +
"            \n" +
"            <div class=\"container\">\n" +
"        \n" +
"");     
                
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);

            int cart_id = 0;int qty = 0;
            int item_id = 0;int price = 0;
            int user_id = 0;int totalPrice = 0;
            int discount = 0;
            int gradePoint = 0;
            String mode = request.getParameter("Pay_Mode");
            discount = Integer.parseInt(request.getParameter("textDis"));
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://THINKJUICEDATA//ThinkJuice.accdb");
           
            String getDataCart = "select * from Cart";
            Statement cartSt = con.createStatement();
            ResultSet cartRs = cartSt.executeQuery(getDataCart);
            if(cartRs.next()){
                String getCartTotal = "select sum(price) ,user_id from Cart group by user_id";
            cartRs.close();
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(getCartTotal);
            if(rs2.next()){
                totalPrice = rs2.getInt(1);
                user_id = rs2.getInt(2);
                
                String getPoint = "select user_points from User_Details where user_id = '"+user_id+"'";
                Statement stP = con.createStatement();
                ResultSet rsP = stP.executeQuery(getPoint);
                if(rsP.next()){
                    gradePoint = rsP.getInt(1);
                    rsP.close();stP.close();
                }
            }
            st2.close();rs2.close();
            String onum = "ODTJ"+OrderNumberGenrator()+Integer.toString(user_id);
            if(discount == 100){
                if(gradePoint >= 100){
                    totalPrice = totalPrice - 100;
                    gradePoint = 0;
            }
            }else{
                totalPrice = totalPrice - ((totalPrice * discount)/100);
            }
            
            PreparedStatement ps = con.prepareStatement("insert into Order_Details(order_id,user_id,order_time,order_price,pay_mode,order_dis)values(?,?,?,?,?,?)");
            ps.setString(1,onum);ps.setInt(2, user_id);ps.setString(3, strDate);ps.setInt(4, totalPrice);ps.setString(5, mode);ps.setInt(6,discount);
            int i =ps.executeUpdate();
            if(i>0){

                ps.close();
                Statement st = con.createStatement();
                String getCartData = "select cat_id,item_id,qty,user_id,price from Cart";
                ResultSet rs = st.executeQuery(getCartData);
                
                String insertOrder = "insert into Order_Item(order_id,cat_id,item_id,qty,price,user_id) values (?,?,?,?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(insertOrder);
            int j = 0;
            while(rs.next()){
                cart_id = rs.getInt(1);
                item_id = rs.getInt(2);
                qty = rs.getInt(3);
                user_id = rs.getInt(4);
                price = rs.getInt(5);
                ps1.setString(1, onum);
                ps1.setInt(2, cart_id);ps1.setInt(4, qty);ps1.setInt(6, user_id);
                ps1.setInt(3, item_id);ps1.setInt(5, price);
                 j = ps1.executeUpdate();
            }
            
            gradePoint += ((totalPrice * 5)/100);
            
            if(gradePoint < 100){
                String updatePoint = "update User_Details set user_points = '"+gradePoint+"' where user_id = '"+user_id+"'";
                Statement ust = con.createStatement();
                int up = ust.executeUpdate(updatePoint);
            }
            if(j>0){
                rs.close();ps1.close();st.close();
                 String TruncQuery = "delete from Cart"; 
                    Statement stCart = con.createStatement();
                    int K = stCart.executeUpdate(TruncQuery);
              if(K > 0){
                  stCart.close();
                   String TableQuery = " select u.user_name ,u.user_contact ,o.order_id,o.order_time,o.pay_mode,o.order_price "
                          + " from Order_Details o , User_Details u where o.order_id = '"+onum+"' and o.order_time = '"+strDate+"' and u.user_id = o.user_id";
                   
                    String cust_cont;
                    ResultSet rsp;
                    Statement stp = con.createStatement();
                        rsp = stp.executeQuery(TableQuery);
                        if(rsp.next()){
                            out.print("<h3>Order Detail</h3><form action=index.jsp method=post>");
                            out.print("<label for=labelName style = margin-top:20px; display: inline;>Customer Name : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+rsp.getString(1)+"</label>");
                            out.print("<label for=labelName style= margin-left:30px; display: inline>Customer Contact : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+rsp.getString(2)+"</label>");
                            cust_cont = rsp.getString(2);
                            out.print("<br><br><label for=labelName style= margin-top: 20px; display: inline>Order Number : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+rsp.getString(3)+"</label>");
                            out.print("<label for=labelName style= margin-left:30px; display: inline>Date : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+rsp.getString(4)+"</label>");
                            out.print("<label for=labelName style= margin-left:30px; display: inline>Payemt Mode : </label>");
                            out.print("<label for=labelName style= margin-left:20px; display: inline>"+rsp.getString(5)+"</label>");
                            int totalCost = rsp.getInt(6);
                            
                            String str = "select cat.cat_name,i.item_name,oi.qty,oi.price "+
                                        " from item_Details i,Category cat,Order_Item oi " +
                                         " where i.cat_id = cat.cat_id and i.item_id = oi.item_id "
                                       + " and oi.order_id = '"+rsp.getString(3)+"' ";
                        
                        Statement sti = con.createStatement();
                        ResultSet rsi = sti.executeQuery(str);
                        rsp.close();stp.close();
                        out.print("<table style=margin-top:20px class=table><thead class=thead-dark><tr><th>Category</th><th>Item Name</th><th>Quantity</th><th>Price</th></tr></thead><tbody>");
                        while(rsi.next()){
         out.print("<tr><td>"+rsi.getString(1)+"</td><td>"+rsi.getString(2)+"</td><td>"+rsi.getInt(3)+"</td><td>"+rsi.getInt(4)+"</td></tr>");
               }
                        rsi.close();sti.close();
       out.print("<tr><td colspan=3>Total Price </td><td>"+totalCost+"</td></tr>");
       out.print("</tbody></table>");
       out.print("<input type=submit value= Back To Home class=button style=margin- top:40px;margin-left:30px;></form>");
       out.print("</div></body>");
                        
                        
                        String Msg = "Thank You, to visit at Think Juice.\n" +
                                     "We are Happy to serve you.\n";
                         Msg += "Your Order Number: "+onum+"\n"+
                                     "Date: "+strDate+"\n"+
                                     "Total Bill: "+totalPrice+"\n"+
                                     "Total Point: "+gradePoint;
                        Msg += "\nFor more information and for exclusive offer follow us on Instagram \n";
                                       Msg  += "https://www.instagram.com/think_juice_ghatkopar/";
                                       
                        
                                       
                       /* String NewMsg = "Thank You,to visit at Think Juice."+
                                        "We are Happy to serve you."+
                                        "Your Order Number:"+onum+
                                        "Date:"+strDate+
                                        "Total Bill:"+totalPrice+
                                        "Total Point:"+gradePoint+
                                        "For more information and for exclusive offers follow us on Instagram"+
                                        "https://www.instagram.com/think_juice_ghatkopar/";   */
                        
                         String NewMsg = "Thank You, to visit at Think Juice.%nWe are Happy to serve you.%nYour Order Number: "+onum+"%nDate: "+strDate+"%nTotal Bill: "+totalPrice+"%nTotal Point: "+gradePoint+"%nFor more information and for exclusive offers follow us on Instagram%n https://tx.gl/r/cVGp/%23AdvdTrack%23";
                           
                        String contact = "91"+cust_cont;
                        String msgResponse = sendNotification(contact,NewMsg);
                           out.print("<h1>"+msgResponse+"</h1>");
                        }
              }
            }else{
                 out.print("<script type=text/javascript>"
                            + " alert('Order data is not Stores'); window.location = 'index.jsp';</script>");
            }
            }
       }else{
                out.print("<script type=text/javascript>"
                            + " alert('Cart Is Empty'); window.location = 'index.jsp';</script>");
            }
            }catch(Exception e){
                out.println("<h1>"+e.getMessage()+"</h1>");
            }
            
      }
    }
    
    
    public String sendNotification(String number,String Msg){
     try {
			// Construct data
			String apiKey = "apikey=" + "hvtA/CXPEYM-8uzcHwp3j6lsHfbESyZ8R0tQp6PWvP";
			String message = "&message=" + Msg;
			String sender = "&sender=" + "THINKJ";
			String numbers = "&numbers=" + number;
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
