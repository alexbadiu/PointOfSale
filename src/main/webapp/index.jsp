<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<t:pageTemplate pageTitle="Point of Sale">
    <h1>Welcome to the Point of Sale</h1>
    <c:choose>
        <c:when test="${pageContext.request.getRemoteUser() == null}">
        </c:when>
        <c:otherwise>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddSale" role="button">Initiate Sale</a>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddReturn" role="button">Initiate Return Products</a>
        </c:otherwise>
    </c:choose>
</t:pageTemplate>