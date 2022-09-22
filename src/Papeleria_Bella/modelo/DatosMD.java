
package Papeleria_Bella.modelo;

import java.awt.Image;


public class DatosMD {
    String codigo;
    String ruc;
    String nombrec;
    String razons;
    String matrizp;
    String celular;
    String estado;
    String email;
     private Image foto;

    public DatosMD() {
    }

    public DatosMD(String codigo, String ruc, String nombrec, String razons, String matrizp, String celular, String estado, String email, Image foto) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.nombrec = nombrec;
        this.razons = razons;
        this.matrizp = matrizp;
        this.celular = celular;
        this.estado = estado;
        this.email = email;
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getRazons() {
        return razons;
    }

    public void setRazons(String razons) {
        this.razons = razons;
    }

    public String getMatrizp() {
        return matrizp;
    }

    public void setMatrizp(String matrizp) {
        this.matrizp = matrizp;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
