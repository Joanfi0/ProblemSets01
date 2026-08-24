package ucu.edu.aed.Implementaciones;

import ucu.edu.aed.Implementaciones.tda.TDAPila;

public class Pila<T> extends ListaEnlazada<T> implements TDAPila<T> {

    public Pila(T data) {
        super(data);
    }

    public Pila(){
    }

    @Override
    public T tope() {
        if(primero == null){
            return null;
        }
        return primero.getData();
    }

    @Override
    public T saca() {
        if(primero == null){
            return null;
        }

        Nodo nodoActual = new Nodo (primero.getData());
        primero = primero.getSiguiente();
        return nodoActual.getData();
    }

    @Override
    public void mete(T dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if(primero != null){
            primero.setPrimero(false);
            nuevoNodo.setSiguiente(primero);
        }

        nuevoNodo.setPrimero(true);
        primero = nuevoNodo;
    }

    @Override
    public void agregar(T elem) {
        mete(elem);
    }

    @Override
    public boolean remover(T elem) {
        throw new IllegalArgumentException("En una pila el metodo se llama saca");
    }
}