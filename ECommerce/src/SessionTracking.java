import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class SessionTracking extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
String pass=req.getParameter("password");

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","minkal");
Statement st=c.createStatement();

ResultSet rs=st.executeQuery("select * from ECOMUSERS where NAME='"+name+"' and PASSWORD='"+pass+"'");
if(rs.next())
{
HttpSession se=req.getSession();

//se.setMaxInactiveInterval(60*60*60);
//out.println(se.getMaxInactiveInterval());
se.setAttribute("name",name);
se.setAttribute("pass",pass);
out.println("User is Valid   - "+se.isNew());
out.println("<br>");
//RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
//rd.forward(req, res);
res.sendRedirect("welcome.jsp");
}
else
out.println("Invalid User");

}catch(Exception e){out.println(e.toString());}
out.println("</body></html>");
}
}