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
				<a href="https://www.javaguides.net" class="navbar-brand"> E-Learning </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<h4 class="card-title text-center bg-dark text-white">New User Course</h4>
			<div class="card-body">
				<form class="form" method="post" action="<%=request.getContextPath()%>/insertCourse">
                       <label>Course Id</label>
                       <input type="text" class="form-control" name="id">
                       <label>Course Name</label>
                       <input type="text" class="form-control" name="nm">
                       <label>Course description</label>
                       <input type="text" class="form-control" name="des">
                       <label>Fees</label>
                       <input type="text" class="form-control" name="fee">
                       <label>Resources</label>
                       <input type="text" class="form-control" name="rsrc"><br>
                       
                        <input type="submit" class="btn btn-dark btn-block " value="submit">
                   </form>
				
			</div>
		</div>
	</div>
</body>
</html>
