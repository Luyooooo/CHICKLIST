
package Logica;

import java.time.LocalDate;


public abstract class Pago {
    private Cliente cliente;
    private double monto;
    private LocalDate fecha;
    
    public abstract void actualizarPago();
}
