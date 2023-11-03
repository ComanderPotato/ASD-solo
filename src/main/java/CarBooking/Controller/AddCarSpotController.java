package CarBooking.Controller;
import CarBooking.Model.*;
import CarBooking.Model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddCarSpotController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        String locationName = request.getParameter("locationName").trim();
        double price = Double.parseDouble(request.getParameter("price"));
        String streetNumber = request.getParameter("streetNumber").trim();
        String addressLine = request.getParameter("addressLine").trim();
        String suburb = request.getParameter("suburb").trim();
        String city = request.getParameter("city").trim();
        String postCode = request.getParameter("postCode").trim();
        int state = Integer.parseInt(request.getParameter("state"));
        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        AddressDBManager addressManager = (AddressDBManager) session.getAttribute("addressManager");
        CarSpot carSpot = null;
        Address address = null;
        session.setAttribute("isAddCarSpotModalOpen", true);
        session.setAttribute("isAdminSpotsOpen", true);
        session.setAttribute("isAdminUserOpen", false);
        session.setAttribute("isAdminFormsOpen", false);
        try {
            if(!carSpotManager.carSpotExists(locationName)) {
                address = new Address(state, streetNumber, addressLine, suburb, city, postCode);
                int addressId = addressManager.addAddress(address);
                carSpot = new CarSpot(addressId, locationName, price);
                carSpotManager.addCarSpot(carSpot);
                session.setAttribute("isAddCarSpotModalOpen", false);
                request.getRequestDispatcher("AdminServlet").include(request, response);
            } else {
                session.setAttribute("carSpotExists", "Car spot already exists");
                request.getRequestDispatcher("adminDashboard.jsp").include(request, response);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
