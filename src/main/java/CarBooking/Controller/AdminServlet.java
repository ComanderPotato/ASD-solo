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

public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        AddressDBManager addressManager = (AddressDBManager) session.getAttribute("addressManager");
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        SupportFormDBManager supportFormManager = (SupportFormDBManager) session.getAttribute("supportFormManager");
        ArrayList<CarSpot> carSpots;
        ArrayList<User> users;
        ArrayList<SupportForm> supportForms;
        try {
            carSpots = carSpotManager.queryCarSpots();
            users = userManager.queryUsers();
            supportForms = supportFormManager.querySupportFormWithUser();
            for(CarSpot carSpot : carSpots) {
                carSpot.setAddress(addressManager.queryAddressById(carSpot.getAddressId()));
            }
            session.setAttribute("carSpots", carSpots);
            session.setAttribute("users", users);
            session.setAttribute("supportForms", supportForms);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        if(session.getAttribute("visitedAdmin") == null) {
            session.setAttribute("isEditCarModalOpen", false);
            session.setAttribute("isEditUserModalOpen", false);
            session.setAttribute("isDeleteUserModalOpen", false);
            session.setAttribute("isAdminSpotsOpen", true);
            session.setAttribute("isAdminUserOpen", false);
            session.setAttribute("isAdminFormsOpen", false);

        }
        session.setAttribute("visitedAdmin", true);
        request.getRequestDispatcher("adminDashboard.jsp").include(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        CarSpotDBManager carSpotManager = (CarSpotDBManager) session.getAttribute("carSpotManager");
        AddressDBManager addressManager = (AddressDBManager) session.getAttribute("addressManager");
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        SupportFormDBManager supportFormManager = (SupportFormDBManager) session.getAttribute("supportFormManager");
        ArrayList<CarSpot> carSpots;
        ArrayList<User> users;
        ArrayList<SupportForm> supportForms;
        try {
            carSpots = carSpotManager.queryCarSpots();
            users = userManager.queryUsers();
            supportForms = supportFormManager.querySupportFormWithUser();
            for(CarSpot carSpot : carSpots) {
                carSpot.setAddress(addressManager.queryAddressById(carSpot.getAddressId()));
            }
            session.setAttribute("carSpots", carSpots);
            session.setAttribute("users", users);
            session.setAttribute("supportForms", supportForms);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        if(session.getAttribute("visitedAdmin") == null) {
            session.setAttribute("isEditCarModalOpen", false);
            session.setAttribute("isEditUserModalOpen", false);
            session.setAttribute("isDeleteUserModalOpen", false);
            session.setAttribute("isAdminSpotsOpen", true);
            session.setAttribute("isAdminUserOpen", false);
            session.setAttribute("isAdminFormsOpen", false);

        }
        session.setAttribute("visitedAdmin", true);
        request.getRequestDispatcher("adminDashboard.jsp").include(request, response);
    }
}