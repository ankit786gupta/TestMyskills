<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit details</title>
</head>
<body>
	<%@ include file="includepage_editform_admin.jsp"%>
	<h2 align="center">Edit Details</h2>
	<form action="editsave" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value="${command.name}"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" value="${command.email}"></td>
			</tr>
			<tr>
				<td>Company :</td>
				<td><input type="text" name="company"
					value="${command.company}"></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" value="${command.salary}"></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><input type="text" name="designation"
					value="${command.designation}"></td>
			</tr>
			<tr>
				<td>ID :</td>
				<td><input style="background-color: #bab5b5;" type="text"
					name="id" value="${command.id}" readonly></td>
			</tr>
		</table>
		<br> <input type="submit" value="Edit form">
	</form>
</body>
</html>