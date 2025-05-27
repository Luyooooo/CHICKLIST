
package Logica;

import java.util.List;
import java.util.ArrayList;


public class Inventario {
    private List<Producto> productos;
    
    public Inventario(){
        this.productos = new ArrayList<>();
    }
    
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
    
    
    public void agregarProducto(Producto producto) {
        Producto producto1 = buscarProducto(producto.getNombre());
        if (producto1 == null) {
            productos.add(producto);
        } else {
            producto1.aumentarCantidad(producto.getCantidad());
        }
    }
    
    public boolean eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            productos.remove(producto);
            return true;
        }
        return false;
    }
    
    public boolean actualizarCantidad(String nombre, int cantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(cantidad);
            return true;
        }
        return false;
    }
    
    public String mostrarInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Inventario ===").append("\n");
        for (Producto p : productos) {
            sb.append(p);
        }
        return sb.toString();
    }
    

    public List<Producto> getProductos() {
        return productos;
    }
    
    
}
