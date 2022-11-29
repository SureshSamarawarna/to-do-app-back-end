package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.ToDoItem;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ToDoDAOImpl implements ToDoDAO {

    private Connection connection;

    public ToDoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer PK) throws ConstraintViolationException {

    }

    @Override
    public boolean existsById(Integer PK) {
        return false;
    }

    @Override
    public List<ToDoItem> findAll() {
        return null;
    }

    @Override
    public Optional<ToDoItem> findById(Integer PK) {
        return Optional.empty();
    }

    @Override
    public ToDoItem save(ToDoItem entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public ToDoItem update(ToDoItem entity) throws ConstraintViolationException {
        return null;
    }
}
