
package chicklist;


public abstract class Dueño {
    private String nombre;
    private String usuario;
    private String contraseña;
    private ManejoDeUsuario manejoDeU;

    public Dueño(String nombre, String usuario, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.manejoDeU=new ManejoDeUsuario();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public ManejoDeUsuario getManejoDeU() {
        return manejoDeU;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setManejoDeU(ManejoDeUsuario manejoDeU) {
        this.manejoDeU = manejoDeU;
    }
    
    //registrar el dueño
    public void registrarDueño(String nombre,String usuario,String contraseña){
        manejoDeU.registrarUsuario(nombre, usuario, contraseña);
    }
    
    //autenticar los datos del dueño para iniciar sesion
    public void autenticarDueño(String usuario,String contraseña){
        manejoDeU.autenticarUsuario(usuario, contraseña);
    }
    
    public abstract void administrarInventario();
    public abstract void generarReporte();
    public abstract void gestionarClientes();
    
    
    
}
