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

	<%@page import="com.prachi.training.model.Course"%>
	
		<h4 ><%Course name=(Course)request.getAttribute("course");%>
		<%= name.getC_name() %>
		</h4>
	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<h4 class="card-title text-center bg-dark text-white">UpdateCourse</h4>
			<div class="card-body">
				<form class="form" method="post" action="<%=request.getContextPath()%>/updateClick">
                       <label>Course Id</label>
                       <input type="text" class="form-control" name="id" value="<%= name.getCourse_id()%>">
                       <label>Course Name</label>
                       <input type="text" class="form-control" name="nm" value="<%= name.getC_name()%>">
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
