<%@page import="bank.model.RechargeBill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recharge Success</title>
<link rel="stylesheet" type="text/css" href="RechargeTxnView.css">
</head>
<body>
    <div class="container">
        <%
            RechargeBill rechBill = (RechargeBill)session.getAttribute("RechTxn");
        %>
        <h1>Recharge Successful!!</h1>
        <div class="recharge-info">
            <h3>Transaction Id: <%= rechBill.getTxnId() %></h3>
            <h3>Account No: <%= rechBill.getTxnAccNo() %></h3>
            <h3>Amount: <%= rechBill.getTxnAmt() %></h3>
            <h3>Mobile Number: <%= rechBill.getTxnMobNo() %></h3>
            <h3>Service Provider: <%= rechBill.getTxnServiceProvider() %></h3>
            <h3>Date: <%= rechBill.getTxnDate() %></h3>
        </div>
        
        <a href="DashboardView.jsp" class="go-to-dashboard">Go to Dashboard</a>
    </div>
</body>
</html>
