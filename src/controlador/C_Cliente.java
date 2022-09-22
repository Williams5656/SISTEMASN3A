package controlador;

import static controlador.C_Persona.vistapersona;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteBD;
import modelo.ClienteMD;
import modelo.PersonaBD;
import modelo.PersonaMD;
import vista.V_GesClient;

public class C_Cliente extends ClienteBD {

    public static V_GesClient vistacliente;
    private final ClienteBD bdcliente = new ClienteBD();
    private final PersonaBD bdpersona = new PersonaBD();

    public C_Cliente(V_GesClient vistacl) {
        C_Cliente.vistacliente = vistacl;
        vistacl.setVisible(true);
        lista();
        GenerarCodCliente();
        vistacl.getLabelTINombres().setVisible(false);
        vistacl.getLabelNombres().setVisible(false);
        vistacl.getLabelTelefono().setVisible(false);
        vistacl.getLabelTiTelefono().setVisible(false);
        vistacl.getBtnguardarp().setEnabled(false);
        vistacl.getBtnmodificar().setEnabled(false);
        vistacl.getBtnguardarp().addActionListener(x -> guardar());
        vistacl.getBtnmodificar().addActionListener(x -> modificar());
        vistacl.getBtneliminar().addActionListener(x -> eliminar());
        vistacl.getBtnnuevo().addActionListener(x -> nuevo());
        vistacl.getBtnBuscarCedula().addActionListener(x -> BuscarPersona());
        vistacl.getTxtBuscarCliente().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarCliente();
            }
        });
        vistacl.getTxtBuscarCedula().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtBuscarCedulaFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtBuscarCedulaFocusLost(evt);
            }
        });
        vistacl.getTableCliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTableCliente().getModel();
        List<ClienteMD> lista = bdcliente.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistacliente.getTableCliente().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getCedula(), i, 1);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getEstado(), i, 2);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getTrabajo(), i, 3);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getProfesion(), i, 4);

        }
    }

    public void guardar() {
        bdcliente.setCodigo(vistacliente.getLabelCodigo().getText());
        bdcliente.setCedula(vistacliente.getTxtBuscarCedula().getText());
        bdcliente.setEstado(vistacliente.getCmbEstadoCliente().getSelectedItem().toString());
        bdcliente.setTrabajo(vistacliente.getCmbTrabajo().getSelectedItem().toString());
        bdcliente.setProfesion(vistacliente.getTxtProfesion().getText());

        if (bdcliente.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdcliente.setCodigo(vistacliente.getLabelCodigo().getText());
        bdcliente.setCedula(vistacliente.getLabelCedula().getText());
        bdcliente.setEstado(vistacliente.getCmbEstadoCliente().getSelectedItem().toString());
        bdcliente.setTrabajo(vistacliente.getCmbTrabajo().getSelectedItem().toString());
        bdcliente.setProfesion(vistacliente.getTxtProfesion().getText());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdcliente.modificar(vistacliente.getLabelCodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistacliente.getBtnguardarp().setEnabled(false);
        vistacliente.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTableCliente().getModel();
        String cedula = (String) modelo.getValueAt(vistacliente.getTableCliente().getSelectedRow(), 0);
        List<ClienteMD> lista = bdcliente.obtenerdatos(cedula);
        bdcliente.setCodigo(lista.get(0).getCodigo());
        vistacliente.getLabelCodigo().setText(bdcliente.getCodigo());
        bdcliente.setCedula(lista.get(0).getCedula());
        vistacliente.getTxtBuscarCedula().setText(bdcliente.getCedula());
        bdcliente.setEstado(lista.get(0).getEstado());
        vistacliente.getCmbEstadoCliente().setSelectedItem(bdcliente.getEstado());
        bdcliente.setTrabajo(lista.get(0).getTrabajo());
        vistacliente.getCmbTrabajo().setSelectedItem(bdcliente.getTrabajo());
        bdcliente.setProfesion(lista.get(0).getProfesion());
        vistacliente.getTxtProfesion().setText(bdcliente.getProfesion());
        vistacliente.getTxtBuscarCedula().setEditable(false);
    }

    public void GenerarCodCliente() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistacliente.getLabelCodigo().setText("CLNT" + buffer.toString());
    }

    public void eliminar() {
        bdcliente.setCodigo(vistacliente.getLabelCodigo().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdcliente.eliminar(vistacliente.getLabelCodigo().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistacliente.getLabelNombres().setText("");
        vistacliente.getLabelTelefono().setText("");
        vistacliente.getLabelTINombres().setVisible(false);
        vistacliente.getLabelNombres().setVisible(false);
        vistacliente.getLabelTelefono().setVisible(false);
        vistacliente.getLabelTiTelefono().setVisible(false);
        vistacliente.getBtnguardarp().setEnabled(true);
        vistacliente.getBtnmodificar().setEnabled(true);
        GenerarCodCliente();
    }

    private void TxtBuscarCedulaFocusGained(java.awt.event.FocusEvent evt) {
        vistacliente.getTxtBuscarCedula().setText("");
        vistacliente.getTxtBuscarCedula().setForeground(Color.BLACK);

    }

    private void TxtBuscarCedulaFocusLost(java.awt.event.FocusEvent evt) {
        if (vistacliente.getTxtBuscarCedula().getText().isEmpty()) {
            vistacliente.getTxtBuscarCedula().setText("Ingrese el número de Cédula");
            vistacliente.getTxtBuscarCedula().setForeground(Color.GRAY);
        }
    }

    public void BuscarPersona() {
        if (vistacliente.getTxtBuscarCedula().equals("")) {
            JOptionPane.showMessageDialog(null, "Nó deje el campo vacio");
        } else {
            vistacliente.getLabelTINombres().setVisible(true);
            vistacliente.getLabelNombres().setVisible(true);
            vistacliente.getLabelTelefono().setVisible(true);
            vistacliente.getLabelTiTelefono().setVisible(true);
            List<PersonaMD> listapersona = bdpersona.buscardatos(vistacliente.getTxtBuscarCedula().getText());
            for (int i = 0; i < listapersona.size(); i++) {
                vistacliente.getLabelNombres().setText(listapersona.get(i).getNombres() + " " + listapersona.get(i).getApellidos());
                vistacliente.getLabelTelefono().setText(listapersona.get(i).getTelefono());
            }
        }
    }

    public void BuscarCliente() {
        if (vistacliente.getTxtBuscarCliente().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vistacliente.getTableCliente().getModel();

            List<ClienteMD> lista = bdcliente.buscardatos(vistacliente.getTxtBuscarCliente().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vistacliente.getTableCliente().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);

                vistacliente.getTableCliente().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistacliente.getTableCliente().setValueAt(lista.get(i).getCedula(), i, 1);
                vistacliente.getTableCliente().setValueAt(lista.get(i).getEstado(), i, 2);
                vistacliente.getTableCliente().setValueAt(lista.get(i).getTrabajo(), i, 3);
                vistacliente.getTableCliente().setValueAt(lista.get(i).getProfesion(), i, 4);
            }
        }
    }
}
