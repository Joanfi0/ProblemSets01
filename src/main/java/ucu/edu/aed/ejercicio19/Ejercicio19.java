package ucu.edu.aed.ejercicio19;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.TDAPila;

import java.util.Objects;

public class Ejercicio19 {

    private Ejercicio19() {
    }

    public static boolean controlCorchetes(TDALista<Character> listaDeEntrada) {
        Objects.requireNonNull(listaDeEntrada, "listaDeEntrada");

        TDAPila<Character> pila = new Pila<>();

        for (int i = 0; i < listaDeEntrada.tamaño(); i++) {
            Character caracter = listaDeEntrada.obtener(i);

            if (Character.valueOf('{').equals(caracter)) {
                pila.mete(caracter);
            } else if (Character.valueOf('}').equals(caracter)) {
                if (pila.esVacio()) {
                    return false;
                }

                pila.saca();
            }
        }

        return pila.esVacio();
    }

}
