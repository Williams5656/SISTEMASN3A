package MUEBLES.Modelo;


public class M_usuario_MD {
    
    String codigo;
    String cedula_persona;
    String usuario;
    String contraseña;
    String codigo_rol;
    String estado;

    public M_usuario_MD() {
    }

    public M_usuario_MD(String codigo, String cedula_persona, String usuario, String contraseña, String codigo_rol, String estado) {
        this.codigo = codigo;
        this.cedula_persona = cedula_persona;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigo_rol = codigo_rol;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
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

    public String getCodigo_rol() {
        return codigo_rol;
    }

    public void setCodigo_rol(String codigo_rol) {
        this.codigo_rol = codigo_rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
