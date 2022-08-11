
package Hertz.Controlador;

import Hertz.Modelo.PersonaBD;
import Hertz.Vista.VPersona;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Hertz.Vista.*;
import Hertz.modelo.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CPersona {
    public static VPersona vista;
    private PersonaBD bdPersona = new PersonaBD();

    public CPersona(VPersona vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();
        
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getTablaPersona().addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }        
        });
        
    }//Fin del constructor
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaPersona().getModel();
        
        List<PersonaMD> lista = bdPersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        
//**************** Limpiar en decremento   ************************

        for (int j = vista.getTablaPersona().getRowCount()-1; j >= 0; j--){
            modelo.removeRow(j);
        }

//*******************************************************************
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaPersona().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTablaPersona().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablaPersona().setValueAt(lista.get(i).getDireccion(), i, 2);
            vista.getTablaPersona().setValueAt(lista.get(i).getCelular(), i, 3);
            vista.getTablaPersona().setValueAt(lista.get(i).getEmail(), i, 4);
            vista.getTablaPersona().setValueAt(lista.get(i).getFechaNac(), i, 5);
        }
    }//Fin de Lista
    
    public void guardar(){
        
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String date = f.format(new Date());
        String fecha;
        
        bdPersona.setCedula(vista.getTxtCedula().getText());
        bdPersona.setNombre(vista.getTxtNombre().getText());
        bdPersona.setDireccion(vista.getTxtDireccion().getText());
        bdPersona.setCelular(vista.getTxtCelular().getText());
        bdPersona.setEmail(vista.getTxtEmail().getText());
        bdPersona.setFechaNac(f.format(vista.getTxtCalendario().getDate()));
        
        if (bdPersona.insertar()){
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }//Fin del Guardar
    
    public void seleccionar(){
        vista.getTxtCedula().setEnabled(true);
        vista.getTxtNombre().setEnabled(true);
        vista.getTxtDireccion().setEnabled(true);
        vista.getTxtCelular().setEnabled(true);
        vista.getTxtEmail().setEnabled(true);
        vista.getTxtCalendario().setEnabled(true);
        
        vista.getBtnGuardar().setEnabled(false);
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaPersona().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablaPersona().getSelectedRow(), 0);
        List<PersonaMD> lista = bdPersona.obtenerDatos(cedula);
        
        bdPersona.setCedula(lista.get(0).getCedula());
        vista.getTxtCedula().setText(bdPersona.getCedula());
        
        bdPersona.setNombre(lista.get(0).getNombre());
        vista.getTxtNombre().setText(bdPersona.getNombre());
        
        bdPersona.setDireccion(lista.get(0).getDireccion());
        vista.getTxtDireccion().setText(bdPersona.getDireccion());
        
        bdPersona.setCelular(lista.get(0).getCelular());
        vista.getTxtCelular().setText(bdPersona.getCelular());
        
        bdPersona.setEmail(lista.get(0).getEmail());
        vista.getTxtEmail().setText(bdPersona.getEmail());
        
        bdPersona.setFechaNac(lista.get(0).getFechaNac());
        vista.getTxtCalendario().setDateFormatString(bdPersona.getFechaNac());
    }
    
}//Fin de la clase

