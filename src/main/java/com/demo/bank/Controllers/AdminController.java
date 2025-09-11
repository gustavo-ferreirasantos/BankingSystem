package com.demo.bank.Controllers;

import com.demo.bank.App;
import com.demo.bank.Classes.Client;
import com.demo.bank.Classes.Endereco;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminController {

    private int numUser;

    private static final Logger logger = Logger.getLogger(AdminController.class.getName());




    @FXML
    protected TableView<Client> table = new TableView<>();
    @FXML
    protected TableColumn<Client, String> column1 = new TableColumn<>("Name");
    @FXML
    protected TableColumn<Client, String> column2 = new TableColumn<>("Cpf");

    @FXML
    protected TextField tfName, tfEmail, tfPassword, tfCep, tfCpf, tfNumber, tfStreet, tfCity;


    @FXML
    protected Button btExit;


    @FXML
    protected Button btCreate;


    @FXML
    protected Button btClients;

    @FXML
    protected Button btCreateSend;

    @FXML
    protected StackPane boxCentral;

    /*
    // ---------------- Tela Inicial ----------------
    @FXML
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/bank/FXML/AdminPlaceholder.fxml"));
            ScenePlaceholder = loader.load();
            loader = new FXMLLoader(getClass().getResource("/com/demo/bank/FXML/AdminClients.fxml"));
            SceneClients = loader.load();
            loader = new FXMLLoader(getClass().getResource("/com/demo/bank/FXML/AdminAdd.fxml"));
            SceneAdd = loader.load();
            boxCentral.getChildren().add(ScenePlaceholder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao carregar FXML", e);
        }
    }
    */

    @FXML
    public void initialize() {
        // Define as colunas (nomes devem bater com os getters da classe Client)
        column1.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        column2.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        // Adiciona os clientes existentes (se já tiver)
        table.setItems(FXCollections.observableArrayList(App.getListClients()));
    }

    @FXML
    protected void CreateClient(){
        App.setListClients(tfName.getText(), new Endereco(tfCity.getText(), tfStreet.getText(), Integer.parseInt(tfNumber.getText()), Integer.parseInt(tfCep.getText())), tfCpf.getText());

        for(int i = 0; i<App.getListClients().size(); i++){
            System.out.printf("\nId:%d ======== Nome:%s  ======= Cpf: %s",App.getListClients().get(i).getAccount(), App.getListClients().get(i).getNameClient(), App.getListClients().get(i).getCpf());
            table.getItems().setAll(App.getListClients());
        }


    }


    // ---------------- Troca de Telas ----------------
    @FXML
    protected void SceneClients(ActionEvent event) {
        effectButton(btClients);


        boxCentral.getChildren().clear();
        boxCentral.getChildren().add(App.getScreen("Admin_Clients"));
    }

    @FXML
    protected void SceneAdd(ActionEvent event) {
        effectButton(btCreate);

        boxCentral.getChildren().clear();
        boxCentral.getChildren().add(App.getScreen("Admin_Add"));
    }


    // ---------------- Exit ----------------
    @FXML
    protected void Exit(){
        effectButton(null);

        boxCentral.getChildren().clear(); // limpa qualquer tela carregada
        boxCentral.getChildren().add(App.getScreen("Admin_Placeholder"));
        App.setScene("Login");
    }


    @FXML
    protected void effectButton(Button button){
        btCreate.getStyleClass().remove("btn_after");
        btClients.getStyleClass().remove("btn_after");
        btCreate.getStyleClass().add("btn");
        btClients.getStyleClass().add("btn");
        if (button == null){
            return;
        }else if(button.getStyleClass().contains("btn")){
            button.getStyleClass().remove("btn_");
            button.getStyleClass().add("btn_after");
        }else{
            button.getStyleClass().remove("btn_after");
            button.getStyleClass().add("btn");
        }
    }


}
