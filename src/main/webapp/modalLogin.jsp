<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 11/10/2023
  Time: 5:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="LoginServlet" method="post" class="modal modal-login <%= isLoginOpen ? "" : "hidden" %>" id="login">
<%--<form action="LoginServlet" method="post" class="modal modal-login hidden" id="login">--%>
    <div class="modal-content">
        <div class="modal-title">
            <h1>Login</h1>
            <button data-close="login">X</button>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input
                    type="email"
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
        <div>
            <%=(existErr != null ? existErr : " ")%>
        </div>
        <div>
            <button type="submit" class="CTA CTA--primary">Login</button>
            <button class="CTA CTA--secondary" data-openRegister >Sign up</button>
        </div>
    </div>
</form>