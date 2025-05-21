
package Logica;

import java.util.List;
import Persistencia.ManejoDeInventario;


public abstract class Inventario {
    private Dueño dueño;
    private List<Producto> productos;
    
    public void añadirProducto(Producto producto){
        ManejoDeInventario.registrarProducto(dueño.getNombre(), producto.getNombre(), producto.getCodigoProducto(), producto.getPrecio(), producto.getCantidad());
    }
    
    public void editarNombreProducto(Producto producto,String nuevoNombre){
        ManejoDeInventario.editarNombre(dueño.getNombre(), producto.getCodigoProducto(), nuevoNombre);
    }
    
    public void editarPrecioProducto(Producto producto,double nuevoPrecio){
        ManejoDeInventario.editarPrecioProducto(dueño.getNombre(), producto.getCodigoProducto(), nuevoPrecio);
    }
    public void eliminarProducto(Producto producto){
        ManejoDeInventario.eliminarProducto(dueño.getNombre(), producto.getCodigoProducto());
    }
    public void actualizarUnidades(Producto producto, int unidades){
        ManejoDeInventario.actualizarCantidad(dueño.getNombre(), producto.getCodigoProducto(), unidades);
    }
    
    //public void buscarProducto(){}
    //public void mostrarInventario(){}

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
}
