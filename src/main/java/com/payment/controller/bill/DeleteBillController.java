package com.payment.controller.bill;

import com.payment.service.BillService;
import com.payment.service.impl.BillServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill/delete")
public class DeleteBillController extends HttpServlet {
    private final BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        billService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/bill/all");
    }
}
