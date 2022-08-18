/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.modelo.*;
import Farmacia.vista.v_usuarios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VICO5
 */
public class c_usuario {

    public static v_usuarios VistaU;

    private usuario_BD bdusuario = new usuario_BD();

    public c_usuario(v_usuarios VistaU) {
        this.VistaU = VistaU;
        VistaU.setVisible(true);
        VistaU.setLocationRelativeTo(null);
        lista();
        VistaU.getBtn_guardar().addActionListener(x -> guardar());
        VistaU.getBtn_modificar().addActionListener(e -> modificar());
        VistaU.getTabla_usuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                seleccionar();
            }

        });

        VistaU.getBtn_nuevo().addActionListener(e -> nuevo());
        VistaU.getBtn_eliminar().addActionListener(e -> eliminar());

        VistaU.getBtn_guardar().setEnabled(false);
        VistaU.getBtn_modificar().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaU.getTabla_usuario().getModel();
        List<usuario_MD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaU.getTabla_usuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaU.getTabla_usuario().setValueAt(lista.get(i).getCedulau(), i, 0);
            VistaU.getTabla_usuario().setValueAt(lista.get(i).getNombreu(), i, 1);
            VistaU.getTabla_usuario().setValueAt(lista.get(i).getCorreou(), i, 2);
            VistaU.getTabla_usuario().setValueAt(lista.get(i).getContraseña(), i, 3);
            VistaU.getTabla_usuario().setValueAt(lista.get(i).getRol(), i, 4);

        }
    }

    public void nuevo() {
        VistaU.getCombo_cedula().setSelectedItem("");
        VistaU.getTxt_nombreu().setText("");
        VistaU.getCombo_correo().setSelectedItem("");
        VistaU.getTxt_conta().setText("");
        VistaU.getCombo_rol().setSelectedItem("");

        VistaU.getBtn_guardar().setEnabled(true);
        VistaU.getBtn_modificar().setEnabled(false);

    }

    public void guardar() {
        String ced = (String) VistaU.getCombo_cedula().getSelectedItem();
        bdusuario.setRol(ced);
        bdusuario.setNombreu(VistaU.getTxt_nombreu().getText());
        String c = (String) VistaU.getCombo_correo().getSelectedItem();
        bdusuario.setRol(c);;
        bdusuario.setContraseña(VistaU.getTxt_conta().getText());
        String rol = (String) VistaU.getCombo_rol().getSelectedItem();
        bdusuario.setRol(rol);

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modificar() {
       String ced = (String) VistaU.getCombo_cedula().getSelectedItem();
        bdusuario.setCedulau(ced);
        bdusuario.setNombreu(VistaU.getTxt_nombreu().getText());
        String c = (String) VistaU.getCombo_correo().getSelectedItem();
        bdusuario.setCorreou(c);;
        bdusuario.setContraseña(VistaU.getTxt_conta().getText());
        String rol = (String) VistaU.getCombo_rol().getSelectedItem();
        bdusuario.setRol(rol);

        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea modificar");
        if (resp == 0) {
            if (bdusuario.modificar(VistaU.getTxt_nombreu().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }

    public void seleccionar() {
        VistaU.getBtn_guardar().setEnabled(false);
        VistaU.getBtn_modificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaU.getTabla_usuario().getModel();
        String cedula = (String) modelo.getValueAt(VistaU.getTabla_usuario().getSelectedRow(), 0);
        List<usuario_MD> lista = bdusuario.obtenerdatos(cedula);
        bdusuario.setCedulau(lista.get(0).getCedulau());
        VistaU.getCombo_cedula().setSelectedItem(bdusuario.getCedulau());
        bdusuario.setNombreu(lista.get(0).getNombreu());
        VistaU.getTxt_nombreu().setText(bdusuario.getNombreu());
        bdusuario.setCorreou(lista.get(0).getCorreou());
        VistaU.getCombo_correo().setSelectedItem(bdusuario.getCorreou());
        bdusuario.setContraseña(lista.get(0).getContraseña());
        VistaU.getTxt_conta().setText(bdusuario.getContraseña());
        bdusuario.setRol(lista.get(0).getRol());
        VistaU.getCombo_rol().setSelectedItem(bdusuario.getRol());
        
    }

    public void eliminar() {
        bdusuario.setNombreu(VistaU.getTxt_nombreu().getText());
        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea eliminar" + VistaU.getTxt_nombreu().getText());
        if (resp == 0) {
            if (bdusuario.eliminar(VistaU.getTxt_nombreu().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }

}
