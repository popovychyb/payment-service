package com.payment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ConnectionUtil {
    private static final Logger LOGGER = Logger.getLogger(ConnectionUtil.class);
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String URL =
            "jdbc:mysql://localhost:3306/payment_system?serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("MySQL JDBC driver not found", e);
            throw new RuntimeException("Can't find MySQL Driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("Can't establish connect to DB", e);
            throw new RuntimeException("Can't establish connect to DB", e);
        }
    }
}
