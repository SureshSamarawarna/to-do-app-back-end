package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.ToDoItem;
import lk.ijse.dep9.entity.util.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoDAOImpl implements ToDoItemDAO {

    private Connection connection;

    public ToDoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(id) FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            if (existsById(id)) throw new ConstraintViolationException("To-do Item user name exists within other tabels", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT id FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            return stm.executeQuery().next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ToDoItem> findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            List<ToDoItem> toDoItemList = new ArrayList<>();
            while (rst.next()) {
                int id = rst.getInt("id");
                String userName = rst.getString("user_name");
                String description = rst.getString("description");
                Status status = Status.valueOf(rst.getString("status"));
                toDoItemList.add(new ToDoItem(id, userName, description, status));
            }
            return toDoItemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ToDoItem> findById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                String userName = rst.getString("user_name");
                String description = rst.getString("description");
                Status status = Status.valueOf( rst.getString("status"));
                return Optional.of(new ToDoItem(id, userName, description, status));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO ToDoItem (id, user_name, description, status) VALUES (?, ?, ?, ?)");
            stm.setInt(1, toDoItem.getId());
            stm.setString(2, toDoItem.getUserName());
            stm.setString(3, toDoItem.getDescription());
            stm.setString(4, toDoItem.getStatus().toString());
            if (stm.executeUpdate() == 1) {
                return toDoItem;
            } else {
                throw new SQLException("Failed to save the toDoItem");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDoItem update(ToDoItem toDoItem) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE ToDoItem SET user_name=?, description=?, status=? WHERE id=?");
            stm.setString(1, toDoItem.getUserName());
            stm.setString(2, toDoItem.getDescription());
            stm.setString(3, toDoItem.getStatus().toString());
            stm.setInt(4, toDoItem.getId());
            if (stm.executeUpdate() == 1) {
                return toDoItem;
            } else {
                throw new SQLException("Failed to update the book");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
