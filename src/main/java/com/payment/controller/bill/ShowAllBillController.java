package com.payment.controller.bill;

import com.payment.model.Bill;
import com.payment.service.BillService;
import com.payment.service.impl.BillServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill/all")
public class ShowAllBillController extends HttpServlet {
    private final BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Bill> bills = billService.getAll();
        req.setAttribute("bills", bills);
        req.getRequestDispatcher("/WEB-INF/views/bill/all.jsp").forward(req, resp);
    }
}
