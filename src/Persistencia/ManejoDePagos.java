
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
    private static final String ARCHIVO_PAGOS = "archivosPersistencia\\pagos.txt";
    
    public static void registrarPago(Pago pago) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_PAGOS, true)))) {
            out.println(pago.getCliente().getCedula() + "," +
                        pago.getMonto() + "," +
                        pago.getFecha());
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
    
    
    public static List<Pago> cargarPagos(List<Cliente> clientes) {
        List<Pago> pagos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ARCHIVO_PAGOS))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 3) {
                    int cedula = Integer.parseInt(datos[0]);
                    double monto = Double.parseDouble(datos[1]);
                    LocalDate fecha = LocalDate.ofEpochDay(Long.parseLong(datos[2]));//xddddddddddddddddddddddd

                    Cliente cliente = buscarClientePorCedula(clientes, cedula);
                    if (cliente != null) {
                        Pago pago = new Pago(cliente, monto);
                        pagos.add(pago);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer pagos: " + e.getMessage());
        }
        return pagos;
    }
    
    
}
