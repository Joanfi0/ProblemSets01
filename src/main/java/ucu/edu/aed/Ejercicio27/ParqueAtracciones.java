package ucu.edu.aed.Ejercicio27;

import java.util.Scanner;

public class ParqueAtracciones {
    private RuedaDeLaFortuna unaRueda;

    public ParqueAtracciones(int cantidadCabinas){
        this.unaRueda = new RuedaDeLaFortuna(cantidadCabinas);
    }

    public RuedaDeLaFortuna getUnaRueda() {
        return unaRueda;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de cabinas:");
        ParqueAtracciones unParque = new ParqueAtracciones(new Scanner(System.in).nextInt());

        unParque.getUnaRueda().setActivo(true);
        unParque.getUnaRueda().avanzar();

         //El Main no se encuentra completo. EL programa no devuelve nada por Consola
    }
}
