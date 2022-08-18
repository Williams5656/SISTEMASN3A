/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.modelo.*;
import Farmacia.vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VICO5
 */
public class c_roles {

    public static v_roles VistaR;

    private roles_BD bdrol = new roles_BD();

    public c_roles(v_roles VistaR) {
        this.VistaR = VistaR;
        VistaR.setVisible(true);
        VistaR.setLocationRelativeTo(null);
        lista();
        VistaR.getBtn_guardar().addActionListener(x -> guardar());
        VistaR.getBtn_modificar().addActionListener(e -> modificar());
        VistaR.getBtn_buscar().addActionListener(e -> buscar());
        VistaR.getTabla_roles().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                seleccionar();
            }

        });

        VistaR.getBtn_nuevo().addActionListener(e -> nuevo());
        VistaR.getBtn_eliminar().addActionListener(e -> eliminar());
        VistaR.getBtn_guardar().setEnabled(false);
        VistaR.getBtn_modificar().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTabla_roles().getModel();
        List<roles_MD> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaR.getTabla_roles().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaR.getTabla_roles().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaR.getTabla_roles().setValueAt(lista.get(i).getNombres(), i, 1);
            VistaR.getTabla_roles().setValueAt(lista.get(i).getDescripcion(), i, 2);
            VistaR.getTabla_roles().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void nuevo() {
        VistaR.getTxt_codigo().setText("");
        VistaR.getCombo_nombres().setSelectedItem("");
        VistaR.getTxt_descripcion().setText("");
        VistaR.getCombo_estado().setSelectedItem("");
        VistaR.getTxt_buscar().setText("");

        VistaR.getBtn_guardar().setEnabled(true);
        VistaR.getBtn_modificar().setEnabled(false);

    }

    public void guardar() {
        bdrol.setCodigo(VistaR.getTxt_codigo().getText());
        String nom = (String) VistaR.getCombo_nombres().getSelectedItem();
        bdrol.setEstado(nom);
        bdrol.setDescripcion(VistaR.getTxt_descripcion().getText());
        String rol = (String) VistaR.getCombo_estado().getSelectedItem();
        bdrol.setEstado(rol);

        if (bdrol.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void buscar() {
        if (VistaR.getTxt_buscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaR.getTabla_roles().getModel();
            List<roles_MD> lista = bdrol.obtenerdatos(VistaR.getTxt_buscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaR.getTabla_roles().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaR.getTabla_roles().setValueAt(lista.get(i).getCodigo(), i, 0);
                VistaR.getTabla_roles().setValueAt(lista.get(i).getNombres(), i, 1);
                VistaR.getTabla_roles().setValueAt(lista.get(i).getDescripcion(), i, 2);
                VistaR.getTabla_roles().setValueAt(lista.get(i).getEstado(), i, 3);

            }
        }

    }

    public void modificar() {
        bdrol.setCodigo(VistaR.getTxt_codigo().getText());
        String nom = (String) VistaR.getCombo_nombres().getSelectedItem();
        bdrol.setEstado(nom);
        bdrol.setDescripcion(VistaR.getTxt_descripcion().getText());
        String rol = (String) VistaR.getCombo_estado().getSelectedItem();
        bdrol.setEstado(rol);

        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea modificar");
        if (resp == 0) {
            if (bdrol.modificar(VistaR.getTxt_codigo().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }

    public void seleccionar() {
        VistaR.getBtn_guardar().setEnabled(false);
        VistaR.getBtn_modificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTabla_roles().getModel();
        String cedula = (String) modelo.getValueAt(VistaR.getTabla_roles().getSelectedRow(), 0);
        List<roles_MD> lista = bdrol.obtenerdatos(cedula);
        bdrol.setCodigo(lista.get(0).getCodigo());
        VistaR.getTxt_codigo().setText(bdrol.getCodigo());
        bdrol.setNombres(lista.get(0).getNombres());
        VistaR.getCombo_nombres().setSelectedItem(bdrol.getNombres());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        VistaR.getTxt_descripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        VistaR.getCombo_estado().setSelectedItem(bdrol.getEstado());
    }

    public void eliminar() {
        bdrol.setCodigo(VistaR.getTxt_codigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "SEGURO QUE DESEA INHABILITAR  " + VistaR.getCombo_nombres().getSelectedItem());
        if (resp == 0) {
            if (bdrol.eliminar(VistaR.getTxt_codigo().getText()));
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
            lista();
            nuevo();
        }
    }

}
