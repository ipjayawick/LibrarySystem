package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.libraryManagementSystem.view.tm.BookTM;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewBooksFormController {
    public TableColumn colBkId;
    public TableColumn colTtle;
    public TableColumn colAthr;
    public TableColumn colPblshr;
    public TableColumn colBkIntCode;
    public TableView<BookTM> tbl;
    public AnchorPane root;


    public void initialize() throws SQLException, ClassNotFoundException {
        colBkId.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colTtle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colAthr.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPblshr.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colBkIntCode.setCellValueFactory(new PropertyValueFactory<>("bookIntCode"));
        loadAllItems();
    }

    private void loadAllItems() throws SQLException, ClassNotFoundException {
        ObservableList<BookTM> bookList = FXCollections.observableArrayList();
        ArrayList<BookDTO> books = new DatabaseAccessCode().getAllBooks();
        for (BookDTO book: books) {
            bookList.add(new BookTM(book.getBookID(),book.getBookTitle(),book.getAuthor(),book.getPublisher(),book.getBookIntCode()));
        }
        tbl.setItems(bookList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashboardForm.fxml"))));
        window.setTitle("Library System");
        window.centerOnScreen();
        window.show();
    }
}