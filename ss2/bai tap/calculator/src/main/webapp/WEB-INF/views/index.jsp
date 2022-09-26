<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 6/27/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>

<form action="/calculator" method="post">
    <input type="number" name="number1" value="number1">
    <input type="number" name="number2" value="number2"> <br>
    <button type="submit" name="operation" value="Addition">Addition(+)</button>
    <button type="submit" name="operation" value="Subtraction">Subtraction(-)</button>
    <button type="submit" name="operation" value="Multiplication">Multiplication(*)</button>
    <button type="submit" name="operation" value="Division">Division(/)</button>

</form>

<div>
    <h4>Result: ${result}</h4>
</body>
</div>

</html>
