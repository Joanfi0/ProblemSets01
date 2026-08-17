package ucu.edu.aed;


import ucu.edu.aed.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {

    public static void main(String[] args) {
        List<String> lineas = new ArrayList<>();

        FileUtils.leerLineas("src/main/java/ucu/edu/aed/resources/numeros.txt", linea -> {
            lineas.add(linea);
        });

        int N = Integer.parseInt(lineas.get(0));
        int [] arreglo = new int[N];

        for (int i = 0; i < N; i++) {
            arreglo[i] = Integer.parseInt(lineas.get(i + 1));
        }

        int contadorIf = 0;
        int intercambios = 0;

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i + 1; j--) {
                contadorIf++;

                if (arreglo[i] < arreglo[j - 1]) {
                    int aux = arreglo[i];
                    arreglo[i] = arreglo[j - 1];
                    arreglo[j - 1] = aux;
                    intercambios++;
                }
            }
        }

        System.out.println("Valor de N: " + N);
        System.out.println("Contenido del contador: " + contadorIf);
        System.out.println("Cantidad de intercambios: " + intercambios);
        System.out.println("Primer elemento del arreglo resultante: " + arreglo[0]);
        System.out.println("Ultimo elemento del arreglo resultante: " + arreglo[N - 1]);

    }


}
