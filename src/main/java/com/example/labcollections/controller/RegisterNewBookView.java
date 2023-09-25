package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.LibroException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterNewBookView {
    ModelFactoryController singleton = ModelFactoryController.getInstance(); //1.Linea en todos los controladores
    MainApplication main; //2.linea en todos los controladores;
    public Button btnAgregar;
    public TextField tfTitulo;
    public TextField tfAutor;
    public Button btnVolver;

    public void onAgregarButtonCLick(ActionEvent actionEvent) {
        if (verificarCampos(tfAutor.getText(), tfTitulo.getText())){
            try{
                singleton.agregarLibro(tfAutor.getText().replaceAll("\\s+","").toLowerCase(), tfTitulo.getText().replaceAll("\\s+","").toLowerCase());
                Alerta.saltarAlertaInformacion("Libro agregado con exito");
                main.abrirPanelAdmin();
            } catch (LibroException e) {
                Alerta.saltarAlertaError(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            Alerta.saltarAlertaError("Rellene los campos");
        }

    }

    public void onVolverButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelAdmin();
    }

    public  void setMain(MainApplication main){
        this.main=main;
    }
    private boolean verificarCampos(String nombre, String id) { //En los parentesis se ponen los que necesitas verificar
        if (nombre.isBlank()){
            return false;
        }
        if (id.isBlank()){
            return false;
        }
        return true;
    }
}
