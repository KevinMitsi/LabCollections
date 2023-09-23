package com.example.labcollections.controller;

import com.example.labcollections.MainApplication;
import com.example.labcollections.model.Bibliotecario;

public class LibrarianPanelViewController {
    MainApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Bibliotecario bibliotecarioLogeado;















    public void setMain(MainApplication main, Bibliotecario bibliotecario) {
        this.main=main;
        bibliotecarioLogeado = bibliotecario;
    }
}
