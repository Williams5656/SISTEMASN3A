package MUEBLES.Controlador;

import MUEBLES.Modelo.M_rolMD;
import MUEBLES.Modelo.Persona_BD_muebles;
import MUEBLES.Modelo.rol_BD;
import MUEBLES.Vista.Vista_rol;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Crol {
    
    public static Vista_rol vista;
    private rol_BD bdpersona= new rol_BD();
    
    public Crol(Vista_rol vista){
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablarol().getModel();
            List<M_rolMD> lista = bdpersona.obtenerdatos(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {

                //if (lista.get(i).getCedula().equals(vista.getTxtbuscar().getText())) {
                    modelo.addRow(new Object[columnas]);
                    vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
                    vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
                    vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
                    vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);

            }
        }
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        List<M_rolMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void guarda() {
        bdpersona.setCodigo(Integer.parseInt(vista.getTxtcodigo().getText()));
        String nombre = (String) vista.getCob_estado().getSelectedItem();
        bdpersona.setEstado(nombre);
        bdpersona.setDescripcion(vista.getTxtArea_descripcion().getText());
        String estado = (String) vista.getCobestado().getSelectedItem();
        bdpersona.setEstado(estado);
        

        if (bdpersona.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modifica() {
        String nombre = (String) vista.getCob_estado().getSelectedItem();
        bdpersona.setEstado(nombre);
        bdpersona.setDescripcion(vista.getTxtArea_descripcion().getText());
        String estado = (String) vista.getCobestado().getSelectedItem();
        bdpersona.setEstado(estado);

        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdpersona.modificar(vista.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                nuevo();
            }
        }
    }

    public void selecciona() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablarol().getSelectedRow(), 0);

        List<M_rolMD> lista = bdpersona.obtenerdatos(cedula);

        bdpersona.setCodigo(lista.get(0).getCodigo());
        vista.getTxtcodigo().setText(bdpersona.getCodigo());
        bdpersona.setNombre(lista.get(0).getNombre());
        vista.getCobnombre().setSelectedItem(bdpersona.getNombre());
        bdpersona.setDescripcion(lista.get(0).getDescripcion());
        vista.getTxtArea_descripcion().setText(bdpersona.getDescripcion());
        bdpersona.setEstado(lista.get(0).getEstado());
        vista.getCobestado().setSelectedItem(bdpersona.getEstado());

    }

    public void nuevo() {
        vista.getTxtcodigo().setText("");
        vista.getCobnombre().setSelectedItem(0);
        vista.getTxtArea_descripcion().setText("");
        vista.getCobestado().setSelectedItem(0);

    }

    public void eliminar() {
        bdpersona.setCodigo(Integer.parseInt(vista.getTxtcodigo().getText()));
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO " + vista.getTxtcodigo().getText());
        if (res == 0) {
            if (bdpersona.eliminar(vista.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                nuevo();

            }
        }
    }
}
