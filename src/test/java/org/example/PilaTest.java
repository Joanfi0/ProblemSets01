package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.aed.implementaciones.Pila;

import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    private Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new Pila<>();
    }

    @Test
    void pilaVaciaAlCrearlaConConstructorVacio() {
        assertTrue(pila.esVacio());
        assertEquals(0, pila.tamaño());
    }

    @Test
    void constructorConDatoDejaUnElementoEnElTope() {
        Pila<Integer> otra = new Pila<>(10);

        assertFalse(otra.esVacio());
        assertEquals(1, otra.tamaño());
        assertEquals(10, otra.tope());
    }

    @Test
    void topeDevuelveNullSiLaPilaEstaVacia() {
        assertNull(pila.tope());
    }

    @Test
    void sacaDevuelveNullSiLaPilaEstaVacia() {
        assertNull(pila.saca());
    }

    @Test
    void meteUnElementoQuedaComoTope() {
        pila.mete(1);

        assertFalse(pila.esVacio());
        assertEquals(1, pila.tamaño());
        assertEquals(1, pila.tope());
    }

    @Test
    void meteVariosElementosElUltimoQuedaComoTope() {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);

        assertEquals(3, pila.tamaño());
        assertEquals(3, pila.tope());
    }

    @Test
    void meteActualizaElTopeCadaVez() {
        pila.mete(1);
        assertEquals(1, pila.tope());

        pila.mete(2);
        assertEquals(2, pila.tope());

        pila.mete(3);
        assertEquals(3, pila.tope());
    }

    @Test
    void sacaRespetaOrdenLIFO() {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);

        assertEquals(3, pila.saca());
        assertEquals(2, pila.saca());
        assertEquals(1, pila.saca());
        assertTrue(pila.esVacio());
    }

    @Test
    void sacaDisminuyeElTamaño() {
        pila.mete(1);
        pila.mete(2);

        assertEquals(2, pila.tamaño());
        pila.saca();
        assertEquals(1, pila.tamaño());
        pila.saca();
        assertEquals(0, pila.tamaño());
    }

    @Test
    void sacaActualizaElTopeAlSiguienteElemento() {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);

        pila.saca();
        assertEquals(2, pila.tope());

        pila.saca();
        assertEquals(1, pila.tope());
    }

    @Test
    void sacaDejaLaPilaVaciaTrasSacarTodo() {
        pila.mete(1);
        pila.saca();

        assertTrue(pila.esVacio());
        assertNull(pila.tope());
        assertNull(pila.saca());
    }

    @Test
    void topeNoRemueveElElemento() {
        pila.mete(1);
        pila.mete(2);

        assertEquals(2, pila.tope());
        assertEquals(2, pila.tope());
        assertEquals(2, pila.tamaño());
    }

    @Test
    void agregarEsEquivalenteAMete() {
        pila.agregar(1);
        pila.agregar(2);

        assertEquals(2, pila.tamaño());
        assertEquals(2, pila.tope());
    }

    @Test
    void meteYSacaIntercaladosMantienenOrdenCorrecto() {
        pila.mete(1);
        pila.mete(2);
        assertEquals(2, pila.saca());

        pila.mete(3);
        pila.mete(4);
        assertEquals(4, pila.saca());
        assertEquals(3, pila.saca());
        assertEquals(1, pila.saca());
        assertTrue(pila.esVacio());
    }

    @Test
    void removerTirarIllegalArgumentException() {
        pila.mete(1);

        assertThrows(IllegalArgumentException.class, () -> pila.remover(1));
    }

    @Test
    void meteConDatoNullSeAgregaComoNodo() {
        // mete no filtra null (a diferencia de agregar en ListaEnlazada/Conjunto),
        // por lo que el dato null pasa a ser el tope.
        pila.mete(null);

        assertEquals(1, pila.tamaño());
        assertNull(pila.tope());
    }
}