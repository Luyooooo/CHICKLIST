
package Logica;

import Persistencia.ManejoDeClientes;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private String nombre;
    private String apellido;
    private final int cedula;  //se lo volvi final porque la cedula no debería modificarse. Pues si algo le quita el final y descomenta el setter.
    private List<Venta> historialCompras;
    private double saldoPendiente;
    
    public Cliente(String nombre,String apellido,int cedula){
        historialCompras = new ArrayList<>();
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.saldoPendiente = 0.0; //inicialicemos el saldo. Y pues lo incrementamos dependiendo si debe o no.
    }
    
    public void agregarVenta(Venta venta){
         historialCompras.add(venta);
        if (!venta.isPagada()) {
            saldoPendiente += venta.getTotal();
        }
    }
    
    public void pagar(double monto){
        saldoPendiente -= monto;
        if (saldoPendiente<0) {
            saldoPendiente=0;
        }
    }
    
    public void aplicarPago(double monto) {
        if (monto <= saldoPendiente) {
            saldoPendiente -= monto;
        } else {
            saldoPendiente = 0; // no puede ser negativo
        }
    }
    
    @Override
    public String toString(){
        return nombre + " " + apellido + "\n(Cedula: " + cedula + ")";
    }
    //public void actualizarSaldo(double montoPagado){}
    //public String toString(){}
    

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

    public List<Venta> getHistorialCompras() {
        return historialCompras;
    }
    
    
    
    
    
    
}
