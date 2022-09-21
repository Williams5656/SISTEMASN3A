package modelo;

public class RegistroMD {

    String cedula_cliente;
    String n_juicio;
    String tipo_juicio;
    String Estado;

    public RegistroMD() {
    }

    public RegistroMD(String cedula_cliente, String n_juicio, String tipo_juicio, String Estado) {
        this.cedula_cliente = cedula_cliente;
        this.n_juicio = n_juicio;
        this.tipo_juicio = tipo_juicio;
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getN_juicio() {
        return n_juicio;
    }

    public void setN_juicio(String n_juicio) {
        this.n_juicio = n_juicio;
    }

    public String getTipo_juicio() {
        return tipo_juicio;
    }

    public void setTipo_juicio(String tipo_juicio) {
        this.tipo_juicio = tipo_juicio;
    }

}