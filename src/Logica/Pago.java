
package Logica;

import java.time.LocalDate;


public abstract class Pago {
    private Cliente cliente;
    private double monto;
    private LocalDate fecha;
    
    //public boolean esPagoCompleto(){}
    //public String resumenPago(){}

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
