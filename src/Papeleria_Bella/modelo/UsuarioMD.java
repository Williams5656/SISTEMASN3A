 
package Papeleria_Bella.modelo;


public class UsuarioMD {
    String codigo;
    String usuario;
    String contraseña;
    String rol;
    String estado;

    public UsuarioMD(String codigo, String usuario, String contraseña, String rol, String estado) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estado = estado;
    }
    
    public UsuarioMD() {
    }

    public String getCodigo() {
        return codigo;
    }  

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
