
package Papeleria_Bella.controlador;

import Papeleria_Bella.modelo.Conexion;
import Papeleria_Bella.modelo.*;
import Papeleria_Bella.vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cusuario {
    public static Vusuario vista;
    private UsuarioBD busuario = new UsuarioBD();
    
    public Cusuario(Vusuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
         vista.getComborol().setModel(busuario.ROL());
//        lista();
    }
//        vista.getButtonguardar().addActionListener(x -> guardar());
//        vista.getButtonbuscar().addActionListener(e -> buscar());
//        vista.getButtonmodificar().addActionListener(e -> modificar());
//        vista.getComborol().setModel(busuario.ROL());
//        vista.getTablausuario().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                seleccionar();
//            }
//
//        });
//        
//        vista.getButtonnuevo().addActionListener(e -> nuevo());
//        vista.getButtoneliminar().addActionListener(e -> eliminar());
//        vista.getButtonguardar().setEnabled(false);
//        vista.getButtonmodificar().setEnabled(false);
//    }
//    public void lista() {
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablausuario().getModel();
//        List<UsuarioMD> lista = busuario.mostrardatos();
//        int columnas = modelo.getColumnCount();
//        for (int j = vista.getTablausuario().getRowCount() - 1; j >= 0; j--) {
//            modelo.removeRow(j);
//        }
//        for (int i = 0; i < lista.size(); i++) {
//            modelo.addRow(new Object[columnas]);
//            vista.getTablausuario().setValueAt(lista.get(i).getCodigo(), i, 0);
//            vista.getTablausuario().setValueAt(lista.get(i).getCedula(), i, 1);
//            vista.getTablausuario().setValueAt(lista.get(i).getUsuario(), i, 2);
//            vista.getTablausuario().setValueAt(lista.get(i).getClave(), i, 3);
//            vista.getTablausuario().setValueAt(lista.get(i).getRol(), i, 4);
//            vista.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 5);
//        }
//    }
    
//    public void guardar() {
//        busuario.setCodigo(vista.getLabelcodigo().getText());
//        busuario.setCedula(vista.getTxtcedula().getText());
//        busuario.setUsuario(vista.getTxtusuario().getText());
//        busuario.setClave(vista.getPassword().getText());
//        busuario.setRol(vista.getComborol().getSelectedItem().toString());
//        busuario.setEstado(vista.getComboestado().getSelectedItem().toString());
//
//        if (busuario.insertar()) {
//            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
//            lista();
//        } else {
//            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
//            lista();
//        }
//
//    }
//    public void modificar() {
//        busuario.setCodigo(vista.getLabelcodigo().getText());
//        busuario.setCedula(vista.getTxtcedula().getText());
//        busuario.setUsuario(vista.getTxtusuario().getText());
//        busuario.setClave(vista.getPassword().getText());
//        String rol = (String) vista.getComboestado().getSelectedItem();
//        busuario.setRol(rol);
//        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
//        if (resp == 0) {
//            if (busuario.modificar(vista.getTxtcedula().getText())) ;
//                JOptionPane.showMessageDialog(null, "Datos Actualizados");
//                lista();
//                nuevo();
//                
//            }
//    }
//    
//    public void seleccionar() {
//        vista.getButtonguardar().setEnabled(false);
//        vista.getButtonmodificar().setEnabled(true);
//        
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablarol().getModel();
//        String codigo = (String) modelo.getValueAt(vista.getTablarol().getSelectedRow(), 0);
//        List<RolMD> lista = brol.obtenerdatos(codigo);
//        brol.setCodigo(lista.get(0).getCodigo());
//        vista.getTxtcodigo().setText(brol.getCodigo());
//        brol.setNombre(lista.get(0).getNombre());
//        vista.getTxtnombre().setText(brol.getNombre());
//        brol.setDescripcion(lista.get(0).getDescripcion());
//        vista.getTxtdescripcion().setText(brol.getDescripcion());
//        brol.setEstado(lista.get(0).getEstado());
//        vista.getComboestado().setSelectedItem(brol.getEstado());   
//    }
//    public void eliminar(){
//        brol.setCodigo(vista.getTxtcodigo().getText());
//        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  "+vista.getTxtcodigo().getText());
//        if (resp == 0) {
//            if (brol.eliminar(vista.getTxtcodigo().getText())) ;
//                JOptionPane.showMessageDialog(null, "Datos Actualizados");
//                lista();
//                nuevo();
//                
//            }
//    } 
//  
//    public void nuevo(){
//        vista.getTxtcodigo().setText("");
//        vista.getTxtnombre().setText("");
//        vista.getTxtdescripcion().setText("");
//        vista.getComboestado().setSelectedItem("");
//        vista.getButtonguardar().setEnabled(true);
//        vista.getButtonmodificar().setEnabled(false);
//    }
//
//    private void buscar() {
//        if (vista.getTxtbuscar().getText().equals("")) {
//            lista();
//        } else {
//            DefaultTableModel model;
//            model = (DefaultTableModel) vista.getTablarol().getModel();
//            java.util.List<RolMD> lista = brol.buscardatos(vista.getTxtbuscar().getText());
//            int columnas = model.getColumnCount();
//            for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
//                model.removeRow(j);
//            }
//            for (int i = 0; i < lista.size(); i++) {
//                    model.addRow(new Object[columnas]);
//                    vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
//                    vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
//                    vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
//                    vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);
//            }
//        }
//    
//    }
    
}
