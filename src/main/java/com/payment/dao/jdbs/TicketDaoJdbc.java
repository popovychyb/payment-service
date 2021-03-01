package com.payment.dao.jdbs;

import com.payment.dao.TicketDao;
import com.payment.model.Ticket;
import com.payment.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoJdbc implements TicketDao {

    @Override
    public Ticket create(Ticket ticket) {
        String query = "INSERT INTO tickets (card_id, ticket_status_id) "
                + "VALUES (?, ?);";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, ticket.getCardId());
            statement.setLong(2, ticket.getTicketStatusId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                ticket.setId(resultSet.getLong(1));
                return ticket;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Ticket> get(Long id) {
        String selectTicketQuery = "SELECT * FROM tickets WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectTicketQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getTicketFromResultSet(resultSet);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<Ticket> getTicketFromResultSet(ResultSet resultSet)
            throws SQLException {
        Ticket ticket = new Ticket(resultSet.getLong("card_id"));
        ticket.setId(resultSet.getLong("id"));
        ticket.setTicketStatusId(resultSet.getLong("ticket_status_id"));
        return Optional.of(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        String selectAllTicketsQuery = "SELECT * FROM tickets;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectAllTicketsQuery)) {
            List<Ticket> tickets = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Ticket ticket = null;
            while (resultSet.next()) {
                ticket = getTicketFromResultSet(resultSet).get();
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ticket update(Ticket ticket) {
        String updateTicketQuery = "UPDATE tickets SET card_id = ?, "
                + "ticket_status_id = ? WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(updateTicketQuery)) {
            statement.setLong(1, ticket.getCardId());
            statement.setLong(2, ticket.getTicketStatusId());
            statement.setLong(3, ticket.getId());
            statement.executeUpdate();
            return ticket;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteTicketQuery = "DELETE FROM tickets WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(deleteTicketQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ticket> getUserTickets(Long id) {
        String selectUserTicketsQuery = "SELECT * FROM tickets WHERE card_id IN "
                + "(SELECT id FROM cards WHERE users_id = ?);";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectUserTicketsQuery)) {
            statement.setLong(1, id);
            List<Ticket> tickets = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Ticket ticket = null;
            while (resultSet.next()) {
                ticket = getTicketFromResultSet(resultSet).get();
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
