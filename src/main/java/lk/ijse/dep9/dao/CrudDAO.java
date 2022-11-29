package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.SuperEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> extends SuperDAO {

    long count() throws SQLException;

    void deleteById(ID PK) throws ConstraintViolationException, SQLException;

    boolean existsById(ID PK) throws SQLException;

    List<T> findAll();

    Optional<T> findById(ID PK);

    T save(T entity) throws ConstraintViolationException ;

    T update(T entity) throws ConstraintViolationException ;

}
