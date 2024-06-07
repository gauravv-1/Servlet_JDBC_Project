<%@page import="bank.model.Recharge"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="ConfirmRechargeDetailsStyle.css">
</head>
<body>
    <div class="container">
        <%
            Recharge rech = (Recharge)session.getAttribute("rechDetails");
        %>
        <div class="recharge-info">
            Mobile Number: <%= rech.getMobNo() %><br>
            Service Provider: <%= rech.getServiceProvider() %><br>
            Amount: <%= rech.getRechAmt() %>
        </div>
        
        <a href="RechargeBillController" class="confirm-link">Confirm</a>
    </div>
</body>
</html>
