package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.BiblitecarioException;
import com.example.labcollections.exception.EstudianteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateEmployeeViewController {
    ModelFactoryController singleton = ModelFactoryController.getInstance(); //Volver a paso 1 y hacerlo de nuevo
    MainApplication main;
    public Button btnVolver;
    public ComboBox<String>cbGenero;
    public TextField tfNombre;
    public TextField tfDireccion;
    public TextField tfCedula;
    public Button btnRegistro;

    public void onVolverButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelAdmin();
    }

    public void onRegistroButtonClick(ActionEvent actionEvent) {
        String nombre = tfNombre.getText().replaceAll("\\s+","").toLowerCase(); //Guardo el texto del campo "Nombre" en una variable para poder usarla
        String id = tfCedula.getText().replaceAll("\\s+","").toLowerCase();
        String direccion = tfDireccion.getText();
        if(verificarCampos(nombre, id, direccion) && cbGenero.getValue()!=null){ //verificamos campos y que el cb no sea null
            try{
                singleton.agregarBiblitecario(nombre, id);
                Alerta.saltarAlertaConfirmacion("Felicidades se ha registrado correctamente");
                main.abrirPanelAdmin();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (BiblitecarioException e) {
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else {
            Alerta.saltarAlertaError("Debe rellenar todos los campos");
        }
    }
    public void setMain(MainApplication main) { //Reemplazar el nombre por main
        this.main = main;
    }


    //Si se necesita verifcar campos vacíos
    private boolean verificarCampos(String nombre, String id, String direccion) { //En los parentesis se ponen los que necesitas verificar
        if (nombre.isBlank()){
            return false;
        }
        if (id.isBlank()){
            return false;
        }
        if(direccion.isBlank()){
            return false;
        }
        return true;
    }



    @FXML
        //ComboBox o Tablas
    void initialize(){
        cbGenero.getItems().add("Masculino");
        cbGenero.getItems().add("Femenino");
        cbGenero.getItems().add("Otro");
        cbGenero.getItems().add("Helicotero Apache");
    }
}
