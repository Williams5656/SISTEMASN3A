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
    int codigo;
    String nombrep;
    String presentacion;
    String lab;
    String cantidad;
    String pvp;
    String fechai;
    String fechasal;
    String desc;
    Image foto;

    public productoMD() {
    }

    public productoMD(int codigo, String nombrep, String presentacion, String lab, String cantidad, String pvp, String fechai, String fechasal, String desc, Image foto) {
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.presentacion = presentacion;
        this.lab = lab;
        this.cantidad = cantidad;
        this.pvp = pvp;
        this.fechai = fechai;
        this.fechasal = fechasal;
        this.desc = desc;
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPvp() {
        return pvp;
    }

    public void setPvp(String pvp) {
        this.pvp = pvp;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechasal() {
        return fechasal;
    }

    public void setFechasal(String fechasal) {
        this.fechasal = fechasal;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
}