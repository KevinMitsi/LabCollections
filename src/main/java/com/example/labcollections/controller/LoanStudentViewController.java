package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class LoanStudentViewController {
    public Label lblNombreLibro;
    public Label lblAutor;
    public TableColumn colID;
    public TableColumn colDetalle;
    public Button Aceptar;

    public void setMain(MainApplication mainApplication, Estudiante estudianteLogeado, Prestamo prestamoSeleccionado) {
    }

    public void onAcetarButtonClick(ActionEvent actionEvent) {
    }
}
