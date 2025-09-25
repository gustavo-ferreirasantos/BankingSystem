package com.demo.bank.Controllers;

import com.demo.bank.API.ViaCepService;
import com.demo.bank.App;
import com.demo.bank.Model.Client;
import com.demo.bank.Model.Endereco;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;



public class AdminController {



    @FXML //Tabela de clientes
    protected TableView<Client> table;
    @FXML //3 colunas: Nome,Cpf e ID
    protected TableColumn<Client, String> columnName , columnCpf, columnId ;

    @FXML //Campos de texto na hora de adicionar clientes
    protected TextField tfName, tfEmail, tfPassword, tfCep, tfCpf, tfNumber;

    @FXML //Usado na tabela
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
    protected void CreateClient() throws Exception {

        //Adicionar cliente pela caixa de texto
        App.setListClients(
                tfName.getText(),
                ViaCepService.getEndereco(tfCep.getText(),Integer.parseInt(tfNumber.getText())),
                tfCpf.getText(), //Só aceita CPF que existe pelo visto
                tfEmail.getText(),
                tfPassword.getText()
        );

        //Adicionar cliente fixo (para testes)
//        App.setListClients(
//                "Gustavo",
//                ViaCepService.getEndereco("48902300", 723),
//                "111.444.777-35",
//                "gustavo.silva@email.com",
//                "senha123"
//        );


        for(int i = 0; i<App.getListClients().size(); i++){
            System.out.printf("\nId:%d ======== Nome:%s  ======= Cpf: %s ======= Logradouro:%s",
                    App.getListClients().get(i).getId(),
                    App.getListClients().get(i).getNameClient(),
                    App.getListClients().get(i).getCpf(),
                    App.getListClients().get(i).getEndereco().getBairro());

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

        boxCentral.getChildren().clear(); //Limpa a tela central
        boxCentral.getChildren().add(App.getScreen("Admin_Add")); //Adiciona uma nova tela (A de adicionar clientes)
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
