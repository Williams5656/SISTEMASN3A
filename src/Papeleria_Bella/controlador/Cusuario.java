 
package Papeleria_Bella.controlador;
import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Cusuario {
    public static Vusuario vista;
            
    private UsuarioBD busuario = new UsuarioBD();
    
    public Cusuario(Vusuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        lista();
        vista.getButtonguardar().addActionListener(e -> guardar());
        vista.getButtonguardar().setEnabled(true); 
    }
       
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablausuario().getModel();
        List<UsuarioMD> lista = busuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablausuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablausuario().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablausuario().setValueAt(lista.get(i).getUsuario(), i, 1);
            vista.getTablausuario().setValueAt(lista.get(i).getContraseña(), i, 2);
            vista.getTablausuario().setValueAt(lista.get(i).getRol(), i, 3);
            vista.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 4);

        }
    }
    
    public void guardar() {
        busuario.setCodigo(vista.getTxtcodigo().getText());
        busuario.setUsuario(vista.getTxtusuario().getText());
        busuario.setContraseña(vista.getFieldcontraseña().getText());
        busuario.setRol(vista.getComborol().getSelectedItem().toString());
        busuario.setEstado(vista.getComboestado().getSelectedItem().toString());

        if (busuario.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
}
