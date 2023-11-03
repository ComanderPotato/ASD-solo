<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 11/10/2023
  Time: 5:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


%>
<form action="RegisterServlet" method="post" class="modal modal-register <%= isRegisterOpen ? "" : "hidden" %>" id="register">
<%--<form action="RegisterServlet" method="post" class="modal modal-register hidden" id="register">--%>
    <div class="modal-content">
        <div class="modal-title">
            <h1>Register</h1>
            <button data-close="register">X</button>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input
                    type="text"
                    id="email"
                    name="email"
                    required
                    placeholder="<%=(emailErr != null ? emailErr : "Enter your email")%>"

            />
        </div>
        <div class="form-group form-group-password">
            <label for="password">Password:</label>
            <input
                    type="password"
                    id="password"
                    name="password"
                    required
                    placeholder="<%=(passErr != null ? passErr : "Enter your password")%>"
            />
            <img src="./images/eye-off.svg" alt="" class="icon icon-eye" data-show date-eye>
            <img src="./images/eye-show.svg" alt="" class="icon icon-eye hidden" data-hide data-eye>
        </div>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    required
                    placeholder="Enter your first name"
            />
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    required
                    placeholder="Enter your last name"
            />
        </div>
        <div class="form-group">
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" />
        </div>
        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input
                    type="tel"
                    id="phone"
                    name="phone"
                    required
                    placeholder="<%=(phoneErr != null ? phoneErr : "Enter your phone number")%>"
            />
        </div>
        <div class="form-group">
            <label for="adminCode">Admin Code:</label>
            <input id="adminCode" name="adminCode" />
        </div>
        <div>
            <%=(userExists != null ? userExists : " ")%>
        </div>
        <div>
            <button type="submit" class="CTA CTA--primary">Sign up</button>
        </div>
    </div>
</form>
