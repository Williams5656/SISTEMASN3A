
package V93Modelo;


public class CotizacionBD extends CotizacionMD {
    Conectar cn = new Conectar();
    
        public boolean RegistrarCotizacion() {
       String sql = "INSERT INTO cotizacion(cliente, producto, cantidad, precio, total)  VALUES ('" + getCliente()+ "','" + getProducto()+ "','" + getCantidad()+ "','" + getPrecio()+ "','" + getTotal()+ "')";
  
        if (cn.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
}
