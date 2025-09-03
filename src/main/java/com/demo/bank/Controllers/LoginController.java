package com.demo.bank.Controllers;

import com.demo.bank.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    protected Button btLoginButton;

    @FXML
    protected TextField tfUserName;

    @FXML
    protected TextField tfPassword;





    @FXML
    protected void AdminScene(){
        App.setScene("Admin");
    }
}
