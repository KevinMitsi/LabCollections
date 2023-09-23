package com.example.labcollections.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prestamo {
    private String codigoPrestamo;
    private Map<Integer, DetallePrestamo> detallesPrestamo;

    public Prestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
        this.detallesPrestamo = new HashMap<>();
    }
    public void agregarDetallePrestamo(int idLibroPrestado, String codigoPrestamoAsociado) {
        DetallePrestamo detalle = new DetallePrestamo( codigoPrestamoAsociado, idLibroPrestado);
        detallesPrestamo.put(idLibroPrestado, detalle);
    }

    public Prestamo() {
    }

    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Map<Integer, DetallePrestamo> getDetallesPrestamo() {
        return detallesPrestamo;
    }

    public void setDetallesPrestamo(Map<Integer, DetallePrestamo> detallesPrestamo) {
        this.detallesPrestamo = detallesPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return getCodigoPrestamo().equals(prestamo.getCodigoPrestamo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoPrestamo());
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "codigoPrestamo='" + codigoPrestamo + '\'' +
                ", detallesPrestamo=" + detallesPrestamo +
                '}';
    }
}
