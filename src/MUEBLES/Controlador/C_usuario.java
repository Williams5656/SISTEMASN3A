package MUEBLES.Controlador;

import MUEBLES.Modelo.M_muebles_usuarioMD;
import MUEBLES.Modelo.Usuario_BD;
import MUEBLES.Vista.Vista_usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class C_usuario {
    
    public static Vista_usuario vistacli;
    private Usuario_BD bdcliente = new Usuario_BD();
    
    public C_usuario(Vista_usuario vistacli){
        this.vistacli = vistacli;
        
        vistacli.setVisible(true);
        vistacli.setLocationRelativeTo(null);
        lista();
        vistacli.getBtnguardar().addActionListener(e -> guardar());
        vistacli.getBtnmodificar().addActionListener(e -> modificar());
        vistacli.getBtneliminar().addActionListener(e -> eliminar());
        vistacli.getTablausuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                seleccionar();
            }
        });
        
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacli.getTablausuario().getModel();
        List<M_muebles_usuarioMD> lista = bdcliente.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistacli.getTablausuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistacli.getTablausuario().setValueAt(lista.get(i).getCedula(), i, 0);
            vistacli.getTablausuario().setValueAt(lista.get(i).getNombre_u(), i, 1);
            vistacli.getTablausuario().setValueAt(lista.get(i).getContraseña(), i, 2);
            vistacli.getTablausuario().setValueAt(lista.get(i).getRol(), i, 3);
            vistacli.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 4);
        }
    }
    
    public void guardar() {
        bdcliente.setCedula(vistacli.getTxtcedula().getText());
        bdcliente.setNombre_u(vistacli.getTxtusuario().getText());
        bdcliente.setContraseña(vistacli.getTxtcontraseña().getText());
        bdcliente.setRol(vistacli.getTxtrol().getText());
        bdcliente.setEstado(vistacli.getTxtestado().getText());
        if (bdcliente.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    
    public void modificar() {
        bdcliente.setNombre_u(vistacli.getTxtusuario().getText());
        bdcliente.setContraseña(vistacli.getTxtcontraseña().getText());
        bdcliente.setRol(vistacli.getTxtrol().getText());
        bdcliente.setEstado(vistacli.getTxtestado().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdcliente.modificar(vistacli.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                limpiar();
            }
        }
    }
    
    public void seleccionar() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacli.getTablausuario().getModel();
        String cedula = (String) modelo.getValueAt(vistacli.getTablausuario().getSelectedRow(), 0);

        List<M_muebles_usuarioMD> lista = bdcliente.obtenerdatos(cedula);

        bdcliente.setCedula(lista.get(0).getCedula());
        vistacli.getTxtcedula().setText(bdcliente.getCedula());
        bdcliente.setNombre_u(lista.get(0).getNombre_u());
        vistacli.getTxtusuario().setText(bdcliente.getNombre_u());
        bdcliente.setContraseña(lista.get(0).getContraseña());
        vistacli.getTxtcontraseña().setText(bdcliente.getContraseña());
        bdcliente.setRol(lista.get(0).getRol());
        vistacli.getTxtrol().setText(bdcliente.getRol());
        bdcliente.setEstado(lista.get(0).getEstado());
        vistacli.getTxtestado().setText(bdcliente.getEstado());

    }
    
    public void eliminar(){
        bdcliente.setCedula(vistacli.getTxtcedula().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO "+vistacli.getTxtcedula().getText());
        if (res == 0) {
            if (bdcliente.eliminar(vistacli.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                limpiar();
            }
        }
    }
    
    public void limpiar(){
        vistacli.getTxtcedula().setText("");
        vistacli.getTxtusuario().setText("");
        vistacli.getTxtcontraseña().setText("");
        vistacli.getTxtrol().setText("");
        vistacli.getTxtestado().setText("");
    }
}
