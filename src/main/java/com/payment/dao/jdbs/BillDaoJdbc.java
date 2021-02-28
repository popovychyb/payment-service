package com.payment.dao.jdbs;

import com.payment.dao.BillDao;
import com.payment.model.Bill;
import com.payment.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillDaoJdbc implements BillDao {

    @Override
    public List<Bill> getBillsBySenderAccount(Long id) {
        String selectBillsBySenderQuery = "SELECT * FROM bills WHERE sender_card_id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectBillsBySenderQuery)) {
            statement.setLong(1, id);
            List<Bill> bills = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Bill bill = null;
            while (resultSet.next()) {
                bill = getBillsFromResultSet(resultSet).get();
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bill> getBillsByRecipientAccount(Long id) {
        String selectBillsBySenderQuery = "SELECT * FROM bills WHERE recipient_card_id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectBillsBySenderQuery)) {
            statement.setLong(1, id);
            List<Bill> bills = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Bill bill = null;
            while (resultSet.next()) {
                bill = getBillsFromResultSet(resultSet).get();
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bill> getBillsByAccount(Long id) {
        String selectBillsBySenderQuery = "SELECT * FROM bills WHERE (recipient_card_id = ?) "
                + "OR (sender_card_id = ?);";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectBillsBySenderQuery)) {
            statement.setLong(1, id);
            statement.setLong(2, id);
            List<Bill> bills = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Bill bill = null;
            while (resultSet.next()) {
                bill = getBillsFromResultSet(resultSet).get();
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bill create(Bill bill) {
        String query =
                "INSERT INTO bills (sender_card_id, recipient_card_id, "
                        + "payment, bill_status_id) VALUES (?, ?, ?, ?);";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, bill.getSenderCardId());
            statement.setLong(2, bill.getRecipientCardId());
            statement.setBigDecimal(3, bill.getPayment());
            statement.setLong(4, bill.getBillStatusId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                bill.setId(resultSet.getLong(1));
                return bill;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Bill> get(Long id) {
        String selectBillQuery = "SELECT * FROM bills WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectBillQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getBillsFromResultSet(resultSet);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<Bill> getBillsFromResultSet(ResultSet resultSet) throws SQLException {
        Bill bill = new Bill(resultSet.getLong("sender_card_id"),
                resultSet.getLong("recipient_card_id"),
                resultSet.getBigDecimal("payment"));
        bill.setId(resultSet.getLong("id"));
        bill.setBillStatusId(resultSet.getLong("bill_status_id"));
        return Optional.of(bill);
    }

    @Override
    public List<Bill> getAll() {
        String selectAllBillsQuery = "SELECT * FROM bills;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectAllBillsQuery)) {
            List<Bill> bills = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Bill bill = null;
            while (resultSet.next()) {
                bill = getBillsFromResultSet(resultSet).get();
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bill update(Bill bill) {
        String updateBillQuery = "UPDATE bills SET sender_card_id = ?, recipient_card_id = ?, "
                + "payment = ?, bill_status_id = ? WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(updateBillQuery)) {
            statement.setLong(1, bill.getSenderCardId());
            statement.setLong(2, bill.getRecipientCardId());
            statement.setBigDecimal(3, bill.getPayment());
            statement.setLong(4, bill.getBillStatusId());
            statement.setLong(5, bill.getId());
            statement.executeUpdate();
            return bill;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteBillQuery = "DELETE FROM bills WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(deleteBillQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
