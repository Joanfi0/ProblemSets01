package ucu.edu.aed.ejercicio17;

import ucu.edu.aed.implementaciones.tda.TDALista;
import ucu.edu.aed.utils.FileUtils;

public class Ejercicio17 {

    private static final String ARCHIVO_ADQUISICIONES = "src/main/resources/recursos-ejercicio-17/adquisiciones.txt";
    private static final String ARCHIVO_PRESTAMOS = "src/main/resources/recursos-ejercicio-17/prestamos.txt";

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        double valorAgregado = procesarAdquisiciones(biblioteca, ARCHIVO_ADQUISICIONES);
        int variacionPrestados = procesarPrestamos(biblioteca, ARCHIVO_PRESTAMOS);

        System.out.println("Valor total agregado al stock: " + valorAgregado);
        System.out.println("Variacion total de ejemplares prestados: " + variacionPrestados);
        System.out.println("Catalogo ordenado por titulo:");
        imprimirCatalogo(biblioteca);
    }

    public static double procesarAdquisiciones(Biblioteca biblioteca, String archivo) {
        final double[] total = {0};

        leerLineas(archivo, linea -> {
            String[] campos = separarCampos(linea, 4);
            if (campos == null) {
                return;
            }

            String codigo = campos[0];
            String titulo = campos[1];
            double precioReposicion = Double.parseDouble(campos[2]);
            int cantidad = Integer.parseInt(campos[3]);

            total[0] += biblioteca.registrarAdquisicion(codigo, titulo, precioReposicion, cantidad);
        });

        return total[0];
    }

    public static int procesarPrestamos(Biblioteca biblioteca, String archivo) {
        final int[] variacionPrestados = {0};

        leerLineas(archivo, linea -> {
            String[] campos = separarCampos(linea, 3);
            if (campos == null) {
                return;
            }

            String codigo = campos[0];
            String tipo = campos[1];
            int cantidad = Integer.parseInt(campos[2]);

            if ("PRESTAMO".equalsIgnoreCase(tipo)) {
                variacionPrestados[0] += biblioteca.registrarPrestamo(codigo, cantidad);
            } else if ("DEVOLUCION".equalsIgnoreCase(tipo)) {
                variacionPrestados[0] -= biblioteca.registrarDevolucion(codigo, cantidad);
            } else {
                System.err.println("Tipo de movimiento desconocido: " + tipo);
            }
        });

        return variacionPrestados[0];
    }

    private static void imprimirCatalogo(Biblioteca biblioteca) {
        TDALista<Libro> libros = biblioteca.listarOrdenadosPorTitulo();

        for (int i = 0; i < libros.tamaño(); i++) {
            Libro libro = libros.obtener(i);
            System.out.println(libro);
        }
    }

    private static String[] separarCampos(String linea, int cantidadEsperada) {
        if (linea == null || linea.trim().isEmpty() || linea.trim().startsWith("#")) {
            return null;
        }

        String[] campos = linea.split(",");
        if (campos.length != cantidadEsperada) {
            System.err.println("Linea ignorada por formato invalido: " + linea);
            return null;
        }

        for (int i = 0; i < campos.length; i++) {
            campos[i] = campos[i].trim();
        }

        return campos;
    }

    private static void leerLineas(String archivo, ProcesadorLinea procesador) {
        FileUtils.leerLineas(archivo, procesador::procesar);
    }

    private interface ProcesadorLinea {
        void procesar(String linea);
    }
}
