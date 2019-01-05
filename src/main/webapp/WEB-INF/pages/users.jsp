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
    <form method="POST" action="${pageContext.request.contextPath}/Users">
        <p>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser" role="button">Add User</a>
            <button class="btn btn-danger" type="submit">Delete users</button>
        </p>
        <c:forEach var="user" items="${users}" varStatus="status">
            <div class="row">
                <div class="col-md">
                    <input type="checkbox" class="form-check-input" name="user_ids" value="${user.id}" />
                </div>
                <div class="col-md-3">
                    ${user.username}
                </div>
                <div class="col-md-3">
                    ${user.email}
                </div>
                <div class="col-md-3">
                    ${user.position}
                </div>
                <div class="col-md-2">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button">Edit User</a>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate> 
    