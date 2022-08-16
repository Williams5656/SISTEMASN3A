package MUEBLES.Modelo;

public class M_muebles_usuarioMD {
    
    String cedula;
    String nombre_u;
    String contraseña;
    String rol;
    String estado;

    public M_muebles_usuarioMD(String cedula, String nombre_u, String contraseña, String rol, String estado) {
        this.cedula = cedula;
        this.nombre_u = nombre_u;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estado = estado;
    }

    public M_muebles_usuarioMD() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
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
