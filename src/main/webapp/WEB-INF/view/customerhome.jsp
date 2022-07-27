<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="my-login-page">
<jsp:include page="templates/customerheader.jsp"/>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
                    <h4 class="float-left">Customer</h4>
                    <ul class="float-right">
                        <li>
                            <form action="/searchBox" class="form-inline my-2 my-lg-0 ">
                                <input class="form-control mr-sm-2" name="searchTerm" type="search" placeholder="Search"
                                       aria-label="Search">
                                <input type="hidden" name="page" value="0"/>
                                <input type="hidden" name="size" value="${maxTraySize}"/>
                                <input class="btn btn-outline-primary my-2 my-sm-0" value="Search" type="submit">
                            </form>
                        </li>
                        <li class="text-right">
                            <a href="/search">Advanced Search</a>
                        </li>
                    </ul>
                </div>
                <div class="card card-body table-responsive">
                    <c:choose>
                        <c:when test="${allUsers.totalPages > 0}">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>User Id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${allUsers.content}">
                                    <tr>
                                        <td>
                                            <label>${user.getId()}</label>
                                        </td>
                                        <td>
                                            <label id="fname_${user.getId()}">
                                                    ${user.getFirstName()}
                                            </label>
                                            <input required type="text" name="firstName" class="form-control"
                                                   value="${user.getFirstName()}"
                                                   style="display: none;"
                                                   id="text_fname_${user.getId()}">
                                        </td>
                                        <td>
                                            <label id="lname_${user.getId()}">
                                                    ${user.getLastName()}
                                            </label>
                                            <input required class="form-control" type="text" name="firstName"
                                                   value="${user.getLastName()}"
                                                   style="display: none;"
                                                   id="text_lname_${user.getId()}">
                                        </td>
                                        <td>
                                            <label>
                                                    ${user.getEmail()}
                                            </label>
                                        </td>
                                        <td>
                                            <a href="/update" id="update_${user.getId()}" class="updateData"
                                               onclick="event.preventDefault();"><i class="fa fa-edit"></i></a>
                                            <a href="/save" id="save_${user.getId()}" class="saveData"
                                               onclick="event.preventDefault();saveData(${user.getId()});"
                                               style="display: none;"><i class="fa fa-save"></i></a>
                                        </td>
                                        <td><a href="/delete/${user.getId()}" class="deleteData"><i
                                                class="fa fa-trash"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </c:when>
                        <c:otherwise>
                            <h5>No users Found... Search again!</h5>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <c:if test="${allUsers.totalPages > 0}">
                <nav aria-label="Page navigation example" style="margin:auto;">
                    <ul class="pagination">
                        <c:set var="prev" value="0"/>
                        <c:if test="${param.page > 0}">
                            <c:set var="prev" value="${param.page -1}"/>
                        </c:if>
                        <c:if test="${allUsers.totalPages > 0}">
                            <li class='page-item <c:if test="${empty param.page || param.page eq 0}">disabled</c:if>'>
                                <a class="page-link" href="/?page=${prev}&size=${maxTraySize}">Prev</a></li>
                        </c:if>
                        <c:forEach var="i" begin="0" end="${allUsers.totalPages -1}">
                            <li class='page-item <c:if test="${param.page eq i || (empty param.page && i eq 0)}">active</c:if>'>
                                <a class="page-link" href="/?page=${i}&size=${maxTraySize}">${i+1}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${allUsers.totalPages > 0}">
                            <li class='page-item <c:if test="${allUsers.totalPages <= (param.page + 1)}">disabled</c:if>'>
                                <a class="page-link" href="/?page=${param.page + 1}&size=${maxTraySize}">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>
            <input type="hidden" name="currentPage" value="${currentPage}" id="currentPageNo">
            <%--</nav>--%>
        </div>
    </div>
</section>
<jsp:include page="templates/pageScript.jsp"/>
</body>
</html>