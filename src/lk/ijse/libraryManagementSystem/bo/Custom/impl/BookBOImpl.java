package lk.ijse.libraryManagementSystem.bo.Custom.impl;

import lk.ijse.libraryManagementSystem.bo.Custom.BookBO;
import lk.ijse.libraryManagementSystem.dao.CrudUtil;
import lk.ijse.libraryManagementSystem.dao.DAOFactory;
import lk.ijse.libraryManagementSystem.dao.custom.BookDAO;
import lk.ijse.libraryManagementSystem.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookBOImpl implements BookBO {
    BookDAO dao=DAOFactory.getInstance().getDAO(DAOFactory.DAOType.BOOK);

    @Override
    public boolean save(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        return dao.save(new Book(bookDTO.getBookID(), bookDTO.getBookTitle(), bookDTO.getAuthor(), bookDTO.getPublisher(), bookDTO.getBookIntCode()));
    }

    @Override
    public BookDTO get(String s) throws SQLException, ClassNotFoundException {
        Book book = dao.get(s);
        return new BookDTO(book.getBookID(),book.getBookTitle(),book.getAuthor(),book.getPublisher(),book.getBookIntCode());
    }


    @Override
    public ArrayList<BookDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Book> books = dao.getAll();
        ArrayList<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book: books) {
            bookDTOs.add(new BookDTO(book.getBookID(),book.getBookTitle(),book.getAuthor(),book.getPublisher(),book.getBookIntCode()));
        }
        return bookDTOs;
    }
}
