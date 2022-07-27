<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/">
        <img src="images/logo.png" width="50" height="50" class="d-inline-block align-top" alt="">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%--     dashboard       --%>
            <li class="nav-item active">
                <a class="nav-link" href="/">Dashboard<span class="sr-only">(current)</span></a>
            </li>
            <%--        job form link    --%>
            <li class="nav-item active">
                <a class="nav-link" href="/jobform">Post Job</a>
            </li>
            <%--       jobs link     --%>
            <li class="nav-item active">
                <a class="nav-link" href="/jobs">Jobs</a>
            </li>
            <%--     customers link      --%>
            <li class="nav-item active">
                <a class="nav-link" href="/customers">Customers</a>
            </li>

                <%--     job applications link      --%>
                <li class="nav-item active">
                    <a class="nav-link" href="/jobapplications">Job Applications</a>
                </li>

            <%--     my account link       --%>
            <li class="nav-item active">
                <a class="nav-link" href="/freelancer">My Account</a>
            </li>
            <%--     contact us link       --%>
            <li class="nav-item active">
                <a class="nav-link" href="/contactus">Contact Us</a>
            </li>
        </ul>
        <div >
            <%--     logout lik       --%>
            <a style="text-align: right; color: #fff;" href="<c:url value="logout" />">Logout <i class="fa fa-sign-out fa-lg"></i>
            </a>
        </div>
    </div>
</nav>