/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author VICO5
 */
public class clienteMD {
    String cedula;
    String nombre_apellido;
    String descripcion_cli;
    Image foto;

    public clienteMD() {
    }

    public clienteMD(String cedula, String nombre_apellido, String descripcion_cli, Image foto) {
        this.cedula = cedula;
        this.nombre_apellido = nombre_apellido;
        this.descripcion_cli = descripcion_cli;
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

    public String getDescripcion_cli() {
        return descripcion_cli;
    }

    public void setDescripcion_cli(String descripcion_cli) {
        this.descripcion_cli = descripcion_cli;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    
}
