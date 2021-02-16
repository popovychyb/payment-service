package com.payment.controller.card;

import com.payment.service.CardService;
import com.payment.service.impl.CardServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/card/delete")
public class DeleteCardController extends HttpServlet {
    private final CardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        cardService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/card/all");
    }
}
