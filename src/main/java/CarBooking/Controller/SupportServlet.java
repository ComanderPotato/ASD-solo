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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        SupportFormDBManager supportManager = (SupportFormDBManager) session.getAttribute("supportManager");
        SupportForm form = new SupportForm(email, message);
        validator.clear(session);
        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("support.jsp").include(request, response);
        }
        else {
            try {
                supportManager.addSupportForm(form);
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
            }
            request.getRequestDispatcher("index.jsp").include(request, response);
        }

    }
}