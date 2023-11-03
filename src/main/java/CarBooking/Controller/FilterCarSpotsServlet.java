package CarBooking.Controller;
import CarBooking.Controller.Validator;
import CarBooking.Model.CarSpot;
import CarBooking.Model.dao.CarSpotDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilterCarSpotsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String filter = request.getParameter("filter");
        int state = Integer.parseInt(request.getParameter("state"));
        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        ArrayList<CarSpot> filteredList;
        try {
            filteredList = carSpotManager.filterCarSpots(filter, state);
            session.setAttribute("carSpots", filteredList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
