<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%!String message = "Java is best";%>
	<%!Date date = new Date();%>
	<%
		for (int i = 0; i <= 10; i++) {
			//	out.println(message);
	%>

	<h3>JSP is Simple</h3>
	<%=message%>
	<%=date%>
	<%
		}
	%>

</body>
</html>