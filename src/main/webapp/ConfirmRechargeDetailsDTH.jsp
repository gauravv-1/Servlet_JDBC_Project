<%@page import="bank.model.DTHRecharge"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <div class="container">
        <%
            DTHRecharge rechDTH = (DTHRecharge)session.getAttribute("rechDetailsDTH");
        %>
        <div class="recharge-info">
            Consumer Number: <%= rechDTH.getOperator() %><br>
            Service Provider: <%= rechDTH.getConsumerNo() %><br>
            Amount: <%= rechDTH.getAmt() %>
        </div>
        
        <a href="RechargeBillControllerDTH" class="confirm-link">Confirm</a>
    </div>
</body>
</html>