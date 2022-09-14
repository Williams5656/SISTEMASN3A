
package Hertz.Controlador;

import Hertz.Modelo.UsuarioBD;
import Hertz.Modelo.UsuarioMD;
import Hertz.Vista.VUsuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CUsuario {
    public static VUsuario vista;
    
    private UsuarioBD bdusuario = new UsuarioBD();

    public CUsuario(VUsuario vista) {
        this.vista = vista;
        
        vista.setVisible(true);
        lista();
        
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getCbRol().setModel(bdusuario.rol());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        
        vista.getTxtBuscar().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                buscar();
            }        
        });
        
        vista.getTablaUsuarios().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
        
        vista.getTxtCodigo().setEnabled(false);
        vista.getTxtCedula().setEnabled(false);
        vista.getTxtUsuario().setEnabled(false);
        vista.getTxtPassword().setEnabled(false);
        vista.getCbRol().setEnabled(false);
        vista.getCbEstado().setEnabled(false);
        
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        
    }//Fin del constructor
    
    public void nuevo(){
        limpiar();
        vista.getTxtCodigo().setEnabled(true);
        vista.getTxtCedula().setEnabled(true);
        vista.getTxtUsuario().setEnabled(true);
        vista.getTxtPassword().setEnabled(true);
        vista.getCbRol().setEnabled(true);
        vista.getCbEstado().setEnabled(true);
        
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
    }
    
    public void limpiar(){
        vista.getTxtCodigo().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtUsuario().setText("");
        vista.getTxtPassword().setText("");
        vista.getCbRol().setSelectedIndex(0);
        vista.getCbEstado().setSelectedIndex(0);
    }
    
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
            vista.getTablaUsuarios().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getCedula(), i, 1);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getUsuario(), i, 2);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getPassword(), i, 3);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getRol(), i, 4);
            vista.getTablaUsuarios().setValueAt(lista.get(i).getEstado(), i, 5);
        }
    }//Fin de Lista
    
    public void guardar(){
        
        bdusuario.setCodigo(Integer.parseInt(vista.getTxtCodigo().getText()));
        bdusuario.setCedula(vista.getTxtCedula().getText());
        bdusuario.setUsuario(vista.getTxtUsuario().getText());
        bdusuario.setPassword(vista.getTxtPassword().getText());
        bdusuario.setRol(vista.getCbRol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCbEstado().getSelectedItem().toString());
        
        if (bdusuario.insertar()){
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
           modelo = (DefaultTableModel) vista.getTablaUsuarios().getModel();
        
            List<UsuarioMD> lista = bdusuario.buscarDatos(vista.getTxtBuscar().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vista.getTablaUsuarios().getRowCount()-1; j >= 0; j--){
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getCedula(), i, 1);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getUsuario(), i, 2);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getPassword(), i, 3);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getRol(), i, 4);
                vista.getTablaUsuarios().setValueAt(lista.get(i).getEstado(), i, 5);
            }
       }
    }//Fin de Buscar
    
    public void modificar(){
        
        bdusuario.setCodigo(Integer.parseInt(vista.getTxtCodigo().getText()));
        bdusuario.setCedula(vista.getTxtCedula().getText());
        bdusuario.setUsuario(vista.getTxtUsuario().getText());
        bdusuario.setPassword(vista.getTxtPassword().getText());
        bdusuario.setRol(vista.getCbRol().getSelectedItem().toString());
        bdusuario.setEstado(vista.getCbEstado().getSelectedItem().toString());
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Modificar?");
        if (respuesta == 0){
            if (bdusuario.modificar(Integer.parseInt(vista.getTxtCodigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }        
    }//Fin del modificar
    
    public void seleccionar(){
        vista.getTxtCodigo().setEnabled(true);
        vista.getTxtCedula().setEnabled(true);
        vista.getTxtUsuario().setEnabled(true);
        vista.getTxtPassword().setEnabled(true);
        vista.getCbRol().setEnabled(true);
        vista.getCbEstado().setEnabled(true);
        
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getTxtBuscar().setText("");
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaUsuarios().getModel();
        int codigo = (Integer) modelo.getValueAt(vista.getTablaUsuarios().getSelectedRow(), 0);
        
        List<UsuarioMD> lista = bdusuario.obtenerDatos(codigo);
        
        bdusuario.setCodigo(lista.get(0).getCodigo());
        vista.getTxtCodigo().setText(String.valueOf(bdusuario.getCodigo()));
        
        bdusuario.setCedula(lista.get(0).getCedula());
        vista.getTxtCedula().setText(bdusuario.getCedula());
        
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vista.getTxtUsuario().setText(bdusuario.getUsuario());
        
        bdusuario.setPassword(lista.get(0).getPassword());
        vista.getTxtPassword().setText(bdusuario.getPassword());
        
        bdusuario.setRol(lista.get(0).getRol());
        vista.getCbRol().setSelectedItem(bdusuario.getRol());
        
        bdusuario.setEstado(lista.get(0).getEstado());
        vista.getCbEstado().setSelectedItem(bdusuario.getEstado());
    }//Fin del seleccionar
    
    public void eliminar(){
        bdusuario.setCodigo(Integer.parseInt(vista.getTxtCodigo().getText()));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este usuario " + vista.getTxtCodigo().getText());
        if (respuesta == 0){
            if (bdusuario.eliminar(Integer.parseInt(vista.getTxtCodigo().getText()))){
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                limpiar();
            }
        }
    }//Fin de eliminar
}
