<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Login page</title>
</head>
<body class="container">
<h1>Login page</h1>

<h4 style="color:red">${errorMsg}</h4>

<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" name="email" id="email" class="form-control">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="pwd" id="password" class="form-control">
    </div>
    <div class="btn-group mt-1">
        <a href="${pageContext.request.contextPath}/registration" class="btn btn-outline-secondary">Registration</a>
        <button type="submit" class="btn btn-primary">Login</button>
    </div>
</form>
</body>
</html>
