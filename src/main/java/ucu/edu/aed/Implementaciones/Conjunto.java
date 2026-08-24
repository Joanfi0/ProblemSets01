package ucu.edu.aed.Implementaciones;

import ucu.edu.aed.Implementaciones.tda.TDAConjunto;

public class Conjunto<T> extends ListaEnlazada<T> implements TDAConjunto<T> {

    @Override
    public void agregar(T elem) {
        if(!this.contiene(elem)) super.agregar(elem);
    }

    @Override
    public void agregar(int index, T elem) {
        if(!this.contiene(elem)) super.agregar(index, elem);
    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        TDAConjunto<T> resultado = new Conjunto<>();

        for(int i = 1; i <= this.tamaño() ; i++){
            resultado.agregar(this.obtener(i));
        }

        for(int i = 1; i <= otro.tamaño(); i++){
            resultado.agregar(otro.obtener(i));
        }
        return resultado;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        TDAConjunto<T> resultado = new Conjunto<>();

        for(int i = 1; i <= this.tamaño() ; i++){
            if(otro.contiene(this.obtener(i))) resultado.agregar(this.obtener(i));
        }

        return resultado;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        TDAConjunto<T> resultado = new Conjunto<>();

        for(int i = 1; i <= this.tamaño() ; i++){
            if(!otro.contiene(this.obtener(i))) resultado.agregar(this.obtener(i));
        }

        return resultado;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        if(this.esVacio()) return true;
        if(otro.esVacio()) return false;

        for(int i = 1; i <= this.tamaño() ; i++){
            if(!otro.contiene(this.obtener(i))) return false;
        }

        return true;
    }
}