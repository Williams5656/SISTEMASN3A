package controlador;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteBD;
import modelo.ClienteMD;
import modelo.Conectar;
import modelo.PersonaBD;
import modelo.PersonaMD;
import modelo.RegistroBD;
import modelo.RegistroMD;
import vista.V_Registro;

public class C_Registro {

    public static V_Registro vistaregistro;
    RegistroBD bdregistro = new RegistroBD();
    ClienteBD bdcliente = new ClienteBD();
    PersonaBD bdpersona = new PersonaBD();

    public C_Registro(V_Registro vistaresgistro) {
        this.vistaregistro = vistaresgistro;
        vistaresgistro.setVisible(true);
        GenerarCodRegistro();
        listaregistro();
        vistaresgistro.getBtnguardarp().addActionListener(x -> guardar());
        vistaresgistro.getBtnmodificar().addActionListener(x -> modificar());
        vistaresgistro.getBtneliminar().addActionListener(x -> eliminar());
        vistaresgistro.getBtnnuevo().addActionListener(x -> nuevo());
        vistaresgistro.getBtnBuscarCedula().addActionListener(x -> BuscarCliente(vistaregistro.getTxtcliente().getText()));
        vistaresgistro.getTxtBuscarJuicio().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarJuicioFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarJuicioFocusLost(evt);
            }
        });
        vistaresgistro.getTxtBuscarJuicio().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Buscar();
            }
        });
    }

    public void nuevo() {
        GenerarCodRegistro();
        vistaregistro.getTxtcliente().setText("");
        vistaregistro.getBtnguardarp().setEnabled(true);
        vistaregistro.getBtnmodificar().setEnabled(true);

    }

    public void listaregistro() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaregistro.getTablajuicio().getModel();
        List<RegistroMD> lista = bdregistro.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistaregistro.getTablajuicio().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistaregistro.getTablajuicio().setValueAt(lista.get(i).getN_juicio(), i, 0);
            vistaregistro.getTablajuicio().setValueAt(lista.get(i).getCedula_cliente(), i, 1);
            vistaregistro.getTablajuicio().setValueAt(lista.get(i).getTipo_juicio(), i, 2);
            vistaregistro.getTablajuicio().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void guardar() {
        bdregistro.setN_juicio(vistaregistro.getNumjuicio().getText());
        bdregistro.setCedula_cliente(vistaregistro.getTxtcliente().getText());
        bdregistro.setTipo_juicio(vistaregistro.getCbtipojuicio().getSelectedItem().toString());
        bdregistro.setEstado(vistaregistro.getCmbEstadoJuicio().getSelectedItem().toString());

        if (bdregistro.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            listaregistro();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            listaregistro();
        }

    }

    public void modificar() {
        bdregistro.setN_juicio(vistaregistro.getNumjuicio().getText());
        bdregistro.setCedula_cliente(vistaregistro.getTxtcliente().getText());
        bdregistro.setTipo_juicio(vistaregistro.getCbtipojuicio().getSelectedItem().toString());
        bdregistro.setEstado(vistaregistro.getCmbEstadoJuicio().getSelectedItem().toString());

        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR LOS DATOS");
        if (resp == 0) {
            if (bdregistro.modificar(vistaregistro.getNumjuicio().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                listaregistro();
                nuevo();
                vistaregistro.getBtnmodificar().setEnabled(false);
            }
        }
    }

    public void seleccionar() {
        vistaregistro.getBtnguardarp().setEnabled(false);
        vistaregistro.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaregistro.getTablajuicio().getModel();
        String codigo = (String) modelo.getValueAt(vistaregistro.getTablajuicio().getSelectedRow(), 0);
        List<RegistroMD> lista = bdregistro.obtenerdatos(codigo);
        bdregistro.setN_juicio(lista.get(0).getN_juicio());
        vistaregistro.getNumjuicio().setText(bdregistro.getN_juicio());
        bdregistro.setCedula_cliente(lista.get(0).getCedula_cliente());
        vistaregistro.getTxtcliente().setText(bdregistro.getCedula_cliente());
        bdregistro.setTipo_juicio(lista.get(0).getTipo_juicio());
        vistaregistro.getCbtipojuicio().setSelectedItem(bdregistro.getTipo_juicio());
        bdregistro.setEstado(lista.get(0).getEstado());
        vistaregistro.getCmbEstadoJuicio().setSelectedItem(bdregistro.getEstado());

    }

    public void eliminar() {

        bdregistro.setN_juicio(vistaregistro.getNumjuicio().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LOS DATOS" + vistaregistro.getNumjuicio().getText());
        if (resp == 0) {
            if (bdregistro.eliminar(vistaregistro.getNumjuicio().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                listaregistro();
                nuevo();
            }
        }

    }

    public void BuscarCliente(String cedula) {
        try {
            if (vistaregistro.getTxtcliente().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene el campo para realizar la busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                Conectar conectar = new Conectar();
                String sql = "Select nombres,apellidos from persona\n"
                        + "Where cedula=(Select cedula from cliente Where \"cedula\"='" + cedula + "')";
                ResultSet rs = conectar.query(sql);
                while (rs.next()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "No existe esa cedula");
                        vistaregistro.getLabelcliente().setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                    } else {
                    }

                }

            }

        } catch (SQLException e) {
            Logger.getLogger(C_Registro.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void GenerarCodRegistro() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistaregistro.getNumjuicio().setText("JCO" + buffer.toString());
    }

    public void Buscar() {
        if (vistaregistro.getTxtBuscarJuicio().getText().equals("")) {
            listaregistro();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistaregistro.getTablajuicio().getModel();
            java.util.List<RegistroMD> lista = bdregistro.buscardatosporcedula(vistaregistro.getTxtBuscarJuicio().getText());
            int columnas = model.getColumnCount();
            for (int j = vistaregistro.getTablajuicio().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[columnas]);
                vistaregistro.getTablajuicio().setValueAt(lista.get(i).getN_juicio(), i, 0);
                vistaregistro.getTablajuicio().setValueAt(lista.get(i).getCedula_cliente(), i, 1);
                vistaregistro.getTablajuicio().setValueAt(lista.get(i).getTipo_juicio(), i, 2);
                vistaregistro.getTablajuicio().setValueAt(lista.get(i).getEstado(), i, 3);
            }
        }
    }

    private void txtBuscarJuicioFocusGained(java.awt.event.FocusEvent evt) {
        vistaregistro.getTxtBuscarJuicio().setText("");
        vistaregistro.getTxtBuscarJuicio().setForeground(Color.BLACK);
    }

    private void txtBuscarJuicioFocusLost(java.awt.event.FocusEvent evt) {
        if (vistaregistro.getTxtBuscarJuicio().getText().isEmpty()) {
            vistaregistro.getTxtBuscarJuicio().setText("Ingrese el numero de cedula");
            vistaregistro.getTxtBuscarJuicio().setForeground(Color.GRAY);
        }
    }

}
