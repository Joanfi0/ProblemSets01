package ucu.edu.aed.ejercicio17;

import ucu.edu.aed.Implementaciones.tda.TDALista;

import java.util.Comparator;

public class Biblioteca {

    private final TDALista<Libro> catalogo = new Lista<>();

    public double registrarAdquisicion(String codigo, String titulo, double precioReposicion, int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad adquirida no puede ser negativa");
        }

        Libro libro = buscarPorCodigo(codigo);
        if (libro == null) {
            catalogo.agregar(new Libro(codigo, titulo, precioReposicion, cantidad));
        } else {
            libro.setTitulo(titulo);
            libro.setPrecioReposicion(precioReposicion);
            libro.agregarEjemplares(cantidad);
        }

        return precioReposicion * cantidad;
    }

    public int registrarPrestamo(String codigo, int cantidadSolicitada) {
        Libro libro = buscarPorCodigo(codigo);
        if (libro == null) {
            return 0;
        }

        return libro.prestarEjemplares(cantidadSolicitada);
    }

    public int registrarDevolucion(String codigo, int cantidad) {
        Libro libro = buscarPorCodigo(codigo);
        if (libro == null) {
            return 0;
        }

        libro.agregarEjemplares(cantidad);
        return cantidad;
    }

    public boolean retirarDelCatalogo(String codigo) {
        Libro libro = buscarPorCodigo(codigo);
        if (libro == null) {
            return false;
        }

        return catalogo.remover(libro);
    }

    public int consultarExistencias(String codigo) {
        Libro libro = buscarPorCodigo(codigo);
        if (libro == null) {
            return 0;
        }

        return libro.getEjemplaresDisponibles();
    }

    public Libro buscarPorCodigo(String codigo) {
        return catalogo.buscar(libro -> libro.getCodigo().equals(codigo));
    }

    public TDALista<Libro> listarOrdenadosPorTitulo() {
        return catalogo.ordenar(Comparator.comparing(Libro::getTitulo));
    }
}
