<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration user</title>
</head>
<body>
<h1>Registration</h1>

<h4 style="color:red">${message}</h4>

<form method="post" action="${pageContext.request.contextPath}/registration">
    First Name: <input type="text" name="firstName">
    <br>
    Last Name: <input type="text" name="lastName">
    <br>
    Email: <input type="text" name="email">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    Password: <input type="password" name="pwd-repeat">
    <br>
    <button type="submit">Register</button>
</form>
</body>
</html>
