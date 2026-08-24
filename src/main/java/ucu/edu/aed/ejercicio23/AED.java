package ucu.edu.aed.ejercicio23;

import ucu.edu.aed.implementaciones.ListaEnlazada;
import ucu.edu.aed.utils.FileUtils;

public class AED {

    ListaEnlazada<Sucursal> listaEnlazadaSucursales =
            new ListaEnlazada<>();

    public void cargarSucursales() {
        FileUtils.leerLineas("recursos-ejercicio-23/sucursales.txt", linea -> {
            Sucursal unaSucursal = new Sucursal(linea);
            listaEnlazadaSucursales.agregar(unaSucursal);
        });
    }

    public void agregarSucursal(String ubicacion) {
        Sucursal unaSucursal = new Sucursal(ubicacion);
        listaEnlazadaSucursales.agregar(unaSucursal);
    }

    public Sucursal buscarSucursal(String ubicacion) {
        return listaEnlazadaSucursales.buscar(
                sucursal -> sucursal.getUbicacion().equals(ubicacion)
        );
    }

    public void quitarSucursal(String ubicacion) {
        Sucursal sucursal = buscarSucursal(ubicacion);

        if (sucursal != null) {
            listaEnlazadaSucursales.remover(sucursal);
        }
    }

    public void listarSucursales() {
        for (int i = 0; i < listaEnlazadaSucursales.tamaño(); i++) {
            System.out.println(listaEnlazadaSucursales.obtener(i));
        }
    }

    public void imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaEnlazadaSucursales.tamaño(); i++) {
            sb.append(listaEnlazadaSucursales.obtener(i).getUbicacion()).append(separador).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public int cantidadSucursales() {
        return listaEnlazadaSucursales.tamaño();
    }

    public boolean estaVacia() {
        return listaEnlazadaSucursales.esVacio();
    }

    public static void main(String[] args) {
        AED empresa = new AED();

        // Cambio de ruta del txt para que apunte a suc1.txt
        empresa.cargarSucursales();
        System.out.println("Hay un total de: " + empresa.cantidadSucursales() + " sucursales");
        // Salida: 107

        /*
        empresa.quitarSucursal("Chicago");
        empresa.listarSucursales();
        */
        // Salida: Shenzhen, es la ciudad que le sigue a Hong Kong

        // Cambio de ruta del txt para que apunte a suc2.txt
        /*
        empresa.cargarSucursales();
        empresa.quitarSucursal("Shenzhen");
        empresa.quitarSucursal("Tokio");
        System.out.println(empresa.estaVacia());
        System.out.println("Cantidad: " + empresa.cantidadSucursales());
        */
        // Salida: vacía, ya que estaVacia: true, cantidad: 0. y esta sin error de ejecución

        // Cambio de ruta del txt para que apunte a suc3.txt
        /*
        empresa.cargarSucursales();
        empresa.imprimir(";");
        */
        // Salida: Montreal; Caracas; Tulsa; Mobile; Vancouver;

    }
}