<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.payment.model.enums.BillStatus" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>All bills</title>
</head>
<body class="container">
<jsp:include page="../menu.jsp"/>
<h1>All bills</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Sender Card Id</th>
        <th>Recipient Card Id</th>
        <th>Payment</th>
        <th>Bill Status</th>
        <th>Delete</th>
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
                <c:out value="${BillStatus.getBillStatus(bill)}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/bill/delete?id=${bill.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
