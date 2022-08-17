
package V93Controlador;

import static V93Controlador.CRol.VistaR;
import V93Modelo.RolBD;
import V93Modelo.RolMb;
import V93Vista.VistaRol;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
public class CRol {
     public static VistaRol VistaR;

    private RolBD bdrol = new RolBD();
    
     public CRol(VistaRol VistaR) {
        this.VistaR = VistaR;
        VistaR.setVisible(true);
        VistaR.setLocationRelativeTo(null);
        lista();
        VistaR.getBtnGuardarRol().addActionListener(x -> guardar());
        VistaR.getBtnModificarRol().addActionListener(e -> modificar());
        VistaR.getTableRol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        VistaR.getBtnGuardarRol().setEnabled(false);
        VistaR.getBtnModificarRol().setEnabled(false);
        VistaR.getBtnNuevoRol().addActionListener(e -> nuevo());
        VistaR.getBtnEliminarRol().addActionListener(e -> eliminar());
    }
     
      public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTableRol().getModel();
        List<RolMb> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaR.getTableRol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaR.getTableRol().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaR.getTableRol().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaR.getTableRol().setValueAt(lista.get(i).getDescripcion(), i, 2);
           
        }
    }
       public void guardar() {
        bdrol.setCodigo(VistaR.getTxtCodigoRol().getText());
        bdrol.setNombre(VistaR.getTxtNombreRol().getText());
        bdrol.setDescripcion(VistaR.getTxtDesceipcionRol().getText());
       
      
        if (bdrol.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdrol.setNombre(VistaR.getTxtNombreRol().getText());
        bdrol.setDescripcion(VistaR.getTxtDesceipcionRol().getText());
        
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdrol.modificar(VistaR.getTxtCodigoRol().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                lista();
                nuevo();
            }

        }

    }

    public void seleccionar() {
        VistaR.getBtnGuardarRol().setEnabled(false);
        VistaR.getBtnModificarRol().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTableRol().getModel();
        String codigo = (String) modelo.getValueAt(VistaR.getTableRol().getSelectedRow(), 0);
        List<RolMb> lista = bdrol.obtenerdatos(codigo);
        bdrol.setCodigo(lista.get(0).getCodigo());
        VistaR.getTxtCodigoRol().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        VistaR.getTxtNombreRol().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        VistaR.getTxtDesceipcionRol().setText(bdrol.getDescripcion());
       

    }

    public void eliminar() {
        bdrol.setCodigo(VistaR.getTxtCodigoRol().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar este Rol");
        if (rest == 0) {
            if (bdrol.eliminar(VistaR.getTxtCodigoRol().getText())) {
                JOptionPane.showMessageDialog(null, "Rol Eliminado");
                lista();
            }

        }

    }

    public void nuevo() {
        VistaR.getTxtCodigoRol().setText("");
        VistaR.getTxtNombreRol().setText("");
        VistaR.getTxtDesceipcionRol().setText("");
        VistaR.getBtnGuardarRol().setEnabled(true);
        VistaR.getBtnModificarRol().setEnabled(true);
    }
      
      
    
}
