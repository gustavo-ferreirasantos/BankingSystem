package com.demo.bank.Controllers;

import com.demo.bank.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AdminController {

    @FXML
    protected Button btExit;

    @FXML
    protected void Exit(){
        App.setScene("Login");
    }
}
