 package V93Modelo;

public class UsuarioMb {

    private String codigo;
    private String cedula;
    private String nombre_usuario;
    private String clave;
    private String codigo_rol;
    private String estado;
    private String correo;

    public UsuarioMb() {
    }
               
    public UsuarioMb(String codigo, String cedula, String nombre_usuario, String clave, String codigo_rol, String estado, String correo) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.codigo_rol = codigo_rol;
        this.estado = estado;
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
