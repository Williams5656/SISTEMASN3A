package ABG_System.modelo;

public class PersonaBD {

    String Cedula;
    String Nombres;
    String Apellidos;
    String Usuario;
    String Clave;
    String Telefono;
    String Direccion;
    String CorreoElectronico;
    String Rol;

    public PersonaBD(String Cedula, String Nombres, String Apellidos, String Usuario, String Contraseña, String Telefono, String Direccion, String CorreoElectronico, String Rol) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Usuario = Usuario;
        this.Clave = Contraseña;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.CorreoElectronico = CorreoElectronico;

        this.Rol = Rol;
    }

    public PersonaBD() {
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Teléfono) {
        this.Telefono = Teléfono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

}
