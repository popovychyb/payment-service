<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>All tickets</title>
</head>
<body class="container">
<jsp:include page="../menu.jsp"/>
<h1>My tickets</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>CardId</th>
        <th>Ticket Status</th>
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
                <c:choose>
                    <c:when test="${ticket.ticketStatusId == 0}">
                        <c:out value="NEW"/>
                    </c:when>
                    <c:when test="${ticket.ticketStatusId == 1}">
                        <c:out value="APPROVED"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="DECLINED"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
