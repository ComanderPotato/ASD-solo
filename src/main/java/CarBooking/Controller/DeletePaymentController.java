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

public class DeletePaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("paymentId"));
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        PaymentDBManager paymentManager = (PaymentDBManager) session.getAttribute("paymentManager");
        session.setAttribute("isPaymentOpen", true);
        try {
            paymentManager.removePayment(paymentId);
            request.getRequestDispatcher("AccountServlet").include(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
