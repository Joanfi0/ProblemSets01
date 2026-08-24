package ucu.edu.aed.Implementaciones;

import ucu.edu.aed.Implementaciones.tda.TDALista;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
    protected Nodo primero;

    public ListaEnlazada(T data){
        this.primero = new Nodo(data, 1);
        this.primero.setPrimero(true);
    }

    public ListaEnlazada(){
    }

    protected class Nodo{
        private boolean esPrimero;
        private final T data;
        private Nodo siguiente;
        private int indice;

        public Nodo(T data){
            this.data = data;
            this.esPrimero = false;
            this.siguiente = null;
        }

        public Nodo(T data, Nodo siguiente) {
            this.data = data;
            this.siguiente = siguiente;
        }

        public Nodo(T data, int indice){
            this.data = data;
            this.indice = indice;
        }

        public T getData() {
            return data;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public boolean isPrimero() {
            return esPrimero;
        }

        public int getIndice() {
            return indice;
        }

        public void setPrimero(boolean esPrimero) {
            this.esPrimero = esPrimero;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public void setIndice(int indice){
            this.indice = indice;
        }
    }

    @Override
    public void agregar(T elem) {
        if (elem == null){
            return;
        }
        if(primero == null){
            primero = new Nodo(elem, 1);
            primero.setPrimero(true);
            return;
        }

        Nodo actual = primero;

        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(new Nodo(elem, actual.getIndice() + 1));
    }

    @Override
    public void agregar(int index, T elem) {
        if(elem == null) return;
        if(index < 1 || index > tamaño() + 1) return;

        if(primero == null){
            if(index == 1){
                primero = new Nodo(elem, index);
                primero.setPrimero(true);
            }
            return;
        }

        if(index == 1){
            Nodo nuevo = new Nodo(elem, 1);
            nuevo.setSiguiente(primero);
            primero.setPrimero(false);
            nuevo.setPrimero(true);

            Nodo actual = primero;
            while (actual != null){
                actual.setIndice(actual.getIndice() + 1);
                actual = actual.getSiguiente();
            }
            primero = nuevo;
            return;
        }

        Nodo actual = primero;

        while (actual.getSiguiente() != null){
            if(actual.getSiguiente().getIndice() == index){
                Nodo nuevoNodo = new Nodo(elem, index);
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);

                Nodo siguienteActual = nuevoNodo.getSiguiente();
                while (siguienteActual != null){
                    siguienteActual.setIndice(siguienteActual.getIndice() + 1);
                    siguienteActual = siguienteActual.getSiguiente();
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    @Override
    public T obtener(int index) {
        if(index < 1 || index > tamaño()) return null;

        Nodo actual = primero;
        while (actual != null){
            if(actual.getIndice() == index) return actual.getData();
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public T remover(int index) {
        if(index < 1 || index > tamaño()) return null;

        if(index == 1){
            T dataRemovida = primero.getData();
            primero = primero.getSiguiente();
            if(primero != null) primero.setPrimero(true);

            Nodo actual = primero;
            while (actual != null){
                actual.setIndice(actual.getIndice() - 1);
                actual = actual.getSiguiente();
            }
            return dataRemovida;
        }

        Nodo actual = primero;

        while (actual.getSiguiente() != null){
            if(actual.getSiguiente().getIndice() == index){
                T dataRemovida = actual.getSiguiente().getData();
                actual.setSiguiente(actual.getSiguiente().getSiguiente());

                Nodo siguienteActual = actual.getSiguiente();
                while (siguienteActual != null){
                    siguienteActual.setIndice(siguienteActual.getIndice() - 1);
                    siguienteActual = siguienteActual.getSiguiente();
                }
                return dataRemovida;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean remover(T elem) {
        if(elem == null || primero == null){
            return false;
        }

        if(primero.getData().equals(elem)){
            primero = primero.getSiguiente();
            if(primero != null) primero.setPrimero(true);

            Nodo actual = primero;
            while (actual != null){
                actual.setIndice(actual.getIndice() - 1);
                actual = actual.getSiguiente();
            }
            return true;
        }

        Nodo temporal = primero;

        while (temporal.getSiguiente() != null){
            if (temporal.getSiguiente().getData().equals(elem)){
                temporal.setSiguiente(temporal.getSiguiente().getSiguiente());

                Nodo siguienteActual = temporal.getSiguiente();
                while (siguienteActual != null){
                    siguienteActual.setIndice(siguienteActual.getIndice() - 1);
                    siguienteActual = siguienteActual.getSiguiente();
                }
                return true;
            }
            temporal = temporal.getSiguiente();
        }
        return false;
    }

    @Override
    public boolean contiene(T elem) {
        if(elem == null){
            return false;
        }
        Nodo temporal = primero;

        while (temporal != null){
            if (temporal.getData().equals(elem)){
                return true;
            }
            temporal = temporal.getSiguiente();
        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        if(elem == null || primero == null) return -1;

        Nodo actual = primero;

        while (actual != null){
            if(actual.getData().equals(elem)) return actual.getIndice();
            actual = actual.getSiguiente();
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        if(criterio == null || primero == null) return null;

        Nodo actual = primero;
        while (actual != null){
            if(criterio.test(actual.getData())) return actual.getData();
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        List<T> datos = new ArrayList<>();
        Nodo actual = primero;
        while (actual != null){
            datos.add(actual.getData());
            actual = actual.getSiguiente();
        }

        datos.sort(comparator);

        ListaEnlazada<T> resultado = new ListaEnlazada<>();
        for (T dato : datos){
            resultado.agregar(dato);
        }
        return resultado;
    }

    @Override
    public int tamaño() {
        if(esVacio()) return 0;
        int contador = 1;
        Nodo temporal = primero;

        while (temporal.getSiguiente() != null){
            temporal = temporal.getSiguiente();
            contador++;
        }
        return contador;
    }

    @Override
    public boolean esVacio() {
        if(primero == null) return true;
        return false;
    }

    @Override
    public void vaciar() {
        primero = null;
    }
}