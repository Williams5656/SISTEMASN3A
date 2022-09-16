
package Papeleria_Bella.modelo;


public class ProveedoresMD {
    String codigo;
    String ruc;
    String nombrecom;
    String representanteleg;
    String celular;

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

    public String getNombrecom() {
        return nombrecom;
    }

    public void setNombrecom(String nombrecom) {
        this.nombrecom = nombrecom;
    }

    public String getRepresentanteleg() {
        return representanteleg;
    }

    public void setRepresentanteleg(String representanteleg) {
        this.representanteleg = representanteleg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ProveedoresMD() {
    }

    public ProveedoresMD(String codigo, String ruc, String nombrecom, String representanteleg, String celular) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.nombrecom = nombrecom;
        this.representanteleg = representanteleg;
        this.celular = celular;
    }
    
    
}
