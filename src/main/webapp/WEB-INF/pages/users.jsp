<%-- 
    Document   : users
    Created on : Jan 5, 2019, 2:29:38 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser" role="button">Add User</a>
        <button class="btn btn-danger" type="submit">Delete users</button>
    </p>
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md-4">
                ${user.username}
            </div>
            <div class="col-md-4">
                ${user.email}
            </div>
            <div class="col-md-4">
                ${user.position}
            </div>
        </div>
    </c:forEach>
</t:pageTemplate> 
    