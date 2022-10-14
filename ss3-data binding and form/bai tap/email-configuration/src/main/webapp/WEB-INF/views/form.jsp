<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 7/4/2022
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form action="/save" method="post" modelAttribute="emailBox">
    <table>
        <tr>
            <td><form:label path="language">Language: </form:label></td>
            <td>
                <form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size:</form:label></td>
            <td>
                Show <span>
          <form:select path="pageSize">
              <form:option value="5">5</form:option>
              <form:option value="10">10</form:option>
              <form:option value="15">15</form:option>
              <form:option value="25">25</form:option>
              <form:option value="50">50</form:option>
              <form:option value="100">100</form:option>
          </form:select>
        </span> emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spams filter</form:label></td>
            <td><form:checkbox path="spamFilter"></form:checkbox></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <br/>
        <tr>
            <td><form:button type="submit">Update</form:button></td>
            <td><form:button type="reset">Cancel</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
