<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Registration user</title>
</head>
<body class="h-100">
<div class="container h-50">
    <div class="row h-100 justify-content-center align-items-center">
        <form method="post" action="${pageContext.request.contextPath}/registration">
            <h1 class="display-4">Registration</h1>

            <h4 style="color:red">${message}</h4>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" name="firstName" value="${firstName}" id="firstName" class="form-control">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" value="${lastName}" id="lastName" class="form-control">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" id="email" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="pwd" id="password" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Repeat password</label>
                <input type="password" name="pwd-repeat" id="pwd-repeat" class="form-control">
            </div>
            <div class="btn-group mt-1">
                <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-secondary">Login</a>
                <button type="submit" class="btn btn-primary">Registration</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
