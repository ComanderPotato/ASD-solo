<%@ page import="CarBooking.Model.State" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 21/10/2023
  Time: 6:57 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean isAddCarSpotModalOpen = (Boolean) session.getAttribute("isAddCarSpotModalOpen");
%>
<form action="AddCarSpotController" method="post" class="modal modal-addCarSpot <%=isAddCarSpotModalOpen ? "" : "hidden"%>" id="addCarSpot">
    <div class="modal-content">
        <div class="modal-title">
            <h1>Add car spot</h1>
            <button data-close="addCarSpot">X</button>
        </div>
        <div class="form-group">
            <label for="locationName">Location name:</label>
            <input
                    type="text"
                    id="locationName"
                    name="locationName"
                    required
                    data-carSpotInput

            />
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input
                    type="text"
                    id="price"
                    name="price"
                    required
                    data-carSpotInput
            />
        </div>
        <div>
            Address
        </div>
        <div class="form-group">
            <label for="streetNumber">Street number:</label>
            <input
                    type="text"
                    id="streetNumber"
                    name="streetNumber"
                    data-carSpotInput
                    required
            />
        </div>
        <div class="form-group">
            <label for="addressLine">Address line:</label>
            <input
                    type="text"
                    id="addressLine"
                    name="addressLine"
                    required
                    data-carSpotInput

            />
        </div>
        <div class="form-group">
            <label for="suburb">Suburb:</label>
            <input
                    type="text"
                    id="suburb"
                    name="suburb"
                    required
                    data-carSpotInput

            />
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input
                    type="text"
                    id="city"
                    name="city"
                    required
                    data-carSpotInput

            />
        </div>
        <div class="form-group">
            <label for="postCode">Post code:</label>
            <input
                    type="text"
                    id="postCode"
                    name="postCode"
                    required
                    data-carSpotInput

            />
        </div>
        <select name="state" id="state">
            <%
                if(states != null)
                    for(State state : states) {

            %>
            <option value="<%=state.getId()%>"><%=state.getState()%></option>
            <%
                    }
            %>
        </select>
        <div>
            <button type="submit" class="CTA CTA--primary carSpot-button" disabled>Add car spot</button>
        </div>
    </div>
</form>
