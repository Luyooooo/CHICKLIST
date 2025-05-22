
package Persistencia;

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
    
    // metodo editarPrecio
    public static void editarPrecioProducto(String nombreUsuario, int codigoProducto, double nuevoPrecio) {
        //Construir la ruta al archivo de inventario del usuario específico.
        String nombreArchivoInventario = DIRECTORIO_INVENTARIOS + "inventario_" + nombreUsuario + ".txt";
        // Crear un objeto File para representar el archivo de inventario.
        File archivoInventario = new File(nombreArchivoInventario);
        //Crear una lista para almacenar las líneas modificadas del archivo.
        List<String> lineasModificadas = new ArrayList<>();
        //Una bandera para indicar si se encontró el producto a editar.
        boolean productoEncontrado = false;

        //verificar si el archivo de inventario del usuario existe.
        if (archivoInventarioExiste(nombreUsuario)==false) {
            //Si el archivo no existe, mostrar un mensaje de error y salir del método.
            JOptionPane.showMessageDialog(null, "Error: El archivo de inventario para el usuario " + nombreUsuario + " no existe.");
            return;
        }

        //Intentar leer el archivo de inventario.
        try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario))) {
            String linea;
            // Leer el archivo línea por línea.
            while ((linea = br.readLine()) != null) {
                // Dividir cada línea en campos usando la coma como delimitador.
                String[] campos = linea.split(",");
                // Verificar si la línea tiene al menos 4 campos (nombre, código, precio, cantidad).
                if (campos.length == 4) {
                    try {
                        // Intentar convertir el segundo campo (índice 1) a un entero para obtener el código del producto del archivo.
                        int codigoArchivo = Integer.parseInt(campos[1].trim());
                        // Comparar el código del producto del archivo con el código del producto que se quiere editar.
                        if (codigoArchivo == codigoProducto) {
                            // Si los códigos coinciden, actualizar el precio del producto (asumiendo que está en el tercer campo, índice 2).
                            campos[2] = String.valueOf(nuevoPrecio);
                            //Unir los campos modificados de nuevo en una línea separada por comas y agregarla a la lista de líneas modificadas.
                            lineasModificadas.add(String.join(",", campos));
                            // Establecer la bandera de producto encontrado a true.
                            productoEncontrado = true;
                        } else {
                            // Si el código no coincide, agregar la línea original a la lista de líneas modificadas sin cambios.
                            lineasModificadas.add(linea);
                        }
                    } catch (NumberFormatException e) {
                        // Si el segundo campo no es un número válido, mantener la línea original sin cambios (podría ser un error en el formato del archivo).
                        lineasModificadas.add(linea);
                    }
                } else {
                    // Si la línea no tiene el formato esperado (4 campos), mantener la línea original sin cambios.
                    lineasModificadas.add(linea);
                }
            }
        } catch (IOException e) {
            // Si ocurre un error al leer el archivo, mostrar un mensaje de error y salir del método.
            JOptionPane.showMessageDialog(null, "Error al leer el inventario: " + e.getMessage());
            return;
        }

        //Después de leer el archivo, verificar si se encontró el producto a editar.
        if (productoEncontrado) {
            // Intentar escribir las líneas modificadas de vuelta al archivo (sobrescribiendo el contenido anterior).
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivoInventario))) {
                // Iterar sobre la lista de líneas modificadas y escribir cada línea en el archivo.
                for (String lineaModificadaEach : lineasModificadas) {
                    pw.println(lineaModificadaEach);
                }
                //Mostrar un mensaje de éxito indicando que el precio del producto fue actualizado.
                JOptionPane.showMessageDialog(null, "Precio del producto con código " + codigoProducto + " actualizado a " + nuevoPrecio);
            } catch (IOException e) {
                // Si ocurre un error al escribir en el archivo, mostrar un mensaje de error.
                JOptionPane.showMessageDialog(null, "Error al escribir en el inventario: " + e.getMessage());
            }
        } else {
            // Si no se encontró el producto con el código especificado, mostrar un mensaje indicando que no se encontró.
            JOptionPane.showMessageDialog(null, "No se encontró el producto con código " + codigoProducto + " en el inventario de " + nombreUsuario);
        }
    }
    
    public static void editarNombre(String nombreUsuario,int codigoProducto,String nuevoNombreProducto){
        String nombreArchivoInventario = DIRECTORIO_INVENTARIOS + "inventario_" + nombreUsuario + ".txt";
        File archivoInventario = new File(nombreArchivoInventario);
        List<String> lineasModificadas = new ArrayList<>();
        boolean productoEncontrado = false;
        
        if (archivoInventarioExiste(nombreUsuario)==false) {
            JOptionPane.showMessageDialog(null, "Error: El archivo de inventario para el usuario " + nombreUsuario + " no existe.");
            return;
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(archivoInventario))) {
            String linea;
            while ((linea=br.readLine()) != null) {                
                String[] campos = linea.split(",");
                if (campos.length==4) {
                    try {
                        int codigoArchivo=Integer.parseInt(campos[1].trim());
                        if (codigoArchivo==codigoProducto) {
                            campos[0]=nuevoNombreProducto;
                            lineasModificadas.add(String.join(",", campos));
                            productoEncontrado=true;
                        } else{
                            lineasModificadas.add(linea);
                        }
                    }catch (NumberFormatException e) {
                        lineasModificadas.add(linea);
                    }
                } else{
                    lineasModificadas.add(linea);
                }
                
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el inventario: " + e.getMessage());
            return;
        }
        if (productoEncontrado) {
            try(PrintWriter pw = new PrintWriter(new FileWriter(archivoInventario))) {
                for (String lineasModificadaEach : lineasModificadas) {
                    pw.println(lineasModificadaEach);
                }
                JOptionPane.showMessageDialog(null, "Nombre del producto con código " + codigoProducto + " actualizado a " + nuevoNombreProducto);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el inventario: " + e.getMessage());
            }
        } else{
            JOptionPane.showMessageDialog(null, "No se encontró el producto con código " + codigoProducto + " en el inventario de " + nombreUsuario);
        }
        
    }
    
    public static void actualizarCantidad(String nombreUsuario,int codigoProducto,int nuevaCantidad){
        String nombreArchivoInventario = DIRECTORIO_INVENTARIOS + "inventario_" + nombreUsuario + ".txt";
        File archivoInventario = new File(nombreArchivoInventario);
        List<String> lineasModificadas = new ArrayList<>();
        boolean productoEncontrado = false;

        if (!archivoInventarioExiste(nombreUsuario)) { //El "!" antes de eso es para que el netbeans lo lea como si el archivo no existiera. Si no nos tocaria hacer el else y ahi si poner el mensaje creeria yo.
            JOptionPane.showMessageDialog(null, "Error: El archivo de inventario para el usuario " + nombreUsuario + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 4) {
                    try {
                        int codigoArchivo = Integer.parseInt(campos[1].trim());
                        if (codigoArchivo == codigoProducto) {
                            campos[3] = String.valueOf(nuevaCantidad);
                            lineasModificadas.add(String.join(",", campos));
                            productoEncontrado = true;
                        } else {
                            lineasModificadas.add(linea);
                        }
                    } catch (NumberFormatException e) {
                        lineasModificadas.add(linea); //mantener la linea original sin cambios
                    }
                } else {
                    lineasModificadas.add(linea); // Mantener la linea original sin cambios
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el inventario: " + e.getMessage());
            return;
        }

        if (productoEncontrado) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivoInventario))) {
                for (String lineaModificada : lineasModificadas) {
                    pw.println(lineaModificada);
                }
                JOptionPane.showMessageDialog(null, "Cantidad del producto con código " + codigoProducto + " actualizada a " + nuevaCantidad);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el inventario: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con código " + codigoProducto + " en el inventario de " + nombreUsuario);
        }
    }

    public static void eliminarProducto(String nombreUsuario,int codigoProducto){
        String nombreArchivoInventario = DIRECTORIO_INVENTARIOS + "inventario_" + nombreUsuario + ".txt";
        File archivoInventario = new File(nombreArchivoInventario);
        List<String> lineasRestantes = new ArrayList<>();
        boolean productoEncontrado = false;

        if (archivoInventarioExiste(nombreUsuario)==false) {
            JOptionPane.showMessageDialog(null, "Error: El archivo de inventario para el usuario " + nombreUsuario + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 4) {
                    try {
                        int codigoArchivo = Integer.parseInt(campos[1].trim());
                        if (codigoArchivo == codigoProducto) {
                            productoEncontrado = true;//no se añade a las lineas restantes
                        } else {
                            lineasRestantes.add(linea); // Agregar solo los productos que no se eliminan
                        }
                    } catch (NumberFormatException e) {
                        lineasRestantes.add(linea); 
                    }
                } else {
                    lineasRestantes.add(linea); 
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el inventario: " + e.getMessage());
            return;
        }

        if (productoEncontrado) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivoInventario))) {
                for (String lineaRestante : lineasRestantes) {
                    pw.println(lineaRestante);
                }
                JOptionPane.showMessageDialog(null, "Producto con código " + codigoProducto + " eliminado del inventario de " + nombreUsuario);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el inventario: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con código " + codigoProducto + " en el inventario de " + nombreUsuario);
        }
    }
    
    
    
    
    
}
