<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 6/24/2022
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<form action=/translate method="post">
    <label>Enter word you want to translate</label>
    <input type="text" placeholder="Input English word" name="englishWord">
    <button type="submit">Translate</button>
</form>
</body>
</html>
