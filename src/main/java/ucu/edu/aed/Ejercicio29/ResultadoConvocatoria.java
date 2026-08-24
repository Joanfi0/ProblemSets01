package ucu.edu.aed.Ejercicio29;
import ucu.edu.aed.implementaciones.tda.TDALista;

public class ResultadoConvocatoria {

    private TDALista<Convocado> convocados;
    private TDALista<Jugador> suplentes;
    private int deficit;

    public ResultadoConvocatoria(
            TDALista<Convocado> convocados,
            TDALista<Jugador> suplentes,
            int deficit) {

        this.convocados = convocados;
        this.suplentes = suplentes;
        this.deficit = deficit;
    }

    public TDALista<Convocado> getConvocados() {
        return convocados;
    }

    public TDALista<Jugador> getSuplentes() {
        return suplentes;
    }

    public int getDeficit() {
        return deficit;
    }

    public boolean hayDeficit() {
        return deficit > 0;
    }
}