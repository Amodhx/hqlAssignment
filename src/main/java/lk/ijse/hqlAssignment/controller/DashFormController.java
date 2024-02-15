package lk.ijse.hqlAssignment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;
import lk.ijse.hqlAssignment.dto.BookDTO;
import lk.ijse.hqlAssignment.entity.Author;
import lk.ijse.hqlAssignment.entity.Book;
import lk.ijse.hqlAssignment.service.AuthorServiceImpl;
import lk.ijse.hqlAssignment.service.BookServiceImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashFormController implements Initializable {

    @FXML
    private JFXButton Q01Button;
    @FXML
    private JFXTextArea textArea;

    BookServiceImpl bookService = new BookServiceImpl();
    AuthorServiceImpl authorService = new AuthorServiceImpl();


    @FXML
    void onQ01Click(ActionEvent event) {
        textArea.clear();
        for (BookDTO b : bookService.q1()) {
            textArea.appendText(b+ "\n ");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setFont(Font.font(18));
    }

    @FXML
    void q02(ActionEvent event) {
        textArea.clear();
        boolean b  = bookService.q2(1);
        if (b){
            textArea.appendText("Values Updated !!!");
        }else {
            new Alert(Alert.AlertType.ERROR,"Cant update values!!").show();
        }
    }

    @FXML
    void q03(ActionEvent event) {
        textArea.clear();


    }

    @FXML
    void q04(ActionEvent event) {
        textArea.clear();
        ArrayList<Double> arrayList = bookService.getBookPrices();
        int x = arrayList.size();
        int total = 0 ;
        for (int i = 0; i < arrayList.size(); i++) {
            total += arrayList.get(i);
        }
        textArea.appendText("Average: "+String.valueOf(total/x));
    }

    @FXML
    void q05(ActionEvent event) {
        textArea.clear();
        List<Author> authors = authorService.getAll();
        for (int i = 0; i < authors.size(); i++) {
            textArea.appendText(authors.get(i).getName() +" --"+ authors.get(i).getBooks().size()+"\n");
        }
    }

    @FXML
    void q06(ActionEvent event) {

    }

    @FXML
    void q07(ActionEvent event) {

    }

    @FXML
    void q08(ActionEvent event) {

    }

    @FXML
    void q09(ActionEvent event) {

    }

    @FXML
    void q10(ActionEvent event) {
        textArea.clear();

    }
}
