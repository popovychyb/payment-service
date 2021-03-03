package com.payment.controller.bill;

import com.payment.service.BillService;
import com.payment.service.impl.BillServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill/allByUser")
public class ShowAllUserBillsController extends HttpServlet {
    private final BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("user_id");
        req.setAttribute("bills", billService.getUserBills(userId));
        req.getRequestDispatcher("/WEB-INF/views/bill/allByUser.jsp").forward(req, resp);
    }
}
