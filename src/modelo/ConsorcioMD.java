package modelo;

public class ConsorcioMD {

    String codigo;
    String nombre;
    String tipo;
    String riesgo;

    public ConsorcioMD(String codigo, String nombre, String tipo, String riesgo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.riesgo = riesgo;
    }

    public ConsorcioMD() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

}
