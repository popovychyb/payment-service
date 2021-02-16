package com.payment.controller.user;

import com.payment.model.enums.Role;
import com.payment.service.UserService;
import com.payment.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/role")
public class ChangeUserRoleController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        if (userService.get(id).get().getRole().equals(Role.ADMIN)) {
            userService.reduceToUser(id);
        } else {
            userService.raiseToAdmin(id);
        }
        resp.sendRedirect("/user/all");
    }
}
