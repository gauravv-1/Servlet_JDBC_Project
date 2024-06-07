<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In Page</title>


<!-- Main css -->
<link rel="stylesheet" href="css/LoginViewCSS.css">
</head>
<body>

	<div class="login-form">
		<h1>Welcome to Linkcode Bank Application</h1>
		<div class="container">
			<div class="main">
				<div class="content">
					<h2>Log In</h2>
					<%
					String errorMessage = (String) request.getAttribute("errorMessage");
					if (errorMessage != null) {
					%>
					<p style="color: red; text-align: center;"><%=errorMessage%></p>
					<%
					}
					%>
					<%
					String sucessMessage = (String) request.getAttribute("sucessMessage");
					if (sucessMessage != null) {
					%>
					<p style="color: green; text-align: center;"><%=sucessMessage%></p>
					<%
					}
					%>
					<form action="LoginController">
						<input type="text" name="uname" placeholder="User Name" required>
						<input type="password" name="password" placeholder="User Password"
							required>
						<button class="btn" type="submit">Login</button>

					</form>
					<p class="account">
						Don't Have An Account? <a href="Register.jsp">Register</a>
					</p>

				</div>
				<div class="form-img">
					<img src="./images/BankLogo.png" alt="">
				</div>
			</div>
		</div>
	</div>
</body>

</html>