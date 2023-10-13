<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 12/10/2023
  Time: 12:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Support</title>
    <link rel="stylesheet" href="./styles/global.css">
    <link rel="stylesheet" href="./styles/support.css">
    <link rel="stylesheet" href="./styles/navbar.css">

</head>
<body>
<main>
<%@include file="navbar.jsp"%>
    <div class="main">
<%--      <div class="support-form">--%>
      <form action="SupportServlet" method="post" class="support-form">
        <h1>Support Form</h1>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
          <label for="message">Tell us what the problem is:</label>
          <textarea id="message" name="message" rows="10" cols="50">
          </textarea>
        </div>
        <button type="submit" class="CTA CTA--primary">Submit</button>
      </form>
<%--      </div>--%>
    </div>
</main>
</body>
</html>
