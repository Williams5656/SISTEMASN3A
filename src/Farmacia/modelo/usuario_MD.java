/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

/**
 *
 * @author VICO5
 */
public class usuario_MD {
    private String cedulau;
    private String nombreu;
    private String contraseña;
    private String correou;
    private String rol;

    public String getCedulau() {
        return cedulau;
    }

    public void setCedulau(String cedulau) {
        this.cedulau = cedulau;
    }

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreou() {
        return correou;
    }

    public void setCorreou(String correou) {
        this.correou = correou;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public usuario_MD() {
    }

    public usuario_MD(String cedulau, String nombreu, String contraseña, String correou, String rol) {
        this.cedulau = cedulau;
        this.nombreu = nombreu;
        this.contraseña = contraseña;
        this.correou = correou;
        this.rol = rol;
    }

}