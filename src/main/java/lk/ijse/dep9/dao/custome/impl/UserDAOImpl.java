package lk.ijse.dep9.dao.custome.impl;

import lk.ijse.dep9.dao.custome.UserDAO;
import lk.ijse.dep9.entity.SuperEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    private UserDAOImpl (Connection connection){
        this.connection=connection;
    }

    @Override
    public long count() throws SQLException {
        try{
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(user_name) from user");
            ResultSet rst= stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String user_name) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM USER WHERE user_name=?");
        stm.setString(1,user_name);
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
