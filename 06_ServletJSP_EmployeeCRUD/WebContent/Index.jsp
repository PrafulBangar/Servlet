<%@page import="com.jlt.dao.EmployeeDao"%>
<%@page import="com.jlt.controller.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD Home</title>
</head>
<body>
	<h3>Employee CRUD Home</h3>
	<hr>
	<form action="EmployeeCRUDServLet" method="post">
		<table border="1">
			<tr>
				<td>Employee Id</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Salary</td>
				<td>Email</td>
				<td>Action</td>
			</tr>
			<%!List<Employee> employeeList;%>
			<%
				employeeList = new EmployeeDao().getAllEmployees();
				for (Employee employee : employeeList) {
			%>
			<tr>
				<td><%=employee.getEmployeeId()%></td>
				<td><%=employee.getFirstName()%></td>
				<td><%=employee.getLastName()%></td>
				<td><%=employee.getSalary()%></td>
				<td><%=employee.getEmail()%></td>
				<td><input type="radio" name="dbAction"
					value="<%=employee.getEmployeeId()%>"></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="6"><input type="submit" value="Add Employee"
					name="option"> &nbsp;&nbsp;&nbsp; <input type="submit"
					value="Update" name="option"> &nbsp;&nbsp;&nbsp; <input
					type="submit" value="Delete" name="option">
			</tr>


		</table>
	</form>

</body>
</html>