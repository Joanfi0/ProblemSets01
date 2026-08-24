package ucu.edu.aed.Implementaciones;

import ucu.edu.aed.Implementaciones.tda.TDACola;

public class Cola<T> extends ListaEnlazada<T> implements TDACola<T> {

    @Override
    public T frente() {
        if(primero == null) return null;
        return this.primero.getData();
    }

    @Override
    public boolean poneEnCola(T dato) {
        if(dato == null) return false;
        agregar(dato);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if(primero == null) return null;
        return remover(1);
    }
}