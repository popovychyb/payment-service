package com.payment.controller.ticket;

import com.payment.service.TicketService;
import com.payment.service.impl.TicketServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ticket/allByUser")
public class ShowAllUserTicketsController extends HttpServlet {
    private final TicketService ticketService = new TicketServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("user_id");
        req.setAttribute("tickets", ticketService.getUserTickets(userId));
        req.getRequestDispatcher("/WEB-INF/views/ticket/allByUser.jsp").forward(req, resp);
    }
}
