<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
			<h3 class="text-center">Feedback from users</h3>
			<hr>
			
			
	 <div>
        <table border="1" cellpadding="5">
            
            <tr>
                <th><b>User ID</b></th>
				<th><b>User Name</b></th>
				<th><b>email</b></th>
				<th><b>Feedback</b></th>
				
            </tr>
            <c:forEach var="book" items="${listUser}">
                <tr>
                    <td><c:out value="${book.user_id}" /></td>
                    <td><c:out value="${book.name}" /></td>
                    <td><c:out value="${book.email}" /></td>
                    <td><c:out value="${book.feedbadck}" /></td>
                </tr>
            </c:forEach>
        </table>
  </div>
</body>
</html>
