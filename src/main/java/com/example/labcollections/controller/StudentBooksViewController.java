package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.exception.PrestamoException;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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

    public void onFinalizarButtonClick(ActionEvent actionEvent) throws PrestamoException {
        try {
            Prestamo prestamo = singleton.obtenerPrestamo(libroSeleccionado);
            estudianteLogeado.finalizarPrestamo(prestamo);
            // Recorrer el HashMap para encontrar y eliminar la entrada con el Prestamo específico
            Iterator<Map.Entry<Integer, Prestamo>> iterator = estudianteLogeado.getMisPrestamos().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Prestamo> entry = iterator.next();
                if (entry.getValue().equals(prestamo)) {
                    iterator.remove();
                    break;
                }
            }
            estudianteLogeado.getMisLibros().remove(libroSeleccionado);
            Alerta.saltarAlertaInformacion("LIBRO REMOVIDO Y PRESTAMO FINALIZADO");
            main.abrirPanelEstudiante(estudianteLogeado);
        } catch (PrestamoException e) {
            Alerta.saltarAlertaError(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
