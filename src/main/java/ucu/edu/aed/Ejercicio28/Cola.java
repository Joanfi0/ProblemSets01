package ucu.edu.aed.Ejercicio28;

import ucu.edu.aed.ejercicio19.ListaSimple;
import ucu.edu.aed.tda.TDACola;

public class Cola<T> extends ListaSimple<T> implements TDACola<T> {

    public Cola() {
        super();
    }

    @Override
    public T frente() {
        if (this.esVacio()) {
            throw new java.util.NoSuchElementException("La cola esta vacia");
        }

        return this.obtener(0);
    }

    @Override
    public boolean poneEnCola(T dato) {
        this.agregar(dato);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (this.esVacio()) {
            throw new java.util.NoSuchElementException("La cola esta vacia");
        }

        return this.remover(0);
    }
}
