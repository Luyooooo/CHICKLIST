
package Logica;

import java.time.LocalDate;
import java.util.List;


public abstract class Venta {
    private Cliente cliente;
    private List<Producto> productosVendidos;
    private LocalDate fecha;
    
    
    public abstract float calcularTotalVenta();
    public abstract void registrarVenta();

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
