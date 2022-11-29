package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoDAO;
import lk.ijse.dep9.entity.SuperEntity;
import lk.ijse.dep9.entity.ToDoItem;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoDAOImpl implements ToDoDAO {
    
    private Connection connection;

    public ToDoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(id) FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Serializable id) {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Serializable id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT id FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            return stm.executeQuery().next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            List<ToDoItem> toDoItemList = new ArrayList<>();
            while (rst.next()) {
                int id = rst.getInt("id");
                String userName = rst.getString("user_name");
                String description = rst.getString("description");
                String status = rst.getString("status");
                toDoItemList.add(new ToDoItem(id, userName,description,status));
            }
            return toDoItemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional findById(Serializable PK) {
        return Optional.empty();
    }

    @Override
    public SuperEntity save(SuperEntity entity) {
        return null;
    }

    @Override
    public SuperEntity update(SuperEntity entity) {
        return null;
    }
}
