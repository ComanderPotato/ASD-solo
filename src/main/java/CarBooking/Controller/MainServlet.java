package CarBooking.Controller;

import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        User user;
        validator.clear(session);
        if(isLoggedIn) {

            user = (User) session.getAttribute("user");
        }

        request.getRequestDispatcher("index.jsp").include(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        User user;
        validator.clear(session);
        if(isLoggedIn) {
            user = (User) session.getAttribute("user");
        }

        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}