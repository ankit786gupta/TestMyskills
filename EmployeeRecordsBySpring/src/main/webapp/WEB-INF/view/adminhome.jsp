<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style>
body {
	background-image:
		url(WEB-INF/webstuff/samantha-gades-BlIhVfXbi9s-unsplash.jpg);
	background-size: 1350px 610px;
}

div.relative {
	position: relative;
	font-size: 25px;
	font-weight: bold;
	top: 5px;
	left: 0;
}

div.absolute {
	color: red;
	position: absolute;
	font-size: 25px;
	top: 5px;
	position: absolute;
	right: 500px;
}

.topnav {
	position: relative;
	top: 28px;
	overflow: hidden;
	background-color: black;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: grey;
	color: black;
}

a:link {
	text-decoration: none;
}
</style>

</head>
<body>
	<div class="relative">
		Admin Forum
		<div class="absolute">${message}</div>
	</div>

	<!--  Navigation Tag -->

	<nav class="topnav">
		<a class="active" href="admin_addemployee">ADD EMPLOYEE |</a> <a
			href="viewemp">VIEW EMPLOYEE |</a> <a href="logout">LOGOUT |</a>
	</nav>

</body>
</html>