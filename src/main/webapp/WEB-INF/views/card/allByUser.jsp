<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.payment.model.enums.ActivityStatus" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>User Cards</title>
</head>
<body class="container">
<jsp:include page="../menu.jsp"/>
<h1>My cards</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>Balance</th>
        <th>Title</th>
        <th>Status</th>
        <th>Block</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="card" items="${cards}">
        <tr>
            <td>
                <c:out value="${card.id}"/>
            </td>
            <td>
                <c:out value="${card.number}"/>
            </td>
            <td>
                <c:out value="${card.balance}"/>
            </td>
            <td>
                <c:out value="${card.title}"/>
            </td>
            <td>
                <c:out value="${ActivityStatus.getActivityStatus(card)}"/>
            </td>
            <td>
                <c:choose>
                    <c:when test="${ActivityStatus.getActivityStatus(card) == ActivityStatus.ACTIVE}">
                        <a href="${pageContext.request.contextPath}/card/block?id=${card.id}">Block</a>
                    </c:when>
                    <c:when test="${ActivityStatus.getActivityStatus(card) == ActivityStatus.CONSIDERATION}">
                        Request sent
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/ticket/create?id=${card.id}">Request unblock</a>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/card/delete?id=${card.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
