/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conect;
import Modelo.proveedorBD;
import Modelo.proveedorMD;
import Vista.vproveedor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class cproveedor {

    public static vproveedor vista;

    private proveedorBD bdpv = new proveedorBD();

    public cproveedor(vproveedor vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();

        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtnimprimir().addActionListener(e -> imprimir());

        vista.getTxt_buscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTabla_pro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
                imprimir();
            }
        });

        vista.getTxt_codfigo().setEnabled(false);
        vista.getTxt_laboratorio().setEnabled(false);
        vista.getTxt_ruc().setEnabled(false);
        vista.getTxt_telefono().setEnabled(false);
        vista.getTxt_encargado().setEnabled(false);
        vista.getTxt_pagina().setEnabled(false);
        vista.getTxt_direccion().setEnabled(false);
        vista.getTxt_correo().setEnabled(false);

        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);

    }

    public void nuevo() {
        limpiar();

        vista.getTxt_codfigo().setEnabled(false);
        vista.getTxt_laboratorio().setEnabled(true);
        vista.getTxt_ruc().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_encargado().setEnabled(true);
        vista.getTxt_pagina().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);
        vista.getTxt_correo().setEnabled(true);

        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
        vista.getTxt_codfigo().setText(obtenerCodigoActual() + "");
    }

    public Integer obtenerCodigoActual() {
        List<Integer> lista = bdpv.obtenerCodigoActual();
        return lista.get(0) + 1;

    }

    public void limpiar() {
        vista.getTxt_codfigo().setText("");
        vista.getTxt_laboratorio().setText("");
        vista.getTxt_ruc().setText("");
        vista.getTxt_telefono().setText("");
        vista.getTxt_encargado().setText("");
        vista.getTxt_pagina().setText("");
        vista.getTxt_direccion().setText("");
        vista.getTxt_correo().setText("");
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_pro().getModel();

        List<proveedorMD> lista = bdpv.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_pro().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        
        
        for (int i = 0; i < lista.size(); i++) {
//             try {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_pro().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_pro().setValueAt(lista.get(i).getLaboratorio(), i, 1);
            vista.getTabla_pro().setValueAt(lista.get(i).getRuc(), i, 2);
            vista.getTabla_pro().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTabla_pro().setValueAt(lista.get(i).getEncargado(), i, 4);
            vista.getTabla_pro().setValueAt(lista.get(i).getPaginaweb(), i, 5);
            vista.getTabla_pro().setValueAt(lista.get(i).getDireccion(), i, 6);
            vista.getTabla_pro().setValueAt(lista.get(i).getCorreo(), i, 7);
//            } catch (Exception e) {
//                
//            }
                
//            }
        }
    }

    public void guardar() {

//        bdpv.setCodigo(Integer.parseInt(vista.getTxt_codfigo().getText()));
        bdpv.setCodigo(vista.getTxt_codfigo().getText());
        bdpv.setLaboratorio(vista.getTxt_laboratorio().getText());
        bdpv.setRuc(vista.getTxt_ruc().getText());
        bdpv.setTelefono(vista.getTxt_telefono().getText());
        bdpv.setEncargado(vista.getTxt_encargado().getText());
        bdpv.setPaginaweb(vista.getTxt_pagina().getText());
        bdpv.setDireccion(vista.getTxt_direccion().getText());
        bdpv.setCorreo(vista.getTxt_correo().getText());

        if (bdpv.insertar()) {
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
            modelo = (DefaultTableModel) vista.getTabla_pro().getModel();

            List<proveedorMD> lista = bdpv.obtenerDatosPornombre(vista.getTxt_buscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_pro().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_pro().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_pro().setValueAt(lista.get(i).getLaboratorio(), i, 1);
            vista.getTabla_pro().setValueAt(lista.get(i).getRuc(), i, 2);
            vista.getTabla_pro().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTabla_pro().setValueAt(lista.get(i).getEncargado(), i, 4);
            vista.getTabla_pro().setValueAt(lista.get(i).getPaginaweb(), i, 5);
            vista.getTabla_pro().setValueAt(lista.get(i).getDireccion(), i, 6);
            vista.getTabla_pro().setValueAt(lista.get(i).getCorreo(), i, 7);
            
            }
        }
    }

    public void modificar() {

        bdpv.setCodigo(vista.getTxt_codfigo().getText());
        bdpv.setLaboratorio(vista.getTxt_laboratorio().getText());
        bdpv.setRuc(vista.getTxt_ruc().getText());
        bdpv.setTelefono(vista.getTxt_telefono().getText());
        bdpv.setEncargado(vista.getTxt_encargado().getText());
        bdpv.setPaginaweb(vista.getTxt_pagina().getText());
        bdpv.setDireccion(vista.getTxt_direccion().getText());
        bdpv.setCorreo(vista.getTxt_correo().getText());
        

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdpv.modificar(Integer.parseInt(vista.getTxt_codfigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }

    public void seleccionar() {
        
        vista.getTxt_codfigo().setEnabled(false);
        vista.getTxt_laboratorio().setEnabled(true);
        vista.getTxt_ruc().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_encargado().setEnabled(true);
        vista.getTxt_pagina().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);
        vista.getTxt_correo().setEnabled(true);
        
        
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_pro().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTabla_pro().getSelectedRow(), 0);

         List<proveedorMD> lista = bdpv.obtenerDatos(codigo);

        bdpv.setCodigo(lista.get(0).getCodigo());
        vista.getTxt_codfigo().setText(bdpv.getCodigo());

        bdpv.setLaboratorio(lista.get(0).getLaboratorio());
        vista.getTxt_laboratorio().setText(bdpv.getLaboratorio());

        bdpv.setRuc(lista.get(0).getRuc());
        vista.getTxt_ruc().setText(bdpv.getRuc());

        bdpv.setTelefono(lista.get(0).getTelefono());
        vista.getTxt_telefono().setText(bdpv.getTelefono());
        
        bdpv.setEncargado(lista.get(0).getEncargado());
        vista.getTxt_encargado().setText(bdpv.getEncargado());
        
        bdpv.setPaginaweb(lista.get(0).getPaginaweb());
        vista.getTxt_pagina().setText(bdpv.getPaginaweb());
        
        bdpv.setDireccion(lista.get(0).getDireccion());
        vista.getTxt_direccion().setText(bdpv.getDireccion());
        
        bdpv.setCorreo(lista.get(0).getCorreo());
        vista.getTxt_correo().setText(bdpv.getCorreo());
    }

    public void eliminar() {
        bdpv.setCodigo(vista.getTxt_codfigo().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este rol " + vista.getTxt_codfigo().getText());
        if (respuesta == 0) {
            if (bdpv.eliminar(Integer.parseInt(vista.getTxt_codfigo().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }
     public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/proveedor.jasper"));
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
