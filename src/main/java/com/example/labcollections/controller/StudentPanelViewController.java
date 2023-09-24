package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentPanelViewController {
    private ObservableSet<Libro> librosEstudiantesData = FXCollections.observableSet();
    private ObservableSet<Libro> librosDisponiblesData = FXCollections.observableSet();
    private ObservableList<Libro> librosEstudiantesList;
    private ObservableList<Libro> librosDisponiblesList;
    private Libro libroPropioSeleccionado = null;
    private Libro libroDisponibleSeleccionado = null;

    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;
    public TableColumn<Libro, String> colNombre;
    public TableColumn<Libro, String> colAutor;
    public Label lblNombreEstudiante;
    public TableColumn<Libro, String>  colNomreDispo;
    public TableColumn<Libro, String>  colAutorDispo;
    public Button btnCerrar;
    public TableView<Libro> tableLibrosDisponibles;
    public TableView<Libro>tableLibrosEstudiantes;


    public void setMain(MainApplication main, Estudiante estudiante) {
        this.main = main;
        estudianteLogeado = estudiante;
        tableLibrosDisponibles.getItems().clear();
        tableLibrosDisponibles.setItems(obtenerLibrosDisponibles());
        tableLibrosEstudiantes.getItems().clear();
        tableLibrosEstudiantes.setItems(obtenerLibrosEstudiantes());
    }

    public void onDragSelection(MouseEvent mouseEvent) {
        if (libroPropioSeleccionado==null){
            Alerta.saltarAlertaError("No ha seleccionado ningún libro");
        }
        else {
            main.abrirVistaPrestamoEstudiante(estudianteLogeado);
        }

    }

    public void onCerrarButtonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }

    public void onDragDisponible(MouseEvent mouseEvent) {

    }
    @FXML
    void initialize(){
        colAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tableLibrosEstudiantes.refresh();
        colAutorDispo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        colNomreDispo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tableLibrosDisponibles.refresh();
        tableLibrosEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection)->{
            libroPropioSeleccionado = newSelection;
        });
        tableLibrosDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            libroDisponibleSeleccionado = newSelection;
        });
    }

    private ObservableList<Libro> obtenerLibrosEstudiantes(){
       librosEstudiantesData.addAll(estudianteLogeado.getMisLibros());
        librosEstudiantesList = FXCollections.observableArrayList(librosEstudiantesData);
        return librosEstudiantesList;
    }

    private ObservableList<Libro> obtenerLibrosDisponibles(){
        librosEstudiantesData.addAll(singleton.getLibros());
        librosDisponiblesList= FXCollections.observableArrayList(librosDisponiblesData);
        return librosDisponiblesList;
    }

}
