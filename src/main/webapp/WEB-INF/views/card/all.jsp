<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All cards</title>
</head>
<body>
<h1>All cards</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>IdUser</th>
        <th>Balance</th>
<%--        <th>Expiry</th>--%>
        <th>Title</th>
<%--        <th>Cvv2</th>--%>
<%--        <th>PinCode</th>--%>
<%--        <th>Currency</th>--%>
        <th>Status</th>
<%--        <th>CreateTime</th>--%>
        <th>Block/Unblock</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="card" items="${cards}">
        <tr>
            <td>
                <c:out value="${card.id}"/>
            </td>
            <td>
                <c:out value="${card.number}"/>
            </td>
            <td>
                <c:out value="${card.idUser}"/>
            </td>
            <td>
                <c:out value="${card.balance}"/>
            </td>
<%--            <td>--%>
<%--                <c:out value="${card.expiry}"/>--%>
<%--            </td>--%>
            <td>
                <c:out value="${card.title}"/>
            </td>
<%--            <td>--%>
<%--                <c:out value="${card.cvv2}"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:out value="${card.pinCode}"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:out value="${card.currency}"/>--%>
<%--            </td>--%>
            <td>
                <c:choose>
                    <c:when test="${card.activityStatusId == 1}">
                        <c:out value="ACTIVE"/>
                    </c:when>
                    <c:when test="${card.activityStatusId == 2}">
                        <c:out value="BLOCKED"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="CONSIDERATION"/>
                    </c:otherwise>
                </c:choose>
            </td>
<%--            <td>--%>
<%--                <c:out value="${card.createTime}"/>--%>
<%--            </td>--%>
            <td>
                <a href="${pageContext.request.contextPath}/card/block?id=${card.id}">
                    Block/Unblock</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/card/delete?id=${card.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
