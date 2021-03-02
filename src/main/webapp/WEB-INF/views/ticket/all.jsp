<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.payment.model.enums.TicketStatus" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>All tickets</title>
</head>
<body class="container">
<jsp:include page="../menu.jsp"/>
<h1>All tickets</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>CardId</th>
        <th>Ticket Status</th>
        <th>Consider</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ticket" items="${tickets}">
        <tr>
            <td>
                <c:out value="${ticket.id}"/>
            </td>
            <td>
                <c:out value="${ticket.cardId}"/>
            </td>
            <td>
                <c:out value="${TicketStatus.getTicketStatus(ticket)}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/ticket/decline?id=${ticket.id}">
                    Decline </a>
                <a href="${pageContext.request.contextPath}/ticket/approve?id=${ticket.id}">
                    Approve</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/ticket/delete?id=${ticket.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
