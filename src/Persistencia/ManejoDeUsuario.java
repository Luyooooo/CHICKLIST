
package Persistencia;

import Logica.Dueño;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ManejoDeUsuario {
    
    
    private static final String ARCHIVO_USUARIOS = "archivosPersistencia\\usuarios.txt"; // Nombre del archivo
    private static final String DIRECTORIO_INVENTARIOS="archivosPersistencia\\inventarios\\";
    
    
    
    // Método para verificar si un usuario ya existe
    private static boolean usuarioExiste(String usuario) {
        try (Scanner scanner = new Scanner(new File(ARCHIVO_USUARIOS))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 3 && datos[1].equals(usuario)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // No hay archivo aún, lo tratamos como usuario no existente
        }
        return false;
    }

    // Método para registrar un nuevo usuario
    public static void registrarUsuario(Dueño dueño) {
        if (usuarioExiste(dueño.getUsuario())) {
            //JOptionPane.showMessageDialog(null,"Error: El usuario '" + dueño.getUsuario() + "' ya está registrado." );
            //System.out.println("Error: El usuario '" + usuario + "' ya está registrado.");
            return; // No se registra el usuario
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true)))) {
            pw.println(dueño.getNombre() + "," + dueño.getUsuario() + "," + dueño.getContraseña());
            //JOptionPane.showMessageDialog(null, "usuario registrado exitosamente");
            //System.out.println("Usuario registrado exitosamente.");

            // Crear el archivo de inventario para el nuevo usuario
            crearArchivoInventario(dueño.getUsuario());

        } catch (IOException e) {
            //JOptionPane.showMessageDialog(null, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            //System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para autenticar un usuario
    public static boolean autenticarUsuario(String usuario, String contraseña) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(ARCHIVO_USUARIOS)))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                if (campos.length == 3 && campos[1].equals(usuario) && campos[2].equals(contraseña)) {
                    return true; // Usuario y contraseña coinciden
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al autenticar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            //System.err.println("Error al autenticar usuario: " + e.getMessage());
        }
        return false; // No se encontró el usuario o la contraseña es incorrecta
    }

    private static void crearArchivoInventario(String nombreUsuario) {
        // Asegurarse de que el directorio de inventarios exista
        File directorio = new File(DIRECTORIO_INVENTARIOS);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crea el directorio si no existe
        }

        String nombreArchivo = DIRECTORIO_INVENTARIOS + "inventario_" + nombreUsuario + ".txt";
        File archivoInventario = new File(nombreArchivo);

        try {
            if (archivoInventario.createNewFile()) {
                //JOptionPane.showMessageDialog(null, "Archivo de inventario creado para: " + nombreUsuario);
                //System.out.println("Archivo de inventario creado para: " + nombreUsuario);
            } else {
                //JOptionPane.showMessageDialog(null,"El archivo de inventario para " + nombreUsuario + " ya existía." );
                //System.out.println("El archivo de inventario para " + nombreUsuario + " ya existía.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de inventario para " + nombreUsuario + ": " + e.getMessage());
        }
    }

}
