<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/RegistrationViewCSS.css">
</head>
<body>


	<div class="login-form">

		<div class="container">
			<div class="main">
				<div class="content">
					<h2>Register</h2>
					<form action="RegisterController">
						<input type="text" name="fName" placeholder="First Name" required>
						<input type="text" name="lName" placeholder="Last Name"
							required>
							 <input type="text" name="uname"
							placeholder="Userame" required>
							 <input type="text"
							name="password" placeholder="Password" required>
							 <input
							type="text" name="accNo" placeholder="Account Number" required>
							<input
							type="text" name="accBal" placeholder="Account Balance" required>
						

						<button class="btn" type="submit">Register</button>

					</form>
					<p class="account">
						Already have an Account? <a href="login.jsp">LogIn</a>
					</p>

				</div>
				<div class="form-img">
				
					
					<img src="./images/signup.jpg" alt="">
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>