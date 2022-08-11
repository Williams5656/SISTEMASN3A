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
public class ClienteMD {
    private String codigoC;
    private String nombreC;
    private String apellidoC;
    private String telefonoC;
    private String direccionC;

    public ClienteMD(String codigoC, String nombreC, String apellidoC, String telefonoC, String direccionC) {
        this.codigoC = codigoC;
        this.nombreC = nombreC;
        this.apellidoC = apellidoC;
        this.telefonoC = telefonoC;
        this.direccionC = direccionC;
    }

    public ClienteMD() {
    }

    public String getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getApellidoC() {
        return apellidoC;
    }

    public void setApellidoC(String apellidoC) {
        this.apellidoC = apellidoC;
    }

    public String getTelefonoC() {
        return telefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        this.telefonoC = telefonoC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }
    
}
