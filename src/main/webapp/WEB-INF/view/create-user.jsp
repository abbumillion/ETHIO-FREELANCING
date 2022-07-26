<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Sign Up</title>

    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">

<%--    <jsp:include page="templates/header.jsp"/>--%>
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Sign Up Here</h4>
                        <c:if test="${not empty param.error}">
                            <label id="error" class="alert alert-danger">${param.error}</label>
                        </c:if>
                    <%--sign up form starts--%>
                        <form action="/register" method="POST">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input id="firstName" type="text" class="form-control" name="firstName" required
                                       autofocus>
                            </div>
                    <%--last name--%>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input id="lastName" type="text" class="form-control" name="lastName" required>
                            </div>
                    <%--email--%>
                            <div class="form-group">
                                <label for="email">E-Mail Address</label>
                                <input id="email" type="email" class="form-control" name="email" required>
                            </div>
                    <%--password--%>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input id="password" type="password" class="form-control" name="password" required
                                       data-eye>
                            </div>
                    <%--confirm password--%>
                            <div class="form-group">
                                <label for="password">Confirm Password</label>
                                <input id="confirmpassword" type="password" class="form-control" name="password" required
                                       data-eye>
                            </div>
                    <%--role--%>
                            <div class="form-group">
                                <select id="criteriaId" name="roleName" class="custom-select form-control" required>
                                    <%--                                    <option value="ADMIN">Admin</option>--%>
                                    <option value="FREELANCER">Freelancer</option>
                                    <option value="CUSTOMER">Customer</option>
                                </select>
                            </div>
                    <%-- sign up button--%>
                            <div class="form-group m-2">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Sign Up
                                </button>
                            </div>
                    <%-- login button--%>
                            <div class="form-group m-2">
                                <a href="/login" >already have account?</a>
                            </div>
                        </form>
                    </div>
                </div>
                <jsp:include page="templates/copyright.jsp"/>
            </div>
        </div>
    </div>
</section>
<jsp:include page="templates/footer.jsp"/>
</body>
</html>