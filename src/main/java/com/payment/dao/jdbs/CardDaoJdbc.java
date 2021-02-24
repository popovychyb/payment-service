package com.payment.dao.jdbs;

import com.payment.dao.CardDao;
import com.payment.model.Card;
import com.payment.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardDaoJdbc implements CardDao {

    @Override
    public List<Card> getUserCards(Long id) {
        String selectUserCardsQuery = "SELECT * FROM cards WHERE users_id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(selectUserCardsQuery)) {
            statement.setLong(1, id);
            List<Card> cards = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Card card = null;
            while (resultSet.next()){
                card = getCardFromResultSet(resultSet).get();
                cards.add(card);
            }
            return cards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Card create(Card card) {
        String query = "INSERT INTO cards (card_number, users_id, balance, title, activity_status_id) "
                + "VALUES (?, ?, ?, ?, ?);";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, card.getNumber());
            statement.setLong(2, card.getIdUser());
            statement.setBigDecimal(3, card.getBalance());
            statement.setString(4, card.getTitle());
            statement.setLong(5, card.getActivityStatusId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()){
                resultSet.next();
                card.setId(resultSet.getLong(1));
                return card;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Card> get(Long id) {
        String selectCardQuery = "SELECT * FROM cards WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(selectCardQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getCardFromResultSet(resultSet);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<Card> getCardFromResultSet(ResultSet resultSet) throws SQLException {
        Card card = new Card(resultSet.getLong("users_id"));
        card.setId(resultSet.getLong("id"));
        card.setNumber(resultSet.getString("card_number"));
        card.setBalance(resultSet.getBigDecimal("balance"));
        card.setTitle(resultSet.getString("title"));
        card.setActivityStatusId(resultSet.getLong("activity_status_id"));
        return Optional.of(card);
    }

    @Override
    public List<Card> getAll() {
        String selectAllCardsQuery = "SELECT * FROM cards;";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(selectAllCardsQuery)) {
            List<Card> cards = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Card card = null;
            while (resultSet.next()){
                card = getCardFromResultSet(resultSet).get();
                cards.add(card);
            }
            return cards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Card update(Card card) {
        String updateCardQuery = "UPDATE cards SET card_number = ?, users_id = ?, balance = ?, " +
                "title = ?, activity_status_id = ? WHERE id = ?;";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(updateCardQuery)){
            statement.setString(1, card.getNumber());
            statement.setLong(2, card.getIdUser());
            statement.setBigDecimal(3, card.getBalance());
            statement.setString(4, card.getTitle());
            statement.setLong(5, card.getActivityStatusId());
            statement.setLong(6, card.getId());
            statement.executeUpdate();
            return card;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteCardQuery = "DELETE FROM cards WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(deleteCardQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
