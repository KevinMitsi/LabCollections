package com.example.labcollections.model;

import java.util.Objects;

public class DetallePrestamo {
    private String codigoPrestamoAsociado;
    private int idLibroPrestado;


    // int strg

    public DetallePrestamo(String codigoPrestamoAsociado, int idLibroPrestado) {
        this.codigoPrestamoAsociado = codigoPrestamoAsociado;
        this.idLibroPrestado = idLibroPrestado;
    }

    public DetallePrestamo() {
    }

    public String getCodigoPrestamoAsociado() {
        return codigoPrestamoAsociado;
    }

    public void setCodigoPrestamoAsociado(String codigoPrestamoAsociado) {
        this.codigoPrestamoAsociado = codigoPrestamoAsociado;
    }

    public int getIdLibroPrestado() {
        return idLibroPrestado;
    }

    public void setIdLibroPrestado(int idLibroPrestado) {
        this.idLibroPrestado = idLibroPrestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePrestamo that)) return false;
        return getIdLibroPrestado() == that.getIdLibroPrestado() && getCodigoPrestamoAsociado().equals(that.getCodigoPrestamoAsociado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoPrestamoAsociado(), getIdLibroPrestado());
    }

    @Override
    public String toString() {
        return "DetallePrestamo{" +
                "codigoPrestamoAsociado='" + codigoPrestamoAsociado + '\'' +
                ", idLibroPrestado=" + idLibroPrestado +
                '}';
    }
}
