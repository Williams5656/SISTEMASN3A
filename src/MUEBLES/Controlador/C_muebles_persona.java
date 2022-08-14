package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesprincipal.vistaprin;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.*;
import MUEBLES.Modelo.*;

public class C_muebles_persona {
    
    public static Vista_persona_muebles vistaper;
    private Persona_BD_muebles bdpersona = new Persona_BD_muebles();
    
    public C_muebles_persona(Vista_persona_muebles vistaper){
        this.vistaper = vistaper;
        vistaper.setVisible(true);
        vistaper.setLocationRelativeTo(null);
        
        lista();
        vistaper.getBtnnuevo().addActionListener(e -> busquedaper());
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaper.getTabla_muebles_persona().getModel();
        List<M_muebles_persona> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistaper.getTabla_muebles_persona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getCedula(), i, 0);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getNombre(), i, 1);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getApellido(), i, 2);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getDireccion(), i, 3);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getCelular(), i, 4);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getNacionalidad(), i, 5);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getFechana(), i, 6);
        }
    }
    
    public void eliminar(){
        bdpersona.setCedula(vistaper.getTxtbusqueda().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO "+vistaper.getTxtbusqueda().getText());
        if (res == 0) {
            if (bdpersona.eliminar(vistaper.getTxtbusqueda().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
            }
        }
    }
    
    public void busquedaper(){
        Vista_busqueda_persona visbus =  new Vista_busqueda_persona();
        C_busqueda_persona bp = new C_busqueda_persona(visbus);
    }

}
