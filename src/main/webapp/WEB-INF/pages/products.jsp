<%-- 
    Document   : products
    Created on : Jan 7, 2019, 12:03:38 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Products">
    <h1>Products</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Products">
        <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
            <p>
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddProduct" role="button">Add Product</a>
                <button class="btn btn-danger" type="submit">Delete products</button>
            </p>
        </c:if>
        <c:forEach var="productSpecification" items="${productSpecifications}" varStatus="status">
            <div class="row">
                <div class="col-md">
                    <input type="checkbox" class="form-check-input" name="product_ids" value="${productSpecification.id}" />
                </div>
                <div class="col-md-3">
                    ${productSpecification.prodName}
                </div>
                <div class="col-md-3">
                    ${productSpecification.description}
                </div>
                <div class="col-md">
                    ${productSpecification.price}
                </div>
                <div class="col-md">
                    ${productSpecification.unitOnStock}
                </div>
                <div class="col-md-2">
                    ${productSpecification.barcode}
                </div>
                <div class="col-md-1">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProduct?id=${productSpecification.id}" role="button">Edit Product</a>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate> 

