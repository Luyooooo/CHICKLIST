
package Logica;

import java.time.LocalDate;
import java.util.List;


public class ReporteDiario {
    private List<Venta> ventasDelDia;
    private List<Pago> pagosDelDia;
    private List<Cliente> clientes;
    private LocalDate fecha;
    
    public ReporteDiario(List<Venta> ventasDelDia, List<Pago> pagosDelDia, List<Cliente> clientes) {
        this.ventasDelDia = ventasDelDia;
        this.pagosDelDia = pagosDelDia;
        this.clientes=clientes;
        this.fecha = LocalDate.now();
    }

    public double totalVentas() {
        double total = 0.0;
        for (Venta v : ventasDelDia) {
            total += v.getTotal();
        }
        return total;
    }

    public double totalPagado() {
        double total = 0.0;
        for (Pago p : pagosDelDia) {
            total += p.getMonto();
        }
        // 2. Sumar ventas que ya estaban pagadas
        for (Venta v : ventasDelDia) {
            if (v.isPagada()) {
                total += v.getTotal();
            }
        }
        return total;
    }

    public double totalPendiente() {
        return clientes.stream()
                       .mapToDouble(Cliente::getSaldoPendiente)
                       .sum();
    }


    public String generarResumenTexto() {
        return "=== Reporte Diario ===\n" +
               "Fecha: " + fecha + "\n" +
               "Total de ventas: $" + totalVentas() + "\n" +
               "Total pagado: $" + totalPagado() + "\n" +
               "Total pendiente: $" + totalPendiente();
    }
    

   
    
    
}
