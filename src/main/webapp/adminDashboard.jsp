<%@ page import="CarBooking.Model.CarSpot" %>
<%@ page import="CarBooking.Model.SupportForm" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 20/10/2023
  Time: 6:42 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    ArrayList<State> states = (ArrayList<State>) session.getAttribute("states");
    ArrayList<SupportForm> supportForms = (ArrayList<SupportForm>) session.getAttribute("supportForms");
    ArrayList<CarSpot> carSpots = (ArrayList<CarSpot>) session.getAttribute("carSpots");
    ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
    Boolean isAdminSpotsOpen = (Boolean) session.getAttribute("isAdminSpotsOpen");
    Boolean isAdminUserOpen = (Boolean) session.getAttribute("isAdminUserOpen");
    Boolean isAdminFormsOpen = (Boolean) session.getAttribute("isAdminFormsOpen");
    Boolean isEditUserModalOpen = (Boolean) session.getAttribute("isEditUserModalOpen");
    Boolean isEditCarModalOpen = (Boolean) session.getAttribute("isEditCarModalOpen");
    Boolean isDeleteUserModalOpen = (Boolean) session.getAttribute("isDeleteUserModalOpen");
%>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./styles/adminDashboard.css">
    <link rel="stylesheet" href="./styles/viewSpots.css">
    <script src="./script/adminDashboard.js" defer></script>
</head>
<body>
<main>

<%@include file="navbar.jsp"%>
    <div class="main-admin">
        <nav class="admin-nav">
            <button class="nav-links admin-links" data-type="spots" href="#" <%
                if(isAdminSpotsOpen) {%> disabled<% } %>>Car spots</button>
            <button class="nav-links admin-links" data-type="users" href="#" <%
                if(isAdminUserOpen) {%> disabled<% } %>>View users</button>
            <button class="nav-links admin-links" data-type="forms" href="#" <%
                if(isAdminFormsOpen) {%> disabled<% } %>>Support forms</button>
        </nav>
        <div class="main-admin-spots <%= isAdminSpotsOpen ? "" : "hidden"%>">
            <div class="main-admin-spots--header">
                <form action="FilterCarSpotsServlet" class="view-spots-form">
                    <div class="form-group">
                        <label for="filter">Filter:</label>
                        <input
                                type="text"
                                id="filter"
                                name="filter"
                        />
                        <select name="stateIdFilter" id="statIdFilter">
                            <%
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
                <button
                        class="CTA CTA--secondary"
                        data-modalOpen
                        data-type="addCarSpot"
                >Add car spot</button>
            </div>
            <div class="main-admin-spots--content admin-grid">
                    <%
                        if(carSpots != null)
                            for(CarSpot carSpot : carSpots) {
                    %>
                    <div class="admin-grid--item">
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
        <div class="main-admin-users <%= isAdminUserOpen ? "" : "hidden"%>">
            <div class="main-admin-users--header">

            </div>
            <div class="main-admin-users--content admin-grid">
                <%
                    if(users != null)
                        for(User user : users) {
                %>
                <div class="admin-grid--item
                admin-grid--item-user"
                     data-editId="<%=user.getId()%>"
                     data-editEmail="<%=user.getEmail()%>"
                     data-editPassword="<%=user.getPassword()%>"
                     data-editFirstName="<%=user.getFirstName()%>"
                     data-editLastName="<%=user.getLastName()%>"
                     data-editPhone="<%=user.getPhoneNumber()%>"
                >
                    <h2><%=user.getEmail()%></h2>
                    <h3><%=user.getPassword()%></h3>
                    <h3><%=user.getFirstName() + " " + user.getLastName()%></h3>
                    <div class="admin-user--controls"
                         data-editId="<%=user.getId()%>"
                         data-editEmail="<%=user.getEmail()%>"
                         data-editPassword="<%=user.getPassword()%>"
                         data-editFirstName="<%=user.getFirstName()%>"
                         data-editLastName="<%=user.getLastName()%>"
                         data-editPhone="<%=user.getPhoneNumber()%>"
                    >
                        <img src="./images/edit.svg" class="icon user-button--edit" alt="">
                        <img src="./images/delete.svg" class="icon user-button--delete" alt="">
                    </div>
                </div>
                <%
                        }
                %>
            </div>
        </div>
        <div class="main-admin-forms <%= isAdminFormsOpen ? "" : "hidden"%>">
            <div class="main-admin-forms--header">

            </div>
            <div class="main-admin-forms--content  admin-grid">
                <%
                    if(supportForms != null)
                        for(SupportForm supportForm : supportForms) {
                %>
                    <div class="admin-grid--item">
                        <span><%=supportForm.getEmail()%></span>
                        <p><%=supportForm.getMessage()%></p>
                    </div>
                <%
                        }
                %>
            </div>
        </div>
    </div>
    <%@include file="modalAddCarSpot.jsp"%>
    <%@include file="modalEditUser.jsp"%>
    <%@include file="modalDeleteUser.jsp"%>

</main>
</body>
</html>
