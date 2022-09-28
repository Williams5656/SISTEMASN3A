/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.productoBD;
import Modelo.productoMD;
import Modelo.proveedorBD;
import Modelo.proveedorMD;
import Modelo.*;
import Vista.vproducto;
import java.awt.Image;
import java.awt.EventQueue;
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
public class cproducto {

    public static vproducto vista;

    private productoBD bdpersona = new productoBD();
    private proveedorBD bdpv = new proveedorBD();
    List<String> listap = bdpv.obtenerlaboratorios();
    public cproducto(vproducto vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();

        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modifcar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtnimprimir().addActionListener(e -> imprimir());
        vista.getBtn_foto().addActionListener(e -> foto());
        vista.getTxt_buscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTabla_productos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
                imprimir();
            }
        });

        vista.getCombo_lab().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
//                    obtenerlab();
                }
            }
        });

        vista.getTxt_codigo().setEnabled(false);
        vista.getTxt_nombreproducto().setEnabled(false);
        vista.getCombo_presentacion().setEnabled(false);
        vista.getCombo_lab().setEnabled(false);
        vista.getCombo_cantidad().setEnabled(false);
        vista.getTxt_pvp().setEnabled(false);
        vista.getTxt_calendari().setEnabled(false);
        vista.getTxt_calendarv().setEnabled(false);
        vista.getTex_descripcion().setEnabled(false);
        vista.getBtn_foto().setEnabled(false);
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modifcar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
    }

    private void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_productos().getModel();

        List<productoMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_productos().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            try {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_productos().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTabla_productos().setValueAt(lista.get(i).getNombrep(), i, 1);
                vista.getTabla_productos().setValueAt(lista.get(i).getPresentacion(), i, 2);
                vista.getTabla_productos().setValueAt(lista.get(i).getLab(), i, 3);
                vista.getTabla_productos().setValueAt(lista.get(i).getCantidad(), i, 4);
                vista.getTabla_productos().setValueAt(lista.get(i).getPvp(), i, 5);
                vista.getTabla_productos().setValueAt(lista.get(i).getFechai(), i, 6);
                vista.getTabla_productos().setValueAt(lista.get(i).getFechasal(), i, 7);
                vista.getTabla_productos().setValueAt(lista.get(i).getDesc(), i, 8);
                vista.getTabla_productos().setValueAt(lista.get(i).getFoto(), i, 9);
            } catch (Exception e) {
            }
        }

    }

    private void nuevo() {
        limpiar();
        vista.getTxt_codigo().setEnabled(false);
        vista.getTxt_nombreproducto().setEnabled(true);
        vista.getCombo_presentacion().setEnabled(true);
        vista.getCombo_lab().setEnabled(true);
        vista.getCombo_cantidad().setEnabled(true);
        vista.getTxt_pvp().setEnabled(true);
        vista.getTxt_calendari().setEnabled(true);
        vista.getTxt_calendarv().setEnabled(true);
        vista.getTex_descripcion().setEnabled(true);

        vista.getBtn_foto().setEnabled(true);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modifcar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_codigo().setText(obtenerCodigoActual() + "");
        obtenerCodigoActual();
        obtenerlab();

    }

    private void guardar() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdpersona.setNombrep(vista.getTxt_nombreproducto().getText());
        bdpersona.setPresentacion(vista.getCombo_presentacion().getSelectedItem().toString());
        bdpersona.setLab(vista.getCombo_lab().getSelectedItem().toString());
        bdpersona.setCantidad(vista.getCombo_cantidad().getSelectedItem().toString());
        bdpersona.setPvp(vista.getTxt_pvp().getText());
        bdpersona.setFechai(f.format(vista.getTxt_calendari().getDate()));
        bdpersona.setFechasal(f1.format(vista.getTxt_calendarv().getDate()));
        ImageIcon ic = (ImageIcon) vista.getLabel_foto().getIcon();
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
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdpersona.setNombrep(vista.getTxt_nombreproducto().getText());
        bdpersona.setPresentacion(vista.getCombo_presentacion().getSelectedItem().toString());
        bdpersona.setLab(vista.getCombo_cantidad().getSelectedItem().toString());
        bdpersona.setPvp(vista.getTxt_pvp().getText());
        bdpersona.setFechai(f.format(vista.getTxt_calendari().getDate()));
        bdpersona.setFechasal(f.format(vista.getTxt_calendarv().getDate()));
        ImageIcon ic = (ImageIcon) vista.getLabel_foto().getIcon();
        bdpersona.setFoto(ic.getImage());

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdpersona.modificar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }

    }

    private void eliminar() {
        bdpersona.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este uduario " + vista.getTxt_codigo().getText());
        if (respuesta == 0) {
            if (bdpersona.eliminar(Integer.parseInt(vista.getTxt_codigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
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
                Logger.getLogger(cproducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void buscar() {
        if (vista.getTxt_buscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_productos().getModel();

            List<productoMD> lista = bdpersona.obtenerDatos(Integer.parseInt(vista.getTxt_buscar().getText()));
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_productos().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_productos().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTabla_productos().setValueAt(lista.get(i).getNombrep(), i, 1);
                vista.getTabla_productos().setValueAt(lista.get(i).getPresentacion(), i, 2);
                vista.getTabla_productos().setValueAt(lista.get(i).getLab(), i, 3);
                vista.getTabla_productos().setValueAt(lista.get(i).getCantidad(), i, 4);
                vista.getTabla_productos().setValueAt(lista.get(i).getPvp(), i, 5);
                vista.getTabla_productos().setValueAt(lista.get(i).getFechai(), i, 6);
                vista.getTabla_productos().setValueAt(lista.get(i).getFechasal(), i, 7);
                vista.getTabla_productos().setValueAt(lista.get(i).getDesc(), i, 8);
                vista.getTabla_productos().setValueAt(lista.get(i).getFoto(), i, 9);
            }
        }

    }

    private void seleccionar() {
        vista.getTxt_codigo().setEnabled(false);
        vista.getTxt_nombreproducto().setEnabled(true);
        vista.getCombo_presentacion().setEnabled(true);
        vista.getCombo_lab().setEnabled(true);
        vista.getCombo_cantidad().setEnabled(true);
        vista.getTxt_pvp().setEnabled(true);
        vista.getTxt_calendari().setEnabled(true);
        vista.getTxt_calendarv().setEnabled(true);
        vista.getTex_descripcion().setEnabled(true);
        vista.getBtn_foto().setEnabled(true);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modifcar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_productos().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTabla_productos().getSelectedRow(), 0);

        List<productoMD> lista = bdpersona.obtenerDatos(codigo);

        bdpersona.setCodigo(lista.get(0).getCodigo());
        vista.getTxt_codigo().setText(String.valueOf(bdpersona.getCodigo()));

        bdpersona.setNombrep(lista.get(0).getNombrep());
        vista.getTxt_nombreproducto().setText(bdpersona.getNombrep());

        bdpersona.setPresentacion(lista.get(0).getPresentacion());
        vista.getCombo_presentacion().setSelectedItem(bdpersona.getPresentacion());

        bdpersona.setLab(lista.get(0).getLab());
//        
        vista.getCombo_lab().setSelectedItem(bdpersona.getLab());

        bdpersona.setCantidad(lista.get(0).getCantidad());
        vista.getCombo_cantidad().setSelectedItem(bdpersona.getCantidad());

        bdpersona.setPvp(lista.get(0).getPvp());
        vista.getTxt_pvp().setText(bdpersona.getPvp());

        bdpersona.setFechai(lista.get(0).getFechai());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(bdpersona.getFechai());
            vista.getTxt_calendari().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        bdpersona.setFechasal(lista.get(0).getFechasal());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha2 = null;
        try {
            fecha2 = formato.parse(bdpersona.getFechasal());
            vista.getTxt_calendarv().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        bdpersona.setDesc(lista.get(0).getDesc());
        vista.getTex_descripcion().setText(bdpersona.getDesc());

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLabel_foto().getWidth(), vista.getLabel_foto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLabel_foto().setIcon(icon);
        } else {
            vista.getLabel_foto().setIcon(null);
        }

    }

    private void limpiar() {
        vista.getTxt_codigo().setText("");
        vista.getTxt_nombreproducto().setText("");
        vista.getCombo_presentacion().setSelectedItem(null);
        vista.getCombo_lab().removeAllItems();
        vista.getCombo_cantidad().setSelectedItem(null);
        vista.getTxt_pvp().setText("");
        vista.getTxt_calendari().setCalendar(null);
        vista.getTxt_calendarv().setCalendar(null);
        vista.getTex_descripcion().setText("");
        vista.getLabel_foto().setIcon(null);

    }

    public Integer obtenerCodigoActual() {
        List<Integer> lista = bdpersona.obtenerCodigoActual();
        return lista.get(0) + 1;

    }

    public void obtenerlab() {
//        List<String> listar = new ArrayList<String>();
        vista.getCombo_lab().removeAllItems();
//        listar.addAll(lista.get(0));
for (int i = 0; i < listap.size(); i++) {
               
                 vista.getCombo_lab().addItem(listap.get(i));
        }
    }

     public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/producto.jasper"));
            JasperPrint jp = (JasperPrint)JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(cpersona.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
