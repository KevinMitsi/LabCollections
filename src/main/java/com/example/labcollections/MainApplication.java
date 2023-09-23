package com.example.labcollections;

import com.example.labcollections.controller.LoginViewController;
import com.example.labcollections.controller.RegisterViewController;
import com.example.labcollections.model.Biblioteca;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    Biblioteca biblioteca = new Biblioteca("Chapeco","aquino");
    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        inicializarLogin();

    }

    public void inicializarLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginViewController controller = fxmlLoader.getController(); //4.
        controller.setMain(this); //5.
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void abrirPestanaRegistro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("registerView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        RegisterViewController controller = fxmlLoader.getController(); //8. Crear el mismo controller que pertenece a la view
        controller.setMain(this); //9.Crear un nuevo setMain
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }
}