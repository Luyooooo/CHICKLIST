
package Logica;


public abstract class ReporteDiario {
    private double ventasTotales;
    private double totalVendido;
    private double totalPagado;
    private double totalPendiente;
    
    public abstract void generarReporte();

    public double getVentasTotales() {
        return ventasTotales;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public double getTotalPendiente() {
        return totalPendiente;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public void setTotalPendiente(double totalPendiente) {
        this.totalPendiente = totalPendiente;
    }
    
    
}
