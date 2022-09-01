/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.rolBD;
import Modelo.rolMD;
import Vista.vrol;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VICO5
 */
public class crol {
    public static vrol vista;
    
    private rolBD bdRol = new rolBD();

    public crol(vrol vista) {
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
        
        vista.getTabla_rol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
        
        vista.getTxt_codigo().setEnabled(false);
        vista.getTxt_nombre().setEnabled(false);
        vista.getTxt_descripcion().setEnabled(false);
        vista.getCombo_estado().setEnabled(false);
        
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        
    }
    
    public void nuevo(){
        limpiar();
        vista.getTxt_codigo().setEnabled(true);
        vista.getTxt_nombre().setEnabled(true);
        vista.getTxt_descripcion().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
    }
    
    public void limpiar(){
        vista.getTxt_codigo().setText("");
        vista.getTxt_nombre().setText("");
        vista.getTxt_descripcion().setText("");
        vista.getCombo_estado().setSelectedIndex(0);
    }
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_rol().getModel();
        
        List<rolMD> lista = bdRol.mostrardatos();
        int columnas = modelo.getColumnCount();
        


        for (int j = vista.getTabla_rol().getRowCount()-1; j >= 0; j--){
            modelo.removeRow(j);
        }


        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_rol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_rol().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTabla_rol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTabla_rol().setValueAt(lista.get(i).getEstado(), i, 3);
        }
    }
    
    public void guardar(){
        
        bdRol.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdRol.setNombre(vista.getTxt_nombre().getText());
        bdRol.setDescripcion(vista.getTxt_descripcion().getText());
        bdRol.setEstado(vista.getCombo_estado().getSelectedItem().toString());
        
        if (bdRol.insertar()){
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
            limpiar();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    
    public void buscar(){
       if(vista.getTxt_buscar().getText().equals("")){
           lista();
       }
       else{
           DefaultTableModel modelo;
           modelo = (DefaultTableModel) vista.getTabla_rol().getModel();
        
            List<rolMD> lista = bdRol.obtenerDatos(Integer.parseInt(vista.getTxt_buscar().getText()));
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_rol().getRowCount()-1; j >= 0; j--){
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTabla_rol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTabla_rol().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTabla_rol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTabla_rol().setValueAt(lista.get(i).getEstado(), i, 3);
            }
       }
    }
    
    public void modificar(){
        
        bdRol.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdRol.setNombre(vista.getTxt_nombre().getText());
        bdRol.setDescripcion(vista.getTxt_descripcion().getText());
        bdRol.setEstado(vista.getCombo_estado().getSelectedItem().toString());
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0){
            if (bdRol.modificar(Integer.parseInt(vista.getTxt_codigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }        
    }
    
    public void seleccionar(){
        vista.getTxt_codigo().setEnabled(true);
        vista.getTxt_nombre().setEnabled(true);
        vista.getTxt_descripcion().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getTxt_buscar().setText("");
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_rol().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTabla_rol().getSelectedRow(), 0);
        
        List<rolMD> lista = bdRol.obtenerDatos(codigo);
        
        bdRol.setCodigo(lista.get(0).getCodigo());
        vista.getTxt_codigo().setText(String.valueOf(bdRol.getCodigo()));
        
        bdRol.setNombre(lista.get(0).getNombre());
        vista.getTxt_nombre().setText(bdRol.getNombre());
        
        bdRol.setDescripcion(lista.get(0).getDescripcion());
        vista.getTxt_descripcion().setText(bdRol.getDescripcion());
        
        bdRol.setEstado(lista.get(0).getEstado());
        vista.getCombo_estado().setSelectedItem(bdRol.getEstado());
    }
    
    public void eliminar(){
        bdRol.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este rol " + vista.getTxt_codigo().getText());
        if (respuesta == 0){
            if (bdRol.eliminar(Integer.parseInt(vista.getTxt_codigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }
}
