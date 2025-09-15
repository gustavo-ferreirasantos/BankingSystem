package com.demo.bank.Controllers;

import com.demo.bank.App;
import com.demo.bank.Classes.Client;
import com.demo.bank.Classes.Endereco;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;



public class AdminController {



    @FXML
    protected TableView<Client> table;
    @FXML
    protected TableColumn<Client, String> columnName , columnCpf, columnId ;

    @FXML
    protected TextField tfName, tfEmail, tfPassword, tfCep, tfCpf, tfNumber;

    @FXML
    private BorderPane root;


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


    @FXML
    public void initialize() {
        if(columnId!=null) {
            // Define as colunas (nomes devem bater com os getters da classe Client)
            columnName.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
            columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

            // Adiciona os clientes existentes (se já tiver)

            table.setItems(FXCollections.observableArrayList(App.getListClients()));
            // Listener para quando o BorderPane for adicionado à cena
            root.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    UpdateTable();
                }
            });

        }

    }

    @FXML
    public void UpdateTable() {
        //table.getItems().setAll(App.getListClients());
        table.setItems(FXCollections.observableArrayList(App.getListClients()));
    }

    @FXML
    protected void CreateClient(){
        App.setListClients(
                tfName.getText(),
                new Endereco(
                        Integer.parseInt(tfNumber.getText()),
                        Integer.parseInt(tfCep.getText())
                ),
                tfCpf.getText(),
                tfEmail.getText(),
                tfPassword.getText()

        );


        for(int i = 0; i<App.getListClients().size(); i++){
            System.out.printf("\nId:%d ======== Nome:%s  ======= Cpf: %s",
                    App.getListClients().get(i).getId(),
                    App.getListClients().get(i).getNameClient(),
                    App.getListClients().get(i).getCpf());
        }
    }


    // ---------------- Troca de Telas ----------------
    @FXML
    protected void SceneClients() {
        effectButton(btClients);
        boxCentral.getChildren().clear();
        boxCentral.getChildren().add(App.getScreen("Admin_Clients"));
    }

    @FXML
    protected void SceneAdd() {
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
        if (button != null) {
            if(button.getStyleClass().contains("btn")){
                button.getStyleClass().remove("btn");
                button.getStyleClass().add("btn_after");
            }else{
                button.getStyleClass().remove("btn_after");
                button.getStyleClass().add("btn");
            }
        }
    }


}
