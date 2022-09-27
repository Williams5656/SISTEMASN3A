
package V93Modelo;

import java.awt.Image;

public class EmpresaMb {
    
    private String   ruc;
    private String  nombre;
    private String  actividad;
    private String  direccion;
    private String  ciudad;
    private String  celular;
    private String  correo;
    private String  estado; 
    private Image   foto;

    public EmpresaMb(String ruc, String nombre, String actividad, String direccion, String ciudad, String celular, String correo, String estado, Image foto) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.actividad = actividad;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
        this.foto = foto;
    }

    public EmpresaMb() {
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    
    
    
    
    
}
