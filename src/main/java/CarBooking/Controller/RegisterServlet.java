package CarBooking.Controller;

import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import CarBooking.Controller.PasswordEncrypterDecrypter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String previousUrl = URLHelper.getPrevious(request.getHeader("referer"));
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDob = LocalDate.parse(dob, format);
        String phone = request.getParameter("phone");
        String adminCode = request.getParameter("adminCode");
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        User newUser = null;
        validator.clear(session);
        session.setAttribute("isRegisterOpen", true);
        if(!validator.validateEmail(email) || !validator.validatePassword(password) || !validator.validatePhone(phone) || !validator.validateDob(formatDob)) {

            if(!validator.validateEmail(email)) session.setAttribute("emailErr", "Error: Email format incorrect");

            if(!validator.validatePassword(password)) session.setAttribute("passErr", "Error: Password format incorrect");

            if(!validator.validatePhone(phone)) session.setAttribute("phoneErr", "Error: Phone number format incorrect");

            if(!validator.validateDob(formatDob)) {
                LocalDate minDate = LocalDate.now().minusYears(16).plusDays(1);
                LocalDate maxDate = LocalDate.now().minusYears(100);
                session.setAttribute("dateErr", String.format("Error: must be between %s and %s", minDate, maxDate));
            }

            request.getRequestDispatcher(previousUrl).include(request, response);
        }
        else {
            try {
                if(!userManager.userExists(email)) {
                    String encryptedPassword = null;
                    try {
                        encryptedPassword = PasswordEncrypterDecrypter.encrypt(password);
                    } catch (Exception e) {

                    }
                    newUser = new User(email, encryptedPassword, firstName, lastName, formatDob, phone, adminCode);
                    userManager.addUser(newUser);
                    User sessionUser = userManager.findUser(email, encryptedPassword);
                    if(sessionUser != null) {
                        session.setAttribute("isLoggedIn", true);
                        session.setAttribute("sessionUser", sessionUser);
                        session.setAttribute("isRegisterOpen", false);
                        request.getRequestDispatcher("MainServlet").include(request, response);
                    }
                } else {
                    session.setAttribute("userExists", "User with email already exists");

                    request.getRequestDispatcher(previousUrl).include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
                request.getRequestDispatcher(previousUrl).include(request, response);
            }
        }

    }
}