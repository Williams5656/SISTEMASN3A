
package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Cpersona {
    public static Vpersona vista;
    
    private PersonaBD bpersona = new PersonaBD();
    
    public Cpersona(Vpersona vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        lista();
        vista.getButtonguardar().addActionListener(e -> guardar());
        vista.getButtonguardar().setEnabled(true);
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablapersona().getModel();
        List<PersonaMD> lista = bpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablapersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 1);
            vista.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 2);
            vista.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTablapersona().setValueAt(lista.get(i).getDireccion(), i, 4);
            vista.getTablapersona().setValueAt(lista.get(i).getEmail(), i, 5);
            vista.getTablapersona().setValueAt(lista.get(i).getRol(), i, 6);

        }
    }
    
    public void guardar() {
        bpersona.setCedula(vista.getTxtcedula().getText());
        bpersona.setNombres(vista.getTxtnombres().getText());
        bpersona.setApellidos(vista.getTxtapellidos().getText());
        bpersona.setTelefono(vista.getTxttelefono().getText());
        bpersona.setDireccion(vista.getTxtdireccion().getText());
        bpersona.setEmail(vista.getTxtemail().getText());
        bpersona.setRol(vista.getComborol().getSelectedItem().toString());
        if (bpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
}
