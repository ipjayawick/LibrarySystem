package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.libraryManagementSystem.dao.DatabaseAccessCode;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;

import java.io.IOException;
import java.sql.SQLException;

public class DashboardFormController {
    public JFXTextField txtIssueBkID;
    public JFXTextField txtIssueMemID;
    public JFXTextField txtRenewBkID;
    public StackPane root;
    public Label lblBookName;
    public Label lblBookAuthor;
    public Label lblMemberName;
    public Label lblConNum;

    public void addMemberOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("AddMemberForm");
    }

    public void addBookOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("AddBookForm");
    }

    public void viewMembersOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("ViewMembersForm");
    }

    public void viewBooksOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("ViewBooksForm");
    }

    public void settingsOnAction(ActionEvent actionEvent) {
    }

    public void showMemberOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        MemberDTO member = new DatabaseAccessCode().getMember(txtIssueMemID.getText());
        if(member!=null){
            lblMemberName.setText(lblBookName.getText()+member.getName());
            lblConNum.setText(lblConNum.getText()+member.getNumber());
        }
    }

    public void showBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BookDTO book = new DatabaseAccessCode().getBook(txtIssueBkID.getText());
        if(book!=null){
            lblBookName.setText(lblBookName.getText()+book.getBookTitle());
            lblBookAuthor.setText(lblBookAuthor.getText()+book.getAuthor());
        }
    }


    public void issueOnAction(ActionEvent actionEvent) {
    }

    public void renewOnAction(ActionEvent actionEvent) {
    }

    public void submitOnAction(ActionEvent actionEvent) {
    }

    private void setWindow(String form) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+form+".fxml"))));
        window.centerOnScreen();
    }

}
