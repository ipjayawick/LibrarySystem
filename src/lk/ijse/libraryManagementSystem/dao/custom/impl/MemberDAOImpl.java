package lk.ijse.libraryManagementSystem.dao.custom.impl;

import lk.ijse.libraryManagementSystem.dao.CrudUtil;
import lk.ijse.libraryManagementSystem.dao.custom.MemberDAO;
import lk.ijse.libraryManagementSystem.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {


    @Override
    public boolean save(Member member) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("INSERT INTO MEMBERS VALUES(?,?,?,?)",member.getMemberID(),member.getName(),member.getNumber(),member.getEmail());
    }

    @Override
    public Member get(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM MEMBERS WHERE id='" + s + "'");
    }


    @Override
    public ArrayList<Member> getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM MEMBERS");
    }
}
