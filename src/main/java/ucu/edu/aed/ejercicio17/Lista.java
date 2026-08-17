package ucu.edu.aed.ejercicio17;

import ucu.edu.aed.tda.TDALista;

import java.util.Comparator;
import java.util.function.Predicate;

public class Lista implements TDALista {

    class Nodo {
        Object dato;
        Nodo siguiente;
    }

    private Nodo primero;
    private int cantidad;

    @Override
    public void agregar(Object elem) {
        Nodo nuevo = new Nodo();
        nuevo.dato = elem;

        if  (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;

        }
        cantidad++;
    }

    @Override
    public void agregar(int index, Object elem) {   // agregar al final de la lista


    }

    @Override
    public Object obtener(int index) {
        return null;
    }

    @Override
    public Object remover(int index) {
        return null;
    }

    @Override
    public boolean remover(Object elem) {
        return false;
    }

    @Override
    public boolean contiene(Object elem) {
        return false;
    }

    @Override
    public int indiceDe(Object elem) {
        return 0;
    }

    @Override
    public Object buscar(Predicate criterio) {
        Nodo actual = primero;
        while (actual != null) {
            if (criterio.test(actual.dato)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public TDALista ordenar(Comparator comparator) {
        return null;
    }

    @Override
    public int tamaño() {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public void vaciar() {

    }
}
