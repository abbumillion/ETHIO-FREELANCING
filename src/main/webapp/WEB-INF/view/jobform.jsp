<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Post Job</title>
</head>

<body class="my-login-page">
<jsp:include page="templates/header.jsp"/>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Post Job</h4>
                        <c:if test="${not empty param.error}">
                            <label id="error" class="alert alert-danger">${param.error}</label>
                        </c:if>
                        <%-- job form --%>
                        <form action="/postjob" method="POST">
                        <%--Title--%>
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input id="title" type="text" class="form-control" name="title" required
                                       autofocus>
                            </div>
                        <%--Job Category--%>
                            <div class="form-group">
                                <label for="category">Job Category</label>
                                <select name="category" class="custom-select form-control" required >
                                    <option value="WRITING">Freelancer</option>
                                    <option value="DESIGNER">Customer</option>
                                    <option value="WAITER">Freelancer</option>
                                    <option value="TEACHER">Customer</option>
                                    <option value="TRANSLATOR">Freelancer</option>
                                    <option value="DEVELOPER">Customer</option>
                                    <option value="MECHANIC">Freelancer</option>
<%--                                    <option value="CUSTOMER">Customer</option>--%>
<%--                                    <option value="WRITING">Freelancer</option>--%>
<%--                                    <option value="DESIGNER">Customer</option>--%>
<%--                                    <option value="FREELANCER">Freelancer</option>--%>
<%--                                    <option value="CUSTOMER">Customer</option>--%>
<%--                                    <option value="WRITING">Freelancer</option>--%>
<%--                                    <option value="DESIGNER">Customer</option>--%>
<%--                                    <option value="FREELANCER">Freelancer</option>--%>
<%--                                    <option value="CUSTOMER">Customer</option>--%>
                                </select>
<%--                                <input id="lastName" type="text" class="form-control" name="lastName" required>--%>
                            </div>
                        <%--Type--%>
                            <div class="form-group">
                                <label for="type">Type</label>
                                <select name="type" multiple class="custom-select form-control" required >
                                    <option value="REMOTE">Remote</option>
                                    <option value="FULLTIME">Full Time</option>
                                    <option value="PERTIME">Per Time</option>
                                    <option value="HOURLY">Hourly</option>
                                    <option value="WEEKENDS">Weekends</option>
                                    <option value="EXTRATIME">Extra Time</option>
<%--                                    <option value="MECHANIC">Freelancer</option>--%>
                                    <%--                                    <option value="CUSTOMER">Customer</option>--%>
                                    <%--                                    <option value="WRITING">Freelancer</option>--%>
                                    <%--                                    <option value="DESIGNER">Customer</option>--%>
                                    <%--                                    <option value="FREELANCER">Freelancer</option>--%>
                                    <%--                                    <option value="CUSTOMER">Customer</option>--%>
                                    <%--                                    <option value="WRITING">Freelancer</option>--%>
                                    <%--                                    <option value="DESIGNER">Customer</option>--%>
                                    <%--                                    <option value="FREELANCER">Freelancer</option>--%>
                                    <%--                                    <option value="CUSTOMER">Customer</option>--%>
                                </select>
<%--                                <input id="type" type="text" class="form-control" name="type" required>--%>
                            </div>
                        <%--Salary--%>
                            <div class="form-group">
                                <label for="salary">Salary</label>
                                <input id="salary" type="number" class="form-control" name="salary" required
                                       data-eye>
                            </div>
                        <%--Skills--%>
                            <div class="form-group">
                                <label for="skill">Skills</label>
                                <input id="skill" type="password" class="form-control" name="password" required
                                       data-eye>
                            </div>
                        <%--Description--%>
                            <div class="form-group">
                                <select id="criteriaId" name="roleName" class="custom-select form-control" required>
                                    <%--                                    <option value="ADMIN">Admin</option>--%>
                                    <option value="FREELANCER">Freelancer</option>
                                    <option value="CUSTOMER">Customer</option>
                                </select>
                            </div>
                        <%--    Submit Button--%>
                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Post
                                </button>
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