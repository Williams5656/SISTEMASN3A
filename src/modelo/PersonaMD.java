package modelo;

import java.awt.*;

public class PersonaMD {

    int codigo;
    String cedula;
    String nombres;
    String apellidos;
    String usuario;
    String clave;
    String telefono;
    String correo;
    String rol;
    private Image foto_perfil;

    public PersonaMD() {
    }

    public PersonaMD(String cedula, String nombres, String apellidos, String usuario, String clave, String telefono, String correo, String rol, Image foto_perfil) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.telefono = telefono;
        this.correo = correo;
        this.rol = rol;
        this.foto_perfil = foto_perfil;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Image getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(Image foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

}
