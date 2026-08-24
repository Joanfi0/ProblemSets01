package ucu.edu.aed.ejercicio26;

import ucu.edu.aed.implementaciones.Pila;

public class ParteA {
    public boolean controlCorchetes (String texto){
        if(!texto.contains("{") || !texto.contains("}")) return false;

        Pila<String> corchetes = new Pila<>();
        for(char letra: texto.toCharArray()){
            if(letra == '{') corchetes.mete("{");
            if(letra == '}'){
                if(!corchetes.contiene("{")) {
                    return false;
                }
                corchetes.saca();
            }
        }

        if(corchetes.tamaño() > 0){
            return false;
        }

        return true;
    }
}
