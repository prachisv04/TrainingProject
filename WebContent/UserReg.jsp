<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>contact</td>
     <td><input type="text" name="phone_no" /></td>
    </tr>
    <tr>
     <td>mail</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>address</td>
     <td><input type="password" name="address" /></td>
    </tr>
    <tr>
     <td>reg date</td>
     <td><input type="text" name="reg_date" /></td>
    </tr>
    <tr>
     <td>Password No</td>
     <td><input type="text" name="password" /></td>
    </tr>
    <tr>
     <td>Photo</td>
     <td><input type="text" name="upload_photo" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>