<%-- 
    Document   : addSale
    Created on : Jan 6, 2019, 3:02:35 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Sale">
    <h1>Add Sale</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddSale">
        <div class="row">
            <div class="col-md-3">
                <div class="row">
                    <div class="mb-10">
                        <label for="barcode">Barcode</label>
                        <input type="text" class="form-control" name="barcode" id="barcode" placeholder="10010101">
                        <div class="invalid-feedback">
                            Barcode is required.
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-10">
                        <input type="number" min="1"  class="form-control" name="quantity" id="quantity"  value="1">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Add product</button>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-4">
                        <h4>Name</h4>
                    </div>
                    <div class="col-md-4">
                        <h4>Description</h4>
                    </div>
                    <div class="col-md-2">
                        <h4>Price</h4>
                    </div>
                    <div class="col-md-2">
                        <h4>Quantity</h4>
                    </div>
                </div>
                <c:forEach var="temporarProduct" items="${temporarProducts}" varStatus="status">
                    <div class="row">
                        <div class="col-md-4">
                            ${temporarProduct.name}
                        </div>
                        <div class="col-md-4">
                            ${temporarProduct.description}
                        </div>
                        <div class="col-md-2">
                            $${temporarProduct.price}
                        </div>
                        <div class="col-md-2">
                            ${temporarProduct.quantity}
                        </div>
                    </div>
                </c:forEach>
                <br>
                <div class="row">
                    <div class="col-md-4">
                            Total Payment:
                    </div>
                    <div class="col-md-4">
                            ${total}
                    </div>
                </div>
                <div class="row">
                    <div class="mb-10">
                        <button class="btn btn-primary btn-lg btn-block" type="submit" formaction="${pageContext.request.contextPath}/ProcessSale" name="submit" value="pressed">Submit sale</button>
                    </div>
                </div>
            </div>
        </div>
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
