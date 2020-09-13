package lk.ijse.libraryManagementSystem.bo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuperBO<T,K> {
    public boolean save(T t) throws SQLException, ClassNotFoundException;
    public T get(K k) throws SQLException, ClassNotFoundException;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
