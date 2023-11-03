package CarBooking.Controller;
import java.io.IOException;

import CarBooking.Model.*;
import CarBooking.Model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.ArrayList;


public class BookingPicker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String filterString = request.getParameter("filterString");
        int stateId = Integer.parseInt(request.getParameter("stateId"));

        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        try {
            carSpots = carSpotManager.filterCarSpots(filterString, stateId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        response.getWriter().write(new JsonBuilder<CarSpot>().getJsonObject(carSpots));


    }
}
