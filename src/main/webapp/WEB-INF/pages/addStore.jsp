<%-- 
    Document   : addStore
    Created on : Jan 5, 2019, 8:59:14 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Store">
    <h1>Add Store</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddStore">
        <div class="row">
            <div class="mb-3">
                <label for="name">Name</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="name" id="name" placeholder="Name" required>
                    <div class="invalid-feedback">
                        Store Name is required.
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Str. example nr. 2" required>
                <div class="invalid-feedback">
                    Please enter a valid address.
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
