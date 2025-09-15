package com.demo.bank;

import com.demo.bank.Classes.Admin;
import com.demo.bank.Classes.Client;
import com.demo.bank.Classes.Endereco;
import com.demo.bank.Classes.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App extends Application {
    private static Scene loginScene;
    private static Scene adminScene;
    private static Scene clientScene;
    private static Stage stage;


    private static final Map<String, Parent> screens = new HashMap<>();


    protected static ArrayList<Client> ListClients = new ArrayList<>();

    public static void setListClients(String nameClient, Endereco endereco, String cpf, String email, String password) {
        ListClients.add(new Client(nameClient, endereco, cpf, email, password));
    }

    public static ArrayList<Client> getListClients() {
        return ListClients;
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Login");


        // Carregando telas
        loadScreens();


        // Cenas principais
        loginScene = new Scene(screens.get("Login"));
        adminScene = new Scene(screens.get("Admin"));
        clientScene = new Scene(screens.get("Client"));


        // -------- ADMIN -----------
        /* Sem o uso de loadScreens
        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("FXML/Admin.fxml"));
        Parent fxmlAdmin = adminLoader.load();
        AdminScene = new Scene(fxmlAdmin);
        ScenePlaceholder = FXMLLoader.load(getClass().getResource("/com/demo/bank/FXML/AdminPlaceholder.fxml"));
        SceneClients = FXMLLoader.load(getClass().getResource("/com/demo/bank/FXML/AdminClients.fxml"));
        SceneAdd = FXMLLoader.load(getClass().getResource("/com/demo/bank/FXML/AdminAdd.fxml"));
        */


        // -------- ICONS -----------
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/icon.png")));
        primaryStage.getIcons().add(icon);



        primaryStage.setScene(loginScene);
        primaryStage.centerOnScreen();

        primaryStage.show();
    }




    public static void loadScreens() throws IOException {
        screens.put("Login", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Login.fxml"))));
        screens.put("Admin", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Admin.fxml"))));
        screens.put("Client", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Client.fxml"))));
        screens.put("Admin_Placeholder", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminPlaceholder.fxml"))));
        screens.put("Admin_Clients", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminClients.fxml"))));
        screens.put("Admin_Add", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminAdd.fxml"))));
    }

    public static Parent getScreen(String name) {
        return screens.get(name);
    }



    public static void setScene(String scene) {
        switch (scene){
            case "Admin":
                stage.setScene(adminScene);
                stage.setTitle("Admin");
                break;
            case "Client":
                stage.setScene(clientScene);
                stage.setTitle("Client");
                break;
            case "Login":
                stage.setScene(loginScene);
                stage.setTitle("Login");
                break;
        }
        stage.centerOnScreen();

    }

    public static void main(String[] args) {
        /*
        Admin admin = new Admin();
        Client client1 = new Client("G", 13, new Endereco("Jag", "dfadf", 21, 2341), "948");
        Client client2 = new Client("G", 14, new Endereco("Jag", "dfadf", 21, 2341), "642424");
        ListClients.add(client1);
        ListClients.add(client2);
        admin.setId(0);
        ListClients.get(0).setId(1);
        ListClients.get(1).setId(1);
        System.out.println(client2.getId());
        System.out.println(client1.getId());
        System.out.println(admin.getId());
        */
// CPFs válidos (apenas para testes)
        App.setListClients(
                "João Silva",
                new Endereco(
                        12345678,
                        123
                ),
                "111.444.777-35",
                "joao.silva@email.com",
                "senha123"
        );

        App.setListClients(
                "Maria Oliveira",
                new Endereco(
                        87654321,
                        456
                ),
                "012.345.678-90",
                "maria.oliveira@email.com",
                "senha456"
        );

        App.setListClients(
                "Carlos Souza",
                new Endereco(
                        11223344,
                        789
                ),
                "987.654.321-00",
                "carlos.souza@email.com",
                "senha789"
        );

        App.setListClients(
                "Ana Costa",
                new Endereco(
                        44332211,
                        101
                ),
                "258.371.460-08",
                "ana.costa@email.com",
                "senha101"
        );

        App.setListClients(
                "Pedro Lima",
                new Endereco(
                        55667788,
                        202
                ),
                "314.159.265-90",
                "pedro.lima@email.com",
                "senha202"
        );

        App.setListClients(
                "Lucas Moreira",
                new Endereco(
                        66778899,
                        303
                ),
                "443.201.879-89",
                "lucas.moreira@email.com",
                "senha303"
        );


        launch();
    }

}
