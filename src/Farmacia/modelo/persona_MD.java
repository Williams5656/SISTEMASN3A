/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import java.awt.Image;

/**
 *
 * @author VICO5
 */
public class persona_MD {
    private String cedula;
    private String nombre_apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String fecha_nacimiento;
    private String buscar;
    private Image foto;

    public persona_MD() {
    }

    public persona_MD(String cedula, String nombre_apellido, String direccion, String telefono, String correo, String fecha_nacimiento, String buscar, Image foto) {
        this.cedula = cedula;
        this.nombre_apellido = nombre_apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.buscar = buscar;
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

   
    
    
       
    
}
