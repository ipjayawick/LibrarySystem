package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
    public HBox hbx2;
    public HBox hbx1;

    public void initialize(){
        JFXDepthManager.setDepth(hbx1,2);
        JFXDepthManager.setDepth(hbx2,2);
    }

    public void addMemberOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("AddMemberForm", "Add Member");
    }

    public void addBookOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("AddBookForm", "Add Book");
    }

    public void viewMembersOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("ViewMembersForm", "Member List");
    }

    public void viewBooksOnAction(ActionEvent actionEvent) throws IOException {
        setWindow("ViewBooksForm", "Book List");
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


    public void issueOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDone = new DatabaseAccessCode().issueBook(txtIssueBkID.getText(), txtIssueMemID.getText());
        if(isDone){
            new Alert(Alert.AlertType.INFORMATION,"Book issued").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Failed").show();
        }
    }

    public void renewOnAction(ActionEvent actionEvent) {
    }

    public void submitOnAction(ActionEvent actionEvent) {
    }

    private void setWindow(String form, String title) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+form+".fxml"))));
        window.setTitle(title);
        window.centerOnScreen();

    }

}
