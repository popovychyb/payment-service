package com.payment.controller.user;

import com.payment.model.User;
import com.payment.service.UserService;
import com.payment.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/registration")
public class RegistrationController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/user/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String pwdRepeat = req.getParameter("pwd-repeat");

        if (pwd.equals(pwdRepeat)) {
            User user = new User(firstName, lastName, email, pwd);
            userService.create(user);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("message",
                    "Your password and repeat password aren't the same. Please try again.");
            req.getRequestDispatcher("/WEB-INF/views/user/registration.jsp").forward(req, resp);
        }
    }
}
