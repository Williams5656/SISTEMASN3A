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
public class ServiciosMD {
    
    String codigo;
    String nombre;
    String descripcion;
    String actividad;
    String recursos;
    String precio;
    String buscar;
    Image foto;

    public ServiciosMD() {
    }

    public ServiciosMD(String codigo, String nombre, String descripcion, String actividad, String recursos, String precio, String buscar, Image foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;
        this.recursos = recursos;
        this.precio = precio;
        this.buscar = buscar;
        this.foto = foto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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

