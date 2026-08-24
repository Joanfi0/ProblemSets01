package ucu.edu.aed.Implementaciones;

import ucu.edu.aed.Implementaciones.tda.TDALista;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaArreglo<T> implements TDALista<T>{
    private T[] elementos;
    private int cantidad;    //Dicta el tamaño actual del arreglo obviando los nulos.

    public ListaArreglo(int espacioReservar){
        this.elementos = (T[]) new Object[espacioReservar];
        this.cantidad = 0;
    }

    @Override
    public void agregar(T elem) {
        if(elem == null) return;
        if(elementos.length > cantidad) {
            elementos[cantidad] = elem;
            cantidad++;
            return;
        }
        T[] elementosNueva = (T[]) new Object[elementos.length + 1];
        for(int i = 0; i < elementos.length; i++) {
            elementosNueva[i] = elementos[i];
        }
        elementosNueva[cantidad] = elem;
        this.elementos = elementosNueva;
        cantidad++;
    }

    @Override
    public void agregar(int index, T elem) {
        if(elem == null) return;

        if(index > cantidad || index < 0) return;  //Esto esta hecho para evitar inconsistencias con los metodos iterativos (For each)
        else if (index == cantidad) {
            if(cantidad == elementos.length){
                T[] elementosNueva = (T[]) new Object[elementos.length + 1];

                for(int i = 0; i < elementos.length; i++) {
                    elementosNueva[i] = elementos[i];
                }

                elementosNueva[index] = elem;
                this.elementos = elementosNueva;
                cantidad++;
                return;
            }
            elementos[index] = elem;
            cantidad++;
        }
        else{
            if(cantidad < elementos.length){
                for(int i = cantidad; i > index ; i--){
                    elementos[i] = elementos[i-1];
                }
                elementos[index] = elem;
                cantidad++;
            }
            else if(cantidad == elementos.length){
                T[] elementosNueva = (T[]) new Object[elementos.length + 1];

                for(int i = 0; i < elementos.length; i++) {
                    elementosNueva[i] = elementos[i];
                }

                for(int i = cantidad; i > index ; i--){
                    elementosNueva[i] = elementosNueva[i-1];
                }

                elementosNueva[index] = elem;
                this.elementos = elementosNueva;
                cantidad++;
            }
        }
    }

    @Override
    public T obtener(int index) {
        return elementos[index];
    }

    @Override
    public T remover(int index) {
        if(index >= cantidad || index < 0) return null;
        T elemento = elementos[index];
        elementos[index] = null;
        for(int i = index; i < cantidad - 1; i++){
            elementos[i] = elementos[i+1];
        }
        elementos[cantidad - 1] = null;
        cantidad--;
        return elemento;
    }

    @Override
    public boolean remover(T elem) {
        if(elem == null) return false;

        for(int i = 0; i < cantidad; i++){
            if(elementos[i].equals(elem)) {
                remover(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contiene(T elem) {
        if(elem == null) return false;

        for(int i = 0; i < cantidad; i++){
            if(elementos[i].equals(elem)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indiceDe(T elem) {
        if(elem == null) return -1;

        for(int i = 0; i < cantidad; i++){
            if(elementos[i].equals(elem)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        if(criterio == null) return null;

        for(int i = 0; i < cantidad; i++) {
            if(criterio.test(elementos[i])) {
                return elementos[i];
            }
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        return null;
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
        if(!esVacio()){
            for(int i = 0; i < cantidad; i++){
                elementos[i] = null;
            }
            cantidad = 0;
        }
    }
}
