package CarBooking.Controller;
import CarBooking.Controller.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class MakeBookingController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String carSpotId = request.getParameter("carSpotId");
        String paymentId = request.getParameter("paymentId");
        String arrivalDate = request.getParameter("arrivalDate");
        String arrivalTime = request.getParameter("arrivalTime");
        String exitDate = request.getParameter("exitDate");
        String exitTime = request.getParameter("exitTime");
        String dateBooked = Formatter.formatDateTime(LocalDateTime.now());
    }
}