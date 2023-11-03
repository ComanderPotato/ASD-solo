<%@ page import="CarBooking.Model.PaymentType" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 19/10/2023
  Time: 5:04 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="AddPaymentController" method="post" class="modal modal-payment <%=isPaymentModalOpen ? "" : "hidden"%>" id="payment">
  <div class="modal-content">
    <div class="modal-title">
      <h1>Payment</h1>
      <button data-close="payment">X</button>
    </div>
    <div class="form-group">
      <label for="cardNumber">Card Number:</label>
      <input
              class="payment-input"
              type="text"
              id="cardNumber"
              name="cardNumber"
              required
              data-cardNumber
              placeholder="<%=(cardNumErr != null ? cardNumErr : "Enter your card number")%>"

      />
    </div>
    <div class="form-group form-group">
      <label for="cardName">Card Name:</label>
      <input
              type="text"
              id="cardName"
              name="cardName"
              required
      />
    </div>
    <div class="form-group">
      <label for="cardExpiry">Card Expiry:</label>
      <input
              class="payment-input"
              type="text"
              id="cardExpiry"
              name="cardExpiry"
              required
              data-cardExpiry
              placeholder="<%=(cardExpiryErr != null ? cardExpiryErr : "MM/YY")%>"

      />
    </div>
    <div class="form-group">
      <label for="cardCvv">Card CVV:</label>
      <input
              class="payment-input"
              type="text"
              id="cardCvv"
              name="cardCvv"
              required
              data-cardCvv
              placeholder="<%=(cardCvvErr != null ? cardCvvErr : "CVV")%>"
      />
    </div>
    <div class="form-group">
      <label for="cardType">Payment Type:</label>
      <select name="cardType" id="cardType">
        <%
          if(paymentTypes != null)
            for(PaymentType paymentType : paymentTypes) {
        %>
          <option value="<%=paymentType.getId()%>"><%=paymentType.getType()%></option>
        <%
            }
        %>
      </select>
    </div>
    <%=(cardExists != null ? cardExists : " ")%>
    <div>
      <button type="submit" class="CTA CTA--primary">Add Payment</button>
    </div>
  </div>
</form>
