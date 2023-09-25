package com.example.labcollections.controller;
import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class AdminPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    ObservableSet<Estudiante>estudianteObservableSetData = FXCollections.observableSet();
    ObservableSet<Libro>libroObservableSetData = FXCollections.observableSet();
    ObservableSet<Bibliotecario>bibliotecarioObservableSetData = FXCollections.observableSet();
    ObservableMap<Integer,Prestamo> prestamoObservableMapData = FXCollections.observableMap(singleton.getPrestamos());
    ObservableList<Estudiante>estudiantesList;
    ObservableList<Libro>librosList;
    ObservableList<Bibliotecario>bibliotecariosList;
    ObservableList<Prestamo>prestamosList;
  Prestamo prestamoSeleccionado = null;
    public TableView<Estudiante> tableEstudiantes;
    public TableColumn<Estudiante, String> colNombre;
    public TableColumn<Estudiante, String> colCedula;
    public TableView<Bibliotecario> tableEmpleados;
    public TableColumn<Bibliotecario, String> colNombreEmpleado;
    public TableColumn<Bibliotecario, String> colCedulaEmpleado;
    public TableView<Libro> tableLibros;
    public TableColumn<Libro, String> colNombreLibro;
    public TableColumn<Libro, String> colAutor;
    public TableColumn<Libro, Boolean> colPrestado;
    public TableView<Prestamo> tablePrestamo;
    public TableColumn<Prestamo, String> colLibroPrestamo;
    public TableColumn<Prestamo, String> colEstudiantePrestamo;
    public Button btnSalir;

    public void onDragTablePrestamo(MouseEvent mouseEvent) {

    }

    public void onSalirButtonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }


    public void setMain(MainApplication main) {
        this.main = main;
        tableEstudiantes.getItems().clear();
        tableEstudiantes.setItems(obtenerEstudiantesRegistrados());
        tableEstudiantes.refresh();
        tableEmpleados.getItems().clear();
        tableEmpleados.setItems(obtenerBibliotecariosRegistrados());
        tableEmpleados.refresh();
        tableLibros.getItems().clear();
        tableLibros.setItems(obtenerLibrosRegistrados());
        tableLibros.refresh();
        tablePrestamo.getItems().clear();
        tablePrestamo.setItems(obtenerPrestamosRegistrados());
        tablePrestamo.refresh();
    }

    private ObservableList<Estudiante> obtenerEstudiantesRegistrados() {
        estudianteObservableSetData.addAll(singleton.getEstudiantes());
        estudiantesList = FXCollections.observableArrayList(estudianteObservableSetData);
        return estudiantesList;
    }
    private ObservableList<Libro> obtenerLibrosRegistrados() {
        libroObservableSetData.addAll(singleton.getLibros());
        librosList = FXCollections.observableArrayList(libroObservableSetData);
        return librosList;
    }
    private ObservableList<Bibliotecario> obtenerBibliotecariosRegistrados() {
        bibliotecarioObservableSetData.addAll(singleton.getBibliotecarios());
        bibliotecariosList = FXCollections.observableArrayList(bibliotecarioObservableSetData);
        return bibliotecariosList;
    }
    private ObservableList<Prestamo> obtenerPrestamosRegistrados() {
        prestamosList = FXCollections.observableArrayList();
        Iterator<Prestamo> iterator = prestamoObservableMapData.values().iterator();
        while (iterator.hasNext()) {
            Prestamo prestamo = iterator.next();
            prestamosList.add(prestamo);
        }
        return prestamosList;
    }
    @FXML
    void initialize(){
        colNombre.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCedula.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreEmpleado.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCedulaEmpleado.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreLibro.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colAutor.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getAutor()));
        colPrestado.setCellValueFactory(cellData-> new SimpleBooleanProperty(cellData.getValue().isPrestado()));
        colLibroPrestamo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getLibroAsociado().getTitulo()));
        colEstudiantePrestamo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getEstudianteAsociado().getNombre()));
    }

    public void OnDragEmpleado(MouseEvent mouseEvent) throws IOException {
        main.abrirCrearEmpleado();
    }
}
