package com.example.labcollections.controller;
import javafx.scene.control.Alert;

public interface Alerta {
    static void saltarAlertaInformacion(String contenido){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informacion");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    static void saltarAlertaAdvertencia(String contenido){
        Alert alert= new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Advertencia");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    static void saltarAlertaError(String contenido){
        Alert alert= new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("ERROR");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    static void saltarAlertaConfirmacion(String contenido){
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("LISTO");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
