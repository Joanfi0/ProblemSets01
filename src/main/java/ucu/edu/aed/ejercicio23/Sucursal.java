package ucu.edu.aed.ejercicio23;

public class Sucursal {
    private String ubicacion;

    public String getUbicacion() {return ubicacion;}

    public Sucursal(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Sucursal -" + ubicacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sucursal sucursal = (Sucursal) obj;
        return ubicacion.equals(sucursal.ubicacion);
    }
}