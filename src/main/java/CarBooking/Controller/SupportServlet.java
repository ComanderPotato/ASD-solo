package CarBooking.Controller;

import CarBooking.Model.SupportForm;
import CarBooking.Model.User;
import CarBooking.Model.dao.SupportFormDBManager;
import CarBooking.Model.dao.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SupportServlet extends HttpServlet {
    private static final int MESSAGE_COUNT = 200;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email").toLowerCase();
        String message = request.getParameter("message");
        SupportFormDBManager supportManager = (SupportFormDBManager) session.getAttribute("supportFormManager");
        SupportForm supportForm = new SupportForm(email, message);
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        boolean validUser = false;
        try {
            if(userManager.userExists(email)) {
                supportForm = new SupportForm(userManager.findUserByEmail(email).getId(), email, message);
                validUser = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        validator.clear(session);
        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("support.jsp").include(request, response);
        }
        else {
            try {
                if(validUser) {
                    supportManager.addSupportFormWithId(supportForm);
                } else {
                    supportManager.addSupportFormNoId(supportForm);
                }
                request.getRequestDispatcher("support.jsp").include(request, response);
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
                request.getRequestDispatcher("support.jsp").include(request, response);
            }
        }

    }
}