package com.payment.controller.card;

import com.payment.model.Card;
import com.payment.service.CardService;
import com.payment.service.impl.CardServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/card/all")
public class ShowAllCardController extends HttpServlet {
    private final CardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Card> cards = cardService.getAll();
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("/WEB-INF/views/card/all.jsp").forward(req, resp);
    }
}
