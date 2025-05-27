
package Logica;

import Persistencia.ManejoDeUsuario;


public class Dueño {
    private final String nombre; //Pequeña modificación: Le quite el static y lo volvi final si lo que se quiere es no cambiar el nombre del dueño. Si al final lo vamos a hacer entonces quitamos el final y descomentamos el setter.
    private String usuario;
    private String contraseña;

    public Dueño(String nombre, String usuario, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    
    
    //public String toString(){}
    /*public abstract void administrarInventario();
    public abstract void administrarVentas();
    public abstract void hacerSeguimientoDePagos();
    public abstract void generarReporte();
    public abstract void gestionarClientes();*/
    
    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }


    /*public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    
    
}
