package lk.ijse.libraryManagementSystem.dao.custom.impl;

import lk.ijse.libraryManagementSystem.dao.CrudUtil;
import lk.ijse.libraryManagementSystem.dao.custom.BookDAO;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.entity.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean save(Book book) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO BOOKS VALUES(?,?,?,?,?)",book.getBookID(),book.getBookTitle(),book.getAuthor(),book.getPublisher(),book.getBookIntCode());
    }

    @Override
    public Book get(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM BOOKS WHERE id='" + s + "'");
    }


    @Override
    public ArrayList<Book> getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM BOOKS");
    }
}
