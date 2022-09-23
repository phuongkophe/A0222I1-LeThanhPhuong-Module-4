<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 9/23/2022
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<html>
<head>
    <title>Convert Currency</title>
</head>
<body>
<form method="post" action="/convert">
    <label>Enter USD</label>
    <input name="usd" placeholder="Input usd">
    <label>Enter exchange rate</label>
    <input name="exchangeRate" placeholder="Input exchange rate">
    <button type="submit">Convert</button>
</form>
<div>
    <c:if test="${vnd !=null}">
        <h1>Result: </h1>
        <h2>${usd} USD is: ${vnd} VND</h2>
    </c:if>
</div>
</body>
</html>
