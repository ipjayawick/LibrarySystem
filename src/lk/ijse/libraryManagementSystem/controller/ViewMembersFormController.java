package lk.ijse.libraryManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.libraryManagementSystem.dao.DatabaseAccessCode;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.view.tm.BookTM;
import lk.ijse.libraryManagementSystem.view.tm.MemberTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewMembersFormController {
    public TableColumn colMemId;
    public TableColumn colName;
    public TableColumn colMobNum;
    public TableColumn colEmail;
    public TableView<MemberTM> tbl;
    public AnchorPane root;

    public void initialize() throws SQLException, ClassNotFoundException {
        colMemId.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobNum.setCellValueFactory(new PropertyValueFactory<>("number"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        loadAllItems();
    }

    private void loadAllItems() throws SQLException, ClassNotFoundException {
        ObservableList<MemberTM> memberList = FXCollections.observableArrayList();
        ArrayList<MemberDTO> members = new DatabaseAccessCode().getAllMembers();
        for (MemberDTO member:members) {
             memberList.add(new MemberTM(member.getMemberID(),member.getName(),member.getNumber(),member.getEmail()));
        }
        tbl.setItems(memberList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashboardForm.fxml"))));
        window.setTitle("Library System");
        window.centerOnScreen();
        window.show();
    }
}
