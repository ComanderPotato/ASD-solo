package CarBooking.Controller;
import CarBooking.Model.Payment;
import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import CarBooking.Model.dao.PaymentDBManager;
import CarBooking.Model.dao.PaymentTypeDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int id = Integer.parseInt(request.getParameter("editId"));
        String email = request.getParameter("editEmail").toLowerCase();
        String password = request.getParameter("editPassword");
        String firstName = request.getParameter("editFirstName");
        String lastName = request.getParameter("editLastName");
        String phone = request.getParameter("editPhone");
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        User newUser = null;
        validator.clear(session);
        session.setAttribute("isEditUserModalOpen", true);
        session.setAttribute("isAdminSpotsOpen", false);
        session.setAttribute("isAdminUserOpen", true);
        session.setAttribute("isAdminFormsOpen", false);
        if(!validator.validateEmail(email) || !validator.validatePassword(password) || !validator.validatePhone(phone)) {
            if(!validator.validateEmail(email)) session.setAttribute("emailErr", "Error: Email format incorrect");

            if(!validator.validatePassword(password)) session.setAttribute("passErr", "Error: Password format incorrect");

            if(!validator.validatePhone(phone)) session.setAttribute("phoneErr", "Error: Phone number format incorrect");

            request.getRequestDispatcher("adminDashboard.jsp").include(request, response);
        } else {
            try {
                String encrypedPw = null;
                try {
                    encrypedPw = PasswordEncrypterDecrypter.encrypt(password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                User userToEdit = userManager.findUserByID(id);
                userToEdit.setEmail(email);
                userToEdit.setPassword(encrypedPw);
                userToEdit.setFirstName(firstName);
                userToEdit.setLastName(lastName);
                userToEdit.setPhoneNumber(phone);
                userManager.updateUser(userToEdit);
                session.setAttribute("isEditUserModalOpen", false);
                request.getRequestDispatcher("AdminServlet").include(request, response);
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
