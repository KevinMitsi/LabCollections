package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Iterator;

public class StudentPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;
    private ObservableSet<Libro> librosEstudiantesData = FXCollections.observableSet();
    private ObservableSet<Libro> librosDisponiblesData = FXCollections.observableSet();
    private ObservableList<Libro> librosEstudiantesList;
    private ObservableList<Libro> librosDisponiblesList;
    private ObservableMap<Integer, Prestamo>observableMapData;
    private ObservableList<Prestamo>prestamosList;
    private Libro libroPropioSeleccionado = null;
    private Libro libroDisponibleSeleccionado = null;
    private Prestamo prestamoSeleccionado=null;
    public TableColumn<Libro, String> colNombre;
    public TableColumn<Libro, String> colAutor;
    public Label lblNombreEstudiante;
    public TableColumn<Libro, String>  colNomreDispo;
    public TableColumn<Libro, String>  colAutorDispo;
    public Button btnCerrar;
    public TableView<Libro> tableLibrosDisponibles;
    public TableView<Libro>tableLibrosEstudiantes;
    public TableView<Prestamo> tablePrestamos;
    public TableColumn<Prestamo, String> colIdPrestamo;
    public TableColumn<Prestamo, String> colDetalle;




    public void setMain(MainApplication main, Estudiante estudiante) {
        this.main = main;
        this.estudianteLogeado = estudiante;
        observableMapData = FXCollections.observableMap(estudianteLogeado.getMisPrestamos());
        lblNombreEstudiante.setText(estudiante.getNombre());
        tableLibrosDisponibles.getItems().clear();
        tableLibrosDisponibles.setItems(obtenerLibrosDisponibles());
        tableLibrosEstudiantes.getItems().clear();
        tableLibrosEstudiantes.setItems(obtenerLibrosEstudiantes());
        tablePrestamos.getItems().clear();
        tablePrestamos.setItems(obtenerPrestamosRegistrados());
        }

    public void onDragSelection(MouseEvent mouseEvent) throws IOException {
        if (libroPropioSeleccionado==null){
            Alerta.saltarAlertaError("No ha seleccionado ningún libro");
        }
        else {
            main.abrirVistaLibroEstudiante(estudianteLogeado, libroPropioSeleccionado);
        }

    }

    public void onCerrarButtonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }

    public void onDragDisponible(MouseEvent mouseEvent) throws IOException {
        if (libroDisponibleSeleccionado==null){
            Alerta.saltarAlertaError("No ha seleccionado ningún libro");
        }
        else {
            main.abrirCrearPrestamooEstudiante(estudianteLogeado, libroDisponibleSeleccionado);
        }
    }
    public void onDragPrestamo(MouseEvent mouseEvent) throws IOException {
        main.abrirAmpliarPrestamoEstudiante(estudianteLogeado, prestamoSeleccionado);
    }

    @FXML
    void initialize(){
        colAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tableLibrosEstudiantes.refresh();
        colAutorDispo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        colNomreDispo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tableLibrosDisponibles.refresh();
        colIdPrestamo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCodigoPrestamo()));
        colDetalle.setCellValueFactory(cellData->new SimpleObjectProperty(cellData.getValue().getDetallesPrestamo()));
        tableLibrosEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection)->{
            libroPropioSeleccionado = newSelection;
        });
        tableLibrosDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            libroDisponibleSeleccionado = newSelection;
        });
        tablePrestamos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            prestamoSeleccionado = newSelection;
        });
    }

    private ObservableList<Libro> obtenerLibrosEstudiantes(){
       librosEstudiantesData.addAll(estudianteLogeado.getMisLibros());
        librosEstudiantesList = FXCollections.observableArrayList(librosEstudiantesData);
        return librosEstudiantesList;
    }

    private ObservableList<Libro> obtenerLibrosDisponibles(){
        librosDisponiblesData.addAll(singleton.getLibrosDisponibles());
        librosDisponiblesList= FXCollections.observableArrayList(librosDisponiblesData);
        return librosDisponiblesList;
    }

    private ObservableList<Prestamo> obtenerPrestamosRegistrados() {
        prestamosList = FXCollections.observableArrayList();
        Iterator<Prestamo> iterator = observableMapData.values().iterator();
        while (iterator.hasNext()) {
            Prestamo prestamo = iterator.next();
            prestamosList.add(prestamo);
        }
        return prestamosList;
    }



}
