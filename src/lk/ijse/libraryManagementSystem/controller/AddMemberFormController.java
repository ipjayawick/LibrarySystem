package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.libraryManagementSystem.bo.BOFactory;
import lk.ijse.libraryManagementSystem.bo.Custom.MemberBO;
import lk.ijse.libraryManagementSystem.bo.Custom.impl.MemberBOImpl;
import lk.ijse.libraryManagementSystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;

import java.io.IOException;
import java.sql.SQLException;

public class AddMemberFormController {
    public JFXTextField txtMemberID;
    public JFXTextField txtName;
    public JFXTextField txtMobileNum;
    public JFXTextField txtEmail;
    public AnchorPane root;

    MemberBO bo= BOFactory.getInstance().getBO(BOFactory.BOType.MEMBER);

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashboardForm.fxml"))));
        window.setTitle("Library System");
        window.centerOnScreen();
        window.show();
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isAdded = bo.save(new MemberDTO(txtMemberID.getText(), txtName.getText(), txtMobileNum.getText(), txtEmail.getText()));

        Alert alert;
        if(isAdded){
            alert = new Alert(Alert.AlertType.INFORMATION, "Saved Successfully");
        }else{
            alert = new Alert(Alert.AlertType.ERROR, "Saving Unsuccessful!");
        }
        alert.setHeaderText(null);
        alert.show();
    }
}
