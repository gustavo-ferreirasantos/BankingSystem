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
//Classe usada inteiramente para o "Login.fxml", controla a lógica dessa tela
//implements Initializable indica que precisa da função initialize
public class LoginController implements Initializable {


    // @FXML indica que é um código usado nesse tipo de arquivo
    @FXML
    protected Button btLoginButton;

    @FXML
    protected TextField tfUserName;

    @FXML
    protected TextField tfPassword;

    @FXML //Caixa pra selecionar o tipo de usuário (cliente ou admin)
    protected ChoiceBox<String> cbUserType;
    //Armazena o tipo de usuário
    private String UserType;
    private final String[] UserTypes = {"Admin", "Client"};

    //Adiciona os tipos de usuário na caixa seletora, o método necessariamente precisa se chamar "initialize"
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbUserType.getItems().addAll(UserTypes);
        cbUserType.setOnAction(this::setUserType);
    }

    public void setUserType(ActionEvent event) {
        UserType = cbUserType.getValue();
    }

    //Entra na cena selecionada (admin ou cliente)
    @FXML
    protected void SelectScene(){
        App.setScene(UserType);
    }
}
