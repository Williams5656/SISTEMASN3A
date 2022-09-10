
package V93Controlador;

import V93Vista.VistaVentas;
import java.awt.event.MouseAdapter;
import V93Modelo.ClienteBD;
import V93Modelo.ClienteMb;
import V93Modelo.FacturaBD;
import V93Modelo.FacturaMb;
import V93Modelo.PersonaBD;
import V93Modelo.PersonaMb;
import V93Vista.VistaCliente;
import V93Vista.VistaPersona;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CVentas {
    
    FacturaMb v = new FacturaMb();
    FacturaBD Vdao = new FacturaBD();
    DefaultTableModel modelo = new DefaultTableModel();
    
     public static VistaVentas VistaVent;
     
      public CVentas(VistaVentas VistaVent) {
        this.VistaVent = VistaVent;
        VistaVent.setVisible(true);
        VistaVent.setLocationRelativeTo(null);
//        lista();
//        VistaVent.getBtnGuardarCliente().addActionListener(x -> guardar());
//        VistaVent.getBtnModificarCliente().addActionListener(e -> modificar());
//        VistaVent.getBtnBuscarCliente().addActionListener(e -> buscar());
        // VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaVent.getTableVentas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                seleccionar();
            }

        });

//        VistaC.getBtnNuevoCliente().addActionListener(e -> nuevo());
//        VistaC.getBtnEliminarCliente().addActionListener(e -> eliminar());
//        VistaC.getBtnGuardarCliente().setEnabled(false);
//        VistaC.getBtnModificarCliente().setEnabled(false);
    }
        public void ListarVentas() {
        List<FacturaMb> ListarVenta = Vdao.ListarVentas();
        modelo = (DefaultTableModel) VistaVent.getTableVentas().getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarVenta.size(); i++) {
            ob[0] = ListarVenta.get(i).getId();
            ob[1] = ListarVenta.get(i).getCliente();
            ob[2] = ListarVenta.get(i).getVendedor();
            ob[3] = ListarVenta.get(i).getTotal();
            modelo.addRow(ob);

        }
        VistaVent.getTableVentas().setModel(modelo);

    }
    
}
