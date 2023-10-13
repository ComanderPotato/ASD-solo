<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./styles/global.css">

    <link rel="stylesheet" href="./styles/modal.css">
</head>
<body>
<form action="RegisterServlet" method="post">
    <div class="modal-content">
        <div class="modal-title">
            <h1>Register</h1>
<%--            <button data-close="register">X</button>--%>
            <a href="index.jsp">Back</a>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input
                    type="text"
                    id="email"
                    name="email"
                    required
            />
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input
                    type="password"
                    id="password"
                    name="password"
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
        </div>
    </div>
</form>
</body>
</html>