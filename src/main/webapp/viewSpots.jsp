<%@ page import="CarBooking.Model.dao.CarSpotDBManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="CarBooking.Model.CarSpot" %>
<%@ page import="CarBooking.Model.State" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 11/10/2023
  Time: 6:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/viewSpots.css">
    <link rel="stylesheet" href="./styles/navbar.css">
    <link rel="stylesheet" href="./styles/navbar.css">
</head>
<body>
<main>
    <%@include file="navbar.jsp"%>
    <div class="main-view-spots">
        <div class="spots-container">
            <div class="spots-container--header">
                <form action="FilterCarSpotsServlet" class="view-spots-form">
                <div class="form-group">
                    <label for="filter">Filter:</label>
                    <input
                            type="text"
                            id="filter"
                            name="filter"
                    />
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
                    <button type="submit" class="CTA CTA--primary">Filter</button>
                </form>

            </div>
            <div class="spots-container--content">
                <%
                    ArrayList<CarSpot> carSpots = (ArrayList<CarSpot>) session.getAttribute("carSpots");
                    if(carSpots != null)
                        for(CarSpot carSpot : carSpots) {
                %>
                <div class="spots-container--spot">
                    <h2><%=carSpot.getLocationName()%></h2>
                    <h3><%=carSpot.getPrice()%></h3>
                    <h3><%=carSpot.getAddress().getSuburb()%></h3>
                    <button class="CTA CTA--primary">Book now</button>
                </div>
                <%
                        }
                %>
            </div>
        </div>
    </div>
</main>
</body>
</html>
