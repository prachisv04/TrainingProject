<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>User Management Application</title>
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
		
			<%@page import="com.prachi.training.model.User"%>

		<div class="container">
		
					<h3 class="text-center">"Welcome <%User name=(User)request.getAttribute("listUser"); %>
					<%= name.getName()%>"
			</h3><br>
			<h5 class="text-left"><a href="<%=request.getContextPath()%>/feedback" class="btn btn-danger">Give Feedback</a></h5>
			
			<hr>
			<div class="container text-center">
					<h4 class="text-warning text-center">List of Registered Courses</h4>
			</div>
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
<td><b>Course ID</b></td>
<td><b>Course Name</b></td>
<td><b>Course Description</b></td>
<td><b>Course resources</b></td>


</tr>

<%
try{
Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainingPrDb","root","root123");

/* String name=(String)session.getAttribute("username");
System.out.println(name);
String name1="'"+name+"'";
System.out.println(name1);
int i=st.executeUpdate("update StudentDetails set course=' JAVA'  where username="+name1); */
String sql ="select * from course where course_id in (select courseId from enrollinfo where userId= ?);";

//Step 2:Create a statement using connection object
PreparedStatement preparedStatement = connection1.prepareStatement(sql); 
preparedStatement.setInt(1, name.getUser_id());
System.out.println(preparedStatement);
// Step 3: Execute the query or update query
resultSet = preparedStatement.executeQuery();
System.out.println(resultSet);
while(resultSet.next()){
%>
<tr >
<td><%=resultSet.getString("course_id") %></td>
<td><%=resultSet.getString("c_name") %></td>
<td><%=resultSet.getString("c_desp") %></td>
<td><%=resultSet.getString("c_fees") %></td>

</tr>

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
