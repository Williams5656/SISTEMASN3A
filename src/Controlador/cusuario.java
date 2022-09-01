/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.usuarioBD;
import Modelo.usuarioMD;
import Vista.vusuario;
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
public class cusuario {
     public static vusuario vista;
    
    private usuarioBD bdusuario = new usuarioBD();

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
        
        vista.getTxt_codigo().setEnabled(false);
        vista.getTxt_cedula().setEnabled(false);
        vista.getTxt_usuario().setEnabled(false);
        vista.getTxt_contraseña().setEnabled(false);
        vista.getCombo_rol().setEnabled(false);
        vista.getCombo_estado().setEnabled(false);
        
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        
    }
    
    public void nuevo(){
        limpiar();
        vista.getTxt_codigo().setEnabled(true);
        vista.getTxt_cedula().setEnabled(true);
        vista.getTxt_usuario().setEnabled(true);
        vista.getTxt_contraseña().setEnabled(true);
        vista.getCombo_rol().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);
        
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
    }
    
    public void limpiar(){
        vista.getTxt_codigo().setText("");
        vista.getTxt_cedula().setText("");
        vista.getTxt_usuario().setText("");
        vista.getTxt_contraseña().setText("");
        vista.getCombo_rol().setSelectedIndex(0);
        vista.getCombo_estado().setSelectedIndex(0);
    }
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_usuarios().getModel();
        
        List<usuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        


        for (int j = vista.getTabla_usuarios().getRowCount()-1; j >= 0; j--){
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
    
    public void guardar(){
        
        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdusuario.setCedula(vista.getTxt_cedula().getText());
        bdusuario.setUsuario(vista.getTxt_usuario().getText());
        bdusuario.setPassword(vista.getTxt_contraseña().getText());
        bdusuario.setRol(vista.getCombo_rol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCombo_estado().getSelectedItem().toString());
        
        if (bdusuario.insertar()){
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
           modelo = (DefaultTableModel) vista.getTabla_usuarios().getModel();
        
            List<usuarioMD> lista = bdusuario.obtenerDatos(Integer.parseInt(vista.getTxt_buscar().getText()));
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTabla_usuarios().getRowCount()-1; j >= 0; j--){
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
    
    public void modificar(){
        
        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        bdusuario.setCedula(vista.getTxt_cedula().getText());
        bdusuario.setUsuario(vista.getTxt_usuario().getText());
        bdusuario.setPassword(vista.getTxt_contraseña().getText());
        bdusuario.setRol(vista.getCombo_rol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCombo_estado().getSelectedItem().toString());
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0){
            if (bdusuario.modificar(Integer.parseInt(vista.getTxt_codigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }        
    }
    
    public void seleccionar(){
        vista.getTxt_codigo().setEnabled(true);
        vista.getTxt_cedula().setEnabled(true);
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
        vista.getTxt_cedula().setText(bdusuario.getCedula());
        
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vista.getTxt_usuario().setText(bdusuario.getUsuario());
        
        bdusuario.setPassword(lista.get(0).getPassword());
        vista.getTxt_contraseña().setText(bdusuario.getPassword());
        
        bdusuario.setRol(lista.get(0).getRol());
        vista.getCombo_rol().setSelectedItem(bdusuario.getRol());
        
        bdusuario.setEstado(lista.get(0).getEstado());
        vista.getCombo_estado().setSelectedItem(bdusuario.getEstado());
    }//Fin del seleccionar
    
    public void eliminar(){
        bdusuario.setCodigo(Integer.parseInt(vista.getTxt_codigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este rol " + vista.getTxt_codigo().getText());
        if (respuesta == 0){
            if (bdusuario.eliminar(Integer.parseInt(vista.getTxt_codigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }
    
}
