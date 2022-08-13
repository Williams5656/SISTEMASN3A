package V93Controlador;

import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
 
public class CPersonas {
 
    public static VistaPersona VistaP;

    private PersonaBD bdpersona = new PersonaBD();

    public CPersonas(VistaPersona VistaP) {
        this.VistaP = VistaP;
        VistaP.setVisible(true);
        VistaP.setLocationRelativeTo(null);
        lista();
        VistaP.getBtnGuardarPersona().addActionListener(x -> guardar());
        VistaP.getBtnModificarPersona().addActionListener(e -> modificar());
        // VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getTablePersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        List<PersonaMb> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaP.getTablePersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCedula(), i, 0);
            VistaP.getTablePersona().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaP.getTablePersona().setValueAt(lista.get(i).getDireccion(), i, 2);
            VistaP.getTablePersona().setValueAt(lista.get(i).getFecha_nacimiento(), i, 3);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCiudad(), i, 4);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCelular(), i, 5);

        }
    }

    public void guardar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(VistaP.getTxtFechaNacimientoPersona().getText());
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(VistaP.getTxtFechaNacimientoPersona().getText());
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdpersona.modificar(VistaP.getTxtCedulaPersona().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        String cedula = (String) modelo.getValueAt(VistaP.getTablePersona().getSelectedRow(), 0);
        List<PersonaMb> lista = bdpersona.obtenerdatos(cedula);
        bdpersona.setCedula(lista.get(0).getCedula());
        VistaP.getTxtCedulaPersona().setText(bdpersona.getCedula());
        bdpersona.setNombre(lista.get(0).getNombre());
        VistaP.getTxtNombrePersona().setText(bdpersona.getNombre());
        bdpersona.setDireccion(lista.get(0).getDireccion());
        VistaP.getTxtDireccionPersona().setText(bdpersona.getDireccion());
        bdpersona.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());
        VistaP.getTxtFechaNacimientoPersona().setText(bdpersona.getFecha_nacimiento());
        bdpersona.setCiudad(lista.get(0).getCiudad());
        VistaP.getTxtCiudadPersona().setText(bdpersona.getCiudad());
        bdpersona.setCelular(lista.get(0).getCelular());
        VistaP.getTxtCelularPersona().setText(bdpersona.getCelular());

    }

    public void eliminar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdpersona.eliminar(VistaP.getTxtCedulaPersona().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaP.getTxtCedulaPersona().setText("");
        VistaP.getTxtNombrePersona().setText("");
        VistaP.getTxtDireccionPersona().setText("");
        VistaP.getTxtFechaNacimientoPersona().setText("");
        VistaP.getTxtCiudadPersona().setText("");
        VistaP.getTxtCelularPersona().setText("");
        VistaP.getBtnGuardarPersona().setEnabled(true);
        VistaP.getBtnModificarPersona().setEnabled(false);
    }
}
