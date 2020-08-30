import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Registration extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
out.println("<style>"
		+ "body{"
		+ "background:#34495e;"
		+ "}"
		+ "h1,h1 a{"
		+ "text-align:center;"
		+ "color:white;}"
		+ "</style>");
String email=req.getParameter("email");
String name=req.getParameter("name");
String password=req.getParameter("password");
//out.println(email);
//out.println(name);
//out.println(password);
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","minkal");
Statement st=c.createStatement();

int a=st.executeUpdate("insert into ECOMUSERS values('"+name+"'," +"'"+email +"',"+"'"+password+"')");
out.println("<h1>Registered Succesfully<br/>");
out.println("<a href='login.html'>Click here to Login</a></h1>");
}catch(Exception e){out.println(e.toString());}
out.println("</body></html>");
}
}