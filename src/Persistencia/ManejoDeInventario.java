
package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ManejoDeInventario {
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
    public static void registrarProducto(String nombreUsuario,String nombreProducto,int codigoProducto,double precio,int cantidad){
        if (archivoInventarioExiste(nombreUsuario)==false) {
            JOptionPane.showMessageDialog(null, "Error: No existe este usuario");
            return;//no se registrara el producto
        }
        if (productoExiste(nombreUsuario,codigoProducto)) {
            JOptionPane.showMessageDialog(null, "Error: Ya existe un producto con el codigo " + codigoProducto);
            return;//no se registra el producto
        }
        try (FileWriter fw = new FileWriter(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt", true); // true para append(agregarlo)
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(nombreProducto + "," + codigoProducto + "," + precio + "," + cantidad);
            JOptionPane.showMessageDialog(null, "producto ingresado exitosamente");
            //System.out.println("Producto ingresado exitosamente");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto: " + e.getMessage());
            //System.err.println("Error al registrar producto: " + e.getMessage());
        }
    }
    
    public static boolean archivoInventarioExiste(String nombreUsuario){
        File archivoInventario = new File(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt");
        //true si el archivo existe y false si no existe
        return archivoInventario.exists();
    }
    
    //metodo editarPrecio
    //metodo editarNombre
    //metodo acualizarCantidad
    //metodo eliminarProducto
    
    
    
    
    
}
