
package Logica;

import Persistencia.ManejoDeUsuario;


public abstract class Dueño {
    private static String nombre;
    private String usuario;
    private String contraseña;

    public Dueño(String nombre, String usuario, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //registrar el dueño
    public void registrarDueño(){
        ManejoDeUsuario.registrarUsuario(nombre, usuario, contraseña);
    }
    
    //autenticar los datos del dueño para iniciar sesion
    public boolean autenticarDueño(){
        return ManejoDeUsuario.autenticarUsuario(usuario, contraseña);
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
