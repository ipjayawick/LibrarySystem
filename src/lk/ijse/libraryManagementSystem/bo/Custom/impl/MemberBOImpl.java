package lk.ijse.libraryManagementSystem.bo.Custom.impl;

import lk.ijse.libraryManagementSystem.bo.Custom.MemberBO;
import lk.ijse.libraryManagementSystem.dao.DAOFactory;
import lk.ijse.libraryManagementSystem.dao.custom.MemberDAO;
import lk.ijse.libraryManagementSystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {
    MemberDAO dao= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.MEMEBER);

    @Override
    public boolean save(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return dao.save(new Member(memberDTO.getMemberID(),memberDTO.getName(),memberDTO.getNumber(),memberDTO.getEmail()));
    }

    @Override
    public MemberDTO get(String s) throws SQLException, ClassNotFoundException {
        Member member =dao.get(s);
        return new MemberDTO(member.getMemberID(),member.getName(),member.getNumber(),member.getEmail());
    }


    @Override
    public ArrayList<MemberDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Member> members = dao.getAll();
        ArrayList<MemberDTO> memberDTOs=new ArrayList<>();
        for (Member member:members) {
            memberDTOs.add(new MemberDTO(member.getMemberID(),member.getName(),member.getNumber(),member.getEmail()));
        }
        return memberDTOs;
    }
}
