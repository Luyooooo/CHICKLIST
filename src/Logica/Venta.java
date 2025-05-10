
package Logica;

import java.time.LocalDate;
import java.util.List;


public abstract class Venta {
    private Cliente cliente;
    private List<Producto> productosVendidos;
    private LocalDate fecha;
    
    public abstract float calcularTotalVenta();
    public abstract void registrarVenta();
}
