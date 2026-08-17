package ucu.edu.aed.ejercicio17;

import ucu.edu.aed.tda.TDALista;

import java.util.Objects;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lista<T> implements TDALista<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
    }

    private Nodo<T> primero;
    private int cantidad;

    @Override
    public void agregar(T elem) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.dato = elem;

        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
    }

    @Override
    public void agregar(int index, T elem) {
        validarIndiceParaAgregar(index);

        Nodo<T> nuevo = new Nodo<>();
        nuevo.dato = elem;

        if (index == 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            Nodo<T> anterior = obtenerNodo(index - 1);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
        cantidad++;
    }

    @Override
    public T obtener(int index) {
        return obtenerNodo(index).dato;
    }

    @Override
    public T remover(int index) {
        validarIndiceExistente(index);

        T datoRemovido;
        if (index == 0) {
            datoRemovido = primero.dato;
            primero = primero.siguiente;
        } else {
            Nodo<T> anterior = obtenerNodo(index - 1);
            Nodo<T> removido = anterior.siguiente;
            datoRemovido = removido.dato;
            anterior.siguiente = removido.siguiente;
        }

        cantidad--;
        return datoRemovido;
    }

    @Override
    public boolean remover(T elem) {
        int indice = indiceDe(elem);
        if (indice == -1) {
            return false;
        }

        remover(indice);
        return true;
    }

    @Override
    public boolean contiene(T elem) {
        return indiceDe(elem) != -1;
    }

    @Override
    public int indiceDe(T elem) {
        Nodo<T> actual = primero;
        int indice = 0;

        while (actual != null) {
            if (Objects.equals(actual.dato, elem)) {
                return indice;
            }
            actual = actual.siguiente;
            indice++;
        }

        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (criterio.test(actual.dato)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        Lista<T> ordenada = new Lista<>();
        Nodo<T> actual = primero;

        while (actual != null) {
            ordenada.agregarOrdenado(actual.dato, comparator);
            actual = actual.siguiente;
        }

        return ordenada;
    }

    @Override
    public int tamaño() {
        return cantidad;
    }

    @Override
    public boolean esVacio() {
        return cantidad == 0;
    }

    @Override
    public void vaciar() {
        primero = null;
        cantidad = 0;
    }

    private void agregarOrdenado(T elem, Comparator<T> comparator) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.dato = elem;

        if (primero == null || comparator.compare(elem, primero.dato) <= 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null && comparator.compare(elem, actual.siguiente.dato) > 0) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        cantidad++;
    }

    private Nodo<T> obtenerNodo(int index) {
        validarIndiceExistente(index);

        Nodo<T> actual = primero;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }

        return actual;
    }

    private void validarIndiceExistente(int index) {
        if (index < 0 || index >= cantidad) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
    }

    private void validarIndiceParaAgregar(int index) {
        if (index < 0 || index > cantidad) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
    }
}
