<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container" id="container">
		<h3>Login</h3>
		<form action="login">
			<input type="number" id="empId" name="empId"><br>
			<input type="text" id="empName" name="empName"><br>
			<input type="submit">
		</form>
	</div>
</body>
</html>