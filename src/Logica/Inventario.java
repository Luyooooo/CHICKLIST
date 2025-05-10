
package Logica;

import java.util.List;


public abstract class Inventario {
    private List<Producto> productos;
    
    public abstract void añadirProducto(Producto producto);
    public abstract void editarProducto(Producto producto);
    public abstract void eliminarProducto(Producto producto);
    public abstract void actualizarUnidades(Producto producto, int unidades);
}
