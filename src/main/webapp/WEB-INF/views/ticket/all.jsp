<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All tickets</title>
</head>
<body>
<h1>All tickets</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>CardId</th>
        <th>Ticket Status</th>
<%--        <th>CreateTime</th>--%>
<%--        <th>Last Update</th>--%>
<%--        <th>Ticket Message</th>--%>
<%--        <th>Response Message</th>--%>
        <th>Delete</th>
    </tr>
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
<%--            <td>--%>
<%--                <c:out value="${ticket.createTime}"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:out value="${ticket.lastUpdate}"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:out value="${ticket.ticketMessage}"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:out value="${ticket.responseMessage}"/>--%>
<%--            </td>--%>
            <td>
                <a href="${pageContext.request.contextPath}/ticket/delete?id=${ticket.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
