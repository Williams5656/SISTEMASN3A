/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.modelo.*;
import Farmacia.vista.*;
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

/**
 *
 * @author VICO5
 */
public class cpersona {
 public static v_persona vistapersona;
    private persona_BD bdpersona = new persona_BD();

    public cpersona(v_persona vistapersona) {
        this.vistapersona = vistapersona;
        vistapersona.setVisible(true);
    lista();
            
        vistapersona.getBtn_boto().addActionListener(x -> obtieneImagen());
        //vistapersona.getBtn_eliminarF().addActionListener(x -> QuitarImagen());
        vistapersona.getBtn_guardar().addActionListener(x -> guardar());
        vistapersona.getBtn_modificar().addActionListener(x -> modificar());
        vistapersona.getBtn_eliminar().addActionListener(x -> eliminar());
        vistapersona.getTabla_persona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        /*vistapersona.getLabelBotones().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelBotonesMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelBotonesMouseExited(evt);
            }
        });*/

    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapersona.getTabla_persona().getModel();
        List<persona_MD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistapersona.getTabla_persona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getCedula(), i, 0);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getNombre_apellido(), i, 1);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getCorreo(), i, 2);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getTelefono(), i, 3);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getCorreo(), i, 4);
            vistapersona.getTabla_persona().setValueAt(lista.get(i).getFoto(), i, 5);

        }
    }

    public void guardar() {
        bdpersona.setCedula(vistapersona.getTxt_cedula().getText());
        bdpersona.setNombre_apellido(vistapersona.getTxt_nombre_apellido().getText());
        bdpersona.setCorreo(vistapersona.getTxt_correo().getText());
        bdpersona.setTelefono(vistapersona.getTxt_cell().getText());
        //bdpersona.setCorreo(vistapersona.getTxtcorreo().getText());

        ImageIcon ic = (ImageIcon) vistapersona.getBtn_boto().getIcon();
        bdpersona.setFoto(ic.getImage());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    private void obtieneImagen() {
        vistapersona.getBtn_boto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistapersona.getBtn_boto().getWidth(), vistapersona.getBtn_boto().getHeight(), Image.SCALE_DEFAULT);
                vistapersona.getBtn_boto().setIcon(new ImageIcon(icono));
                vistapersona.getBtn_boto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificar() {
        bdpersona.setCedula(vistapersona.getTxt_cedula().getText());
        bdpersona.setNombre_apellido(vistapersona.getTxt_nombre_apellido().getText());
        bdpersona.setCorreo(vistapersona.getTxt_correo().getText());
        bdpersona.setTelefono(vistapersona.getTxt_cell().getText());
       

        ImageIcon ic = (ImageIcon) vistapersona.getBtn_boto().getIcon();
        bdpersona.setFoto(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdpersona.modificar(vistapersona.getTxt_cedula().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistapersona.getBtn_guardar().setEnabled(false);
        vistapersona.getBtn_modificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapersona.getTabla_persona().getModel();
        String cedula = (String) modelo.getValueAt(vistapersona.getTabla_persona().getSelectedRow(), 0);
        List<persona_BD> lista = bdpersona.obtenerDatos(cedula);
        bdpersona.setCedula(lista.get(0).getCedula());
        vistapersona.getTxt_cedula().setText(bdpersona.getCedula());
        bdpersona.setNombre_apellido(lista.get(0).getNombre_apellido());
        vistapersona.getTxt_nombre_apellido().setText(bdpersona.getNombre_apellido());
        bdpersona.setTelefono(lista.get(0).getTelefono());
        vistapersona.getTxt_cell().setText(bdpersona.getTelefono());
       bdpersona.setCorreo(lista.get(0).getCorreo());
        vistapersona.getTxt_correo().setText(bdpersona.getCorreo());
        

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistapersona.getBtn_boto().getWidth(), vistapersona.getBtn_boto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistapersona.getBtn_boto().setIcon(icon);
        } else {
            vistapersona.getBtn_boto().setIcon(null);
        }

    }

    public void     eliminar() {
        bdpersona.setCedula(vistapersona.getTxt_cedula().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdpersona.eliminar(vistapersona.getTxt_cedula().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistapersona.getTxt_cedula().setText("");
        vistapersona.getTxt_nombre_apellido().setText("");
        vistapersona.getTxt_correo().setText("");
        vistapersona.getTxt_cell().setText("");
        
        vistapersona.getBtn_boto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        vistapersona.getBtn_guardar().setEnabled(true);
        vistapersona.getBtn_modificar().setEnabled(false);
    }

    public void QuitarImagen() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de quitar la foto?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION) {
            vistapersona.getBtn_boto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        }

    }

    private void labelBotonesMouseEntered(java.awt.event.MouseEvent evt) {
        vistapersona.getBtn_guardar().setVisible(true);
        vistapersona.getBtn_nuevo().setVisible(true);
        vistapersona.getBtn_modificar().setVisible(true);
        vistapersona.getBtn_eliminar().setVisible(true);
    }

    private void labelBotonesMouseExited(java.awt.event.MouseEvent evt) {
        vistapersona.getBtn_guardar().setVisible(false);
        vistapersona.getBtn_nuevo().setVisible(false);
        vistapersona.getBtn_modificar().setVisible(false);
        vistapersona.getBtn_eliminar().setVisible(false);
    }
}

    

