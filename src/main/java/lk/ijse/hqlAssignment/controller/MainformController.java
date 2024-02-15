package lk.ijse.hqlAssignment.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.hqlAssignment.dto.UserDTO;
import lk.ijse.hqlAssignment.service.UserServiceImpl;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class MainformController {

    @FXML
    private JFXButton loggingButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;
    UserServiceImpl userService = new UserServiceImpl();
    @FXML
    void onLogInClick(ActionEvent event) {
        for (UserDTO u : userService.getAllUsers()) {
            if (usernameField.getText().equals(u.getUsernmae()) && passwordField.getText().equals(u.getPassword())) {
                loggin();
            }
        }
    }

    @SneakyThrows
    private void loggin() {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dash-from.fxml"))));
        stage.setResizable(false);
        stage.show();
        Stage stage1 = (Stage) loggingButton.getScene().getWindow();
        stage1.close();
    }
}
