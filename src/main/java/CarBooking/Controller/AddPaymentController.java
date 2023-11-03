package CarBooking.Controller;
import CarBooking.Model.Payment;
import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import CarBooking.Model.dao.PaymentDBManager;
import CarBooking.Model.dao.PaymentTypeDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class AddPaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String previousUrl = "accountDashboard.jsp";
        String cardName = request.getParameter("cardName");
        String cardNumber = request.getParameter("cardNumber").replaceAll("-", "");
        String cardExpiry = request.getParameter("cardExpiry");
        String cardCvv = request.getParameter("cardCvv");
        int paymentType = Integer.parseInt(request.getParameter("cardType"));
        PaymentDBManager paymentManager = (PaymentDBManager) session.getAttribute("paymentManager");
        User sessionUser = (User) session.getAttribute("sessionUser");
        Payment newPayment = null;
        validator.clear(session);
        session.setAttribute("isPaymentOpen", true);
        session.setAttribute("isPaymentModalOpen", true);
        if(!validator.validateCardNumber(cardNumber) || !validator.validateCardExpiry(cardExpiry) || !validator.validateCardCvv(cardCvv)) {
            if(!validator.validateCardNumber(cardNumber)) session.setAttribute("cardNumErr", "Error: Card number format incorrect");

            if(!validator.validateCardExpiryFormat(cardExpiry) && !validator.validateCardExpiryFormat(cardExpiry)) {
                session.setAttribute("cardExpiryErr", "Error: Card has expired and format incorrect");
            } else if(!validator.validateCardExpiryFormat(cardExpiry)) {
                session.setAttribute("cardExpiryErr", "Error: Card expiry format incorrect");
            } else {
                session.setAttribute("cardExpiryErr", "Error: Card has expired");
            }

            if(!validator.validateCardCvv(cardCvv)) session.setAttribute("cardCvvErr", "Error: Card CVV format incorrect");
            request.getRequestDispatcher(previousUrl).include(request, response);
        } else {
            try {
                newPayment = new Payment(sessionUser.getId(), paymentType, cardName, cardNumber, cardExpiry, cardCvv);
                if(!paymentManager.paymentExists(newPayment)) {
                    paymentManager.addPayment(newPayment);
                    session.setAttribute("isPaymentModalOpen", false);
                    request.getRequestDispatcher("AccountServlet").include(request, response);

                } else {
                    session.setAttribute("cardExists", "Payment method already exists on this account");
                    request.getRequestDispatcher(previousUrl).include(request, response);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
