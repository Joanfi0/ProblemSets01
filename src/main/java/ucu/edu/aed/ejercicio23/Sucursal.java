package ucu.edu.aed.ejercicio23;

public class Sucursal {
    private String ubicacion;

    public String getUbicacion() {return ubicacion;}

    public Sucursal(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }
}