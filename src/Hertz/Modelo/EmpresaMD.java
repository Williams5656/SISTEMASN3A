/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hertz.Modelo;

import java.awt.Image;


/**
 *
 * @author ESTEBAN
 */
public class EmpresaMD {
    
    String nombre;
    String ruc;
    String ciudad;
    String direccion;
    String email;
    String celular;
    String estado;
    String buscar;
    Image foto;

    public EmpresaMD() {
    }

    public EmpresaMD(String nombre,String ruc, String ciudad, String direccion, String email, String celular, String estado, String buscar, Image foto) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.estado = estado;
        this.buscar = buscar;
        this.foto = foto;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
