package com.example.labcollections.controller;

import com.example.labcollections.model.Biblioteca;

public class ModelFactoryController {
    Biblioteca biblioteca;

    public void agregarEstudiante(String id, String nombre) {
        biblioteca.agregarEstudiante(id, nombre);
    }

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {

        //Siempre se debe verificar si la raiz del recurso es null
        if(biblioteca == null)
        {
            System.out.println("es null");
            inicializarDatos();
         }


    }

    private void inicializarDatos() {

        biblioteca = new Biblioteca();
        System.out.println("Hostels inicializado "+ biblioteca );

    }


}
