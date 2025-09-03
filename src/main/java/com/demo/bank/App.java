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
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("FXML/Login.fxml"));
        LoginScene = new Scene(fxmlLogin);
        Parent fxmlAdmin =  FXMLLoader.load(getClass().getResource("FXML/Admin.fxml"));
        AdminScene = new Scene(fxmlAdmin);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Book.png")));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(LoginScene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }

    public static void setScene(String str) {
        switch (str){
            case "Admin":
                stage.setScene(AdminScene);
                break;
            case "Login":
                stage.setScene(LoginScene);
                break;
        }

    }
}