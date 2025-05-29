
package Persistencia;

import Logica.Cliente;
import Logica.Pago;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejoDePagos {
    private static final String ARCHIVO_PAGOS = "archivosPersistencia\\pagos\\";
    
    public static void registrarPago(Pago pago,String usuario) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_PAGOS+ "pagos_" + usuario + ".txt", true)))) {
            out.println(pago.getCliente().getCedula() + "," +
                        pago.getFecha() + "," +
                        pago.getMonto());
        } catch (IOException e) {
            System.err.println("Error al guardar el pago: " + e.getMessage());
        }
    }
    
    private static Cliente buscarClientePorCedula(List<Cliente> clientes, int cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                return c;
            }
        }
        return null;
    }
    
    
    public static List<Pago> cargarPagos(List<Cliente> clientes,String usuario) {
        List<Pago> pagos = new ArrayList<>();
        File archivo = new File(ARCHIVO_PAGOS+"pagos_" + usuario + ".txt");

        if (!archivo.exists()) {
            //System.out.println("No se encontraron pagos para el usuario " + usuario);
            return pagos;
        }

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (linea.isEmpty()) continue;

                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int cedula = Integer.parseInt(datos[0]);
                    String fecha = datos[1];
                    double monto = Double.parseDouble(datos[2]);

                    Cliente cliente = buscarClientePorCedula(clientes, cedula);
                    if (cliente != null) {
                        // ✅ Aplica el pago directamente al cliente
                        cliente.aplicarPago(monto);

                        // Crea el objeto pago y lo agrega a la lista
                        pagos.add(new Pago(cliente, monto));
                    } else {
                        System.err.println("Cliente con cédula " + cedula + " no encontrado al cargar pago.");
                    }
                } else {
                    System.err.println("Línea de pago mal formada: " + linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer pagos: " + e.getMessage());
        }

        return pagos;
    }
    
    
}
