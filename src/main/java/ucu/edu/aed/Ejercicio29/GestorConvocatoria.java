package ucu.edu.aed.Ejercicio29;

import ucu.edu.aed.implementaciones.ListaEnlazada;
import ucu.edu.aed.implementaciones.tda.TDALista;

import java.util.Comparator;

public class GestorConvocatoria {

    private static final int CANTIDAD_TITULARES = 20;

    public ResultadoConvocatoria armarConvocatoria(
            TDALista<Jugador> jugadores) {

        if (jugadores == null) {
            throw new IllegalArgumentException(
                    "La lista de jugadores no puede ser nula"
            );
        }

        TDALista<Jugador> jugadoresOrdenados =
                jugadores.ordenar(Comparator.naturalOrder());

        TDALista<Convocado> convocados =
                new ListaEnlazada<>();

        TDALista<Jugador> suplentes =
                new ListaEnlazada<>();

        int cantidadConvocados = 0;
        int cantidadJugadores = jugadoresOrdenados.tamaño();

        for (int i = 1; i <= cantidadJugadores; i++) {

            Jugador jugador = jugadoresOrdenados.obtener(i);

            if (jugador.estaHabilitado()) {

                if (cantidadConvocados < CANTIDAD_TITULARES) {

                    convocados.agregar(
                            new Convocado(
                                    jugador,
                                    TipoConvocacion.TITULAR
                            )
                    );

                    cantidadConvocados++;

                } else {

                    suplentes.agregar(jugador);
                }

            } else {

                if (cantidadConvocados < CANTIDAD_TITULARES) {

                    convocados.agregar(
                            new Convocado(
                                    jugador,
                                    TipoConvocacion.PENDIENTE
                            )
                    );

                    cantidadConvocados++;
                }
            }
        }

        int deficit =
                CANTIDAD_TITULARES - cantidadConvocados;

        return new ResultadoConvocatoria(
                convocados,
                suplentes,
                deficit
        );
    }
}