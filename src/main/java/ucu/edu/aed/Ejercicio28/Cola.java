package ucu.edu.aed.Ejercicio28;

import ucu.edu.aed.implementaciones.ListaEnlazada;
import ucu.edu.aed.implementaciones.tda.TDACola;

import java.util.NoSuchElementException;

public class Cola<T> extends ListaEnlazada<T> implements TDACola<T> {

    public Cola() {
        super();
    }

    @Override
    public T frente() {
        if (this.esVacio()) {
            throw new NoSuchElementException("La cola esta vacia");
        }

        return this.obtener(1);
    }

    @Override
    public boolean poneEnCola(T dato) {
        this.agregar(dato);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (this.esVacio()) {
            throw new NoSuchElementException("La cola esta vacia");
        }

        return this.remover(1);
    }
}