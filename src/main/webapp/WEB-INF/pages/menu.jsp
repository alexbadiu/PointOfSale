<%-- 
    Document   : menu
    Created on : Jan 4, 2019, 10:13:59 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Point of Sale</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                 <a class="nav-link" href="${pageContext.request.contextPath}">Home</a>
            </li>
           
            <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users</a>
                </li>
            </c:if>
            
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Stores">Stores</a>
                </li>
            </c:if>
            
            <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Sales">Sales</a>
                </li>
            </c:if>
            
            <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Products">Products</a>
                </li>
            </c:if>
            
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}">About <span class="sr-only">(current)</span></a>
            </li>
        </ul>
            
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${pageContext.request.getRemoteUser() == null}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
