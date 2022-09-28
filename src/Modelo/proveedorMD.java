/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author VICO5
 */
public class proveedorMD {
    
    String codigo;
    String laboratorio;
    String ruc;
    String telefono;
    String encargado;
    String paginaweb;
    String direccion;
    String correo;

    public proveedorMD(String codigo, String laboratorio, String ruc, String telefono, String encargado, String paginaweb, String direccion, String correo) {
        this.codigo = codigo;
        this.laboratorio = laboratorio;
        this.ruc = ruc;
        this.telefono = telefono;
        this.encargado = encargado;
        this.paginaweb = paginaweb;
        this.direccion = direccion;
        this.correo = correo;
    }

    public proveedorMD() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    
          
}
