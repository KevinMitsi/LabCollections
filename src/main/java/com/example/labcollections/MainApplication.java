package com.example.labcollections;

import com.example.labcollections.controller.*;
import com.example.labcollections.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    Biblioteca biblioteca = new Biblioteca("Chapeco","aquino");
    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        inicializarLogin();

    }

    public void inicializarLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginViewController controller = fxmlLoader.getController(); //4.
        controller.setMain(this); //5.
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void abrirPestanaRegistro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("registerView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        RegisterViewController controller = fxmlLoader.getController(); //8. Crear el mismo controller que pertenece a la view
        controller.setMain(this); //9.Crear un nuevo setMain
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("adminPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        AdminPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Panel de Admin");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelEstudiante(Estudiante estudiante) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("studentPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        StudentPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this, estudiante);
        stage.setTitle("Panel estudiante");
        stage.setScene(scene);
        stage.show();

    }

    public void abrirPanelBibliotecario(Bibliotecario bibliotecario) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("librarianPanelView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        LibrarianPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this, bibliotecario);
        stage.setTitle("Panel bibliotecario");
        stage.setScene(scene);
        stage.show();
    }


    public void abrirVistaLibroEstudiante(Estudiante estudianteLogeado, Libro libroPropioSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("studentBooksView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        StudentBooksViewController controller = fxmlLoader.getController();
        controller.setMain(this, estudianteLogeado, libroPropioSeleccionado);
        stage.setTitle("Ampliacion del libro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearPrestamooEstudiante(Estudiante estudianteLogeado, Libro libroDisponibleSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("makeLoanRequestView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        MakeLoanRequestViewController controller = fxmlLoader.getController();
        controller.setMain(this, estudianteLogeado, libroDisponibleSeleccionado);
        stage.setTitle("Crear Prestamo");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliarPrestamoEstudiante(Estudiante estudianteLogeado, Prestamo prestamoSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loanStudentView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        LoanStudentViewController controller = fxmlLoader.getController();
        controller.setMain(this, estudianteLogeado, prestamoSeleccionado);
        stage.setTitle("Ampliacióon de Libro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearEmpleado() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("createEmployeeView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        CreateEmployeeViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Crear empleado");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearLibro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("registerNewBookView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        RegisterNewBookView controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Agregar libro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearPrestamoBiblitecario(Bibliotecario bibliotecarioLogeado,Libro libroDisponibleSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("acceptLoanView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        AcceptLoanViewController controller = fxmlLoader.getController();
        controller.setMain(this, bibliotecarioLogeado,libroDisponibleSeleccionado);
        stage.setTitle("Prestamo");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirVerPrestamoBibliotecario(Bibliotecario bibliotecarioLogeado,Prestamo prestamoSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("librarianLoansView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        LibrarianLoansViewController controller = fxmlLoader.getController();
        controller.setMain(this, bibliotecarioLogeado,prestamoSeleccionado);
        stage.setTitle("Prestamo");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAgregarDetalle(Bibliotecario bibliotecarioLogeado, Prestamo prestamoSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("newDetailView.fxml")); //7. Cambiar la view
        Scene scene = new Scene(fxmlLoader.load());
        NewDetailViewController controller = fxmlLoader.getController();
        controller.setMain(this,bibliotecarioLogeado,prestamoSeleccionado);
        stage.setTitle("Agregar detalle");
        stage.setScene(scene);
        stage.show();
    }
}