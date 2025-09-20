package com.demo.bank;

import com.demo.bank.API.ViaCepService;
import com.demo.bank.Model.Client;
import com.demo.bank.Model.Endereco;
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

    //Map é uma espécie de dicionário, nesse caso relaciona o nome da tela (string) e o objeto tela em si (parent)
    private static final Map<String, Parent> screens = new HashMap<>();

    //Nomes que aparecem na lista de clientes ao logar como admin
    protected static ArrayList<Client> ListClients = new ArrayList<>();

    //Função para adicionar clientes
    public static void setListClients(String nameClient, Endereco endereco, String cpf, String email, String password) {
        ListClients.add(new Client(nameClient, endereco, cpf, email, password));
    }
    //Usado na tabela
    public static ArrayList<Client> getListClients() {
        return ListClients;
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Login");


        //Carrega todas as telas de uma só vez
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
        //Adiciona o ícone do aplicativo
        primaryStage.getIcons().add(icon);



        primaryStage.setScene(loginScene);
        //Centraliza a tela
        primaryStage.centerOnScreen();
        //Apresenta a tela
        primaryStage.show();
    }



    //Ele procura por uma pasta FXML que esteja no mesmo nível do arquivo App.class compilado. Ele retorna um objeto URL com o caminho para o arquivo.
    //Caso não encontre, retorna null e dá NullPointerException
    public static void loadScreens() throws IOException {
        screens.put("Login", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Login.fxml"))));
        screens.put("Admin", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Admin.fxml"))));
        screens.put("Client", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("FXML/Client.fxml"))));
        screens.put("Admin_Placeholder", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminPlaceholder.fxml"))));
        screens.put("Admin_Clients", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminClients.fxml"))));
        screens.put("Admin_Add", FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/demo/bank/FXML/AdminAdd.fxml"))));
    }
    //Acha a tela por meio de sua chave (nome)
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

    public static void main(String[] args) throws Exception {
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
                "Carlos Souza",
                ViaCepService.getEndereco("11223344", 44),
                "987.654.321-00",
                "carlos.souza@email.com",
                "senha789"
        );

        App.setListClients(
                "Ana Costa",
                ViaCepService.getEndereco("48902300", 723),
                "258.371.460-08",
                "ana.costa@email.com",
                "senha101"
        );

        App.setListClients(
                "Pedro Lima",
                ViaCepService.getEndereco("55667788", 723),

                "314.159.265-90",
                "pedro.lima@email.com",
                "senha202"
        );

        App.setListClients(
                "Lucas Moreira",
                ViaCepService.getEndereco("66778899", 303),
                "443.201.879-89",
                "lucas.moreira@email.com",
                "senha303"
        );
        //Uso da API para obter o endereço a partir do CEP (teste no terminal)
        Endereco endereco = null;
        try {
            endereco = ViaCepService.getEndereco("48902300", 3);
        } catch (Exception e) { //Detecta qualquer erro
            throw new RuntimeException(e);//Erro grave
        }
        System.out.println(endereco.getBairro() + ", " + endereco.getLocalidade() +  ", " + endereco.getLogradouro());

        //Responsável por abrir o aplicativo
        launch();
        System.out.println("App fechado!");
    }

}
