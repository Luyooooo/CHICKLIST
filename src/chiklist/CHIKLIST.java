
package chiklist;

import Persistencia.ManejoDeProductos;
import Logica.Cliente;
import Logica.Producto;
import Persistencia.ManejoDeClientes;
import Persistencia.ManejoDeProductos;
import java.time.LocalDate;
import Persistencia.ManejoDeUsuario;
import java.util.List;

public class CHIKLIST {

    
    public static void main(String[] args) {
        /*//ola
        LocalDate fecha=LocalDate.now();
        System.out.println(fecha);*/
        Cliente c1=new Cliente("david", "alvarez", 11021032);
        ManejoDeClientes c=new ManejoDeClientes();
        c.registrarCliente(c1,"pepito34");
        List<Producto> productos=ManejoDeProductos.cargarProductos("pepito34");
        System.out.println(productos);
        
        
    }
    
}
