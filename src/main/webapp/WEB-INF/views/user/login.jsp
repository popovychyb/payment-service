<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Login page</h1>

<h4 style="color:red">${errorMsg}</h4>

<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="text" name="email">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <button type="submit">Login</button>
</form>

</body>
</html>
