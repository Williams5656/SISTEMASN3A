/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conect;
import Modelo.productoMD;
import Modelo.productoBD;
import Vista.vproductos;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author A
 */
public class cproductos {
     public static vproductos vista;

    private productoBD bdpersona = new productoBD();

    public cproductos(vproductos vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();

        vista.getBtnnuevo01().addActionListener(e -> nuevo());
        vista.getBtnguardar01().addActionListener(e -> guardar());
        vista.getBtnmodificar01().addActionListener(e -> modificar());
        vista.getBtneliminar01().addActionListener(e -> eliminar());
//        vista.getBtnimprimirp().addActionListener(e -> imprimir());
        vista.getBtnfoto().addActionListener(e -> foto());
        vista.getTxtbuscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTablaproductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });

        vista.getTxtid().setEnabled(false);
        vista.getTxtnomproductos().setEnabled(false);
        vista.getTxtdescripcion().setEnabled(false);
        vista.getBtnfoto().setEnabled(false);
        vista.getBtnguardar01().setEnabled(false);
        vista.getBtnbuscar01().setEnabled(false);
        vista.getBtnmodificar01().setEnabled(false);
        vista.getBtneliminar01().setEnabled(false);
    }

    private void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaproductos().getModel();

        List<productoMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTablaproductos().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaproductos().setValueAt(lista.get(i).getId_producto(), i, 0);
            vista.getTablaproductos().setValueAt(lista.get(i).getNombre_pro(), i, 1);
            vista.getTablaproductos().setValueAt(lista.get(i).getDescripcion_pro(), i, 2);
            vista.getTablaproductos().setValueAt(lista.get(i).getFoto(), i, 3);
        }

    }

    private void nuevo() {
        limpiar();
        vista.getTxtid().setEnabled(true);
        vista.getTxtnomproductos().setEnabled(true);
        vista.getTxtdescripcion().setEnabled(true);
        vista.getBtnfoto().setEnabled(true);
        vista.getBtnguardar01().setEnabled(true);
        vista.getBtnbuscar01().setEnabled(true);
        vista.getBtnmodificar01().setEnabled(true);
        vista.getBtneliminar01().setEnabled(true);

    }
//      public void imprimir() {
//        Conect con = new Conect();
////        
//        try {
//            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepAutos.jasper"));
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("logo", "imagenes/991231.jpg");
//            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
//            JasperViewer jv = new JasperViewer(jp, false);
//            JOptionPane.showMessageDialog(null, "Imprimiendo Autos");
//            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            jv.setVisible(true);
//        } catch (JRException e) {
//            System.out.println("no se pudo encontrar registros" + e.getMessage());
//            Logger.getLogger(cproductos.class.getName()).log(Level.SEVERE, null, e);
//        }
//
//    }

    private void guardar() {
       // SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setId_producto(vista.getTxtid().getText());
        bdpersona.setNombre_pro(vista.getTxtnomproductos().getText());
        bdpersona.setDescripcion_pro(vista.getTxtdescripcion().getText());
        //bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
        ImageIcon ic = (ImageIcon) vista.getFoto().getIcon();
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

        bdpersona.setId_producto(vista.getTxtid().getText());
        bdpersona.setNombre_pro(vista.getTxtnomproductos().getText());
        bdpersona.setDescripcion_pro(vista.getTxtdescripcion().getText());
        //bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
        ImageIcon ic = (ImageIcon) vista.getFoto().getIcon();
        bdpersona.setFoto(ic.getImage());

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdpersona.modificar(vista.getTxtid().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }

    }

    private void eliminar() {
        bdpersona.setId_producto(vista.getTxtid().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este uduario " + vista.getTxtid().getText());
        if (respuesta == 0) {
            if (bdpersona.eliminar(vista.getTxtid().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    private void foto() {
        vista.getFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getFoto().getWidth(), vista.getFoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getFoto().setIcon(new ImageIcon(icono));
                vista.getFoto().updateUI();
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
            modelo = (DefaultTableModel) vista.getTablaproductos().getModel();

            List<productoMD> lista = bdpersona.obtenerDatos(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTablaproductos().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTablaproductos().setValueAt(lista.get(i).getId_producto(), i, 0);
                vista.getTablaproductos().setValueAt(lista.get(i).getNombre_pro(), i, 1);
                vista.getTablaproductos().setValueAt(lista.get(i).getDescripcion_pro(), i, 2);
                vista.getTablaproductos().setValueAt(lista.get(i).getFoto(), i, 6);
                
            }
        }

    }

    private void seleccionar() {
        vista.getTxtid().setEnabled(true);
        vista.getTxtnomproductos().setEnabled(true);
        vista.getTxtdescripcion().setEnabled(true);
        vista.getBtnfoto().setEnabled(true);
        vista.getBtnguardar01().setEnabled(false);
        vista.getBtnmodificar01().setEnabled(true);
        vista.getBtneliminar01().setEnabled(true);
        vista.getBtnbuscar01().setEnabled(true);
        vista.getTxtbuscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaproductos().getModel();
        String id_producto = (String) modelo.getValueAt(vista.getTablaproductos().getSelectedRow(), 0);

        List<productoMD> lista = bdpersona.obtenerDatos(id_producto);

        bdpersona.setId_producto(lista.get(0).getId_producto());
        vista.getTxtid().setText(bdpersona.getId_producto());
        bdpersona.setNombre_pro(lista.get(0).getNombre_pro());
        vista.getTxtnomproductos().setText(bdpersona.getNombre_pro());
        bdpersona.setDescripcion_pro(lista.get(0).getDescripcion_pro());
        vista.getTxtdescripcion().setText(bdpersona.getDescripcion_pro());
       
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
            Image newimg = img.getScaledInstance(vista.getFoto().getWidth(), vista.getFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getFoto().setIcon(icon);
        } else {
            vista.getFoto().setIcon(null);
        }

    }

    private void limpiar() {
        vista.getTxtid().setText("");
        vista.getTxtnomproductos().setText("");
        vista.getTxtdescripcion().setText("");
        //vista.getTxt_calendar().setCalendar(null);
        vista.getFoto().setIcon(null);

    }
    
}