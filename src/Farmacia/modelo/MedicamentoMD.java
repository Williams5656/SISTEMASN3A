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
public class MedicamentoMD {
    private String codigoM;
    private String nombreM;
    private String cantidadM;
    private String precio_unitario;

    public MedicamentoMD() {
    }

    public MedicamentoMD(String codigoM, String nombreM, String cantidadM, String precio_unitario) {
        this.codigoM = codigoM;
        this.nombreM = nombreM;
        this.cantidadM = cantidadM;
        this.precio_unitario = precio_unitario;
    }

    public String getCodigoM() {
        return codigoM;
    }

    public void setCodigoM(String codigoM) {
        this.codigoM = codigoM;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getCantidadM() {
        return cantidadM;
    }

    public void setCantidadM(String cantidadM) {
        this.cantidadM = cantidadM;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
   
}
