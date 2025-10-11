package com.demo.bank.Controllers;

import com.demo.bank.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClientController {


    @FXML
    protected Button btExit;

    @FXML
    protected void Exit(){
        StartApplication.setScene("Login");
    }


}
