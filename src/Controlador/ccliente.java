/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author VICO5
 */
public class ccliente {

    public static vcliente vista;

    private clienteBD bdcliente= new clienteBD();
    private personaBD bdpersona = new personaBD();

    public ccliente(vcliente vista) {
        this.vista = vista;

        vista.setVisible(true);
        lista();

        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
//        vista.getBtnimprimir().addActionListener(e -> imprimir());

        vista.getTxt_buscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
                 
            }
        });

        vista.getTabla_cliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
//                imprimir();
            }
        });

    

        vista.getCombo_cedula().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    obtenerPersonaPorCedula();
                }
            }
        });

        vista.getTxt_codigo().setEnabled(false);
        vista.getCombo_cedula().setEnabled(false);
        vista.getTxt_nombre_persona().setEnabled(false);
        vista.getTxt_telefono().setEnabled(false);
        vista.getTxt_alergias().setEnabled(false);
        vista.getTxt_enfermedades().setEnabled(false);
        vista.getTxt_direccion().setEnabled(false);

        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);

    }

    public void nuevo() {
        limpiar();
//        vista.getTxt_codigo().setEnabled(true);
        vista.getCombo_cedula().setEnabled(true);
        vista.getTxt_nombre_persona().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_alergias().setEnabled(true);
        vista.getTxt_enfermedades().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);

        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_codigo().setText(obtenerCodigoActual() + "");
        obtenercedulas();
//        obtenerroles();

    }

    public void obtenercedulas() {
        List<String> listac = new ArrayList<String>();
        vista.getCombo_cedula().removeAllItems();
        listac.addAll(bdpersona.obtenerCedulas());
        for (int i = 0; i < listac.size(); i++) {
            vista.getCombo_cedula().addItem(listac.get(i));
        }

    }

