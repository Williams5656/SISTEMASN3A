/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hertz.Controlador;

import Hertz.Modelo.*;
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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CEmpresa {
    public static VEmpresa vista;
    
    private EmpresaBD bdEmpresa = new EmpresaBD();

    public CEmpresa(VEmpresa vista) {
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
        
        vista.getTablaPersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
        
        
        vista.getTxtNombre().setEnabled(false);
        vista.getTxtCiudad().setEnabled(false);
        vista.getTxtDireccion().setEnabled(false);
        vista.getTxtCelular().setEnabled(false);
        vista.getTxtEmail().setEnabled(false);
        vista.getBtnFoto().setEnabled(false);
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        
    }//Fin del constructor
    
    public void nuevo(){
        limpiar();
        vista.getTxtNombre().setEnabled(true);
        vista.getTxtRuc().setEnabled(true);
        vista.getTxtCiudad().setEnabled(true);
        vista.getTxtDireccion().setEnabled(true);
        vista.getTxtCelular().setEnabled(true);
        vista.getTxtEmail().setEnabled(true);
        vista.getComboEstado().setEnabled(true);
        vista.getBtnFoto().setEnabled(true);
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
    }
    
    public void limpiar(){
        
        vista.getTxtNombre().setText("");
        vista.getTxtRuc().setText("");
        vista.getTxtCiudad().setText("");
        vista.getTxtDireccion().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtEmail().setText("");
        vista.getComboEstado().setSelectedIndex(0);
        vista.getLbFoto().setIcon(null);
    }
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaempresa().getModel();
        
        List<EmpresaMD> lista = bdEmpresa.mostrardatos();
        int columnas = modelo.getColumnCount();
        
//**************** Limpiar en decremento   ************************

        for (int j = vista.getTablaempresa().getRowCount()-1; j >= 0; j--){
            modelo.removeRow(j);
        }

//*******************************************************************
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            
            vista.getTablaempresa().setValueAt(lista.get(i).getRuc(), i, 0);
            vista.getTablaempresa().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablaempresa().setValueAt(lista.get(i).getCiudad(), i, 2);
            vista.getTablaempresa().setValueAt(lista.get(i).getDireccion(), i, 3);
            vista.getTablaempresa().setValueAt(lista.get(i).getCelular(), i, 4);
            vista.getTablaempresa().setValueAt(lista.get(i).getEmail(), i, 5);
            vista.getTablaempresa().setValueAt(lista.get(i).getEstado(), i, 6);
            vista.getTablaempresa().setValueAt(lista.get(i).getFoto(), i, 7);
        }
    }//Fin de Lista
    
    public void guardar(){
        
        //SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        
        
        bdEmpresa.setNombre(vista.getTxtNombre().getText());
        bdEmpresa.setRuc(vista.getTxtRuc().getText());
        bdEmpresa.setCiudad(vista.getTxtCiudad().getText());
        bdEmpresa.setDireccion(vista.getTxtDireccion().getText());
        bdEmpresa.setEmail(vista.getTxtEmail().getText());
        bdEmpresa.setCelular(vista.getTxtCelular().getText());
        bdEmpresa.setEstado(vista.getComboEstado().getSelectedItem().toString());
        
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        bdEmpresa.setFoto(ic.getImage());
        
        if (bdEmpresa.insertar()){
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
           modelo = (DefaultTableModel) vista.getTablaempresa().getModel();
        
            List<EmpresaMD> lista = bdEmpresa.obtenerDatos(vista.getTxtBuscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTablaempresa().getRowCount()-1; j >= 0; j--){
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                
                vista.getTablaempresa().setValueAt(lista.get(i).getRuc(), i, 0);
                vista.getTablaempresa().setValueAt(lista.get(i).getNombre(), i, 1);
                vista.getTablaempresa().setValueAt(lista.get(i).getCiudad(), i, 2);
                vista.getTablaempresa().setValueAt(lista.get(i).getDireccion(), i, 3);
                vista.getTablaempresa().setValueAt(lista.get(i).getCelular(), i, 4);
                vista.getTablaempresa().setValueAt(lista.get(i).getEmail(), i, 5);
                vista.getTablaempresa().setValueAt(lista.get(i).getEstado(), i, 6);
                vista.getTablaempresa().setValueAt(lista.get(i).getFoto(), i, 7);
                //}
        }
       }
    }//Fin de Buscar
    

    
    public void modificar(){
        
        //SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        
       
        bdEmpresa.setNombre(vista.getTxtNombre().getText());
        bdEmpresa.setRuc(vista.getTxtRuc().getText());
        bdEmpresa.setCiudad(vista.getTxtCiudad().getText());
        bdEmpresa.setDireccion(vista.getTxtDireccion().getText());
        bdEmpresa.setCelular(vista.getTxtCelular().getText());
        bdEmpresa.setEmail(vista.getTxtEmail().getText());
        bdEmpresa.setEstado(vista.getComboEstado().getSelectedItem().toString());
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        bdEmpresa.setFoto(ic.getImage());
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0){
            if (bdEmpresa.modificar(vista.getTxtRuc().getText())){
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
                Logger.getLogger(CEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void seleccionar(){
        
        vista.getTxtNombre().setEnabled(true);
        vista.getTxtRuc().setEnabled(true);
        vista.getTxtCiudad().setEnabled(true);
        vista.getTxtDireccion().setEnabled(true);
        vista.getTxtCelular().setEnabled(true);
        vista.getTxtEmail().setEnabled(true);
        vista.getComboEstado().setEnabled(true);
        vista.getBtnFoto().setEnabled(true);
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
        vista.getTxtBuscar().setText("");
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaempresa().getModel();
        String ruc = (String) modelo.getValueAt(vista.getTablaempresa().getSelectedRow(), 0);
        
        List<EmpresaMD> lista = bdEmpresa.obtenerDatos(ruc);
        
        
        
        bdEmpresa.setRuc(lista.get(0).getRuc());
        vista.getTxtRuc().setText(bdEmpresa.getRuc());
        
        bdEmpresa.setNombre(lista.get(0).getNombre());
        vista.getTxtNombre().setText(bdEmpresa.getNombre());
        
        bdEmpresa.setCiudad(lista.get(0).getCiudad());
        vista.getTxtCiudad().setText(bdEmpresa.getCiudad());
        
        bdEmpresa.setDireccion(lista.get(0).getDireccion());
        vista.getTxtDireccion().setText(bdEmpresa.getDireccion());
        
        bdEmpresa.setCelular(lista.get(0).getCelular());
        vista.getTxtCelular().setText(bdEmpresa.getCelular());
        
        bdEmpresa.setEmail(lista.get(0).getEmail());
        vista.getTxtEmail().setText(bdEmpresa.getEmail());
        
        bdEmpresa.setEstado(lista.get(0).getEstado());
        vista.getComboEstado().setSelectedItem(bdEmpresa.getEstado());
        
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
        bdEmpresa.setRuc(vista.getTxtRuc().getText());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta empresa " + vista.getTxtRuc().getText() );
        if (respuesta == 0){
            if (bdEmpresa.eliminar(vista.getTxtRuc().getText())){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }//Fin de eliminar
    
    private void imprimir(){
        
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
                map.put("cedula", vista.getTxtRuc().getText());
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
    }
    
}//Fin de la clase