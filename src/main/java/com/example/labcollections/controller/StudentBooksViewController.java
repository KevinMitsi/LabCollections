package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class StudentBooksViewController {
    public Button btnFinalizar;
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;
    Libro libroSeleccionado;
    public Label lblNombreLibro;
    public Label lblAutor;
    public Button Aceptar;

    public void setMain(MainApplication mainApplication, Estudiante estudianteLogeado, Libro libroPropioSeleccionado) {
        this.main = mainApplication;
        this.estudianteLogeado = estudianteLogeado;
        this.libroSeleccionado = libroPropioSeleccionado;
        lblAutor.setText(libroSeleccionado.getAutor());
        lblNombreLibro.setText(libroSeleccionado.getTitulo());
    }

    public void onAcetarButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelEstudiante(estudianteLogeado);
    }

    public void onFinalizarButtonClick(ActionEvent actionEvent) {

    }
}
