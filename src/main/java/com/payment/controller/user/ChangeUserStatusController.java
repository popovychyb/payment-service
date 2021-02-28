package com.payment.controller.user;

import com.payment.model.enums.ActivityStatus;
import com.payment.service.UserService;
import com.payment.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/block")
public class ChangeUserStatusController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        if (userService.get(id).get().getActivityStatusId()
                .equals((long) ActivityStatus.valueOf("ACTIVE").ordinal())) {
            userService.blockUser(id);
        } else {
            userService.unblockUser(id);
        }
        resp.sendRedirect(req.getContextPath() + "/user/all");
    }
}
