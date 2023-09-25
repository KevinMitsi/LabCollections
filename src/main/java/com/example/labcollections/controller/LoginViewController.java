package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.BiblitecarioException;
import com.example.labcollections.exception.EstudianteException;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Estudiante;
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

    public void onIngresrButtonClick(ActionEvent actionEvent) throws IOException {
        String nombre = tfNombre.getText().replaceAll("\\s+","").toLowerCase();
        String id = pfNombre.getText().replaceAll("\\s+","").toLowerCase();
        String valor = cbOpciones.getValue();
        if(verificarDatos(nombre, id, valor)){
            if(nombre.equals("admin")&&id.equals("admin123")){
                main.abrirPanelAdmin();
            }
            else {
                if(valor.equals("Estudiante")){
                    try{
                        Estudiante estudiante = singleton.verificarIngresoEstudiante(id, nombre);
                        Alerta.saltarAlertaConfirmacion("Ingresando");
                        main.abrirPanelEstudiante(estudiante);
                    } catch (EstudianteException e) {
                       Alerta.saltarAlertaError(e.getMessage());
                    }
                }
                if (valor.equals("Bibliotecario")){
                    try {
                        Bibliotecario bibliotecario = singleton.verificarIngresoBiblitecario(id, nombre);
                        Alerta.saltarAlertaConfirmacion("Ingresando");
                        main.abrirPanelBibliotecario(bibliotecario);
                    } catch (BiblitecarioException e) {
                        Alerta.saltarAlertaError(e.getMessage());
                    }
                }
            }
        }
        else {
            Alerta.saltarAlertaError("Verificar los campos");
        }
    }



    public void onRegisterButtonClick(ActionEvent actionEvent) throws IOException { //7. Cambio de pestaña
        main.abrirPestanaRegistro();
    }




    //3. Set Main

    public void setMain(MainApplication main){
        this.main=main;
    }
    private boolean verificarDatos(String nombre, String id, String valor) {
        if (nombre.isBlank()){
            return false;
        }
        if (id.isBlank()){
            return false;
        }
        if (valor==null){
            return false;
        }
        return true;
    }

    @FXML
    void initialize(){ //6. ¿Hay o no? ComboBox, Tabla...
        cbOpciones.getItems().add("Estudiante");
        cbOpciones.getItems().add("Bibliotecario");

    }




}
