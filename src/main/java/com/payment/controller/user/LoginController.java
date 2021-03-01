package com.payment.controller.user;

import com.payment.exception.AuthenticationException;
import com.payment.model.User;
import com.payment.security.AuthenticationService;
import com.payment.security.AuthenticationServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private final AuthenticationService authService = new AuthenticationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");

        try {
            User user = authService.login(email, password);
            HttpSession session = req.getSession();
            session.setAttribute("user_id", user.getId());
            session.setAttribute("user_role_id", user.getRoleId());
        } catch (AuthenticationException e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
                    .forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
