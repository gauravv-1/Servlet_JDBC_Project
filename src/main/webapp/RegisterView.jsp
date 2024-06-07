<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="RegisterViewStyle.css">
</head>
<body>
	<h2>Register Here</h2>
	<form action="RegisterController">

		First Name:<input type="text" name="fName">
		Last Name: <input type="text" name="lName">
		UserName: <input type="text" name="uname">
		Password:<input type="text" name="password">
		Account Number: <input type="text" name="accNo">
		Account Balance: <input type="text" name="accBal">
		<input type="submit" value="Regsiter">
		
	</form>
</body>
</html>