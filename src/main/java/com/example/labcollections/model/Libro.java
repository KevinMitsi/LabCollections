package com.example.labcollections.model;

import java.util.Objects;

public class Libro implements Comparable{
    private String titulo;
    private String autor;

    private boolean isPrestado;

    public Libro() {
    }

    public Libro(String titulo, String autor, boolean isPrestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isPrestado=isPrestado;
    }

    public boolean isPrestado() {
        return isPrestado;
    }

    public void setPrestado(boolean prestado) {
        isPrestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return getTitulo().equals(libro.getTitulo()) && getAutor().equals(libro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor());
    }

    public int compareTo(Libro otroLibro) {
        return this.titulo.compareTo(otroLibro.titulo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isPrestado='"+ isPrestado+'\''+
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
