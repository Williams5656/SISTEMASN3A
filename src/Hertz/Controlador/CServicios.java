/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hertz.Controlador;

import Hertz.Modelo.*;
import Hertz.Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class CServicios {
    public static VServicios vista;
    
    private ServiciosBD bdservicios = new ServiciosBD();

    public CServicios(VServicios vista) {
        this.vista = vista;
        
        vista.setVisible(true);
 
        lista();
        
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnFoto().addActionListener(e -> obtieneImagen());
        
        vista.getTxtBuscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }        
        });
        
        vista.getTablaServicios().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
       
        vista.getComboNombre().setEnabled(false);
        vista.getTxtDescripcion().setEnabled(false);
        vista.getTxtActividad().setEnabled(false);
        vista.getTxtRecursos().setEnabled(false);
        vista.getTxtPrecio().setEnabled(false);
        vista.getBtnFoto().setEnabled(false);
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        
    }//Fin del constructor
    
    public void nuevo(){
        limpiar();
        vista.getTxtCodigo().setEnabled(true);
        vista.getComboNombre().setEnabled(true);
        vista.getTxtDescripcion().setEnabled(true);
        vista.getTxtActividad().setEnabled(true);
        vista.getTxtRecursos().setEnabled(true);
        vista.getTxtPrecio().setEnabled(true);
        vista.getBtnFoto().setEnabled(true);
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
    }
    
    public void limpiar(){
        
        vista.getTxtCodigo().setText("");
        vista.getComboNombre().setSelectedIndex(0);
        vista.getTxtDescripcion().setText("");
        vista.getTxtActividad().setText("");
        vista.getTxtRecursos().setText("");
        vista.getTxtPrecio().setText("");
        vista.getLbFoto().setIcon(null);
    }
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaServicios().getModel();
        
        List<ServiciosMD> lista = bdservicios.mostrardatos();
        int columnas = modelo.getColumnCount();
        
//**************** Limpiar en decremento   ************************

        for (int j = vista.getTablaServicios().getRowCount()-1; j >= 0; j--){
            modelo.removeRow(j);
        }

