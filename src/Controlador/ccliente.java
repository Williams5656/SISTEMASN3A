/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ccliente {
     public static vcliente vista;

    private clienteBD bdpersona = new clienteBD();

    public ccliente(vcliente vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();

        vista.getBtnnuevo().addActionListener(e -> nuevo());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getBtnfoto().addActionListener(e -> foto());
        vista.getTxtbuscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTabla_cliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });

        vista.getTxtcedula().setEnabled(false);
        vista.getTxtnomyap().setEnabled(false);
        vista.getTxtdescrip().setEnabled(false);
        vista.getBtnfoto().setEnabled(false);
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(false);
        vista.getBtneliminar().setEnabled(false);
    }

    private void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();

        List<clienteMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_cliente().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_cliente().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTabla_cliente().setValueAt(lista.get(i).getNombre_apellido(), i, 1);
            vista.getTabla_cliente().setValueAt(lista.get(i).getDescripcion_cli(), i, 2);
            vista.getTabla_cliente().setValueAt(lista.get(i).getFoto(), i, 3);
        }

    }

    private void nuevo() {
        limpiar();
        vista.getTxtcedula().setEnabled(true);
        vista.getTxtnomyap().setEnabled(true);
        vista.getTxtdescrip().setEnabled(true);
        vista.getBtnfoto().setEnabled(true);
        vista.getBtnguardar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(true);
        vista.getBtneliminar().setEnabled(true);

    }

    private void guardar() {
       // SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setCedula(vista.getTxtcedula().getText());
        bdpersona.setNombre_apellido(vista.getTxtnomyap().getText());
        bdpersona.setDescripcion_cli(vista.getTxtdescrip().getText());
        //bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
        ImageIcon ic = (ImageIcon) vista.getFot().getIcon();
        bdpersona.setFoto(ic.getImage());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }

    }

    private void modificar() {
       // SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setCedula(vista.getTxtcedula().getText());
        bdpersona.setNombre_apellido(vista.getTxtnomyap().getText());
        bdpersona.setDescripcion_cli(vista.getTxtdescrip().getText());
        //bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
        ImageIcon ic = (ImageIcon) vista.getFot().getIcon();
        bdpersona.setFoto(ic.getImage());

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdpersona.modificar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }

    }

    private void eliminar() {
        bdpersona.setCedula(vista.getTxtcedula().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este uduario " + vista.getTxtcedula().getText());
        if (respuesta == 0) {
            if (bdpersona.eliminar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    private void foto() {
        vista.getFot().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getFot().getWidth(), vista.getFot().getHeight(), Image.SCALE_DEFAULT);
                vista.getFot().setIcon(new ImageIcon(icono));
                vista.getFot().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(cpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();

            List<clienteMD> lista = bdpersona.obtenerDatos(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_cliente().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_cliente().setValueAt(lista.get(i).getCedula(), i, 0);
                vista.getTabla_cliente().setValueAt(lista.get(i).getNombre_apellido(), i, 1);
                vista.getTabla_cliente().setValueAt(lista.get(i).getDescripcion_cli(), i, 2);
                vista.getTabla_cliente().setValueAt(lista.get(i).getFoto(), i, 6);
                
            }
        }

    }

    private void seleccionar() {
        vista.getTxtcedula().setEnabled(true);
        vista.getTxtnomyap().setEnabled(true);
        vista.getTxtdescrip().setEnabled(true);
        vista.getBtnfoto().setEnabled(true);
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);
        vista.getBtneliminar().setEnabled(true);
        vista.getTxtbuscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTabla_cliente().getSelectedRow(), 0);

        List<clienteMD> lista = bdpersona.obtenerDatos(cedula);

        bdpersona.setCedula(lista.get(0).getCedula());
        vista.getTxtcedula().setText(bdpersona.getCedula());
        bdpersona.setNombre_apellido(lista.get(0).getNombre_apellido());
        vista.getTxtnomyap().setText(bdpersona.getNombre_apellido());
        bdpersona.setDescripcion_cli(lista.get(0).getDescripcion_cli());
        //vista.getTxtdescrip().setText(bdpersona.getDescripcion_cli());
        /*bdpersona.setFechanac(lista.get(0).getFechanac());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(bdpersona.getFechanac());
            vista.getTxt_calendar().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }*/

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getFot().getWidth(), vista.getFot().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getFot().setIcon(icon);
        } else {
            vista.getFot().setIcon(null);
        }

    }

    private void limpiar() {
        vista.getTxtcedula().setText("");
        vista.getTxtnomyap().setText("");
        vista.getTxtdescrip().setText("");
        //vista.getTxt_calendar().setCalendar(null);
        vista.getFot().setIcon(null);

    }
    
}
