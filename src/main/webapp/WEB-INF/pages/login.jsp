<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset='UTF-8'" />
        <title>Login</title>
    </head>
    <body>
        <%--Navbar--%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">  
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="index.jsp" class="navbar-brand">ULBS Fac. Inginerie</a>
			</div><!--Navbar Headear -->
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="info.jsp">Informatii despre noi</a></li>
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div><%--End navbar-collapse--%>
		</div><%--container--%>
	</nav><%--NAV--%>
        <div class="container col-md-4 col-md-offset-4" style="padding-top:5%">

            <form class="form-signin" action="login" method="post">
                <h1 class="from-signin-heading">Login!</h1>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input class="form-control" name="username" type="text" placeholder="Introduceți numele de utilizator" required/><br>
                </div><br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input  class="form-control" name="password" type="password" placeholder="Introduceți parola" required/><br>
                </div><br>
                <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Logare"/><br>
            </form>
            <form class="form-signin" action="signUP" method="post">
                <h3 class="from-signin-heading">Nu aveti cont?</h3>
                <input class="btn btn-lg btn-primary btn-block" name="signup" type="submit" value="Sign Up"/>
            </form>


        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>$('.navbar-collapse a').click(function(){
			$(".navbar-collapse").collapse('hide');
			});
	</script>
    </body>
</html>
