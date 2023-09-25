package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.EstudianteException;
import com.example.labcollections.exception.PrestamoException;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AcceptLoanViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Bibliotecario bibliotecarioLogeado;
    Libro libroLogeado;

    public TextField tfNombre;
    public TextField tfCedula;
    public Button btnRegistro;
    public Label lblTitulo;
    public Label lblAutor;

    public void onRegistroButtonClick(ActionEvent actionEvent) {
        if (verificarCampos(tfNombre.getText(),tfCedula.getText())){
            try{
                Estudiante estudiante = singleton.verificarIngresoEstudiante(tfCedula.getText().replaceAll("\\s+","").toLowerCase(),tfNombre.getText().replaceAll("\\s+","").toLowerCase());
                libroLogeado.setPrestado(true);
                estudiante.getMisLibros().add(libroLogeado);
                Prestamo prestamo = new Prestamo("Libros prestado: "+libroLogeado.getTitulo());
                prestamo.setEstudianteAsociado(estudiante);
                prestamo.setLibroAsociado(libroLogeado);
                estudiante.getMisPrestamos().put(estudiante.getMisPrestamos().size()+1,prestamo);
                singleton.agregarPrestamo(singleton.getPrestamos().size()+1,prestamo);
                Alerta.saltarAlertaConfirmacion("Prestamo creado");
                main.abrirPanelBibliotecario(bibliotecarioLogeado);
            } catch (EstudianteException | PrestamoException e) {
                Alerta.saltarAlertaError(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            Alerta.saltarAlertaError("Verifique los campos");
        }
    }

    private boolean verificarCampos(String text, String text1) {
        if (text.isBlank()){
            return false;
        }
        if (text1.isBlank()){
            return false;
        }
        return true;
    }

    public void setMain(MainApplication mainApplication, Bibliotecario bibliotecarioLogeado, Libro libroDisponibleSeleccionado) {
        this.main=mainApplication;
        this.bibliotecarioLogeado=bibliotecarioLogeado;
        this.libroLogeado=libroDisponibleSeleccionado;
        lblAutor.setText(libroLogeado.getAutor());
        lblTitulo.setText(libroLogeado.getTitulo());
    }
}
