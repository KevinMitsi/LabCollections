package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewDetailViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Bibliotecario bibliotecarioLogeado;
    Prestamo prestamoSeleccionado;
    public Button btnAgregar;
    public Button btnVolver;
    public TextField tfDetale;

    public void onAgregar(ActionEvent actionEvent) throws IOException {
        if (verificarDatos(tfDetale.getText())){
            bibliotecarioLogeado.agregarDetallePrestamo(prestamoSeleccionado,tfDetale.getText());
            main.abrirVerPrestamoBibliotecario(bibliotecarioLogeado,prestamoSeleccionado);
        }
        else {
            Alerta.saltarAlertaError("Verifique el campo");
        }
    }

    private boolean verificarDatos(String text) {
        return !text.isBlank();
    }

    public void onVolver(ActionEvent actionEvent) throws IOException {
        main.abrirVerPrestamoBibliotecario(bibliotecarioLogeado,prestamoSeleccionado);
    }

    public void setMain(MainApplication main, Bibliotecario bibliotecarioLogeado, Prestamo prestamoSeleccionado){
        this.main=main;
        this.bibliotecarioLogeado=bibliotecarioLogeado;
        this.prestamoSeleccionado=prestamoSeleccionado;
    }
}
