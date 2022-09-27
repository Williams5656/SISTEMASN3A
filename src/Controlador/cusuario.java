/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.cpersona.vista;
import Modelo.personaBD;
import Modelo.personaMD;
import Modelo.rol_BD;
import Modelo.usuarioBD;
import Modelo.usuarioMD;
import Vista.vusuario;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class cusuario {

    public static vusuario vista;

    private usuarioBD bdusuario = new usuarioBD();
    private rol_BD bdRol = new rol_BD();
    private personaBD bdpersona = new personaBD();

    public cusuario(vusuario vista) {
        this.vista = vista;

        vista.setVisible(true);
        lista();

        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
       

        vista.getTxt_buscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTabla_usuarios().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
    
//        vista.getTabla_usuarios().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                seleccionar();
//            }
//        });
        
        vista.getCombo_cedula().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if(evt.getStateChange()== ItemEvent.SELECTED){
                    obtenerPersonaPorCedula();
                }                
            }
        });      
    
    

        vista.getTxt_codigo().setEnabled(false);
        vista.getCombo_cedula().setEnabled(false);
        vista.getTxt_usuario().setEnabled(false);
        vista.getTxt_contraseña().setEnabled(false);
        vista.getCombo_rol().setEnabled(false);
        vista.getCombo_estado().setEnabled(false);
        vista.getTxt_nombrepersona().setEnabled(false);

        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);

    }

    public void nuevo() {
        limpiar();
//        vista.getTxt_codigo().setEnabled(true);
        vista.getCombo_cedula().setEnabled(true);
        vista.getTxt_usuario().setEnabled(true);
        vista.getTxt_contraseña().setEnabled(true);
        vista.getCombo_rol().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);
        

        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_codigo().setText(obtenerCodigoActual() + "");
        obtenercedulas();
        obtenerroles();

    }

    public void obtenercedulas() {
        List<String> listac = new ArrayList<String>();
        vista.getCombo_cedula().removeAllItems();
        listac.addAll(bdpersona.obtenerCedulas());
        for (int i = 0; i < listac.size(); i++) {
            vista.getCombo_cedula().addItem(listac.get(i));
        }

    }

    public void obtenerroles() {
        List<String> listar = new ArrayList<String>();
        vista.getCombo_rol().removeAllItems();
        listar.addAll(bdRol.obtenerroles());
        for (int i = 0; i < listar.size(); i++) {
            vista.getCombo_rol().addItem(listar.get(i));
        }
    }

    private void foto() {
        vista.getLabel_foto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLabel_foto().getWidth(), vista.getLabel_foto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLabel_foto().setIcon(new ImageIcon(icono));
                vista.getLabel_foto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(cpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiar() {
        vista.getTxt_codigo().setText("");
        vista.getCombo_cedula().removeAllItems();
        vista.getCombo_rol().removeAllItems();
        //vista.getCombo_cedula().setSelectedIndex(0);
        vista.getTxt_usuario().setText("");
        vista.getTxt_contraseña().setText("");
        //vista.getCombo_rol().setSelectedIndex(0);
        vista.getCombo_estado().setSelectedIndex(0);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_usuarios().getModel();

        List<usuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_usuarios().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getCedula(), i, 1);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getUsuario(), i, 2);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getPassword(), i, 3);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getRol(), i, 4);
            vista.getTabla_usuarios().setValueAt(lista.get(i).getEstado(), i, 5);
        }
    }

    public void guardar() {

        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdusuario.setCedula(vista.getCombo_cedula().getSelectedItem().toString());
        bdusuario.setUsuario(vista.getTxt_usuario().getText());
        bdusuario.setPassword(vista.getTxt_contraseña().getText());
        bdusuario.setRol(vista.getCombo_rol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCombo_estado().getSelectedItem().toString());

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void buscar() {
        if (vista.getTxt_buscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_usuarios().getModel();

            List<usuarioMD> lista = bdusuario.obtenerDatosPorNombre(vista.getTxt_buscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_usuarios().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getCedula(), i, 1);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getUsuario(), i, 2);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getPassword(), i, 3);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getRol(), i, 4);
                vista.getTabla_usuarios().setValueAt(lista.get(i).getEstado(), i, 5);
            }
        }
    }

    public void modificar() {

        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdusuario.setCedula(vista.getCombo_cedula().getSelectedItem().toString());
        bdusuario.setUsuario(vista.getTxt_usuario().getText());
        bdusuario.setPassword(vista.getTxt_contraseña().getText());
        bdusuario.setRol(vista.getCombo_rol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCombo_estado().getSelectedItem().toString());

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdusuario.modificar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    public void seleccionar() {
//        vista.getTxt_codigo().setEnabled(true);
        vista.getCombo_cedula().setEnabled(false);
        vista.getTxt_usuario().setEnabled(true);
        vista.getTxt_contraseña().setEnabled(true);
        vista.getCombo_rol().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);

        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_usuarios().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTabla_usuarios().getSelectedRow(), 0);

        List<usuarioMD> lista = bdusuario.obtenerDatos(codigo);

        bdusuario.setCodigo(lista.get(0).getCodigo());
        vista.getTxt_codigo().setText(String.valueOf(bdusuario.getCodigo()));

        bdusuario.setCedula(lista.get(0).getCedula());
        vista.getCombo_cedula().removeAllItems();
        vista.getCombo_cedula().addItem(bdusuario.getCedula());
        vista.getCombo_cedula().setSelectedIndex(0);

        bdusuario.setUsuario(lista.get(0).getUsuario());
        vista.getTxt_usuario().setText(bdusuario.getUsuario());

        bdusuario.setPassword(lista.get(0).getPassword());
        vista.getTxt_contraseña().setText(bdusuario.getPassword());

        bdusuario.setRol(lista.get(0).getRol());
        obtenerroles();
        vista.getCombo_rol().setSelectedItem(bdusuario.getRol());

        bdusuario.setEstado(lista.get(0).getEstado());
        vista.getCombo_estado().setSelectedItem(bdusuario.getEstado());
    }//Fin del seleccionar

    public void eliminar() {
        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este rol " + vista.getTxt_codigo().getText());
        if (respuesta == 0) {
            if (bdusuario.eliminar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    public Integer obtenerCodigoActual() {
        List<Integer> lista = bdusuario.obtenerCodigoActual();
        return lista.get(0) + 1;

    }

    private void obtenerPersonaPorCedula() {
        
        personaMD mdPersona=bdpersona.obtenerPersonaPorCedula(vista.getCombo_cedula().getSelectedItem().toString());
        
        vista.getTxt_nombrepersona().setText(mdPersona.getNombres());      
        
        Image img = mdPersona.getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLabel_foto().getWidth(), vista.getLabel_foto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLabel_foto().setIcon(icon);
        } else {
            vista.getLabel_foto().setIcon(null);
        }

    }
}
