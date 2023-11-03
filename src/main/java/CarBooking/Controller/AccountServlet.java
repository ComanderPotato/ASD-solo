package CarBooking.Controller;
import CarBooking.Model.Booking;
import CarBooking.Model.Payment;
import CarBooking.Model.User;
import CarBooking.Model.dao.BookingDBManager;
import CarBooking.Model.dao.PaymentDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        PaymentDBManager paymentManager = (PaymentDBManager) session.getAttribute("paymentManager");
        BookingDBManager bookingManager = (BookingDBManager) session.getAttribute("bookingManager");
        User sessionUser = (User) session.getAttribute("sessionUser");
        ArrayList<Payment> payments;
        ArrayList<Booking> bookings;
        try {
            bookings = bookingManager.queryBookingsByUserID(sessionUser.getId());
            payments = paymentManager.queryPayments(sessionUser.getId());
            session.setAttribute("bookings", bookings);
            session.setAttribute("payments", payments);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        if(session.getAttribute("visitedAccount") == null) {
            session.setAttribute("isPaymentModalOpen", false);
            session.setAttribute("isPaymentOpen", false);
        }

        session.setAttribute("visitedAccount", true);

        request.getRequestDispatcher("accountDashboard.jsp").include(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        PaymentDBManager paymentManager = (PaymentDBManager) session.getAttribute("paymentManager");
        BookingDBManager bookingManager = (BookingDBManager) session.getAttribute("bookingManager");
        User sessionUser = (User) session.getAttribute("sessionUser");
        ArrayList<Payment> payments;
        ArrayList<Booking> bookings;
        try {
            bookings = bookingManager.queryBookingsByUserID(sessionUser.getId());
            payments = paymentManager.queryPayments(sessionUser.getId());
            session.setAttribute("bookings", bookings);
            session.setAttribute("payments", payments);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        if(session.getAttribute("visitedAccount") == null) {
            session.setAttribute("isPaymentModalOpen", false);
            session.setAttribute("isPaymentOpen", false);
        }

        session.setAttribute("visitedAccount", true);
        request.getRequestDispatcher("accountDashboard.jsp").include(request, response);
    }
}
