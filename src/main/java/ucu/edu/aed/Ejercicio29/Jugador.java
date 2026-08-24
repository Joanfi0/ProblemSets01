package ucu.edu.aed.Ejercicio29;

public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private Division division;
    private int partidasJugadas;
    private EstadoJugador estado;

    public Jugador(String nombre,
                   Division division,
                   int partidasJugadas,
                   EstadoJugador estado) {

        this.nombre = nombre;
        this.division = division;
        this.partidasJugadas = partidasJugadas;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public Division getDivision() {
        return division;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public EstadoJugador getEstado() {
        return estado;
    }

    public boolean estaHabilitado() {
        return estado == EstadoJugador.HABILITADO;
    }

    @Override
    public int compareTo(Jugador otro) {

        // Primero los habilitados.
        if (this.estaHabilitado() && !otro.estaHabilitado()) {
            return -1;
        }

        if (!this.estaHabilitado() && otro.estaHabilitado()) {
            return 1;
        }

        // Mayor división primero.
        int comparacionDivision =
                Integer.compare(
                        otro.division.getNivel(),
                        this.division.getNivel()
                );

        if (comparacionDivision != 0) {
            return comparacionDivision;
        }

        if (this.estaHabilitado() && otro.estaHabilitado()) {

            int comparacionPartidas =
                    Integer.compare(
                            this.partidasJugadas,
                            otro.partidasJugadas
                    );

            if (comparacionPartidas != 0) {
                return comparacionPartidas;
            }
        }

        /*
         * Si también empatan, compareTo devuelve 0.
         */
        return 0;
    }

    @Override
    public String toString() {
        return nombre
                + " - "
                + division
                + " - "
                + partidasJugadas
                + " partidas - "
                + estado;
    }
}