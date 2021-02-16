<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1>All users</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Status</th>
        <th>Create time</th>
        <th>Change role</th>
        <th>Delete</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.firstName}"/>
            </td>
            <td>
                <c:out value="${user.lastName}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:out value="${user.role}"/>
            </td>
            <td>
                <c:out value="${user.status}"/>
            </td>
            <td>
                <c:out value="${user.createTime}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/block?id=${user.id}">
                    Block/Unblock</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/role?id=${user.id}">
                    Admin/User</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
