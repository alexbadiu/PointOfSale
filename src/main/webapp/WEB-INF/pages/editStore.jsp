<%-- 
    Document   : editStore
    Created on : Jan 5, 2019, 8:59:34 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Store">
    <h1>Edit Store</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditStore">
        <div class="row">
            <div class="mb-3">
                <label for="name">Name</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="name" id="name" placeholder="Name" required value="${store.name}" />
                    <div class="invalid-feedback">
                        Store name is required.
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Str. example nr. 2" required value="${store.address}">
                <div class="invalid-feedback">
                    Please enter a valid address.
                </div>
            </div>
        </div>
        <input type="hidden" name="store_id" value="${store.id}" />
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
