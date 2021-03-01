<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>All bills</title>
</head>
<body class="container">
<jsp:include page="../menu.jsp"/>
<h1>My bills</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Sender Card Id</th>
        <th>Recipient Card Id</th>
        <th>Payment</th>
        <th>Bill Status</th>
    </tr>
    </thead>
    <tbody>
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
                <c:choose>
                    <c:when test="${bill.billStatusId == 0}">
                        <c:out value="PREPARED"/>
                    </c:when>
                    <c:when test="${bill.billStatusId == 1}">
                        <c:out value="SENT"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="REJECTED"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
