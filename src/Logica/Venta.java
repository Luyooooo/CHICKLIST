
package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Venta {
    private Cliente cliente;
    private List<Producto> productosVendidos;
    private LocalDate fecha;
    private boolean pagada;
    private double total;
    
    
    public Venta(Cliente cliente, List<Producto> productos){
        this.cliente = cliente;
        this.productosVendidos = new ArrayList<>(productos);
        this.fecha = LocalDate.now(); // Fecha actual
        this.total = calcularTotalVenta();
        this.pagada = false;
    }
    
    public float calcularTotalVenta(){
        double suma = 0.0;
        for (Producto p : productosVendidos) {
            suma += p.getPrecio() * p.getCantidad();
        }
        return (float) suma;
    }
    
    public String generarRecibo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Recibo - Fecha: ").append(fecha).append("\n");
        sb.append("Cliente: ").append(cliente.toString()).append("\n");
        sb.append("Productos:\n");
        for (Producto p : productosVendidos) {
            sb.append("- ").append(p.getNombre()).append(" x ").append(p.getCantidad()).append(" = $").append(p.getPrecio() * p.getCantidad()).append("\n");
        }
        sb.append("Total: $").append(total).append("\n");
        sb.append("Estado: ").append(pagada ? "Pagada" : "Pendiente").append("\n");
        return sb.toString();
    }
    
    public void marcarComoPagada(){
        this.pagada=true;
    }
    //public abstract void registrarVenta();

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isPagada() {
        return pagada;
    }

    public double getTotal() {
        double suma = 0.0;
        for (Producto p : productosVendidos) {
            suma += p.getPrecio() * p.getCantidad();
        }
        return (float) suma;
    }
    
    
    
    
    
}
