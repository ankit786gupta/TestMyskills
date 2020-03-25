<%@page import="com.employeedata.pojo.EmpDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees List</title>
</head>
<body>
	<%@ include file="includepage_viewform_admin.jsp"%>
	<h2 align="center">View Employee list</h2>
	<form action="employee_search" method = "post">
	<input type = "text" name = "freetext" placeholder = "search employee">
	<input type = "submit" value = "search">
	</form><br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Company</th>
			<th>Salary</th>
			<th>Designation</th>
			<th>ID</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${command}">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.email}</td>
				<td>${emp.company}</td>
				<td>${emp.salary}</td>
				<td>${emp.designation}</td>
				<td>${emp.id}</td>
				<td><a href="edit/${emp.id}">Edit</a></td>
				<td><a href="delete/${emp.id}">Delete</a></td>
			</tr>
</c:forEach>
	</table>
	<hr>
</body>
</html>