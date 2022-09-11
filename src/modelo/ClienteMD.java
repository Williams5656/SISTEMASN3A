package modelo;

public class ClienteMD {

    String Codigo;
    String Cedula;
    String Estado;

    public ClienteMD() {
    }

    public ClienteMD(String Codigo, String Cedula, String Nombres, String Telefono, String Estado) {
        this.Codigo = Codigo;
        this.Cedula = Cedula;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

 
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
