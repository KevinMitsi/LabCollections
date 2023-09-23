package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {
    ModelFactoryController singleton = ModelFactoryController.getInstance(); //1.Linea en todos los controladores
    MainApplication main; //2.linea en todos los controladores;

    public TextField tfNombre;
    public PasswordField pfNombre;
    public Button btnIngresar;
    public ComboBox<String> cbOpciones;
    public Button btnRegister;

    public void onIngresrButtonClick(ActionEvent actionEvent) {
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) throws IOException { //7. Cambio de pestaña
        main.abrirPestanaRegistro();
    }




    //3. Set Main

    public void setMain(MainApplication main){
        this.main=main;
    }

    @FXML
    void initialize(){ //6. ¿Hay o no? ComboBox, Tabla...
        cbOpciones.getItems().add("Estudiante");
        cbOpciones.getItems().add("Bibliotecario");

    }


}
