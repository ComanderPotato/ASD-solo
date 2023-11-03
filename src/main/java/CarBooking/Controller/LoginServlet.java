package CarBooking.Controller;
import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    // Retrieves the user information from the login modal. First validates the inputs follow the specific criteria.
    // If they dont, it gets returned with necessary fields that are wrong. Else, it checks if the user does exists,
    // If the user exists, it will try and find the user within the database. Else returns and states that the user
    // doesnt exist.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        session.setAttribute("isLoginOpen", true);
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        String previousUrl = URLHelper.getPrevious(request.getHeader("referer"));
        User user = null;
        validator.clear(session);
        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher(previousUrl).include(request, response);
        } else if(!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher(previousUrl).include(request, response);
        } else {
            try {
                if(userManager.userExists(email)) {
                    user = userManager.findUser(email, PasswordEncrypterDecrypter.encrypt(password));

                    if(user != null) {
                        session.setAttribute("isLoggedIn", true);
                        session.setAttribute("isLoginOpen", false);
                        session.setAttribute("sessionUser", user);
                        request.getRequestDispatcher("MainServlet").include(request, response);
                    } else {
                        session.setAttribute("existErr", "Incorrect email or password");
                        request.getRequestDispatcher(previousUrl).include(request, response);
                    }
                } else {
                    session.setAttribute("existErr", "Account not found");

                    request.getRequestDispatcher(previousUrl).include(request, response);


                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "user does not exist" : "Welcome");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