//    public void obtenerroles() {
//        List<String> listar = new ArrayList<String>();
//        vista.getCombo_rol().removeAllItems();
//        listar.addAll(bdRol.obtenerroles());
//        for (int i = 0; i < listar.size(); i++) {
//            vista.getCombo_rol().addItem(listar.get(i));
//        }
//    }
    private void foto() {
        vista.getLabelfoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLabelfoto().getWidth(), vista.getLabelfoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLabelfoto().setIcon(new ImageIcon(icono));
                vista.getLabelfoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(cpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiar() {
        vista.getTxt_codigo().setText("");
        vista.getCombo_cedula().removeAllItems();
        vista.getTxt_nombre_persona().setText("");
        //vista.getCombo_cedula().setSelectedIndex(0);
        vista.getTxt_telefono().setText("");
        vista.getTxt_alergias().setText("");
        vista.getTxt_enfermedades().setText("");
        vista.getTxt_direccion().setText("");
        //vista.getCombo_rol().setSelectedIndex(0);

    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();

        List<clienteMD> lista = bdcliente.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_cliente().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
             try {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_cliente().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_cliente().setValueAt(lista.get(i).getCedula(), i, 1);
            vista.getTabla_cliente().setValueAt(lista.get(i).getNombre(), i, 2);
            vista.getTabla_cliente().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTabla_cliente().setValueAt(lista.get(i).getAlergias(), i, 4);
            vista.getTabla_cliente().setValueAt(lista.get(i).getEnfermedades(), i, 5);
            vista.getTabla_cliente().setValueAt(lista.get(i).getDireccion(), i, 6);
             } catch (Exception e) {
                 
             }
            
        }
    }

    public void guardar() {

        bdcliente.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdcliente.setCedula(vista.getCombo_cedula().getSelectedItem().toString());
        bdcliente.setNombre(vista.getTxt_nombre_persona().getText());
        bdcliente.setTelefono(vista.getTxt_telefono().getText());
        bdcliente.setAlergias(vista.getTxt_alergias().getText());
        bdcliente.setEnfermedades(vista.getTxt_enfermedades().getText());
        bdcliente.setDireccion(vista.getTxt_direccion().getText());

        if (bdcliente.insertar()) {
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
            modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();

            List<clienteMD> lista = bdcliente.obtenerDatosPorNombre(vista.getTxt_buscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_cliente().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
               vista.getTabla_cliente().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_cliente().setValueAt(lista.get(i).getCedula(), i, 1);
            vista.getTabla_cliente().setValueAt(lista.get(i).getNombre(), i, 2);
            vista.getTabla_cliente().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTabla_cliente().setValueAt(lista.get(i).getAlergias(), i, 4);
            vista.getTabla_cliente().setValueAt(lista.get(i).getEnfermedades(), i, 5);
            vista.getTabla_cliente().setValueAt(lista.get(i).getDireccion(), i, 6);
            
            }
        }
    }

    public void modificar() {

       
        bdcliente.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdcliente.setCedula(vista.getCombo_cedula().getSelectedItem().toString());
        bdcliente.setNombre(vista.getTxt_nombre_persona().getText());
        bdcliente.setTelefono(vista.getTxt_telefono().getText());
        bdcliente.setAlergias(vista.getTxt_alergias().getText());
        bdcliente.setEnfermedades(vista.getTxt_enfermedades().getText());
        bdcliente.setDireccion(vista.getTxt_direccion().getText());
        

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdcliente.modificar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    public void seleccionar() {
        vista.getTxt_codigo().setEnabled(true);
        vista.getCombo_cedula().setEnabled(true);
        vista.getTxt_nombre_persona().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_alergias().setEnabled(true);
        vista.getTxt_enfermedades().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);

        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_cliente().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTabla_cliente().getSelectedRow(), 0);

        List<clienteMD> lista = bdcliente.obtenerDatos(codigo);

        bdcliente.setCodigo(lista.get(0).getCodigo());
        vista.getTxt_codigo().setText(String.valueOf(bdcliente.getCodigo()));

        bdcliente.setCedula(lista.get(0).getCedula());
        vista.getCombo_cedula().removeAllItems();
        vista.getCombo_cedula().addItem(bdcliente.getCedula());
        vista.getCombo_cedula().setSelectedIndex(0);

        bdcliente.setNombre(lista.get(0).getNombre());
        vista.getTxt_nombre_persona().setText(bdcliente.getNombre());

        bdcliente.setTelefono(lista.get(0).getTelefono());
        vista.getTxt_nombre_persona().setText(bdcliente.getNombre());
        
         bdcliente.setAlergias(lista.get(0).getAlergias());
        vista.getTxt_alergias().setText(bdcliente.getAlergias());
        
         bdcliente.setEnfermedades(lista.get(0).getEnfermedades());
        vista.getTxt_enfermedades().setText(bdcliente.getEnfermedades());
        
         bdcliente.setDireccion(lista.get(0).getDireccion());
        vista.getTxt_direccion().setText(bdcliente.getDireccion());

    }//Fin del seleccionar

    public void eliminar() {
        bdcliente.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este rol " + vista.getTxt_codigo().getText());
        if (respuesta == 0) {
            if (bdcliente.eliminar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    public Integer obtenerCodigoActual() {
        List<Integer> lista = bdcliente.obtenerCodigoActual();
        return lista.get(0) + 1;

    }

    private void obtenerPersonaPorCedula() {

        personaMD mdPersona = bdpersona.obtenerPersonaPorCedula(vista.getCombo_cedula().getSelectedItem().toString());
        
        vista.getTxt_nombre_persona().setText(mdPersona.getNombres());
        vista.getTxt_telefono().setText(mdPersona.getTelefono());
        vista.getTxt_direccion().setText(mdPersona.getDireccion());

        Image img = mdPersona.getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLabelfoto().getWidth(), vista.getLabelfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLabelfoto().setIcon(icon);
        } else {
            vista.getLabelfoto().setIcon(null);
        }

    }
    
//     public void imprimir() {
//        Conect con = new Conect();
//        try {
//            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/cliente.jasper"));
//            JasperPrint jp = (JasperPrint)JasperFillManager.fillReport(jas, null, con.getCon());
//            JasperViewer jv = new JasperViewer(jp, false);
//            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            jv.setVisible(true);
//        } catch (JRException e) {
//            System.out.println("no se pudo encontrar registros" + e.getMessage());
//            Logger.getLogger(cpersona.class.getName()).log(Level.SEVERE, null, e);
//        }
//
//    }
}
