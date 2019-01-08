<%-- 
    Document   : stores
    Created on : Jan 5, 2019, 8:51:02 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Stores">
    <h1>Stores</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Stores">
        <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
            <p>
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddStore" role="button">Add Store</a>
                <button class="btn btn-danger" type="submit">Delete stores</button>
            </p>
        </c:if>
        <div class="row">
            <div class="col-md">
            </div>
            <div class="col-md-4">
                <h4>Name</h4>
            </div>
            <div class="col-md-4">
                <h4>Address</h4>
            </div>
            <div class="col-md-2">
            </div>
        </div>
        <c:forEach var="store" items="${stores}" varStatus="status">
            <div class="row">
                <div class="col-md">
                    <input type="checkbox" class="form-check-input" name="store_ids" value="${store.id}" />
                </div>
                <div class="col-md-4">
                    ${store.name}
                </div>
                <div class="col-md-4">
                    ${store.address}
                </div>
                <div class="col-md-2">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditStore?id=${store.id}" role="button">Edit Store</a>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate> 
