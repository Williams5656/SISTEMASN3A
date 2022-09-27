
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
import V93Vista.VistaVentas;
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
        listarVentas();
//        lista();
//        VistaVent.getBtnGuardarCliente().addActionListener(x -> guardar());
//        VistaVent.getBtnModificarCliente().addActionListener(e -> modificar());
//        VistaVent.getBtnBuscarCliente().addActionListener(e -> buscar());
        // VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        
        VistaVent.getTableVentas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableVentasMouseClicked(e);
            }
            
             

        });

//        VistaC.getBtnNuevoCliente().addActionListener(e -> nuevo());
//        VistaC.getBtnEliminarCliente().addActionListener(e -> eliminar());
//        VistaC.getBtnGuardarCliente().setEnabled(false);
//        VistaC.getBtnModificarCliente().setEnabled(false);
    }
      private void TableVentasMouseClicked(java.awt.event.MouseEvent evt) {                                         
                int fila = VistaVent.getTableVentas().rowAtPoint(evt.getPoint());
        VistaVent.getTxtIdVentas().setText(VistaVent.getTableVentas().getValueAt(fila, 0).toString());
    } 
       public void listarVentas() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaVent.getTableVentas().getModel();
        List<FacturaMb> lista = Vdao.ListarVentas();
        int columnas = modelo.getColumnCount();

        for (int j = VistaVent.getTableVentas().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaVent.getTableVentas().setValueAt(lista.get(i).getId(), i, 0);
            VistaVent.getTableVentas().setValueAt(lista.get(i).getCliente(), i, 1);
            VistaVent.getTableVentas().setValueAt(lista.get(i).getVendedor(), i, 2);
            VistaVent.getTableVentas().setValueAt(lista.get(i).getTotal(), i, 3);

        }
    }
    
}
