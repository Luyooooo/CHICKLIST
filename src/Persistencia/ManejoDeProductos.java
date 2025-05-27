
package Persistencia;

import Logica.Dueño;
import Logica.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ManejoDeProductos {
    private static final String DIRECTORIO_INVENTARIOS="archivosPersistencia\\inventarios\\";
    
    // Método para verificar si un producto ya existe
    private static boolean productoExiste(String nombreUsuario,int codigo) {
        try (FileReader fr = new FileReader(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt");
            BufferedReader br = new BufferedReader(fr);
            Scanner scanner = new Scanner(br)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");
                int codigoArchivo=Integer.parseInt(campos[1].trim());//lo convierto a int para compararlo con el codigo
                if (campos.length == 4 && codigoArchivo==codigo ) {
                    return true; // El producto ya existe
                }
            }
        } catch (IOException e) {
            // Si hay un error al leer el archivo, asumimos que no existe el producto
            return false;
        }
        return false; // No se encontró el producto
    }
    
    //Metodo para registrar un nuevo producto 
    public static void guardarProducto(String nombreUsuario,Producto producto){
        /*if (archivoInventarioExiste(nombreUsuario)==false) {
            JOptionPane.showMessageDialog(null, "Error: No existe este usuario");
            return;//no se registrara el producto
        }*/
        if (productoExiste(nombreUsuario,producto.getCodigoProducto())) {
            JOptionPane.showMessageDialog(null, "Error: Ya existe un producto con el codigo " + producto.getCodigoProducto());
            return;//no se registra el producto
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt", true)))) {
            pw.println(producto.getNombre() + "," + producto.getCodigoProducto() + "," + producto.getPrecio() + "," + producto.getCantidad());
            JOptionPane.showMessageDialog(null, "producto ingresado exitosamente");
            //System.out.println("Producto ingresado exitosamente");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto: " + e.getMessage());
            //System.err.println("Error al registrar producto: " + e.getMessage());
        }
    }
    
    /*public static boolean archivoInventarioExiste(String nombreUsuario){
        File archivoInventario = new File(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt");
        //true si el archivo existe y false si no existe
        return archivoInventario.exists();
    }*/
    
    public static List<Producto> cargarProductos(String usuario) {
        List<Producto> productos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DIRECTORIO_INVENTARIOS+ "inventario_" + usuario + ".txt"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    int codigo = Integer.parseInt(datos[1]);
                    double precio = Double.parseDouble(datos[2]);
                    int cantidad = Integer.parseInt(datos[3]);
                    productos.add(new Producto(nombre,codigo, precio, cantidad));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer productos: " + e.getMessage());
        }
        return productos;
    }
    
    public static void sobrescribirProductos(String usuario,List<Producto> productos) {
        try (PrintWriter out = new PrintWriter(new FileWriter(DIRECTORIO_INVENTARIOS+ "inventario_" + usuario + ".txt"))) {
            for (Producto p : productos) {
                out.println(p.getNombre() + "," + p.getCodigoProducto() + "," + p.getPrecio() + "," + p.getCantidad());
            }
        } catch (IOException e) {
            System.err.println("Error al sobrescribir archivo de productos: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
}
