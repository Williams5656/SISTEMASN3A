/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import java.awt.Image;

/**
 *
 * @author A
 */
public class Usuario_PersonaMD {
    private String cedula;
    private String nombres;
    private String fechaNacimiento;
    private String rol;
    private String nombreU;
    private String clave;
    private String estado;
    private Image foto;

    public Usuario_PersonaMD() {
    }

    public Usuario_PersonaMD(String cedula, String nombres, String fechaNacimiento, String rol, String nombreU, String clave, String estado,Image foto) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.nombreU = nombreU;
        this.clave = clave;
        this.estado = estado;
        this.foto = foto;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
