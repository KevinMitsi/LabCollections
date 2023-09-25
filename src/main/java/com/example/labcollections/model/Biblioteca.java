package com.example.labcollections.model;

import com.example.labcollections.exception.BiblitecarioException;
import com.example.labcollections.exception.EstudianteException;
import com.example.labcollections.exception.LibroException;
import com.example.labcollections.exception.PrestamoException;

import java.util.*;

public class Biblioteca {
    private Set<Estudiante> estudiantes;
    private Set<Libro> librosDisponibles;
    private Set<Bibliotecario> bibliotecarios;
    private Map<Integer,Prestamo> prestamos;
    private String nombre;
    private String direccion;


    public Biblioteca(String nombre, String direccion) {
        this.direccion=direccion;
        this.nombre=nombre;
        this.estudiantes=new HashSet<>();
        this.bibliotecarios=new TreeSet<>();
        this.librosDisponibles=new TreeSet<>();
        this.prestamos= new HashMap<>();
    }

    public Biblioteca() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Set<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public void setLibrosDisponibles(Set<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public Set<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Set<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Map<Integer, Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Map<Integer, Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Biblioteca that)) return false;
        return getDireccion().equals(that.getDireccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDireccion());
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public void agregarEstudiante(String id, String nombre) throws EstudianteException {
        Estudiante estudiante = new Estudiante(id, nombre);
        if (getEstudiantes().contains(estudiante)){
            throw new EstudianteException("El estudiante ya está registrado");
        }
        else {
            estudiantes.add(estudiante);
        }
    }

    public void agregarLibro(String autor, String nombreLibro) throws LibroException {
        Libro libro = new Libro(autor, nombreLibro, false);

        // Crear un Iterator para recorrer el conjunto de libros disponibles
        Iterator<Libro> iterator = getLibrosDisponibles().iterator();

        // Usar el Iterator para verificar si ya existe un libro con el mismo nombre
        while (iterator.hasNext()) {
            Libro existingLibro = iterator.next();
            if (existingLibro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                throw new LibroException("Este libro ya está agregado");
            }
        }

        // Si no se encontró un libro con el mismo nombre, agregar el nuevo libro
        getLibrosDisponibles().add(libro);
    }


    public void agregarBibliotecario(String id, String nombre) throws BiblitecarioException {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, id);
        if (getBibliotecarios().contains(bibliotecario)){
            throw new BiblitecarioException("Este bibliotecario ya existe");
        }
        else {
            getBibliotecarios().add(bibliotecario);
        }
    }

    public void agregarPrestamo(Integer key,Prestamo prestamo) throws PrestamoException {
        if (getPrestamos().containsValue(prestamo)){
            throw new PrestamoException("Este prestamo ya existe en la base de datos");
        }
        else {
            getPrestamos().put(key,prestamo);
        }
    }

    public Estudiante verificarEstudiante(String contrasena, String nombre) throws EstudianteException {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getNombre().equals(nombre) && estudiante.getId().equals(contrasena)) {
                return estudiante; // Coincide el nombre y la contraseña, retorna el estudiante
            }
        }
        throw new EstudianteException("Estudiante no encontrado"); // Si no se encuentra el estudiante, lanza una excepción
    }
    public Bibliotecario  verificarBiblitecario(String id, String nombre) throws  BiblitecarioException{
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario bibliotecario = iterator.next();
            if (bibliotecario.getNombre().equals(nombre) && bibliotecario.getId().equals(id)) {
                return bibliotecario; // Coincide el nombre y la contraseña, retorna el estudiante
            }
        }
        throw new BiblitecarioException("Bibliotecario no encontrado"); // Si no se encuentra el estudiante, lanza una excepción
    }

    public Prestamo obtenerPrestamo(Libro libroSeleccionado) throws PrestamoException {
            Iterator<Prestamo> iterator = prestamos.values().iterator();
            while (iterator.hasNext()) {
                Prestamo prestamo = iterator.next();
                if (prestamos.containsValue(prestamo)) {
                    return prestamo;
                }
            }
        throw new PrestamoException("No se encuentra este prestamo");
    }
}
