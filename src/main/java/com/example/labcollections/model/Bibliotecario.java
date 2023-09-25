package com.example.labcollections.model;

import java.util.Objects;

public class Bibliotecario implements Comparable<Bibliotecario>{
    private String nombre;
    private String id;

    public Bibliotecario() {
    }

    public Bibliotecario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bibliotecario that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    @Override
    public String toString() {
        return "Bibliotecario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public int compareTo(Bibliotecario o) {
        return this.nombre.compareTo(o.getNombre());
    }

    public void agregarDetallePrestamo(Prestamo prestamoSeleccionado, String text) {
        prestamoSeleccionado.getDetallesPrestamo().put(prestamoSeleccionado.getDetallesPrestamo().size()+1, new DetallePrestamo(text, (int)(Math.random()*129)));
    }
}
