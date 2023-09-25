package com.example.labcollections.controller;

import com.example.labcollections.exception.BiblitecarioException;
import com.example.labcollections.exception.EstudianteException;
import com.example.labcollections.exception.LibroException;
import com.example.labcollections.exception.PrestamoException;
import com.example.labcollections.model.Estudiante;
import com.example.labcollections.model.Biblioteca;
import com.example.labcollections.model.Bibliotecario;
import com.example.labcollections.model.Prestamo;
import com.example.labcollections.model.Libro;
import com.example.labcollections.model.DetallePrestamo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ModelFactoryController {
    Biblioteca biblioteca;

    public void agregarEstudiante(String id, String nombre) throws EstudianteException {
        biblioteca.agregarEstudiante(id, nombre);
    }
    public void agregarLibro(String autor, String nombreLibro) throws LibroException {
        biblioteca.agregarLibro(autor, nombreLibro);
    }

    public void agregarBiblitecario(String id, String nombre) throws BiblitecarioException {
        biblioteca.agregarBibliotecario(id, nombre);
    }

    public void agregarPrestamo(Integer key, Prestamo prestamo) throws PrestamoException {
        biblioteca.agregarPrestamo(key, prestamo);
    }
    public Estudiante verificarIngresoEstudiante(String id, String estudiante) throws EstudianteException {
       return biblioteca.verificarEstudiante(id,estudiante);
    }
    public Bibliotecario verificarIngresoBiblitecario(String id, String nombre) throws BiblitecarioException {
        return biblioteca.verificarBiblitecario(id, nombre);
    }


    //TODO métodos de get

    public Set<Estudiante> getEstudiantes(){
        return biblioteca.getEstudiantes();
    }
    public Set<Bibliotecario> getBibliotecarios(){
        return biblioteca.getBibliotecarios();
    }

    public Set<Libro> getLibros(){
        return biblioteca.getLibrosDisponibles();
    }

    public Map<Integer,Prestamo> getPrestamos(){
        return biblioteca.getPrestamos();
    }

    public Prestamo obtenerPrestamo(Libro libroSeleccionado) throws PrestamoException {
        return biblioteca.obtenerPrestamo(libroSeleccionado);
    }

    public Set<Libro>getLibrosDisponibles(){
        Set<Libro>disponibles = new TreeSet<>();
        Iterator<Libro> iterator = getLibros().iterator();
        while (iterator.hasNext()){
            Libro libro = iterator.next();
            if (!libro.isPrestado()){
                disponibles.add(libro);
            }
        }
        return disponibles;
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
            inicializarDatos();
         }


    }

    private void inicializarDatos() {

        biblioteca = new Biblioteca("Chapeco", "aquino");
        //Bibliotecarios
        Bibliotecario bibliotecario = new Bibliotecario(("Camilo".replaceAll("\\s+","").toLowerCase()), "123");
        Bibliotecario bibliotecario1 = new Bibliotecario(("Juan".replaceAll("\\s+","").toLowerCase()), "3211");
        Bibliotecario bibliotecario2 = new Bibliotecario(("Patricio".replaceAll("\\s+","").toLowerCase()), "1424");
        //Estudiantes
        Estudiante estudiante1 = new Estudiante("1092", "Ana Sofia Duque Torres".replaceAll("\\s+","").toLowerCase());
        Estudiante estudiante2 = new Estudiante("1004", "Kevin Andrés García Aguirre".replaceAll("\\s+","").toLowerCase());
        //Libros
        Libro libro1 = new Libro("Cien anios de soledad", "Grabiel Garcia Marques",false);
        Libro libro2 = new Libro("El Amor en los tiempos de colera", "Grabiel Garcia Marques",false);
        Libro libro3 = new Libro("Calculo vectorial multivariado", "Stewart",false);
        Libro libro4 = new Libro("Calculo Integral", "Stewart",false);
        Libro libro5 = new Libro("Calculo Diferencial", "Stewart",false);

        //prestamos
        Prestamo prestamo1 = new Prestamo("123");
        Prestamo prestamo2 = new Prestamo("342");
        Prestamo prestamo3 = new Prestamo("782");
        //datalles Prestamo
        DetallePrestamo detalle1 = new DetallePrestamo("Libro prestado: Cien anios",1);
        DetallePrestamo detalle2 = new DetallePrestamo("Libro prestado: El amor",2);
        DetallePrestamo detalle3 = new DetallePrestamo("Libro prestado: Calculo vecotrial",3);
        //Asosiación al map
        prestamo1.getDetallesPrestamo().put(prestamo1.getDetallesPrestamo().size()+1,detalle1);
        prestamo2.getDetallesPrestamo().put(prestamo2.getDetallesPrestamo().size()+1,detalle2);
        prestamo3.getDetallesPrestamo().put(prestamo3.getDetallesPrestamo().size()+1,detalle3);

        prestamo1.setEstudianteAsociado(estudiante1);
        prestamo2.setEstudianteAsociado(estudiante1);
        prestamo3.setEstudianteAsociado(estudiante2);
        prestamo1.setLibroAsociado(libro1);
        prestamo2.setLibroAsociado(libro2);
        prestamo3.setLibroAsociado(libro3);
        estudiante1.getMisLibros().add(libro1);
        estudiante1.getMisLibros().add(libro2);
        estudiante2.getMisLibros().add(libro3);
        libro1.setPrestado(true);
        libro2.setPrestado(true);
        libro3.setPrestado(true);

        System.out.println("Bibliteca inicializado "+ biblioteca );
         //todo: add biblietecarios
        biblioteca.getBibliotecarios().add(bibliotecario);
        biblioteca.getBibliotecarios().add(bibliotecario1);
        biblioteca.getBibliotecarios().add(bibliotecario2);
        //TODO: add Libros
        biblioteca.getLibrosDisponibles().add(libro1);
        biblioteca.getLibrosDisponibles().add(libro2);
        biblioteca.getLibrosDisponibles().add(libro3);
        biblioteca.getLibrosDisponibles().add(libro4);
        biblioteca.getLibrosDisponibles().add(libro5);
        //todo: add Prestamos
        biblioteca.getPrestamos().put(getPrestamos().size()+1,prestamo1);
        biblioteca.getPrestamos().put(getPrestamos().size()+1,prestamo2);
        biblioteca.getPrestamos().put(getPrestamos().size()+1,prestamo3);
        estudiante1.getMisPrestamos().put(estudiante1.getMisPrestamos().size()+1,prestamo1);
        estudiante1.getMisPrestamos().put(estudiante1.getMisPrestamos().size()+1,prestamo2);
        estudiante2.getMisPrestamos().put(estudiante2.getMisPrestamos().size()+1,prestamo3);
        //Todo add estudiantes
        biblioteca.getEstudiantes().add(estudiante1);
        biblioteca.getEstudiantes().add(estudiante2);

    }


}
