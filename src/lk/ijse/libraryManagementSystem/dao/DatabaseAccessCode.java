package lk.ijse.libraryManagementSystem.dao;

import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseAccessCode {
    public boolean saveBook(BookDTO bookDTO) {
        return false;
    }

    public boolean saveMember(MemberDTO memberDTO) {
        return false;
    }

    public ArrayList<BookDTO> getAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<BookDTO> books = new ArrayList<>();
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM BOOKS");
        while (rst.next()){
            books.add(new BookDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return books;
    }

    public ArrayList<MemberDTO> getAllMembers() throws SQLException, ClassNotFoundException {
        ArrayList<MemberDTO> members = new ArrayList<>();
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM MEMBERS");
        while (rst.next()){
            members.add(new MemberDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return members;
    }
}
