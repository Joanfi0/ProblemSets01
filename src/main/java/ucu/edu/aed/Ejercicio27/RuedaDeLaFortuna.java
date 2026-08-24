package ucu.edu.aed.Ejercicio27;

import java.util.ArrayList;

public class RuedaDeLaFortuna {
    private ArrayList<Cabina> cabinas;
    private boolean activo;

    public RuedaDeLaFortuna(int cantidadCabinas){
        cabinas = new ArrayList<>(cantidadCabinas);
        activo = false;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayList<Cabina> getCabinas() {
        return cabinas;
    }

    public boolean pasajerosEsperando(int cantidad){
        return cantidad != 0;
    }

    public void subirPasajeros(Cabina unaCabina){    //O(1)
        unaCabina.setCantidadPasajeros(1);
        unaCabina.setVacía(false);
    }

    public void bajarPasajeros(Cabina unaCabina){    //O(1)
        unaCabina.setCantidadPasajeros(0);
        unaCabina.setVacía(true);
    }

    public void avanzar(){       //O(1)
        int contador = 0;
        Cabina cabinaActual;

        while (isActivo()){
            if(contador >= cabinas.size()) contador = 0;
            cabinaActual = cabinas.get(contador);

            if(pasajerosEsperando(1)){

                if(cabinaActual.isVacía()){
                    subirPasajeros(cabinaActual);
                } else {
                    bajarPasajeros(cabinaActual);
                    subirPasajeros(cabinaActual);
                }
            } else {
                bajarPasajeros(cabinaActual);
            }
            contador++;
        }
    }
}

/*
    En este caso se utiliza un ArrayList para representar la cola circular. Sin embargo, esto es eficiente porque se
    conoce la cantidad de Cabinas que hay, pero, dado un caso hipotético donde se eliminen y se ingresen cabinas
    aleatoriamente, esta estructura deja de ser eficiente debido a la alta demanda de recursos que implica mover
    las cabinas de una posición N a una posción N-1 o N+1. Si este fuese el caso, lo más eficiente sería representar
    la cola como una Lista Enlazada pese a perdida de recursos que implica moverse nodo a nodo.
*/