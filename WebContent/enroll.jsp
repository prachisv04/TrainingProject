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
				<a href="https://www.javaguides.net" class="navbar-brand">E-Learning </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Admin Login</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<%@page import="com.prachi.training.model.Course"%>
	
		<h4 class="text-center text-warning">"Enroll For Course:<%Course name=(Course)request.getAttribute("course");%>
		<%= name.getC_name() %>"
		</h4>
	<hr>
	<a href="<%=request.getContextPath()%>/new" class="btn btn-danger">New User?? Signup First</a>
	<div class="container col-md-5">
	
		<div class="card">
			<h4 class="card-title text-center bg-dark text-white">EnrollMent for course</h4>
			<div class="card-body">
				<form class="form" method="post" action="<%=request.getContextPath()%>/enrollinsert">
						<label>Course Id</label>
						<input type="text" class="form-control" name="Cid" value="<%= name.getCourse_id()%>">
						<label>User Id</label>
                       <input type="text" class="form-control" name="Uid">
                       <label>Password</label>
                       <input type="text" class="form-control" name="pwd">
                     <label>mail</label>
                       <input type="text" class="form-control" name="mail">
                       <label>payment</label>
                       <input type="text" class="form-control" name="payment">
                       <br>
                        <input type="submit" class="btn btn-dark btn-block " value="submit">
                   </form>
				
			</div>
		</div>
	</div>
</body>
</html>
