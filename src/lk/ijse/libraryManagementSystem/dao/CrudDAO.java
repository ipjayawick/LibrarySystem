package lk.ijse.libraryManagementSystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,K> {
    public boolean save(T t) throws SQLException, ClassNotFoundException;
    public T get(K k) throws SQLException, ClassNotFoundException;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
