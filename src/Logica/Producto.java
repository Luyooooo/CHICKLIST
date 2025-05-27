
package Logica;


public class Producto {
    private int codigoProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre,int codigoProducto,double precio,int cantidad){
        this.nombre=nombre;
        this.codigoProducto=codigoProducto;
        this.precio=precio;
        this.cantidad=cantidad;
    }
    
    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }
    
    public boolean disminuirCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            return true;
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return nombre + " - Precio: $" + precio + " - Cantidad: " + cantidad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }
    
    
    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
