package modelo;

public class ServicioMD {

    String codigo;
    String ced_Cliente;
    String tipo;
    String fecha;
    String Consultorio;
    String Estado;

    public ServicioMD() {
    }

    public ServicioMD(String codigo, String ced_Cliente, String tipo, String fecha, String Consultorio, String Estado) {
        this.codigo = codigo;
        this.ced_Cliente = ced_Cliente;
        this.tipo = tipo;
        this.fecha = fecha;
        this.Consultorio = Consultorio;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCed_Cliente() {
        return ced_Cliente;
    }

    public void setCed_Cliente(String ced_Cliente) {
        this.ced_Cliente = ced_Cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConsultorio() {
        return Consultorio;
    }

    public void setConsultorio(String Consultorio) {
        this.Consultorio = Consultorio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
