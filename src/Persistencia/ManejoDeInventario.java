
package Persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ManejoDeInventario {
    private static final String DIRECTORIO_INVENTARIOS="archivosPersistencia\\inventarios\\";
    
    public static void registrarProducto(String nombreUsuario,String nombreProducto,double precio,int cantidad){
        try (FileWriter fw = new FileWriter(DIRECTORIO_INVENTARIOS+ "inventario_" + nombreUsuario + ".txt", true); // true para append(agregarlo)
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(nombreProducto + "," + precio + "," + cantidad);
            System.out.println("Producto ingresado exitosamente");

        } catch (IOException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }
}
