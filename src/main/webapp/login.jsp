<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 10/10/2023
  Time: 4:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/modal.css">
</head>
<body>
<form action="LoginServlet" method="post">
    <div class="modal-content">
        <div class="modal-title">
            <h1>Login</h1>
<%--            <button data-close="login">X</button>--%>
            <a href="index.jsp">Back</a>
        </div>
        <div class="form-group">
            <label for="emailLogin">Email:</label>
            <input
                    type="email"
                    id="emailLogin"
                    name="emailLogin"
                    required
            />
        </div>
        <div class="form-group">
            <label for="passwordLogin">Password:</label>
            <input
                    type="password"
                    id="passwordLogin"
                    name="passwordLogin"
                    required
            />
        </div>
        <div>
            <button type="submit" class="CTA CTA--primary">Login</button>
            <%--                <button class="CTA CTA--secondary" data-openRegister >Sign up</button>--%>
        </div>
    </div>
</form>
</body>
</html>
