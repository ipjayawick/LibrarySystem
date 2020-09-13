package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.libraryManagementSystem.bo.BOFactory;
import lk.ijse.libraryManagementSystem.bo.Custom.BookBO;
import lk.ijse.libraryManagementSystem.bo.Custom.impl.BookBOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.entity.Book;

import java.io.IOException;
import java.sql.SQLException;

public class AddBookFormController {
    public JFXTextField txtBkID;
    public JFXTextField txtBkTitle;
    public JFXTextField txtAuthor;
    public JFXTextField txtPublisher;
    public JFXTextField txtBkInternalCode;
    public AnchorPane root;

    BookBO bo=BOFactory.getInstance().getBO(BOFactory.BOType.BOOK);

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashboardForm.fxml"))));
        window.setTitle("Library System");
        window.centerOnScreen();
        window.show();
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        boolean isAdded = bo.save(new BookDTO(txtBkID.getText(), txtBkTitle.getText(), txtAuthor.getText(), txtPublisher.getText(), txtBkInternalCode.getText()));

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
