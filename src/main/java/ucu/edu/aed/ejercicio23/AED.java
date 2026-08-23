package ucu.edu.aed.ejercicio23;
import ucu.edu.aed.tda.implementaciones.ListaEnlazada;
import ucu.edu.aed.utils.FileUtils;


public class AED {

    ListaEnlazada<Sucursal> listaEnlazadaSucursales = new ListaEnlazada<Sucursal>();
    public void cargarSucursales(){
        FileUtils.leerLineas("recursos-ejercicio-23/suc2.txt", linea ->{
            Sucursal unaSucursal = new Sucursal(linea);
            listaEnlazadaSucursales.agregar(unaSucursal);
            System.out.println(unaSucursal);
        });
    }


    public static void main(String[] args) {
        AED empresa = new AED();

        empresa.cargarSucursales();
        /*
        Sucursal sucursalAEliminar = empresa.listaSucursales.buscar(sucursal -> sucursal.getUbicacion().equals("Shenzen"));
        Sucursal otraSucursalAEliminar = empresa.listaSucursales.buscar(sucursal -> sucursal.getUbicacion().equals("Tokio"));
        empresa.listaSucursales.remover(sucursalAEliminar);
        empresa.listaSucursales.remover(otraSucursalAEliminar);
         */
        System.out.println("Hay un total de: " + empresa.listaEnlazadaSucursales.tamaño() + " sucursales");


    }




}