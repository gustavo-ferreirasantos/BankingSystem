package com.demo.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    private static Scene LoginScene;
    private static Scene AdminScene;
    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Login");

        // -------- LOGIN -----------
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("FXML/Login.fxml"));
        Parent fxmlLogin = loginLoader.load();
        LoginScene = new Scene(fxmlLogin);

        // -------- ADMIN -----------
        FXMLLoader adminLoader = new FXMLLoader(
                getClass().getResource("FXML/Admin.fxml")
        );
        Parent fxmlAdmin = adminLoader.load();
        AdminScene = new Scene(fxmlAdmin);

        // -------- ICONS -----------
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Book.png")));
        primaryStage.getIcons().add(icon);



        primaryStage.setScene(LoginScene);
        primaryStage.show();
    }




    public static void setScene(String scene) {
        switch (scene){
            case "Admin":
                stage.setScene(AdminScene);
                break;
            case "Login":
                stage.setScene(LoginScene);
                break;
        }

    }







    public static void main(String[] args) {
        launch();
    }

}
