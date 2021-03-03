<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>New payment</title>
</head>
<body class="container h-100">
<jsp:include page="../menu.jsp"/>
<div class="container h-50">
    <div class="row h-100 justify-content-center align-items-center">
        <form method="post" action="${pageContext.request.contextPath}/bill/new">
            <h1 class="display-4">New payment</h1>
            <h4 style="color:#ff0000">${errorMsg}</h4>
            <div class="form-group">
                <label for="senderCard">Sender Card</label>
                <select class="form-control" id="senderCard" name="senderCard">
                    <c:forEach var="card" items="${cards}">
                        <option><c:out value="${card.number}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="recipientCard">Recipient Card</label>
                <input type="number" name="recipientCard" value="${recipientCard}" id="recipientCard"
                       class="form-control">
            </div>
            <div class="form-group">
                <label for="payment">Payment</label>
                <input type="number" name="payment" value="${payment}" id="payment" class="form-control">
            </div>
            <div class="btn-group mt-1">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
