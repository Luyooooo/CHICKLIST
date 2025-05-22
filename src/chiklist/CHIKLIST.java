
package chiklist;

import Logica.Cliente;
import Persistencia.ManejoDeClientes;
import Persistencia.ManejoDeProductos;
import java.time.LocalDate;
import Persistencia.ManejoDeUsuario;

public class CHIKLIST {

    
    public static void main(String[] args) {
        /*//ola
        LocalDate fecha=LocalDate.now();
        System.out.println(fecha);*/
        Cliente c1=new Cliente("david", "alvarez", 11021032);
        ManejoDeClientes c=new ManejoDeClientes();
        c.registrarCliente(c1);
    }
    
}
