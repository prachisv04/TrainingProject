<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>E-Learning  Application</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> E-Learning  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Admin Login</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card mt-100">
		<h4 class="card-title text-center bg-dark text-white"> User Login</h4>
			<div class="card-body">
				<form class="form" method="post" action="<%=request.getContextPath()%>/userLoginClick">
                       <label>Email</label>
                       <input type="email" class="form-control" name="email"><br>
                       <label>password</label><br>
                       <input type="password" class="form-control" name="pwd"><br>
                        <input type="submit" class="btn btn-dark btn-block " value="login">
                   </form>
				
			</div>
		</div>
	</div>
</body>
</html>
