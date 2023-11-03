package CarBooking.Controller;


import CarBooking.Model.Address;
import CarBooking.Model.CarSpot;
import CarBooking.Model.PaymentType;
import CarBooking.Model.State;
import CarBooking.Model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="ConnServlet", value="/ConnServlet")
public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private UserDBManager userManager;
    private SupportFormDBManager supportFormManager;
    private PaymentDBManager paymentManager;
    private PaymentTypeDBManager paymentTypeManager;
    private CarSpotDBManager carSpotManager;
    private BookingDBManager bookingManager;
    private AddressDBManager addressManager;
    private StateDBManager stateManager;
    private BookedDatesDBManager bookedDatesManager;

    private Connection conn;
    @Override
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn =  db.openConnection();
        ArrayList<State> states;
        ArrayList<PaymentType> paymentTypes;
        try {
            userManager = new UserDBManager(conn);
            supportFormManager = new SupportFormDBManager(conn);
            paymentManager = new PaymentDBManager(conn);
            paymentTypeManager = new PaymentTypeDBManager(conn);
            carSpotManager = new CarSpotDBManager(conn);
            bookingManager = new BookingDBManager(conn);
            addressManager = new AddressDBManager(conn);
            stateManager = new StateDBManager(conn);
            bookedDatesManager = new BookedDatesDBManager(conn);
            states = stateManager.queryStates();
            paymentTypes = paymentTypeManager.queryPaymentTypes();
            session.setAttribute("states", states);
            session.setAttribute("paymentTypes", paymentTypes);

        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        session.setAttribute("userManager", userManager);
        session.setAttribute("supportFormManager", supportFormManager);
        session.setAttribute("paymentManager", paymentManager);
        session.setAttribute("paymentTypeManager", paymentTypeManager);
        session.setAttribute("carSpotManager", carSpotManager);
        session.setAttribute("bookingManager", bookingManager);
        session.setAttribute("addressManager", addressManager);
        session.setAttribute("stateManager", stateManager);
        session.setAttribute("bookedDatesManager", bookedDatesManager);
        session.setAttribute("isLoginOpen", false);
        session.setAttribute("isRegisterOpen", false);
        session.setAttribute("isAddCarSpotModalOpen", false);
    }
    @Override
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}