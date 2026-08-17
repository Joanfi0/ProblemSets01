package ucu.edu.aed.ejercicio17;

import java.util.Objects;

public class Libro {

    private final String codigo;
    private String titulo;
    private double precioReposicion;
    private int ejemplaresDisponibles;

    public Libro(String codigo, String titulo, double precioReposicion, int ejemplaresDisponibles) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo del libro es obligatorio");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo del libro es obligatorio");
        }
        if (precioReposicion < 0) {
            throw new IllegalArgumentException("El precio de reposicion no puede ser negativo");
        }
        if (ejemplaresDisponibles < 0) {
            throw new IllegalArgumentException("La cantidad de ejemplares no puede ser negativa");
        }

        this.codigo = codigo.trim();
        this.titulo = titulo.trim();
        this.precioReposicion = precioReposicion;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo del libro es obligatorio");
        }
        this.titulo = titulo.trim();
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public void setPrecioReposicion(double precioReposicion) {
        if (precioReposicion < 0) {
            throw new IllegalArgumentException("El precio de reposicion no puede ser negativo");
        }
        this.precioReposicion = precioReposicion;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void agregarEjemplares(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a agregar no puede ser negativa");
        }
        ejemplaresDisponibles += cantidad;
    }

    public int prestarEjemplares(int cantidadSolicitada) {
        if (cantidadSolicitada < 0) {
            throw new IllegalArgumentException("La cantidad solicitada no puede ser negativa");
        }

        int cantidadPrestada = Math.min(cantidadSolicitada, ejemplaresDisponibles);
        ejemplaresDisponibles -= cantidadPrestada;
        return cantidadPrestada;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (!(otro instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) otro;
        return codigo.equals(libro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " - stock: " + ejemplaresDisponibles;
    }
}
