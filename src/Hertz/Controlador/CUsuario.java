/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hertz.Controlador;

import Modelo.UsuarioBD;
import Vista.VUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.*;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CUsuario {
    public static VUsuario vista;
    private UsuarioBD bdusuario = new UsuarioBD();

    public CUsuario(VUsuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();
        
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getTablaUsuarios().addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
        
    }//Fin del constructor
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaUsuarios().getModel();
        
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        
//**************** Limpiar en decremento   ************************

        for (int j = vista.getTablaUsuarios().getRowCount()-1; j >= 0; j--){
            modelo.removeRow(j);
        }

//*******************************************************************
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getUsuario(), i, 1);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getPassword(), i, 2);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getRol(), i, 3);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getEstado(), i, 4);
        }
    }//Fin de Lista
    
    public void guardar(){
        
        bdusuario.setCedula(vista.getCbCedula().getSelectedItem().toString());
        bdusuario.setUsuario(vista.getTxtUsuario().getText());
        bdusuario.setPassword(vista.getTxtPassword().getText());
        bdusuario.setRol(vista.getCbRol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCbEstado().getSelectedItem().toString());
        
        if (bdusuario.insertar()){
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }//Fin del Guardar
    
    public void seleccionar(){
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaUsuarios().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablaUsuarios().getSelectedRow(), 0);
        List<UsuarioMD> lista = bdusuario.obtenerDatos(cedula);
        
        bdusuario.setCedula(lista.get(0).getCedula());
        vista.getCbCedula().setSelectedItem(bdusuario.getCedula());
        
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vista.getTxtUsuario().setText(bdusuario.getUsuario());
        
        bdusuario.setPassword(lista.get(0).getPassword());
        vista.getTxtPassword().setText(bdusuario.getPassword());
        
        bdusuario.setRol(lista.get(0).getRol());
        vista.getCbRol().setSelectedItem(bdusuario.getRol());
        
        bdusuario.setEstado(lista.get(0).getEstado());
        vista.getCbEstado().setSelectedItem(bdusuario.getEstado());
        
    }
    
}
