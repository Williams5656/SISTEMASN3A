package modelo;

public class UsuarioMD {

    int codigo;
    String usuario;
    String clave;

    public UsuarioMD() {
    }

    public UsuarioMD(int codigo, String usuario, String clave) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
