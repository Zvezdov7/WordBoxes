<%--
  Created by IntelliJ IDEA.
  User: Dmitry Zvezdov
  Date: 06.10.17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>WordBoxes</title>
</head>
<body>
<h1>Customers</h1>
<%--<p>${haha}</p>--%>
<c:if test="${not empty customers}">
    <ul>
        <c:forEach var="customer" items="${customers}">
            <li>${customer.getFirstName()}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
