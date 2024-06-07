
<%@page import="bank.model.Register"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="DashboardStyle.css">
</head>
<body>
<%
	Register r = (Register)session.getAttribute("loginInfo");
	%>
    <div class="dashboard">
        <div class="card">
            <h2>Profile</h2>
            <p>Welcome <%= r.getfName() %> <%=r.getlName() %></p>
            <a href="ProfileView.jsp" class="button">View Profile</a>
            <a href="LogoutController" class="buttonLogout">LogOut</a>
        </div>
        <div class="card">
            <h2>Recharge</h2>
            <p>Recharge Your Mobile</p>
            <a href="RechargeView.jsp" class="button">Recharge</a>
        </div>
        <div class="card">
            <h2>Fund Transfer</h2>
            <p>Tranfer Funds to Friends</p>
            <a href="TransferView.jsp" class="button">Transfer Funds</a>
        </div>
         <div class="card">
            <h2>DTH REcharge</h2>
            <p>Transactions Details</p>
            <a href="DTHView.jsp" class="button">View Statements</a>
        </div>
        <div class="card">
            <h2>Bank Statements</h2>
            <p>Transactions Details</p>
            <a href="StatementController" class="button">View Statements</a>
        </div>
    </div>
</body>
</html>


