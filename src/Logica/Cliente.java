
package Logica;

import Persistencia.ManejoDeClientes;
import java.util.ArrayList;
import java.util.List;


public abstract class Cliente {
    private String nombre;
    private String apellido;
    private final int cedula; //se lo volvi final porque la cedula no debería modificarse. Pues si algo le quita el final y descomenta el setter. 
    private List<Venta> historialCompras;
    private double saldoPendiente;
    
    public Cliente(String nombre,String apellido,int cedula){
        historialCompras = new ArrayList<Venta>();
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.saldoPendiente = 0.0; //inicialicemos el saldo. Y pues lo incrementamos dependiendo si debe o no.
    }
    
    //public void agregarVenta(Venta venta){}
    //public void actualizarSaldo(double montoPagado){}
    //public String toString(){}
    
    public void registrarCliente(){
        ManejoDeClientes.registrarCliente(nombre, apellido, cedula);
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }
    
    
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

    /*public void setCedula(int cedula) { 
        this.cedula = cedula;
    }*/
    
    
    
    
}
