package modelo;

public class ClienteMD {

    String Codigo;
    String Cedula;
    String Estado;
    String trabajo;
    String profesion;

    public ClienteMD() {
    }

    public ClienteMD(String Codigo, String Cedula, String Estado, String trabajo, String profesion) {
        this.Codigo = Codigo;
        this.Cedula = Cedula;
        this.Estado = Estado;
        this.trabajo = trabajo;
        this.profesion = profesion;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
