<%--
  Created by IntelliJ IDEA.
  User: Phuong
  Date: 7/4/2022
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${mess != null}">
    ${mess}
</c:if>
<h1>${emailBox.language}</h1>
<h1>${emailBox.pageSize}</h1>
<h1>${emailBox.spamFilter}</h1>
<h1>${emailBox.signature}</h1>
</body>
</html>
