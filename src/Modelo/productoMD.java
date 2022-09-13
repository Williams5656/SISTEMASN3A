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
public class productoMD {
    String id_producto;
    String nombre_pro;
    String descripcion_pro;
    Image foto;

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getDescripcion_pro() {
        return descripcion_pro;
    }

    public void setDescripcion_pro(String descripcion_pro) {
        this.descripcion_pro = descripcion_pro;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public productoMD(String id_producto, String nombre_pro, String descripcion_pro, Image foto) {
        this.id_producto = id_producto;
        this.nombre_pro = nombre_pro;
        this.descripcion_pro = descripcion_pro;
        this.foto = foto;
    }

    public productoMD() {
    }
    
    
    
}
