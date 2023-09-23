package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Estudiante;

public class StudentPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Estudiante estudianteLogeado;


















    public void setMain(MainApplication main, Estudiante estudiante) {
        this.main = main;
        estudianteLogeado = estudiante;
    }
}