//*******************************************************************
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            
            vista.getTablaServicios().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablaServicios().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablaServicios().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTablaServicios().setValueAt(lista.get(i).getActividad(), i, 3);
            vista.getTablaServicios().setValueAt(lista.get(i).getRecursos(), i, 4);
            vista.getTablaServicios().setValueAt(lista.get(i).getPrecio(), i, 5);
            vista.getTablaServicios().setValueAt(lista.get(i).getFoto(), i, 6);
        }
    }//Fin de Lista
    
    public void guardar(){
        
        //SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        
        
        bdservicios.setCodigo(vista.getTxtCodigo().getText());
        bdservicios.setNombre(vista.getComboNombre().getSelectedItem().toString());
        bdservicios.setDescripcion(vista.getTxtDescripcion().getText());
        bdservicios.setActividad(vista.getTxtActividad().getText());
        bdservicios.setRecursos(vista.getTxtRecursos().getText());
        bdservicios.setPrecio(vista.getTxtPrecio().getText());
                
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        bdservicios.setFoto(ic.getImage());
        
        if (bdservicios.insertar()){
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
            limpiar();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }//Fin del Guardar
    
    public void buscar(){
       if(vista.getTxtBuscar().getText().equals("")){
           lista();
       }
       else{
           DefaultTableModel modelo;
           modelo = (DefaultTableModel) vista.getTablaServicios().getModel();
        
            List<ServiciosMD> lista = bdservicios.obtenerDatos(vista.getTxtBuscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTablaServicios().getRowCount()-1; j >= 0; j--){
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                
                vista.getTablaServicios().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTablaServicios().setValueAt(lista.get(i).getNombre(), i, 1);
                vista.getTablaServicios().setValueAt(lista.get(i).getDescripcion(), i, 2);
                vista.getTablaServicios().setValueAt(lista.get(i).getActividad(), i, 3);
                vista.getTablaServicios().setValueAt(lista.get(i).getRecursos(), i, 4);
                vista.getTablaServicios().setValueAt(lista.get(i).getPrecio(), i, 5);
                vista.getTablaServicios().setValueAt(lista.get(i).getFoto(), i, 6);
                //}
        }
       }
    }//Fin de Buscar
    

    
    public void modificar(){
        
        //SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        
       
        bdservicios.setCodigo(vista.getTxtCodigo().getText());
        bdservicios.setNombre(vista.getComboNombre().getSelectedItem().toString());
        bdservicios.setDescripcion(vista.getTxtDescripcion().getText());
        bdservicios.setActividad(vista.getTxtActividad().getText());
        bdservicios.setRecursos(vista.getTxtRecursos().getText());
        bdservicios.setPrecio(vista.getTxtPrecio().getText());
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        bdservicios.setFoto(ic.getImage());
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0){
            if (bdservicios.modificar(vista.getTxtCodigo().getText())){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }        
    }//Fin del modificar
    
    private void obtieneImagen() {
        vista.getLbFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLbFoto().setIcon(new ImageIcon(icono));
                vista.getLbFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void seleccionar(){
        
        vista.getTxtCodigo().setEnabled(true);
        vista.getComboNombre().setEnabled(true);
        vista.getTxtDescripcion().setEnabled(true);
        vista.getTxtActividad().setEnabled(true);
        vista.getTxtRecursos().setEnabled(true);
        vista.getTxtPrecio().setEnabled(true);
        vista.getBtnFoto().setEnabled(true);
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
        vista.getTxtBuscar().setText("");
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaServicios().getModel();
        String codigo = (String) modelo.getValueAt(vista.getTablaServicios().getSelectedRow(), 0);
        
        List<ServiciosMD> lista = bdservicios.obtenerDatos(codigo);
        
        
        
        bdservicios.setCodigo(lista.get(0).getCodigo());
        vista.getTxtCodigo().setText(bdservicios.getCodigo());
        
        bdservicios.setNombre(lista.get(0).getNombre());
        vista.getComboNombre().setSelectedItem(bdservicios.getNombre());
        
        bdservicios.setDescripcion(lista.get(0).getDescripcion());
        vista.getTxtDescripcion().setText(bdservicios.getDescripcion());
        
        bdservicios.setActividad(lista.get(0).getActividad());
        vista.getTxtActividad().setText(bdservicios.getActividad());
        
        bdservicios.setRecursos(lista.get(0).getRecursos());
        vista.getTxtRecursos().setText(bdservicios.getRecursos());
        
        bdservicios.setPrecio(lista.get(0).getPrecio());
        vista.getTxtPrecio().setText(bdservicios.getPrecio());
        
                
        /*bdEmpresa.setFechaNac(lista.get(0).getFechaNac());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(bdPersona.getFechaNac());
            vista.getTxtCalendario().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }*/
        
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLbFoto().setIcon(icon);
        } else {
            vista.getLbFoto().setIcon(null);
        }
    }//Fin del seleccionar
    
    public void eliminar(){
        bdservicios.setCodigo(vista.getTxtCodigo().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta empresa " + vista.getTxtCodigo().getText() );
        if (respuesta == 0){
            if (bdservicios.eliminar(vista.getTxtCodigo().getText())){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }//Fin de eliminar
    
    /*private void imprimir(){
        
        Conect con = new Conect();
        
        if(vista.getTxtBuscar().getText().equals("")){
            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/HertzReportes/PersonasTodo.jasper"));
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("logo","Hertz\\Imagenes\\logoHertz.png");
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true); 
            } 
            catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(CPersona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else {
            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/HertzReportes/PersonaFiltro.jasper"));
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("logo","Hertz\\Imagenes\\logoHertz.png");
                //String cedula = JOptionPane.showInputDialog("Ingresar cedula");
                map.put("cedula", vista.getTxtCedula().getText());
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true); 
               } 
            catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(CPersona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }*/
    
}//Fin de la clase