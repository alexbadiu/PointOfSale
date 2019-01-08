<%-- 
    Document   : sales
    Created on : Jan 6, 2019, 2:31:39 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Sales">
    <h1>Sales</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Sales">
        <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
            <p>
                <button class="btn btn-danger" type="submit">Delete sales</button>
            </p>
        </c:if>
        <c:forEach var="sale" items="${sales}" varStatus="status">
            <div class="row">
                <div class="col-md-2">
                    <input type="checkbox" class="form-check-input" name="sale_ids" value="${sale.id}" />
                </div>
                <div class="col-md-2">
                    ${sale.saleDate}
                </div>
                <div class="col-md-2">
                    ${sale.saleTime}
                </div>
                <div class="col-md-2">
                    ${sale.cashierName}
                </div>
                <div class="col-md-2">
                    ${sale.storeName}
                </div>
                <div class="col-md-2">
                    ${sale.paymentAmount}
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate> 
