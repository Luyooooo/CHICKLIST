
package Logica;

import java.time.LocalDate;
import java.util.List;


public class ReporteDiario {
    private List<Venta> ventasDelDia;
    private List<Pago> pagosDelDia;
    private LocalDate fecha;
    
    public ReporteDiario(List<Venta> ventasDelDia, List<Pago> pagosDelDia) {
        this.ventasDelDia = ventasDelDia;
        this.pagosDelDia = pagosDelDia;
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
        return total;
    }

    public double totalPendiente() {
        double totalPendiente = 0.0;
        for (Venta v : ventasDelDia) {
            if (!v.isPagada()) {
                totalPendiente += v.getTotal();
            }
        }
        return totalPendiente;
    }

    public String generarResumenTexto() {
        return "=== Reporte Diario ===\n" +
               "Fecha: " + fecha + "\n" +
               "Total de ventas: $" + totalVentas() + "\n" +
               "Total pagado: $" + totalPagado() + "\n" +
               "Total pendiente: $" + totalPendiente();
    }
    
    //public String generarReporte(){}

   
    
    
}
