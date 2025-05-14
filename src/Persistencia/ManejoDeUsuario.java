
package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ManejoDeUsuario {
    
    
    private static final String ARCHIVO_USUARIOS = "archivosPersistencia\\usuarios.txt"; // Nombre del archivo
    private static final String DIRECTORIO_INVENTARIOS="archivosPersistencia\\inventarios\\";
    
    
    
    // Método para verificar si un usuario ya existe
    private static boolean usuarioExiste(String usuario) {
    try (FileReader fr = new FileReader(ARCHIVO_USUARIOS);
         BufferedReader br = new BufferedReader(fr);
         Scanner scanner = new Scanner(br)) {
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] campos = linea.split(",");
            if (campos.length == 3 && campos[1].equals(usuario)) {
                return true; // El usuario ya existe
            }
        }
    } catch (IOException e) {
        // Si hay un error al leer el archivo, asumimos que no existe el usuario
        return false;
    }
    return false; // No se encontró el usuario
}

// Método para registrar un nuevo usuario
    public static void registrarUsuario(String nombre, String usuario, String contraseña) {
        if (usuarioExiste(usuario)) {
            System.out.println("Error: El usuario '" + usuario + "' ya está registrado.");
            return; // No se registra el usuario
        }
        try (FileWriter fw = new FileWriter(ARCHIVO_USUARIOS, true); // true para append(agregarlo)
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(nombre + "," + usuario + "," + contraseña);
            System.out.println("Usuario registrado exitosamente.");

            // Crear el archivo de inventario para el nuevo usuario
            crearArchivoInventario(usuario);

        } catch (IOException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para autenticar un usuario
    public static boolean autenticarUsuario(String usuario, String contraseña) {
        try (FileReader fr = new FileReader(ARCHIVO_USUARIOS);
             BufferedReader br = new BufferedReader(fr);
             Scanner sc = new Scanner(br)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                if (campos.length == 3 && campos[1].equals(usuario) && campos[2].equals(contraseña)) {
                    return true; // Usuario y contraseña coinciden
                }
            }
        } catch (IOException e) {
            System.err.println("Error al autenticar usuario: " + e.getMessage());
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
                System.out.println("Archivo de inventario creado para: " + nombreUsuario);
            } else {
                System.out.println("El archivo de inventario para " + nombreUsuario + " ya existía.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de inventario para " + nombreUsuario + ": " + e.getMessage());
        }
    }

}
