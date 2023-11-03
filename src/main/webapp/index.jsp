

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="CarBooking.Model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tom's Parking</title>
    <link rel="stylesheet" href="./styles/index.css">
</head>
<body>

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
</main>
</body>
<%
    if(session.isNew()) {
%>
    <jsp:include page="/ConnServlet" flush="true" />
<%
    }
%>
</html>