package ucu.edu.aed.Ejercicio27;

public class Cabina {
    private int cantidadPasajeros;
    private boolean vacía;

    public Cabina(){
        cantidadPasajeros = 0;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public boolean isVacía() {
        return vacía;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public void setVacía(boolean vacía) {
        this.vacía = vacía;
    }
}
