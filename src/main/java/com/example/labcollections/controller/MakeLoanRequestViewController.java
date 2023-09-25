package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.LibroException;
import com.example.labcollections.exception.PrestamoException;
import com.example.labcollections.model.DetallePrestamo;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MakeLoanRequestViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;
    Libro libroLogeado;
    public Label lblNombreLibro;
    public Label lblAutor;
    public Button btnRegresar;
    public Button btnAgregar;

    public void setMain(MainApplication mainApplication, Estudiante estudianteLogeado, Libro libroDisponibleSeleccionado) {
        this.main=mainApplication;
        this.estudianteLogeado = estudianteLogeado;
        this.libroLogeado = libroDisponibleSeleccionado;
        lblNombreLibro.setText(libroLogeado.getTitulo());
        lblAutor.setText(libroLogeado.getAutor());
    }

    public void onRegresarButonCLick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelEstudiante(estudianteLogeado);
    }

    public void onAgregarButtonClick(ActionEvent actionEvent) throws LibroException {
        Prestamo prestamo;
        int codigo= (int) (Math.random() * 192);
       try{
           estudianteLogeado.agregarLibro(libroLogeado);
            prestamo = new Prestamo(String.valueOf(codigo));
            prestamo.setLibroAsociado(libroLogeado);
            prestamo.setEstudianteAsociado(estudianteLogeado);
            singleton.agregarPrestamo(singleton.getPrestamos().size(),prestamo);
            prestamo.getDetallesPrestamo().put(prestamo.getDetallesPrestamo().size()+1, new DetallePrestamo(prestamo.getCodigoPrestamo(), (int) (Math.random() * 192)));
            estudianteLogeado.getMisPrestamos().put(codigo,prestamo);
            Alerta.saltarAlertaConfirmacion("Listo prestamo agregado");
            main.abrirPanelEstudiante(estudianteLogeado);
       }catch (LibroException | PrestamoException e){
           Alerta.saltarAlertaError(e.getMessage());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
