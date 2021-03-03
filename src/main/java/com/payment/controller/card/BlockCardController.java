package com.payment.controller.card;

import com.payment.service.CardService;
import com.payment.service.impl.CardServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/card/block")
public class BlockCardController extends HttpServlet {
    private final CardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        cardService.blockCard(Long.valueOf(req.getParameter("id")));
        if ((Long) req.getSession().getAttribute("user_role_id") == 0) {
            resp.sendRedirect(req.getContextPath() + "/card/all");
        } else {
            resp.sendRedirect(req.getContextPath() + "/card/allByUser");
        }
    }
}
