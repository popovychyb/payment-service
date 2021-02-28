package com.payment.controller.ticket;

import com.payment.model.Ticket;
import com.payment.service.TicketService;
import com.payment.service.impl.TicketServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ticket/all")
public class ShowAllTicketController extends HttpServlet {
    private final TicketService ticketService = new TicketServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Ticket> tickets = ticketService.getAll();
        req.setAttribute("tickets", tickets);
        req.getRequestDispatcher("/WEB-INF/views/ticket/all.jsp").forward(req, resp);
    }
}
