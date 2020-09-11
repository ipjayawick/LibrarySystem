package lk.ijse.libraryManagementSystem.dao;

import com.jfoenix.controls.JFXTextField;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseAccessCode {
    public boolean saveBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?,?)");

        pst.setString(1,bookDTO.getBookID());
        pst.setString(2,bookDTO.getBookTitle());
        pst.setString(3,bookDTO.getAuthor());
        pst.setString(4,bookDTO.getPublisher());
        pst.setString(5,bookDTO.getBookIntCode());

        return pst.executeUpdate()>0;
    }

    public boolean saveMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO MEMBERS VALUES(?,?,?,?)");

        pst.setString(1,memberDTO.getMemberID());
        pst.setString(2,memberDTO.getName());
        pst.setString(3,memberDTO.getNumber());
        pst.setString(4,memberDTO.getEmail());

        return pst.executeUpdate()>0;
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


    public MemberDTO getMember(String memberID) throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM MEMBERS WHERE id='" + memberID + "'");
        if (rst.next()){
            return new MemberDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    public BookDTO getBook(String booKID) throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM BOOKS WHERE id='" + booKID + "'");
        System.out.println("SELECT * FROM BOOKS WHERE id='" + booKID + "'");
        if (rst.next()){
            return new BookDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
        }else {
            return null;
        }
    }

    public boolean issueBook(String bookID, String memberID) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO ISSUES VALUES(?,?,?,?) ");
        String issueID=getNextIssueID();

        pst.setString(1,issueID);
        pst.setString(2,bookID);
        pst.setString(3,memberID);
        pst.setInt(4,1);
        System.out.println(pst);
        int result = pst.executeUpdate();
        return result>0;
    }

    private String getNextIssueID() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT issueID FROM ISSUES ORDER BY issueID DESC LIMIT 1 ");
        if(rst.next()){
            return rst.getString(1)+1;
        }else{
            return "1";
        }
    }
}
