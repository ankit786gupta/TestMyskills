<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success page</title>
</head>
<body>
<%@ include file = "includepage_addsuccess.jsp" %>
<h2>Registration Successful ...</h2>
<h3>Your details :</h3>
Name - ${namevalue}<br>
Email - ${emailvalue}<br>
Company - ${companyvalue}<br>
Salary - ${salaryvalue}<br>
Designation - ${designationvalue}<br>
Id - ${idvalue}<br>
</body>
</html>