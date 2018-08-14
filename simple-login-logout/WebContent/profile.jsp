<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.sql.*,com.main.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body>
		<div class="box">
		<h1 style="text-align:center; color:#8B008B;">User Logged In</h1>
			<div class="sub">
				<% 
					String id=null;
					String name=null;
					String email=null;
					String gender=null;
					String dob=null;
					
					id=(String)request.getSession().getAttribute("id");
					
					if(id!=null){
					Statement st=JConnect.getStatement();
					ResultSet rs=st.executeQuery("select * from user where email='"+id+"'");
					if(rs.next()){
						name=rs.getString("name");
						email=rs.getString("email");
						gender=rs.getString("gender");
						dob=rs.getString("dob");
					}
					}else{
						response.sendRedirect("login.jsp");
					}
				%>
				<h5><%=name%></h5>
				<h5><%=email%></h5>
				<h5<%=gender%>></h5>
				<h5><%=dob%></h5>
				<a href="logout">LOGOUT</a>
			</div>
		</div>
	</body>
</html>