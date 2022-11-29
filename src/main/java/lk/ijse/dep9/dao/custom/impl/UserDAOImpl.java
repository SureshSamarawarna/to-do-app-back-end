package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String PK) throws ConstraintViolationException {

    }

    @Override
    public boolean existsById(String PK) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(String PK) {
        return Optional.empty();
    }

    @Override
    public User save(User entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public User update(User entity) throws ConstraintViolationException {
        return null;
    }
}
