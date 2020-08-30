<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="">
<%@ page session = "false" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*,java.io.*,java.sql.*,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.Transaction,org.hibernate.cfg.Configuration,com.minkal.*" %>
<title>Ecommerce</title>

</head>
<body>
<script src=""></script>
<% 
HttpSession session=request.getSession(false);
//out.println(session);
if(session!=null){
	
   
	String name=(String)session.getAttribute("name");
	
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","minkal");
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery("Select * from ECOMUSERS where name="+"'"+name+"'");

	while(rs.next())
	{ 
	out.println("Name:"+rs.getString("NAME"));
	out.println("</br> "+"Email:"+rs.getString("email"));
	//out.println("</br> "+rs.getString("password"));
	System.out.println();
	}
	}catch(Exception e){out.println(e.toString());}
	
	
	
   
    }
	

%>

</body>
</html>