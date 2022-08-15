
package Hertz.Modelo;

public class UsuarioMD {
    
    String cedula;
    String usuario;
    String password;
    String rol;
    String estado;

    public UsuarioMD() {
    }

    public UsuarioMD(String cedula, String usuario, String password, String rol, String estado) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
