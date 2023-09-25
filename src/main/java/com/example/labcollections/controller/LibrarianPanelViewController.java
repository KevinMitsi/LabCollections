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
import java.util.Iterator;

public class LibrarianPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    ObservableSet<Estudiante> estudianteObservableSetData = FXCollections.observableSet();
    ObservableSet<Libro>libroObservableSetData = FXCollections.observableSet();
    ObservableMap<Integer, Prestamo> prestamoObservableMapData = FXCollections.observableMap(singleton.getPrestamos());
    ObservableList<Estudiante> estudiantesList;
    ObservableList<Libro>librosList;
   ObservableList<Prestamo>prestamosList;
    public Button btnSalir;
    public TableView<Libro> tableLibros;
    public TableColumn<Libro, String> colAutor;
    public TableColumn<Libro, String> colTitulo;
    public TableColumn<Libro, Boolean> colPrestado;
    public TableView<Prestamo> tablePrestamo;
    public TableColumn<Prestamo, String> colLibroPrestamo;
    public TableColumn<Prestamo, String> colEstudiantePrestamo;
    public TableView<Estudiante> tableEstudiantes;
    public TableColumn<Estudiante, String> colCedula;
    public TableColumn<Estudiante, String> colNombre;
    public Button btnPretamo;

    Bibliotecario bibliotecarioLogeado;
    Estudiante estudianteSeleccionado;
    Libro libroDisponibleSeleccionado;
    Prestamo prestamoSeleccionado;



    public void onSalirBttonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }

    public void onDragLibros(MouseEvent mouseEvent) {

    }

    public void onDragTablePrestamo(MouseEvent mouseEvent) {
    }

    public void onPrestamoCLick(ActionEvent actionEvent) {
    }
    public void setMain(MainApplication main, Bibliotecario bibliotecario) {
        this.main=main;
        bibliotecarioLogeado = bibliotecario;
        tableEstudiantes.getItems().clear();
        tableEstudiantes.setItems(obtenerEstudiantesRegistrados());
        tableEstudiantes.refresh();
        tableLibros.getItems().clear();
        tableLibros.setItems(obtenerLibrosRegistrados());
        tableLibros.refresh();
        tablePrestamo.getItems().clear();
        tablePrestamo.setItems(obtenerPrestamosRegistrados());
        tablePrestamo.refresh();

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

    private ObservableList<Libro> obtenerLibrosRegistrados() {
        libroObservableSetData.addAll(singleton.getLibros());
        librosList = FXCollections.observableArrayList(libroObservableSetData);
        return librosList;
    }

    private ObservableList<Estudiante> obtenerEstudiantesRegistrados() {
        estudianteObservableSetData.addAll(singleton.getEstudiantes());
        estudiantesList = FXCollections.observableArrayList(estudianteObservableSetData);
        return estudiantesList;
    }


    @FXML
    void initialize(){
        colNombre.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCedula.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getId()));
      colAutor.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getAutor()));
        colPrestado.setCellValueFactory(cellData-> new SimpleBooleanProperty(cellData.getValue().isPrestado()));
        colLibroPrestamo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getLibroAsociado().getTitulo()));
        colEstudiantePrestamo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getEstudianteAsociado().getNombre()));

        tableEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection)->{
            estudianteSeleccionado = newSelection;
        });
        tableLibros.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            libroDisponibleSeleccionado = newSelection;
        });
        tablePrestamo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            prestamoSeleccionado = newSelection;
        });
    }

}
