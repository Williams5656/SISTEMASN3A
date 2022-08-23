package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.V_Usuario;

public class C_Usuario {

    boolean mostrar = false;
    public static V_Usuario vistausuario;
    public UsuarioBD bdusuario = new UsuarioBD();
    public RolBD bdrol = new RolBD();
    public PersonaBD bdpersona = new PersonaBD();
    String NombreRol = "";

    public C_Usuario(V_Usuario vistaUsuario) {
        this.vistausuario = vistaUsuario;
        vistaUsuario.setVisible(true);
        lista();
        GenerarCodUsuario();
        vistaUsuario.getBtnguardarp().setEnabled(false);
        vistaUsuario.getBtnmodificar().setEnabled(false);
        vistaUsuario.getCmbRol().setModel(bdusuario.NombreROL());
        vistaUsuario.getBtnBuscarPersona().addActionListener(x -> BuscarPersona());
        vistaUsuario.getBtnguardarp().addActionListener(e -> guardar());
        vistaUsuario.getBtnmodificar().addActionListener(e -> modificar());
        vistaUsuario.getBtnnuevo().addActionListener(e -> nuevo());
        vistaUsuario.getBtneliminar().addActionListener(e -> eliminar());
        vistaUsuario.getTxtCedula().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCedulaFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        vistaUsuario.getCheckBoxEstado().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxEstadoActionPerformed(evt);
            }
        });
        vistaUsuario.getTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        List<RolMD> listarol = bdrol.buscardatosporcodigo(bdusuario.getRol());
        for (int i = 0; i < listarol.size(); i++) {
            if (listarol.get(i).getCodigo().equals(bdusuario.getRol())) {
                NombreRol = listarol.get(i).getNombre();
            }
        }
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        List<RolMD> listarol = bdrol.buscardatosporcodigo(bdusuario.getRol());
        for (int i = 0; i < listarol.size(); i++) {
            if (listarol.get(i).getCodigo().equals(bdusuario.getRol())) {
                NombreRol = listarol.get(i).getNombre();
            }
        }
        for (int j = vistausuario.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCodUsuario(), i, 0);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getUsuario(), i, 2);
            vistausuario.getTableUsuario().setValueAt(NombreRol, i, 3);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 4);

        }
    }

    public void guardar() {
        String Codroles = "";
        List<RolMD> listarol = bdrol.buscardatospornombre(vistausuario.getCmbRol().getSelectedItem().toString());
        for (int i = 0; i < listarol.size(); i++) {
            Codroles = listarol.get(i).getCodigo();

        }
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoUsuario().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(Codroles);
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoUsuario().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(vistausuario.getCmbRol().getSelectedItem().toString());
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdusuario.modificar(vistausuario.getLabelCodigoUsuario().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {

        vistausuario.getBtnguardarp().setEnabled(false);
        vistausuario.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(vistausuario.getTableUsuario().getSelectedRow(), 0);
        List<UsuarioMD> lista = bdusuario.obtenerdatos(cedula);
        bdusuario.setCodUsuario(lista.get(0).getCodUsuario());
        vistausuario.getLabelCodigoUsuario().setText(bdusuario.getCodUsuario());
        bdusuario.setCedula(lista.get(0).getCedula());
        vistausuario.getTxtCedula().setText(bdusuario.getCedula());
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vistausuario.getTxtUsuario().setText(bdusuario.getUsuario());
        bdusuario.setClave(lista.get(0).getClave());
        vistausuario.getJPassClave().setText(bdusuario.getClave());
        bdusuario.setRol(lista.get(0).getRol());
        vistausuario.getCmbRol().setSelectedItem(NombreRol);
        bdusuario.setEstado(lista.get(0).getEstado());
        vistausuario.getLabelEstado().setText(bdusuario.getEstado());

    }

    public void eliminar() {
        bdusuario.setCedula(vistausuario.getLabelCodigoUsuario().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdusuario.eliminar(vistausuario.getLabelCodigoUsuario().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtUsuario().setText("");
        vistausuario.getBtnguardarp().setEnabled(true);
        vistausuario.getBtnmodificar().setEnabled(false);
        GenerarCodUsuario();
    }

    private void txtCedulaFocusGained(java.awt.event.FocusEvent evt) {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtCedula().setForeground(Color.BLACK);

    }

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {
        if (vistausuario.getTxtCedula().getText().isEmpty()) {
            vistausuario.getTxtCedula().setText("Ingrese el número de Cédula");
            vistausuario.getTxtCedula().setForeground(Color.GRAY);
        }
    }

    public void BuscarPersona() {
        String PersonaNombres = "";
        String PersonaApellidos = "";
        if (vistausuario.getTxtCedula().equals("")) {
            JOptionPane.showMessageDialog(null, "No deje el campo vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            List<PersonaMD> lista = bdpersona.buscardatos(vistausuario.getTxtCedula().getText());
            for (int i = 0; i < lista.size(); i++) {
                PersonaNombres = lista.get(i).getNombres();
                PersonaApellidos = lista.get(i).getApellidos();
            }
            vistausuario.getLabelNombresPersona().setText(PersonaNombres + " " + PersonaApellidos);
        }
    }

    private void CheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mostrar) {
            vistausuario.getLabelEstado().setText("Activo");
            mostrar = false;

        } else {
            vistausuario.getLabelEstado().setText("Inactivo");
            mostrar = true;
        }
    }

    public void GenerarCodUsuario() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistausuario.getLabelCodigoUsuario().setText("USRO" + buffer.toString());
    }
}
