
package Persistencia;

import Logica.Cliente;
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


public class ManejoDeClientes {
    
    private static final String ARCHIVO_CLIENTES = "archivosPersistencia\\clientes\\"; // Nombre del archivo
    //private static final String DIRECTORIO_INFORMACION="archivosPersistencia\\informacionClientes\\";
    
    
    // Método para verificar si un usuario ya existe
    public static boolean clienteExiste(int cedula,String nombreUsuario) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(ARCHIVO_CLIENTES+ "clientes_" + nombreUsuario + ".txt")))){
             while (sc.hasNextLine()) {                
                String[] datos=sc.nextLine().split(",");
                 if (datos.length==3 && Integer.parseInt(datos[2])==cedula) {
                     return true;
                 }
            }
        } catch (IOException e) {
            // Si hay un error al leer el archivo, asumimos que no existe el cliente
            return false;
        }
        return false; // No se encontró el usuario
    }
    
    // Método para registrar un nuevo cliente
    public static void registrarCliente(Cliente cliente, String usuario) {
        if (clienteExiste(cliente.getCedula(),usuario)) {
            return; // No se registra el cliente
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES+ "clientes_" + usuario + ".txt", true)))){// true para append(agregarlo)
            pw.println(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCedula());

            // Crear el archivo de datos para el nuevo cliente
            //crearArchivoDatos(cliente.getCedula());

        } catch (IOException e) {
            //ver despues XD System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }
    
    public static List<Cliente> cargarClientes(String usuario) {
        List<Cliente> clientes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ARCHIVO_CLIENTES+ "clientes_" + usuario + ".txt"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    int cedula = Integer.parseInt(datos[2]);
                    clientes.add(new Cliente(nombre, apellido, cedula));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer los clientes: " + e.getMessage());
        }
        return clientes;
    }
    
    /*private static void crearArchivoDatos(int cedula) {
        File directorio = new File(DIRECTORIO_INFORMACION);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String nombreArchivo = DIRECTORIO_INFORMACION + "inventario_" + cedula + ".txt";
        File archivoInventario = new File(nombreArchivo);
        try {
            if (archivoInventario.createNewFile()) {
                //System.out.println("Archivo creado: " + archivoInventario.getName());
            } else {
                //System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            //System.err.println("Error al crear el archivo del cliente: " + e.getMessage());
        }
    }*/
    
}
