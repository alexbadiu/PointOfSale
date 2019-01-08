<%-- 
    Document   : editProduct
    Created on : Jan 8, 2019, 11:41:04 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Product">
    <h1>Edit Product</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditProduct">
        <div class="row">
            <div class="mb-3">
                <label for="prodName">Product name</label>
                <input type="text" class="form-control" name="prodName" id="prodName" placeholder="Product name" required value="${productSpecification.prodName}">
                <div class="invalid-feedback">
                    Product name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="description">Description <span class="text-muted">(Optional)</span></label>
                <input type="text" class="form-control" name="description" id="description" placeholder="Description..." value="${productSpecification.description}">
                <div class="invalid-feedback">
                    Please enter a valid description.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="barcode">Barcode</label>
                <input type="text" class="form-control" name="barcode" id="barcode" placeholder="10010101" required value="${productSpecification.barcode}">
                <div class="invalid-feedback">
                    Barcode is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="price">Price</label>
                <input type="number" step="0.01" min="0" class="form-control" name="price" id="price" placeholder="3.44" required value="${productSpecification.price}">
                <div class="invalid-feedback">
                    Please enter a valid Price (number).
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="units">Units</label>
                <input type="number" step="1" min="0" class="form-control" name="units" id="units" placeholder="3" required value="${productSpecification.unitOnStock}">
                <div class="invalid-feedback">
                    Please enter a valid Price (number).
                </div>
            </div>
        </div>
        <input type="hidden" name="productSpecification_id" value="${productSpecification.id}" />
        <input type="hidden" name="product_id" value="${productSpecification.prodId}" />
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
</t:pageTemplate>
