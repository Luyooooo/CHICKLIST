
package Logica;

import java.util.ArrayList;
import java.util.List;


public abstract class Cliente {
    private String nombre;
    private String apellido;
    private int cedula;
    private List<Venta> historialCompras;
    private double saldoPendiente;
    
    public Cliente(String nombre,String apellido,int cedula){
        historialCompras = new ArrayList<Venta>();
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
    }
    
    public abstract void registrarCliente();
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
    
}
