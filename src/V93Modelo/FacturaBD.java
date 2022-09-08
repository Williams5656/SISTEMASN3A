
package V93Modelo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;


public class FacturaBD extends FacturaMb {
    
     Conectar conecta = new Conectar();

    public FacturaBD(int id, int cod_pro, int cantidad, double precio, int id_venta) {
        super(id, cod_pro, cantidad, precio, id_venta);
    }

    public FacturaBD() {
    }
    
//      public FacturaBD BuscarPro(String cod){
//            ProductoMb producto = new  ProductoMb();
//            
//         String sql = "SELECT * FROM producto WHERE codigo = ?";
//         try{
//             //con = conecta.getConnection();
//              ResultSet rs = conecta.query(sql);
//             //rs = conecta.prepareStatement(sql);
//             //rs.set(1, cod);
//             //rs = ps.executeQuery();
//             
//             if (rs.next()){
//                 producto.setDescripcion(rs.getString("deescripcion"));
//                 producto.setPrecio(rs.getDouble("precio"));
//                 producto.setStock(rs.getInt("Stock"));
//                 
//             }
//         }catch (SQLException e){
//             System.out.println(e.toString());
//         }
//         
//        // return producto;
//     }
//     
     
    
}
