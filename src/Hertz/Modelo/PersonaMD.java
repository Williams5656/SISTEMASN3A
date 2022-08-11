
package Hertz.Modelo;

import java.util.Date;

public class PersonaMD {
    
    String cedula;
    String nombre;
    String direccion;
    String celular;
    String email;
    String fechaNac;

    public PersonaMD() {
    }

    public PersonaMD(String cedula, String nombre, String direccion, String celular, String email, String fechanac) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.fechaNac = fechanac;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
}
