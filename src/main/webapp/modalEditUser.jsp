<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 22/10/2023
  Time: 6:11 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="EditUserServlet" method="post" class="modal modal-edit <%=isEditUserModalOpen ? "" : "hidden"%>" id="edit">
    <div class="modal-content">
        <div class="modal-title">
            <h1>Edit user</h1>
            <button data-close="register">X</button>
        </div>
        <div class="form-group">
            <label for="editEmail">Email:</label>
            <input
                    type="text"
                    id="editEmail"
                    class="input--edit-user"
                    name="editEmail"
                    required
                    placeholder="<%=(emailErr != null ? emailErr : "Enter your email")%>"
            />
        </div>
        <div class="form-group form-group-password">
            <label for="editPassword">Password:</label>
            <input
                    type="password"
                    id="editPassword"
                    class="input--edit-user"
                    name="editPassword"
                    required
                    placeholder="<%=(passErr != null ? passErr : "Enter your password")%>"
            />
            <img src="./images/eye-off.svg" alt="" class="icon icon-eye" data-show date-eye>
            <img src="./images/eye-show.svg" alt="" class="icon icon-eye hidden" data-hide data-eye>
        </div>
        <div class="form-group">
            <label for="editFirstName">First Name:</label>
            <input
                    type="text"
                    id="editFirstName"
                    class="input--edit-user"
                    name="editFirstName"
                    required
            />
        </div>
        <div class="form-group">
            <label for="editLastName">Last Name:</label>
            <input
                    type="text"
                    id="editLastName"
                    class="input--edit-user"
                    name="editLastName"
                    required
            />
        </div>
        <div class="form-group">
            <label for="editPhone">Phone Number:</label>
            <input
                    type="tel"
                    id="editPhone"
                    class="input--edit-user"
                    name="editPhone"
                    required
                    placeholder="<%=(phoneErr != null ? phoneErr : "Enter your phone number")%>"
            />
        </div>
        <div>
            <input type="hidden" id="editId" name="editId" value="">
            <button type="submit" class="CTA CTA--primary">Edit user</button>
        </div>
    </div>
</form>
