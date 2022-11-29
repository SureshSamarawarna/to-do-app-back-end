package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.custom.impl.ToDoDAOImpl;
import lk.ijse.dep9.dao.custom.impl.UserDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null)? (daoFactory = new DAOFactory()): daoFactory;
    }

    public <T extends SuperDAO> T getDAO(Connection connection, DAOTypes daoType){
        switch (daoType){
            case USER:
                return (T) new UserDAOImpl(connection);
            case TODO_ITEM:
                return (T) new ToDoDAOImpl(connection);
            default:
                return null;
        }
    }
}
