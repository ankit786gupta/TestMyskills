<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<%@ include file="includepage_empform.jsp"%>
	<h2>Registration Form</h2>
	<form method="post" action="savedata">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" placeholder="Enter name"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"
					placeholder="Enter email id"></td>
			</tr>
			<tr>
				<td>Company :</td>
				<td><input type="text" name="company"
					placeholder="Enter company name"></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" placeholder="Enter salary"></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><input type="text" name="designation"
					placeholder="Enter designation"></td>
			</tr>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id" placeholder="Enter id"
					required></td>
			</tr>
		</table>
		<br> <input type="submit" value="submit form">
	</form>
</body>
</html>