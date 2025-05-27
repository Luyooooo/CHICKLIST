
package Persistencia;

import Logica.Pago;
import Logica.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


public class ManejoDeReportes {
    private static final String DIRECTORIO_REPORTES = "archivosPersistencia\\reportes\\";
    
    public static void generarReporteDiario(List<Venta> ventas, List<Pago> pagos,String usuario) {
        double totalVentas = 0, totalPagado = 0, totalPendiente = 0;
        for (Venta v : ventas) {
            totalVentas += v.getTotal();
            if (!v.isPagada()) {
                totalPendiente += v.getTotal();
            }
        }
        for (Pago p : pagos) {
            totalPagado += p.getMonto();
        }

        String nombreArchivo = DIRECTORIO_REPORTES + "reporte_"+ usuario + LocalDate.now() + ".txt";

        File directorio = new File(DIRECTORIO_REPORTES);
        if (!directorio.exists()) directorio.mkdirs();

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo)))) {
            out.println("=== Reporte Diario ===");
            out.println("Fecha: " + LocalDate.now());
            out.println("Total de ventas: $" + totalVentas);
            out.println("Total pagado: $" + totalPagado);
            out.println("Total pendiente: $" + totalPendiente);
        } catch (IOException e) {
            System.err.println("Error al generar el reporte: " + e.getMessage());
        }
    }
    
    
}
