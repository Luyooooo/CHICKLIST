
package chicklist;
import Persistencia.ManejoDeInventario;
import java.time.LocalDate;
import Persistencia.ManejoDeUsuario;

public class CHICKLIST {

    
    public static void main(String[] args) {
        /*//ola
        LocalDate fecha=LocalDate.now();
        System.out.println(fecha);*/
        ManejoDeUsuario u=new ManejoDeUsuario();
        u.registrarUsuario("pepito", "pepito34", "1234");
        ManejoDeInventario i=new ManejoDeInventario();
        i.registrarProducto("pepito34", "botella de agua", 700, 5);
    }
    
}
