<%-- 
    Document   : editUser
    Created on : Jan 5, 2019, 3:31:53 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit User">
    <h1>Edit User</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
        <div class="row">
            <div class="mb-3">
                <label for="username">Username</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">@</span>
                    </div>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username" required value="${user.username}" />
                    <div class="invalid-feedback">
                        Your username is required.
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="email">Email <span class="text-muted">(Optional)</span></label>
                <input type="email" class="form-control" name="email" id="email" placeholder="you@example.com" value="${user.email}">
                <div class="invalid-feedback">
                    Please enter a valid email address.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" required>
                <div class="invalid-feedback">
                    Please enter a password.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="position">Position</label>
                <select class="custom-select d-block w-100" name="position" id="position" required>
                    <option value="CLIENT">Client</option>
                    <option value="ADMIN" ${user.position eq 'ADMIN' ? 'selected' : ''}>Administrator</option>
                </select>
                <div class="invalid-feedback">
                    Please select a valid position.
                </div>
            </div>
        </div>
        <input type="hidden" name="user_id" value="${user.id}" />
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
