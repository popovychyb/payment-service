<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All bills</title>
</head>
<body>
<h1>All bills</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Sender Card Id</th>
        <th>Recipient Card Id</th>
        <th>Payment</th>
        <th>Bill Status</th>
        <th>Create Time</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="bill" items="${bills}">
        <tr>
            <td>
                <c:out value="${bill.id}"/>
            </td>
            <td>
                <c:out value="${bill.senderCardId}"/>
            </td>
            <td>
                <c:out value="${bill.recipientCardId}"/>
            </td>
            <td>
                <c:out value="${bill.payment}"/>
            </td>
            <td>
                <c:out value="${bill.billStatus}"/>
            </td>
            <td>
                <c:out value="${bill.createTime}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/bill/delete?id=${bill.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
