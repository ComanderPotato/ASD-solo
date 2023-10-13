<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@page import="CarBooking.Model.*" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Car Park Booking</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <%--%>
<%--        String existErr = (String) session.getAttribute("existErr");--%>
<%--        String emailErr = (String) session.getAttribute("emailErr");--%>
<%--        String passErr = (String) session.getAttribute("passErr");--%>
<%--    %>--%>
<%--    <div class="container">--%>
<%--        <h1>Welcome</h1>--%>

<%--    </div>--%>
<%--    <jsp:include page="/ConnServlet" flush="true" />--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="CarBooking.Model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tom's Parking</title>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/navbar.css">
    <link rel="stylesheet" href="./styles/modal.css">
    <link rel="stylesheet" href="./styles/index.css">
<%--    <script src="./script/global.js" defer></script>--%>
</head>
<body>
<%--<%--%>
<%--    session.setAttribute("isLoggedIn", false);--%>
<%--%>--%>
<main>
    <%@include file="navbar.jsp"%>
    <div class="main">
        <div class="main-left">
            <form action="">
                <div class="main-left--content">
                    <h1 class="main-left--text">Where do you need to go?</h1>

                    <input
                            type="text"
                            name=""
                            id=""
                            class="main-left--search"
                            placeholder="Find an address, venue, or city"
                            required
                    />
                    <button type="submit" class="main-left--button">Show results</button>
                </div>
            </form>
        </div>
    <div class="main-right"></div>
</div>
<%--<%@include file="modalLogin.jsp"%>--%>
<%--<%@include file="modalRegister.jsp"%>--%>
</main>
<jsp:include page="/ConnServlet" flush="true" />
</body>
</html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home Page</title>--%>
<%--    <link rel="stylesheet" href="./styles/global.css">--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f2f2f2;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            display: grid;--%>
<%--            place-content: center;--%>
<%--            height: 100vh;--%>
<%--        }--%>

<%--        .container {--%>
<%--            width: 400px;--%>
<%--            margin: 100px auto;--%>
<%--            background-color: #fff;--%>
<%--            padding: 20px;--%>
<%--            border-radius: 5px;--%>
<%--            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);--%>
<%--        }--%>

<%--        h1 {--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .form-group {--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        .form-group label {--%>
<%--            display: block;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        .form-group input {--%>
<%--            width: 100%;--%>
<%--            padding: 5px;--%>
<%--            font-size: 16px;--%>
<%--            border-radius: 3px;--%>
<%--            border: 1px solid #ccc;--%>
<%--        }--%>

<%--        .button-container {--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .button-container button {--%>
<%--            padding: 10px 20px;--%>
<%--            font-size: 16px;--%>
<%--            border-radius: 3px;--%>
<%--            border: none;--%>
<%--            background-color: #4CAF50;--%>
<%--            color: #fff;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--        .button-container button:hover {--%>
<%--            background-color: #45a049;--%>
<%--        }--%>

<%--        .guest-link {--%>
<%--            text-align: center;--%>
<%--            margin-top: 10px;--%>
<%--        }--%>
<%--        a {--%>
<%--            text-decoration: none;--%>
<%--            color: inherit;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%--%>
<%--    String existErr = (String) session.getAttribute("existErr");--%>
<%--    String emailErr = (String) session.getAttribute("emailErr");--%>
<%--    String passErr = (String) session.getAttribute("passErr");--%>
<%--%>--%>
<%--<div class="container">--%>
<%--    <h1>Welcome</h1>--%>

<%--    <form action="LoginServlet" method="post">--%>
<%--        <div class="form-group">--%>
<%--            <label for="email">Email:</label>--%>
<%--            <input type="text" id="email" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="password">Password:</label>--%>
<%--            <input type="password" id="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password") %>">--%>
<%--        </div>--%>
<%--        <span><%=(existErr != null ? existErr : "") %></span>--%>
<%--        <div class="button-container">--%>
<%--            <button type="submit">Login</button>--%>
<%--            <button><a href="register.jsp">Sign Up</a></button>--%>
<%--        </div>--%>
<%--        <div class="guest-link">--%>
<%--            <a href="GuestServlet">Continue as Guest</a>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</div>--%>
<%--<jsp:include page="/ConnServlet" flush="true" />--%>
<%--</body>--%>
<%--</html>--%>