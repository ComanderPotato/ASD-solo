<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 11/10/2023
  Time: 5:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String existErr = (String) session.getAttribute("existErr");
    String emailErr = (String) session.getAttribute("emailErr");
    String passErr = (String) session.getAttribute("passErr");
%>
<div class="modal modal-login hidden" id="login">
    <form action="LoginServlet" method="post">
        <div class="modal-content">
            <div class="modal-title">
                <h1>Login</h1>
                <button data-close="login">X</button>
            </div>
            <div class="form-group">
                <label for="emailLogin">Email:</label>
                <input
                        type="email"
                        id="emailLogin"
                        name="emailLogin"
                        required
                        placeholder="<%=(emailErr != null ? emailErr : "Enter your email")%>"
                />
            </div>
            <div class="form-group">
                <label for="passwordLogin">Password:</label>
                <input
                        type="password"
                        id="passwordLogin"
                        name="passwordLogin"
                        required
                        placeholder="<%=(passErr != null ? passErr : "Enter your password") %>"
                />
            </div>
            <div>
                <button type="submit" class="CTA CTA--primary">Login</button>
<%--                <button class="CTA CTA--secondary" data-openRegister >Sign up</button>--%>
            </div>
        </div>
    </form>
</div>
