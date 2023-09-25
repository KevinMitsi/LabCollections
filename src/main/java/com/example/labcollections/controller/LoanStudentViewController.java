package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.DetallePrestamo;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Prestamo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.Iterator;

public class LoanStudentViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;
    Prestamo prestamoSeleciconado;
    ObservableMap<Integer, DetallePrestamo>detallePrestamoObservableMapData;
    ObservableList<DetallePrestamo>listPrestamos;

    public Label lblNombreLibro;
    public Label lblAutor;
    public TableView<DetallePrestamo> tablePrestamo;
    public TableColumn<DetallePrestamo, Integer> colID;
    public TableColumn<DetallePrestamo, String> colDetalle;
    public Button Aceptar;

    public void setMain(MainApplication mainApplication, Estudiante estudianteLogeado, Prestamo prestamoSeleccionado) {
        this.main= mainApplication;
        this.estudianteLogeado=estudianteLogeado;
        this.prestamoSeleciconado=prestamoSeleccionado;
        detallePrestamoObservableMapData= FXCollections.observableMap(prestamoSeleccionado.getDetallesPrestamo());
        lblAutor.setText(prestamoSeleccionado.getLibroAsociado().getAutor());
        lblNombreLibro.setText(prestamoSeleccionado.getLibroAsociado().getTitulo());
        tablePrestamo.getItems().clear();
        tablePrestamo.setItems(obtenerListaDetalles(detallePrestamoObservableMapData));
    }


    public void onAcetarButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelEstudiante(estudianteLogeado);
    }

    private ObservableList<DetallePrestamo> obtenerListaDetalles(ObservableMap<Integer, DetallePrestamo> detallePrestamoObservableMapData) {
        listPrestamos=FXCollections.observableArrayList();
        Iterator<DetallePrestamo>iterator = detallePrestamoObservableMapData.values().iterator();
        while(iterator.hasNext()){
            DetallePrestamo detallePrestamo = iterator.next();
            listPrestamos.add(detallePrestamo);
        }
        return listPrestamos;
    }

    @FXML
    void initialize(){
        colDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoPrestamoAsociado()));
        colID.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getIdLibroPrestado()));
    }




}
