<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 10/10/2023
  Time: 6:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
    boolean isLoggedIn = false;
%>
<nav class="nav-bar">
    <div>
    <a class="nav-links" href="index.jsp">Tom's Parking</a>
    </div>
    <div>
        <a class="nav-links" href="booking.jsp">Book online</a>
        <a class="nav-links" href="viewSpots.jsp">View spots</a>
        <a class="nav-links" href="support.jsp">Support</a>
    </div>
    <% if(!isLoggedIn) { %>
    <div class="nav-buttons">
        <a href="login.jsp" class="CTA CTA--primary" data-navButton data-type="login">
            Login
        </a>
        <a
                href="register.jsp"
                class="CTA CTA--secondary"

                data-navButton
                data-type="register"
        >
            Sign up
        </a>
    </div>
    <% } else { %>
    <div>Loggined in</div>
    <% } %>
</nav>
