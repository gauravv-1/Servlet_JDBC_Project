<%@page import="bank.model.Register"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
<link rel="stylesheet" type="text/css" href="ProfileViewStyle.css">
</head>
<body>
    <div class="container">
        <%
            Register r = (Register)session.getAttribute("loginInfo"); 
        %>
        <h1>My Profile</h1>
        <div class="profile-info">
            <p><strong>First Name:</strong> <%= r.getfName() %></p>
            <p><strong>Last Name:</strong> <%= r.getlName() %></p>
            <p><strong>Account Number:</strong> <%= r.getAccNo() %></p>
            <p><strong>Account Balance:</strong> <%= r.getAccBal() %></p>
            <p><strong>User Name:</strong> <%= r.getUname() %></p>
            <div>Change Password <a href="ChangePasswordView.jsp">Click Here</a></div>
        </div>
        
        <a href="DashboardView.jsp" class="go-to-dashboard">Go to Dashboard</a>
    </div>
</body>
</html>
