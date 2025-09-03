package com.demo.bank.Controllers;

import com.demo.bank.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    protected Button fxLoginButton;

    @FXML
    protected void AdminScene(){
        App.setScene("Admin");
    }
}
