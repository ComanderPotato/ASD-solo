<%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 23/10/2023
  Time: 7:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="DeleteUserServlet" method="post" class="modal modal-delete <%=isDeleteUserModalOpen ? "" : "hidden"%>" id="delete">
    <div class="modal-content">
        <div class="modal-title">
            <h1>Delete user</h1>
            <button data-close="delete">X</button>
        </div>
        <h4>
            Deleting user
            <span id="deleteEmail"></span>
        </h4>
        <div>
            <input type="hidden" id="deleteId" name="deleteId" value="">
            <button data-close="delete" class="CTA CTA--secondary">Cancel</button>
            <button type="submit" class="CTA CTA--primary">Confirm</button>
        </div>
    </div>
</form>
