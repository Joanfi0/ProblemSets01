import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.aed.implementaciones.ListaEnlazada;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEnlazadaTest {

    private ListaEnlazada<String> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaEnlazada<>();
    }

    @Test
    public void testRemoverElementoExistente() {
        // Arrange
        lista.agregar("Montevideo");
        lista.agregar("Canelones");

        // Act
        boolean resultado = lista.remover("Montevideo");

        // Assert
        assertTrue(resultado, "El método debería retornar true al eliminar un elemento existente.");
        assertEquals(1, lista.tamaño(), "El tamaño de la lista debería reducirse a 1.");
        assertFalse(lista.contiene("Montevideo"), "La lista ya no debería contener el elemento eliminado.");
    }

    @Test
    public void testRemoverElementoInexistente() {
        // Arrange
        lista.agregar("Montevideo");

        // Act
        boolean resultado = lista.remover("Maldonado");

        // Assert
        assertFalse(resultado, "El método debería retornar false si el elemento no se encuentra en la lista.");
        assertEquals(1, lista.tamaño(), "El tamaño de la lista no debería modificarse.");
    }

    @Test
    public void testRemoverEnListaVacia() {
        // Act
        boolean resultado = lista.remover("Montevideo");

        // Assert
        assertFalse(resultado, "El método debería retornar false al intentar remover en una lista vacía.");
        assertTrue(lista.esVacio(), "La lista debe permanecer vacía.");
        assertEquals(0, lista.tamaño(), "El tamaño de la lista vacía debe ser 0.");
    }
}