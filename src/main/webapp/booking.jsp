<%@ page import="CarBooking.Model.State" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 12/10/2023
  Time: 4:38 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/booking.css">
    <link rel="stylesheet" href="./styles/navbar.css">
    <script src="./script/booking.js" defer></script>
</head>
<body>
<main>
    <%@include file="navbar.jsp"%>
    <div class="booking-content">
        <div class="booking-banner">
            <h1>Find a car park to book</h1>
        </div>
        <form action="" class="form--booking">
            <div class="booking-form--heading">
                <h2>Book online</h2>
                <p>Plan your journey and book your parking online before you leave home</p>
            </div>
            <div class="form-group--booking">
                <div class="form-group">
                    <label for="state">State</label>
                    <select name="state" id="state">
                        <%
                            ArrayList<State> states = (ArrayList<State>) session.getAttribute("states");
                            if(states != null)
                                for(State state : states) {
                        %>
                        <option value="<%=state.getId()%>"><%=state.getState()%></option>
                        <%
                                }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="carPark">Car park</label>
                    <input
                            type="text"
                            id="carPark"
                            name="carPark"
                            required
                    />
                    <input
                            type="hidden"
                            id="carParkId"
                            name="carParkId"
                            required
                    />
                    <div class="carPark-dropdown">

                    </div>
                </div>
            </div>
            <div class="form-group--booking booking-time">
                <div class="adjacent--booking">
                    <div class="form-group">
                        <label for="arrivalDate">Arrival date</label>
                        <input
                                type="date"
                                id="arrivalDate"
                                name="arrivalDate"
                                required
                                min="<%=LocalDate.now()%>"
                        />
                    </div>
                    <div class="form-group">
                        <label for="arrivalTime">Time</label>
                        <input
                                type="time"
                                id="arrivalTime"
                                name="arrivalTime"
                                required
                        />
                    </div>
                </div>
                <div class="adjacent--booking">
                    <div class="form-group">
                        <label for="exitDate">Exit date</label>
                        <input
                                type="date"
                                id="exitDate"
                                name="arrivalDate"
                                required
                                min="<%=LocalDate.now().plusDays(1)%>"
                        />
                    </div>
                    <div class="form-group">
                        <label for="exitTime">Time</label>
                        <input
                                type="time"
                                id="exitTime"
                                name="exitTime"
                                required
                        />
                    </div>
                </div>
            </div>
            <div class="form--booking-button">
                <button type="submit" class="CTA CTA--primary">Book now</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
