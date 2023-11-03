package CarBooking.Controller;

import CarBooking.Model.CarSpot;
import CarBooking.Model.User;
import CarBooking.Model.dao.AddressDBManager;
import CarBooking.Model.dao.CarSpotDBManager;
import CarBooking.Model.dao.UserDBManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.logging.*;


public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String previousUrl = URLHelper.getPrevious(request.getHeader("referer"));
        validator.clear(session);
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
        request.getRequestDispatcher(previousUrl).include(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String previousUrl = URLHelper.getPrevious(request.getHeader("referer"));
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
        request.getRequestDispatcher(previousUrl).include(request, response);
    }
}
