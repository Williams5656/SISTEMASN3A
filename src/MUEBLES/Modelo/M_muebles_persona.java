package MUEBLES.Modelo;

public class M_muebles_persona {
    
    String cedula;
    String nombre;
    String apellido;
    String direccion;
    String celular;
    String nacionalidad;
    String fechana;

    public M_muebles_persona(String cedula, String nombre, String apellido, String direccion, String celular, String nacionalidad, String fechana) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.nacionalidad = nacionalidad;
        this.fechana = fechana;
    }

    public M_muebles_persona() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechana() {
        return fechana;
    }

    public void setFechana(String fechana) {
        this.fechana = fechana;
    }
    
    
}
