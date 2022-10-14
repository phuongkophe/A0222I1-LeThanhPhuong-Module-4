<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 9/26/2022
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <input type="checkbox" name="condiment" value="Lecture">Lecture
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <br>
    <input type="submit" value="Save">
</form>

<div>
    <c:if test="${listChoice != null}">
        Selected condiment(s):
        <c:forEach items="${listChoice}" var="item">
            <br>${item}
        </c:forEach>
    </c:if>
</div>
</body>
</html>
