package V93Controlador;

import V93Modelo.ClienteBD;
import V93Modelo.ClienteMb;
import V93Modelo.PersonaBD;
import V93Modelo.PersonaMb;
import V93Vista.VistaCliente;
import V93Vista.VistaPersona;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CCliente {

    public static VistaCliente VistaC;

    private ClienteBD bdcliente = new ClienteBD();

    public CCliente(VistaCliente VistaC) {
        this.VistaC = VistaC;
        VistaC.setVisible(true);
        VistaC.setLocationRelativeTo(null);
        lista();
        VistaC.getBtnGuardarCliente().addActionListener(x -> guardar());
        VistaC.getBtnModificarCliente().addActionListener(e -> modificar());
        VistaC.getBtnBuscarCliente().addActionListener(e -> buscar());
        // VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaC.getTableClientes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        VistaC.getBtnNuevoCliente().addActionListener(e -> nuevo());
        VistaC.getBtnEliminarCliente().addActionListener(e -> eliminar());
        VistaC.getBtnGuardarCliente().setEnabled(false);
        VistaC.getBtnModificarCliente().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaC.getTableClientes().getModel();
        List<ClienteMb> lista = bdcliente.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaC.getTableClientes().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaC.getTableClientes().setValueAt(lista.get(i).getCedula(), i, 0);
            VistaC.getTableClientes().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaC.getTableClientes().setValueAt(lista.get(i).getCiudad(), i, 2);
            VistaC.getTableClientes().setValueAt(lista.get(i).getDireccion(), i, 3);
            VistaC.getTableClientes().setValueAt(lista.get(i).getTelefono(), i, 4);
            VistaC.getTableClientes().setValueAt(lista.get(i).getCorreo(), i, 5);

        }
    }

    public void guardar() {
        bdcliente.setCedula(VistaC.getTxtCedulaCliente().getText());
        bdcliente.setNombre(VistaC.getTxtNombreCliente().getText());
        bdcliente.setCiudad(VistaC.getTxtCiudadCliente().getText());
        bdcliente.setDireccion(VistaC.getTxtDireccionCliente().getText());
        bdcliente.setTelefono(VistaC.getTxtTelefonoCliente().getText());
        bdcliente.setCorreo(VistaC.getTxtCorreoElectronicoCliente().getText());

        if (bdcliente.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void buscar() {
        if (VistaC.getTxtBuscarCliente().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaC.getTableClientes().getModel();
            List<ClienteMb> lista = bdcliente.obtenerdatos(VistaC.getTxtBuscarCliente().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaC.getTableClientes().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaC.getTableClientes().setValueAt(lista.get(i).getCedula(), i, 0);
                VistaC.getTableClientes().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaC.getTableClientes().setValueAt(lista.get(i).getCiudad(), i, 2);
                VistaC.getTableClientes().setValueAt(lista.get(i).getDireccion(), i, 3);
                VistaC.getTableClientes().setValueAt(lista.get(i).getTelefono(), i, 4);
                VistaC.getTableClientes().setValueAt(lista.get(i).getCorreo(), i, 5);
            }
        }

    }

    public void modificar() {
        bdcliente.setCedula(VistaC.getTxtCedulaCliente().getText());
        bdcliente.setNombre(VistaC.getTxtNombreCliente().getText());
        bdcliente.setCiudad(VistaC.getTxtCiudadCliente().getText());
        bdcliente.setDireccion(VistaC.getTxtDireccionCliente().getText());
        bdcliente.setTelefono(VistaC.getTxtTelefonoCliente().getText());
        bdcliente.setCorreo(VistaC.getTxtCorreoElectronicoCliente().getText());
        
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdcliente.modificar(VistaC.getTxtCedulaCliente().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaC.getBtnGuardarCliente().setEnabled(false);
        VistaC.getBtnModificarCliente().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaC.getTableClientes().getModel();
        String cedula = (String) modelo.getValueAt(VistaC.getTableClientes().getSelectedRow(), 0);
        List<ClienteMb> lista = bdcliente.obtenerdatos(cedula);
        bdcliente.setCedula(lista.get(0).getCedula());
        VistaC.getTxtCedulaCliente().setText(bdcliente.getCedula());
        bdcliente.setNombre(lista.get(0).getNombre());
        VistaC.getTxtNombreCliente().setText(bdcliente.getNombre());
        bdcliente.setCiudad(lista.get(0).getCiudad());
        VistaC.getTxtCiudadCliente().setText(bdcliente.getCiudad());
        bdcliente.setDireccion(lista.get(0).getDireccion());
        VistaC.getTxtDireccionCliente().setText(bdcliente.getDireccion());
        bdcliente.setTelefono(lista.get(0).getTelefono());
        VistaC.getTxtTelefonoCliente().setText(bdcliente.getTelefono());
        bdcliente.setCorreo(lista.get(0).getCorreo());
        VistaC.getTxtCorreoElectronicoCliente().setText(bdcliente.getCorreo());
       
    }

    public void eliminar() {
        bdcliente.setCedula(VistaC.getTxtCedulaCliente().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdcliente.eliminar(VistaC.getTxtCedulaCliente().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaC.getTxtCedulaCliente().setText("");
        VistaC.getTxtNombreCliente().setText("");
        VistaC.getTxtCiudadCliente().setText("");
        VistaC.getTxtDireccionCliente().setText("");
        VistaC.getTxtTelefonoCliente().setText("");
        VistaC.getTxtCorreoElectronicoCliente().setText("");
        VistaC.getTxtBuscarCliente().setText("");
        VistaC.getBtnGuardarCliente().setEnabled(true);
        VistaC.getBtnModificarCliente().setEnabled(false);
    }
}


