
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


public class ManejoDeClientes {
    
    private static final String ARCHIVO_CLIENTES = "archivosPersistencia\\clientes.txt"; // Nombre del archivo
    private static final String DIRECTORIO_INFORMACION="archivosPersistencia\\informacionClientes\\";
    
    
    // Método para verificar si un usuario ya existe
    private static boolean clienteExiste(int cedula) {
        try (FileReader fr = new FileReader(ARCHIVO_CLIENTES);
             BufferedReader br = new BufferedReader(fr);
             Scanner scanner = new Scanner(br)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");
                if (campos.length == 3 && campos[2].equals(String.valueOf(cedula))) {
                    return true; // El cliente ya existe
                }
            }
        } catch (IOException e) {
            // Si hay un error al leer el archivo, asumimos que no existe el cliente
            return false;
        }
        return false; // No se encontró el usuario
    }
    
    // Método para registrar un nuevo usuario
    public static void registrarUsuario(String nombre, String apellido, int cedula) {
        if (clienteExiste(cedula)) {
            return; // No se registra el cliente
        }
        try (FileWriter fw = new FileWriter(ARCHIVO_CLIENTES, true); // true para append(agregarlo)
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(nombre + "," + apellido + "," + cedula);//guarda los datos del cliente

            // Crear el archivo de datos para el nuevo cliente
            //crearArchivoDatos(cedula);

        } catch (IOException e) {
            //ver despues XD System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }
    
    private static void crearArchivoInventario(int cedula) {
        // Asegurarse de que el directorio de inventarios exista
        File directorio = new File(DIRECTORIO_INFORMACION);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crea el directorio si no existe
        }

        String nombreArchivo = DIRECTORIO_INFORMACION + "inventario_" + cedula + ".txt";
        File archivoInventario = new File(nombreArchivo);

        /*try {
            if (archivoInventario.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo de inventario creado para: " + cedula);
                //System.out.println("Archivo de inventario creado para: " + nombreUsuario);
            } else {
                JOptionPane.showMessageDialog(null,"El archivo de inventario para " + cedula + " ya existía." );
                //System.out.println("El archivo de inventario para " + nombreUsuario + " ya existía.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de inventario para " + cedula + ": " + e.getMessage());
        }*/
    }
    
}
