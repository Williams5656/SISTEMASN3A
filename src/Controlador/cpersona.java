/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conect;
import Modelo.personaBD;
import Modelo.personaMD;
import Vista.vpersona;
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
public class cpersona {

    public static vpersona vista;

    private personaBD bdpersona = new personaBD();

    public cpersona(vpersona vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();
        validar();

        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtnimprimir().addActionListener(e -> imprimir());
        vista.getBtn_foto().addActionListener(e -> foto());
        vista.getTxt_buscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }
        });

        vista.getTabla_persona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
                imprimir();
            }
        });

        vista.getTxt_cedula().setEnabled(false);
        vista.getTxt_nombres().setEnabled(false);
        vista.getTxt_direccion().setEnabled(false);
        vista.getTxt_telefono().setEnabled(false);
        vista.getTxt_correo().setEnabled(false);
        vista.getTxt_calendar().setEnabled(false);
        
        vista.getBtn_foto().setEnabled(false);
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
    }

    private void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_persona().getModel();

        List<personaMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vista.getTabla_persona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_persona().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTabla_persona().setValueAt(lista.get(i).getNombres(), i, 1);
            vista.getTabla_persona().setValueAt(lista.get(i).getDireccion(), i, 2);
            vista.getTabla_persona().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTabla_persona().setValueAt(lista.get(i).getCorreo(), i, 4);
            vista.getTabla_persona().setValueAt(lista.get(i).getFechanac(), i, 5);
//            vista.getTabla_persona().setValueAt(lista.get(i).getFoto(), i, 6);
        }

    }

    private void nuevo() {
        limpiar();
        vista.getTxt_cedula().setEnabled(true);
        vista.getTxt_nombres().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_correo().setEnabled(true);
        vista.getTxt_calendar().setEnabled(true);
        vista.getBtn_foto().setEnabled(true);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtnimprimir().setEnabled(true);

    }

    private void guardar() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        personaMD mdPersona=bdpersona.obtenerPersonaPorCedula(vista.getTxt_cedula().getText());
        if(mdPersona==null){
            bdpersona.setCedula(vista.getTxt_cedula().getText());
            bdpersona.setNombres(vista.getTxt_nombres().getText());
            bdpersona.setDireccion(vista.getTxt_direccion().getText());
            bdpersona.setTelefono(vista.getTxt_telefono().getText());
            bdpersona.setCorreo(vista.getTxt_correo().getText());
            bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
            ImageIcon ic = (ImageIcon) vista.getFoto().getIcon();
            bdpersona.setFoto(ic.getImage());

            if (bdpersona.insertar()) {
                JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
                lista();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
        } else{
            JOptionPane.showMessageDialog(null, "YA EXISTE UNA PERSONA CON ESTA CEDULA");
        }
        

    }

    private void modificar() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        bdpersona.setCedula(vista.getTxt_cedula().getText());
        bdpersona.setNombres(vista.getTxt_nombres().getText());
        bdpersona.setDireccion(vista.getTxt_direccion().getText());
        bdpersona.setTelefono(vista.getTxt_telefono().getText());
        bdpersona.setCorreo(vista.getTxt_correo().getText());
        bdpersona.setFechanac(f.format(vista.getTxt_calendar().getDate()));
        ImageIcon ic = (ImageIcon) vista.getFoto().getIcon();
        bdpersona.setFoto(ic.getImage());

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0) {
            if (bdpersona.modificar(vista.getTxt_cedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }

    }

    private void eliminar() {
        bdpersona.setCedula(vista.getTxt_cedula().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este uduario " + vista.getTxt_cedula().getText());
        if (respuesta == 0) {
            if (bdpersona.eliminar(vista.getTxt_cedula().getText())) {
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
        if (vista.getTxt_buscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_persona().getModel();

            List<personaMD> lista = bdpersona.obtenerDatos(vista.getTxt_buscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_persona().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_persona().setValueAt(lista.get(i).getCedula(), i, 0);
                vista.getTabla_persona().setValueAt(lista.get(i).getNombres(), i, 1);
                vista.getTabla_persona().setValueAt(lista.get(i).getDireccion(), i, 2);
                vista.getTabla_persona().setValueAt(lista.get(i).getTelefono(), i, 3);
                vista.getTabla_persona().setValueAt(lista.get(i).getCorreo(), i, 4);
                vista.getTabla_persona().setValueAt(lista.get(i).getFechanac(), i, 5);
                vista.getTabla_persona().setValueAt(lista.get(i).getFoto(), i, 6);
                //}
            }
        }

    }

    private void seleccionar() {
        vista.getTxt_cedula().setEnabled(true);
        vista.getTxt_nombres().setEnabled(true);
        vista.getTxt_direccion().setEnabled(true);
        vista.getTxt_telefono().setEnabled(true);
        vista.getTxt_correo().setEnabled(true);
        vista.getTxt_calendar().setEnabled(true);
        vista.getBtn_foto().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_persona().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTabla_persona().getSelectedRow(), 0);

        List<personaMD> lista = bdpersona.obtenerDatos(cedula);

        bdpersona.setCedula(lista.get(0).getCedula());
        vista.getTxt_cedula().setText(bdpersona.getCedula());

        bdpersona.setNombres(lista.get(0).getNombres());
        vista.getTxt_nombres().setText(bdpersona.getNombres());

        bdpersona.setDireccion(lista.get(0).getDireccion());
        vista.getTxt_direccion().setText(bdpersona.getDireccion());

        bdpersona.setTelefono(lista.get(0).getTelefono());
        vista.getTxt_telefono().setText(bdpersona.getTelefono());

        bdpersona.setCorreo(lista.get(0).getCorreo());
        vista.getTxt_correo().setText(bdpersona.getCorreo());

        bdpersona.setFechanac(lista.get(0).getFechanac());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(bdpersona.getFechanac());
            vista.getTxt_calendar().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

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
        vista.getTxt_cedula().setText("");
        vista.getTxt_nombres().setText("");
        vista.getTxt_direccion().setText("");
        vista.getTxt_telefono().setText("");
        vista.getTxt_correo().setText("");
        vista.getTxt_calendar().setCalendar(null);
        vista.getFoto().setIcon(null);

    }
    
    
    private void validar(){
        Validaciones.Numeros.solo_numeros(vista.getTxt_cedula());
        Validaciones.Letras.solo_letras(vista.getTxt_nombres());
        
        
    }
    
     public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/persona.jasper"));
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
