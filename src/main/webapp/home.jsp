<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
</style>

</head>
<body>
	<div class="container" id="container">
		<h1>Employee Details !!!</h1>
		<c:if test="${employeeType == 'admin'}">
			<table>
			  <tr>
			    <th>Employee Id</th>
			    <th>Name</th>
			    <th>Leaves Available</th>
			    <th>Leaves Taken</th>
			    <th>Leaves Remaining</th>
			  </tr>
			  <c:forEach items="${employees}" var="employee">
					<tr>
					    <td>${employee.getEmpId()}</td>
					    <td>${employee.getEmpName()}</td>
					    <td>${employee.getLeavesAvailable()}</td>
					    <td>${employee.getLeavesTaken()}</td>
					    <td>${employee.getLeavesRemaining()}</td>
					</tr>
				</c:forEach>
			</table>
		
			<form action="/addEmployee">
				<input type="number" name="empId" id="empId"><br>
				<input type="text" name="empName" id="empName"><br>
				<input type="submit" name="${employeeType}"><br>
			</form>
		</c:if>
		
		<c:if test="${employeeType == 'user'}">
			<table>
			  <tr>
			    <th>Employee Id</th>
			    <th>Name</th>
			    <th>Leaves Available</th>
			    <th>Leaves Taken</th>
			    <th>Leaves Remaining</th>
			    <th></th>
			  </tr>
			  <tr>
			    <td>${employee.getEmpId()}</td>
			    <td>${employee.getEmpName()}</td>
			    <td>${employee.getLeavesAvailable()}</td>
			    <td>${employee.getLeavesTaken()}</td>
			    <td>${employee.getLeavesRemaining()}</td>
			    <td><button><a href="http://localhost:8080/applyLeave?empId=${employee.getEmpId()}">apply leave</a></button></td>
			  </tr>
			</table>
		</c:if>
	</div>
</body>
<script type="text/javascript">

</script>
</html>