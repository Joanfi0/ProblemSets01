package ucu.edu.aed.Ejercicio29;

public class Convocado {

    private Jugador jugador;
    private TipoConvocacion tipo;

    public Convocado(Jugador jugador, TipoConvocacion tipo) {
        this.jugador = jugador;
        this.tipo = tipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public TipoConvocacion getTipo() {
        return tipo;
    }

    public boolean esPendiente() {
        return tipo == TipoConvocacion.PENDIENTE;
    }

    @Override
    public String toString() {
        return jugador + " - " + tipo;
    }
}