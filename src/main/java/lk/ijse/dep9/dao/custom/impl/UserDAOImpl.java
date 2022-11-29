package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Serializable PK) {

    }

    @Override
    public boolean existsById(Serializable PK) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
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
