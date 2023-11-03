package CarBooking.Controller;
import CarBooking.Controller.Validator;
import CarBooking.Model.BookedDates;
import CarBooking.Model.CarSpot;
import CarBooking.Model.dao.BookedDatesDBManager;
import CarBooking.Model.dao.CarSpotDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilterBookedDatesController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carParkId = Integer.parseInt(request.getParameter("carParkId"));
        BookedDatesDBManager bookedDatesManager = (BookedDatesDBManager) session.getAttribute("bookedDatesManager");
        ArrayList<BookedDates> bookedDates = new ArrayList<>();
        try {
            bookedDates = bookedDatesManager.queryBookingsByCarId(carParkId);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        response.getWriter().write(new JsonBuilder<BookedDates>().getJsonObject(bookedDates));

    }
}
