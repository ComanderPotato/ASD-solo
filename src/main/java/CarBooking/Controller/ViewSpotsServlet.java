package CarBooking.Controller;
import CarBooking.Model.CarSpot;
import CarBooking.Model.Payment;
import CarBooking.Model.State;
import CarBooking.Model.User;
import CarBooking.Model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewSpotsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();

        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        ArrayList<CarSpot> carSpots;
        try {
            carSpots = carSpotManager.queryCarSpotsWithAddress();
            session.setAttribute("carSpots", carSpots);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();

        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        AddressDBManager addressManager = (AddressDBManager) session.getAttribute("addressManager");
        ArrayList<CarSpot> carSpots;
        try {
            carSpots = carSpotManager.queryCarSpots();
            for(CarSpot carSpot : carSpots) {
                carSpot.setAddress(addressManager.queryAddressById(carSpot.getAddressId()));
            }
            session.setAttribute("carSpots", carSpots);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("viewSpots.jsp").include(request, response);
    }
}
