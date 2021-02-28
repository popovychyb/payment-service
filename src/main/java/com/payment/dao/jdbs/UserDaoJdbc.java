package com.payment.dao.jdbs;

import com.payment.dao.UserDao;
import com.payment.model.User;
import com.payment.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJdbc implements UserDao {
    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User create(User user) {
        String query = "INSERT INTO users (first_name, last_name, email, password, "
                + "role_id, activity_status_id) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setLong(5, user.getRoleId());
            statement.setLong(6, user.getActivityStatusId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                user.setId(resultSet.getLong(1));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> get(Long id) {
        String selectUserQuery = "SELECT * FROM users WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectUserQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        String selectAllUsersQuery = "SELECT * FROM users;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(selectAllUsersQuery)) {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet).get();
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User update(User user) {
        String updateUserQuery = "UPDATE users SET first_name = ?, last_name = ?, "
                + "email = ?, password = ?, role_id = ?, activity_status_id = ? WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(updateUserQuery)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setLong(5, user.getRoleId());
            statement.setLong(6, user.getActivityStatusId());
            statement.setLong(7, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteUserQuery = "DELETE FROM users WHERE id = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(deleteUserQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<User> getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("password"));
        user.setId(resultSet.getLong("id"));
        user.setRoleId(resultSet.getLong("role_id"));
        user.setActivityStatusId(resultSet.getLong("activity_status_id"));
        return Optional.of(user);
    }
}
