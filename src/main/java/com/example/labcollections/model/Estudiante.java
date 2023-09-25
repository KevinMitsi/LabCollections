package com.example.labcollections.model;

import com.example.labcollections.exception.LibroException;
import com.example.labcollections.exception.PrestamoException;

import java.util.*;

public class Estudiante {
    private String id;
    private String nombre;

    private Set<Libro> misLibros;

    private Map<Integer, Prestamo> misPrestamos;

    public Estudiante() {
    }

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.misLibros = new TreeSet<>();
        this.misPrestamos = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<Integer, Prestamo> getMisPrestamos() {
        return misPrestamos;
    }

    public void setMisPrestamos(Map<Integer, Prestamo> misPrestamos) {
        this.misPrestamos = misPrestamos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Set<Libro> getMisLibros() {
        return misLibros;
    }

    public void setMisLibros(Set<Libro> misLibros) {
        this.misLibros = misLibros;
    }

    public void agregarLibro(Libro libro) throws LibroException {
        if (misLibros.contains(libro)){
            throw new LibroException("Ya tienes este libro prestado");
        }
        else {
            if (libro.isPrestado()){
                throw new LibroException("Este libro no está disponible");
            }
            else {
                libro.setPrestado(true);
                misLibros.add(libro);
            }
        }
    }

    public void devolverLibro(Libro libro) throws LibroException {
        if(!misLibros.contains(libro)){
            throw new LibroException("Este libro no lo tiene prestado");
        }
        else {
            libro.setPrestado(false);
            misLibros.remove(libro);
        }
    }

    public void hacerPrestamo(Integer key, Prestamo prestamo) throws PrestamoException {
        if(misPrestamos.containsValue(prestamo)){
            throw new PrestamoException("No se pueden hacer préstamo repetidos");
        }
        else {
            misPrestamos.put(key, prestamo);
        }
    }

    public void finalizarPrestamo(Prestamo prestamo) throws PrestamoException {
        // Verificar si el préstamo existe en el HashMap
        if (!misPrestamos.containsValue(prestamo)) {
            throw new PrestamoException("Este préstamo no existe o ya fue finalizado");
        } else {
            // Iterar a través de las entradas del HashMap para encontrar el préstamo
            Iterator<Map.Entry<Integer, Prestamo>> iterator = misPrestamos.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Prestamo> entry = iterator.next();
                if (entry.getValue().equals(prestamo)) {
                    // Remover el préstamo del HashMap
                    iterator.remove();
                    System.out.println("Préstamo finalizado y eliminado del sistema.");
                    return; // Salir del método después de eliminar el préstamo
                }
            }
        }
    }


}
