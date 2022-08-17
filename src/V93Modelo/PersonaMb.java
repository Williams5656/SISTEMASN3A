package V93Modelo;

import java.awt.Image;

public class PersonaMb {

    private String cedula;
    private String nombre;
    private String direccion;
    private String fecha_nacimiento;
    private String ciudad;
    private String celular;
    private Image foto;
      
         
    public PersonaMb(String cedula, String nombre, String direccion, String fecha_nacimiento, String ciudad, String celular, Image foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciudad = ciudad;
        this.celular = celular;
        this.foto = foto;
    }

    public PersonaMb() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    

}
