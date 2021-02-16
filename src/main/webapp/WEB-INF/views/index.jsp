<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment service</title>
</head>
<body>
<h1>Hello world!</h1>
<p>Current time is: ${time}</p>
<br>
<a href="${pageContext.request.contextPath}/inject">Inject test data into the DB</a>
<br>
<a href="${pageContext.request.contextPath}/user/registration">registration</a>
<br>
<a href="${pageContext.request.contextPath}/user/all">user/all</a>
<br>
<a href="${pageContext.request.contextPath}/card/all">card/all</a>
<br>
<a href="${pageContext.request.contextPath}/bill/all">bill/all</a>
<br>
<a href="${pageContext.request.contextPath}/ticket/all">ticket/all</a>
</body>
</html>
