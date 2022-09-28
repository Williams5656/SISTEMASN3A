package Papeleria_Bella.modelo;

public class ClientesMD {

    String codigo;
    String cedula;
    String nombres;
    String celular;
    String estado;
    String discapacidad;
    String porcentaje_discapacidad;

    public ClientesMD() {
    }

    public ClientesMD(String codigo, String cedula, String nombres, String celular, String estado, String discapacidad, String porcentaje_discapacidad) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.celular = celular;
        this.estado = estado;
        this.discapacidad = discapacidad;
        this.porcentaje_discapacidad = porcentaje_discapacidad;
    }

 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPorcentaje_discapacidad() {
        return porcentaje_discapacidad;
    }

    public void setPorcentaje_discapacidad(String porcentaje_discapacidad) {
        this.porcentaje_discapacidad = porcentaje_discapacidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

}
