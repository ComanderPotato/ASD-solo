<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 11/10/2023
  Time: 5:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal modal-register hidden" id="register">
  <form action="RegisterServlet" method="post">
    <div class="modal-content">
      <div class="modal-title">
        <h1>Register</h1>
        <button data-close="register">X</button>
      </div>
      <div class="form-group">
        <label for="emailRegister">Email:</label>
        <input
                type="text"
                id="emailRegister"
                name="emailRegister"
                required
        />
      </div>
      <div class="form-group">
        <label for="passwordRegister">Password:</label>
        <input
                type="password"
                id="passwordRegister"
                name="passwordRegister"
                required
        />
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
        <input type="tel" id="phone" name="phone" required />
      </div>
      <div class="form-group">
        <label for="adminCode">Admin Code:</label>
        <input id="adminCode" name="adminCode" required />
      </div>
      <div>
        <button type="submit" class="CTA CTA--primary">Sign up</button>
<%--  <input type="submit">--%>
      </div>
    </div>
  </form>
</div>
