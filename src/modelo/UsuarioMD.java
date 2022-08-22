package modelo;

public class UsuarioMD {

    String CodUsuario;
    String Cedula;
    String Usuario;
    String Clave;
    String Rol;
    String Estado;

    public UsuarioMD() {
    }

    public UsuarioMD(String CodUsuario, String Cedula, String Usuario, String Clave, String Rol, String Estado) {
        this.CodUsuario = CodUsuario;
        this.Cedula = Cedula;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Rol = Rol;
        this.Estado = Estado;
    }

    public String getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(String CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
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

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
