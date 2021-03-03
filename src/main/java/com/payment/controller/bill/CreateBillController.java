package com.payment.controller.bill;

import com.payment.exception.NoSuchCardException;
import com.payment.model.Bill;
import com.payment.service.BillService;
import com.payment.service.CardService;
import com.payment.service.impl.BillServiceImpl;
import com.payment.service.impl.CardServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill/new")
public class CreateBillController extends HttpServlet {
    private final BillService billService = new BillServiceImpl();
    private final CardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("user_id");
        req.setAttribute("cards", cardService.getUserCards(userId));
        req.getRequestDispatcher("/WEB-INF/views/bill/new.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String senderCard = req.getParameter("senderCard");
        String recipientCard = req.getParameter("recipientCard");
        BigDecimal payment = new BigDecimal(req.getParameter("payment"));

        Long senderCardId = cardService.getByNumber(senderCard).get().getId();
        try {
            Long recipientCardId = cardService.getByNumber(recipientCard).orElseThrow(() ->
                    new NoSuchCardException("No such card")).getId();
            billService.create(new Bill(senderCardId, recipientCardId, payment));
        } catch (NoSuchCardException e) {
            req.setAttribute("errorMsg", e.getMessage());
            Long userId = (Long) req.getSession().getAttribute("user_id");
            req.setAttribute("cards", cardService.getUserCards(userId));
            req.getRequestDispatcher("/WEB-INF/views/bill/new.jsp")
                    .forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/bill/allByUser");
    }
}
