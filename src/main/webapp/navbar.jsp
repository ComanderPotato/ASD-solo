<%@ page import="CarBooking.Model.dao.UserDBManager" %>
<%@ page import="CarBooking.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 10/10/2023
  Time: 6:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean isLoggedIn = (session.getAttribute("isLoggedIn") == null) ? false : (Boolean) session.getAttribute("isLoggedIn");

    Boolean isLoginOpen = (Boolean) session.getAttribute("isLoginOpen");
    Boolean isRegisterOpen = (Boolean) session.getAttribute("isRegisterOpen");
    String userExists = (String) session.getAttribute("userExists");
    String existErr = (String) session.getAttribute("existErr");
    String emailErr = (String) session.getAttribute("emailErr");
    String passErr = (String) session.getAttribute("passErr");
    String phoneErr = (String) session.getAttribute("phoneErr");
    User sessionUser = (User) session.getAttribute("sessionUser");
    if(isRegisterOpen == null) isRegisterOpen = false;
    if(isLoginOpen == null) isLoginOpen = false;
%>
<head>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/navbar.css">
    <link rel="stylesheet" href="./styles/modal.css">
    <script src="./script/global.js" defer></script>
</head>
<nav class="nav-bar">
    <div>
        <a class="nav-links" href="index.jsp">Tom's Parking</a>
    </div>
    <div>
        <a class="nav-links" href="booking.jsp">Book online</a>
        <a class="nav-links" href="ViewSpotsServlet">View spots</a>
        <a class="nav-links" href="support.jsp">Support</a>
    </div>
    <% if(!isLoggedIn) { %>
    <div class="nav-buttons">
        <button
                class="CTA CTA--primary"
                data-modalOpen
                data-type="login"
        >
            Login
        </button>
        <button
                class="CTA CTA--secondary"
                data-modalOpen
                data-type="register"
        >
            Sign up
        </button>
    </div>
    <% } else { %>
        <div class="dropdown">
            <div class="nav-account">
            <a class="navbar-icon" href="#"><img src="./images/account.svg" class="icon" alt="User Account"></a>
            <div class="dropdown-content">
                <%
                    if(sessionUser.isAdmin()) {
                %>
                <a href="AdminServlet">Admin Dashboard</a>
                <%
                    }
                %>
                <a href="AccountServlet">Account</a>
                <a class="logout"href="LogoutController">Logout</a>
            </div>
                <p><%=sessionUser.getFirstName()%></p>
            </div>
        </div>
    <% } %>
    <%
        if(!isLoggedIn) {
    %>
        <%@include file="modalLogin.jsp"%>
        <%@include file="modalRegister.jsp"%>
    <% } %>
</nav>

