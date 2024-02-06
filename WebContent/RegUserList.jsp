<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<title>E-Learning Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #000000">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> 
					 E-Learning </a>
			</div>
<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/adminLogin"
					class="nav-link">Admin Login</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		

		<div class="container">
			<h3 class="text-center">List of Registered Users</h3>
			<hr>
			<br>
			
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*,java.util.*"%>

<%
try {
	Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainingPrDb","root","root123");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
ResultSet resultSet1=null;
%>


<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr >
<td><b>User ID</b></td>
<td><b>User Name</b></td>
<td><b>Phone No.</b></td>
<td><b>Email</b></td>
<td><b>Address</b></td>
<td><b>Registration Date</b></td>

</tr>
<%
try{
Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainingPrDb","root","root123");
Statement st=connection1.createStatement();
/* String name=(String)session.getAttribute("username");
System.out.println(name);
String name1="'"+name+"'";
System.out.println(name1);
int i=st.executeUpdate("update StudentDetails set course=' JAVA'  where username="+name1); */
statement=connection1.createStatement();
String sql ="SELECT * FROM user1";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>
<tr >
<td><%=resultSet.getString("user_id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("phone_no") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("reg_date") %></td>

<%
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<br><br>
</div>
		</div>
			
</body>
</html>
