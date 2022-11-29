package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() throws SQLException {
        try{
            PreparedStatement stm = connection.prepareStatement("SELECT user_name FROM USER");
            ResultSet rst = stm.executeQuery();
            rst.next();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(String user_name) throws ConstraintViolationException, SQLException  {
        try{
            PreparedStatement stm = connection.prepareStatement("DELETE FROM USER WHERE user_name= ?");
            stm.setString(1,user_name);
            stm.executeUpdate();
        }catch (SQLException e){
            if (existsById(user_name)) throw new ConstraintViolationException(" still exists in other tables", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(String user_name) throws SQLException {
        try{
            PreparedStatement stm = connection.prepareStatement("SELECT user_name FROM USER WHERE user_name=?");
            stm.setString(1,user_name);
            return stm.executeQuery().next();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM USER");
            ResultSet rst = stm.executeQuery();
            List<User> memberList = new ArrayList<>();
            while (rst.next()) {
                String user_name = rst.getString("user_name");
                String full_name = rst.getString("full_name");
                String password = rst.getString("password");
                memberList.add(new User(user_name, full_name, password));
            }
            return memberList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(String user_name) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM USER WHERE user_name = ?");
            stm.setString(1, user_name);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                String full_name = rst.getString("full_name");
                String password = rst.getString("password");
                return Optional.of(new User(user_name, full_name, password));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User user) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO USER (user_name, full_name, password) VALUES (?, ?, ?)");
            stm.setString(1, user.getUser_name());
            stm.setString(2, user.getFull_name());
            stm.setString(3, user.getPassword());
            if (stm.executeUpdate() == 1) {
                return user;
            } else {
                throw new SQLException("Failed to save the user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User update(User user) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE USER SET  full_name=?, password=? WHERE user_name=?");
            stm.setString(1, user.getUser_name());
            stm.setString(2, user.getFull_name());
            stm.setString(3, user.getPassword());

            if (stm.executeUpdate() == 1) {
                return user;
            } else {
                throw new SQLException("Failed to update the user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
