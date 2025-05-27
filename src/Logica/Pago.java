
package Logica;

import java.time.LocalDate;


public class Pago {
    private Cliente cliente;
    private double monto;
    private LocalDate fecha;
    
    public Pago(Cliente cliente, double monto){
        this.cliente = cliente;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.cliente.pagar(monto); // Actualiza el saldo pendiente del cliente
    }
    
    public boolean esPagoCompleto(Venta venta){
        return monto >= venta.getTotal();
    }
    
    public String resumenPago(){
        return "Pago de $" + monto + "por " + cliente.getNombre() + "el " + fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    
    
}
