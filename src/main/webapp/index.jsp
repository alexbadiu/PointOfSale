<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Point of Sale">
    <h1>Welcome to the Point of Sale</h1>
    <p>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddSale" role="button">Initiate Sale</a>
    </p>
</t:pageTemplate>