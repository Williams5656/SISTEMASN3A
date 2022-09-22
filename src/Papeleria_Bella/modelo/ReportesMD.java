

package Papeleria_Bella.modelo;


public class ReportesMD {
    String codigo;
    String nombreprod;
    String cantidadprod;
    int ingreso;
    int egreso;

    public ReportesMD() {
    }

    public ReportesMD(String codigo, String nombreprod, String cantidadprod, int ingreso, int egreso) {
        this.codigo = codigo;
        this.nombreprod = nombreprod;
        this.cantidadprod = cantidadprod;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getCantidadprod() {
        return cantidadprod;
    }

    public void setCantidadprod(String cantidadprod) {
        this.cantidadprod = cantidadprod;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getEgreso() {
        return egreso;
    }

    public void setEgreso(int egreso) {
        this.egreso = egreso;
    }
    
            
}
