package com.payment.controller;

import com.payment.model.User;
import com.payment.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db")
public class TestDBController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String query = "SELECT * FROM users WHERE id = ?";

        try(Connection conn = ConnectionUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, 1L);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                User user = new User(null, null, email, null);
                user.setId(id);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
    }
}
