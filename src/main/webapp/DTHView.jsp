<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DTHController">
	<label for="option">Select DTH Operator: </label>
	<select name="operator" id="sub">
            <option value="Airtel Digital Tv">Airtel Digital TV</option>
            <option value="TataSky">TataSky</option>
            <option value="D2h">D2h</option>
            <option value="Dish TV">Dish TV</option>
        </select>
        <br/>
        <br/>
        <input type="text" name="consumerNo" placeholder="Enter Consumer Number"/>
        <input type="text" name="amt" placeholder="Enter Amount"/>
         <br/>
        <br/>
        <input type="submit" value="Submit"/>
	</form>
</body>
</html>