
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
