package CarBooking.Controller;
import CarBooking.Model.User;
import CarBooking.Model.dao.UserDBManager;
import CarBooking.Model.dao.PaymentDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("deleteId"));
        User sessionUser = (User) session.getAttribute("sessionUser");
        String previousUrl = sessionUser.isAdmin() ? "AdminServlet" : "AccountServlet";
        UserDBManager userManager = (UserDBManager) session.getAttribute("userManager");
        PaymentDBManager paymentManager = (PaymentDBManager) session.getAttribute("paymentManager");
        session.setAttribute("isDeleteUserModalOpen", true);
        session.setAttribute("isAdminSpotsOpen", false);
        session.setAttribute("isAdminUserOpen", true);
        session.setAttribute("isAdminFormsOpen", false);
        try {
            paymentManager.removeAllUserPayments(userId);
            userManager.deleteUser(userId);
            session.setAttribute("isDeleteUserModalOpen", false);
            request.getRequestDispatcher(previousUrl).include(request, response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
