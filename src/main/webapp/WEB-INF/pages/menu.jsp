<%-- 
    Document   : menu
    Created on : Dec 5, 2018, 12:46:56 PM
    Author     : 
--%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking Lot</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${activePage eq 'Cars' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Cars">Cars</a>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/ParkingLot/about.jsp' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
            
        <ul class="navbar-nav ml-auto">
            <li class="nav-item ${activePage eq 'Login' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
            </li>
             <li class="nav-item ${activePage eq 'Register' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
            </li>
        </ul>
    </div>
</nav>