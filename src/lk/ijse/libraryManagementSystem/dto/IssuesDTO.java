package lk.ijse.libraryManagementSystem.dto;

public class IssuesDTO {
    private String issueID;
    private String bookID;
    private String memberID;
    private Boolean isReturned;

    public IssuesDTO() {
    }

    public IssuesDTO(String issueID, String bookID, String memberID, Boolean isReturned) {
        this.setIssueID(issueID);
        this.setBookID(bookID);
        this.setMemberID(memberID);
        this.setReturned(isReturned);
    }

    public String getIssueID() {
        return issueID;
    }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public Boolean getReturned() {
        return isReturned;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }
}
