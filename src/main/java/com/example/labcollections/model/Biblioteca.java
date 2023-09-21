package com.example.labcollections.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Biblioteca {
    private Set<Estudiante> estudiantes;
    private Set<Libro> librosDisponibles;
    private Set<Bibliotecario> bibliotecarios;


    private String nombre;
    private String direccion;

    public Biblioteca(String nombre, String direccion) {
        this.direccion=direccion;
        this.nombre=nombre;
        this.estudiantes=new HashSet<>();
        this.bibliotecarios=new TreeSet<>();
        this.librosDisponibles=new TreeSet<>();
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

    public void agregarEstudiante(String id, String nombre) {
        Estudiante estudiante = new Estudiante(id, nombre);
        estudiantes.add(estudiante);
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }


    public Set<Libro> obtenerLibrosDisponibles() {
        return librosDisponibles;
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
    }


    public Set<Bibliotecario> obtenerBibliotecariosOrdenadosPorID() {
        return bibliotecarios;
    }


}
