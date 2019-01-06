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
            <div class="mb-3">
                <label for="cashierId">Cashier</label>
                <select class="custom-select d-block w-100" name="cashierId" id="cashierId" required>
                  <option value="">Choose...</option>
                  <c:forEach var="user" items="${users}" varStatus="status">
                      <option value="${user.id}">${user.username}</option>
                  </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a valid user (cashier).
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="storeId">Store</label>
                <select class="custom-select d-block w-100" name="storeId" id="storeId" required>
                  <option value="">Choose...</option>
                  <c:forEach var="store" items="${stores}" varStatus="status">
                      <option value="${store.id}">${store.name}</option>
                  </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a valid store.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="paymentAmount">Payment amount</label>
                <input type="number" step="0.01" min="0" class="form-control" name="paymentAmount" id="paymentAmount" placeholder="3.44" required>
                <div class="invalid-feedback">
                    Please enter a valid Payment amount (number).
                </div>
            </div>
        </div>
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
