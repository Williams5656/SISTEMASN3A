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

    int codigo;
    String cedula;
    String nombre;
    String telefono;
    String alergias;
    String enfermedades;
    String direccion;

    public clienteMD() {
    }

    public clienteMD(int codigo, String cedula, String nombre, String telefono, String alergias, String enfermedades, String direccion) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.direccion = direccion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
