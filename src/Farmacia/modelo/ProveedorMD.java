/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

/**
 *
 * @author A
 */
public class ProveedorMD {
    private String codigoP;
    private String nombreP;
    private String telefonoP;
    private String direccionP;

    public ProveedorMD() {
    }

    public ProveedorMD(String codigoP, String nombreP, String telefonoP, String direccionP) {
        this.codigoP = codigoP;
        this.nombreP = nombreP;
        this.telefonoP = telefonoP;
        this.direccionP = direccionP;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }
    
}
