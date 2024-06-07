<%@page import="java.util.List"%>
<%@page import="bank.model.RechargeBill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        width: 100%;
        max-width: 600px;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        height: 80vh; /* Set a height to enable scrolling */
    }
    .transactions {
        flex: 1;
        overflow-y: auto;
        padding: 20px;
    }
    .transaction {
        display: flex;
        justify-content: space-between;
        padding: 16px;
        border-bottom: 1px solid #eee;
    }
    .transaction:last-child {
        border-bottom: none;
    }
    .transaction-details {
        display: flex;
        flex-direction: column;
    }
    .txn-id {
        font-size: 14px;
        color: #999;
    }
    .txn-amt {
        font-size: 18px;
        color: #333;
        margin-top: 4px;
    }
    .txn-acc-no {
        font-size: 14px;
        color: #666;
        margin-top: 2px;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        font-weight: bold;
        text-align: center;
        text-decoration: none;
        color: #fff;
        background-color: #4CAF50;
        border-radius: 8px;
        transition: background-color 0.3s, transform 0.3s;
        cursor: pointer;
        margin-top: 20px;
    }
    .btn:hover {
        background-color: #45a049;
        transform: scale(1.05);
    }
    .btn:active {
        background-color: #3e8e41;
        transform: scale(0.95);
    }
    .btn-container {
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 -2px 4px rgba(0,0,0,0.1);
        position: sticky;
        bottom: 0;
        display: flex;
        justify-content: center;
        width: 100%;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="transactions">
        <%
        List<RechargeBill> rTxns = (List<RechargeBill>) session.getAttribute("TxnsDetails");

        if (rTxns != null && !rTxns.isEmpty()) {
            for (RechargeBill rTxn : rTxns) {
        %>
        <div class="transaction">
            <div class="transaction-details">
                <div class="txn-id">Txn Id: <%= rTxn.getTxnId() %></div>
                <div class="txn-amt">Amount: <%= rTxn.getTxnAmt() %></div>
                <div class="txn-acc-no">To Consumer: <%= rTxn.getTxnMobNo() %></div>
                <div class="txn-acc-no">Transaction Date: <%= rTxn.getTxnDate() %></div>
                <div class="txn-acc-no">From Account No: <%= rTxn.getTxnAccNo() %></div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="transaction">
            <div class="transaction-details">
                No transactions found.
            </div>
        </div>
        <%
        }
        %>
        </div>
        <div class="btn-container">
            <a href="DashboardView.jsp" class="btn">Go to Dashboard</a>
        </div>
    </div>
</body>
</html>
