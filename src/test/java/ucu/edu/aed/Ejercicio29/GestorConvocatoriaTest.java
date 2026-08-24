package ucu.edu.aed.Ejercicio29;

import org.junit.jupiter.api.Test;

import ucu.edu.aed.implementaciones.ListaEnlazada;
import ucu.edu.aed.implementaciones.tda.TDALista;

import static org.junit.jupiter.api.Assertions.*;

public class GestorConvocatoriaTest {

    @Test
    public void testPrioridadDivisionYPartidas() {

        // Arrange
        TDALista<Jugador> jugadores = new ListaEnlazada<>();

        Jugador oro = new Jugador(
                "Oro",
                Division.ORO,
                1,
                EstadoJugador.HABILITADO
        );

        Jugador diamanteMuchas = new Jugador(
                "Diamante Muchas",
                Division.DIAMANTE,
                100,
                EstadoJugador.HABILITADO
        );

        Jugador diamantePocas = new Jugador(
                "Diamante Pocas",
                Division.DIAMANTE,
                10,
                EstadoJugador.HABILITADO
        );

        jugadores.agregar(oro);
        jugadores.agregar(diamanteMuchas);
        jugadores.agregar(diamantePocas);

        GestorConvocatoria gestor = new GestorConvocatoria();

        // Act
        ResultadoConvocatoria resultado =
                gestor.armarConvocatoria(jugadores);

        // Assert
        assertSame(
                diamantePocas,
                resultado.getConvocados()
                        .obtener(1)
                        .getJugador()
        );

        assertSame(
                diamanteMuchas,
                resultado.getConvocados()
                        .obtener(2)
                        .getJugador()
        );

        assertSame(
                oro,
                resultado.getConvocados()
                        .obtener(3)
                        .getJugador()
        );
    }

    @Test
    public void testMantieneOrdenRegistroEnEmpate() {

        // Arrange
        TDALista<Jugador> jugadores = new ListaEnlazada<>();

        Jugador primero = new Jugador(
                "Primero",
                Division.ORO,
                20,
                EstadoJugador.HABILITADO
        );

        Jugador segundo = new Jugador(
                "Segundo",
                Division.ORO,
                20,
                EstadoJugador.HABILITADO
        );

        jugadores.agregar(primero);
        jugadores.agregar(segundo);

        GestorConvocatoria gestor = new GestorConvocatoria();

        // Act
        ResultadoConvocatoria resultado =
                gestor.armarConvocatoria(jugadores);

        // Assert
        assertSame(
                primero,
                resultado.getConvocados()
                        .obtener(1)
                        .getJugador()
        );

        assertSame(
                segundo,
                resultado.getConvocados()
                        .obtener(2)
                        .getJugador()
        );
    }

    @Test
    public void testMasDeVeinteHabilitadosGeneraSuplentes() {

        // Arrange
        TDALista<Jugador> jugadores = new ListaEnlazada<>();

        for (int i = 0; i < 21; i++) {

            jugadores.agregar(
                    new Jugador(
                            "Jugador " + i,
                            Division.DIAMANTE,
                            i,
                            EstadoJugador.HABILITADO
                    )
            );
        }

        GestorConvocatoria gestor = new GestorConvocatoria();

        // Act
        ResultadoConvocatoria resultado =
                gestor.armarConvocatoria(jugadores);

        // Assert
        assertEquals(
                20,
                resultado.getConvocados().tamaño()
        );

        assertEquals(
                1,
                resultado.getSuplentes().tamaño()
        );

        assertEquals(
                "Jugador 20",
                resultado.getSuplentes()
                        .obtener(1)
                        .getNombre()
        );

        assertEquals(0, resultado.getDeficit());
    }

    @Test
    public void testCompletaConJugadoresPendientes() {

        // Arrange
        TDALista<Jugador> jugadores = new ListaEnlazada<>();

        for (int i = 0; i < 18; i++) {

            jugadores.agregar(
                    new Jugador(
                            "Habilitado " + i,
                            Division.ORO,
                            i,
                            EstadoJugador.HABILITADO
                    )
            );
        }

        Jugador bronce = new Jugador(
                "Bronce lesionado",
                Division.BRONCE,
                1,
                EstadoJugador.LESIONADO
        );

        Jugador diamante = new Jugador(
                "Diamante suspendido",
                Division.DIAMANTE,
                50,
                EstadoJugador.SUSPENDIDO
        );

        Jugador platino = new Jugador(
                "Platino lesionado",
                Division.PLATINO,
                30,
                EstadoJugador.LESIONADO
        );

        jugadores.agregar(bronce);
        jugadores.agregar(diamante);
        jugadores.agregar(platino);

        GestorConvocatoria gestor = new GestorConvocatoria();

        // Act
        ResultadoConvocatoria resultado =
                gestor.armarConvocatoria(jugadores);

        // Assert
        assertEquals(
                20,
                resultado.getConvocados().tamaño()
        );

        assertSame(
                diamante,
                resultado.getConvocados()
                        .obtener(19)
                        .getJugador()
        );

        assertEquals(
                TipoConvocacion.PENDIENTE,
                resultado.getConvocados()
                        .obtener(19)
                        .getTipo()
        );

        assertSame(
                platino,
                resultado.getConvocados()
                        .obtener(20)
                        .getJugador()
        );

        assertEquals(
                TipoConvocacion.PENDIENTE,
                resultado.getConvocados()
                        .obtener(20)
                        .getTipo()
        );

        assertEquals(0, resultado.getDeficit());
    }

    @Test
    public void testDeficitCuandoNoHayVeinteJugadores() {

        // Arrange
        TDALista<Jugador> jugadores = new ListaEnlazada<>();

        jugadores.agregar(
                new Jugador(
                        "Jugador 1",
                        Division.ORO,
                        10,
                        EstadoJugador.HABILITADO
                )
        );

        jugadores.agregar(
                new Jugador(
                        "Jugador 2",
                        Division.PLATA,
                        20,
                        EstadoJugador.HABILITADO
                )
        );

        jugadores.agregar(
                new Jugador(
                        "Jugador 3",
                        Division.DIAMANTE,
                        30,
                        EstadoJugador.LESIONADO
                )
        );

        GestorConvocatoria gestor = new GestorConvocatoria();

        // Act
        ResultadoConvocatoria resultado =
                gestor.armarConvocatoria(jugadores);

        // Assert
        assertEquals(
                3,
                resultado.getConvocados().tamaño()
        );

        assertEquals(17, resultado.getDeficit());

        assertTrue(resultado.hayDeficit());
    }
}