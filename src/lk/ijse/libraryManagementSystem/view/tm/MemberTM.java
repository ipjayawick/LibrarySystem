package lk.ijse.libraryManagementSystem.view.tm;

public class MemberTM {
    private String memberID;
    private String name;
    private String number;
    private String email;

    public MemberTM() {
    }

    public MemberTM(String memberID, String name, String number, String email) {
        this.memberID = memberID;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
