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

    private List<Prestamo> prestamos;


    private String nombre;
    private String direccion;

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Biblioteca(String nombre, String direccion) {
        this.direccion=direccion;
        this.nombre=nombre;
        this.estudiantes=new HashSet<>();
        this.bibliotecarios=new TreeSet<>();
        this.librosDisponibles=new TreeSet<>();
        this.prestamos= new ArrayList<>();
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

    public void agregarLibro(Libro libro) throws LibroException {
        if (getLibrosDisponibles().contains(libro)){
            throw new LibroException("Este libro ya está agregado");
        }
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario) throws BiblitecarioException {
        if (getBibliotecarios().contains(bibliotecario)){
            throw new BiblitecarioException("Este bibliotecario ya existe");
        }
        else {
            getBibliotecarios().add(bibliotecario);
        }
    }

    public void agregarPrestamo(Prestamo prestamo) throws PrestamoException {
        if (getPrestamos().contains(prestamo)){
            throw new PrestamoException("Este prestamo ya existe en la base de datos");
        }
        else {
            getPrestamos().add(prestamo);
        }
    }

    public void verificarEstudiante(Estudiante estudiante) throws EstudianteException {
        if (!getEstudiantes().contains(estudiante)){
            throw new EstudianteException("Este estuiante no se encuentra registrado");
        }
    }

    public void  verificarBiblitecario(Bibliotecario bibliotecario) throws  BiblitecarioException{
        if (!getBibliotecarios().contains(bibliotecario)){
            throw  new BiblitecarioException("Este trabajador no se encuentra registrado");
        }
    }
}
