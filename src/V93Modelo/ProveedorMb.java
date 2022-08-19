
package V93Modelo;


public class ProveedorMb {
    
   private String ruc;
   private String nombre;
   private String celular;
   private String direccion;
   private String razon;

    public ProveedorMb(String ruc, String nombre, String celular, String direccion, String razon) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.razon = razon;
    }

    public ProveedorMb() {
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
   
   
    
}
