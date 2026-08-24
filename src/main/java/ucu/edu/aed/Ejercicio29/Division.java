package ucu.edu.aed.Ejercicio29;

public enum Division {

    BRONCE(1),
    PLATA(2),
    ORO(3),
    PLATINO(4),
    DIAMANTE(5);

    private final int nivel;

    Division(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}