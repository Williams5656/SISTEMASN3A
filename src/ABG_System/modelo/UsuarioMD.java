package ABG_System.modelo;

public class UsuarioMD {

    String Usuario;
    String Clave;

    public UsuarioMD() {
    }

    public UsuarioMD(String Usuario, String Clave) {
        this.Usuario = Usuario;
        this.Clave = Clave;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}
