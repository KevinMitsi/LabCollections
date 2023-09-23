package com.example.labcollections;

import com.example.labcollections.controller.*;
import com.example.labcollections.model.Biblioteca;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Estudiante;
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

    public void abrirPanelAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("adminPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        AdminPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Panel de Admin");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelEstudiante(Estudiante estudiante) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("studentPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        StudentPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this, estudiante);
        stage.setTitle("Panel estudiante");
        stage.setScene(scene);
        stage.show();

    }

    public void abrirPanelBibliotecario(Bibliotecario bibliotecario) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("librarianPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        LibrarianPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this, bibliotecario);
        stage.setTitle("Panel bibliotecario");
        stage.setScene(scene);
        stage.show();
    }
}