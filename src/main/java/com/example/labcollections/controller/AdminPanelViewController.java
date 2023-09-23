package com.example.labcollections.controller;
import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.Prestamo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AdminPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public TableView<Estudiante> tableEstudiantes;
    public TableColumn colNombre;
    public TableColumn colCedula;
    public TableView<Bibliotecario> tableEmpleados;
    public TableColumn colNombreEmpleado;
    public TableColumn colCedulaEmpleado;
    public TableView<Libro> tableLibros;
    public TableColumn colNombreLibro;
    public TableColumn colIDLibro;
    public TableColumn colAutor;
    public TableView<Prestamo> tablePrestamo;
    public TableColumn colLibroPrestamo;
    public TableColumn colEstudiantePrestamo;
    public TableColumn colDiasPrestamo;
    public Button btnSalir;

    public void onDragTablePrestamo(MouseEvent mouseEvent) {
    }

    public void onSalirButtonClick(ActionEvent actionEvent) {
    }


    public void setMain(MainApplication main) {
        this.main = main;
    }
    @FXML
    void initialize(){

    }

}
