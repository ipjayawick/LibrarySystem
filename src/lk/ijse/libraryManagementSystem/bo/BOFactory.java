package lk.ijse.libraryManagementSystem.bo;

import lk.ijse.libraryManagementSystem.bo.Custom.impl.BookBOImpl;
import lk.ijse.libraryManagementSystem.bo.Custom.impl.MemberBOImpl;
import lk.ijse.libraryManagementSystem.dao.custom.impl.MemberDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory == null) ? (boFactory = new BOFactory()) : boFactory;
    }


    public enum BOType{
        BOOK,MEMBER
    }
    public <T> T getBO(BOType type){
        switch (type){
            case BOOK:return (T) new BookBOImpl();
            case MEMBER: return (T) new MemberBOImpl();
            default: return null;
        }
    }
}
