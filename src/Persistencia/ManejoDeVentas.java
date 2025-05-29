
package Persistencia;

import Logica.Cliente;
import Logica.Producto;
import Logica.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejoDeVentas {
    private static final String ARCHIVO_VENTAS = "archivosPersistencia\\ventas\\";
    
    public static void guardarVenta(Venta venta,String usuario) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_VENTAS+ "ventas_" + usuario + ".txt", true)))) {
            StringBuilder productosStr = new StringBuilder();
            for (Producto p : venta.getProductosVendidos()) {
                productosStr.append(p.getNombre()).append(":")
                        .append(p.getCodigoProducto()).append(":")
                        .append(p.getPrecio()).append(":")
                        .append(p.getCantidad()).append("|");
            }
            out.println(venta.getCliente().getCedula() + "," +
                        venta.getFecha() + "," +
                        venta.getTotal() + "," +
                        venta.isPagada() + "," +
                        productosStr.toString());
        } catch (IOException e) {
            System.err.println("Error al guardar la venta: " + e.getMessage());
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
    
     public static List<Venta> cargarVentas(List<Cliente> clientes,String usuario) {
        List<Venta> ventas = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ARCHIVO_VENTAS+ "ventas_" + usuario + ".txt"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",", 5);
                if (datos.length == 5) {
                    int cedula = Integer.parseInt(datos[0]);
                    String fecha = String.valueOf(datos[1]);//para no perderme xdddddddd
                    double total = Double.parseDouble(datos[2]);
                    boolean pagada = Boolean.parseBoolean(datos[3]);
                    String productosStr = datos[4];

                    Cliente cliente = buscarClientePorCedula(clientes, cedula);
                    if (cliente != null) {
                        List<Producto> productos = new ArrayList<>();
                        for (String prodInfo : productosStr.split("\\|")) {
                            if (prodInfo.isEmpty()) continue;
                            String[] partes = prodInfo.split(":");
                            String nombre = partes[0];
                            int codigo = Integer.parseInt(partes[1]);
                            double precio = Double.parseDouble(partes[2]);
                            int cantidad = Integer.parseInt(partes[3]);
                            productos.add(new Producto(nombre,codigo, precio, cantidad));
                        }

                        Venta venta = new Venta(cliente, productos);
                        if (pagada) {
                        venta.marcarComoPagada();
                        }

                        // actualizar saldo si no está pagada
                        cliente.agregarVenta(venta);

                        ventas.add(venta);                    
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer ventas: " + e.getMessage());
        }
        return ventas;
    }
    
    

}
