package lk.ijse.libraryManagementSystem.dao;

import lk.ijse.libraryManagementSystem.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.custom.impl.MemberDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory==null) ? (daoFactory=new DAOFactory()) : daoFactory;
    }

    public enum DAOType{
        BOOK, MEMEBER
    }

    public <T> T getDAO(DAOType type){
        switch (type){
            case BOOK:return (T)new BookDAOImpl();
            case MEMEBER:return (T)new MemberDAOImpl();
            default: return null;
        }
    }
}
