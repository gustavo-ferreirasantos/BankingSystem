package com.demo.bank.Controllers;

import com.demo.bank.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {



    @FXML
    protected Button btLoginButton;

    @FXML
    protected TextField tfUserName;

    @FXML
    protected TextField tfPassword;

    @FXML
    protected ChoiceBox<String> cbUserType;

    private String UserType;
    private final String[] UserTypes = {"Admin", "Client"};


    public void initialize(URL arg0, ResourceBundle arg1) {
        cbUserType.getItems().addAll(UserTypes);
        cbUserType.setOnAction(this::setUserType);
    }

    public void setUserType(ActionEvent event) {
        UserType = cbUserType.getValue();
    }


    @FXML
    protected void AdminScene(){
        App.setScene(UserType);
    }
}
