
package Papeleria_Bella.controlador;

import static Papeleria_Bella.controlador.Cpersona.vista;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Crol {
    public static Vrol vista;
    
    private RolBD brol = new RolBD();
    
    public Crol(Vrol vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        CodigoRol();
        lista();
        vista.getButtonguardar().addActionListener(x -> guardar());
        vista.getButtonbuscar().addActionListener(e -> buscar());
        vista.getButtonmodificar().addActionListener(e -> modificar());
        vista.getButtonimprimir().addActionListener(e -> imprimir());
        vista.getTablarol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        
        vista.getButtonnuevo().addActionListener(e -> nuevo());
        vista.getButtoneliminar().addActionListener(e -> eliminar());
        vista.getButtonguardar().setEnabled(false);
        vista.getButtonmodificar().setEnabled(false);
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        List<RolMD> lista = brol.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }
    
    public void guardar() {
        brol.setCodigo(vista.getLabelcodigo().getText());
        brol.setNombre(vista.getTxtnombre().getText());
        brol.setDescripcion(vista.getTxtdescripcion().getText());
        brol.setEstado(vista.getComboestado().getSelectedItem().toString());

        if (brol.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }
    public void modificar() {
        brol.setCodigo(vista.getLabelcodigo().getText());
        brol.setNombre(vista.getTxtnombre().getText());
        brol.setDescripcion(vista.getTxtdescripcion().getText());
        String estado = (String) vista.getComboestado().getSelectedItem();
        brol.setEstado(estado);
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (brol.modificar(vista.getLabelcodigo().getText())) ;
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                
            }
    }
    
    public void seleccionar() {
        vista.getButtonguardar().setEnabled(false);
        vista.getButtonmodificar().setEnabled(true);
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        String codigo = (String) modelo.getValueAt(vista.getTablarol().getSelectedRow(), 0);
        List<RolMD> lista = brol.obtenerdatos(codigo);
        brol.setCodigo(lista.get(0).getCodigo());
        vista.getLabelcodigo().setText(brol.getCodigo());
        brol.setNombre(lista.get(0).getNombre());
        vista.getTxtnombre().setText(brol.getNombre());
        brol.setDescripcion(lista.get(0).getDescripcion());
        vista.getTxtdescripcion().setText(brol.getDescripcion());
        brol.setEstado(lista.get(0).getEstado());
        vista.getComboestado().setSelectedItem(brol.getEstado());   
    }
    public void eliminar(){
        brol.setCodigo(vista.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  "+vista.getLabelcodigo().getText());
        if (resp == 0) {
            if (brol.eliminar(vista.getLabelcodigo().getText())) ;
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                
            }
    } 
    public void nuevo(){
        vista.getLabelcodigo().setText("");
        vista.getTxtnombre().setText("");
        vista.getTxtdescripcion().setText("");
        vista.getComboestado().setSelectedItem("");
        vista.getButtonguardar().setEnabled(true);
        vista.getButtonmodificar().setEnabled(false);
        CodigoRol();
    }
    public void CodigoRol() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vista.getLabelcodigo().setText("R0" + buffer.toString());
    }

    private void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vista.getTablarol().getModel();
            java.util.List<RolMD> lista = brol.buscardatos(vista.getTxtbuscar().getText());
            int columnas = model.getColumnCount();
            for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                    model.addRow(new Object[columnas]);
                    vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
                    vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
                    vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
                    vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);
            }
        }
    
    }
    private void imprimir_sinparametro() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "imagen/persona.png");
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void imprimir_unparametro() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona1.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            String nombre =JOptionPane.showInputDialog("Imprimir el parametro elegido");
            map.put("logo", "imagen/persona1.png");
            map.put("valor", nombre);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void imprimir_dosparametro() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona2.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "imagen/persona2.png");
            String nombre =JOptionPane.showInputDialog("Imprimir el primer parámetro");
            String placa =JOptionPane.showInputDialog("Imprimir el segundo parámetro");
            map.put("valor", nombre);
            map.put("placa", placa);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void imprimir_todo() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "imagen/persona.png");
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Imprimiendo personas");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public void imprimir() {
        int opcion=Integer.parseInt(JOptionPane.showInputDialog("Escoja una opción: \n1. Imprimir un parametro \n2. Imprimir dos parametros \n 3. Imprimir todo "));
    
    switch(opcion){
    
        case 1: 
            imprimir_unparametro();
             break;
            
        case 2: 
            imprimir_dosparametro();
            break;
            
        case 3: 
            imprimir_todo();
            break;
            
        default:
            JOptionPane.showConfirmDialog(null, "No Escogio una opción correcta");
    }
    }
}
