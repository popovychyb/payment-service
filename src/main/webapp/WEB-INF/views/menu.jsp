<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
    <a href="${pageContext.request.contextPath}/" class="nav-link">Home</a>
    <c:choose>
        <c:when test="${sessionScope.user_role_id == 0}">
            <c:out value="admin panel: "/>
            <br>
            <a href="${pageContext.request.contextPath}/user/all" class="nav-link">Users</a>
            <br>
            <a href="${pageContext.request.contextPath}/card/all" class="nav-link">Cards</a>
            <br>
            <a href="${pageContext.request.contextPath}/bill/all" class="nav-link">Bills</a>
            <br>
            <a href="${pageContext.request.contextPath}/ticket/all" class="nav-link">Tickets</a>
        </c:when>
        <c:otherwise>
            <c:out value="user panel: "/>
            <br>
            <a href="${pageContext.request.contextPath}/card/allByUser" class="nav-link">Cards</a>
            <br>
            <a href="${pageContext.request.contextPath}/ticket/allByUser" class="nav-link">Tickets</a>
            <br>
            <a href="${pageContext.request.contextPath}/bill/allByUser" class="nav-link">Bills</a>
        </c:otherwise>
    </c:choose>
    <br>
    <a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a>
</nav>
