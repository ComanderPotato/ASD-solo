<%@ page import="java.util.ArrayList" %>
<%@ page import="CarBooking.Model.Payment" %>
<%@ page import="CarBooking.Model.Booking" %><%--
  Created by IntelliJ IDEA.
  User: tomgolding
  Date: 19/10/2023
  Time: 10:26 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cardNumErr = (String) session.getAttribute("cardNumErr");
    String cardExpiryErr = (String) session.getAttribute("cardExpiryErr");
    String cardCvvErr = (String) session.getAttribute("cardCvvErr");
    String cardExists = (String) session.getAttribute("cardExists");
    ArrayList<PaymentType> paymentTypes = (ArrayList<PaymentType>) session.getAttribute("paymentTypes");
    Boolean isPaymentOpen = (Boolean) session.getAttribute("isPaymentOpen");
    Boolean isPaymentModalOpen = (Boolean) session.getAttribute("isPaymentModalOpen");
%>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="./styles/accountDashboard.css">
    <link rel="stylesheet" href="./styles/modal.css">
    <script src="./script/accountDashboard.js" defer></script>
</head>
<body>
<main>

    <%@include file="navbar.jsp"%>

    <div class="main-account">
        <div class="account-nav">
            <nav>
                <a class="nav-links" href="#">Information</a>
            </nav>
        </div>
        <div class="account-nav">
            <nav>
                <button class="nav-links" data-accountRight data-account-orders <%
                    if(!isPaymentOpen) {%> disabled<% } %>>Order History</button>
                <button class="nav-links" data-accountRight data-account-payments <%
                    if(isPaymentOpen) {%> disabled<% } %>>Payment Methods</button>
            </nav>
        </div>
        <div class="account-info grid-section">

        </div>
        <div class="account-orders grid-section grid-right <%= !isPaymentOpen ? "" : "hidden" %>">
            <div class="list-container">
                <%
                    ArrayList<Booking> bookings = (ArrayList<Booking>) session.getAttribute("bookings");
                    if(bookings == null) bookings = new ArrayList<>();
                    if(!bookings.isEmpty())
                        for(Booking booking : bookings) {
                %>
                <div class="list-item">
                    <h2><%=booking.getUserId()%></h2>
                    <h3><%=booking.getTotal()%></h3>
                </div>
                <%
                        } else {
                %>
                <div class="list-item">
                    <h2>Looks like you've made no bookings, you suck!</h2>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <div class="account-payments grid-section grid-right <%= isPaymentOpen ? "" : "hidden" %>">
            <div class="list-container">
                <%
                    ArrayList<Payment> payments = (ArrayList<Payment>) session.getAttribute("payments");
                    if(payments != null)
                        for(Payment payment : payments) {
                %>
                <div class="list-item">
                    <div class="credit-card-box">
                        <div class="flip">
                            <div class="front">
                                <div class="chip"></div>
                                <div class="logo">
                                    <svg version="1.1" id="visa" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                         width="47.834px" height="47.834px" viewBox="0 0 47.834 47.834" style="enable-background:new 0 0 47.834 47.834;">
                                        <g>
                                            <g>
                                                <path d="M44.688,16.814h-3.004c-0.933,0-1.627,0.254-2.037,1.184l-5.773,13.074h4.083c0,0,0.666-1.758,0.817-2.143
                         c0.447,0,4.414,0.006,4.979,0.006c0.116,0.498,0.474,2.137,0.474,2.137h3.607L44.688,16.814z M39.893,26.01
                         c0.32-0.819,1.549-3.987,1.549-3.987c-0.021,0.039,0.317-0.825,0.518-1.362l0.262,1.23c0,0,0.745,3.406,0.901,4.119H39.893z
                         M34.146,26.404c-0.028,2.963-2.684,4.875-6.771,4.875c-1.743-0.018-3.422-0.361-4.332-0.76l0.547-3.193l0.501,0.228
                         c1.277,0.532,2.104,0.747,3.661,0.747c1.117,0,2.313-0.438,2.325-1.393c0.007-0.625-0.501-1.07-2.016-1.77
                         c-1.476-0.683-3.43-1.827-3.405-3.876c0.021-2.773,2.729-4.708,6.571-4.708c1.506,0,2.713,0.31,3.483,0.599l-0.526,3.092
                         l-0.351-0.165c-0.716-0.288-1.638-0.566-2.91-0.546c-1.522,0-2.228,0.634-2.228,1.227c-0.008,0.668,0.824,1.108,2.184,1.77
                         C33.126,23.546,34.163,24.783,34.146,26.404z M0,16.962l0.05-0.286h6.028c0.813,0.031,1.468,0.29,1.694,1.159l1.311,6.304
                         C7.795,20.842,4.691,18.099,0,16.962z M17.581,16.812l-6.123,14.239l-4.114,0.007L3.862,19.161
                         c2.503,1.602,4.635,4.144,5.386,5.914l0.406,1.469l3.808-9.729L17.581,16.812L17.581,16.812z M19.153,16.8h3.89L20.61,31.066
                         h-3.888L19.153,16.8z"/>
                                            </g>
                                        </g>
                                    </svg>
                                </div>
                                <div class="number" data-id="<%=payment.getId()%>"><%=payment.getNumberObscured()%></div>
                                <div class="number hidden" data-id="<%=payment.getId()%>"><%=payment.getNumberFormatted()%></div>
                                <div class="card-holder">
                                    <label>Card holder</label>
                                    <div><%=payment.getName()%></div>
                                </div>
                                <div class="card-expiration-date">
                                    <label>Expires</label>
                                    <div><%=payment.getExpiry()%></div>
                                </div>
                            </div>
                            <div class="back">
                                <div class="strip"></div>
                                <div class="logo">
                                    <svg version="1.1" id="visa" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                         width="47.834px" height="47.834px" viewBox="0 0 47.834 47.834" style="enable-background:new 0 0 47.834 47.834;">
                                        <g>
                                            <g>
                                                <path d="M44.688,16.814h-3.004c-0.933,0-1.627,0.254-2.037,1.184l-5.773,13.074h4.083c0,0,0.666-1.758,0.817-2.143
                         c0.447,0,4.414,0.006,4.979,0.006c0.116,0.498,0.474,2.137,0.474,2.137h3.607L44.688,16.814z M39.893,26.01
                         c0.32-0.819,1.549-3.987,1.549-3.987c-0.021,0.039,0.317-0.825,0.518-1.362l0.262,1.23c0,0,0.745,3.406,0.901,4.119H39.893z
                         M34.146,26.404c-0.028,2.963-2.684,4.875-6.771,4.875c-1.743-0.018-3.422-0.361-4.332-0.76l0.547-3.193l0.501,0.228
                         c1.277,0.532,2.104,0.747,3.661,0.747c1.117,0,2.313-0.438,2.325-1.393c0.007-0.625-0.501-1.07-2.016-1.77
                         c-1.476-0.683-3.43-1.827-3.405-3.876c0.021-2.773,2.729-4.708,6.571-4.708c1.506,0,2.713,0.31,3.483,0.599l-0.526,3.092
                         l-0.351-0.165c-0.716-0.288-1.638-0.566-2.91-0.546c-1.522,0-2.228,0.634-2.228,1.227c-0.008,0.668,0.824,1.108,2.184,1.77
                         C33.126,23.546,34.163,24.783,34.146,26.404z M0,16.962l0.05-0.286h6.028c0.813,0.031,1.468,0.29,1.694,1.159l1.311,6.304
                         C7.795,20.842,4.691,18.099,0,16.962z M17.581,16.812l-6.123,14.239l-4.114,0.007L3.862,19.161
                         c2.503,1.602,4.635,4.144,5.386,5.914l0.406,1.469l3.808-9.729L17.581,16.812L17.581,16.812z M19.153,16.8h3.89L20.61,31.066
                         h-3.888L19.153,16.8z"/>
                                            </g>
                                        </g>
                                    </svg>

                                </div>
                                <div class="ccv">
                                    <label>CCV</label>
                                    <div><%=payment.getCvv()%></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="payment-buttons">
                        <img src="./images/eye-off.svg" class="icon payment-icon payment-eye" data-id="<%=payment.getId()%>" alt="">
                        <img src="./images/eye-show.svg" class="icon payment-icon payment-eye hidden" data-id="<%=payment.getId()%>" alt="">
                        <form action="DeletePaymentController" method="post">
                            <input type="hidden" name="paymentId" value="<%=payment.getId()%>">
                            <button type="submit" class="payment-button"><img src="./images/delete.svg" class="icon payment-icon" alt=""></button>
                        </form>
                    </div>
                </div>
                <%
                        }
                %>
                <div class="list-item add-payment" data-type="payment" data-modalOpen>
                    <img src="./images/plus.svg" alt="" class="icon-plus">
                </div>
            </div>
        </div>
    </div>
    <%@include file="modalPayment.jsp"%>
</main
</body>
</html>