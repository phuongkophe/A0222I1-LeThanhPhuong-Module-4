<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/31/2022
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/create" method="post" modelAttribute="student">
    <label>Code student</label>
    <form:input path="codeStudent" type="text" name="codeStudent"/><br>
    <label>Name student</label>
    <form:input path="nameStudent" type="text" name="nameStudent"/><br>
    <label>Point</label>
    <form:input path="point" type="text" name="point"/><br>
    <label>Gender</label>
<%--    <form:input path="gender" type="text" name="gender"/><br>--%>
<%--    <form:select path="gender">--%>
<%--        <form:options items="${listGender}"></form:options>--%>
<%--    </form:select>--%>
    <form:radiobuttons path="gender" items="${listGender}"></form:radiobuttons>
    <button type="submit">Create</button>
</form:form>
</body>
</html>
