package com.payment.controller;

import com.payment.model.Bill;
import com.payment.model.Card;
import com.payment.model.Ticket;
import com.payment.model.User;
import com.payment.service.BillService;
import com.payment.service.CardService;
import com.payment.service.TicketService;
import com.payment.service.UserService;
import com.payment.service.impl.BillServiceImpl;
import com.payment.service.impl.CardServiceImpl;
import com.payment.service.impl.TicketServiceImpl;
import com.payment.service.impl.UserServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inject")
public class InjectDataController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final TicketService ticketService = new TicketServiceImpl();
    private final CardService cardService = new CardServiceImpl();
    private final BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User bob = new User("Bob", "Smith", "bob@mail.com", "qwerty");
        User lisa = new User("Lisa", "Bing", "lisa@mail.com", "12345");
        User admin = new User("John", "Anderson", "admin@payment.com", "1");
        admin.setRoleId(1L);
        userService.create(bob);
        userService.create(lisa);
        userService.create(admin);

        Card bobsCard = new Card(bob.getId());
        Card bobSecondAccount = new Card(bob.getId());
        Card lisaCard = new Card(lisa.getId());
        cardService.create(bobsCard);
        cardService.create(bobSecondAccount);
        cardService.create(lisaCard);

        Bill bobsBill = new Bill(bobsCard.getId(), lisaCard.getId(), new BigDecimal("1000"));
        Bill lisaBill = new Bill(lisaCard.getId(), bobsCard.getId(), new BigDecimal("500"));
        billService.create(bobsBill);
        billService.create(lisaBill);

        cardService.blockCard(bobsCard.getId());
        cardService.blockCard(lisaCard.getId());
        Ticket bobsTicket = new Ticket(bobsCard.getId());
        Ticket lisaTicket = new Ticket(lisaCard.getId());
        ticketService.create(bobsTicket);
        ticketService.create(lisaTicket);

        req.getRequestDispatcher("/WEB-INF/views/inject.jsp").forward(req, resp);
    }
}
